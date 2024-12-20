
package com.QuanLyThuVien.service;

import com.QuanLyThuVien.dao.UserDao;
import com.QuanLyThuVien.model.User;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JTable;


public class UserService {
    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }
    public User getUserById(int user_id){
        return userDao.getUserById(user_id);
    }
    
    public List<User> getAllUser(){
        return userDao.getAllUser();
    }
    
    public List<User> getUserByLeve(int leve){
        return userDao.getUserByLeve(leve);
    }
    public void addUser(User user){
        userDao.addUser(user);
    }
    
    public User Checkpassword(String password){
        return userDao.CheckPassword(password);
    }
    public User CheckUsername(String username){
        return userDao.CheckUsername(username);
    }
    
    public List<User> searchUserFromName(String name){
        return userDao.searchUserFromName(name);
    }
    
    public List<User> searchUserFromUsername(String userName){
        return userDao.searchUserFromUsername(userName);
    }
    
    public void deleteUser(int user_id) throws SQLException{
        userDao.deleteUser(user_id);
    }
    
    public boolean blockUser(int user_id){
        return userDao.blockUser(user_id);
    }
    
    public boolean unlockUser(int user_id){
        return userDao.unlockUser(user_id);
    }
    
    public User CheckLogin(String userName, String passWord){
        return userDao.checkLogin(userName, passWord);
    }
    
    public JTable StatisUserByName(){
        return userDao.StatisUserByName();
    }
    
    public JTable StatisUserByRole(){
        return userDao.StatisUserByRole();
    }
    public boolean ChangePassword(String currentUser, String password){
        return userDao.changePassword(currentUser, password);
    }
}
