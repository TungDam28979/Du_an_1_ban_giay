/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Voucher;
import utility.DBConnect;

/**
 *
 * @author cuong
 */
public class service_voucher {

    String sql = null;
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Voucher> getAll1() {
        sql = "select  mavoucher,motavoucher,hinhthucvoucher , giatrivoucher,giatritoidavoucher,giatriapdungvoucher,soluongvoucher,ngayKetThuc,ngayBatDau,trangthai  from tbl_voucher where  deleted = 1  ORDER BY ngaytao DESC";
        List<Voucher> listsv = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            // ps.setObject(1, deleted);
            rs = ps.executeQuery();

            while (rs.next()) {
                Voucher x = new Voucher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getFloat(6), rs.getInt(7), rs.getDate(8), rs.getDate(9), rs.getInt(10));
                listsv.add(x);
            }
            return listsv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Voucher> find(JDateChooser d1, JDateChooser d2) {
        String sql = "SELECT mavoucher, motavoucher, hinhthucvoucher, giatrivoucher, giatritoidavoucher, giatriapdungvoucher, soluongvoucher, ngayKetThuc, ngayBatDau, trangthai FROM tbl_voucher WHERE  ngaybatdau  >= ? and ngaybatdau < ?";
        List<Voucher> list = new ArrayList<>();

        try {
            con = DBConnect.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            // Lấy giá trị từ JDateChooser
//        java.util.Date startDate = d1.getDate();
//        java.util.Date endDate = d2.getDate();
//        if (startDate == null || endDate == null) {
//            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ ngày và giờ");
//            return list;
//        }
            // Chuyển đổi thành Timestamp
            java.sql.Timestamp startTimestamp = new java.sql.Timestamp(d1.getDate().getTime());
            java.sql.Timestamp endTimestamp = new java.sql.Timestamp(d2.getDate().getTime());

//        java.sql.Timestamp startTimestamp = new java.sql.Timestamp(startDate.getTime());
//        java.sql.Timestamp endTimestamp = new java.sql.Timestamp(endDate.getTime());
            ps.setTimestamp(1, startTimestamp);
            ps.setTimestamp(2, endTimestamp);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Voucher sv = new Voucher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getFloat(6), rs.getInt(7), rs.getDate(8), rs.getDate(9), rs.getInt(10));
                list.add(sv);
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//     public List<voucher> find(JDateChooser  d1, JDateChooser  d2) {
//       sql = "SELECT  mavoucher,motavoucher,hinhthucvoucher , giatrivoucher,giatritoidavoucher,giatriapdungvoucher,soluongvoucher,ngayKetThuc,ngayBatDau,trangthai FROM tbl_voucher WHERE motavoucher BETWEEN ? AND ?";
//    List<voucher> list = new ArrayList<>();
//
//    try {
//        con = DBConnect.getConnection();
//        ps = con.prepareStatement(sql);
//        ps.setObject(1, d1.getDate());
//        ps.setObject(2, d2.getDate());
//        rs = ps.executeQuery();
//          
//        while (rs.next()) {
//            voucher sv = new voucher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getFloat(6), rs.getInt(7), rs.getDate(8), rs.getDate(9), rs.getInt(10));
//            list.add(sv);
//        }
//
//        return list;
//    } catch (Exception e) {
//        e.printStackTrace();
//        return null;
//    }
//    }
    public List<Voucher> findcbb(String loaiGiam) {
        sql = "select mavoucher,motavoucher,hinhthucvoucher , giatrivoucher,giatritoidavoucher,giatriapdungvoucher,soluongvoucher,ngayKetThuc,ngayBatDau,trangthai  from tbl_voucher  where hinhthucvoucher = ?";
        List<Voucher> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, loaiGiam);
            rs = ps.executeQuery();
            while (rs.next()) {
                Voucher sv = new Voucher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getFloat(6), rs.getInt(7), rs.getDate(8), rs.getDate(9), rs.getInt(10));
                list.add(sv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Voucher> findcbbtt(int trangthai) {
        sql = "select mavoucher,motavoucher,hinhthucvoucher , giatrivoucher,giatritoidavoucher,giatriapdungvoucher,soluongvoucher,ngayKetThuc,ngayBatDau,trangthai from tbl_voucher  where trangthai = ?";
        List<Voucher> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, trangthai);
            rs = ps.executeQuery();
            while (rs.next()) {
                Voucher sv = new Voucher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getFloat(6), rs.getInt(7), rs.getDate(8), rs.getDate(9), rs.getInt(10));
                list.add(sv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Voucher> loadData1() {
        sql = "select mavoucher,motavoucher,hinhthucvoucher , giatrivoucher,giatritoidavoucher,giatriapdungvoucher,soluongvoucher,ngayKetThuc,ngayBatDau,trangthai   from tbl_voucher   order by ngaytao desc";// WHERE HOTEN NOT IN (SELECT TOP "+(trang*5-5)+" FROM STUDENTS)
        List<Voucher> list = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                Voucher sv = new Voucher();
                sv = new Voucher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getFloat(6), rs.getInt(7), rs.getDate(8), rs.getDate(9), rs.getInt(10));
                list.add(sv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    public List<voucher> getAll() {
//        sql = "select MoTa,loaivoucher,giatrivoucher,Create_by,Update_by,ngaybatdau,NgayKetThuc,Status from tbl_Voucher";
//        List<voucher> listsv = new ArrayList<>();
//        try {
//            con = DBConnect.getConnection();
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                voucher x = new voucher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getFloat(6), rs.getInt(7), rs.getDate(8), rs.getDate(9),rs.getInt(10));
//                listsv.add(x);
//            }
//            return listsv;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
    public int add(Voucher x) {
        //INSERT INTO tbl_voucher(mavoucher , motavoucher, hinhthucvoucher,giatrivoucher,giatritoidavoucher,soluongvoucher,ngaybatdau,ngayketthuc,trangthai,nguoitao,giatriapdungvoucher)
        sql = "insert into tbl_Voucher (mavoucher,motavoucher,hinhthucvoucher , giatrivoucher,giatritoidavoucher,giatriapdungvoucher,soluongvoucher,ngayKetThuc,ngayBatDau,trangthai ,nguoitao,deleted) values (?,?,?,?,?,?,?,?,?,?,(SELECT TOP 1 id FROM tbl_nhanVien ORDER BY NEWID()),1)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, x.getMa());
            ps.setObject(2, x.getMota());
            ps.setObject(3, x.getHinhthuc());

            ps.setObject(4, x.getGiatrivoucher());
            ps.setObject(5, x.getGiatritoidavc());
            ps.setObject(6, x.getGiatriap());
            ps.setObject(7, x.getSoluong());
            ps.setObject(9, x.getNgaybatdau());
            ps.setObject(8, x.getNgayketthuc());
            ps.setObject(10, x.getTrangthai());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }

    public int updateTT1(Voucher x, String ma) {
        sql = "UPDATE tbl_voucher SET trangthai =1 where mavoucher =?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateTT2(Voucher x, String ma) {
        sql = "UPDATE tbl_voucher SET trangthai =2 where mavoucher =?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateTT3(Voucher x, String ma) {
        sql = "UPDATE tbl_voucher SET trangthai =3 where mavoucher =?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update2(Voucher x, String ma) {
        sql = "UPDATE Voucher SET ngaybatdau =ngaytao, ngayketthuc = ngaytao, trangthai=3 where mavoucher = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Voucher getID(String ma) {
        Voucher sv = null;
        sql = "select mavoucher,motavoucher,hinhthucvoucher , giatrivoucher,giatritoidavoucher,giatriapdungvoucher,soluongvoucher,ngayKetThuc,ngayBatDau,trangthai  from tbl_voucher where mavoucher = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                sv = new Voucher(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBigDecimal(4), rs.getBigDecimal(5), rs.getFloat(6), rs.getInt(7), rs.getDate(8), rs.getDate(9), rs.getInt(10));
            }
            return sv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int delete(Voucher x, String ma) {
        sql = "UPDATE tbl_Voucher SET deleted = 0 WHERE mavoucher = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
//

    public int update(Voucher x, String ma) {
        sql = "update tbl_Voucher  set mavoucher=?,motavoucher=?,hinhthucvoucher =?, giatrivoucher=?,giatritoidavoucher=?,giatriapdungvoucher=?,soluongvoucher=?,ngayKetThuc= ?,ngayBatDau=?,trangthai =?   where mavoucher = ?";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, x.getMa());
            ps.setObject(2, x.getMota());
            ps.setObject(3, x.getHinhthuc());
            ps.setObject(4, x.getGiatrivoucher());
            ps.setObject(5, x.getGiatritoidavc());
            ps.setObject(6, x.getGiatriap());
            ps.setObject(7, x.getSoluong());
            ps.setObject(9, x.getNgaybatdau());
            ps.setObject(8, x.getNgayketthuc());
            ps.setObject(10, x.getTrangthai());
            ps.setObject(11, ma);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

//    public List<voucher> find(LocalDateTime startDateTime, LocalDateTime endDateTime) {
//         sql = "select  mavoucher,motavoucher,hinhthucvoucher , giatrivoucher,giatritoidavoucher,giatriapdungvoucher,soluongvoucher,ngayKetThuc,ngayBatDau,trangthai   from tbl_voucher where mavoucher between  ? and ? ";
//        List<voucher> list  = new ArrayList<>();
//        try {
//            con= DBConnect.getConnection();
//            ps = con.prepareStatement(sql);
//            ps.setObject(1, startDateTime.getDate());
//            ps.setObject(2, endDateTime.getDate());
//            rs = ps.executeQuery();
//            while(rs.next()){
//                voucher sv = new voucher(rs.getString(1), rs.getString(2),rs.getString(3),rs.getBigDecimal(4),rs.getBigDecimal(5),rs.getFloat(6),rs.getInt(7),rs.getDate(8),rs.getDate(9),rs.getInt(10));
//                list.add(sv);
//            }
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
