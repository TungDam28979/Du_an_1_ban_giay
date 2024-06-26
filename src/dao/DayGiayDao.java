package dao;

import java.util.ArrayList;
import java.util.List;
import model.KichCo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DayGiay;
import model.HdeGiay;
import utility.JDBCHelper;

public class DayGiayDao {

    String SELECT_ALL_BY_SQL = """
                                select * from tbl_dayGiay
                                where tbl_dayGiay.trangThai = N'Đang áp dụng'
                               order by [ngayTao] desc""";

    String Insert_DayGiay_BY_SQL = """
                                   insert into tbl_DayGiay ( [TenDayGiay] , [trangThai] , nguoiTao ) 
                                   values
                                   ( ?  , ?  ,  ? )""";

    String Update_DayGiay_BY_SQL = """
                                   update tbl_DayGiay
                                   set [TenDayGiay] = ? , nguoiSua = ?
                                   where id = ? """;

    String DELETE_DayGiay_BY_ID = """
                             UPDATE tbl_dayGiay 
                             set trangThai = N'Dừng áp dụng'
                             where id = ?""";

    public void insert(DayGiay e) {
        JDBCHelper.update(Insert_DayGiay_BY_SQL,
                e.getName(),
                e.getStatus(),
                e.getCreate_by()
        );
    }

    public void update(DayGiay e) {
        JDBCHelper.update(Update_DayGiay_BY_SQL,
                e.getName(),
                e.getUpdate_by(),
                e.getId()
        );
    }

    public int delete(int id) {
        return JDBCHelper.update(DELETE_DayGiay_BY_ID, id);
    }

    public List<DayGiay> selectAll() {
        return selectBySQL(SELECT_ALL_BY_SQL);
    }

    public DayGiay selectById(String k) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<DayGiay> selectBySQL(String sql, Object... args) {
        List<DayGiay> listDayGiay = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
            while (rs.next()) {
                DayGiay dg = new DayGiay();
                dg.setId(rs.getInt("id"));
                dg.setName(rs.getString("TenDayGiay"));
                dg.setStatus(rs.getString("trangThai"));
                dg.setCreate_by(rs.getInt("nguoiTao"));
                dg.setUpdate_by(rs.getInt("nguoiSua"));
                dg.setCreate_at(rs.getDate("ngayTao"));
                dg.setUpdate_at(rs.getDate("ngaySua"));
                listDayGiay.add(dg);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(DayGiayDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDayGiay;
    }

}//end life
