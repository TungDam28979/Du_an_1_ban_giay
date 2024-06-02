/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;
import java.sql.*;
import model.Login_Model;
import utility.DBConnect;
/**
 *
 * @author Tran Viet Vuong
 */
public class Login_Repo {
    public Login_Model getDangnhap(String manv, String mk) {
        try {
            Connection con = DBConnect.getConnection();
            String sql = ("""
                          SELECT soDT, matKhau , chucVu , ID , maNhanVien   FROM tbl_nhanVien 
                          WHERE Manhanvien =? AND MATKHAU=?  and deleted =1 """);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, manv);
            ps.setString(2, mk);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Login_Model lg = new Login_Model();
                lg.setId_NV(rs.getInt("ID"));
                lg.setManv(rs.getString("maNhanVien"));
                lg.setMatkhau(rs.getString("matKhau"));
                lg.setChucVu(rs.getInt("chucVu"));
                return lg;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
