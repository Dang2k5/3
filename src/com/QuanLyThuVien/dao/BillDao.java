
package com.QuanLyThuVien.dao;

import com.QuanLyThuVien.model.Bill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class BillDao {
    public List<Bill> getAllBill(){
        List<Bill> bills = new ArrayList<Bill>();       
        Connection connection = DBConnect.getJDBCConnection();       
        String sql = "SELECT * FROM Bill";          
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);           
            ResultSet rs = preparedStatement.executeQuery();            
            while(rs.next()){
                Bill bill = new Bill();
                bill.setBill_id(rs.getInt("Bill_id"));
                bill.setReader_id(rs.getInt("Reader_id"));
                bill.setUser_id(rs.getInt("Users_id"));
                bill.setDate_muon(rs.getString("Date_muon"));
                bill.setDate_hen(rs.getString("Date_hen"));
                bill.setDeposit(rs.getString("Deposit"));
                bills.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bills;
    }
    
    public void addBill(Bill bill){
       Connection connection = DBConnect.getJDBCConnection();
       String sql = "INSERT INTO Bill(Reader_id, Users_id, Date_muon, Date_hen, Deposit) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bill.getReader_id());
            preparedStatement.setInt(2, bill.getUser_id());
            preparedStatement.setString(3, bill.getDate_muon());
            preparedStatement.setString(4, bill.getDate_hen());
            preparedStatement.setString(5, bill.getDeposit());
            int rs = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(BillDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteBill(int bill_id){
        Connection connection = DBConnect.getJDBCConnection();
        String sql = "DELETE FROM Bill WHERE Bill_id = ?"; 
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bill_id);
            int rs = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BillDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int getBillIdNew(){
         
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT TOP(1) * FROM Bill ORDER BY Bill_id DESC";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Bill bill = new Bill();
                bill.setBill_id(rs.getInt("Bill_id"));
                
                return bill.getBill_id();
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
    public Bill getBillById(int bill_id){
         
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT * FROM Bill WHERE Bill_id = ?";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bill_id);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Bill bill = new Bill();
                bill.setBill_id(rs.getInt("Bll_id"));
                bill.setUser_id(rs.getInt("Users_id"));
                bill.setReader_id(rs.getInt("Reader_id"));
                bill.setDeposit(rs.getString("Deposit"));
                bill.setDate_hen(rs.getString("Date_hen"));
                bill.setDate_muon(rs.getString("Date_muon"));
                return bill;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BillDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Bill> searchBillFromReader(String searchKeyWord){
        List<Bill> bills = new ArrayList<Bill>();
        
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT * FROM Bill INNER JOIN Reader ON Bill.Reader_id = Reader.Reader_id WHERE Name LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(searchKeyWord);
        stringBufferTile.append("%");
        String searchKeyWordLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, searchKeyWordLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Bill bill = new Bill();
                bill.setBill_id(rs.getInt("Bill_id"));
                bill.setReader_id(rs.getInt("Reader_id"));
                bill.setUser_id(rs.getInt("Users_id"));
                bill.setDeposit(rs.getString("Deposit"));
                bill.setDate_muon(rs.getString("Date_muon"));
                bill.setDate_hen(rs.getString("Date_hen"));
                bills.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bills;
    }
    
    public List<Bill> searchBillFromUser(String searchKeyWord){
        List<Bill> bills = new ArrayList<Bill>();
        
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT * FROM Bill INNER JOIN Users ON Bill.Users_id = Users.Users_id where name LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(searchKeyWord);
        stringBufferTile.append("%");
        String searchKeyWordLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, searchKeyWordLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Bill bill = new Bill();
                bill.setBill_id(rs.getInt("Bill_id"));
                bill.setReader_id(rs.getInt("Reader_id"));
                bill.setUser_id(rs.getInt("Users_id"));
                bill.setDeposit(rs.getString("Deposit"));
                bill.setDate_muon(rs.getString("Date_muon"));
                bill.setDate_hen(rs.getString("Date_hen"));
                bills.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bills;
    }
    
    public List<Bill> searchBillFromDate(String searchKeyWord){
        List<Bill> bills = new ArrayList<Bill>();
        
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT * FROM Bill WHERE Date_muon LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(searchKeyWord);
        stringBufferTile.append("%");
        String searchKeyWordLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, searchKeyWordLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Bill bill = new Bill();
                bill.setBill_id(rs.getInt("Bill_id"));
                bill.setReader_id(rs.getInt("Reader_id"));
                bill.setUser_id(rs.getInt("Users_id"));
                bill.setDeposit(rs.getString("Deposit"));
                bill.setDate_muon(rs.getString("Date_muon"));
                bill.setDate_hen(rs.getString("Date_hen"));
                bills.add(bill);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bills;
    }
    
    public JTable StatisUserByDate(){
        
        JTable table = new JTable();
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT Date_muon, COUNT(Date_muon) FROM Bill GROUP BY Date";    
       
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return table;
    }
    
    public int getCountBookByDate(String date){
         
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT * FROM Bill INNER JOIN Bill_Detail ON Bill.Bill_id = Bill_Detail.Bill_id WHERE Date_muon = ? ORDER BY Date_muon DESC";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, date);
            ResultSet rs = preparedStatement.executeQuery();
            
            int index=0;
            while(rs.next()){
                index++;
            }
            
            return index;
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
