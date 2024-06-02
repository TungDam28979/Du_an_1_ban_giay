/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;
import Repository.Forgotpass_Repo;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Forgotpass_Model;
/**
 *
 * @author Tran Viet Vuong
 */
public class Register extends javax.swing.JPanel {
    Forgotpass_Repo FogotRepo = new Forgotpass_Repo();
    
        public static void main(String[] args) {
        JFrame jf = new JFrame();
        Register spview = new Register();
        jf.add(spview);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }
    public Register() {
        initComponents();
        
    }
    public void register() {
        txtUser.grabFocus();
    }

    public void addEventBackLogin(ActionListener event) {
        cmdBackLogin.addActionListener(event);
    }

    Forgotpass_Model readform() {
        Forgotpass_Model fg = new Forgotpass_Model();
        String ma = txtUser.getText();
        String mk = txtPass1.getText();
        return new Forgotpass_Model(ma, mk);
    }

    public boolean checkEmail() {
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        String mail = txtmail.getText();
        if (mail.matches(EMAIL_REGEX) == false) {
            JOptionPane.showMessageDialog(this, "Email sai định dạng!");
            return false;
        }
        if (mail.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn cần nhập vào Email!");
            return false;
        }
        if (FogotRepo.selectEmail(mail) == null) {
            JOptionPane.showMessageDialog(this, "Email chưa được dăng kí với nhan viên nào!");
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtUser = new swing.MyTextField();
        jLabel5 = new javax.swing.JLabel();
        txtmail = new swing.MyTextField();
        txtPass1 = new swing.MyPassword();
        jLabel4 = new javax.swing.JLabel();
        cmdBackLogin = new javax.swing.JButton();
        myButton1 = new swing.MyButton();
        jLabel3 = new javax.swing.JLabel();
        txtPass = new swing.MyPassword();

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(69, 68, 68));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Forgot Passworld");

        jLabel1.setText("User Name");

        jLabel5.setText("Email");

        jLabel4.setText("Confirm Password");

        cmdBackLogin.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        cmdBackLogin.setForeground(new java.awt.Color(30, 122, 236));
        cmdBackLogin.setText("Back to Login");
        cmdBackLogin.setContentAreaFilled(false);
        cmdBackLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmdBackLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdBackLoginMouseClicked(evt);
            }
        });

        myButton1.setBackground(new java.awt.Color(125, 229, 251));
        myButton1.setForeground(new java.awt.Color(40, 40, 40));
        myButton1.setText("Login");
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdBackLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(txtPass1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(cmdBackLogin)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents
    String code;
    String to;
    private void cmdBackLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdBackLoginMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_cmdBackLoginMouseClicked

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed

        Forgotpass_Model fg = readform();

        if (!checkEmail()) {
            return;
        } else {

            if (!FogotRepo.getuser(fg)) {
                JOptionPane.showMessageDialog(this, "Mã nhân viên không tồn tại!");
            } else {
                if (txtPass.getText().equals(txtPass1.getText())) {
                    if (FogotRepo.updatepass(fg) > 0) {
                        JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công!");
                        final String from = "Xshop.17@outlook.com";
                        final String pass = "Aabcxyz123";
                        final String to = txtmail.getText();
                        //Properties: khai báo các thuộc tính
                        Properties prop = new Properties();
                        prop.put("mail.smtp.host", "smtp-mail.outlook.com");//SMTP HOST
                        prop.put("mail.smtp.port", "587");//TLS=587,SSL=465
                        prop.put("mail.smtp.auth", "true");
                        prop.put("mail.smtp.starttls.enable", "true");
                        //gửi mail

                        Authenticator auth = new Authenticator() {
                            @Override
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(from, pass);
                            }

                        };
                        // phiên làm  việc
                        Session session = Session.getInstance(prop, auth);
                        MimeMessage msg = new MimeMessage(session);
                        try {
                            msg.addHeader("Content-type", "text; charset=UTF-8");
                            //người gửi
                            msg.setFrom(from);
                            //người nhận
                            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
                            //tiêu đề
                            msg.setSubject("Gửi mật khẩu");
                            //quy định ngày gửi
                            msg.setSentDate(new Date());
                            //quy định email nhận phản hồi
                            //   msg.setReplyTo(null);
                            //nội dung
                            msg.setText("Mật khẩu được đặt lại là: " + txtPass1.getText(), "UTF-8");

                            Transport.send(msg);

                        } catch (Exception e) {
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "nhân viên không tồn tại Conform pass world không khớp!");
                }
            }

        }
    }//GEN-LAST:event_myButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdBackLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private swing.MyButton myButton1;
    private swing.MyPassword txtPass;
    private swing.MyPassword txtPass1;
    private swing.MyTextField txtUser;
    private swing.MyTextField txtmail;
    // End of variables declaration//GEN-END:variables
}
