/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import java.sql.*;
import java.util.ArrayList;
import model.Forgotpass_Model;
import utility.DBConnect;
/**
 *
 * @author Tran Viet Vuong
 */
public class Forgotpass_Repo {
    public int updatepass(Forgotpass_Model fgp) {
        try {
            Connection con = DBConnect.getConnection();
            String up = "UPDATE tbl_nhanvien SET MATKHAU = ? WHERE MANhanvien = ? and deleted =1 ";
            PreparedStatement ps = con.prepareStatement(up);
            ps.setString(2, fgp.getUser());
            ps.setString(1, fgp.getMatkhau());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<Forgotpass_Model> selectEmail(String email) {
        ArrayList<Forgotpass_Model> list = new ArrayList<>();
        try {
            Connection con = DBConnect.getConnection();
            String get = "SELECT EMAIL FROM tbl_nhanvien where email = ?";
            PreparedStatement ps = con.prepareStatement(get);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Forgotpass_Model fg = new Forgotpass_Model();
                fg.setEmail(rs.getString(1));
                list.add(fg);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean getuser(Forgotpass_Model fgp) {
        try {
            Connection con = DBConnect.getConnection();
            String get = "SELECT MANhanVien FROM tbl_nhanvien WHERE MANhanvien = ?";
            PreparedStatement ps = con.prepareStatement(get);
            ps.setString(1, fgp.getUser());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
