/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loginandsignup;
import java.sql.Statement;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JFrame;
import loginandsignup.TableActionCellRender;
import javax.swing.JTable;
import java.sql.Time;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author LENOVO
 */
public class Quizzes extends javax.swing.JFrame {

    /**
     * Creates new form Quizzes
     */
    
    
    public void setadminname(String Text)
    {
        admin1.setText(Text);
    }
    String id;
    public String getid()
            {
                return id;
            }
      Quizsettings quiz = new Quizsettings();
      ViewQuiz v = new ViewQuiz();
    public Quizzes() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        Tableactionevent event =  new Tableactionevent(){
                
                    public void onEdit(int row)
                {
                    
                    quiz.setusername(Loginandsignup.name);
                     id = getTextAt(row, 1);
                    quiz.Setid(id);
                    String Title = getTextAt(row, 2);
                    quiz.Settitle(Title);
                    setquiz(id);
                    System.out.print(id);
                    quiz.setVisible(true);
                    dispose(); 
                    
                }
                       public void onDelete(int row) { 
        String quizId = getTextAt(row, 1);
        String confirmationMessage = "Are you sure you want to delete this quiz?";
        int option = JOptionPane.showConfirmDialog(null, confirmationMessage, "Confirmation", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            try {
                Connection connection = Connections.getConnection();
                Statement statement = connection.createStatement();

                String query = "DELETE FROM quiz WHERE quiz_id = '" + quizId + "'";
                int rowsDeleted = statement.executeUpdate(query);
                if (rowsDeleted > 0) {
                    DefaultTableModel model = (DefaultTableModel) Student_tale.getModel();
                    model.removeRow(row); // Remove the row from the table
                    JOptionPane.showMessageDialog(null, "Quiz deleted successfully.");
                } else {
                    JOptionPane.showMessageDialog(null, "Quiz deletion failed.");
                }
                statement.close();
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred while deleting the quiz.");
            }
        }
    }
                      public void onview(int row)
                      {
                           id = getTextAt(row, 1);
                           v.setid(id);
                           v.setuser(Loginandsignup.name);
                           v.addComponentsVertically();
                           v.setVisible(true);
                      }

            @Override
            public void onClick(int row) {
                
            }

            @Override
            public void onviewresult(int row) {
               
            }
                };
        Student_tale.getColumnModel().getColumn(3).setCellRenderer(new TableActionCellRender());
        Student_tale.getColumnModel().getColumn(3).setCellEditor(new TableActionCell(event));
        add();
    }
  public void dispose() {
    super.dispose();
}
    public String getTextAt(int rowIndex, int columnIndex) {
    if (Student_tale != null) {
        Object value = Student_tale.getValueAt(rowIndex, columnIndex);
        if (value != null) {
            return value.toString();
        }
    }
    return ""; // Default value if table is not set or cell value is null
}
  public void add() {
    // Get the quizzes ArrayList from Quiz1.Quizzes(Loginandsignup.name)
    ArrayList<String> quizzesList = Quiz1.Quizzes(Loginandsignup.name);

    // Get the existing DefaultTableModel from the JTable
    DefaultTableModel quizzesModel = (DefaultTableModel) Student_tale.getModel();

    // Clear existing rows from the table (optional)
    quizzesModel.setRowCount(0);

    // Populate the DefaultTableModel with data from the ArrayList
    for (int i = 0; i < quizzesList.size(); i += 3) {
        String quiz_id = quizzesList.get(i);
        int quiznos = Integer.parseInt(quizzesList.get(i + 1));
        String quiz_title = quizzesList.get(i + 2);
        Object[] rowData = {quiznos,quiz_id, quiz_title};
        quizzesModel.addRow(rowData);
    }
}
  
  
  protected void setquiz(String Quiz_id)
  {
      ArrayList<String> quizzes = Quiz1.QuizSetting(Loginandsignup.name,Quiz_id);
      int i=0;
      
          quiz.Setdesc(quizzes.get(i));
          quiz.SetMarks(quizzes.get(i+2));
          quiz.SetQuestiono(quizzes.get(i+3));
          
         try {
            Time sqlTime = Time.valueOf(quizzes.get(i + 1)); // Convert string to Time object
            LocalTime time = sqlTime.toLocalTime(); // Convert Time object to LocalTime

            int hours = time.getHour();
            int minutes = time.getMinute();
            int seconds = time.getSecond();

           

            quiz.Sethr(String.valueOf(hours));
            quiz.Setmin(String.valueOf(minutes));
            quiz.Setsec(String.valueOf(seconds));
        } catch (Exception e) {
            e.printStackTrace();
            // Handle parsing exception
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

        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        admin1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Student_tale = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel6.setBackground(new java.awt.Color(124, 131, 188));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_menu_48px_1.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("I");

        jLabel3.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("QUIZARDRY");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search_26px.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("I");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/group_message_26px.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("I");

        admin1.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        admin1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/male_user_50px.png"))); // NOI18N
        admin1.setText("   Hello , Admin");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(admin1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(admin1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Student_tale.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        Student_tale.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sr", "Quiz-id", "Quiz Title", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Student_tale.setRowHeight(50);
        Student_tale.setSelectionForeground(new java.awt.Color(255, 255, 255));
        Student_tale.setShowGrid(true);
        Student_tale.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Student_tale);
        if (Student_tale.getColumnModel().getColumnCount() > 0) {
            Student_tale.getColumnModel().getColumn(0).setPreferredWidth(30);
        }
        Student_tale.getAccessibleContext().setAccessibleName("");

        jPanel1.setBackground(new java.awt.Color(216, 205, 214));

        jButton1.setBackground(new java.awt.Color(216, 205, 214));
        jButton1.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/home-home-48.png"))); // NOI18N
        jButton1.setText("  Home page");
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton1.setDisabledSelectedIcon(null);
        jButton1.setInheritsPopupMenu(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(216, 205, 214));
        jButton2.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/set-up-manage-48.png"))); // NOI18N
        jButton2.setText(" Manage Quiz");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(216, 205, 214));
        jButton3.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user-add-12-32.png"))); // NOI18N
        jButton3.setText("  Add Students");
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(216, 205, 214));
        jButton4.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/result-1-32.png"))); // NOI18N
        jButton4.setText(" Result           ");
        jButton4.setBorder(null);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(248, 203, 173));
        jButton5.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/quiz (1).png"))); // NOI18N
        jButton5.setText("   Quizzes        ");
        jButton5.setBorder(null);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(124, 131, 188));
        jButton6.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logout-36-32.png"))); // NOI18N
        jButton6.setText("Logout");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Quiz q = new Quiz();
        q.setusername(Loginandsignup.name);
        q.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        AddStudent studentframe =  new AddStudent();
        studentframe.setadminname(Loginandsignup.name);
        studentframe.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       Admin_Result Ar1 = new Admin_Result();
        Ar1.setadminname(Loginandsignup.name);
        Ar1.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Quizzes quizframe =  new Quizzes();
        quizframe.setadminname(Loginandsignup.name);
        quizframe.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      Admindashboard Adminframe =  new Admindashboard();
      Adminframe.setadminname(Loginandsignup.name);
      Adminframe.setStudents(Loginandsignup.no1);
      Adminframe.setQuizzes(Loginandsignup.no2);
      Adminframe.setEmail(Loginandsignup.Email);
      Adminframe.setQuiztitle(Loginandsignup.quiz);
      Adminframe.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       home h1 = new home();
       h1.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(Quizzes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quizzes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quizzes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quizzes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quizzes().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Student_tale;
    private javax.swing.JLabel admin1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    
}
