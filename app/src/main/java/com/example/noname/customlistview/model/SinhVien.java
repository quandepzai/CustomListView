package com.example.noname.customlistview.model;

public class SinhVien {
    private String ten;
    private String diachi;
    private String anh;

    public SinhVien(String ten, String diachi, String anh) {
        this.ten = ten;
        this.diachi = diachi;
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }
}
