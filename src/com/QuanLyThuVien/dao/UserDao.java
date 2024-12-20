
package com.QuanLyThuVien.dao;

import com.QuanLyThuVien.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;


public class UserDao {
    public User checkLogin(String username, String password){
        String sql = "SELECT *FROM Users WHERE Username = ? AND Password = ?";
        Connection connection = DBConnect.getJDBCConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setUser_id(rs.getInt("Users_id"));
                user.setName(rs.getString("Name"));
                user.setLeve(rs.getInt("Leve"));
                user.setPhone(rs.getString("Phone"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setFlag(rs.getInt("Flag"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public void addUser(User user){
        Connection conn = DBConnect.getJDBCConnection();
        String sql = "INSERT INTO Users( Name, Leve, Phone, Username, Password, Flag) VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getName());
            ps.setInt(2, user.getLeve());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getUsername());
            ps.setString(5, user.getPassword());
            ps.setInt(6, user.getFlag());
            int rs = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    public List<User> getAllUser(){
        Connection conn = DBConnect.getJDBCConnection();
        String sql = "SELECT *FROM Users ORDER BY Flag DESC";
        List<User> ds = new ArrayList<User>();
        try {         
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setUser_id(rs.getInt("Users_id"));
                user.setName(rs.getString("Name"));
                user.setLeve(rs.getInt("Leve"));
                user.setPhone(rs.getString("Phone"));
                user.setUsername(rs.getString("Username"));             
                user.setFlag(rs.getInt("Flag"));
                ds.add(user);
            }           
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ds;
    }
    
    public List<User> getUserByLeve(int leve){       
        Connection connection = DBConnect.getJDBCConnection();       
        String sql = "SELECT * FROM Users WHERE Leve = ?";    
        List<User> users = new ArrayList<User>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, leve);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setUser_id(rs.getInt("Users_id"));
                user.setName(rs.getString("Name"));
                user.setPhone(rs.getString("Phone"));
                user.setLeve(rs.getInt("Leve"));
                user.setFlag(rs.getInt("Flag"));
                user.setUsername(rs.getString("Username"));
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
   
    public User getUserById(int user_id){       
        Connection connection = DBConnect.getJDBCConnection();       
        String sql = "SELECT * FROM Users WHERE Users_id = ?";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user_id);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                User user = new User();
                user.setUser_id(rs.getInt("Users_id"));
                user.setName(rs.getString("Name"));
                user.setLeve(rs.getInt("Leve"));
                user.setPhone(rs.getString("Phone"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setFlag(rs.getInt("Flag"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User CheckUsername(String username){
         
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT * FROM Users WHERE Username = ?";
        try{
        PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setUser_id(rs.getInt("Users_id"));
                user.setName(rs.getString("Name"));
                user.setLeve(rs.getInt("Leve"));
                user.setPhone(rs.getString("Phone"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setFlag(rs.getInt("Flag"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public User CheckPassword(String password){
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT * FROM Users WHERE Password = ?";
        try{
        PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User user = new User();
                user.setUser_id(rs.getInt("Users_id"));
                user.setName(rs.getString("Name"));
                user.setLeve(rs.getInt("Leve"));
                user.setPhone(rs.getString("Phone"));
                user.setUsername(rs.getString("Username"));
                user.setPassword(rs.getString("Password"));
                user.setFlag(rs.getInt("Flag"));
                return user;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public List<User> searchUserFromName(String name){
        List<User> users = new ArrayList<User>();
        
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT * FROM Users where name LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(name);
        stringBufferTile.append("%");
        String nameLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nameLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                User user = new User();
                user.setUser_id(rs.getInt("Users_id"));
                user.setName(rs.getString("Name"));
                user.setPhone(rs.getString("Phone"));
                user.setLeve(rs.getInt("Leve"));
                user.setFlag(rs.getInt("Flag"));
                user.setUsername(rs.getString("Username"));
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    public List<User> searchUserFromUsername(String userName){
        List<User> users = new ArrayList<User>();
        
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT * FROM Users where Username LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(userName);
        stringBufferTile.append("%");
        String nameLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nameLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                User user = new User();
                user.setUser_id(rs.getInt("Users_id"));
                user.setName(rs.getString("Name"));
                user.setPhone(rs.getString("Phone"));
                user.setLeve(rs.getInt("Leve"));
                user.setFlag(rs.getInt("Flag"));
                user.setUsername(rs.getString("Username"));
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    public void deleteUser(int user_id) throws SQLException{
        Connection connection = DBConnect.getJDBCConnection();
        Statement statement = connection.createStatement();
        int result = statement.executeUpdate("DELETE FROM Users WHERE Users_id=" + user_id);
    }
    
    public boolean blockUser(int user_id){
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "UPDATE Users SET Flag = 0 WHERE Users_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user_id);
            int rs = preparedStatement.executeUpdate();
            if(rs > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean unlockUser(int user_id){
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "UPDATE Users SET Flag = 1 WHERE Users_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user_id);
            int rs = preparedStatement.executeUpdate();
            if(rs > 0)
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public JTable StatisUserByName(){
        
        JTable table = new JTable();
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT Name, COUNT(Name) FROM Users GROUP BY Name";    
       
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return table;
    }
    
    public JTable StatisUserByRole(){
        
        JTable table = new JTable();
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT Leve, COUNT(Leve) FROM Users GROUP BY Leve";    
       
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (SQLException ex) {
            Logger.getLogger(ReaderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return table;
    }
    public boolean changePassword(String currentUser, String password){
        Connection connection = DBConnect.getJDBCConnection();
        String sql = "UPDATE Users SET Password = ? WHERE Username = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, currentUser);
            int rs = preparedStatement.executeUpdate();
            if(rs > 0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
