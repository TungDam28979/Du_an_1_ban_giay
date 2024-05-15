/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class HoaDon {
    private int id;
    private String idKH;
    private String idNV;
    private int idPGG;
    private int idHTTT;
    private String name;
    private String phone;
    private String address;
    private Date ngayNNH;
    private boolean trangThai;
    private int nguoiTao;
    private int nguoiSua;
    private Date ngayTao;
    private Date ngaySua;
    private double thanhTien;

    public HoaDon() {
    }

    public HoaDon(int id, String idKH, String idNV, int idPGG, int idHTTT, String name, String phone, String address, Date ngayNNH, boolean trangThai, int nguoiTao, int nguoiSua, Date ngayTao, Date ngaySua, double thanhTien) {
        this.id = id;
        this.idKH = idKH;
        this.idNV = idNV;
        this.idPGG = idPGG;
        this.idHTTT = idHTTT;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.ngayNNH = ngayNNH;
        this.trangThai = trangThai;
        this.nguoiTao = nguoiTao;
        this.nguoiSua = nguoiSua;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.thanhTien = thanhTien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdKH() {
        return idKH;
    }

    public void setIdKH(String idKH) {
        this.idKH = idKH;
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public int getIdPGG() {
        return idPGG;
    }

    public void setIdPGG(int idPGG) {
        this.idPGG = idPGG;
    }

    public int getIdHTTT() {
        return idHTTT;
    }

    public void setIdHTTT(int idHTTT) {
        this.idHTTT = idHTTT;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getNgayNNH() {
        return ngayNNH;
    }

    public void setNgayNNH(Date ngayNNH) {
        this.ngayNNH = ngayNNH;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(int nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public int getNguoiSua() {
        return nguoiSua;
    }

    public void setNguoiSua(int nguoiSua) {
        this.nguoiSua = nguoiSua;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    
    public Object[] toDataRow(){
        return new Object[]{this.id,this.name, this.address, this.idHTTT, this.idKH, this.idNV, this.idNV, this.idPGG, this.ngayNNH,
         this.ngaySua, this.ngayTao, this.nguoiSua, this.nguoiTao, this.phone, this.thanhTien, this.trangThai};
    }
}
