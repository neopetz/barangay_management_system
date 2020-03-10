
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
public class admin extends javax.swing.JFrame {

    /**
     * Creates new form index
     */
    
     Connection conn;
    PreparedStatement st;
    ResultSet rs;
    private static final String uname="root";
    private static final String pass="";
    private static final String con="jdbc:mysql://localhost:3306/barangay_management_system";
  
    public admin() {
        initComponents();
        
      jTable1.setShowVerticalLines(false); 
     jTable1.setRowHeight(75); 
     jTable1.setSelectionBackground(Color.blue); 
     jTable2.setShowVerticalLines(false); 
     jTable2.setRowHeight(75); 
     jTable2.setSelectionBackground(Color.blue); 
     jTable3.setShowVerticalLines(false); 
     jTable3.setRowHeight(75); 
     jTable3.setSelectionBackground(Color.blue); 
        user();
        
        
        
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
        
    }
    
    
            public void archive(){
         try{
        String query = "SELECT id_resident, lastname, firstname, middlename, ext_name, gender,  date_of_birth, age, contact_number, registered_voter,complete_pernament, mother, father, date_created,date_deleted FROM resident_information_tbl WHERE del=0 ORDER BY id_resident ";
        st = conn.prepareStatement(query);
        rs=st.executeQuery();
        jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
        }
        }
            
                       public void retrive(){
         try{
        String query = "SELECT id_resident, lastname, firstname, middlename, ext_name, gender,  date_of_birth, age, contact_number, registered_voter,complete_pernament, mother, father, date_created,date_deleted FROM resident_information_tbl WHERE del=1 ORDER BY id_resident ";
        st = conn.prepareStatement(query);
        rs=st.executeQuery();
        jTable3.setModel(DbUtils.resultSetToTableModel(rs));
        
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
    
    
        public void connection(String sql,String label){
        
                  try{
            conn = DriverManager.getConnection(con,uname,pass);
          // JOptionPane.showMessageDialog(null,"CONNECTED");    
          Statement state = conn.createStatement();
          state.executeUpdate(sql);
          JOptionPane.showMessageDialog(null,""+label);
          user();
          fetch_dis();
         // conn.close();
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
        }
    }
        
        
     public void user(){
     
        
        try{
          conn = DriverManager.getConnection(con,uname,pass);
        String query = "Select id_employee,username,password,account_type,firstname,lastname from login_tbl WHERE id_employee >=1 ORDER BY id_employee";
        st = conn.prepareStatement(query);
        rs=st.executeQuery();
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
        }
    }
     
     
     public void clear(){
         
         jTextField5.setText("");
         jTextField2.setText("");
         jPasswordField1.setText("");
         jTextField4.setText("");
         jTextField3.setText("");
     }
     
     
     
             public void connection2(String sql){
        
                  try{
            conn = DriverManager.getConnection(con,uname,pass);
          //JOptionPane.showMessageDialog(null,"CONNECTED");    
          Statement state = conn.createStatement();
          state.executeUpdate(sql);
        //  conn.close();
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"con2222222222"+e);
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
        jLabel29 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        kGradientPanel1 = new keeptoo.KGradientPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        kGradientPanel4 = new keeptoo.KGradientPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        kGradientPanel9 = new keeptoo.KGradientPanel();
        jLabel20 = new javax.swing.JLabel();
        kGradientPanel10 = new keeptoo.KGradientPanel();
        jLabel21 = new javax.swing.JLabel();
        kGradientPanel11 = new keeptoo.KGradientPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        kGradientPanel5 = new keeptoo.KGradientPanel();
        jComboBox3 = new javax.swing.JComboBox<>();
        kGradientPanel13 = new keeptoo.KGradientPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        kGradientPanel6 = new keeptoo.KGradientPanel();
        kGradientPanel7 = new keeptoo.KGradientPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTextField28 = new javax.swing.JTextField();
        jLabel224 = new javax.swing.JLabel();
        jComboBox12 = new javax.swing.JComboBox<>();
        jLabel60 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        kGradientPanel8 = new keeptoo.KGradientPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        kGradientPanel12 = new keeptoo.KGradientPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
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
        jPanel16 = new javax.swing.JPanel();
        jLabel140 = new javax.swing.JLabel();
        kGradientPanel3 = new keeptoo.KGradientPanel();
        jLabel56 = new javax.swing.JLabel();
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
        jLabel91 = new javax.swing.JLabel();

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/2_Hot_Home_Icon_48.png"))); // NOI18N
        jLabel1.setText(" HOME");
        jLabel1.setToolTipText("");
        jLabel1.setAlignmentX(0.5F);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
        );

        kGradientPanel2.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 277, -1, -1));

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
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Usergroup_Icon_48.png"))); // NOI18N
        jLabel2.setText("USER INFO");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 50));

        kGradientPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 353, 270, 71));

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
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/User_Group_Icon_48.png"))); // NOI18N
        jLabel3.setText("CHANGE ORGANIZATION");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        kGradientPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 431, 270, 60));

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
        jLabel4.setText("ARCHIVE RESIDENT");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(74, 74, 74))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        );

        kGradientPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 504, 270, 59));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/menu (1).png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        kGradientPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, -1, 60));

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

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Log_Out_Icon_48.png"))); // NOI18N
        jLabel8.setText("RETRIVE RESIDENT");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(134, 134, 134))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        kGradientPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 576, 270, 60));

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
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Sign_Shutdown_Icon_48.png"))); // NOI18N
        jLabel9.setText("SIGN - OUT");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(107, 107, 107))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
        );

        kGradientPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 649, 270, -1));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/AAA.png"))); // NOI18N
        kGradientPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 160, 160));

        jPanel1.add(kGradientPanel2);
        kGradientPanel2.setBounds(0, 37, 270, 890);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("X");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7);
        jLabel7.setBounds(1660, 10, 20, 20);

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

        jPanel1.add(kGradientPanel1);
        kGradientPanel1.setBounds(-6, 37, 1700, 70);

        kGradientPanel4.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel4.setkStartColor(new java.awt.Color(0, 51, 51));
        kGradientPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_NUMBER", "USERNAME", "PASSWORD", "ACCOUNT_TYPE", "FIRSTNAME", "LASTNAME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        kGradientPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 1350, 280));
        kGradientPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 240, 40));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "USERNAME", "LASTNAME", "FIRSTNAME" }));
        kGradientPanel4.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 150, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("ID NUMBER");
        kGradientPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 120, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel13.setText("USERNAME");
        kGradientPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("PASSWORD");
        kGradientPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 590, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("FIRSTNAME");
        kGradientPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 580, -1, 40));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("LASTNAME");
        kGradientPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, 110, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("ACCOUNT TYPE");
        kGradientPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(688, 430, 130, 30));

        jTextField2.setBackground(new java.awt.Color(255,255,255,100));
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        kGradientPanel4.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 500, 200, 40));

        jPasswordField1.setBackground(new java.awt.Color(255,255,255,100));
        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        kGradientPanel4.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 580, 200, 40));

        jTextField3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        kGradientPanel4.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 580, 200, 40));

        jTextField4.setBackground(new java.awt.Color(255,255,255,100));
        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        kGradientPanel4.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 500, 200, 40));

        jComboBox2.setBackground(new java.awt.Color(255,255,255,100));
        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USER", "ADMIN" }));
        kGradientPanel4.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 420, 200, 40));

        kGradientPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        kGradientPanel9.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel9.setkStartColor(new java.awt.Color(0, 153, 0));
        kGradientPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kGradientPanel9MouseClicked(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Add_Male_User_Icon_48.png"))); // NOI18N
        jLabel20.setText("ADD USER");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel9Layout = new javax.swing.GroupLayout(kGradientPanel9);
        kGradientPanel9.setLayout(kGradientPanel9Layout);
        kGradientPanel9Layout.setHorizontalGroup(
            kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel9Layout.createSequentialGroup()
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );
        kGradientPanel9Layout.setVerticalGroup(
            kGradientPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kGradientPanel9Layout.createSequentialGroup()
                .addComponent(jLabel20)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        kGradientPanel4.add(kGradientPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 730, 160, 50));

        kGradientPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        kGradientPanel10.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel10.setkStartColor(new java.awt.Color(0, 0, 153));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Edit_Male_User_Icon_48.png"))); // NOI18N
        jLabel21.setText("UPDATE USER");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel10Layout = new javax.swing.GroupLayout(kGradientPanel10);
        kGradientPanel10.setLayout(kGradientPanel10Layout);
        kGradientPanel10Layout.setHorizontalGroup(
            kGradientPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 156, Short.MAX_VALUE)
            .addGroup(kGradientPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel21)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        kGradientPanel10Layout.setVerticalGroup(
            kGradientPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
            .addGroup(kGradientPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel10Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel21)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        kGradientPanel4.add(kGradientPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 730, 160, 50));

        kGradientPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        kGradientPanel11.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel11.setkStartColor(new java.awt.Color(153, 0, 0));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Remove_Male_User_Icon_48.png"))); // NOI18N
        jLabel22.setText("DELETE USER");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel11Layout = new javax.swing.GroupLayout(kGradientPanel11);
        kGradientPanel11.setLayout(kGradientPanel11Layout);
        kGradientPanel11Layout.setHorizontalGroup(
            kGradientPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
            .addGroup(kGradientPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(kGradientPanel11Layout.createSequentialGroup()
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        kGradientPanel11Layout.setVerticalGroup(
            kGradientPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
            .addGroup(kGradientPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel11Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        kGradientPanel4.add(kGradientPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 730, 160, 50));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search_Icon_48.png"))); // NOI18N
        kGradientPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 60, 50));

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        kGradientPanel4.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, 200, 40));

        jTabbedPane1.addTab("tab2", kGradientPanel4);

        kGradientPanel5.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel5.setkStartColor(new java.awt.Color(0, 51, 51));
        kGradientPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SEARCH BY POSITION", "CHAIRMAIN", "1ST KAGAWAD", "2ND  KAGAWAD", "3RD  KAGAWAD", "4TH  KAGAWAD", "5TH  KAGAWAD", "6TH  KAGAWAD", "7TH  KAGAWAD" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        kGradientPanel5.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 60, 210, 40));

        kGradientPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        kGradientPanel13.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel13.setkStartColor(new java.awt.Color(0, 0, 153));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Edit_Male_User_Icon_48.png"))); // NOI18N
        jLabel24.setText("UPDATE RECORD");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel24MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout kGradientPanel13Layout = new javax.swing.GroupLayout(kGradientPanel13);
        kGradientPanel13.setLayout(kGradientPanel13Layout);
        kGradientPanel13Layout.setHorizontalGroup(
            kGradientPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
        );
        kGradientPanel13Layout.setVerticalGroup(
            kGradientPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
        );

        kGradientPanel5.add(kGradientPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 620, 230, 60));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel25.setText("Firstname          :");
        kGradientPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, -1));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel26.setText("Middlename       :");
        kGradientPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel27.setText("Lastname          :");
        kGradientPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, -1, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel28.setText("Age                 :");
        kGradientPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 530, 150, 30));

        jTextField6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        kGradientPanel5.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 250, 210, 40));

        jTextField7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        kGradientPanel5.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 340, 210, 40));

        jTextField8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        kGradientPanel5.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 430, 210, 40));

        jTextField9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        kGradientPanel5.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 510, 210, 40));

        jTabbedPane1.addTab("tab3", kGradientPanel5);

        javax.swing.GroupLayout kGradientPanel6Layout = new javax.swing.GroupLayout(kGradientPanel6);
        kGradientPanel6.setLayout(kGradientPanel6Layout);
        kGradientPanel6Layout.setHorizontalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1405, Short.MAX_VALUE)
        );
        kGradientPanel6Layout.setVerticalGroup(
            kGradientPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", kGradientPanel6);

        kGradientPanel7.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel7.setkStartColor(new java.awt.Color(0, 51, 51));
        kGradientPanel7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                kGradientPanel7MouseMoved(evt);
            }
        });
        kGradientPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_NUMBER", "FIRSTNAME", "MIDDLENAME", "LASTNAME", "EXT_NAME", "GENDER", "DATE_OF_BIRTH", "AGE", "CONTACT_NUMBER", "VOTER", "ADDRESS", "MOTHER", "FATHER", "DATE_CREATED", "DATE_UPDATED"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        kGradientPanel7.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1390, 380));

        jTextField28.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jTextField28.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField28KeyReleased(evt);
            }
        });
        kGradientPanel7.add(jTextField28, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 180, 30));

        jLabel224.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search_Icon_32.png"))); // NOI18N
        kGradientPanel7.add(jLabel224, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 29, 26, 31));

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
        kGradientPanel7.add(jComboBox12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 240, 30));

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel60.setText("ID NUMBER             :");
        kGradientPanel7.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, -1, 30));

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel7.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 496, 160, 20));

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel61.setText("FULLNAME               :");
        kGradientPanel7.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 550, -1, 30));

        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel7.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 556, 240, 20));

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel62.setText("GENDER                   :");
        kGradientPanel7.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 600, 180, 30));

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel7.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 606, 230, 20));

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel63.setText("DATE OF BIRTH      :");
        kGradientPanel7.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 650, -1, 30));

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel7.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 656, 220, 20));

        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel64.setText("AGE                           :");
        kGradientPanel7.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 700, 180, 30));

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel7.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 706, 210, 20));

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel65.setText("CONTACT NUMBER  :");
        kGradientPanel7.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 750, 190, 30));

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel7.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 756, 220, 20));

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel66.setText("REGISTERED VOTER           :");
        kGradientPanel7.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 490, 260, 30));

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel7.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 500, 260, 20));

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel67.setText("PERNAMENT ADDRESS      :");
        kGradientPanel7.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 550, 250, 30));

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel7.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 560, 500, 20));

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel68.setText("NAME OF MOTHER              :");
        kGradientPanel7.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 600, 250, 30));

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel7.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 610, 360, 20));

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel69.setText("NAME OF FATHER               :");
        kGradientPanel7.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 650, 250, 30));

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel7.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 660, 320, 20));

        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel70.setText(" DATE CREATED                  :");
        kGradientPanel7.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 700, 250, 30));

        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel7.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 710, 320, 20));

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel93.setText(" DATE UPDATED                  :");
        kGradientPanel7.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 750, 250, 30));

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        kGradientPanel7.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 760, 270, 20));

        jPanel13.setBackground(new java.awt.Color(153, 0, 0));
        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel13MouseClicked(evt);
            }
        });

        jLabel115.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(255, 255, 255));
        jLabel115.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Remove_Male_User_Icon_48.png"))); // NOI18N
        jLabel115.setText("ARCHIVE DATA");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel115)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel115)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        kGradientPanel7.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 760, 180, -1));

        jTabbedPane1.addTab("tab5", kGradientPanel7);

        kGradientPanel8.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel8.setkStartColor(new java.awt.Color(0, 51, 51));
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

        kGradientPanel8.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1400, -1));

        kGradientPanel12.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel12.setkStartColor(new java.awt.Color(0, 51, 51));
        kGradientPanel12.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                kGradientPanel12MouseMoved(evt);
            }
        });
        kGradientPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kGradientPanel12MouseClicked(evt);
            }
        });
        kGradientPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "FIRSTNAME", "MIDDLENAME", "LASTNAME", "EXTNAME", "GENDER", "DATE_OF_BIRTH", "AGE", "CONTACT_NUMBER", "VOTER", "ADDRESS", "MOTHER", "FATHER", "DATE_CREATED", "DATE_DELETED"
            }
        ));
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        kGradientPanel12.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1400, -1));

        jLabel116.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel116.setText("ID NUMBER           :");
        kGradientPanel12.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, -1, -1));

        jLabel117.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel117.setText("FULLNAME             :");
        kGradientPanel12.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 580, -1, -1));

        jLabel118.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel118.setText("GENDER                 :");
        kGradientPanel12.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 630, -1, -1));

        jLabel119.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel119.setText("DATE_OF_BIRTH  :");
        kGradientPanel12.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 680, -1, -1));

        jLabel120.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel120.setText("AGE                         :");
        kGradientPanel12.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 730, -1, -1));

        jLabel121.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel121.setText("CONTACT               :");
        kGradientPanel12.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 780, -1, -1));

        jLabel122.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel122.setText("REGISTERED VOTER      :");
        kGradientPanel12.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 540, -1, -1));

        jLabel123.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel123.setText("PERNAMENT ADDRESS  :");
        kGradientPanel12.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 590, -1, -1));

        jLabel124.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel124.setText("MOTHER                           :");
        kGradientPanel12.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 630, -1, -1));

        jLabel125.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel125.setText("FATHER                            :");
        kGradientPanel12.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 680, -1, -1));

        jLabel126.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel126.setText("DATE_CREATED              :");
        kGradientPanel12.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 730, -1, -1));

        jLabel127.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel127.setText("DATE_DELETED              :");
        kGradientPanel12.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 780, -1, -1));

        jLabel128.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel12.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 540, 130, 30));

        jLabel129.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel12.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 580, 400, 30));

        jLabel130.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel12.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 630, 140, 30));

        jLabel131.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel12.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 680, 230, 30));

        jLabel132.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel12.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 730, 90, 30));

        jLabel133.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel12.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 780, 250, 30));

        jLabel134.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel12.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 540, 190, 30));

        jLabel135.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel12.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 580, 430, 30));

        jLabel136.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel12.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 630, 380, 30));

        jLabel137.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel12.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 680, 370, 30));

        jLabel138.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel12.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 730, 300, 30));

        jLabel139.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        kGradientPanel12.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 780, 200, 30));

        jPanel16.setBackground(new java.awt.Color(0, 153, 0));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel16MouseEntered(evt);
            }
        });

        jLabel140.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel140.setForeground(new java.awt.Color(255, 255, 255));
        jLabel140.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/User_mapping_Icon_48.png"))); // NOI18N
        jLabel140.setText("RETRIVE DATA");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel140, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel140))
        );

        kGradientPanel12.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 770, 170, 50));

        kGradientPanel8.add(kGradientPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.addTab("tab6", kGradientPanel8);

        kGradientPanel3.setkEndColor(new java.awt.Color(255, 255, 255));
        kGradientPanel3.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/123.jpg"))); // NOI18N
        kGradientPanel3.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(321, 48, -1, -1));

        jTabbedPane1.addTab("tab1", kGradientPanel3);

        jPanel1.add(jTabbedPane1);
        jTabbedPane1.setBounds(280, 60, 1410, 860);

        jLabel14.setText("jLabel14");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14);
        jLabel14.setBounds(1590, 10, 48, 16);

        jLabel82.setForeground(new java.awt.Color(255, 255, 255));
        jLabel82.setText("BARANGAY POPULATION");
        jPanel1.add(jLabel82);
        jLabel82.setBounds(60, 180, 140, 16);

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(255, 255, 255));
        jLabel83.setText("0");
        jPanel1.add(jLabel83);
        jLabel83.setBounds(100, 216, 60, 30);

        jLabel84.setForeground(new java.awt.Color(255, 255, 255));
        jLabel84.setText("NUMBER OF REGISTERED VOTER");
        jLabel84.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jLabel84);
        jLabel84.setBounds(40, 270, 190, 16);

        jLabel85.setForeground(new java.awt.Color(255, 255, 255));
        jLabel85.setText("jLabel85");
        jPanel1.add(jLabel85);
        jLabel85.setBounds(100, 310, 48, 16);

        jLabel86.setForeground(new java.awt.Color(255, 255, 255));
        jLabel86.setText("NUMBER OF NON VOTERS");
        jPanel1.add(jLabel86);
        jLabel86.setBounds(50, 370, 160, 20);

        jLabel87.setForeground(new java.awt.Color(255, 255, 255));
        jLabel87.setText("jLabel87");
        jPanel1.add(jLabel87);
        jLabel87.setBounds(100, 420, 48, 16);

        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setText("NUMBER OF BLOTTER");
        jPanel1.add(jLabel88);
        jLabel88.setBounds(50, 476, 160, 20);

        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setText("jLabel89");
        jPanel1.add(jLabel89);
        jLabel89.setBounds(90, 520, 48, 16);

        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setText("DATE");
        jPanel1.add(jLabel90);
        jLabel90.setBounds(90, 600, 80, 30);

        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setText("jLabel91");
        jPanel1.add(jLabel91);
        jLabel91.setBounds(80, 650, 48, 16);

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
            new home().setVisible(true);
            dispose();
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
        jTabbedPane1.setSelectedIndex(5);
        jLabel12.setText("RETRIVE RESIDENT ");
        retrive();
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
        jTabbedPane1.setSelectedIndex(4);
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
        jLabel12.setText("CHANGE ORGANIZATION");
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
        jLabel12.setText("ADD/UPDATE/DELETE USER");
        user();
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

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        // TODO add your handling code here:
        
        
        
    }//GEN-LAST:event_jPanel1MouseMoved

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        archive();
        fetch_dis();
    }//GEN-LAST:event_formWindowOpened

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        LocalDate nowDate = LocalDate.now();
        String id = jTextField5.getText();
        String username = jTextField2.getText();
        String password = jPasswordField1.getText();
        int account_type = jComboBox2.getSelectedIndex();
        String lastname= jTextField4.getText();
        String firstname = jTextField3.getText();
        
        String sql = "INSERT INTO login_tbl(ID_EMPLOYEE,USERNAME,PASSWORD,ACCOUNT_TYPE,DATE_CREATED,LASTNAME,FIRSTNAME)VALUES('"+id+"','"+username+"','"+password+"','"+account_type+"','"+nowDate+"','"+lastname+"','"+firstname+"')";
        String label = "SUCCESSFULLY CREATED";
        
        connection(sql,label);
        clear();
    }//GEN-LAST:event_jLabel20MouseClicked

    private void kGradientPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel9MouseClicked

    }//GEN-LAST:event_kGradientPanel9MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked



    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
                             
         int i = jTable1.getSelectedRow();
        
        TableModel model = jTable1.getModel();
        
        jTextField5.setText( model.getValueAt(i,0).toString());

        jTextField2.setText((String) model.getValueAt(i,1));
        jPasswordField1.setText((String) model.getValueAt(i,2));
       
        String a = (String) model.getValueAt(i,3);
        if(a.equals("0")){
            jComboBox2.setSelectedIndex(0);
        }else{
            jComboBox2.setSelectedIndex(1);
        }
       
        jTextField3.setText((String) model.getValueAt(i,4));
        jTextField4.setText((String) model.getValueAt(i,5));
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
     
     String id = jTextField5.getText();
     String username = jTextField2.getText();
     String pass = jPasswordField1.getText();
     int account = jComboBox2.getSelectedIndex();
     String lastname = jTextField4.getText();
     String firstname = jTextField3.getText();
        
        String sql = "UPDATE login_tbl SET username='"+username+"',password='"+pass+"',account_type='"+account+"',lastname='"+lastname+"',firstname='"+firstname+"' WHERE id_employee='"+id+"'";
        String label="SUCCESSFULLY UPDATED";
        
        connection(sql,label);
        clear();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
       
        
        
               String id = jTextField5.getText();

        if(id.isEmpty()){
            JOptionPane.showMessageDialog(null,"PLEASE SELECT IN DATA A TABLE");
        }else{

            LocalDate nowDate = LocalDate.now();
            String time = jLabel11.getText();
            String fullname = "DELETE DATA"+jTextField2.getText();

            int confirm = JOptionPane.showConfirmDialog(this, "Are You Sure Want to Delete ? ","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

            if(confirm==JOptionPane.YES_OPTION){
                String sql = "UPDATE login_tbl SET del=1 WHERE id_employee='"+id+"'";
                String label = "DATA DELETED SUCCESSFULLY";

                connection(sql,label);
                String log_sql = "INSERT INTO log (date_log,time_log,action_log,user_log) VALUES('"+nowDate+"','"+time+"','"+fullname+"','ADMIN')";
                  connection2(log_sql);
                  
                  clear();
            }else{

            }

        }
    }//GEN-LAST:event_jLabel22MouseClicked

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
       
        String position = jComboBox3.getSelectedItem().toString();
        
         try{
           conn = DriverManager.getConnection(con,uname,pass);
        String query = "Select * from official WHERE POSITION='"+position+"'";
        st = conn.prepareStatement(query);  
        rs=st.executeQuery(query);
        
         while(rs.next()){
         jTextField6.setText(rs.getString("name"));
         jTextField7.setText(rs.getString("middlename"));
         jTextField8.setText(rs.getString("lastname"));
         jTextField9.setText(rs.getString("age"));
         }
  
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,e);
        }
        
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jLabel24MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseClicked
        
        String position = jComboBox3.getSelectedItem().toString();
        
        String name= jTextField6.getText();
        String middlename = jTextField7.getText();
        String lastname = jTextField8.getText();
        String age = jTextField9.getText();
        
        String sql = "UPDATE official SET name='"+name+"',middlename='"+middlename+"',lastname='"+lastname+"',age='"+age+"' WHERE POSITION='"+position+"'";
        String label = "SUCCESSFULLY UPDATED RECORD";
        
        connection(sql,label);
        
    }//GEN-LAST:event_jLabel24MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:

        int i = jTable2.getSelectedRow();

        TableModel model = jTable2.getModel();

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

    }//GEN-LAST:event_jTable2MouseClicked

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

    private void jComboBox12MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox12MouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox12MouseMoved

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

    private void jPanel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel13MouseClicked

        String id = jLabel71.getText();

        if(id.isEmpty()){
            JOptionPane.showMessageDialog(null,"PLEASE SELECT IN DATA A TABLE");
        }else{

            LocalDate nowDate = LocalDate.now();
            String time = jLabel11.getText();
            String fullname = "DELETE DATA"+jLabel72.getText();

            int confirm = JOptionPane.showConfirmDialog(this, "Are You Sure Want to Delete ? ","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

            if(confirm==JOptionPane.YES_OPTION){
                String sql = "UPDATE resident_information_tbl SET del=1,date_deleted='"+nowDate+"' WHERE id_resident='"+id+"'";
                String label = "DATA DELETED SUCCESSFULLY";

                connection(sql,label);
                 fetch_dis();
                String log_sql = "INSERT INTO log (date_log,time_log,action_log,user_log) VALUES('"+nowDate+"','"+time+"','"+fullname+"','user')";
                connection2(log_sql);
                clear();
            }else{

            }

        }
    }//GEN-LAST:event_jPanel13MouseClicked

    private void kGradientPanel7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel7MouseMoved
       archive();
    }//GEN-LAST:event_kGradientPanel7MouseMoved

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

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked

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
    }//GEN-LAST:event_jTable4MouseClicked

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked

        String id = jLabel128.getText();

        if(id.isEmpty()){
            JOptionPane.showMessageDialog(null,"PLEASE SELECT IN DATA A TABLE");
        }else{

            LocalDate nowDate = LocalDate.now();
            String time = jLabel11.getText();
            String fullname = "RETRIVE DATA"+jLabel129.getText();

            int confirm = JOptionPane.showConfirmDialog(this, "Are You Sure Want to Retrive Data ? ","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

            if(confirm==JOptionPane.YES_OPTION){
                String sql = "UPDATE resident_information_tbl SET del=0 WHERE id_resident='"+id+"'";
                String label = "DATA RETRIVED SUCCESSFULLY";
          
                connection(sql,label);
                retrive();
                String log_sql = "INSERT INTO log (date_log,time_log,action_log,user_log) VALUES('"+nowDate+"','"+time+"','"+fullname+"','user')";
                connection2(log_sql);

                clear();
            }else{

            }
        }
    }//GEN-LAST:event_jPanel16MouseClicked

    private void jPanel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseEntered

    private void kGradientPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_kGradientPanel12MouseClicked

    private void kGradientPanel12MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kGradientPanel12MouseMoved
        retrive();
    }//GEN-LAST:event_kGradientPanel12MouseMoved

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
                new admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel115;
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
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel56;
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
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private keeptoo.KGradientPanel kGradientPanel1;
    private keeptoo.KGradientPanel kGradientPanel10;
    private keeptoo.KGradientPanel kGradientPanel11;
    private keeptoo.KGradientPanel kGradientPanel12;
    private keeptoo.KGradientPanel kGradientPanel13;
    private keeptoo.KGradientPanel kGradientPanel2;
    private keeptoo.KGradientPanel kGradientPanel3;
    private keeptoo.KGradientPanel kGradientPanel4;
    private keeptoo.KGradientPanel kGradientPanel5;
    private keeptoo.KGradientPanel kGradientPanel6;
    private keeptoo.KGradientPanel kGradientPanel7;
    private keeptoo.KGradientPanel kGradientPanel8;
    private keeptoo.KGradientPanel kGradientPanel9;
    // End of variables declaration//GEN-END:variables
}
