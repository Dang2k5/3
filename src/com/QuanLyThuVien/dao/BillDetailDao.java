
package com.QuanLyThuVien.dao;

import com.QuanLyThuVien.model.BillDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BillDetailDao {
    public void addBill(List<Integer> book_ids, int bill_id){
       Connection connection = DBConnect.getJDBCConnection();
       
        for(Integer book_id : book_ids){
            String sql = "INSERT INTO Bill_Detail(Bill_id, Book_id, Fined) VALUES (?,?,?)";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, bill_id);
                preparedStatement.setInt(2, book_id);
                preparedStatement.setString(3, "0");

                int rs = preparedStatement.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(BillDetailDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }
    
    public List<BillDetail> getAllBillDetail(int billId){
        List<BillDetail> billdts = new ArrayList<BillDetail>();
        
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT * FROM Bill_Detail WHERE Bill_id = ?";    
       
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, billId);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                BillDetail billdt = new BillDetail();
                billdt.setBill_detail_id(rs.getInt("Bill_detail_id"));
                billdt.setBill_id(rs.getInt("Bill_id"));
                billdt.setBook_id(rs.getInt("Book_id"));
                billdt.setDate_pay(rs.getString("Date_pay"));
                billdt.setFined(rs.getString("Fined"));
                billdts.add(billdt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return billdts;
    }
    
    public void update(int billDetail_id,int fined){
        Connection connection = DBConnect.getJDBCConnection();
        String sql = "UPDATE Bill_detail SET Fined = ?,Date_pay = ? WHERE Book_id=?";
        
        long millis=System.currentTimeMillis();  
        java.sql.Date date = new java.sql.Date(millis); 
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, fined);
            preparedStatement.setString(2, date.toString());
            preparedStatement.setInt(3, billDetail_id);
            int rs = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(BillDetailDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
