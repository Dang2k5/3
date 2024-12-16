
package com.QuanLyThuVien.model;

import java.util.Objects;


public class User {
    private int user_id;
    private String name;
    private String phone;
    private int leve;
    private String username;
    private String password;
    private int flag;

    public User() {
    }

    public User(String name, String phone, int leve, String username, String password, int flag) {
        this.name = name;
        this.phone = phone;
        this.leve = leve;
        this.username = username;
        this.password = password;
        this.flag = flag;
    }

    
    public User(int user_id, String name, String phone, int leve, String username, String password, int flag) {
        this.user_id = user_id;
        this.name = name;
        this.phone = phone;
        this.leve = leve;
        this.username = username;
        this.password = password;
        this.flag = flag;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + this.user_id;
        hash = 43 * hash + Objects.hashCode(this.name);
        hash = 43 * hash + Objects.hashCode(this.phone);
        hash = 43 * hash + this.leve;
        hash = 43 * hash + Objects.hashCode(this.username);
        hash = 43 * hash + Objects.hashCode(this.password);
        hash = 43 * hash + this.flag;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.user_id != other.user_id) {
            return false;
        }
        if (this.leve != other.leve) {
            return false;
        }
        if (this.flag != other.flag) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return Objects.equals(this.password, other.password);
    }

    
    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getLeve() {
        return leve;
    }

    public void setLeve(int leve) {
        this.leve = leve;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
