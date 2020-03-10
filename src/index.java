
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jayson
 */
public class index extends javax.swing.JFrame {

    /**
     * Creates new form index
     */
    
     Connection conn;
    PreparedStatement st;
    ResultSet rs;
    private static final String uname="root";
    private static final String pass="";
    private static final String con="jdbc:mysql://localhost:3306/barangay_management_system";
  
    public index() {
        initComponents();
         LocalDate nowDate = LocalDate.now();
         jLabel174.setText(""+nowDate);
         jLabel188.setText(""+nowDate);
        jRadioButton3.setSelected(true);
        jLabel188.setText(""+nowDate);
        
        
          int x = 270;
          
        if(x == 270){
            kGradientPanel2.setSize(270,890);
            Thread th = new Thread(){
               @Override
               public void run(){
                   try{
                       for(int i=270;i>=0;i--){
                           Thread.sleep((long) .05);
                           kGradientPanel2.setSize(i,890);
                       }
                       
                   }catch(Exception e){
                       JOptionPane.showMessageDialog(null, e);
                   }
               }
                
            };th.start();
            x=0;
        }
        
        
        new Thread(){
            
            public void run(){
                while(true){
                    Calendar cal = new GregorianCalendar();
                    int hour = cal.get(Calendar.HOUR);
                    int min = cal.get(Calendar.MINUTE);
                    int sec = cal.get(Calendar.SECOND);
                    int AM_PM = cal.get(Calendar.AM_PM);
                    String day_night="";
                    
                    if(AM_PM==1){
                        day_night="PM";
                        
                    }else{
                        day_night="AM";
                    }
                    
                    String time = hour+":"+min+":"+sec+" "+day_night;
                    
                     jLabel11.setText(time);
                      
                     
                }
            }
            
        }.start();
        
        
        
     jTable1.setShowVerticalLines(false); 
     jTable1.setRowHeight(75); 
     jTable1.setSelectionBackground(Color.blue); 
     jTable2.setShowVerticalLines(false); 
     jTable2.setRowHeight(75); 
     jTable2.setSelectionBackground(Color.blue); 
     jTable3.setShowVerticalLines(false); 
     jTable3.setRowHeight(75); 
     jTable3.setSelectionBackground(Color.blue); 
     
            try{
            conn = DriverManager.getConnection(con,uname,pass);
           // JOptionPane.showMessageDialog(null,"CONNECTED");
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"sssssssssss"+e);
        }
        
         
        fetch_dis();
     
    }
    
    
    public void org(String position,String label){
      String arr[]=new String[10];
              try{
     String firstname="",lastname="";
     int x=0;
     String query = "SELECT * FROM official"; 
        st = conn.prepareStatement(query);
        rs=st.executeQuery(query);
                while(rs.next()){
                        firstname= rs.getString("name");
                        lastname= rs.getString("lastname");
                         arr[x] = firstname+" "+lastname;
                        x= x+1;
                }
                jLabel157.setText(""+arr[0]);
                jLabel158.setText(""+arr[1]);
                jLabel159.setText(""+arr[2]);
                jLabel160.setText(""+arr[3]);
                jLabel161.setText(""+arr[4]);
                jLabel162.setText(""+arr[5]);
                jLabel163.setText(""+arr[6]);
                jLabel164.setText(""+arr[7]);
              }catch(Exception e){
                  JOptionPane.showMessageDialog(null,e);
               }
    }
    
    
    
    
    
    
   public void clear(){
        jTextField27.setText("");
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
     
        jTextField15.setText("");
        jTextField16.setText("");
        jTextField17.setText("");
        jTextField18.setText("");
        jTextField19.setText("");
        jTextField20.setText("");
        jTextField21.setText("");
        jTextField22.setText("");
        jTextField23.setText("");
        jTextField24.setText("");
        jTextField25.setText("");
        jTextField26.setText("");
        jLabel24.setText("age");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jComboBox3.setSelectedIndex(0);
        jComboBox4.setSelectedIndex(0);
        jComboBox5.setSelectedIndex(0);
        jComboBox6.setSelectedIndex(0);
        jComboBox7.setSelectedIndex(0);
        jComboBox8.setSelectedIndex(0);
        jComboBox9.setSelectedIndex(0);
        jComboBox10.setSelectedIndex(0);
        jComboBox11.setSelectedIndex(0);
       buttonGroup1.clearSelection();
       
       jLabel128.setText("");
       jLabel129.setText("");
       jLabel130.setText("");
       jLabel131.setText("");
       jLabel132.setText("");
       jLabel133.setText("");
       jLabel134.setText("");
       jLabel135.setText("");
       jLabel136.setText("");
       jLabel137.setText("");
       jLabel138.setText("");
       jLabel139.setText("");
       
       jLabel71.setText("");
       jLabel72.setText("");
       jLabel73.setText("");
       jLabel74.setText("");
       jLabel75.setText("");
       jLabel76.setText("");
       jLabel77.setText("");
       jLabel78.setText("");
       jLabel79.setText("");
       jLabel80.setText("");
       jLabel81.setText("");
       jLabel95.setText("");
       
   }
    

    
        public void fetch_log(){
     
        
        try{
        String query = "Select * from log";
        st = conn.prepareStatement(query);
        rs=st.executeQuery();
        jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
        }
    }
       
       
      public void fetch_dis(){
     
        //  String a="1";
          // String b="del";
        
        try{
        String query = "SELECT id_resident, lastname, firstname, middlename, ext_name, gender,  date_of_birth, age, contact_number, registered_voter,complete_pernament, mother, father, date_created,date_updated FROM resident_information_tbl WHERE del=0 ORDER BY id_resident";
        st = conn.prepareStatement(query);
        rs=st.executeQuery();
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
        }
    }
        
      
            public void fetch_clearance(){
        try{
        String query = "SELECT id_resident, lastname, firstname, middlename, ext_name, date_of_birth, age, contact_number,house,lot,block,street,subdivision FROM resident_information_tbl WHERE del=0 ORDER BY id_resident";
        st = conn.prepareStatement(query);
        rs=st.executeQuery();
        jTable5.setModel(DbUtils.resultSetToTableModel(rs));
        
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
        }
    }
      
      
    public void searching(String search){
     
        String filter = (String) jComboBox12.getSelectedItem();
        String filter1 = filter.toLowerCase();
        try{
        String query = "Select id_resident, lastname, firstname, middlename, ext_name, gender,  date_of_birth, age, contact_number, registered_voter,complete_pernament, mother, father, date_created,date_updated from resident_information_tbl WHERE "+filter1+"='"+search+"' AND del=0";
       // JOptionPane.showMessageDialog(null, filter1);
        st = conn.prepareStatement(query);
        rs=st.executeQuery();
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
        }
    }
    
        public void searching_docu(String search){
     
        String filter = (String) jComboBox14.getSelectedItem();
        String filter1 = filter.toLowerCase();
        try{
      String query = "SELECT id_resident, lastname, firstname, middlename, ext_name, date_of_birth, age, contact_number,house,lot,block,street,subdivision FROM resident_information_tbl WHERE "+filter1+"='"+search+"' AND del=0 ORDER BY id_resident";
       // JOptionPane.showMessageDialog(null, filter1);
        st = conn.prepareStatement(query);
        rs=st.executeQuery();
        jTable5.setModel(DbUtils.resultSetToTableModel(rs));
        
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public void connection(String sql,String label){
        
                  try{
            conn = DriverManager.getConnection(con,uname,pass);
          // JOptionPane.showMessageDialog(null,"CONNECTED");    
          Statement state = conn.createStatement();
          state.executeUpdate(sql);
          JOptionPane.showMessageDialog(null,""+label);
          fetch_dis();
         // conn.close();
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
        }
    }
    
        public void connection2(String sql){
        
                  try{
            conn = DriverManager.getConnection(con,uname,pass);
          //JOptionPane.showMessageDialog(null,"CONNECTED");    
          Statement state = conn.createStatement();
          state.executeUpdate(sql);
          fetch_log();
        //  conn.close();
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"con2222222222"+e);
        }
                  
  
    }

    public void connection3(String sql){
        
                  try{
            conn = DriverManager.getConnection(con,uname,pass);
          // JOptionPane.showMessageDialog(null,"CONNECTED");    
          Statement state = conn.createStatement();
          state.executeUpdate(sql);
          archive();
          fetch_log();
        //  conn.close();
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
        }
                  
  
    }    
        
        public void archive(){
         try{
        String query = "SELECT id_resident, lastname, firstname, middlename, ext_name, gender,  date_of_birth, age, contact_number, registered_voter,complete_pernament, mother, father, date_created,date_deleted FROM resident_information_tbl WHERE del=1 ORDER BY id_resident ";
        st = conn.prepareStatement(query);
        rs=st.executeQuery();
        jTable3.setModel(DbUtils.resultSetToTableModel(rs));
        
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
        }
        }
        
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTextField18 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        kGradientPanel2 = new keeptoo.KGradientPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel223 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel56 = new javax.swing.JLabel();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jComboBox12 = new javax.swing.JComboBox<>();
        jTextField28 = new javax.swing.JTextField();
        jLabel224 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        kGradientPanel5 = new keeptoo.KGradientPanel();
        jPanel10 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jTextField21 = new javax.swing.JTextField();
        jTextField22 = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jTextField24 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jComboBox10 = new javax.swing.JComboBox<>();
        jComboBox11 = new javax.swing.JComboBox<>();
        jLabel103 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jTextField58 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jLabel92 = new javax.swing.JLabel();
        jLabel104 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        kGradientPanel11 = new keeptoo.KGradientPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField29 = new javax.swing.JTextField();
        jComboBox13 = new javax.swing.JComboBox<>();
        kGradientPanel7 = new keeptoo.KGradientPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel213 = new javax.swing.JLabel();
        jLabel214 = new javax.swing.JLabel();
        jLabel215 = new javax.swing.JLabel();
        jLabel216 = new javax.swing.JLabel();
        jLabel217 = new javax.swing.JLabel();
        jLabel218 = new javax.swing.JLabel();
        jLabel219 = new javax.swing.JLabel();
        jLabel220 = new javax.swing.JLabel();
        jTextField55 = new javax.swing.JTextField();
        jTextField56 = new javax.swing.JTextField();
        jTextField57 = new javax.swing.JTextField();
        jTextField59 = new javax.swing.JTextField();
        jTextField60 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        kGradientPanel23 = new keeptoo.KGradientPanel();
        jLabel221 = new javax.swing.JLabel();
        kGradientPanel24 = new keeptoo.KGradientPanel();
        jLabel222 = new javax.swing.JLabel();
        kGradientPanel8 = new keeptoo.KGradientPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel123 = new javax.swing.JLabel();
        jLabel124 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jLabel129 = new javax.swing.JLabel();
        jLabel130 = new javax.swing.JLabel();
        jLabel131 = new javax.swing.JLabel();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jLabel134 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        kGradientPanel10 = new keeptoo.KGradientPanel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        jLabel151 = new javax.swing.JLabel();
        jLabel152 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        jLabel154 = new javax.swing.JLabel();
        jLabel155 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel157 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jLabel159 = new javax.swing.JLabel();
        jLabel160 = new javax.swing.JLabel();
        jLabel161 = new javax.swing.JLabel();
        jLabel162 = new javax.swing.JLabel();
        jLabel163 = new javax.swing.JLabel();
        jLabel164 = new javax.swing.JLabel();
        kGradientPanel9 = new keeptoo.KGradientPanel();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        kGradientPanel16 = new keeptoo.KGradientPanel();
        jLabel166 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        kGradientPanel12 = new keeptoo.KGradientPanel();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jLabel169 = new javax.swing.JLabel();
        jLabel170 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel165 = new javax.swing.JLabel();
        jLabel171 = new javax.swing.JLabel();
        jLabel172 = new javax.swing.JLabel();
        jLabel174 = new javax.swing.JLabel();
        kGradientPanel13 = new keeptoo.KGradientPanel();
        jTextField38 = new javax.swing.JTextField();
        jTextField39 = new javax.swing.JTextField();
        jTextField40 = new javax.swing.JTextField();
        jTextField41 = new javax.swing.JTextField();
        jLabel183 = new javax.swing.JLabel();
        jLabel184 = new javax.swing.JLabel();
        jLabel185 = new javax.swing.JLabel();
        jLabel186 = new javax.swing.JLabel();
        jLabel187 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel188 = new javax.swing.JLabel();
        jLabel193 = new javax.swing.JLabel();
        jLabel194 = new javax.swing.JLabel();
        jLabel195 = new javax.swing.JLabel();
        jLabel196 = new javax.swing.JLabel();
        kGradientPanel14 = new keeptoo.KGradientPanel();
        jTextField42 = new javax.swing.JTextField();
        jLabel189 = new javax.swing.JLabel();
        jTextField43 = new javax.swing.JTextField();
        jLabel190 = new javax.swing.JLabel();
        jLabel191 = new javax.swing.JLabel();
        jLabel192 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jLabel197 = new javax.swing.JLabel();
        jLabel198 = new javax.swing.JLabel();
        kGradientPanel15 = new keeptoo.KGradientPanel();
        jLabel199 = new javax.swing.JLabel();
        jLabel200 = new javax.swing.JLabel();
        jLabel201 = new javax.swing.JLabel();
        jLabel202 = new javax.swing.JLabel();
        jLabel203 = new javax.swing.JLabel();
        jLabel204 = new javax.swing.JLabel();
        jLabel205 = new javax.swing.JLabel();
        jLabel206 = new javax.swing.JLabel();
        jLabel207 = new javax.swing.JLabel();
        jLabel208 = new javax.swing.JLabel();
        jLabel209 = new javax.swing.JLabel();
        jLabel210 = new javax.swing.JLabel();
        jLabel211 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jTextField44 = new javax.swing.JTextField();
        jTextField45 = new javax.swing.JTextField();
        jTextField46 = new javax.swing.JTextField();
        jTextField47 = new javax.swing.JTextField();
        jTextField48 = new javax.swing.JTextField();
        jTextField49 = new javax.swing.JTextField();
        jTextField50 = new javax.swing.JTextField();
        jTextField51 = new javax.swing.JTextField();
        jTextField52 = new javax.swing.JTextField();
        jTextField53 = new javax.swing.JTextField();
        jTextField54 = new javax.swing.JTextField();
        jLabel212 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jTextField34 = new javax.swing.JTextField();
        jLabel225 = new javax.swing.JLabel();
        jComboBox14 = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();

        jTextField18.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField18.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField18KeyPressed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });
        jPanel1.setLayout(null);

        kGradientPanel2.setBackground(new java.awt.Color(255, 255, 255));
        kGradientPanel2.setForeground(new java.awt.Color(0, 102, 51));
        kGradientPanel2.setkEndColor(new java.awt.Color(0, 51, 51));
        kGradientPanel2.setkStartColor(new java.awt.Color(0, 51, 51));
        kGradientPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 4));
        jPanel2.setFocusable(false);
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/2_Hot_Home_Icon_48.png"))); // NOI18N
        jLabel1.setText(" HOME");
        jLabel1.setToolTipText("");
        jLabel1.setAlignmentX(0.5F);
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 8, 135, 50));

        kGradientPanel2.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 277, -1));

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 4));
        jPanel3.setPreferredSize(new java.awt.Dimension(196, 66));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel3MouseExited(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Files_Folder_Icon_48.png"))); // NOI18N
        jLabel2.setText(" RESIDENT INFORMATION");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        kGradientPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 333, 289, 61));

        jPanel4.setBackground(new java.awt.Color(0, 51, 51));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 4));
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(196, 66));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 51, 51));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Usergroup_Icon_48.png"))); // NOI18N
        jLabel3.setText(" ADD/EDIT RESIDENT");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 4, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );

        kGradientPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 401, 277, 60));

        jPanel5.setBackground(new java.awt.Color(0, 51, 51));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 4));
        jPanel5.setPreferredSize(new java.awt.Dimension(196, 66));
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel5MouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Folder_customer_Icon_48.png"))); // NOI18N
        jLabel4.setText(" ARCHIVE RESIDENT");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        kGradientPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 474, 277, 59));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/menu (1).png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        kGradientPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 60));

        jPanel6.setBackground(new java.awt.Color(0, 51, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 4));
        jPanel6.setMinimumSize(new java.awt.Dimension(181, 79));
        jPanel6.setPreferredSize(new java.awt.Dimension(196, 66));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel6MouseExited(evt);
            }
        });
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/User_Files_Icon_48.png"))); // NOI18N
        jLabel8.setText(" DOCUMENT");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 5, 150, 40));

        kGradientPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 546, 289, 60));

        jPanel7.setBackground(new java.awt.Color(0, 51, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 4));
        jPanel7.setPreferredSize(new java.awt.Dimension(196, 66));
        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel7MouseExited(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/User_Group_Icon_48.png"))); // NOI18N
        jLabel9.setText(" ORGANIZATION");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(39, 39, 39))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
        );

        kGradientPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 624, 277, 61));

        jPanel8.setBackground(new java.awt.Color(0, 51, 51));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 4));
        jPanel8.setPreferredSize(new java.awt.Dimension(196, 66));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel8MouseExited(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Log_Out_Icon_48.png"))); // NOI18N
        jLabel10.setText(" LOGS");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
        );

        kGradientPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 698, 277, 65));

        jPanel9.setBackground(new java.awt.Color(0, 51, 51));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51), 4));
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel9MouseExited(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Reports_Icon_48.png"))); // NOI18N
        jLabel13.setText("REPORTS");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        kGradientPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 776, 289, -1));

        jLabel109.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/AAA.png"))); // NOI18N
        kGradientPanel2.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 160, 160));

        jPanel1.add(kGradientPanel2);
        kGradientPanel2.setBounds(-10, 40, 280, 890);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Delete_Icon_32.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7);
        jLabel7.setBounds(1650, 0, 40, 50);

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 51, 51));
        kGradientPanel1.setkStartColor(new java.awt.Color(0, 51, 51));
        kGradientPanel1.setLayout(null);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/menu (1).png"))); // NOI18N
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        kGradientPanel1.add(jLabel6);
        jLabel6.setBounds(12, 0, 84, 60);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel1.add(jLabel11);
        jLabel11.setBounds(1500, 10, 150, 40);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("HOME");
        kGradientPanel1.add(jLabel12);
        jLabel12.setBounds(334, 13, 362, 40);

        jLabel223.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Clock_Icon_48.png"))); // NOI18N
        kGradientPanel1.add(jLabel223);
        jLabel223.setBounds(1430, 10, 60, 40);

        jPanel1.add(kGradientPanel1);
        kGradientPanel1.setBounds(-6, 37, 1700, 60);

        kGradientPanel3.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel3.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/123.jpg"))); // NOI18N
        kGradientPanel3.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 58, -1, -1));

        jTabbedPane1.addTab("tab1", kGradientPanel3);

        kGradientPanel4.setBackground(new java.awt.Color(204, 204, 204));
        kGradientPanel4.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel4.setkStartColor(new java.awt.Color(0, 51, 51));
        kGradientPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_NUMBER", "FIRSTNAME", "MIDDLENAME", "LASTNAME", "EXT_NAME", "GENDER", "DATE_OF_BIRTH", "AGE", "CONTACT_NUMBER", "VOTER", "ADDRESS", "MOTHER", "FATHER", "DATE_CREATED", "DATE_UPDATED"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(30);
            jTable1.getColumnModel().getColumn(7).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(8).setPreferredWidth(100);
            jTable1.getColumnModel().getColumn(9).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(10).setPreferredWidth(130);
        }

        kGradientPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1390, 380));

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel60.setText("ID NUMBER             :");
        kGradientPanel4.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, -1, 30));

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel61.setText("FULLNAME               :");
        kGradientPanel4.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 550, -1, 30));

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel62.setText("GENDER                   :");
        kGradientPanel4.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 600, 180, 30));

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel63.setText("DATE OF BIRTH      :");
        kGradientPanel4.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 650, -1, 30));

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel65.setText("CONTACT NUMBER  :");
        kGradientPanel4.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 750, 190, 30));

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel66.setText("REGISTERED VOTER           :");
        kGradientPanel4.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 490, 260, 30));

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel67.setText("PERNAMENT ADDRESS      :");
        kGradientPanel4.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 550, 250, 30));

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel68.setText("NAME OF MOTHER              :");
        kGradientPanel4.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 600, 250, 30));

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel69.setText("NAME OF FATHER               :");
        kGradientPanel4.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 650, 250, 30));

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel4.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 496, 160, 20));

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel4.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 556, 240, 20));

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel4.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 606, 230, 20));

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel4.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 656, 220, 20));

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel4.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 706, 210, 20));

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel4.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 756, 220, 20));

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel4.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 500, 260, 20));

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel4.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 560, 500, 20));

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel4.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 610, 360, 20));

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel4.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 660, 320, 20));

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel70.setText(" DATE CREATED                  :");
        kGradientPanel4.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 700, 250, 30));

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel4.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 710, 320, 20));

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel4.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 760, 270, 20));

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel64.setText("AGE                           :");
        kGradientPanel4.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 700, 180, 30));

        jComboBox12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SEARCH BY", "ID_RESIDENT", "LASTNAME", "FIRSTNAME", "MIDDLENAME", "MOTHER", "FATHER", "REGISTERED_VOTER", " " }));
        jComboBox12.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jComboBox12MouseMoved(evt);
            }
        });
        jComboBox12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox12ActionPerformed(evt);
            }
        });
        kGradientPanel4.add(jComboBox12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 240, 30));

        jTextField28.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTextField28.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField28KeyReleased(evt);
            }
        });
        kGradientPanel4.add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 180, 30));

        jLabel224.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search_Icon_32.png"))); // NOI18N
        kGradientPanel4.add(jLabel224, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 29, 26, 31));

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel93.setText(" DATE UPDATED                  :");
        kGradientPanel4.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 750, 250, 30));

        jTabbedPane1.addTab("tab2", kGradientPanel4);

        kGradientPanel5.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel5.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                kGradientPanel5MouseMoved(evt);
            }
        });
        kGradientPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(51, 0, 204));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        kGradientPanel5.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jTextField1.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 160, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("LASTNAME");
        kGradientPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("FIRSTNAME");
        kGradientPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, -1, 30));

        jTextField2.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 100, 230, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("MIDDLENAME");
        kGradientPanel5.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 100, -1, 30));

        jTextField3.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 100, 180, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("EXT NAME");
        kGradientPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 100, -1, 30));

        jTextField4.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 270, 30));

        jComboBox1.setBackground(new java.awt.Color(204, 204, 204,100));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EXT", "JR", "SR", "I", "II", "III", "IV", "V" }));
        kGradientPanel5.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 100, -1, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("GENDER");
        kGradientPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setText("PLACE OF BIRTH");
        kGradientPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 180, -1, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel22.setText("DATE OF BIRTH");
        kGradientPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 180, -1, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel23.setText("AGE");
        kGradientPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 40, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setText(".");
        jLabel24.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jLabel24MouseMoved(evt);
            }
        });
        kGradientPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 110, 30));

        jComboBox2.setBackground(new java.awt.Color(204, 204, 204,100));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MONTH", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        kGradientPanel5.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 180, 100, 30));

        jTextField5.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 260, 170, 30));

        jTextField6.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField6KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 410, 60, 30));

        jTextField7.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField7.setText(" ");
        jTextField7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField7KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, 80, 30));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("CONTACT NUMBER");
        kGradientPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, -1, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("REGISTERED VOTER");
        kGradientPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 262, 190, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("RESIDENCY");
        kGradientPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 260, 120, 30));

        jTextField8.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField8.setText(" ");
        jTextField8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField8KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 410, 70, 30));

        jTextField9.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField9KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 410, 190, 30));

        jTextField10.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField10.setText(" ");
        jTextField10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField10KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1200, 410, 170, 30));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("MALE");
        kGradientPanel5.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 70, 30));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("FEMALE");
        kGradientPanel5.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 80, 30));

        jComboBox5.setBackground(new java.awt.Color(204, 204, 204,100));
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PREFFIX", "0929", "0905", "0922", "0936", "0916", "0945", "0999", "0918", "0975" }));
        kGradientPanel5.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, -1, 30));

        jComboBox6.setBackground(new java.awt.Color(204, 204, 204,100));
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NO", "YES" }));
        jComboBox6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox6ActionPerformed(evt);
            }
        });
        kGradientPanel5.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 262, 90, 30));

        jComboBox3.setBackground(new java.awt.Color(204, 204, 204,100));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DAY", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        kGradientPanel5.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 180, 70, 30));

        jComboBox4.setBackground(new java.awt.Color(204, 204, 204,100));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "YEAR", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", " ", " " }));
        jComboBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jComboBox4MouseReleased(evt);
            }
        });
        kGradientPanel5.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 180, 80, 30));

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        kGradientPanel5.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 170, -1));

        jComboBox7.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", " " }));
        kGradientPanel5.add(jComboBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 260, 70, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel28.setText("PERMANENT ADDRESS");
        kGradientPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 280, 30));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel29.setText("HOUSE NO");
        kGradientPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, -1, 30));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel30.setText("LOT NO");
        kGradientPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, -1, 30));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel31.setText("BLOCK NO");
        kGradientPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 410, 100, 30));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel32.setText("STREET");
        kGradientPanel5.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 410, 80, 30));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setText("SUBDIVISION");
        kGradientPanel5.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 410, 130, 30));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel34.setText("BARANGAY");
        kGradientPanel5.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 480, 110, 30));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel35.setText("MUNICIPALITY");
        kGradientPanel5.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 480, 150, 30));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel36.setText("PROVINCE");
        kGradientPanel5.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 480, 110, 30));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel37.setText("COUNTRY");
        kGradientPanel5.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 480, 100, 30));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel38.setText("NATIONALITY");
        kGradientPanel5.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 550, 140, 30));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel39.setText("HEIGHT");
        kGradientPanel5.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 550, -1, 30));

        jTextField11.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField11.setText("PARADA");
        jTextField11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField11KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 480, 150, 30));

        jTextField12.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField12.setText("STA MARIA");
        jTextField12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField12KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 480, 170, 30));

        jTextField13.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField13.setText("BULACAN");
        jTextField13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField13KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 480, 140, 30));

        jTextField14.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField14.setText("PHILIPPINES");
        jTextField14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField14KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 480, 160, 30));

        jTextField15.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField15KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 552, 140, 30));

        jTextField16.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField16KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 550, 60, 30));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel40.setText("CM");
        kGradientPanel5.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 560, -1, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel41.setText("WEIGHT");
        kGradientPanel5.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 550, 90, 30));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel42.setText("KG");
        kGradientPanel5.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 560, 20, -1));

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel43.setText("CIVIL STATUS");
        kGradientPanel5.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 550, 140, 30));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel44.setText("FAMILY BACKGROUND");
        kGradientPanel5.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 620, -1, -1));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel45.setText("NAME OF MOTHER");
        kGradientPanel5.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 672, 180, 30));

        jTextField17.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField17KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 550, 50, 30));

        jTextField19.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField19.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField19KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 670, 180, 30));

        jTextField20.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField20KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 670, 120, 30));

        jTextField21.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField21KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 732, 180, 30));

        jTextField22.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField22.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField22KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 730, 230, 30));

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel46.setText("OCCUPATION");
        kGradientPanel5.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 670, 130, 30));

        jComboBox8.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE", "SINGLE", "MARRIED", "WIDOWER", "LEGALLY SEPARATED", "LIVE IN", "DIVORCE" }));
        kGradientPanel5.add(jComboBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 550, 160, 30));

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel47.setText("CONTACT NUMBER");
        kGradientPanel5.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 670, 180, 30));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel48.setText("NAME OF FATHER");
        kGradientPanel5.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 726, -1, 30));

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel49.setText("OCCUPATION");
        kGradientPanel5.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 732, 130, 30));

        jComboBox9.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PREFFIX", "0929", "0905", "0922", "0936", "0916", "0945", "0999", "0918", "0975" }));
        kGradientPanel5.add(jComboBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 670, -1, 30));

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel50.setText("CONTACT NUMBER");
        kGradientPanel5.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 730, -1, 30));

        jLabel51.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel51.setText("NAME OF SPOUSE");
        kGradientPanel5.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 782, -1, 30));

        jLabel52.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel52.setText("NO. OF CHILDREN");
        kGradientPanel5.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 780, 180, 30));

        jTextField23.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField23.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField23KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 732, 120, 30));

        jTextField24.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField24.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField24KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField24, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 782, 230, 30));

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel54.setText("OCCUPATION");
        kGradientPanel5.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 786, 130, 30));

        jTextField25.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField25.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField25KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField25, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 782, 180, 30));

        jLabel58.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel58.setText("PRECINT NO");
        kGradientPanel5.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 550, -1, 30));

        jTextField26.setBackground(new java.awt.Color(204, 204, 204,100));
        jTextField26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField26.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField26KeyPressed(evt);
            }
        });
        kGradientPanel5.add(jTextField26, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 550, 80, 30));

        jLabel94.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(153, 0, 0));
        jLabel94.setText("jLabel94");
        kGradientPanel5.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 260, -1));

        jLabel96.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(153, 0, 0));
        jLabel96.setText("jLabel96");
        kGradientPanel5.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 320, -1));

        jLabel97.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(153, 0, 0));
        jLabel97.setText("jLabel97");
        kGradientPanel5.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 140, 300, -1));

        jLabel98.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(153, 0, 0));
        jLabel98.setText("jLabel98");
        kGradientPanel5.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 220, 20));

        jLabel99.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(153, 0, 0));
        jLabel99.setText("jLabel99");
        kGradientPanel5.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 360, 20));

        jLabel100.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(153, 0, 0));
        jLabel100.setText("jLabel100");
        kGradientPanel5.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 220, 400, -1));

        jLabel101.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(153, 0, 0));
        jLabel101.setText("jLabel101");
        kGradientPanel5.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 260, 20));

        jLabel102.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(153, 0, 0));
        jLabel102.setText("jLabel102");
        kGradientPanel5.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 300, 290, 20));

        jLabel105.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(153, 0, 0));
        jLabel105.setText("jLabel105");
        kGradientPanel5.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 450, 250, -1));

        jLabel107.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(153, 0, 0));
        jLabel107.setText("jLabel107");
        kGradientPanel5.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 520, 310, -1));

        jLabel108.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(153, 0, 0));
        jLabel108.setText("jLabel108");
        kGradientPanel5.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 520, 250, -1));

        jLabel111.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(153, 0, 0));
        jLabel111.setText("jLabel111");
        kGradientPanel5.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 596, 270, 20));

        jLabel112.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(153, 0, 0));
        jLabel112.setText("jLabel112");
        kGradientPanel5.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 590, 300, -1));

        jComboBox10.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PREFFIX", "0929", "0905", "0922", "0936", "0916", "0945", "0999", "0918", "0975" }));
        kGradientPanel5.add(jComboBox10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1162, 732, 80, 30));

        jComboBox11.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NONE", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22" }));
        jComboBox11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox11ActionPerformed(evt);
            }
        });
        kGradientPanel5.add(jComboBox11, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 782, -1, 30));

        jLabel103.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(153, 0, 0));
        jLabel103.setText("jLabel103");
        kGradientPanel5.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 300, 200, 20));

        jLabel110.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(153, 0, 0));
        jLabel110.setText("jLabel110");
        kGradientPanel5.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 520, 270, 20));
        kGradientPanel5.add(jTextField58, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 40, 180, 40));

        jTextField35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jTextField35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        kGradientPanel5.add(jTextField35, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 680, 230, 30));

        jLabel15.setBackground(new java.awt.Color(102, 204, 0));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/8888.jpg"))); // NOI18N
        kGradientPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 820, -1));

        jPanel11.setBackground(new java.awt.Color(0, 204, 0));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel11MouseEntered(evt);
            }
        });

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Add_Male_User_Icon_48.png"))); // NOI18N
        jLabel53.setText("ADD RECORD");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel11Layout.createSequentialGroup()
                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        kGradientPanel5.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 190, 60));

        jPanel12.setBackground(new java.awt.Color(153, 153, 153));
        jPanel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
        });

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Trash_Icon_48.png"))); // NOI18N
        jLabel55.setText("CLEAR");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 65, Short.MAX_VALUE)))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel12Layout.createSequentialGroup()
                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        kGradientPanel5.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 670, 190, 60));

        jPanel14.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        kGradientPanel5.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 210, 200));

        jPanel15.setBackground(new java.awt.Color(0, 0, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel15MouseClicked(evt);
            }
        });

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Edit_Male_User_Icon_48.png"))); // NOI18N
        jLabel57.setText("EDIT RECORD");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel57, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        );

        kGradientPanel5.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 190, 60));

        jLabel59.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel59.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search_Icon_48.png"))); // NOI18N
        jLabel59.setText("SEARCH BY ID");
        kGradientPanel5.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 170, -1));

        jTextField27.setBackground(new java.awt.Color(204, 204, 204));
        jTextField27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextField27.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField27KeyReleased(evt);
            }
        });
        kGradientPanel5.add(jTextField27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 170, 40));

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(153, 0, 0));
        kGradientPanel5.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 190, 20));

        jLabel104.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(153, 0, 0));
        jLabel104.setText("jLabel104");
        kGradientPanel5.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, 160, -1));

        jLabel106.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(153, 0, 0));
        jLabel106.setText("jLabel106");
        kGradientPanel5.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, 260, -1));

        jLabel113.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(153, 0, 0));
        jLabel113.setText("jLabel113");
        kGradientPanel5.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 700, 390, 30));

        jLabel114.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(153, 0, 0));
        jLabel114.setText("jLabel114");
        kGradientPanel5.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 760, 390, 20));

        jTabbedPane1.addTab("tab3", kGradientPanel5);

        kGradientPanel11.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel11.setkStartColor(new java.awt.Color(0, 51, 51));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID_NUMBER", "DATE", "TIME", "ACTION_PERPORMED", "USER"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
        }

        jTextField29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField29.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField29KeyReleased(evt);
            }
        });

        jComboBox13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID_NUMBER", "DATE", "TIME" }));

        javax.swing.GroupLayout kGradientPanel11Layout = new javax.swing.GroupLayout(kGradientPanel11);
        kGradientPanel11.setLayout(kGradientPanel11Layout);
        kGradientPanel11Layout.setHorizontalGroup(
            kGradientPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1381, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(kGradientPanel11Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        kGradientPanel11Layout.setVerticalGroup(
            kGradientPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(kGradientPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab4", kGradientPanel11);

        kGradientPanel7.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel7.setkStartColor(new java.awt.Color(0, 51, 51));
        kGradientPanel7.setPreferredSize(new java.awt.Dimension(1405, 785));
        kGradientPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));

        jTable4.setBackground(new java.awt.Color(204, 204, 204,100));
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Report_No", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        kGradientPanel7.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1360, 290));

        jLabel213.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel213.setText("REPORT NO                         :");
        kGradientPanel7.add(jLabel213, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, -1));

        jLabel214.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel214.setText("PANGALAN NG TANOD           :");
        kGradientPanel7.add(jLabel214, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        jLabel215.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel215.setText("URI NG KASO / PANGYAYARI  :");
        kGradientPanel7.add(jLabel215, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, -1, -1));

        jLabel216.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel216.setText("LUGAR NG PINANGYARIHAN               :");
        kGradientPanel7.add(jLabel216, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 400, -1, -1));

        jLabel217.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel217.setText("SINO - SINO ANG MGA SANGKOT  ?    :");
        kGradientPanel7.add(jLabel217, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 470, -1, -1));

        jLabel218.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel218.setText("ARAW / ORAS NG PANGYAYARI           :");
        kGradientPanel7.add(jLabel218, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, -1, -1));

        jLabel219.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel219.setText("ANO ANG NANGYARI  ?          :");
        kGradientPanel7.add(jLabel219, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, -1, -1));

        jLabel220.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel220.setText("PAANO NAGANAP ANG PANGYAYARI ?  :");
        kGradientPanel7.add(jLabel220, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 580, -1, -1));

        jTextField55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField55ActionPerformed(evt);
            }
        });
        kGradientPanel7.add(jTextField55, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 250, 40));
        kGradientPanel7.add(jTextField56, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 250, 40));
        kGradientPanel7.add(jTextField57, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, 250, 40));
        kGradientPanel7.add(jTextField59, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 330, 400, 40));
        kGradientPanel7.add(jTextField60, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 390, 400, 40));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane5.setViewportView(jTextArea1);

        kGradientPanel7.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 540, 250, 210));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane6.setViewportView(jTextArea2);

        kGradientPanel7.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 450, 400, -1));

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane7.setViewportView(jTextArea3);

        kGradientPanel7.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 570, 400, 180));

        kGradientPanel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        kGradientPanel23.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel23.setkStartColor(new java.awt.Color(0, 153, 0));

        jLabel221.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel221.setForeground(new java.awt.Color(255, 255, 255));
        jLabel221.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Print_Icon_48.png"))); // NOI18N
        jLabel221.setText("SAVE / PRINT");

        javax.swing.GroupLayout kGradientPanel23Layout = new javax.swing.GroupLayout(kGradientPanel23);
        kGradientPanel23.setLayout(kGradientPanel23Layout);
        kGradientPanel23Layout.setHorizontalGroup(
            kGradientPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel221, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
        );
        kGradientPanel23Layout.setVerticalGroup(
            kGradientPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel23Layout.createSequentialGroup()
                .addComponent(jLabel221)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        kGradientPanel7.add(kGradientPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 730, 160, 50));

        kGradientPanel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        kGradientPanel24.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel24.setkStartColor(new java.awt.Color(153, 0, 0));

        jLabel222.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel222.setForeground(new java.awt.Color(255, 255, 255));
        jLabel222.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Cancel_Icon_48.png"))); // NOI18N
        jLabel222.setText("CANCEL");

        javax.swing.GroupLayout kGradientPanel24Layout = new javax.swing.GroupLayout(kGradientPanel24);
        kGradientPanel24.setLayout(kGradientPanel24Layout);
        kGradientPanel24Layout.setHorizontalGroup(
            kGradientPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
            .addGroup(kGradientPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel24Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel222)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        kGradientPanel24Layout.setVerticalGroup(
            kGradientPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
            .addGroup(kGradientPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel24Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel222)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        kGradientPanel7.add(kGradientPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 730, 130, 50));

        jTabbedPane1.addTab("tab5", kGradientPanel7);

        kGradientPanel8.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel8.setkStartColor(new java.awt.Color(0, 51, 51));
        kGradientPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kGradientPanel8MouseClicked(evt);
            }
        });
        kGradientPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FIRSTNAME", "MIDDLENAME", "LASTNAME", "EXTNAME", "GENDER", "DATE_OF_BIRTH", "AGE", "CONTACT_NUMBER", "VOTER", "ADDRESS", "MOTHER", "FATHER", "DATE_CREATED", "DATE_DELETED"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(7).setResizable(false);
            jTable3.getColumnModel().getColumn(9).setResizable(false);
        }

        kGradientPanel8.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1400, -1));

        jLabel116.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel116.setText("ID NUMBER           :");
        kGradientPanel8.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, -1, -1));

        jLabel117.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel117.setText("FULLNAME             :");
        kGradientPanel8.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 580, -1, -1));

        jLabel118.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel118.setText("GENDER                 :");
        kGradientPanel8.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 630, -1, -1));

        jLabel119.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel119.setText("DATE_OF_BIRTH  :");
        kGradientPanel8.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 680, -1, -1));

        jLabel120.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel120.setText("AGE                         :");
        kGradientPanel8.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 730, -1, -1));

        jLabel121.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel121.setText("CONTACT               :");
        kGradientPanel8.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 780, -1, -1));

        jLabel122.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel122.setText("REGISTERED VOTER      :");
        kGradientPanel8.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 540, -1, -1));

        jLabel123.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel123.setText("PERNAMENT ADDRESS  :");
        kGradientPanel8.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 590, -1, -1));

        jLabel124.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel124.setText("MOTHER                           :");
        kGradientPanel8.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 630, -1, -1));

        jLabel125.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel125.setText("FATHER                            :");
        kGradientPanel8.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 680, -1, -1));

        jLabel126.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel126.setText("DATE_CREATED              :");
        kGradientPanel8.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 730, -1, -1));

        jLabel127.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel127.setText("DATE_DELETED              :");
        kGradientPanel8.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 780, -1, -1));

        jLabel128.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel8.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 540, 130, 30));

        jLabel129.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel8.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 580, 400, 30));

        jLabel130.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel8.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 630, 140, 30));

        jLabel131.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel8.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 680, 230, 30));

        jLabel132.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel8.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 730, 90, 30));

        jLabel133.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel8.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 780, 250, 30));

        jLabel134.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel8.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 540, 190, 30));

        jLabel135.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel8.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 580, 430, 30));

        jLabel136.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel8.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 630, 380, 30));

        jLabel137.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel8.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 680, 370, 30));

        jLabel138.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel8.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 730, 300, 30));

        jLabel139.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel8.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 780, 200, 30));

        jTabbedPane1.addTab("tab6", kGradientPanel8);

        kGradientPanel10.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel10.setkStartColor(new java.awt.Color(0, 51, 51));
        kGradientPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel141.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/1.jpg"))); // NOI18N
        kGradientPanel10.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(826, 339, -1, -1));

        jLabel142.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/9.jpg"))); // NOI18N
        kGradientPanel10.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 340, -1, -1));

        jLabel143.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/10.jpg"))); // NOI18N
        kGradientPanel10.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(473, 337, -1, -1));

        jLabel144.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/4.jpg"))); // NOI18N
        kGradientPanel10.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(1155, 339, -1, -1));

        jLabel145.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/8.jpg"))); // NOI18N
        kGradientPanel10.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(653, 110, -1, -1));

        jLabel146.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/5.jpg"))); // NOI18N
        kGradientPanel10.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 603, -1, -1));

        jLabel147.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/6.jpg"))); // NOI18N
        kGradientPanel10.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(653, 603, -1, -1));

        jLabel148.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/7.jpg"))); // NOI18N
        kGradientPanel10.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(991, 603, -1, -1));

        jLabel149.setText("Barangay kagawad");
        kGradientPanel10.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, 120, 27));

        jLabel150.setText("Barangay kagawad");
        kGradientPanel10.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 470, 120, 27));

        jLabel151.setText("Barangay kagawad");
        kGradientPanel10.add(jLabel151, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 730, 110, 27));

        jLabel152.setText("Barangay Chairman");
        kGradientPanel10.add(jLabel152, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 240, 120, 27));

        jLabel153.setText("Barangay kagawad");
        kGradientPanel10.add(jLabel153, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 470, 120, 27));

        jLabel154.setText("Barangay kagawad");
        kGradientPanel10.add(jLabel154, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 470, 120, 27));

        jLabel155.setText("Barangay kagawad");
        kGradientPanel10.add(jLabel155, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 730, 110, 27));

        jLabel156.setText("Barangay kagawad");
        kGradientPanel10.add(jLabel156, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 730, 120, 27));

        jLabel157.setText("jLabel157");
        kGradientPanel10.add(jLabel157, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 270, 150, -1));

        jLabel158.setText("jLabel158");
        kGradientPanel10.add(jLabel158, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 500, 220, -1));

        jLabel159.setText("jLabel159");
        kGradientPanel10.add(jLabel159, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 240, -1));

        jLabel160.setText("jLabel160");
        kGradientPanel10.add(jLabel160, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 500, 220, -1));

        jLabel161.setText("jLabel161");
        kGradientPanel10.add(jLabel161, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 500, 250, -1));

        jLabel162.setText("jLabel162");
        kGradientPanel10.add(jLabel162, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 760, 230, -1));

        jLabel163.setText("jLabel163");
        kGradientPanel10.add(jLabel163, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 760, 220, -1));

        jLabel164.setText("jLabel164");
        kGradientPanel10.add(jLabel164, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 760, 250, -1));

        jTabbedPane1.addTab("tab8", kGradientPanel10);

        kGradientPanel9.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel9.setkStartColor(new java.awt.Color(0, 51, 51));
        kGradientPanel9.setPreferredSize(new java.awt.Dimension(1405, 830));
        kGradientPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jRadioButton3.setBackground(new java.awt.Color(0, 51, 51,100));
        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton3.setText("Barangay Clearance");
        jRadioButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton3MouseClicked(evt);
            }
        });
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        kGradientPanel9.add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, 270, -1));

        jRadioButton5.setBackground(new java.awt.Color(0, 51, 51,100));
        buttonGroup2.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton5.setText("Barangay Business Permit");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });
        kGradientPanel9.add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 570, 270, -1));

        jRadioButton6.setBackground(new java.awt.Color(0, 51, 51,100));
        buttonGroup2.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton6.setText("Barangay Identification Card");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });
        kGradientPanel9.add(jRadioButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 670, 270, -1));

        kGradientPanel16.setkEndColor(new java.awt.Color(0, 51, 51));
        kGradientPanel16.setkStartColor(new java.awt.Color(0, 51, 51));

        jLabel166.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel166.setForeground(new java.awt.Color(255, 255, 255));
        jLabel166.setText("Barangay Clearance");

        javax.swing.GroupLayout kGradientPanel16Layout = new javax.swing.GroupLayout(kGradientPanel16);
        kGradientPanel16.setLayout(kGradientPanel16Layout);
        kGradientPanel16Layout.setHorizontalGroup(
            kGradientPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel16Layout.createSequentialGroup()
                .addContainerGap(232, Short.MAX_VALUE)
                .addComponent(jLabel166, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );
        kGradientPanel16Layout.setVerticalGroup(
            kGradientPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel166, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        kGradientPanel9.add(kGradientPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 720, 50));

        jTabbedPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        kGradientPanel12.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel12.setkStartColor(new java.awt.Color(0, 51, 51));
        kGradientPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel167.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel167.setForeground(new java.awt.Color(255, 255, 255));
        jLabel167.setText("Fullname");
        kGradientPanel12.add(jLabel167, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabel168.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel168.setForeground(new java.awt.Color(255, 255, 255));
        jLabel168.setText("Age");
        kGradientPanel12.add(jLabel168, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel169.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel169.setForeground(new java.awt.Color(255, 255, 255));
        jLabel169.setText("Street Address");
        kGradientPanel12.add(jLabel169, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 130, 30));

        jLabel170.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel170.setForeground(new java.awt.Color(255, 255, 255));
        jLabel170.setText("Date Issued");
        kGradientPanel12.add(jLabel170, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jTextField30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kGradientPanel12.add(jTextField30, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 380, 40));

        jTextField31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kGradientPanel12.add(jTextField31, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 380, 40));

        jTextField32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kGradientPanel12.add(jTextField32, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 380, 40));

        jButton2.setBackground(new java.awt.Color(0, 204, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/PREVIEW.png"))); // NOI18N
        jButton2.setText("PREVIEW");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        kGradientPanel12.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, 150, 40));

        jButton3.setBackground(new java.awt.Color(153, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Trash_Icon_32.png"))); // NOI18N
        jButton3.setText("CLEAR");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        kGradientPanel12.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, 140, 40));

        jLabel165.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel165.setForeground(new java.awt.Color(153, 0, 0));
        jLabel165.setText("jLabel165");
        kGradientPanel12.add(jLabel165, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 380, -1));

        jLabel171.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel171.setForeground(new java.awt.Color(153, 0, 0));
        jLabel171.setText("jLabel171");
        kGradientPanel12.add(jLabel171, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 380, -1));

        jLabel172.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel172.setForeground(new java.awt.Color(153, 0, 0));
        jLabel172.setText("jLabel172");
        kGradientPanel12.add(jLabel172, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 380, -1));

        jLabel174.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kGradientPanel12.add(jLabel174, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 270, 40));

        jTabbedPane2.addTab("tab1", kGradientPanel12);

        kGradientPanel13.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel13.setkStartColor(new java.awt.Color(0, 51, 51));
        kGradientPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField38.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kGradientPanel13.add(jTextField38, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 380, 40));

        jTextField39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kGradientPanel13.add(jTextField39, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 380, 40));

        jTextField40.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kGradientPanel13.add(jTextField40, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 380, 40));

        jTextField41.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kGradientPanel13.add(jTextField41, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, 380, 40));

        jLabel183.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel183.setForeground(new java.awt.Color(255, 255, 255));
        jLabel183.setText("Age");
        kGradientPanel13.add(jLabel183, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        jLabel184.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel184.setForeground(new java.awt.Color(255, 255, 255));
        jLabel184.setText("Street Address");
        kGradientPanel13.add(jLabel184, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel185.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel185.setForeground(new java.awt.Color(255, 255, 255));
        jLabel185.setText("Purpose");
        kGradientPanel13.add(jLabel185, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 90, 30));

        jLabel186.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel186.setForeground(new java.awt.Color(255, 255, 255));
        jLabel186.setText("Date Issued");
        kGradientPanel13.add(jLabel186, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 392, -1, 30));

        jLabel187.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel187.setForeground(new java.awt.Color(255, 255, 255));
        jLabel187.setText("Fullname Guardian");
        kGradientPanel13.add(jLabel187, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 160, -1));

        jButton6.setBackground(new java.awt.Color(153, 0, 0));
        jButton6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Trash_Icon_32.png"))); // NOI18N
        jButton6.setText("CLEAR");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        kGradientPanel13.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 445, 130, 40));

        jButton7.setBackground(new java.awt.Color(0, 204, 0));
        jButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/PREVIEW.png"))); // NOI18N
        jButton7.setText("PREVIEW");
        jButton7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        kGradientPanel13.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 445, 160, 40));

        jLabel188.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kGradientPanel13.add(jLabel188, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 390, 370, 30));

        jLabel193.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel193.setForeground(new java.awt.Color(153, 0, 0));
        jLabel193.setText("jLabel193");
        kGradientPanel13.add(jLabel193, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 380, 20));

        jLabel194.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel194.setForeground(new java.awt.Color(153, 0, 0));
        jLabel194.setText("jLabel194");
        kGradientPanel13.add(jLabel194, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 380, 20));

        jLabel195.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel195.setForeground(new java.awt.Color(153, 0, 0));
        jLabel195.setText("jLabel195");
        kGradientPanel13.add(jLabel195, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 380, 20));

        jLabel196.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel196.setForeground(new java.awt.Color(153, 0, 0));
        jLabel196.setText("jLabel196");
        kGradientPanel13.add(jLabel196, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 380, 20));

        jTabbedPane2.addTab("tab2", kGradientPanel13);

        kGradientPanel14.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel14.setkStartColor(new java.awt.Color(0, 51, 51));
        kGradientPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField42.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kGradientPanel14.add(jTextField42, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 380, 40));

        jLabel189.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel189.setForeground(new java.awt.Color(255, 255, 255));
        jLabel189.setText("Date Issued");
        kGradientPanel14.add(jLabel189, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 160, -1));

        jTextField43.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kGradientPanel14.add(jTextField43, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 380, 40));

        jLabel190.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel190.setForeground(new java.awt.Color(255, 255, 255));
        jLabel190.setText("Name of Business");
        kGradientPanel14.add(jLabel190, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 160, 40));

        jLabel191.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel191.setForeground(new java.awt.Color(255, 255, 255));
        jLabel191.setText("Address");
        kGradientPanel14.add(jLabel191, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 160, -1));

        jLabel192.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        kGradientPanel14.add(jLabel192, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 370, 40));

        jButton8.setBackground(new java.awt.Color(153, 0, 0));
        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Trash_Icon_32.png"))); // NOI18N
        jButton8.setText("CLEAR");
        jButton8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        kGradientPanel14.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 405, 150, 40));

        jButton9.setBackground(new java.awt.Color(0, 204, 0));
        jButton9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/PREVIEW.png"))); // NOI18N
        jButton9.setText("PREVIEW");
        jButton9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        kGradientPanel14.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 405, 140, 40));

        jLabel197.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel197.setForeground(new java.awt.Color(153, 0, 0));
        jLabel197.setText("jLabel197");
        kGradientPanel14.add(jLabel197, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 370, 20));

        jLabel198.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jLabel198.setForeground(new java.awt.Color(153, 0, 0));
        jLabel198.setText("jLabel198");
        kGradientPanel14.add(jLabel198, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 380, 30));

        jTabbedPane2.addTab("tab3", kGradientPanel14);

        kGradientPanel15.setkEndColor(new java.awt.Color(204, 204, 204));
        kGradientPanel15.setkStartColor(new java.awt.Color(0, 51, 51));
        kGradientPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel199.setForeground(new java.awt.Color(255, 255, 255));
        jLabel199.setText("Name");
        kGradientPanel15.add(jLabel199, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 44, 70, 30));

        jLabel200.setForeground(new java.awt.Color(255, 255, 255));
        jLabel200.setText("Date Of Birth");
        kGradientPanel15.add(jLabel200, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 100, 30));

        jLabel201.setForeground(new java.awt.Color(255, 255, 255));
        jLabel201.setText("Address");
        kGradientPanel15.add(jLabel201, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 70, 30));

        jLabel202.setForeground(new java.awt.Color(255, 255, 255));
        jLabel202.setText("Tin No");
        kGradientPanel15.add(jLabel202, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 50, 20));

        jLabel203.setForeground(new java.awt.Color(255, 255, 255));
        jLabel203.setText("SSS No");
        kGradientPanel15.add(jLabel203, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 70, 30));

        jLabel204.setForeground(new java.awt.Color(255, 255, 255));
        jLabel204.setText("Voters No");
        kGradientPanel15.add(jLabel204, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 60, 30));

        jLabel205.setForeground(new java.awt.Color(255, 255, 255));
        jLabel205.setText("Precint No");
        kGradientPanel15.add(jLabel205, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 80, 30));

        jLabel206.setForeground(new java.awt.Color(255, 255, 255));
        jLabel206.setText("Philhealth No");
        kGradientPanel15.add(jLabel206, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 80, 20));

        jLabel207.setForeground(new java.awt.Color(255, 255, 255));
        jLabel207.setText("Pagibig No");
        kGradientPanel15.add(jLabel207, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        jLabel208.setForeground(new java.awt.Color(255, 255, 255));
        jLabel208.setText("Guardian");
        kGradientPanel15.add(jLabel208, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        jLabel209.setForeground(new java.awt.Color(255, 255, 255));
        jLabel209.setText("Guardian Street Address");
        kGradientPanel15.add(jLabel209, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, -1, 20));

        jLabel210.setForeground(new java.awt.Color(255, 255, 255));
        jLabel210.setText("Guardian Contact Number");
        kGradientPanel15.add(jLabel210, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, -1, -1));

        jLabel211.setForeground(new java.awt.Color(255, 255, 255));
        jLabel211.setText("Date Issued");
        kGradientPanel15.add(jLabel211, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 80, 20));
        kGradientPanel15.add(jTextField33, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 170, 30));
        kGradientPanel15.add(jTextField44, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 102, 170, 30));
        kGradientPanel15.add(jTextField45, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 170, 30));
        kGradientPanel15.add(jTextField46, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 170, 30));
        kGradientPanel15.add(jTextField47, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, 170, 30));
        kGradientPanel15.add(jTextField48, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 170, 30));
        kGradientPanel15.add(jTextField49, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 170, 30));
        kGradientPanel15.add(jTextField50, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 220, 30));
        kGradientPanel15.add(jTextField51, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 220, 30));
        kGradientPanel15.add(jTextField52, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 220, 30));
        kGradientPanel15.add(jTextField53, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 210, 220, 30));
        kGradientPanel15.add(jTextField54, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 262, 220, 30));
        kGradientPanel15.add(jLabel212, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 200, 30));

        jButton10.setBackground(new java.awt.Color(153, 0, 0));
        jButton10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Trash_Icon_32.png"))); // NOI18N
        jButton10.setText("CLEAR");
        jButton10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        kGradientPanel15.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 140, 40));

        jButton11.setBackground(new java.awt.Color(0, 204, 0));
        jButton11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/PREVIEW.png"))); // NOI18N
        jButton11.setText("PREVIEW");
        jButton11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        kGradientPanel15.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 430, 130, 40));

        jTabbedPane2.addTab("tab4", kGradientPanel15);

        kGradientPanel9.add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 720, 540));

        jRadioButton4.setBackground(new java.awt.Color(0, 51, 51,100));
        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton4.setText("Barangay Indigency Clearance");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        kGradientPanel9.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 270, -1));

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "RESIDENT_ID", "FIRSTNAME", "MIDDLENAME", "LASTNAME", "EXT_NAME", "DATE_OF_BIRTH", "AGE", "CONTACT", "HOUSE NO", "LOT NO", "BLOCK NO", "STREET", "SUBDIVISION"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(jTable5);
        if (jTable5.getColumnModel().getColumnCount() > 0) {
            jTable5.getColumnModel().getColumn(5).setResizable(false);
            jTable5.getColumnModel().getColumn(9).setResizable(false);
        }

        kGradientPanel9.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 1360, 160));

        jTextField34.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTextField34.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField34KeyReleased(evt);
            }
        });
        kGradientPanel9.add(jTextField34, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 180, 30));

        jLabel225.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search_Icon_32.png"))); // NOI18N
        kGradientPanel9.add(jLabel225, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 29, 26, 31));

        jComboBox14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SEARCH BY", "ID_RESIDENT", "LASTNAME", "FIRSTNAME", "MIDDLENAME", "MOTHER", "FATHER", "REGISTERED_VOTER", " " }));
        jComboBox14.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jComboBox14MouseMoved(evt);
            }
        });
        jComboBox14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox14ActionPerformed(evt);
            }
        });
        kGradientPanel9.add(jComboBox14, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 240, 30));

        jTabbedPane1.addTab("tab7", kGradientPanel9);

        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(280, 60, 1410, 860);

        jLabel14.setText("jLabel14");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14);
        jLabel14.setBounds(1570, 10, 48, 16);

        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setText("BARANGAY POPULATION");
        jPanel1.add(jLabel82);
        jLabel82.setBounds(60, 180, 140, 16);

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setText("5");
        jPanel1.add(jLabel83);
        jLabel83.setBounds(100, 216, 60, 30);

        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setText("NUMBER OF REGISTERED VOTER");
        jLabel84.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel84);
        jLabel84.setBounds(40, 270, 190, 16);

        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setText("5");
        jPanel1.add(jLabel85);
        jLabel85.setBounds(100, 310, 7, 16);

        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setText("NUMBER OF NON VOTERS");
        jPanel1.add(jLabel86);
        jLabel86.setBounds(50, 370, 160, 20);

        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setText("6");
        jPanel1.add(jLabel87);
        jLabel87.setBounds(100, 420, 7, 16);

        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setText("NUMBER OF BLOTTER");
        jPanel1.add(jLabel88);
        jLabel88.setBounds(50, 476, 160, 20);

        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setText("3");
        jPanel1.add(jLabel89);
        jLabel89.setBounds(90, 520, 7, 16);

        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setText("DATE");
        jPanel1.add(jLabel90);
        jLabel90.setBounds(90, 600, 80, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1694, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 927, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1694, 927));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        // TODO add your handling code here:
        this.setState(this.ICONIFIED);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        int x=0;

        if(x == 0){
            kGradientPanel2.setSize(270,890);
            Thread th = new Thread(){
                @Override
                public void run(){
                    try{
                        for(int i=0;i<=270;i++){
                            Thread.sleep(1);
                            kGradientPanel2.setSize(i,890);
                        }

                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }
                }

            };th.start();
            x=270;
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:

        System.exit(0);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jPanel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseExited
        // TODO add your handling code here:
        jLabel13.setForeground(new Color(255,255,255));
        jPanel9.setBackground(new Color(0,51,51));
    }//GEN-LAST:event_jPanel9MouseExited

    private void jPanel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseEntered
        // TODO add your handling code here:
        jLabel13.setForeground(new Color(0,0,0));
        jPanel9.setBackground(new Color(102,255,102));

    }//GEN-LAST:event_jPanel9MouseEntered

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(4);
        jLabel12.setText("REPORTS");
    }//GEN-LAST:event_jPanel9MouseClicked

    private void jPanel8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseExited
        // TODO add your handling code here:
        jLabel10.setForeground(new Color(255,255,255));
        jPanel8.setBackground(new Color(0,51,51));
    }//GEN-LAST:event_jPanel8MouseExited

    private void jPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseEntered
        // TODO add your handling code here:
        jLabel10.setForeground(new Color(0,0,0));
        jPanel8.setBackground(new Color(102,255,102));
    }//GEN-LAST:event_jPanel8MouseEntered

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        // TODO add your handling code here:
        fetch_log();
        jTabbedPane1.setSelectedIndex(3);
        jLabel12.setText("LOGS");
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseExited
        // TODO add your handling code here:
        jLabel9.setForeground(new Color(255,255,255));
        jPanel7.setBackground(new Color(0,51,51));
    }//GEN-LAST:event_jPanel7MouseExited

    private void jPanel7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseEntered
        // TODO add your handling code here:
        jLabel9.setForeground(new Color(0,0,0));
        jPanel7.setBackground(new Color(102,255,102));
    }//GEN-LAST:event_jPanel7MouseEntered

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(6);
        jLabel12.setText("ORGANIZATION");
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseExited
        // TODO add your handling code here:
        jLabel8.setForeground(new Color(255,255,255));
        jPanel6.setBackground(new Color(0,51,51));
    }//GEN-LAST:event_jPanel6MouseExited

    private void jPanel6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseEntered
        // TODO add your handling code here:
        jLabel8.setForeground(new Color(0,0,0));
        jPanel6.setBackground(new Color(102,255,102));
    }//GEN-LAST:event_jPanel6MouseEntered

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(7);
        jLabel12.setText("DOCUMENT AND REQUEST");
        fetch_clearance();
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        int x=270;

        if(x == 270){
            kGradientPanel2.setSize(270,890);
            Thread th = new Thread(){
                @Override
                public void run(){
                    try{
                        for(int i=270;i>=0;i--){
                            Thread.sleep(1);
                            kGradientPanel2.setSize(i,890);
                        }

                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, e);
                    }
                }

            };th.start();
            x=0;
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jPanel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseExited
        // TODO add your handling code here:
        jLabel4.setForeground(new Color(255,255,255));
        jPanel5.setBackground(new Color(0,51,51));

    }//GEN-LAST:event_jPanel5MouseExited

    private void jPanel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseEntered
        // TODO add your handling code here:
        jLabel4.setForeground(new Color(0,0,0));
        jPanel5.setBackground(new Color(102,255,102));

    }//GEN-LAST:event_jPanel5MouseEntered

    private void jPanel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(5);
        jLabel12.setText("ARCHIVE RESIDENT");
        archive();
    }//GEN-LAST:event_jPanel5MouseClicked

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        // TODO add your handling code here:
        jLabel3.setForeground(new Color(255,255,255));
        jPanel4.setBackground(new Color(0,51,51));

    }//GEN-LAST:event_jPanel4MouseExited

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        // TODO add your handling code here:
        jLabel3.setForeground(new Color(0,0,0));
        jPanel4.setBackground(new Color(102,255,102));

    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(2);
        jLabel12.setText("ADD/EDIT RESIDENT");
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseExited
        // TODO add your handling code here:
        jLabel2.setForeground(new Color(255,255,255));
        jPanel3.setBackground(new Color(0,51,51));

    }//GEN-LAST:event_jPanel3MouseExited

    private void jPanel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseEntered
        // TODO add your handling code here:
        jLabel2.setForeground(new Color(0,0,0));
        jPanel3.setBackground(new Color(102,255,102));

    }//GEN-LAST:event_jPanel3MouseEntered

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(1);
        jLabel12.setText("RESIDENT INFORMATION");
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        // TODO add your handling code here:
        jLabel1.setForeground(new Color(255,255,255));
        jPanel2.setBackground(new Color(0,51,51));

    }//GEN-LAST:event_jPanel2MouseExited

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        // TODO add your handling code here:
        jLabel1.setForeground(new Color(0,0,0));
        jPanel2.setBackground(new Color(102,255,102));

    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
        jTabbedPane1.setSelectedIndex(0);
        jLabel12.setText("HOME");
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jComboBox6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox6ActionPerformed
        // TODO add your handling code here:
        String vote = (String) jComboBox6.getSelectedItem();
        
        if(vote.equals("YES")){
            jTextField26.setEditable(true);
        }else{
            jTextField26.setEditable(false);
            jTextField26.setText("");
        }
        
    }//GEN-LAST:event_jComboBox6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
       
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        clear();
        
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jPanel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseClicked
       
       
        String id = jTextField58.getText();
        String lname = jTextField1.getText();
        String fname = jTextField2.getText();
        String mname = jTextField3.getText();
        String mother_name = jTextField35.getText();
        String father_name = jTextField22.getText(); 
        String month = (String) jComboBox2.getSelectedItem();
        String day = (String) jComboBox3.getSelectedItem();
        String year = (String) jComboBox4.getSelectedItem();
        String birthday = month +" "+day+" "+year;
        String last="";
        String first="";
        String mid="";
        String mom="";
        String dad="";
        String bday="";
        
        try{

        String query = "Select * from resident_information_tbl WHERE lastname='"+lname+"' AND firstname='"+fname+"' AND middlename='"+mname+"' AND father='"+father_name+"' AND mother='"+mother_name+"' AND date_of_birth='"+birthday+"'AND del=0" ;
        st = conn.prepareStatement(query);
        rs=st.executeQuery(query);
                while(rs.next()){
                    last= rs.getString("lastname");
                    first= rs.getString("firstname");
                    mid= rs.getString("middlename");
                    dad= rs.getString("father");
                    mom= rs.getString("mother");
                    bday= rs.getString("date_of_birth");
                }
                
       
    if(lname.isEmpty()){
            jLabel94.setText("Lastname is Required ");
     }else{
        jLabel94.setText("");
       if(lname.length()<=2){
           jLabel94.setText("Lastname is too short ");
       }else{
           jLabel94.setText("");
           if(fname.isEmpty()){
               jLabel96.setText("Firstname is Required ");
           }else{
               jLabel96.setText("");
               if(fname.length()<=2){
                   jLabel96.setText("Firstname is too short ");
               }else{
                   jLabel96.setText("");
                   if(mname.isEmpty()){
                       jLabel97.setText("Middletname is Required ");
                   }else{
                       jLabel97.setText("");
                       if(mname.length()<=2){
                           jLabel97.setText("Middlename is too short ");
                       }else{
                           
                           jLabel97.setText("");
                           if(jRadioButton1.isSelected()||jRadioButton2.isSelected()){
                                jLabel98.setText("");
                               if(jTextField4.getText().isEmpty()){
                                   jLabel99.setText("Place of Birth is Required");
                               }else{
                                   jLabel99.setText("");
                                   if(jTextField4.getText().length()<=4){
                                       jLabel99.setText("Place of Birth is too Short");
                                   }else{
                                       jLabel99.setText("");
                                       if(jComboBox2.getSelectedIndex()==0||jComboBox3.getSelectedIndex()==0||jComboBox4.getSelectedIndex()==0){
                                           jLabel100.setText("Date of Birth is Required");
                                       }else{
                                           jLabel100.setText("");
                                           if(jTextField5.getText().isEmpty()){
                                                jLabel101.setText("Contact number is Required");
                                           }else{
                                               jLabel101.setText("");
                                              if(jTextField5.getText().length()<=6){
                                                  jLabel101.setText("Contact number is too short");
                                              } else{
                                                  jLabel101.setText("");
                                                  if(jComboBox7.getSelectedIndex()==0){
                                                      jLabel103.setText("Residency is Required");
                                                  }else{
                                                      jLabel103.setText("");
                                                      if(jTextField6.getText().isEmpty()){
                                                          jLabel104.setText("House Number is Required");
                                                      }else{
                                                          jLabel104.setText("");
                                                          if(jTextField9.getText().isEmpty()){
                                                              jLabel105.setText("Street is Required");
                                                          }else{
                                                              jLabel105.setText("");
                                                              if(jTextField9.getText().length()<=4){
                                                                  jLabel105.setText("Street  is too Short");
                                                              }else{
                                                                  jLabel105.setText("");
                                                                  if(jTextField11.getText().isEmpty()){
                                                                      jLabel106.setText("Barangay is Required");
                                                                  }else{
                                                                      jLabel106.setText("");
                                                                      if(jTextField11.getText().length()<=2){
                                                                          jLabel106.setText("Barangay is too short");
                                                                      }else{
                                                                          jLabel106.setText("");
                                                                          if(jTextField12.getText().isEmpty()){
                                                                              jLabel107.setText("Municipality is Required");
                                                                          }else{
                                                                              jLabel107.setText("");
                                                                              if(jTextField12.getText().length()<=4){
                                                                                 jLabel107.setText("Municipality is too short");  
                                                                              }else{
                                                                                  jLabel107.setText("");
                                                                                  if(jTextField13.getText().isEmpty()){
                                                                                      jLabel108.setText("Province is Required");
                                                                                  }else{
                                                                                      jLabel108.setText("");
                                                                                      if(jTextField13.getText().length()<=4){
                                                                                          jLabel108.setText("Province is too short");
                                                                                      }else{
                                                                                          jLabel108.setText("");
                                                                                          if(jTextField14.getText().isEmpty()){
                                                                                              jLabel110.setText("Counrty is Required");
                                                                                          }else{
                                                                                              jLabel110.setText("");
                                                                                              if(jTextField14.getText().length()<=4){
                                                                                                  jLabel110.setText("Counrty is too short");
                                                                                              }else{
                                                                                                  jLabel110.setText("");
                                                                                                 if(jTextField15.getText().isEmpty()){
                                                                                                      jLabel111.setText("Nationality is Required");
                                                                                                 }else{
                                                                                                     jLabel111.setText("");
                                                                                                     if(jTextField15.getText().length()<=4){
                                                                                                          jLabel111.setText("Nationality is too short");
                                                                                                     }else{
                                                                                                         jLabel111.setText("");
                                                                                                         if(jComboBox8.getSelectedIndex()==0){
                                                                                                             jLabel112.setText("Civil status is Required");
                                                                                                         }else{
                                                                                                             jLabel112.setText("");
                                                                                                             if(jTextField35.getText().isEmpty()){
                                                                                                                 jLabel113.setText("Mother name is Required");
                                                                                                             }else{
                                                                                                                 jLabel113.setText("");
                                                                                                                 if(jTextField35.getText().length()<=4){
                                                                                                                      jLabel113.setText("Mother name is too short");
                                                                                                                 }else{
                                                                                                                     jLabel113.setText("");
                                                                                                                     if(jTextField22.getText().isEmpty()){
                                                                                                                         jLabel114.setText("Father name is Required");
                                                                                                                     }else{
                                                                                                                         jLabel114.setText("");
                                                                                                                         if(jTextField22.getText().length()<=4){
                                                                                                                             jLabel114.setText("Father name is too short");
                                                                                                                         }else{
                                                                                                                               jLabel114.setText("");
                                                                                                                               if(lname.equalsIgnoreCase(last)&& fname.equalsIgnoreCase(first) && mname.equalsIgnoreCase(mid) && mother_name.equalsIgnoreCase(mom) && father_name.equalsIgnoreCase(dad) && birthday.equalsIgnoreCase(bday)){
                                                                                                                                   JOptionPane.showMessageDialog(null,"RESIDENT INFORMATION IS ALREADY TAKEN");
                                                                                                                               }else{
               
                                                                                                                                   String place_birth = jTextField4.getText();
                                                                                                                                   String contact = jTextField5.getText();
                                                                                                                                   String house = jTextField6.getText();
                                                                                                                                   String lot = jTextField7.getText();
                                                                                                                                   String block = jTextField8.getText();
                                                                                                                                   String street = jTextField9.getText();
                                                                                                                                   String subdivision = jTextField10.getText();
                                                                                                                                   String barangay = jTextField11.getText();
                                                                                                                                   String municipality = jTextField12.getText();
                                                                                                                                   String province = jTextField13.getText();
                                                                                                                                   String country = jTextField14.getText();
                                                                                                                                   String nationality = jTextField15.getText();
                                                                                                                                   String height = jTextField16.getText();
                                                                                                                                   String weight = jTextField17.getText();
        
                                                                                                                                   String mother_occupation = jTextField19.getText();
                                                                                                                                   String mother_contact = jTextField20.getText();   
                                                                                                                                   String father_occupation = jTextField21.getText();
             
                                                                                                                                   String father_contact = jTextField23.getText();
                                                                                                                                   String name_spouse = jTextField24.getText();
                                                                                                                                   String spouse_occupation = jTextField25.getText();
                                                                                                                                   String precint = jTextField26.getText();
                                                                                                                                   String age =jLabel24.getText();
        
        
                                                                                                                                   String gender="";
        
                                                                                                                                      if(jRadioButton1.isSelected()){
                                                                                                                                              gender = "MALE";
                                                                                                                                      }
                                                                                                                                      if(jRadioButton2.isSelected()){
                                                                                                                                              gender = "FEMALE";
                                                                                                                                      }
        
                                                                                                                                        String ext_name = (String) jComboBox1.getSelectedItem();

                                                                                                                                        String contact_preffix = (String) jComboBox5.getSelectedItem();
                                                                                                                                        String voter = (String) jComboBox6.getSelectedItem();
                                                                                                                                        String recidency = (String) jComboBox7.getSelectedItem();
                                                                                                                                        String status = (String) jComboBox8.getSelectedItem();
                                                                                                                                        String mother_preffix = (String) jComboBox9.getSelectedItem();
                                                                                                                                        String father_preffix = (String) jComboBox10.getSelectedItem();
                                                                                                                                        String children = (String) jComboBox11.getSelectedItem();
        
                                                                                                                                        String contact_resident = contact_preffix + contact;
                                                                                                                                        String contact_mother_all = mother_preffix + mother_contact;
                                                                                                                                        String contact_father_all = father_preffix + father_contact;
        
                                                                                                                                        String address = house +" "+ lot +" "+block+" "+street+" "+ subdivision+" "+barangay+" "+municipality+" "+province+" "+country;
          
                                                                                                                                        LocalDate nowDate = LocalDate.now();
                                                                                                                                        String fullname = "INSERT INFORMATION "+lname+" "+fname+" "+mname;
       
       
                                                                                                                                        String sql = "INSERT INTO resident_information_tbl(id_resident,lastname, firstname, middlename, ext_name, gender, place_of_birth, date_of_birth, age, contact_number, registered_voter, residency, complete_pernament, nationality, height, weight, precint_number, civil_status, mother, mother_occupation, mother_contact, father, father_occupation, father_contact, spouse, spouse_occupation, no_of_children, date_created, month, day, year, preffix_resident, number_resident, house, lot, block, street, subdivision, barangay, municipality, province, country, preffix_mother, number_mother, preffix_father, number_father, date_updated,del, date_deleted) VALUES ('"+id+"','"+lname+"','"+fname+"','"+mname+"','"+ext_name+"','"+gender+"','"+place_birth+"','"+birthday+"','"+age+"','"+contact_resident+"','"+voter+"','"+recidency+"','"+address+"','"+nationality+"','"+height+"','"+weight+"','"+precint+"','"+status+"','"+mother_name+"','"+mother_occupation+"','"+contact_mother_all+"','"+father_name+"','"+father_occupation+"','"+contact_father_all+"','"+name_spouse+"','"+spouse_occupation+"','"+children+"','"+nowDate+"','"+month+"','"+day+"','"+year+"','"+contact_preffix+"','"+contact+"','"+house+"','"+lot+"','"+block+"','"+street+"','"+subdivision+"','"+barangay+"','"+municipality+"','"+province+"','"+country+"','"+mother_preffix+"','"+mother_contact+"','"+father_preffix+"','"+father_contact+"',0,0,0)";                                       
        
                                                                                                                                        String label = "INSERT SUCCESSFULLY";
                                                                                                                                        connection(sql,label);
                                                                                                                                        String time = jLabel11.getText();
        
                                                                                                                                        String log_sql = "INSERT INTO log(date_log,time_log,action_log,user_log) VALUES('"+nowDate+"','"+time+"','"+fullname+"','user')";
                                                                                                                                        connection2(log_sql);
                                                                                                                              } 
                                                                                                                         }
                                                                                                                     }
                                                                                                                 }
                                                                                                             }
                                                                                                         }
                                                                                                     }
                                                                                                 }
                                                                                              }
                                                                                          }
                                                                                      }
                                                                                  }
                                                                              }
                                                                          }
                                                                      }
                                                                  }
                                                              }
                                                          }
                                                      }
                                                  }
                                              }
                                           }
                                       }
                                   }
                               }
                              }else{
                               jLabel98.setText("Gender is Required");  
                           }
                       }
                   }
               }
           }
       }
    }  
    
 
       
       
        
        }catch(Exception e){
            
        }
        
           
        

       
                

    }//GEN-LAST:event_jPanel11MouseClicked

    private void jLabel24MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseMoved
        // TODO add your handling code here:
 
        

    }//GEN-LAST:event_jLabel24MouseMoved

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_jPanel1MouseMoved

    private void jComboBox4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox4MouseReleased
        // TODO add your handling code here:
               
   
      
    }//GEN-LAST:event_jComboBox4MouseReleased

    private void kGradientPanel5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel5MouseMoved

        if(jComboBox5.getSelectedIndex()==0){
            jTextField5.setText("");
        }
        if(jComboBox9.getSelectedIndex()==0){
            jTextField20.setText("");
        }
        if(jComboBox10.getSelectedIndex()==0){
            jTextField23.setText("");
        }
        
       String month1 = (String) jComboBox2.getSelectedItem();
      String day1 = (String) jComboBox3.getSelectedItem();
     String year1 = (String) jComboBox4.getSelectedItem();
     
     
     if(month1.equals("MONTH")||day1.equals("DAY")||year1.equals("YEAR")){
         
         jLabel24.setText("");
     }else{
           int month=0;
        
       switch(month1){
            case "January":month=1;break;
            case "February":month=2;break;
            case "March":month=3;break;
            case "April":month=4;break;
            case "May":month=5;break;
            case "June":month=6;break;
            case "July":month=7;break;
            case "August":month=8;break;
            case "September":month=9;break;
            case "October":month=10;break;
            case "November":month=11;break;
            case "December":month=12;break;
        }
        
       int day2 = Integer.parseInt(day1);
       int year2 = Integer.parseInt(year1);
     
    LocalDate birt = LocalDate.of(year2,month,day2);
      LocalDate nowDate = LocalDate.now();
      int period = Period.between(birt,nowDate).getYears();
       String period1= Integer.toString(period);
      jLabel24.setText(""+period1);
     
       int valid_age = Integer.parseInt(jLabel24.getText());
       if(valid_age<=18){
          jComboBox6.setSelectedIndex(2);
          jComboBox6.setEnabled(false);
       }else{
           jComboBox6.setEnabled(true);
       }
     }
     
  //valid for mothername   
     
     String valid_mother = jTextField18.getText();
       
       if(valid_mother.isEmpty()){
          jTextField19.setText(""); 
          jTextField20.setText(""); 
           jComboBox9.setSelectedIndex(0);
           jTextField19.setEditable(false);
           jTextField20.setEditable(false);
           jComboBox9.setEnabled(false);
       }else{
           jTextField19.setEditable(true);
           jTextField20.setEditable(true);
           jComboBox9.setEnabled(true);
       }
    
       //valid_for father
            
     String valid_father = jTextField22.getText();
       
       if(valid_father.isEmpty()){
          jTextField21.setText(""); 
          jTextField23.setText(""); 
           jComboBox10.setSelectedIndex(0);
           jTextField21.setEditable(false);
           jTextField23.setEditable(false);
           jComboBox10.setEnabled(false);
       }else{
           jTextField21.setEditable(true);
           jTextField23.setEditable(true);
           jComboBox10.setEnabled(true);
       }
     
    //valid fot spouse
    
         String valid_spouse = jTextField24.getText();
       
       if(valid_spouse.isEmpty()){
          jTextField25.setText("");          
           jComboBox11.setSelectedIndex(0);
           jTextField25.setEditable(false);
           jComboBox11.setEnabled(false);
       }else{
           jTextField25.setEditable(true);
           jComboBox11.setEnabled(true);
       }
       
    }//GEN-LAST:event_kGradientPanel5MouseMoved

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        String position="CHAIRMAIN";
        String label="jLabel157";
        org(position,label);
        
        
         fetch_log();
         archive();
         jTextField26.setEditable(false);
         jTextField19.setEditable(false);
         jTextField21.setEditable(false);
         jTextField25.setEditable(false);
         jTextField20.setEditable(false);
         jTextField23.setEditable(false);
         jComboBox9.setEnabled(false);
         jComboBox10.setEnabled(false);
         jComboBox11.setEnabled(false);
         jTextField28.setEditable(false);
    }//GEN-LAST:event_formWindowOpened

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        
         int i = jTable1.getSelectedRow();
        
        TableModel model = jTable1.getModel();
        
        jLabel71.setText(model.getValueAt(i,0).toString());
        String fname = (String) model.getValueAt(i,1);
        String mname = (String) model.getValueAt(i,2);
        String lname = (String) model.getValueAt(i,3);
        String exname = (String) model.getValueAt(i,4);

        if(exname.equals("EXT")){
            exname="";
        }else{
            
        }
       jLabel72.setText(fname+", "+mname+", "+lname+" "+exname);
       
        jLabel73.setText((String) model.getValueAt(i,5));
        jLabel74.setText((String) model.getValueAt(i,6));
        jLabel75.setText((String) model.getValueAt(i,7));
        jLabel76.setText((String) model.getValueAt(i,8));
        jLabel77.setText((String) model.getValueAt(i,9));
        jLabel78.setText((String) model.getValueAt(i,10));
        jLabel79.setText((String) model.getValueAt(i,11));
        jLabel80.setText((String) model.getValueAt(i,12));
        jLabel81.setText((String) model.getValueAt(i,13));
        jLabel95.setText((String) model.getValueAt(i,14));
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField27KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField27KeyReleased
        // TODO add your handling code here:
        
        jLabel92.setText("");
       String id = jTextField27.getText();
        
       if(id.isEmpty()){
           clear();
       }else{
      
        try{

        String query = "Select * from resident_information_tbl WHERE id_resident='"+id+"' AND del=0";
        st = conn.prepareStatement(query);

      //  st.setString(1,jTextField9.getText());
        
        rs=st.executeQuery(query);
  
        while(rs.next()){
            jTextField1.setText(rs.getString("lastname"));
            jTextField2.setText(rs.getString("firstname"));
            jTextField3.setText(rs.getString("middlename"));
            jTextField4.setText(rs.getString("place_of_birth"));
            jTextField5.setText(rs.getString("number_resident"));
            
            jTextField6.setText(rs.getString("house"));
            jTextField7.setText(rs.getString("lot"));
            jTextField8.setText(rs.getString("block"));
            jTextField9.setText(rs.getString("street"));
            jTextField10.setText(rs.getString("subdivision"));
            jTextField11.setText(rs.getString("barangay"));
            jTextField12.setText(rs.getString("municipality"));
            jTextField13.setText(rs.getString("province"));
            jTextField14.setText(rs.getString("country"));
            
            jTextField15.setText(rs.getString("nationality"));
            jTextField16.setText(rs.getString("height"));
            jTextField17.setText(rs.getString("weight"));
            jTextField18.setText(rs.getString("mother"));
            jTextField19.setText(rs.getString("mother_occupation"));
            jTextField20.setText(rs.getString("number_mother"));
            jTextField21.setText(rs.getString("father_occupation"));
            jTextField22.setText(rs.getString("father"));
            jTextField23.setText(rs.getString("number_father"));
            jTextField24.setText(rs.getString("spouse"));
            jTextField25.setText(rs.getString("spouse_occupation"));
            jTextField26.setText(rs.getString("precint_number"));
            jLabel24.setText(rs.getString("age"));
            
            if(rs.getString("gender").equals("MALE")){
                jRadioButton1.setSelected(true);
            }else{
                jRadioButton2.setSelected(true);
            }

             switch(rs.getString("ext_name")){
                 case "JR":jComboBox1.setSelectedIndex(1);break;
                 case "SR":jComboBox1.setSelectedIndex(2);break;
                 case "I":jComboBox1.setSelectedIndex(3);break;
                 case "II":jComboBox1.setSelectedIndex(4);break;
                 case "III":jComboBox1.setSelectedIndex(5);break;
                 case "IV":jComboBox1.setSelectedIndex(6);break;
                 case "V":jComboBox1.setSelectedIndex(7);break;
                 default:jComboBox1.setSelectedIndex(0);
                 
             }
             
             String arr_month[] = {"MONTH","January","February","March","April","May","June","July","August","September","October","November","December"};
             
             for(int x=0;x<=12;x++){
                  if(rs.getString("month").equals(arr_month[x])){
                        jComboBox2.setSelectedIndex(x);
                        break;
                   }
             } 
             
           
              String arr_day[] = {"DAY","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
              for(int x=0;x<=31;x++){
                  if(rs.getString("day").equals(arr_day[x])){
                        jComboBox3.setSelectedIndex(x);
                        break;
                   }
             }
     
              String arr_year[] = {"YEAR","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019"};
              
             for(int x=0;x<=40;x++){
                  if(rs.getString("year").equals(arr_year[x])){
                        jComboBox4.setSelectedIndex(x);
                        break;
                   }
             }
        
    
             String preffix_number[] = {"PREFFIX","0929","0905","0922","0936","0916","0945","0999","0918","0975"};
             
             for(int x=0;x<=9;x++){
                  if(rs.getString("preffix_resident").equals(preffix_number[x])){
                        jComboBox5.setSelectedIndex(x);
                        break;
                   }
             }
            
             
             switch(rs.getString("registered_voter")){
                 case "YES":jComboBox6.setSelectedIndex(1);break;
                 case "NO":jComboBox6.setSelectedIndex(2);break;
                 default:jComboBox6.setSelectedIndex(0);
             }
           
             String arr_residency[] = {"NONE","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80"};
               for(int x=0;x<=80;x++){
                  if(rs.getString("residency").equals(arr_residency[x])){
                        jComboBox7.setSelectedIndex(x);
                        break;
                   }
            
             }

               String arr_civil[] = {"NONE","SINGLE","MARRIED","WIDOWER","LEGALLY SEPARATED","LIVE IN","DIVORCE"};
               
              for(int x=0;x<=7;x++){
                  if(rs.getString("civil_status").equals(arr_civil[x])){
                        jComboBox8.setSelectedIndex(x);
                        break;
                   }
            
             }
              
            
             for(int x=0;x<=9;x++){
                  if(rs.getString("preffix_mother").equals(preffix_number[x])){
                        jComboBox9.setSelectedIndex(x);
                        break;
                   }
            
             }
       String preffix_number_father[] = {"PREFFIX","0929","0905","0922","0936","0916","0945","0999","0918","0975"};
       
      // JOptionPane.showMessageDialog(null,rs.getString("preffix_father") );
       
       
            for(int x=0;x<=9;x++){
                  if(rs.getString("preffix_father").equals(preffix_number_father[x])){
                        jComboBox10.setSelectedIndex(x);
                        break;
                   }
            
             }
            
      
            String child[] ={"NONE","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22"}; 
             for(int x=0;x<=21;x++){
                  if(rs.getString("no_of_children").equals(child[x])){
                        jComboBox11.setSelectedIndex(x);
                        break;
                   }
            
             }
        }
        
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
        }
        
       }  
    }//GEN-LAST:event_jTextField27KeyReleased

    private void jPanel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel11MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel11MouseEntered

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseClicked

        String id_update = jTextField27.getText();
        
        if(id_update.isEmpty()){
            
            jLabel92.setText("PLEASE ENTER THE ID NUMBER");
            clear();
            
        }else{
        String lname = jTextField1.getText();
        String fname = jTextField2.getText();
        String mname = jTextField3.getText();
        String mother_name = jTextField18.getText();
        String father_name = jTextField22.getText(); 
        String month = (String) jComboBox2.getSelectedItem();
        String day = (String) jComboBox3.getSelectedItem();
        String year = (String) jComboBox4.getSelectedItem();
        String birthday = month +" "+day+" "+year;   
        
                      
        String place_birth = jTextField4.getText();
        String contact = jTextField5.getText();
        String house = jTextField6.getText();
        String lot = jTextField7.getText();
        String block = jTextField8.getText();
        String street = jTextField9.getText();
        String subdivision = jTextField10.getText();
        String barangay = jTextField11.getText();
        String municipality = jTextField12.getText();
        String province = jTextField13.getText();
        String country = jTextField14.getText();
        String nationality = jTextField15.getText();
        String height = jTextField16.getText();
        String weight = jTextField17.getText();
        
        String mother_occupation = jTextField19.getText();
        String mother_contact = jTextField20.getText();   
        String father_occupation = jTextField21.getText();
             
        String father_contact = jTextField23.getText();
        String name_spouse = jTextField24.getText();
        String spouse_occupation = jTextField25.getText();
        String precint = jTextField26.getText();
        String age =jLabel24.getText();
        
        
        String gender="";
        
        if(jRadioButton1.isSelected()){
            gender = "MALE";
        }
        if(jRadioButton2.isSelected()){
            gender = "FEMALE";
        }
        
        String ext_name = (String) jComboBox1.getSelectedItem();

        String contact_preffix = (String) jComboBox5.getSelectedItem();
        String voter = (String) jComboBox6.getSelectedItem();
        String recidency = (String) jComboBox7.getSelectedItem();
        String status = (String) jComboBox8.getSelectedItem();
        String mother_preffix = (String) jComboBox9.getSelectedItem();
        String father_preffix = (String) jComboBox10.getSelectedItem();
        String children = (String) jComboBox11.getSelectedItem();
        
       
     
     
     
        String contact_resident = contact_preffix + contact;
        String contact_mother_all = mother_preffix + mother_contact;
        String contact_father_all = father_preffix + father_contact;
        
        String address = house +" "+ lot +" "+block+" "+street+" "+ subdivision+" "+barangay+" "+municipality+" "+province+" "+country;
          
        LocalDate nowDate = LocalDate.now();
        String time = jLabel11.getText();
        String date_time = nowDate+" "+time;
        
        String fullname = "UPDATE INFORMATION "+lname+" "+fname+" "+mname;
        
         String label = "UPDATE SUCCESSFULLY";
         String create_date="";
         
         
         
         try{
           String query = "SELECT * FROM resident_information_tbl WHERE id_resident = '"+id_update+"' AND del=0";  
           
            st = conn.prepareStatement(query);
            rs=st.executeQuery(query);
                while(rs.next()){
                    create_date = rs.getString("date_created");

                }
         }catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
         }
         
         
         String sql = "UPDATE resident_information_tbl SET lastname='"+lname+"',firstname='"+fname+"',middlename='"+mname+"',ext_name='"+ext_name+"',gender='"+gender+"',place_of_birth='"+place_birth+"',date_of_birth='"+birthday+"',age='"+age+"',contact_number='"+contact_resident+"',registered_voter='"+voter+"',residency='"+recidency+"',complete_pernament='"+address+"',nationality='"+nationality+"',height='"+height+"',weight='"+weight+"',precint_number='"+precint+"',civil_status='"+status+"',mother='"+mother_name+"',mother_occupation='"+mother_occupation+"',mother_contact='"+contact_mother_all+"',father='"+father_name+"',father_occupation='"+father_occupation+"',father_contact='"+contact_father_all+"',spouse='"+name_spouse+"',spouse_occupation='"+spouse_occupation+"',no_of_children='"+children+"',date_created='"+create_date+"',month='"+month+"',day='"+day+"',year='"+year+"',preffix_resident='"+contact_preffix+"',number_resident='"+contact+"',house='"+house+"',lot='"+lot+"',block='"+block+"',street='"+street+"',subdivision='"+subdivision+"',barangay='"+barangay+"',municipality='"+municipality+"',province='"+province+"',country='"+country+"',preffix_mother='"+mother_preffix+"',number_mother='"+mother_contact+"',preffix_father='"+father_preffix+"',number_father='"+father_contact+"',date_updated='"+date_time+"' WHERE id_resident = '"+id_update+"'";
         
        connection(sql,label);
        
       String user = "user";
        
        String log_sql = "INSERT INTO log(date_log,time_log,action_log,user_log) VALUES('"+nowDate+"','"+time+"','"+fullname+"','"+user+"')";
        
        
     connection2(log_sql);
        
        }
       
        
        
    }//GEN-LAST:event_jPanel15MouseClicked

    private void jTextField29KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField29KeyReleased
      
        
       String search =  jTextField29.getText();
       String filter = (String) jComboBox13.getSelectedItem();
       String filter1 = filter.toLowerCase();
       
       if(search.equals("")){
            fetch_log();
       }else{

        try{
        String query = "Select * FROM log WHERE "+filter1+"='"+search+"'";
       // JOptionPane.showMessageDialog(null, filter1);
        
        st = conn.prepareStatement(query);
        rs=st.executeQuery();
        jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
        }
       }
    }//GEN-LAST:event_jTextField29KeyReleased

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
      
        char c=evt.getKeyChar();
        if(Character.isLetter(c)||Character.isISOControl(c)||Character.isWhitespace(c)){      
            jTextField1.setEditable(true);          
        }else{
          jTextField1.setEditable(false);   
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
         char c=evt.getKeyChar();
        if(Character.isLetter(c)||Character.isISOControl(c)||Character.isWhitespace(c)){      
            jTextField2.setEditable(true);          
        }else{
          jTextField2.setEditable(false);   
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        char c=evt.getKeyChar();
        if(Character.isLetter(c)||Character.isISOControl(c)||Character.isWhitespace(c)){      
            jTextField3.setEditable(true);          
        }else{
          jTextField3.setEditable(false);   
        }
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        char c=evt.getKeyChar();
        if(Character.isLetter(c)||Character.isISOControl(c)||Character.isWhitespace(c)){      
            jTextField4.setEditable(true);          
        }else{
          jTextField4.setEditable(false);   
        }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
        char c=evt.getKeyChar();
      boolean max = jTextField5.getText().length()>6;
      int choose = jComboBox5.getSelectedIndex();
      
      if(choose==0){
          jTextField5.setEditable(false); 
         
      }else{
               if(max){
         if(Character.isISOControl(c)){ 
           jTextField5.setEditable(true);      
        }else{
             jTextField5.setEditable(false); 
         }          
      }else{
         if(Character.isDigit(c)||Character.isISOControl(c)){ 
           jTextField5.setEditable(true);      
        }else{
          jTextField5.setEditable(false);   
        }  
      } 
      }
     

    }//GEN-LAST:event_jTextField5KeyPressed

    private void jTextField6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyPressed
       char c=evt.getKeyChar();
        if(Character.isDigit(c)||Character.isISOControl(c)){      
            jTextField6.setEditable(true);          
        }else{
          jTextField6.setEditable(false);   
        }
    }//GEN-LAST:event_jTextField6KeyPressed

    private void jTextField7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyPressed
            char c=evt.getKeyChar();
        if(Character.isDigit(c)||Character.isISOControl(c)){      
            jTextField7.setEditable(true);          
        }else{
          jTextField7.setEditable(false);   
        }
    }//GEN-LAST:event_jTextField7KeyPressed

    private void jTextField8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyPressed
              char c=evt.getKeyChar();
        if(Character.isDigit(c)||Character.isISOControl(c)){      
            jTextField8.setEditable(true);          
        }else{
          jTextField8.setEditable(false);   
        }
    }//GEN-LAST:event_jTextField8KeyPressed

    private void jTextField9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyPressed
            char c=evt.getKeyChar();
        if(Character.isLetter(c)||Character.isISOControl(c)||Character.isWhitespace(c)){      
            jTextField9.setEditable(true);          
        }else{
          jTextField9.setEditable(false);   
        }
    }//GEN-LAST:event_jTextField9KeyPressed

    private void jTextField10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField10KeyPressed
      char c=evt.getKeyChar();
        if(Character.isLetter(c)||Character.isISOControl(c)||Character.isWhitespace(c)){      
            jTextField10.setEditable(true);          
        }else{
          jTextField10.setEditable(false);   
        }
    }//GEN-LAST:event_jTextField10KeyPressed

    private void jTextField11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyPressed
         char c=evt.getKeyChar();
        if(Character.isLetterOrDigit(c)||Character.isISOControl(c)||Character.isWhitespace(c)){      
            jTextField11.setEditable(true);          
        }else{
          jTextField11.setEditable(false);   
        }
    }//GEN-LAST:event_jTextField11KeyPressed

    private void jTextField12KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyPressed
         char c=evt.getKeyChar();
        if(Character.isLetter(c)||Character.isISOControl(c)||Character.isWhitespace(c)){      
            jTextField12.setEditable(true);          
        }else{
          jTextField12.setEditable(false);   
        }
    }//GEN-LAST:event_jTextField12KeyPressed

    private void jTextField13KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyPressed
          char c=evt.getKeyChar();
        if(Character.isLetter(c)||Character.isISOControl(c)||Character.isWhitespace(c)){      
            jTextField13.setEditable(true);          
        }else{
          jTextField13.setEditable(false);   
        }
    }//GEN-LAST:event_jTextField13KeyPressed

    private void jTextField14KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField14KeyPressed
        char c=evt.getKeyChar();
        if(Character.isLetter(c)||Character.isISOControl(c)||Character.isWhitespace(c)){      
            jTextField14.setEditable(true);          
        }else{
          jTextField14.setEditable(false);   
        }
    }//GEN-LAST:event_jTextField14KeyPressed

    private void jTextField15KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField15KeyPressed
          char c=evt.getKeyChar();
        if(Character.isLetter(c)||Character.isISOControl(c)||Character.isWhitespace(c)){      
            jTextField15.setEditable(true);          
        }else{
          jTextField15.setEditable(false);   
        }
    }//GEN-LAST:event_jTextField15KeyPressed

    private void jTextField16KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField16KeyPressed
           char c=evt.getKeyChar();
        if(Character.isDigit(c)||Character.isISOControl(c)){      
            jTextField16.setEditable(true);          
        }else{
          jTextField16.setEditable(false);   
        }
    }//GEN-LAST:event_jTextField16KeyPressed

    private void jTextField17KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField17KeyPressed
         char c=evt.getKeyChar();
        if(Character.isDigit(c)||Character.isISOControl(c)){      
            jTextField17.setEditable(true);          
        }else{
          jTextField17.setEditable(false);   
        }
    }//GEN-LAST:event_jTextField17KeyPressed

    private void jTextField26KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField26KeyPressed
        char c=evt.getKeyChar();
        
        int try_vote = jComboBox6.getSelectedIndex();
        if(try_vote==0||try_vote==2){
            jTextField26.setEditable(false); 
        }else{
        if(Character.isLetterOrDigit(c)||Character.isISOControl(c)){      
          jTextField26.setEditable(true);          
        }else{
          jTextField26.setEditable(false);   
        }
        }

    }//GEN-LAST:event_jTextField26KeyPressed

    private void jTextField18KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField18KeyPressed
        char c=evt.getKeyChar();
        if(Character.isLetter(c)||Character.isISOControl(c)||Character.isWhitespace(c)){      
            jTextField18.setEditable(true);          
        }else{
          jTextField18.setEditable(false);   
        }
    }//GEN-LAST:event_jTextField18KeyPressed

    private void jTextField19KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField19KeyPressed
         char c=evt.getKeyChar();
        if(Character.isLetter(c)||Character.isISOControl(c)||Character.isWhitespace(c)){      
            jTextField19.setEditable(true);          
        }else{
          jTextField19.setEditable(false);   
        }
    }//GEN-LAST:event_jTextField19KeyPressed

    private void jTextField22KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField22KeyPressed
          char c=evt.getKeyChar();
        if(Character.isLetter(c)||Character.isISOControl(c)||Character.isWhitespace(c)){      
            jTextField22.setEditable(true);          
        }else{
          jTextField22.setEditable(false);   
        }
    }//GEN-LAST:event_jTextField22KeyPressed

    private void jTextField21KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField21KeyPressed
          char c=evt.getKeyChar();
        if(Character.isLetter(c)||Character.isISOControl(c)||Character.isWhitespace(c)){      
            jTextField21.setEditable(true);          
        }else{
          jTextField21.setEditable(false);   
        }
    }//GEN-LAST:event_jTextField21KeyPressed

    private void jTextField24KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField24KeyPressed
          char c=evt.getKeyChar();
        if(Character.isLetter(c)||Character.isISOControl(c)||Character.isWhitespace(c)){      
            jTextField24.setEditable(true);          
        }else{
          jTextField24.setEditable(false);   
        }
    }//GEN-LAST:event_jTextField24KeyPressed

    private void jTextField25KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField25KeyPressed
         char c=evt.getKeyChar();
        if(Character.isLetter(c)||Character.isISOControl(c)||Character.isWhitespace(c)){      
            jTextField25.setEditable(true);          
        }else{
          jTextField25.setEditable(false);   
        }
    }//GEN-LAST:event_jTextField25KeyPressed

    private void jTextField20KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField20KeyPressed
        char c=evt.getKeyChar();
      boolean max = jTextField20.getText().length()>6;
            int choose = jComboBox9.getSelectedIndex();
      
      if(choose==0){
          jTextField20.setEditable(false); 
         
      }else{
        if(max){
         if(Character.isISOControl(c)){ 
           jTextField20.setEditable(true);      
        }else{
             jTextField20.setEditable(false); 
         }          
      }else{
         if(Character.isDigit(c)||Character.isISOControl(c)){ 
           jTextField20.setEditable(true);      
        }else{
          jTextField20.setEditable(false);   
        }  
      }
      }

    }//GEN-LAST:event_jTextField20KeyPressed

    private void jTextField23KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField23KeyPressed
       char c=evt.getKeyChar();
      boolean max = jTextField23.getText().length()>6;
       int choose = jComboBox10.getSelectedIndex();
      
      if(choose==0){
          jTextField23.setEditable(false); 
          
      }else{
        if(max){
         if(Character.isISOControl(c)){ 
           jTextField23.setEditable(true);      
        }else{
             jTextField23.setEditable(false); 
         }          
      }else{
         if(Character.isDigit(c)||Character.isISOControl(c)){ 
           jTextField23.setEditable(true);      
        }else{
          jTextField23.setEditable(false);   
        }  
      }
      }

    }//GEN-LAST:event_jTextField23KeyPressed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
             
         int i = jTable3.getSelectedRow();
        
        TableModel model = jTable3.getModel();
        
        jLabel128.setText( model.getValueAt(i,0).toString());
        String fname = (String) model.getValueAt(i,1);
        String mname = (String) model.getValueAt(i,2);
        String lname = (String) model.getValueAt(i,3);
        String exname = (String) model.getValueAt(i,4);

        if(exname.equals("EXT")){
            exname="";
        }else{
            
        }
       jLabel129.setText(fname+", "+mname+", "+lname+" "+exname);
       
        jLabel130.setText((String) model.getValueAt(i,5));
        jLabel131.setText((String) model.getValueAt(i,6));
        jLabel132.setText((String) model.getValueAt(i,7));
        jLabel133.setText((String) model.getValueAt(i,8));
        jLabel134.setText((String) model.getValueAt(i,9));
        jLabel135.setText((String) model.getValueAt(i,10));
        jLabel136.setText((String) model.getValueAt(i,11));
        jLabel137.setText((String) model.getValueAt(i,12));
        jLabel138.setText((String) model.getValueAt(i,13));
        jLabel139.setText((String) model.getValueAt(i,14));
    }//GEN-LAST:event_jTable3MouseClicked

    private void kGradientPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_kGradientPanel8MouseClicked

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        jTabbedPane2.setSelectedIndex(0);
        jLabel166.setText("Barangay Clearance");
        
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton3MouseClicked
                  
    }//GEN-LAST:event_jRadioButton3MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        LocalDate nowDate = LocalDate.now();
        
        String fullname = jTextField30.getText();
        String age = jTextField31.getText();
        String address = jTextField32.getText();
         jLabel188.setText(""+nowDate);
        String date =jLabel188.getText()+" "+jLabel11.getText();
         
       
        
        
        
        
        if(jRadioButton3.isSelected()){
            
           new clearance(fullname,age,address,date).setVisible(true);
        }
        if(jRadioButton4.isSelected()){
            new clearance_indigent().setVisible(true);
        }
        if(jRadioButton5.isSelected()){
            new clearance_business().setVisible(true);
        }
        if(jRadioButton6.isSelected()){
            new clearance_idcard().setVisible(true);
        }
         
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        
        LocalDate nowDate = LocalDate.now();
        jLabel212.setText(""+nowDate);
        
        String fullname = jTextField33.getText();
        String birth= jTextField44.getText();
        String address = jTextField45.getText();
        String tin = jTextField46.getText();
        String sss = jTextField47.getText();
        String voter_no = jTextField48.getText();
        String precint = jTextField49.getText();
        String philhealth = jTextField50.getText();
        String pagibig = jTextField51.getText();
        String guardian = jTextField52.getText();
        String address_guardian = jTextField53.getText();
        String contact_guardian = jTextField54.getText();
        String date = jLabel212.getText();
        

        
        if(jRadioButton3.isSelected()){
            
           new clearance().setVisible(true);
        }
        if(jRadioButton4.isSelected()){
            new clearance_indigent().setVisible(true);
        }
        if(jRadioButton5.isSelected()){
            new clearance_business().setVisible(true);
        }
        if(jRadioButton6.isSelected()){
            new clearance_idcard(fullname,birth,address,tin,sss,voter_no,precint,philhealth,pagibig,guardian,address_guardian,contact_guardian,date).setVisible(true);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       
        LocalDate nowDate = LocalDate.now();
        
        String business = jTextField43.getText();
        String address = jTextField42.getText();
         jLabel192.setText(""+nowDate);
        String date =jLabel192.getText()+" "+jLabel11.getText();
        
        
        
        if(jRadioButton3.isSelected()){
            
           new clearance().setVisible(true);
        }
        if(jRadioButton4.isSelected()){
            new clearance_indigent().setVisible(true);
        }
        if(jRadioButton5.isSelected()){
            new clearance_business(business,address,date).setVisible(true);
        }
        if(jRadioButton6.isSelected()){
            new clearance_idcard().setVisible(true);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
     
         LocalDate nowDate = LocalDate.now(); 
        String guardian = jTextField38.getText();
        String guar_age = jTextField39.getText();
        String street_add = jTextField40.getText();
        String purpose = jTextField41.getText();
        
        
         
        String date =jLabel188.getText()+" "+jLabel11.getText();
        
        if(jRadioButton3.isSelected()){
            
           new clearance().setVisible(true);
        }
        if(jRadioButton4.isSelected()){
            new clearance_indigent(guardian,guar_age,street_add,purpose,date).setVisible(true);
        }
        if(jRadioButton5.isSelected()){
            new clearance_business().setVisible(true);
        }
        if(jRadioButton6.isSelected()){
            new clearance_idcard().setVisible(true);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
         jTabbedPane2.setSelectedIndex(2);
        jLabel166.setText("Barangay Business Permit");
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        jTabbedPane2.setSelectedIndex(3);
        jLabel166.setText("Barangay Identification Card ");
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jTextField55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField55ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField55ActionPerformed

    private void jTextField28KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField28KeyReleased
        // TODO add your handling code here:

        String search = jTextField28.getText();
        int x = jComboBox12.getSelectedIndex();

        if(x==7){

        }else{
            if(search.isEmpty()){

                try{
                    conn = DriverManager.getConnection(con,uname,pass);
                    fetch_dis();
                    // conn.close();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }

            }else if(search.equalsIgnoreCase(search)){
                try{

                    conn = DriverManager.getConnection(con,uname,pass);
                    searching(search);
                    //  conn.close();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }

            }
        }
    }//GEN-LAST:event_jTextField28KeyReleased

    private void jComboBox12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox12ActionPerformed
        // TODO add your handling code here:

        String search = jTextField28.getText();
        int index = jComboBox12.getSelectedIndex();
        if(index==0){
            jTextField28.setEditable(false);
            jTextField28.setText("");
        }else{
            if(search.isEmpty()){

                try{
                    conn = DriverManager.getConnection(con,uname,pass);
                    fetch_dis();
                    // conn.close();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }

            }else if(search.equalsIgnoreCase(search)){
                try{

                    conn = DriverManager.getConnection(con,uname,pass);
                    searching(search);
                    //  conn.close();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }

            }
        }

        int x = jComboBox12.getSelectedIndex();
        if(x==7){
            String filter1="YES";

            jTextField28.setEditable(false);
            try{
                String query = "Select id_resident, lastname, firstname, middlename, ext_name, gender,  date_of_birth, age, contact_number, registered_voter,complete_pernament, mother, father, date_created from resident_information_tbl WHERE registered_voter='"+filter1+"' AND del=0";
                // JOptionPane.showMessageDialog(null, filter1);
                st = conn.prepareStatement(query);
                rs=st.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));

            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
            jTextField28.setText("");
        }else{
            int a = jComboBox12.getSelectedIndex();
            if(a==0){
                jTextField28.setEditable(false);
                jTextField28.setText("");
            }else{
                jTextField28.setEditable(true);
            }
        }
    }//GEN-LAST:event_jComboBox12ActionPerformed

    private void jComboBox12MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox12MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox12MouseMoved

    private void jComboBox11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox11ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        jTabbedPane2.setSelectedIndex(1);
        jLabel166.setText("Barangay Indigency Clearance");
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jTextField34KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField34KeyReleased
        // TODO add your handling code here:

        String search = jTextField34.getText();
        int x = jComboBox14.getSelectedIndex();

        if(x==7){

        }else{
            if(search.isEmpty()){

                try{
                    conn = DriverManager.getConnection(con,uname,pass);
                    fetch_clearance();
                    // conn.close();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }

            }else if(search.equalsIgnoreCase(search)){
                try{

                    conn = DriverManager.getConnection(con,uname,pass);
                    searching_docu(search);
                    //  conn.close();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }

            }
        }
        
        
        
    }//GEN-LAST:event_jTextField34KeyReleased

    private void jComboBox14MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox14MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox14MouseMoved

    private void jComboBox14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox14ActionPerformed
        // TODO add your handling code here:

        String search = jTextField28.getText();
        int index = jComboBox12.getSelectedIndex();
        if(index==0){
            jTextField28.setEditable(false);
            jTextField28.setText("");
        }else{
            if(search.isEmpty()){

                try{
                    conn = DriverManager.getConnection(con,uname,pass);
                    fetch_dis();
                    // conn.close();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }

            }else if(search.equalsIgnoreCase(search)){
                try{

                    conn = DriverManager.getConnection(con,uname,pass);
                    searching(search);
                    //  conn.close();
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,e);
                }

            }
        }

        int x = jComboBox12.getSelectedIndex();
        if(x==7){
            String filter1="YES";

            jTextField28.setEditable(false);
            try{
                String query = "Select id_resident, lastname, firstname, middlename, ext_name, gender,  date_of_birth, age, contact_number, registered_voter,complete_pernament, mother, father, date_created from resident_information_tbl WHERE registered_voter='"+filter1+"' AND del=0";
                // JOptionPane.showMessageDialog(null, filter1);
                st = conn.prepareStatement(query);
                rs=st.executeQuery();
                jTable1.setModel(DbUtils.resultSetToTableModel(rs));

            }catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }
            jTextField28.setText("");
        }else{
            int a = jComboBox12.getSelectedIndex();
            if(a==0){
                jTextField28.setEditable(false);
                jTextField28.setText("");
            }else{
                jTextField28.setEditable(true);
            }
        }
    }//GEN-LAST:event_jComboBox14ActionPerformed

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
       
        
        
        
        int i = jTable5.getSelectedRow();

        TableModel model = jTable5.getModel();

        jLabel71.setText(model.getValueAt(i,0).toString());
        String fname = (String) model.getValueAt(i,1);
        String mname = (String) model.getValueAt(i,2);
        String lname = (String) model.getValueAt(i,3);
        String exname = (String) model.getValueAt(i,4);
        String date_of_birth = (String) model.getValueAt(i,5);
        String age = (String) model.getValueAt(i,6);
        String contact = (String) model.getValueAt(i,7);
        String house = (String) model.getValueAt(i,8);
        String lot= (String) model.getValueAt(i,9);
        String block = (String) model.getValueAt(i,10);
        String street = (String) model.getValueAt(i,11);
        String subdivision = (String) model.getValueAt(i,12);
        
          if(exname.equals("EXT")){
            exname="";
          }
    

        
        String fullname = fname+" "+mname+" "+lname;    
        String add = house+" "+lot+" "+block+" "+street+" "+subdivision;
        
        if(jRadioButton4.isSelected()){
             jTextField38.setText(""+fullname);
             jTextField39.setText(""+age);
             jTextField40.setText(""+add);
        }
        if(jRadioButton3.isSelected()){
            
            jTextField30.setText(""+fullname);
            jTextField31.setText(""+age);
            jTextField32.setText(""+add);
        }
        if(jRadioButton6.isSelected()){
            jTextField33.setText(""+fullname);
            jTextField44.setText(""+date_of_birth);
            jTextField45.setText(""+add);
        }

   
        
        

    }//GEN-LAST:event_jTable5MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox13;
    private javax.swing.JComboBox<String> jComboBox14;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel170;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel195;
    private javax.swing.JLabel jLabel196;
    private javax.swing.JLabel jLabel197;
    private javax.swing.JLabel jLabel198;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel212;
    private javax.swing.JLabel jLabel213;
    private javax.swing.JLabel jLabel214;
    private javax.swing.JLabel jLabel215;
    private javax.swing.JLabel jLabel216;
    private javax.swing.JLabel jLabel217;
    private javax.swing.JLabel jLabel218;
    private javax.swing.JLabel jLabel219;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel220;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel223;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel225;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField45;
    private javax.swing.JTextField jTextField46;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField54;
    private javax.swing.JTextField jTextField55;
    private javax.swing.JTextField jTextField56;
    private javax.swing.JTextField jTextField57;
    private javax.swing.JTextField jTextField58;
    private javax.swing.JTextField jTextField59;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField60;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel10;
    private keeptoo.KGradientPanel kGradientPanel11;
    private keeptoo.KGradientPanel kGradientPanel12;
    private keeptoo.KGradientPanel kGradientPanel13;
    private keeptoo.KGradientPanel kGradientPanel14;
    private keeptoo.KGradientPanel kGradientPanel15;
    private keeptoo.KGradientPanel kGradientPanel16;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel23;
    private keeptoo.KGradientPanel kGradientPanel24;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel5;
    private keeptoo.KGradientPanel kGradientPanel7;
    private keeptoo.KGradientPanel kGradientPanel8;
    private keeptoo.KGradientPanel kGradientPanel9;
    // End of variables declaration//GEN-END:variables
}
