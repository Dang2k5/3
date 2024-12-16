
package com.QuanLyThuVien.view.reader;

import com.QuanLyThuVien.model.Reader;
import com.QuanLyThuVien.service.CategoryService;
import com.QuanLyThuVien.service.ReaderService;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StatisticalReaderFrame extends javax.swing.JFrame {
    DefaultTableModel defaultTableModel;
    ReaderService readerService;
    public StatisticalReaderFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        readerService = new ReaderService();        
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }
        };
        statiJTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("STT");
        defaultTableModel.addColumn("Họ Và Tên");
        defaultTableModel.addColumn("Số Lượng");

        JTable table = new JTable();
        String[][] arrStatis = new String[table.getRowCount()][table.getColumnCount()];
        table = readerService.StatisReaderByName();

        for (int row = 0; row < table.getRowCount(); row++) {
            defaultTableModel.addRow(new Object[]{row+1, table.getValueAt(row, 0),table.getValueAt(row,1)});
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jlb_back = new javax.swing.JLabel();
        bookButton = new javax.swing.JButton();
        addressButton = new javax.swing.JButton();
        nameButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        statiJTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jlb_typeStatis = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 153, 153));

        jlb_back.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jlb_back.setForeground(new java.awt.Color(255, 255, 255));
        jlb_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/QuanLyThuVien/images/icons8_Rewind_48px.png"))); // NOI18N
        jlb_back.setText("Back");
        jlb_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlb_backMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_back)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_back, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bookButton.setBackground(new java.awt.Color(0, 153, 0));
        bookButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        bookButton.setForeground(new java.awt.Color(255, 255, 255));
        bookButton.setText("Theo sách");
        bookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookButtonActionPerformed(evt);
            }
        });

        addressButton.setBackground(new java.awt.Color(0, 153, 0));
        addressButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        addressButton.setForeground(new java.awt.Color(255, 255, 255));
        addressButton.setText("Theo địa chỉ");
        addressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressButtonActionPerformed(evt);
            }
        });

        nameButton.setBackground(new java.awt.Color(0, 153, 0));
        nameButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nameButton.setForeground(new java.awt.Color(255, 255, 255));
        nameButton.setText("Theo tên");
        nameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameButtonActionPerformed(evt);
            }
        });

        statiJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(statiJTable);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(bookButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nameButton)
                        .addGap(65, 65, 65)
                        .addComponent(addressButton)
                        .addGap(82, 82, 82)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bookButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addressButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jlb_typeStatis.setFont(new java.awt.Font("Tahoma", 2, 13)); // NOI18N
        jlb_typeStatis.setText("Theo Tên");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlb_typeStatis, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(584, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jlb_typeStatis, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlb_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlb_backMouseClicked
        this.dispose();
    }//GEN-LAST:event_jlb_backMouseClicked

    private void bookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookButtonActionPerformed
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }
        };
        statiJTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("STT");
        defaultTableModel.addColumn("Mã Độc Giả");
        defaultTableModel.addColumn("Họ Và Tên");
        defaultTableModel.addColumn("Số Lượng Sách Mượn");

        JTable table = new JTable();
        String[][] arrStatis = new String[table.getRowCount()][table.getColumnCount()];
        table = readerService.StatisReaderByBook();

        for (int row = 0; row < table.getRowCount(); row++) {
            int readerId = Integer.parseInt(String.valueOf(table.getValueAt(row, 0)));
            defaultTableModel.addRow(new Object[]{row+1, table.getValueAt(row, 0),readerService.getReaderById(readerId).getName(),table.getValueAt(row,1)});
        }
        jlb_typeStatis.setText("Số Lượng Sách Mượn");
    }//GEN-LAST:event_bookButtonActionPerformed

    private void addressButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressButtonActionPerformed
        defaultTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }
        };
        statiJTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("STT");
        defaultTableModel.addColumn("Địa chỉ");
        defaultTableModel.addColumn("Số Lượng");

        JTable table = new JTable();
        table = readerService.StatisReaderByAddress();

        for (int row = 0; row < table.getRowCount(); row++) {
            defaultTableModel.addRow(new Object[]{row+1, table.getValueAt(row, 0),table.getValueAt(row,1)});
        }
        jlb_typeStatis.setText("Theo Địa Chỉ");
    }//GEN-LAST:event_addressButtonActionPerformed

    private void nameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameButtonActionPerformed
        defaultTableModel = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Không cho phép người dùng sửa dữ liệu
            }        
        };
        statiJTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("STT");
        defaultTableModel.addColumn("Địa chỉ");
        defaultTableModel.addColumn("Số Lượng");    
        JTable table = new JTable();
        table = readerService.StatisReaderByName();        
        for (int row = 0; row < table.getRowCount(); row++) {
            defaultTableModel.addRow(new Object[]{row+1, table.getValueAt(row, 0),table.getValueAt(row,1)});
        }
        jlb_typeStatis.setText("Theo Tên");
    }//GEN-LAST:event_nameButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StatisticalReaderFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addressButton;
    private javax.swing.JButton bookButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlb_back;
    private javax.swing.JLabel jlb_typeStatis;
    private javax.swing.JButton nameButton;
    private javax.swing.JTable statiJTable;
    // End of variables declaration//GEN-END:variables
}
