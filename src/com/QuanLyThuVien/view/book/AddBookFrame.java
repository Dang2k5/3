
package com.QuanLyThuVien.view.book;

import com.QuanLyThuVien.model.Book;
import com.QuanLyThuVien.model.Category;
import com.QuanLyThuVien.service.BookService;
import com.QuanLyThuVien.service.CategoryService;
import java.util.List;

public class AddBookFrame extends javax.swing.JFrame {

    BookService bookService;
    Book book ;
    CategoryService categoryService;
    Category categoryModel;
    public AddBookFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        bookService = new BookService();
        categoryService = new CategoryService();
        categoryModel = new Category();
        book = new Book();    
        
        List<Category> categoriesList = categoryService.getAllCategory();
        
        String []arrCategory;
        arrCategory = new String[categoriesList.size()];
        
        int i=0;
        for(Category item : categoriesList){
            arrCategory[i] = item.getCategory_name();
            i++;
        }
        jComboBox_category.setModel(new javax.swing.DefaultComboBoxModel<>(arrCategory));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_title = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_author = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_amount = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_Introduce = new javax.swing.JTextArea();
        jComboBox_category = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btn_add = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QuanLyThuVien/images/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Enter Tittle");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));

        txt_title.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txt_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 240, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QuanLyThuVien/images/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, -1, -1));

        txt_author.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txt_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 240, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Enter Book Author");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QuanLyThuVien/images/icons8_Books_26px.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Choose Book Category");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, -1, -1));

        txt_amount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 240, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QuanLyThuVien/images/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Enter Amount");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, -1, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QuanLyThuVien/images/voter.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, -1, 40));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Enter Book Introduce");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, -1, -1));

        txt_Introduce.setColumns(20);
        txt_Introduce.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Introduce.setRows(5);
        jScrollPane1.setViewportView(txt_Introduce);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 240, 130));

        jComboBox_category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sách  Ngôn Tình", "Sách Tiểu thuyết", "Sách kinh doanh", "Sách IT" }));
        jPanel1.add(jComboBox_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 240, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("ADD BOOK FRAME");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, -1, -1));

        btn_add.setBackground(new java.awt.Color(255, 51, 0));
        btn_add.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel1.add(btn_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 520, 90, 40));

        btn_back.setBackground(new java.awt.Color(255, 51, 0));
        btn_back.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        jPanel1.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 520, 90, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        book.setTitle(txt_title.getText());
        book.setAuthor(txt_author.getText());
        book.setIntroduce(txt_Introduce.getText());
        int amountBook = Integer.valueOf(String.valueOf(txt_amount.getText()));
        book.setAmount(amountBook);
        String categoryItem = String.valueOf(jComboBox_category.getSelectedItem());
        int category_id = categoryService.getCategoryIdByValue(categoryItem);
        book.setCategory_id(category_id);
        bookService.addBook(book);
        this.dispose();
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_backActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddBookFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_back;
    private javax.swing.JComboBox<String> jComboBox_category;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt_Introduce;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_author;
    private javax.swing.JTextField txt_title;
    // End of variables declaration//GEN-END:variables
}
