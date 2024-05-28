
package model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;


public class Voucher {
     private UUID id;
    private long id1;
     private String ma;
     private String mota;
    private String hinhthuc;
    private BigDecimal giatrivoucher;
    private BigDecimal giatritoidavc;
    private Float giatriap;
     private Integer soluong;
    //  private Integer dkhoadon;
     private Date  ngayketthuc;
    private Date  ngaybatdau;
    private int trangthai;
    private Date ngaytao;
    private int id_nhanvien;
    private boolean deleted;

    public Voucher() {
    }

    public Voucher(String ma, String mota, String hinhthuc, BigDecimal giatrivoucher, BigDecimal giatritoidavc, Float giatriap, Integer soluong, Date ngayketthuc, Date ngaybatdau, int trangthai, Date ngaytao, int id_nhanvien) {
        this.ma = ma;
        this.mota = mota;
        this.hinhthuc = hinhthuc;
        this.giatrivoucher = giatrivoucher;
        this.giatritoidavc = giatritoidavc;
        this.giatriap = giatriap;
        this.soluong = soluong;
        this.ngayketthuc = ngayketthuc;
        this.ngaybatdau = ngaybatdau;
        this.trangthai = trangthai;
        this.ngaytao = ngaytao;
        this.id_nhanvien = id_nhanvien;
    }

    public Voucher(String ma, String mota, String hinhthuc, BigDecimal giatrivoucher, BigDecimal giatritoidavc, Float giatriap, Integer soluong, Date ngayketthuc, Date ngaybatdau, int trangthai, Date ngaytao,boolean deleted) {
        this.ma = ma;
        this.mota = mota;
        this.hinhthuc = hinhthuc;
        this.giatrivoucher = giatrivoucher;
        this.giatritoidavc = giatritoidavc;
        this.giatriap = giatriap;
        this.soluong = soluong;
        this.ngayketthuc = ngayketthuc;
        this.ngaybatdau = ngaybatdau;
        this.trangthai = trangthai;
        this.ngaytao = ngaytao;
        this.deleted = deleted;
    }

    public Voucher(UUID id, long id1, String ma,String mota, String hinhthuc, BigDecimal giatrivoucher, BigDecimal giatritoidavc, Integer soluong,  Date ngayketthuc, Date ngaybatdau, int trangthai) {
        this.id = id;
        this.id1 = id1;
        this.ma = ma;
        this.mota =mota;
        this.hinhthuc = hinhthuc;
        this.giatrivoucher = giatrivoucher;
        this.giatritoidavc = giatritoidavc;
        this.soluong = soluong;
        //this.dkhoadon = dkhoadon;
        this.ngayketthuc = ngayketthuc;
        this.ngaybatdau = ngaybatdau;
        this.trangthai = trangthai;
    }

    public Voucher(String ma,String mota, String hinhthuc, BigDecimal giatrivoucher, BigDecimal giatritoidavc, Float giatriap,Integer soluong, Date ngayketthuc, Date ngaybatdau, int trangthai) {
        this.ma = ma;
        this.mota= mota;
        this.hinhthuc = hinhthuc;
        this.giatrivoucher = giatrivoucher;
        this.giatritoidavc = giatritoidavc;
        this.giatriap = giatriap;
        this.soluong = soluong;
        //this.dkhoadon = dkhoadon;
        this.ngayketthuc = ngayketthuc;
        this.ngaybatdau = ngaybatdau;
        this.trangthai = trangthai;
    }

    public Voucher(long id1, String ma,String mota, String hinhthuc, BigDecimal giatrivoucher, BigDecimal giatritoidavc, Float giatriap,Integer soluong, Date ngayketthuc, Date ngaybatdau, int trangthai) {
        this.id1 = id1;
        this.ma = ma;
        this.mota = mota;
        this.hinhthuc = hinhthuc;
        this.giatrivoucher = giatrivoucher;
        this.giatritoidavc = giatritoidavc;
        this.giatriap=giatriap;
        this.soluong = soluong;
        //this.dkhoadon = dkhoadon;
        this.ngayketthuc = ngayketthuc;
        this.ngaybatdau = ngaybatdau;
        this.trangthai = trangthai;
    }

    public Voucher(Date ngayTao) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId_nhanvien() {
        return id_nhanvien;
    }

    public void setId_nhanvien(int id_nhanvien) {
        this.id_nhanvien = id_nhanvien;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public long getId1() {
        return id1;
    }

    public void setId1(long id1) {
        this.id1 = id1;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getHinhthuc() {
        return hinhthuc;
    }

    public void setHinhthuc(String hinhthuc) {
        this.hinhthuc = hinhthuc;
    }

    public BigDecimal getGiatrivoucher() {
        return giatrivoucher;
    }

    public void setGiatrivoucher(BigDecimal giatrivoucher) {
        this.giatrivoucher = giatrivoucher;
    }

    public BigDecimal getGiatritoidavc() {
        return giatritoidavc;
    }

    public void setGiatritoidavc(BigDecimal giatritoidavc) {
        this.giatritoidavc = giatritoidavc;
    }

    public Float getGiatriap() {
        return giatriap;
    }

    public void setGiatriap(Float giatriap) {
        this.giatriap = giatriap;
    }

    public Integer getSoluong() {
        return soluong;
    }

    public void setSoluong(Integer soluong) {
        this.soluong = soluong;
    }

    public Date getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(Date ngaytao) {
        this.ngaytao = ngaytao;
    }

    public Date getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(Date ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public Date getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(Date ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }
public Voucher(int trangthai) {
        this.trangthai = trangthai;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Object[] toDaTaRow() {
        String trangthai = "";
        int Trangthai = this.getTrangthai();
        if (Trangthai == 1) {
            trangthai = "Sắp diễn ra";
        } else if (Trangthai == 2) {
            trangthai = "Đang diễn ra";
        } else if (Trangthai == 3) {
            trangthai = "Đã kết thúc";
        }
        int stt = 0;
        stt++;
        return new Object[]{stt++, this.getMa(), this.getMota(), this.getHinhthuc(),this.getGiatrivoucher(),this.getGiatritoidavc(),this.getGiatriap(),this.getSoluong(),this.getNgaybatdau(),this.getNgayketthuc()};
    }
}
