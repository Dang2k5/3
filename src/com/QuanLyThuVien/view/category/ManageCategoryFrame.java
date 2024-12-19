
package com.QuanLyThuVien.view.category;

import com.QuanLyThuVien.model.Category;
import com.QuanLyThuVien.model.Reader;
import com.QuanLyThuVien.service.CategoryService;
import com.QuanLyThuVien.view.AdminFrame;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ManageCategoryFrame extends javax.swing.JFrame {

    DefaultTableModel defaultTableModel;
    private Category category ;
    private CategoryService categoryService = new CategoryService();
    List<Category> categories = categoryService.getAllCategory();
    public ManageCategoryFrame() {
        initComponents();
        category = new Category();       
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }
        };

        categoryTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("Mã Thể Loại");
        defaultTableModel.addColumn("Thể Loại");
        
        categoryService = new CategoryService();
        
        List<Category> categories = categoryService.getAllCategory();
        
        for(Category category : categories){
            defaultTableModel.addRow(new Object[]{category.getCategory_id(),category.getCategory_name()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        categoryTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_xoa = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        categoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(categoryTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QuanLyThuVien/images/icons8_Book_Shelf_50px.png"))); // NOI18N
        jLabel1.setText("CATEGORY TABLE");

        btn_xoa.setText("Xóa thể loại");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_them.setText("Thêm thể loại");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_back.setText("Quay lại");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });

        btn_refresh.setText("Cập nhật");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(btn_them)
                .addGap(72, 72, 72)
                .addComponent(btn_xoa)
                .addGap(64, 64, 64)
                .addComponent(btn_refresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_back)
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_xoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_back, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        int row = categoryTable.getSelectedRow();           
        int confirm  = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa không?");        
        if(confirm == JOptionPane.YES_OPTION){
            int categoryId = Integer.parseInt(String.valueOf(categoryTable.getValueAt(row, 0)));
            categoryService.deleteCategory(categoryId);
            JOptionPane.showMessageDialog(null, "Đã xóa thể loại!");           
        }       
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
         AddCategoryFrame acf = new AddCategoryFrame();
         acf.setVisible(true);
         acf.pack();
         acf.setLocationRelativeTo(null);
         acf.setResizable(false);
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        defaultTableModel.setRowCount(0);
        categories = categoryService.getAllCategory();
        
        for(Category i : categories){
            defaultTableModel.addRow(new Object[]{i.getCategory_id(), i.getCategory_name()});
        }
    }//GEN-LAST:event_btn_refreshActionPerformed

    public static void main(String args[]) {      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCategoryFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JTable categoryTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
