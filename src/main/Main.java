package main;

import com.QuanLyThuVien.view.LoginFrame;

public class Main {
    
    public static void main(String[] args) {
        LoginFrame frame = new LoginFrame();
        frame.setTitle("Đăng Nhập Hệ Thống");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
}
