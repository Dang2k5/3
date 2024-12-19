
package com.QuanLyThuVien.view.bill;

import com.QuanLyThuVien.model.Bill;
import com.QuanLyThuVien.model.User;
import com.QuanLyThuVien.service.BillService;
import com.QuanLyThuVien.service.ReaderService;
import com.QuanLyThuVien.service.UserService;
import com.QuanLyThuVien.view.AdminFrame;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ManageBillsFrame extends javax.swing.JFrame {
    DefaultTableModel defaultTableModel;
    private BillService billService;
    private Bill billModel;
    private User userModel;
    private UserService userService;
    private ReaderService readerService;    
    public ManageBillsFrame() {
        initComponents();
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }        
        };
        billTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã phiếu");
        defaultTableModel.addColumn("Người mượn");
        defaultTableModel.addColumn("Nhân viên");
        defaultTableModel.addColumn("Ngày mượn");
        defaultTableModel.addColumn("Tiền cọc");
        
        billService = new BillService();
        userService = new UserService();
        readerService = new ReaderService();
        
        List<Bill> bills = billService.getAllBill();
        
        for(Bill bill : bills){
            defaultTableModel.addRow(new Object[]{bill.getBill_id(),readerService.getReaderById(bill.getReader_id()).getName(),userService.getUserById(bill.getUser_id()).getName(),bill.getDate_muon(),bill.getDeposit()});
        }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Theo độc giả", "Theo nhân viên", "Theo ngày"}));        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        billTable = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jlb_back = new javax.swing.JLabel();
        btn_sua = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        btn_timkiem = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        btn_capnhat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setVerifyInputWhenFocusTarget(false);

        billTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sách", "Tên sách", "Tác giả", "Thể loại", "Số lượng"
            }
        ));
        billTable.setGridColor(new java.awt.Color(0, 0, 0));
        billTable.setShowGrid(true);
        billTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(billTable);

        jLabel14.setBackground(new java.awt.Color(240, 240, 240));
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 51, 51));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QuanLyThuVien/images/icons8_Books_52px_1.png"))); // NOI18N
        jLabel14.setText(" Manage Bills");

        btn_them.setBackground(new java.awt.Color(51, 255, 0));
        btn_them.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_them.setForeground(new java.awt.Color(255, 255, 255));
        btn_them.setText("Thêm phiếu mượn");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_xoa.setBackground(new java.awt.Color(255, 51, 51));
        btn_xoa.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_xoa.setForeground(new java.awt.Color(255, 255, 255));
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));

        jlb_back.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlb_back.setForeground(new java.awt.Color(255, 255, 255));
        jlb_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QuanLyThuVien/images/icons8_Rewind_48px.png"))); // NOI18N
        jlb_back.setText("Back");
        jlb_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlb_backMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlb_back)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_back, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_sua.setBackground(new java.awt.Color(255, 0, 255));
        btn_sua.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_sua.setForeground(new java.awt.Color(255, 255, 255));
        btn_sua.setText("Chi tiết");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn loại thống kê", "Theo ngày", "Theo Tháng", "Theo Năm", " " }));
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

        txt_search.setText("Bạn muốn tìm sách gì");

        btn_capnhat.setBackground(new java.awt.Color(0, 0, 51));
        btn_capnhat.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btn_capnhat.setForeground(new java.awt.Color(255, 255, 255));
        btn_capnhat.setText("Cập nhật");
        btn_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txt_search)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btn_sua)
                                .addGap(18, 18, 18)
                                .addComponent(btn_them)
                                .addGap(18, 18, 18)
                                .addComponent(btn_xoa)
                                .addGap(18, 18, 18)
                                .addComponent(btn_capnhat))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(68, 68, 68))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_xoa, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                        .addComponent(btn_capnhat, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                    .addComponent(btn_them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_sua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_timkiem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txt_search)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
    
    private void jlb_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlb_backMouseClicked
        dispose();
    }//GEN-LAST:event_jlb_backMouseClicked

   // thêm
    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        new AddBillFrame().setVisible(true);
        
    }//GEN-LAST:event_btn_themActionPerformed
    // xóa 
    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        int row = billTable.getSelectedRow();           
        int confirm  = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không?");        
        if(confirm == JOptionPane.YES_OPTION){
            int billId = Integer.parseInt(String.valueOf(billTable.getValueAt(row, 0)));
            billService.deleteBIll(billId);
            JOptionPane.showMessageDialog(null, "Đã xóa phiếu!");
            
        }       
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void billTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billTableMouseClicked

    }//GEN-LAST:event_billTableMouseClicked
    // sửa
    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        int row = billTable.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sách trước!","Lỗi",JOptionPane.ERROR);
        }
        else{
            int billId = Integer.parseInt(String.valueOf(billTable.getValueAt(row, 0)));
            new ShowBillDetailFrame(billId).setVisible(true);
        }
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        String searchKeyWord;
        searchKeyWord = txt_search.getText();
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }        
        };
         
        billTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã phiếu");
        defaultTableModel.addColumn("Người mượn");
        defaultTableModel.addColumn("Nhân viên");
        defaultTableModel.addColumn("Ngày mượn");
        defaultTableModel.addColumn("Tiền cọc");
        
        String typeSearch = String.valueOf(jComboBox1.getSelectedItem());
        List<Bill> bills;
        if(typeSearch.equals("Theo độc giả")){
            bills = billService.searchBillFromReader(searchKeyWord);
        }
        else if(typeSearch.equals("Theo nhân viên")){
            bills = billService.searchBillFromUser(searchKeyWord);
        }
        else{
            bills = billService.searchBillFromDate(searchKeyWord);
        }
            
        for(Bill bill : bills){
            defaultTableModel.addRow(new Object[]{bill.getBill_id(),readerService.getReaderById(bill.getReader_id()).getName(),userService.getUserById(bill.getUser_id()).getName(),bill.getDate_muon(),bill.getDeposit()});
        }
        
    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
    }//GEN-LAST:event_jComboBox1ActionPerformed
    // cập nhật
    private void btn_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhatActionPerformed
        defaultTableModel.setRowCount(0);
        List<Bill> bills = billService.getAllBill();
        
        for(Bill bill : bills){
            defaultTableModel.addRow(new Object[]{bill.getBill_id(),readerService.getReaderById(bill.getReader_id()).getName(),userService.getUserById(bill.getUser_id()).getName(),bill.getDate_muon(),bill.getDeposit()});
        }
    }//GEN-LAST:event_btn_capnhatActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBillsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable billTable;
    private javax.swing.JButton btn_capnhat;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlb_back;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
