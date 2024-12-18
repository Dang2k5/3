
package com.QuanLyThuVien.service;

import com.QuanLyThuVien.dao.CategoryDao;
import com.QuanLyThuVien.model.Category;
import java.util.List;

public class CategoryService {
    
    private CategoryDao catetgoryDao;

    public CategoryService() {
        catetgoryDao = new CategoryDao();
    }
    public void addCategory(Category category){
        catetgoryDao.addCategory(category);
    }
    public void deleteCategory(int category_id){
        catetgoryDao.deleteCategory(category_id);
    }
    public List<Category> getAllCategory(){
        return catetgoryDao.getAllCategory();
    }
    
    public int getCategoryIdByValue(String value){
        return catetgoryDao.getCategoryIdByValue(value);
    }
    
    public String getCategoryById(int category_id){
        return catetgoryDao.getCategoryById(category_id);
    }
    
    public int getCountBookByCategory(int category_id){
        return catetgoryDao.getCountBookByCategory(category_id);
    }
    
    public int getCountBookByCategoryTotal(int category_id){
        return catetgoryDao.getCountBookByCategoryTotal(category_id);
    }
}
