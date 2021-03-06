/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProGApp;

import javax.swing.*;
import ProGApp.Register;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.json.JSONObject;

/**
 *
 * @author DUONG.BuiQuang
 */
public class Login extends javax.swing.JFrame {

  /**
   * Creates new form Login
   */
  String password = null;
  String username = null;
  public Login() throws FileNotFoundException {
    initComponents();
  }

  public void init() throws FileNotFoundException{ 
    
    if(FileService.checkFileExists()) {
      System.out.println(FileService.checkFileExists());
      JSONObject data = FileService.readFile();
//      String todoId = (String) data.get("todoId");
      var mainApp = new MainApp();
      mainApp.setVisible(true);
      this.dispose();
    }
    else {
      this.setVisible(true);
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

    loginForm = new javax.swing.JPanel();
    jLabel9 = new javax.swing.JLabel();
    usernameLoginLabel = new javax.swing.JLabel();
    passwordLoginLabel = new javax.swing.JLabel();
    passwordLogin = new javax.swing.JTextField();
    usernameLogin = new javax.swing.JTextField();
    loginButton = new javax.swing.JLabel();
    createAccountLink = new javax.swing.JLabel();
    jPasswordField1 = new javax.swing.JPasswordField();
    loginPanel = new javax.swing.JPanel();
    loginForm1 = new javax.swing.JPanel();
    jLabel11 = new javax.swing.JLabel();
    usernameLoginLabel1 = new javax.swing.JLabel();
    passwordLoginLabel1 = new javax.swing.JLabel();
    usernameForm = new javax.swing.JTextField();
    createAccountLink1 = new javax.swing.JLabel();
    Login = new java.awt.Button();
    passwordForm = new javax.swing.JPasswordField();
    jLabel10 = new javax.swing.JLabel();

    loginForm.setBackground(new java.awt.Color(255, 255, 255));
    loginForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel9.setBackground(new java.awt.Color(255, 255, 51));
    jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel9.setText("Login");
    loginForm.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

    usernameLoginLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    usernameLoginLabel.setText("Username:");
    usernameLoginLabel.setToolTipText("");
    loginForm.add(usernameLoginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 86, -1));

    passwordLoginLabel.setText("Password:");
    loginForm.add(passwordLoginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 66, -1));

    passwordLogin.setToolTipText("");
    passwordLogin.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        passwordLoginActionPerformed(evt);
      }
    });
    loginForm.add(passwordLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 204, 25));

    usernameLogin.setToolTipText("");
    usernameLogin.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        usernameLoginActionPerformed(evt);
      }
    });
    loginForm.add(usernameLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 204, 25));

    loginButton.setIcon(new javax.swing.ImageIcon("H:\\Java\\CLB\\test\\src\\static\\Register.png")); // NOI18N
    loginButton.setText("jLabel7");
    loginForm.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 110, -1));

    createAccountLink.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    createAccountLink.setForeground(new java.awt.Color(255, 87, 150));
    createAccountLink.setText("Create a new account");
    loginForm.add(createAccountLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 130, 20));

    jPasswordField1.setText("jPasswordField1");

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    loginPanel.setBackground(new java.awt.Color(255, 228, 244));
    loginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    loginForm1.setBackground(new java.awt.Color(255, 255, 255));
    loginForm1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

    jLabel11.setBackground(new java.awt.Color(255, 255, 51));
    jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel11.setText("Login");
    loginForm1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, -1, -1));

    usernameLoginLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    usernameLoginLabel1.setText("Username:");
    usernameLoginLabel1.setToolTipText("");
    loginForm1.add(usernameLoginLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 86, -1));

    passwordLoginLabel1.setText("Password:");
    loginForm1.add(passwordLoginLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 66, -1));

    usernameForm.setToolTipText("");
    usernameForm.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        usernameFormActionPerformed(evt);
      }
    });
    loginForm1.add(usernameForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 204, 40));

    createAccountLink1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
    createAccountLink1.setForeground(new java.awt.Color(255, 87, 150));
    createAccountLink1.setText("Create a new account");
    createAccountLink1.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mousePressed(java.awt.event.MouseEvent evt) {
        createAccountLink1MousePressed(evt);
      }
    });
    loginForm1.add(createAccountLink1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 130, 20));

    Login.setActionCommand("Login");
    Login.setLabel("Login");
    Login.setName(""); // NOI18N
    Login.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        LoginActionPerformed(evt);
      }
    });
    loginForm1.add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 214, 70, 40));
    Login.getAccessibleContext().setAccessibleName("loginButton");

    passwordForm.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        passwordFormActionPerformed(evt);
      }
    });
    loginForm1.add(passwordForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 200, 40));

    loginPanel.add(loginForm1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 230, 360));

    jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel10.setIcon(new javax.swing.ImageIcon("H:\\Java\\CLB\\TodoListProGApp\\src\\main\\java\\assets\\Frame.png")); // NOI18N
    loginPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 770, 590));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(loginPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 809, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 1, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(loginPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void passwordLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordLoginActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_passwordLoginActionPerformed

  private void usernameLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameLoginActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_usernameLoginActionPerformed

  private void usernameFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFormActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_usernameFormActionPerformed

  private void createAccountLink1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createAccountLink1MousePressed
    // TODO add your handling code here:
    var signupForm = new Register(); 
    signupForm.pack();
    signupForm.setLocationRelativeTo(null);
    signupForm.setVisible(true);
    signupForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    this.dispose();
  }//GEN-LAST:event_createAccountLink1MousePressed

  private void LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginActionPerformed
    // TODO add your handling code here:
    String username = usernameForm.getText();
    char[] getPass = passwordForm.getPassword();
    String password = String.valueOf(getPass);
    JSONObject user = Connection.checkAccount(username, password);
    if(user == null) {
      JOptionPane.showMessageDialog(rootPane, "Wrong username or password");
    }
    else {
      try {
        if(!FileService.checkFileExists()) {
          FileService.createFile();
        }
        FileService.writeFile(user);
//        System.out.println(user);
//        Connection.getMyTodos((String) user.get("todoId"));
        new MainApp().setVisible(true);
        this.dispose();
      } catch (IOException ex) {
        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }//GEN-LAST:event_LoginActionPerformed

  private void passwordFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFormActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_passwordFormActionPerformed

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
      java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
//          new Login().setVisible(true);
          new Login().init();
        } catch (FileNotFoundException ex) {
          Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    });
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private java.awt.Button Login;
  private javax.swing.JLabel createAccountLink;
  private javax.swing.JLabel createAccountLink1;
  private javax.swing.JLabel jLabel10;
  private javax.swing.JLabel jLabel11;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPasswordField jPasswordField1;
  private javax.swing.JLabel loginButton;
  private javax.swing.JPanel loginForm;
  private javax.swing.JPanel loginForm1;
  private javax.swing.JPanel loginPanel;
  private javax.swing.JPasswordField passwordForm;
  private javax.swing.JTextField passwordLogin;
  private javax.swing.JLabel passwordLoginLabel;
  private javax.swing.JLabel passwordLoginLabel1;
  private javax.swing.JTextField usernameForm;
  private javax.swing.JTextField usernameLogin;
  private javax.swing.JLabel usernameLoginLabel;
  private javax.swing.JLabel usernameLoginLabel1;
  // End of variables declaration//GEN-END:variables
}
