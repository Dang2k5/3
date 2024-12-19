
package com.QuanLyThuVien.view.user;


import com.QuanLyThuVien.model.User;
import com.QuanLyThuVien.service.UserService;
import com.QuanLyThuVien.view.AdminFrame;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ManageUsersFrame extends javax.swing.JFrame {
    UserService userService;
    DefaultTableModel defaultTableModel;
    
    public ManageUsersFrame() {
        initComponents();

        userService = new UserService();
        
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }        
        };
        
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo tên", "Theo tài khoản"}));
        
        userTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã nv");
        defaultTableModel.addColumn("Họ và tên");
        defaultTableModel.addColumn("Tài khoản");
        defaultTableModel.addColumn("Số điện thoại");
        defaultTableModel.addColumn("Chức vụ");
        defaultTableModel.addColumn("Tình trạng");
        
        List<User> users = userService.getAllUser();
        
        String chucVu;
        String tinhTrang;
        for(User user : users){
            if(user.getLeve() == 0){
                chucVu = "Quản trị viên";
            }
            else if(user.getLeve() == 1){
                chucVu = "Thủ thư";
            }else{
                chucVu = "Độc giả";
            }
            tinhTrang = "Hoạt động";
            defaultTableModel.addRow(new Object[]{user.getUser_id(),user.getName(),user.getUsername(),user.getPhone(),chucVu,tinhTrang});
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        userTable = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        addUserButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        btn_timkiem = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        btn_back = new javax.swing.JButton();
        btn_capnhat1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setVerifyInputWhenFocusTarget(false);

        userTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Họ và tên", "Tài khoản", "Số Điện Thoại", "Chức vụ", "Tình trạng"
            }
        ));
        userTable.setGridColor(new java.awt.Color(0, 0, 0));
        userTable.setShowGrid(true);
        userTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(userTable);

        jLabel14.setBackground(new java.awt.Color(240, 240, 240));
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QuanLyThuVien/images/icons8_Books_52px_1.png"))); // NOI18N
        jLabel14.setText(" Manage Users");

        addUserButton.setBackground(new java.awt.Color(51, 255, 0));
        addUserButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        addUserButton.setForeground(new java.awt.Color(255, 255, 255));
        addUserButton.setText("Thêm tài khoản");
        addUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(255, 51, 51));
        deleteButton.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Xóa tài khoản");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm kiếm theo tên", "Tìm kiếm theo tài khoản", " ", " " }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        btn_timkiem.setBackground(new java.awt.Color(0, 153, 153));
        btn_timkiem.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_timkiem.setForeground(new java.awt.Color(255, 255, 255));
        btn_timkiem.setText("Tìm kiếm");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QuanLyThuVien/images/search.png"))); // NOI18N
        jLabel3.setLabelFor(txt_search);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        txt_search.setText("Nhập từ khóa tìm kiếm");

        btn_back.setBackground(new java.awt.Color(255, 102, 102));
        btn_back.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setText("Quay lại");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_capnhat1.setBackground(new java.awt.Color(0, 0, 51));
        btn_capnhat1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_capnhat1.setForeground(new java.awt.Color(255, 255, 255));
        btn_capnhat1.setText("Cập nhật");
        btn_capnhat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhat1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(226, 226, 226)
                .addComponent(jLabel14)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(addUserButton)
                        .addGap(24, 24, 24)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_capnhat1)
                        .addGap(18, 18, 18)
                        .addComponent(btn_back))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(138, 138, 138))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(addUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_capnhat1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_timkiem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(txt_search)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                        .addGap(45, 45, 45))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
   // thêm
    private void addUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserButtonActionPerformed
        new AddUserFrame().setVisible(true);
        
    }//GEN-LAST:event_addUserButtonActionPerformed
    // xóa 
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int selectedRow = userTable.getSelectedRow();
        int selectedUserId = (int) userTable.getModel().getValueAt(selectedRow, 0);
        User selectedUser = userService.getUserById(selectedUserId);
        if(selectedUser.getLeve() != 0){
            System.out.print(selectedUserId);         
            try {
                userService.deleteUser(selectedUserId);
            } catch (SQLException ex) {
                Logger.getLogger(ManageUsersFrame.class.getName()).log(Level.SEVERE, null, ex);
            }        
            JOptionPane.showMessageDialog(this, "Xóa thành công!");
        }else{
            JOptionPane.showMessageDialog(this, "Không thể xóa quản trị viên!");
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void userTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTableMouseClicked

    }//GEN-LAST:event_userTableMouseClicked

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        String searchKeyWord;
        searchKeyWord =  txt_search.getText();
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }
        };
        userTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã nv");
        defaultTableModel.addColumn("Họ và tên");
        defaultTableModel.addColumn("Tài khoản");
        defaultTableModel.addColumn("Số điện thoại");
        defaultTableModel.addColumn("Chức vụ");
        defaultTableModel.addColumn("Tình trạng");

        String typeSearch = String.valueOf(jComboBox1.getSelectedItem());

        List<User> users;
        if(typeSearch.equals("Theo tên")){
            users = userService.searchUserFromName(searchKeyWord);
        }

        else{
            users = userService.searchUserFromUsername(searchKeyWord);
        }

        String chucVu;
        String tinhTrang;
        for(User user : users){
            if(user.getLeve() == 1){
                chucVu = "Thủ thư";
            }
            else{
                chucVu = "Độc giả";
            }
            if(user.getFlag() == 0){
                tinhTrang = "Bị khóa!";
            }
            else{
                tinhTrang = "Hoạt động";
            }
            defaultTableModel.addRow(new Object[]{user.getUser_id(),user.getName(),user.getUsername(),user.getPhone(),chucVu,tinhTrang});
        }
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
    }//GEN-LAST:event_jComboBox1ActionPerformed
    // trờ lại
    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_capnhat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhat1ActionPerformed
        defaultTableModel.setRowCount(0);
        List<User> users = userService.getAllUser();
        String chucVu;
        String tinhTrang;
        for(User user : users){
            if(user.getLeve() == 0){
                chucVu = "Quản trị viên";
            }
            else if(user.getLeve() == 1){
                chucVu = "Thủ thư";
            }
            else{
                chucVu = "Độc giả";
            }
            if(user.getFlag() == 0){
                tinhTrang = "Bị khóa!";
            }
            else{
                tinhTrang = "Hoạt động";
            }
            defaultTableModel.addRow(new Object[]{user.getUser_id(), user.getName(), user.getUsername(), user.getPhone(), chucVu, tinhTrang});
        }
    }//GEN-LAST:event_btn_capnhat1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ManageUsersFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUserButton;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_capnhat1;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTable userTable;
    // End of variables declaration//GEN-END:variables
}
