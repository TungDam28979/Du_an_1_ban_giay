package dao;

import java.util.ArrayList;
import java.util.List;
import model.KichCo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.JDBCHelper;

public class KichCoDAO {

    String SELECT_ALL_BY_SQL = """
                              Select * from tbl_KichCo
                               where tbl_KichCo.trangThai = N'Đang áp dụng'
                               order by ngayTao desc """;
    String INSERT_KC_BY_SQL = """
                              insert into tbl_KichCo	( [kichCo] , [trangThai] , nguoiTao ) 
                              values 
                              (?, ? , ? )""";
    String UPDATE_KC_BY_NAME = """
                              update tbl_KichCo
                               set [kichCo] =  ? , nguoiSua = ?
                               where id = ?""";
    String DELETE_KC_BY_ID = """
                             UPDATE tbl_kichCo 
                             set trangThai = N'Dừng áp dụng'
                             where id = ?""";

    public void insert(KichCo e) {
        JDBCHelper.update(INSERT_KC_BY_SQL,
                e.getName(),
                e.getStatus(),
                e.getCreate_by()
        );
    }

    public void update(KichCo e) {
        JDBCHelper.update(UPDATE_KC_BY_NAME,
                e.getName(),
                e.getUpdate_by(),
                e.getId()
        );
    }

    public int delete(int id) {//cập nhật lại trạng thái dựa vào id
        return JDBCHelper.update(DELETE_KC_BY_ID, id);
    }

    public List<KichCo> selectAll() {
        return selectBySQL(SELECT_ALL_BY_SQL);
    }

    public KichCo selectById(String k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<KichCo> selectBySQL(String sql, Object... args) {
        List<KichCo> listKichCo = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                KichCo kc = new KichCo();
                kc.setId(rs.getInt("id"));
                kc.setName(rs.getInt("kichCo"));
                kc.setStatus(rs.getString("trangThai"));
                kc.setCreate_by(rs.getInt("nguoiTao"));
                kc.setUpdate_by(rs.getInt("nguoiSua"));
                kc.setCreate_at(rs.getDate("ngayTao"));
                kc.setUpdate_at(rs.getDate("ngaySua"));
                listKichCo.add(kc);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(KichCoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listKichCo;
    }

}//end life
