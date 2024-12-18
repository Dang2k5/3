
package com.QuanLyThuVien.model;

public class Bill {
    private int bill_id;
    private int reader_id;
    private int user_id;
    private int deposit;
    private String date_muon;
    private String date_hen;

    public String getDate_hen() {
        return date_hen;
    }

    public void setDate_hen(String date_hen) {
        this.date_hen = date_hen;
    }

    public int getBill_id() {
        return bill_id;
    }

    public void setBill_id(int bill_id) {
        this.bill_id = bill_id;
    }

    public int getReader_id() {
        return reader_id;
    }

    public void setReader_id(int reader_id) {
        this.reader_id = reader_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public String getDate_muon() {
        return date_muon;
    }

    public void setDate_muon(String date_muon) {
        this.date_muon = date_muon;
    }
    
    
}
