
package com.QuanLyThuVien.dao;

import com.QuanLyThuVien.model.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BookDao {
    public List<Book> getAllBook(){
        List<Book> books = new ArrayList<Book>();       
        Connection connection = DBConnect.getJDBCConnection();        
        String sql = "SELECT * FROM Book";           
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);           
            ResultSet rs = preparedStatement.executeQuery();           
            while(rs.next()){
                Book book = new Book();
                book.setBook_id(rs.getInt("Book_id"));
                book.setTitle(rs.getString("Title"));
                book.setAuthor(rs.getString("Author"));
                book.setCategory_id(rs.getInt("Category_id"));               
                book.setAmount(rs.getInt("Amount"));
                book.setIntroduce(rs.getString("Introduce"));
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }
    
    public List<Book> getAllUniqueBookByAuthor(){
        List<Book> books = new ArrayList<Book>();       
        Connection connection = DBConnect.getJDBCConnection();        
        String sql = "SELECT Author, COUNT(*) AS N'TỔNG SỐ SÁCH' FROM Book GROUP BY author";     
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);           
            ResultSet rs = preparedStatement.executeQuery();           
            while(rs.next()){
                Book book = new Book();
                book.setAuthor(rs.getString("Author"));
                book.setAmount(rs.getInt("TỔNG SỐ SÁCH"));
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }
    
    public void addBook(Book book){
       Connection connection = DBConnect.getJDBCConnection();
       String sql = "INSERT INTO Book(Title, Author, Category_id, Amount, Introduce) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getCategory_id());
            preparedStatement.setInt(4, book.getAmount());           
            preparedStatement.setString(5, book.getIntroduce());
            int rs = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateBook(Book book){
        Connection connection = DBConnect.getJDBCConnection();
        String sql = "UPDATE Book SET Title=?,Author=?,Category_id=?,Amount=?,Introduce=? WHERE Book_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());   
            preparedStatement.setInt(3, book.getCategory_id());
            preparedStatement.setInt(4, book.getAmount());
            preparedStatement.setString(5, book.getIntroduce());
            preparedStatement.setInt(6, book.getBook_id());
            int rs = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void deleteBook(int book_id){
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql2 = "DELETE Bill_Detail WHERE Book_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setInt(1, book_id);
            int rs = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String sql1 = "DELETE Book WHERE Book_id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setInt(1, book_id);
            int rs = preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public Book getBookById(int book_id){
         
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT * FROM Book WHERE Book_id = ?";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, book_id);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Book book = new Book();
                book.setBook_id(rs.getInt("Book_id"));
                book.setTitle(rs.getString("Title"));
                book.setAuthor(rs.getString("Author"));
                book.setCategory_id(rs.getInt("Category_id"));                
                book.setAmount(rs.getInt("Amount"));
                book.setIntroduce(rs.getString("Introduce"));
                return book;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    public List<Book> searchBookFromTitle(String title){
        List<Book> books = new ArrayList<Book>();
        
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT * FROM Book where Title LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(title);
        stringBufferTile.append("%");
        String titleLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, titleLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Book book = new Book();
                book.setBook_id(rs.getInt("Book_id"));
                book.setTitle(rs.getString("Title"));
                book.setAuthor(rs.getString("Author"));
                book.setCategory_id(rs.getInt("Category_id"));
                book.setAmount(rs.getInt("Amount"));                
                book.setIntroduce(rs.getString("Introduce"));
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }
    
    public List<Book> searchBookFromAuthor(String author){
        List<Book> books = new ArrayList<Book>();
        
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT * FROM Book where Author LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(author);
        stringBufferTile.append("%");
        String authorLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, authorLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Book book = new Book();
                book.setBook_id(rs.getInt("Book_id"));
                book.setTitle(rs.getString("Title"));
                book.setAuthor(rs.getString("Author"));
                book.setCategory_id(rs.getInt("Category_id"));                
                book.setAmount(rs.getInt("Amount"));
                book.setIntroduce(rs.getString("Introduce"));
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }
    
    public List<Book> searchBookFromCategory(String category){
        List<Book> books = new ArrayList<Book>();
        
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT * FROM Book INNER JOIN Category ON Book.category_id = Category.Category_id where Category_name LIKE ?";    
        
        StringBuffer stringBufferTile = new StringBuffer();
        stringBufferTile.append("%");
        stringBufferTile.append(category);
        stringBufferTile.append("%");
        String categoryLike = stringBufferTile.toString();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, categoryLike);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Book book = new Book();
                book.setBook_id(rs.getInt("Book_id"));
                book.setTitle(rs.getString("Title"));
                book.setAuthor(rs.getString("Author"));
                book.setCategory_id(rs.getInt("Category_id"));             
                book.setAmount(rs.getInt("Amount"));
                book.setIntroduce(rs.getString("Introduce"));
                books.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }
    public int getCountBook(int book_id){
        Connection connection = DBConnect.getJDBCConnection();
        
        String sql = "SELECT COUNT(*) FROM BOOK";    
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, book_id);
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
