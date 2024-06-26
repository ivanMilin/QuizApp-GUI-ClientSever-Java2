/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quizclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;

/**
 *
 * @author Ivan Milin
 */
public class QuizClient extends javax.swing.JFrame {
    
    private Socket socket;
    private BufferedReader br;
    private PrintWriter pw;
    private RecieveMessageFromServer rmfs;
    private String usernameFromTextField;
    
    private int loginNumber = 0;
    
    AdminGUI adminGUI;
    ContestantGUI contestantGUI;
    ArrayList<QuizMemberClient> activeMembers;
    ArrayList<String> presentMembers;
    ArrayList<String> questionAndAnswers;
    ArrayList<String> scoreboardUsers;
    
    private int points = 0;
    private int sets = 0;
    /**
     * Creates new form QuizClient
     */
    public QuizClient() {
        this.activeMembers = new ArrayList<>();
        this.questionAndAnswers = new ArrayList<>();
        this.presentMembers = new ArrayList<>();
        this.scoreboardUsers = new ArrayList<>();
        initComponents(); 
        
        try
        {
            adminGUI = new AdminGUI(this);
            contestantGUI = new ContestantGUI(this);
            this.socket = new Socket("127.0.0.1", 6001);
            this.br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.pw = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()), true); 
            this.rmfs = new RecieveMessageFromServer(this, adminGUI,contestantGUI);
            Thread thr = new Thread(rmfs);
            thr.start();
            
            jButton_login.setEnabled(false);

        }
        catch(IOException ex)
        {
            Logger.getLogger(QuizClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public BufferedReader getBr() {
        return br;
    }

    public PrintWriter getPw() {
        return pw;
    }
    
    public String get_jCheckBox_Pressed_contestant()
    {
        if(jCheckBox_contestant.isSelected())
            return "contestant";
        else
            return "false";
    }
    
    public String get_jCheckBox_Pressed_admin()
    {
        if(jCheckBox_admin.isSelected())
            return "admin";
        else
            return "false";
    }
    
    public void updateActiveQuizMembers(ArrayList<QuizMemberClient> updatedList)
    {
        this.activeMembers = updatedList;
    }

    public ArrayList<QuizMemberClient> getActiveMembers() {
        return activeMembers;
    }
    
    public JTextField getjTextField_username() {
        return jTextField_username;
    }

    public String getUsernameFromTextField() {
        return usernameFromTextField;
    }

    public void setQuestionAndAnswers(ArrayList<String> questionAndAnswers) {
        this.questionAndAnswers = questionAndAnswers;
    }

    public ArrayList<String> getQuestionAndAnswers() {
        return questionAndAnswers;
    }

    public void setLoginNumber(int loginNumber) {
        this.loginNumber = loginNumber;
    }

    public int getLoginNumber() {
        return loginNumber;
    }

    public void setPresentMembers(ArrayList<String> presentMembers) {
        this.presentMembers = presentMembers;
    }

    public ArrayList<String> getPresentMembers() {
        return presentMembers;
    }

    public void addMembersToScoreboard(String member)
    {
        scoreboardUsers.add(member);
    }
    
    public void removeMembersFromScoreboard()
    {
        scoreboardUsers.clear();
    }

    public ArrayList<String> getScoreboardUsers() {
        return scoreboardUsers;
    }

    public int getPoints() {
        return points;
    }

    public int getSets() {
        return sets;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setSets(int sets) {
        this.sets = sets;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField_username = new javax.swing.JTextField();
        jButton_requestLogin = new javax.swing.JButton();
        jButton_exit = new javax.swing.JButton();
        jCheckBox_admin = new javax.swing.JCheckBox();
        jCheckBox_contestant = new javax.swing.JCheckBox();
        jTextField_password = new javax.swing.JTextField();
        jButton_login = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LoginGUI");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("Login GUI");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Username :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Password :");

        jTextField_username.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jButton_requestLogin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_requestLogin.setText("Request");
        jButton_requestLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_requestLoginActionPerformed(evt);
            }
        });

        jButton_exit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_exit.setText("Exit");
        jButton_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_exitActionPerformed(evt);
            }
        });

        buttonGroup1.add(jCheckBox_admin);
        jCheckBox_admin.setText("Admin");

        buttonGroup1.add(jCheckBox_contestant);
        jCheckBox_contestant.setText("Contestant");

        jTextField_password.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jButton_login.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_login.setText("Login");
        jButton_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_loginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton_login, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_exit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton_requestLogin))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(89, 89, 89))
                            .addComponent(jTextField_username, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jCheckBox_admin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox_contestant))
                            .addComponent(jTextField_password))))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox_admin)
                    .addComponent(jCheckBox_contestant))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton_login, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_requestLogin)
                    .addComponent(jButton_exit))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_requestLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_requestLoginActionPerformed
        // TODO add your handling code here:
        if(jTextField_username.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Insert username");
        }
        else if(jTextField_password.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Insert password");
        }
        else if(!jCheckBox_admin.isSelected() && !jCheckBox_contestant.isSelected())
        {
            JOptionPane.showMessageDialog(null, "Chose role");
        }
        else
        {
            String username = jTextField_username.getText();
            String password = jTextField_password.getText();
            String role = "";
            if(jCheckBox_contestant.isSelected())
                role = "contestant";
            if(jCheckBox_admin.isSelected())
                role = "admin";

            String porukaZaSlanje = "Login =" + username + ":" + password + ":" + role;
            this.pw.println(porukaZaSlanje);
            System.out.println(porukaZaSlanje);
            porukaZaSlanje = "";           
        }
        jButton_login.setEnabled(true);
    }//GEN-LAST:event_jButton_requestLoginActionPerformed

    private void jButton_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_exitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton_exitActionPerformed

    private void jButton_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_loginActionPerformed
        // TODO add your handling code here:
        if (loginNumber == 1) 
        {
            if (jCheckBox_admin.isSelected()) 
            {
                String porukaZaSlanje = "ActiveUsers =";
                this.pw.println(porukaZaSlanje);
                
                usernameFromTextField = jTextField_username.getText();
                adminGUI.show();
                dispose();
            }
            if (jCheckBox_contestant.isSelected()) 
            {
                String porukaZaSlanje = "ActiveUsers =";
                this.pw.println(porukaZaSlanje);

                usernameFromTextField = jTextField_username.getText();
                contestantGUI.show();
                dispose();
            }
        } 
        else if (loginNumber == 2) 
        {
            JOptionPane.showMessageDialog(null, "Wrong Login Format!"); 
            jButton_login.setEnabled(false);
        }   
        else if(loginNumber == 4)
        {
            JOptionPane.showMessageDialog(null, "User does not exist!");
            jButton_login.setEnabled(false);
        }
    }//GEN-LAST:event_jButton_loginActionPerformed

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
            java.util.logging.Logger.getLogger(QuizClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuizClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton_exit;
    private javax.swing.JButton jButton_login;
    private javax.swing.JButton jButton_requestLogin;
    private javax.swing.JCheckBox jCheckBox_admin;
    private javax.swing.JCheckBox jCheckBox_contestant;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField_password;
    private javax.swing.JTextField jTextField_username;
    // End of variables declaration//GEN-END:variables
}