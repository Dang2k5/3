
package com.QuanLyThuVien.dao;

import com.QuanLyThuVien.model.Reader;
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

public class ReaderDao {
    public Reader getReaderById(int reader_id){
         
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT * FROM Reader WHERE Reader_id = ?";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, reader_id);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Reader reader = new Reader();
                reader.setReader_id(rs.getInt("Reader_id"));
                reader.setAddress(rs.getString("Address"));
                reader.setEmail(rs.getString("Email"));
                reader.setName(rs.getString("Name"));
                reader.setPhone(rs.getString("Phone"));
                return reader;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Reader> getAllReader(){
        List<Reader> readers = new ArrayList<Reader>();
       
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT * FROM Reader";    
       
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Reader reader = new Reader();
                reader.setReader_id(rs.getInt("Reader_id"));
                reader.setName(rs.getString("Name"));
                reader.setAddress(rs.getString("Address"));
                reader.setEmail(rs.getString("Email"));
                reader.setPhone(rs.getString("Phone"));
                readers.add(reader);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return readers;
    }
    
    public void deleteReader(int reader_id){
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql2 = "DELETE Reader WHERE Reader_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setInt(1, reader_id);
            int rs = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void addReader(Reader reader){
       Connection connection = DBConnect.getJDBCConnection();
       String sql = "INSERT INTO Reader(Name, Address, Email, Phone) VALUES (?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, reader.getName());
            preparedStatement.setString(2, reader.getAddress());
            preparedStatement.setString(3, reader.getEmail());
            preparedStatement.setString(4, reader.getPhone());
            int rs = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateReader(Reader reader){
        Connection connection = DBConnect.getJDBCConnection();
        String sql = "UPDATE Reader SET Name=?,Address=?,Email=?,Phone=? WHERE Reader_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, reader.getName());
            preparedStatement.setString(2, reader.getAddress());
            preparedStatement.setString(3, reader.getEmail());
            preparedStatement.setString(4, reader.getPhone());
            preparedStatement.setInt(5, reader.getReader_id());
            int rs = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Reader> searchReaderFromName(String name){
        List<Reader> readers = new ArrayList<Reader>();
        
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT * FROM Reader WHERE Name LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(name);
        stringBufferTile.append("%");
        String titleLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, titleLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Reader reader = new Reader();
                reader.setReader_id(rs.getInt("Reader_id"));
                reader.setName(rs.getString("Name"));
                reader.setAddress(rs.getString("Address"));
                reader.setEmail(rs.getString("Email"));
                reader.setPhone(rs.getString("Phone"));
                readers.add(reader);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return readers;
    }
    
    public List<Reader> searchReaderFromEmail(String email){
        List<Reader> readers = new ArrayList<Reader>();
        
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT * FROM Reader WHERE Email LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(email);
        stringBufferTile.append("%");
        String titleLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, titleLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Reader reader = new Reader();
                reader.setReader_id(rs.getInt("Reader_id"));
                reader.setName(rs.getString("Name"));
                reader.setAddress(rs.getString("Address"));
                reader.setEmail(rs.getString("Email"));
                reader.setPhone(rs.getString("Phone"));
                readers.add(reader);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return readers;
    }
    
    public List<Reader> searchReaderFromPhone(String phone){
        List<Reader> readers = new ArrayList<Reader>();
        
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT * FROM Reader WHERE Phone LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(phone);
        stringBufferTile.append("%");
        String titleLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, titleLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Reader reader = new Reader();
                reader.setReader_id(rs.getInt("Reader_id"));
                reader.setName(rs.getString("Name"));
                reader.setAddress(rs.getString("Address"));
                reader.setEmail(rs.getString("Email"));
                reader.setPhone(rs.getString("Phone"));
                readers.add(reader);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return readers;
    }
    
    public JTable StatisReaderByAddress(){

        JTable table = new JTable();
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT Address, COUNT(Address) FROM Reader GROUP BY Address";    
       
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return table;
    }
    
    public JTable StatisReaderByName(){
        
        JTable table = new JTable();
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT Name, COUNT(Name) FROM Reader GROUP BY Name";    
       
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return table;
    }
    public JTable StatisReaderByBook(){
        
        JTable table = new JTable();
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT Reader_id, COUNT(Reader_id) FROM Bill INNER JOIN Bill_Detail ON Bill.Bill_id = Bill_Detail.bill_id GROUP BY Reader_id";    
       
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return table;
    }
}
