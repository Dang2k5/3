
package com.QuanLyThuVien.view;

import com.QuanLyThuVien.model.User;
import com.QuanLyThuVien.service.UserService;
import javax.swing.JOptionPane;

public class ChangePasswordFrame extends javax.swing.JFrame {

    UserService userService = new UserService();
    User user;
    public ChangePasswordFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_passOlder = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_passNewer = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_passConfirmed = new javax.swing.JTextField();
        btn_change = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Đổi mật khẩu");

        jLabel3.setText("Nhập mật khẩu cũ");

        jLabel4.setText("Nhập mật khẩu mới");

        jLabel5.setText("Xác nhận mật khẩu");

        btn_change.setText("Đổi mật khẩu");
        btn_change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_changeActionPerformed(evt);
            }
        });

        btn_return.setText("Quay lại");
        btn_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txt_passOlder, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jLabel3)
                            .addGap(126, 126, 126))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txt_passNewer, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txt_passConfirmed, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btn_change)
                        .addGap(18, 18, 18)
                        .addComponent(btn_return)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_passOlder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_passNewer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_passConfirmed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_change)
                    .addComponent(btn_return))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_returnActionPerformed

    private void btn_changeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_changeActionPerformed
        user = userService.Checkpassword(txt_passOlder.getText());
        if(!txt_passNewer.getText().equals(txt_passConfirmed.getText())){
            JOptionPane.showMessageDialog(this, "Mật khẩu mới và xác nhận mật khẩu không khớp", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Thực hiện thay đổi mật khẩu
        boolean passwordChanged = userService.ChangePassword(user.getUsername(), txt_passNewer.getText());
        System.out.println(passwordChanged);
        if (passwordChanged == true) {
            JOptionPane.showMessageDialog(this, "Mật khẩu đã được cập nhật", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            // Chuyển đến màn hình đăng nhập mới và đóng cửa sổ hiện tại
            new LoginFrame().setVisible(true);
            this.dispose(); // Đóng cửa sổ hiện tại
        } else {
            JOptionPane.showMessageDialog(this, "Mật khẩu cũ không đúng. Vui lòng thử lại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_changeActionPerformed

    public static void main(String args[]) {       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePasswordFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_change;
    private javax.swing.JButton btn_return;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txt_passConfirmed;
    private javax.swing.JTextField txt_passNewer;
    private javax.swing.JTextField txt_passOlder;
    // End of variables declaration//GEN-END:variables
}
