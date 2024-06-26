/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;
import BanHangDAO.BanHangDAO;
import BanHangDAO.HDCT_DAO;
import BanHangDAO.HTTT_DAO;
import BanHangDAO.ThanhToanDAO;
import BanHangDAO.TrangThaiHoaDonDAO;
import BanHangDAO.TrangThaiThanhToanDAO;
import ModelBanHang.HDCTBanHang;
import ModelBanHang.HoaDonBanHang;
import ModelBanHang.hinhThucThanhToan;
import dao.KichCoDAO;
import dao.MauSacDAO;
import dao.ProductDAO;
import dao.ProductDetaisDAO;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import model.GetChucVu;
import model.Ispct;
import model.KhachHang;
import model.KichCo;
import model.MauSac;
import model.NhanVien;
import model.ThanhToanModel;
import model.Voucher;
import service.ChooseKH;
import service.KhachHangService;
import service.NhanVienService;
import service.service_voucher;
import utility.MsgBox;
/**
 *
 * @author Tran Viet Vuong
 */
public class JBanHang extends javax.swing.JPanel implements ChooseKH{

    /**
     * Creates new form JBanHang
     */
    public JBanHang() {
        initComponents();
        initDSSP(); //Fill lên DS_SPCT với trạng thái SP là "Đang Kinh Doanh"
        initHD();   //Fill lên hóa đơn vs trạng thái "Chờ thanh toán".
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        tbp_LoaiHoaDon = new javax.swing.JTabbedPane();
        tbp_TaiQuay = new javax.swing.JPanel();
        pn_thongTinKH = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_maKH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_tenKH = new javax.swing.JTextField();
        btn3_HuySP1 = new swingStyle.btn();
        pn_thongTinHoaDon = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txt_maHD = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_maNV = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_tongGiaTriHD = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txt_thanhToan = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cbb_hinhThucThanhToan = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        txt_tienKhachDua = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txt_tienKhachCK = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txt_tienThua = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txt_ngayTaoHoaDon = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        cbb_voucher_taiQuay = new javax.swing.JComboBox<>();
        btn2_xoaDon1 = new swingStyle.btn();
        btn2_xoaDon2 = new swingStyle.btn();
        pn_gioHang = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_dsGioHang = new javax.swing.JTable();
        btn3_HuySP = new swingStyle.btn();
        pn_hoaDon = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_dshd = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        lbl_giaTriSoHD = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lbl_HDChoosed = new javax.swing.JLabel();
        btn1_taoDon = new swingStyle.btn();
        pn_dssp = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbl_dssp = new javax.swing.JTable();
        txt_searchSPCT = new javax.swing.JTextField();
        cbb_mauSac2 = new swingStyle.Combobox();
        cbb_kichThuoc2 = new swingStyle.Combobox();
        btn4_boLoc = new swingStyle.btn();

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("BÁN HÀNG");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pn_thongTinKH.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thông tin khách hàng"));
        pn_thongTinKH.setForeground(new java.awt.Color(242, 242, 242));

        jLabel2.setText("Mã KH :");

        txt_maKH.setBackground(new java.awt.Color(242, 242, 242));
        txt_maKH.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
        txt_maKH.setDoubleBuffered(true);
        txt_maKH.setEnabled(false);
        txt_maKH.setPreferredSize(new java.awt.Dimension(200, 25));

        jLabel3.setText("Tên KH : ");

        txt_tenKH.setBackground(new java.awt.Color(242, 242, 242));
        txt_tenKH.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
        txt_tenKH.setPreferredSize(new java.awt.Dimension(200, 25));

        btn3_HuySP1.setText("Chọn KH");
        btn3_HuySP1.setRadius(19);
        btn3_HuySP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3_HuySP1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_thongTinKHLayout = new javax.swing.GroupLayout(pn_thongTinKH);
        pn_thongTinKH.setLayout(pn_thongTinKHLayout);
        pn_thongTinKHLayout.setHorizontalGroup(
            pn_thongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_thongTinKHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_thongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pn_thongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_tenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pn_thongTinKHLayout.createSequentialGroup()
                        .addComponent(txt_maKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btn3_HuySP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pn_thongTinKHLayout.setVerticalGroup(
            pn_thongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_thongTinKHLayout.createSequentialGroup()
                .addGroup(pn_thongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txt_maKH, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3_HuySP1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pn_thongTinKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_tenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pn_thongTinHoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thông tin hóa đơn"));

        jLabel4.setText("Mã Hóa Đơn");
        jLabel4.setMaximumSize(null);
        jLabel4.setPreferredSize(new java.awt.Dimension(100, 20));

        txt_maHD.setBackground(new java.awt.Color(242, 242, 242));
        txt_maHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_maHD.setForeground(new java.awt.Color(51, 51, 255));
        txt_maHD.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
        txt_maHD.setDisabledTextColor(java.awt.Color.black);
        txt_maHD.setEnabled(false);
        txt_maHD.setPreferredSize(new java.awt.Dimension(200, 25));

        jLabel9.setText("Mã Nhân Viên");
        jLabel9.setMaximumSize(null);
        jLabel9.setPreferredSize(new java.awt.Dimension(100, 20));

        txt_maNV.setBackground(new java.awt.Color(242, 242, 242));
        txt_maNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_maNV.setForeground(new java.awt.Color(51, 51, 255));
        txt_maNV.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
        txt_maNV.setDisabledTextColor(java.awt.Color.black);
        txt_maNV.setEnabled(false);
        txt_maNV.setPreferredSize(new java.awt.Dimension(200, 25));

        jLabel13.setText("Tổng giá trị HĐ");
        jLabel13.setPreferredSize(new java.awt.Dimension(100, 20));

        txt_tongGiaTriHD.setBackground(new java.awt.Color(242, 242, 242));
        txt_tongGiaTriHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_tongGiaTriHD.setForeground(new java.awt.Color(51, 51, 255));
        txt_tongGiaTriHD.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
        txt_tongGiaTriHD.setDisabledTextColor(java.awt.Color.black);
        txt_tongGiaTriHD.setEnabled(false);
        txt_tongGiaTriHD.setPreferredSize(new java.awt.Dimension(200, 25));

        jLabel17.setText("Giảm Giá Voucher");
        jLabel17.setPreferredSize(new java.awt.Dimension(100, 20));

        txt_thanhToan.setBackground(new java.awt.Color(242, 242, 242));
        txt_thanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_thanhToan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
        txt_thanhToan.setDisabledTextColor(java.awt.Color.black);
        txt_thanhToan.setEnabled(false);
        txt_thanhToan.setPreferredSize(new java.awt.Dimension(200, 25));

        jLabel18.setText("Thanh Toán");
        jLabel18.setPreferredSize(new java.awt.Dimension(100, 20));

        jLabel19.setText("HT thanh toán");
        jLabel19.setMaximumSize(null);
        jLabel19.setPreferredSize(new java.awt.Dimension(100, 20));

        cbb_hinhThucThanhToan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cbb_hinhThucThanhToan.setPreferredSize(new java.awt.Dimension(200, 25));
        cbb_hinhThucThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_hinhThucThanhToanActionPerformed(evt);
            }
        });

        jLabel20.setText("Tiền khách đưa");
        jLabel20.setPreferredSize(new java.awt.Dimension(100, 20));

        txt_tienKhachDua.setBackground(new java.awt.Color(242, 242, 242));
        txt_tienKhachDua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_tienKhachDua.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
        txt_tienKhachDua.setDisabledTextColor(java.awt.Color.black);
        txt_tienKhachDua.setPreferredSize(new java.awt.Dimension(200, 25));
        txt_tienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tienKhachDuaKeyReleased(evt);
            }
        });

        jLabel21.setText("Tiền khách CK");
        jLabel21.setPreferredSize(new java.awt.Dimension(100, 20));

        txt_tienKhachCK.setBackground(new java.awt.Color(242, 242, 242));
        txt_tienKhachCK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_tienKhachCK.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
        txt_tienKhachCK.setDisabledTextColor(java.awt.Color.black);
        txt_tienKhachCK.setPreferredSize(new java.awt.Dimension(200, 25));
        txt_tienKhachCK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_tienKhachCKKeyReleased(evt);
            }
        });

        jLabel22.setText("Tiền thừa");
        jLabel22.setPreferredSize(new java.awt.Dimension(100, 20));

        txt_tienThua.setBackground(new java.awt.Color(242, 242, 242));
        txt_tienThua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_tienThua.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
        txt_tienThua.setDisabledTextColor(java.awt.Color.black);
        txt_tienThua.setEnabled(false);
        txt_tienThua.setPreferredSize(new java.awt.Dimension(200, 25));

        jLabel23.setText("Ngày Tạo");
        jLabel23.setPreferredSize(new java.awt.Dimension(100, 20));

        txt_ngayTaoHoaDon.setBackground(new java.awt.Color(242, 242, 242));
        txt_ngayTaoHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_ngayTaoHoaDon.setForeground(new java.awt.Color(51, 51, 255));
        txt_ngayTaoHoaDon.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(153, 153, 255)));
        txt_ngayTaoHoaDon.setDisabledTextColor(java.awt.Color.black);
        txt_ngayTaoHoaDon.setEnabled(false);
        txt_ngayTaoHoaDon.setPreferredSize(new java.awt.Dimension(200, 25));

        cbb_voucher_taiQuay.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        cbb_voucher_taiQuay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cbb_voucher_taiQuay.setEnabled(false);
        cbb_voucher_taiQuay.setPreferredSize(new java.awt.Dimension(200, 25));
        cbb_voucher_taiQuay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbb_voucher_taiQuayActionPerformed(evt);
            }
        });

        btn2_xoaDon1.setText("Thanh Toán");
        btn2_xoaDon1.setRadius(19);
        btn2_xoaDon1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2_xoaDon1ActionPerformed(evt);
            }
        });

        btn2_xoaDon2.setText("Làm mới");
        btn2_xoaDon2.setRadius(19);
        btn2_xoaDon2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2_xoaDon2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_thongTinHoaDonLayout = new javax.swing.GroupLayout(pn_thongTinHoaDon);
        pn_thongTinHoaDon.setLayout(pn_thongTinHoaDonLayout);
        pn_thongTinHoaDonLayout.setHorizontalGroup(
            pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
                        .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
                                .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
                                        .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(6, 6, 6)))
                                .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbb_hinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
                                        .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_thanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_tongGiaTriHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_maHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txt_maNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbb_voucher_taiQuay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel36)
                                            .addComponent(jLabel37)))))
                            .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_ngayTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8))
                    .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel34)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tienKhachCK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel35)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btn2_xoaDon1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btn2_xoaDon2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pn_thongTinHoaDonLayout.setVerticalGroup(
            pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
                .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_maHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_maNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ngayTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_thongTinHoaDonLayout.createSequentialGroup()
                        .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tongGiaTriHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbb_voucher_taiQuay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel36))
                        .addGap(18, 18, 18)
                        .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_thanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbb_hinhThucThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_tienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel34))
                        .addGap(18, 18, 18)
                        .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_tienKhachCK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel35))
                        .addGap(18, 18, 18)
                        .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel37))
                .addGap(18, 18, 18)
                .addGroup(pn_thongTinHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn2_xoaDon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2_xoaDon2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout tbp_TaiQuayLayout = new javax.swing.GroupLayout(tbp_TaiQuay);
        tbp_TaiQuay.setLayout(tbp_TaiQuayLayout);
        tbp_TaiQuayLayout.setHorizontalGroup(
            tbp_TaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbp_TaiQuayLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tbp_TaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_thongTinKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn_thongTinHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        tbp_TaiQuayLayout.setVerticalGroup(
            tbp_TaiQuayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbp_TaiQuayLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pn_thongTinKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_thongTinHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        tbp_LoaiHoaDon.addTab("Tại Quầy", tbp_TaiQuay);

        pn_gioHang.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Giỏ Hàng"));

        tbl_dsGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null },
                {null, null, null, null, null, null },
                {null, null, null, null, null, null },
                {null, null, null, null, null, null }
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Số Lượng", "Giá Bán", "Thành Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }

    );
    tbl_dsGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_dsGioHangMouseClicked(evt);
        }
    });
    jScrollPane2.setViewportView(tbl_dsGioHang);

    btn3_HuySP.setText("Xóa SP");
    btn3_HuySP.setRadius(19);
    btn3_HuySP.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn3_HuySPActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout pn_gioHangLayout = new javax.swing.GroupLayout(pn_gioHang);
    pn_gioHang.setLayout(pn_gioHangLayout);
    pn_gioHangLayout.setHorizontalGroup(
        pn_gioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pn_gioHangLayout.createSequentialGroup()
            .addComponent(jScrollPane2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(btn3_HuySP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(7, 7, 7))
    );
    pn_gioHangLayout.setVerticalGroup(
        pn_gioHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        .addGroup(pn_gioHangLayout.createSequentialGroup()
            .addComponent(btn3_HuySP, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 111, Short.MAX_VALUE))
    );

    pn_hoaDon.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Hóa Đơn "));

    tbl_dshd.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null}
        },
        new String [] {
            "STT", "Mã HĐ", "Mã NV", "Hình Thức", "Trạng Thái"
        }
    ) {
        Class[] types = new Class [] {
            java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
        };

        public Class getColumnClass(int columnIndex) {
            return types [columnIndex];
        }
        public boolean isCellEditable(int row, int column){
            return false;
        }

    }

    );
    tbl_dshd.setToolTipText("");
    tbl_dshd.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    tbl_dshd.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_dshdMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tbl_dshd);

    jLabel29.setText("Số Hóa Đơn : ");

    lbl_giaTriSoHD.setText("5");

    jLabel38.setText("--HĐ đang chọn--");

    lbl_HDChoosed.setText("-1");

    btn1_taoDon.setText("Tạo Đơn");
    btn1_taoDon.setRadius(19);
    btn1_taoDon.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn1_taoDonActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout pn_hoaDonLayout = new javax.swing.GroupLayout(pn_hoaDon);
    pn_hoaDon.setLayout(pn_hoaDonLayout);
    pn_hoaDonLayout.setHorizontalGroup(
        pn_hoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jScrollPane1)
        .addGroup(pn_hoaDonLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(pn_hoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(btn1_taoDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(pn_hoaDonLayout.createSequentialGroup()
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lbl_giaTriSoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(lbl_HDChoosed, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(369, Short.MAX_VALUE))
    );
    pn_hoaDonLayout.setVerticalGroup(
        pn_hoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pn_hoaDonLayout.createSequentialGroup()
            .addComponent(btn1_taoDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(12, 12, 12)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pn_hoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_hoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(lbl_HDChoosed))
                .addGroup(pn_hoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(lbl_giaTriSoHD)))
            .addContainerGap())
    );

    pn_dssp.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm kinh doanh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N

    tbl_dssp.setModel(new javax.swing.table.DefaultTableModel(
        new Object [][] {
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null},
            {null, null, null, null, null, null, null, null}
        },
        new String [] {
            "","Mã sản phẩm", "Tên sản phẩm", "Size", "Màu", "Thương hiệu","Chất liệu" ,"Dây giày" ,"Đế giày" ,"Số lượng tồn", "Giá Bán"
        }
    )
    {
        public boolean isCellEditable(int row, int column){
            return false;
        }
    }
    );
    tbl_dssp.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbl_dsspMouseClicked(evt);
        }
    });
    jScrollPane6.setViewportView(tbl_dssp);

    txt_searchSPCT.setBackground(new java.awt.Color(242, 242, 242));
    txt_searchSPCT.setForeground(java.awt.Color.gray);
    txt_searchSPCT.setText("Tìm kiếm sản phẩm theo mã sản phẩm , tên ....");
    txt_searchSPCT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 255)));
    txt_searchSPCT.addFocusListener(new java.awt.event.FocusAdapter() {
        public void focusGained(java.awt.event.FocusEvent evt) {
            txt_searchSPCTFocusGained(evt);
        }
        public void focusLost(java.awt.event.FocusEvent evt) {
            txt_searchSPCTFocusLost(evt);
        }
    });
    txt_searchSPCT.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            txt_searchSPCTActionPerformed(evt);
        }
    });
    txt_searchSPCT.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txt_searchSPCTKeyReleased(evt);
        }
    });

    cbb_mauSac2.setLabeText("Màu sắc");
    cbb_mauSac2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cbb_mauSac2ActionPerformed(evt);
        }
    });

    cbb_kichThuoc2.setLabeText("Kích thước");
    cbb_kichThuoc2.setPreferredSize(new java.awt.Dimension(70, 40));
    cbb_kichThuoc2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cbb_kichThuoc2ActionPerformed(evt);
        }
    });

    btn4_boLoc.setText("Bỏ lọc");
    btn4_boLoc.setRadius(19);
    btn4_boLoc.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btn4_boLocActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout pn_dsspLayout = new javax.swing.GroupLayout(pn_dssp);
    pn_dssp.setLayout(pn_dsspLayout);
    pn_dsspLayout.setHorizontalGroup(
        pn_dsspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pn_dsspLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(pn_dsspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane6)
                .addGroup(pn_dsspLayout.createSequentialGroup()
                    .addComponent(txt_searchSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cbb_mauSac2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(cbb_kichThuoc2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btn4_boLoc, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addGap(14, 14, 14)))
            .addContainerGap())
    );
    pn_dsspLayout.setVerticalGroup(
        pn_dsspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_dsspLayout.createSequentialGroup()
            .addGroup(pn_dsspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pn_dsspLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbb_mauSac2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbb_kichThuoc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn4_boLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pn_dsspLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(txt_searchSPCT, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(16, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pn_hoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pn_gioHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(6, 6, 6)
                    .addComponent(pn_dssp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(tbp_LoaiHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 420, Short.MAX_VALUE)
            .addContainerGap())
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jLabel5)
            .addGap(421, 421, 421))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel5)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(pn_hoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(pn_gioHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(pn_dssp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(tbp_LoaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)))
    );
    }// </editor-fold>//GEN-END:initComponents

    private void btn3_HuySP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3_HuySP1ActionPerformed
        this.openViewKhachHang();
    }//GEN-LAST:event_btn3_HuySP1ActionPerformed

    private void cbb_hinhThucThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_hinhThucThanhToanActionPerformed
        updateTienDua_TienCK();
    }//GEN-LAST:event_cbb_hinhThucThanhToanActionPerformed

    private void txt_tienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tienKhachDuaKeyReleased
        try {
            String httt_choosed = dcbHTTT.getSelectedItem().toString();
            if (indexInvoiceChoosed != -1 && !txt_tienKhachDua.getText().isEmpty()) {//Phải chọn HĐ
                int lastCommaIndex = txt_thanhToan.getText().lastIndexOf(",");
                String tienPhaiThanhToan = txt_thanhToan.getText().substring(0, lastCommaIndex).replaceAll(",", "");
                if (!"0".equals(tienPhaiThanhToan)) {//HĐ phải có SP <=> tiền thanh toán != 0 && tiền đưa/ck != "
                    String tienTra = "";
                    if (httt_choosed.endsWith("Kết Hợp") && !txt_tienKhachCK.getText().isEmpty()) {//Kết hợp
                        tienTra = String.valueOf(Integer.parseInt(txt_tienKhachDua.getText()) + Integer.valueOf(txt_tienKhachCK.getText()));
                    } else {//TH: CK && TH KH nhưng trống tiền đựa
                        tienTra = txt_tienKhachDua.getText();
                    }
                    String tienThua = String.valueOf(Integer.parseInt(tienTra) - Integer.valueOf(txt_thanhToan.getText().substring(0, lastCommaIndex).replaceAll(",", "")));//Tiền thừa = tiền khách đưa -tiền phải thanh toán
                    txt_tienThua.setText(String.valueOf(tienThua));
                } else if ("0".equals(tienPhaiThanhToan)) {//TH chưa chọn sp cho hóa đơn mà nhập số tiền.
                    MsgBox.alter(this, "Vui lòng chọn sản phẩm trước mới nhập tiền khách đưa");
                    txt_tienKhachDua.setText("");
                }
            } else if (indexInvoiceChoosed == -1) {
                MsgBox.alter(this, "Vui lòng chọn hóa đơn để nhập số tiền");
                txt_tienKhachDua.setText("");
            } else if (indexInvoiceChoosed != -1 && txt_tienKhachDua.getText().isEmpty()) {//TH xóa đi số cuối.
                if (httt_choosed.equals("Kết Hợp") && !txt_tienKhachCK.getText().isEmpty()) {//Xóa đi ký tự cuối.Nhưng nếu là kq thì nó thừa = tổng - hhtt kia
                    int lastCommaIndex = txt_thanhToan.getText().lastIndexOf(",");
                    txt_tienThua.setText((String.valueOf(Integer.valueOf(txt_tienKhachCK.getText()) - Integer.valueOf(txt_thanhToan.getText().substring(0, lastCommaIndex).replaceAll(",", "")))));
                } else {
                    txt_tienThua.setText(null);
                }
            }
        } catch (NumberFormatException e) {
            if (!txt_tienKhachDua.getText().isEmpty()) {
                txt_tienKhachDua.setText(txt_tienKhachDua.getText().substring(0, txt_tienKhachDua.getText().length() - 1));
            }
            MsgBox.alter(this, "Vui lòng nhập tiền là số.");
        }
    }//GEN-LAST:event_txt_tienKhachDuaKeyReleased

    private void txt_tienKhachCKKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tienKhachCKKeyReleased
        try {
            String httt_choosed = dcbHTTT.getSelectedItem().toString();
            if (indexInvoiceChoosed != -1 && !txt_tienKhachCK.getText().isEmpty()) {//Phải chọn HĐ
                int lastCommaIndex = txt_thanhToan.getText().lastIndexOf(",");
                String tienPhaiThanhToan = txt_thanhToan.getText().substring(0, lastCommaIndex).replaceAll(",", "");
                if (!"0".equals(tienPhaiThanhToan)) {//HĐ phải có SP <=> tiền thanh toán != 0 && tiền đưa/ck != "
                    String tienTra = "";
                    if (httt_choosed.endsWith("Kết Hợp") && !txt_tienKhachDua.getText().isEmpty()) {//Kết hợp
                        tienTra = String.valueOf(Integer.parseInt(txt_tienKhachDua.getText()) + Integer.valueOf(txt_tienKhachCK.getText()));
                    } else {//TH: CK && TH KH nhưng trống tiền đựa
                        tienTra = txt_tienKhachCK.getText();
                    }
                    String tienThua = String.valueOf(Integer.parseInt(tienTra) - Integer.valueOf(txt_thanhToan.getText().substring(0, lastCommaIndex).replaceAll(",", "")));//Tiền thừa = tiền khách đưa -tiền phải thanh toán
                    txt_tienThua.setText(String.valueOf(tienThua));
                } else if ("0".equals(tienPhaiThanhToan)) {//TH chưa chọn sp cho hóa đơn mà nhập số tiền.
                    MsgBox.alter(this, "Vui lòng chọn sản phẩm trước mới nhập tiền khách ck");
                    txt_tienKhachCK.setText("");
                }
            } else if (indexInvoiceChoosed == -1) {
                MsgBox.alter(this, "Vui lòng chọn hóa đơn để nhập số tiền ");
                txt_tienKhachCK.setText("");
            } else if (indexInvoiceChoosed != -1 && txt_tienKhachCK.getText().isEmpty()) {//TH xóa đi số cuối.
                if (httt_choosed.equals("Kết Hợp") && !txt_tienKhachDua.getText().isEmpty()) {//Xóa đi ký tự cuối.Nhưng nếu là kq thì nó thừa = tổng - hhtt kia nhưng vs Th nó ko null
                    int lastCommaIndex = txt_thanhToan.getText().lastIndexOf(",");
                    txt_tienThua.setText((String.valueOf(Integer.valueOf(txt_tienKhachDua.getText()) - Integer.valueOf(txt_thanhToan.getText().substring(0, lastCommaIndex).replaceAll(",", "")))));
                } else {
                    txt_tienThua.setText(null);
                }
            }
        } catch (NumberFormatException e) {
            if (!txt_tienKhachCK.getText().isEmpty()) {
                txt_tienKhachCK.setText(txt_tienKhachCK.getText().substring(0, txt_tienKhachCK.getText().length() - 1));
            }
            MsgBox.alter(this, "Vui lòng nhập tiền là số.");
        }
    }//GEN-LAST:event_txt_tienKhachCKKeyReleased

    private void cbb_voucher_taiQuayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_voucher_taiQuayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbb_voucher_taiQuayActionPerformed

    private void btn2_xoaDon1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2_xoaDon1ActionPerformed
        if (indexInvoiceChoosed != -1) {//Khi thanh toán thì tongGiaTriHD > 0 && tiền thừa >= 0
            int lastCommaIndex = txt_thanhToan.getText().lastIndexOf(",");
            int tienPhaiThanhToan = Integer.valueOf(txt_thanhToan.getText().substring(0, lastCommaIndex).replaceAll(",", ""));
            if (tienPhaiThanhToan > 0) {
                try {
                    if (Integer.valueOf(txt_tienThua.getText()) >= 0 && MsgBox.confirm(this, "Bạn muốn thanh toán hóa đơn HĐ" + maHDChoosed)) {//Tiền thừa khác null && >0
                        hinhThucThanhToan httt = (hinhThucThanhToan) dcbHTTT.getSelectedItem();
                        ThanhToanDAO ttd = new ThanhToanDAO();
                        String mess = null;
                        switch (httt.getTenHinhThucThanhToan()) {
                            case "Tiền Mặt" -> {
                                //Lấy tiền ở Tiền khách đưa + insert bảng thanh toán
                                ThanhToanModel thanhToan = new ThanhToanModel(maHDChoosed, httt.getId_HTTT(), BigDecimal.valueOf(Long.valueOf(txt_tienKhachDua.getText())));
                                mess = (ttd.insertThanhToan(thanhToan) == 1) ? "Tạo Thanh toán tiền mặt thành công" : "";
                                System.out.println("1");
                            }
                            case "Chuyển Khoản" -> {
                                ThanhToanModel thanhToan = new ThanhToanModel(maHDChoosed, httt.getId_HTTT(), BigDecimal.valueOf(Long.valueOf(txt_tienKhachCK.getText())));
                                mess = (ttd.insertThanhToan(thanhToan) == 1) ? "Tạo Thanh toán CK thành công" : "";
                                System.out.println("2");
                            }
                            default -> {
                                if (!txt_tienKhachDua.getText().isEmpty() || !txt_tienKhachCK.getText().isEmpty()) {
                                    ThanhToanModel thanhToanTienMat = new ThanhToanModel(maHDChoosed, 1, BigDecimal.valueOf(Long.valueOf(txt_tienKhachDua.getText())));
                                    ThanhToanModel thanhToanCK = new ThanhToanModel(maHDChoosed, 2, BigDecimal.valueOf(Long.valueOf(txt_tienKhachCK.getText())));
                                    ttd.insertThanhToan(thanhToanTienMat);
                                    ttd.insertThanhToan(thanhToanCK);
                                    mess = "Tạo thanh toán KH thành công";
                                    System.out.println("3");
                                }
                            }
                        }
                        MsgBox.alter(this, mess);
                        if (cbb_hinhThucThanhToan.getSelectedItem().equals("Tiền Mặt")) {
                            MsgBox.alter(this, (bhd.updateTrangThaiHoaDon_TienThua(maHDChoosed, txt_tienThua.getText(), 1) == 1) ? "cập nhật trạng thái hóa đơn thành công" : "");//Cập nhật lại trạng thái hóa đơn//Tiên thừa/id thanh toán
                        } else if (cbb_hinhThucThanhToan.getSelectedItem().equals("Chuyển Khoản")) {
                            MsgBox.alter(this, (bhd.updateTrangThaiHoaDon_TienThua(maHDChoosed, txt_tienThua.getText(), 2) == 1) ? "cập nhật trạng thái hóa đơn thành công" : "");//Cập nhật lại trạng thái hóa đơn//Tiên thừa/id thanh toán
                        } else {
                            MsgBox.alter(this, (bhd.updateTrangThaiHoaDon_TienThua(maHDChoosed, txt_tienThua.getText(), 3) == 1) ? "cập nhật trạng thái hóa đơn thành công" : "");//Cập nhật lại trạng thái hóa đơn//Tiên thừa/id thanh toán
                        }

                        Fill_ListHD_By_Status();//Fill lại bảng HĐ.
                        clearTT_HD_TaiQuay();
                        clearKH();
                        txt_tienKhachDua.setText(null);
                        txt_tienKhachCK.setText(null);
                        dtmGioHang.setRowCount(0);
                        indexInvoiceChoosed = -1;
                        lbl_HDChoosed.setText(String.valueOf(indexInvoiceChoosed));
                    } else {
                        MsgBox.alter(this, "tiền thừa >= 0");
                    }
                } catch (NumberFormatException e) {
                    MsgBox.alter(this, "Yêu cầu nhập tiền khách đưa/ck || nếu httt 'Kết hợp' yêu cầu nhập tiền đưa và ck");
                }
            } else {
                MsgBox.alter(this, "Chưa chọn sản phẩm cho hóa đơn.");
            }
        } else {
            MsgBox.alter(this, "Vui lòng chọn hóa đơn để thực hiện thanh toán");
        }
    }//GEN-LAST:event_btn2_xoaDon1ActionPerformed

    private void btn2_xoaDon2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2_xoaDon2ActionPerformed
        clearTT_HD_TaiQuay();
    }//GEN-LAST:event_btn2_xoaDon2ActionPerformed

    private void tbl_dsGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dsGioHangMouseClicked
        int rowSelectedOnGioHang = tbl_dsGioHang.getSelectedRow();//Chek xem SPCT trên giỏ hàng đã đc chọn chưa.
        if (indexInvoiceChoosed != -1 && evt.getClickCount() == 2) {
            maHDChoosed = Integer.valueOf(tbl_dshd.getValueAt(indexInvoiceChoosed, 1).toString().substring(2));
            int id_SPCT = Integer.valueOf(tbl_dsGioHang.getValueAt(rowSelectedOnGioHang, 1).toString().substring(5));
            int ID_HĐCT = hdctd.get_ID_HDCT_BY_ID_HD_And_SPCT(maHDChoosed, id_SPCT);
            nhapSLSP_WhenClick_Table_GioHang(rowSelectedOnGioHang, maHDChoosed, id_SPCT, ID_HĐCT);
        } else if (indexInvoiceChoosed != -1 && evt.getClickCount() == 1) {
            SPCTChoosed_On_GioHang = Integer.valueOf(tbl_dsGioHang.getValueAt(rowSelectedOnGioHang, 1).toString().substring(5));
            System.out.println(SPCTChoosed_On_GioHang);
        }
    }//GEN-LAST:event_tbl_dsGioHangMouseClicked

    private void btn3_HuySPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3_HuySPActionPerformed
        if (tbl_dsGioHang.getSelectedRow() != -1) {
            boolean result = MsgBox.confirm(this, "Xác nhận xóa sản phẩm SPCT-" + SPCTChoosed_On_GioHang + " khỏi giỏ hàng");
            if (result) {
                hdctd.delete_HDCT_By_ID_SPCT(SPCTChoosed_On_GioHang);//Xóa hđ có id_spct đã chọn.
                int SL_gioHang = Integer.valueOf(tbl_dsGioHang.getValueAt(tbl_dsGioHang.getSelectedRow(), 3).toString());
                int SL_ton = prdd.selectById_To_ThemNhanh(SPCTChoosed_On_GioHang).getSoLuong();//SL trong scpt.
                prdd.updateSL_Ton_When_Insert_HDCT(SPCTChoosed_On_GioHang, SL_gioHang + SL_ton);
                update_Tong_GTHĐ(maHDChoosed);
                fill_ALL_SPCT_To_Table();//Fill lại để cập nhật lại SL
                fillThongTinHoaDon_TaiQuay_ByID_HD(maHDChoosed);
                fill_HĐCT_To_GioHang(maHDChoosed);
                MsgBox.alter(this, "Xóa sản phẩm khỏi giỏ hàng thành công");
            } else if (!result) {
                MsgBox.alter(this, "Hủy xóa SPCT khỏi giỏ hàng");
            }
        } else {
            MsgBox.alter(this, "Vui lòng chọn SPCT để xóa khỏi giỏ hàng");
        }
    }//GEN-LAST:event_btn3_HuySPActionPerformed

    private void tbl_dshdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dshdMouseClicked
        indexInvoiceChoosed = this.tbl_dshd.getSelectedRow();//Thiết lập đơn hàng đang được chọn.
        if (indexInvoiceChoosed != -1) {
            maHDChoosed = Integer.valueOf(this.tbl_dshd.getValueAt(indexInvoiceChoosed, 1).toString().substring(2));//Thiết lập hóa đơn đc chọn.
            String id_HDString = tbl_dshd.getValueAt(indexInvoiceChoosed, 1).toString().substring(2);
            fillThongTinHoaDon_TaiQuay_ByID_HD(Integer.valueOf(id_HDString));
            fill_HĐCT_To_GioHang(Integer.valueOf(id_HDString));
            fillThongTinHoaDon_TaiQuay_ByID_HD(Integer.valueOf(id_HDString));
            updateTienDua_TienCK();
            lbl_HDChoosed.setText(Integer.toString(maHDChoosed));
        }
    }//GEN-LAST:event_tbl_dshdMouseClicked

    private void btn1_taoDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1_taoDonActionPerformed
        if (tbl_dshd.getRowCount() == 5) {
            MsgBox.alter(this, "Tối đa 5 hóa đơn được tạo ra");
            return;
        }
        if (MsgBox.confirm(this, "Tạo thêm 1 hóa đơn")) {
            taoHoaDon();//Đã có TB
            Fill_ListHD_By_Status();//Fill lại bảng vs HĐ mới vừa tạo

            indexInvoiceChoosed = this.tbl_dshd.getRowCount() - 1;//Khi tạo HD <=> mặc định hóa đơn tạo đc chọn
            maHDChoosed = Integer.valueOf(this.tbl_dshd.getValueAt(indexInvoiceChoosed, 1).toString().substring(2));
            MsgBox.alter(this, "Hóa đơn HĐ" + maHDChoosed + " đang được chọn");
            this.tbl_dshd.setRowSelectionInterval(indexInvoiceChoosed, indexInvoiceChoosed);//Thiết lập row dang đc chọn.

            fill_HĐCT_To_GioHang(maHDChoosed);//fill lại giỏ hàng cho HĐ mới
            khachHangDefault();
            fillThongTinHoaDon_TaiQuay_ByID_HD(maHDChoosed);//fill lại in4 KH
            lbl_HDChoosed.setText(String.valueOf(maHDChoosed));
        }
    }//GEN-LAST:event_btn1_taoDonActionPerformed

    private void tbl_dsspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dsspMouseClicked
        if (evt.getClickCount() == 2) {//Để chọn SL SPCT
            maSPCTChoosed_On_DSSP = Integer.valueOf(this.tbl_dssp.getValueAt(tbl_dssp.getSelectedRow(), 1).toString().substring(5));
            System.out.println("Mã SPCT đang chọn " + maSPCTChoosed_On_DSSP);
            nhapSLSP_WhenClick_Table_DSSP(maSPCTChoosed_On_DSSP);
        }
    }//GEN-LAST:event_tbl_dsspMouseClicked

    private void txt_searchSPCTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_searchSPCTFocusGained
        //Sự kiện xảy ra khi thành phần txt_timKiemSP UI nhận đc trạng thái focus.
        if (txt_searchSPCT.getText().equals("Tìm kiếm sản phẩm theo mã sản phẩm , tên ....")) {
            txt_searchSPCT.setText(null);
            txt_searchSPCT.requestFocus(); //Yêu cầu tập trung Focus vào 1 component nào đó.
            //remove placeholder style
            removePlaceholderStyle(txt_searchSPCT);
        }
    }//GEN-LAST:event_txt_searchSPCTFocusGained

    private void txt_searchSPCTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_searchSPCTFocusLost
        //Sự kiện xảy ra khi thành phần txt_timKiemSP UI nhận đc trạng thái focusLost.
        if (txt_searchSPCT.getText().length() == 0) {
            //add Placeholder style
            addPlaceholderStyle(txt_searchSPCT);
            txt_searchSPCT.setText("Tìm kiếm sản phẩm theo mã sản phẩm , tên ....");
        }
    }//GEN-LAST:event_txt_searchSPCTFocusLost

    private void txt_searchSPCTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchSPCTKeyReleased
        String searchString = txt_searchSPCT.getText();
        dtmDSSP = (DefaultTableModel) this.tbl_dssp.getModel();
        search(searchString, dtmDSSP, this.tbl_dssp);
    }//GEN-LAST:event_txt_searchSPCTKeyReleased

    private void cbb_mauSac2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_mauSac2ActionPerformed
        if (dcbMauSac.getSelectedItem() != null) {
            List<Ispct> listSPCT_ByColor = prdd.getALL_SPCT_For_BanHang_By_Color((String) dcbMauSac.getSelectedItem());
            model_Fill_SPCT_To_Table(listSPCT_ByColor);
        }
    }//GEN-LAST:event_cbb_mauSac2ActionPerformed

    private void cbb_kichThuoc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_kichThuoc2ActionPerformed
        if (dcbKichCo.getSelectedItem() != null) {
            List<Ispct> listSPCT_By_Size = prdd.getALL_SPCT_For_BanHang_By_Size((int) dcbKichCo.getSelectedItem());
            model_Fill_SPCT_To_Table(listSPCT_By_Size);
        }
    }//GEN-LAST:event_cbb_kichThuoc2ActionPerformed

    private void btn4_boLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4_boLocActionPerformed
        List<Ispct> listSPCT = prdd.getALL_SPCT_For_BanHang();
        model_Fill_SPCT_To_Table(listSPCT);
    }//GEN-LAST:event_btn4_boLocActionPerformed

    private void txt_searchSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchSPCTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchSPCTActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swingStyle.btn btn1_taoDon;
    private swingStyle.btn btn2_xoaDon1;
    private swingStyle.btn btn2_xoaDon2;
    private swingStyle.btn btn3_HuySP;
    private swingStyle.btn btn3_HuySP1;
    private swingStyle.btn btn4_boLoc;
    private javax.swing.JComboBox<String> cbb_hinhThucThanhToan;
    private swingStyle.Combobox cbb_kichThuoc2;
    private swingStyle.Combobox cbb_mauSac2;
    private javax.swing.JComboBox<String> cbb_voucher_taiQuay;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lbl_HDChoosed;
    private javax.swing.JLabel lbl_giaTriSoHD;
    private javax.swing.JPanel pn_dssp;
    private javax.swing.JPanel pn_gioHang;
    private javax.swing.JPanel pn_hoaDon;
    private javax.swing.JPanel pn_thongTinHoaDon;
    private javax.swing.JPanel pn_thongTinKH;
    private javax.swing.JTable tbl_dsGioHang;
    private javax.swing.JTable tbl_dshd;
    private javax.swing.JTable tbl_dssp;
    private javax.swing.JTabbedPane tbp_LoaiHoaDon;
    private javax.swing.JPanel tbp_TaiQuay;
    private javax.swing.JTextField txt_maHD;
    private javax.swing.JTextField txt_maKH;
    private javax.swing.JTextField txt_maNV;
    private javax.swing.JTextField txt_ngayTaoHoaDon;
    private javax.swing.JTextField txt_searchSPCT;
    private javax.swing.JTextField txt_tenKH;
    private javax.swing.JTextField txt_thanhToan;
    private javax.swing.JTextField txt_tienKhachCK;
    private javax.swing.JTextField txt_tienKhachDua;
    private javax.swing.JTextField txt_tienThua;
    private javax.swing.JTextField txt_tongGiaTriHD;
    // End of variables declaration//GEN-END:variables
ProductDAO prd = new ProductDAO(); //Tên sản phẩm dao
    ProductDetaisDAO prdd = new ProductDetaisDAO();//Sẩn phẩm chi tiết đao
    MauSacDAO msd = new MauSacDAO();//màu sắc dao
    KichCoDAO kcd = new KichCoDAO();//kích cỡ đao
    HTTT_DAO htttd = new HTTT_DAO();// Hinh thức thanh toán
    service_voucher vcd = new service_voucher();//voucher ser
    //----------Lấy model của các combobox để thao tác dữ liệu
    DefaultComboBoxModel dcbMauSac;
    DefaultComboBoxModel dcbKichCo;
    DefaultComboBoxModel dcbHTTT; //hình thức thanh toán ( Money/Pay ).
    DefaultComboBoxModel dcbVoucherTaiQuay;
    //----------Lấy Dao của Trạng Thái Hóa Đơn || Trạng Thái Thanh Toán để lấy tên của nó theo ID
    TrangThaiHoaDonDAO tthdd = new TrangThaiHoaDonDAO();
    TrangThaiThanhToanDAO ttttd = new TrangThaiThanhToanDAO();
    //Dao của Nhân viên || KH để tra ra tên KH + NV.
    KhachHangService khser = new KhachHangService();
    NhanVienService nvs = new NhanVienService();
    //Dao của BÁN HÀNG để fill danh sách.
    HDCT_DAO hdctd = new HDCT_DAO();//Hóa đơn chi tiết.
    BanHangDAO bhd = new BanHangDAO();//Là hóa đơn
    //-----------Lấy model của các bảng để thao tác dữ liệu
    DefaultTableModel dtmHoaDon;
    DefaultTableModel dtmGioHang;
    DefaultTableModel dtmDSSP;
    //--------------------Để xác định hóa đơn có đang đc chọn ko để thêm SPCT.
    int indexInvoiceChoosed = -1;//Để chek xem dòng hóa đơn đang đc chọn trên bảng.
    int maHDChoosed = -1; //X.Định mã HĐ đag đc chọn là gì.
    int SPCTChoosed_On_GioHang; //Xác định SPCT đang chọn trển bảng giỏ hàng
    int maSPCTChoosed_On_DSSP; //Xác định mã SPCT đang chọn trên bảng SPCT

    private void initHD() {
        Fill_ListHD_By_Status(); //Fill ListHD lên bảng vs trạng thái : Chờ thanh toán : và ko quá 5 hóa đơn
    }

    private void Model_HoaDon_To_Table(List<HoaDonBanHang> listHD) {
        dtmHoaDon = (DefaultTableModel) this.tbl_dshd.getModel();
        dtmHoaDon.setRowCount(0);
        int i = 1;
        for (HoaDonBanHang hd : listHD) {
            Object[] data = new Object[]{
                i++,
                "HĐ" + hd.getId(), //Mã HD
//                xacDinhMaNV(hd.getId_nhanVien()),
                hd.getLoaiHoaDon(), //Tại quầy / đặt hàng
                this.tthdd.select_TrangThaiHoaDon_ById(hd.getId_trangThaiHoaDon()),//ID_TTHD --> tên TTHĐ
            };
            dtmHoaDon.addRow(data);
        }
    }

    private void Fill_ListHD_By_Status() {//Thực hiện fill lại d/s hóa đơn khi tạo hóa đơn (TTHĐ -- Chờ thanh toán)
        List<HoaDonBanHang> listDSHD = bhd.select_HD_By_Status();//Lấy danh sách 
        if (listDSHD != null && !listDSHD.isEmpty()) {
            Model_HoaDon_To_Table(listDSHD);
        } else {//Nếu danh sách HĐ trống thì xóa hết dòng đi ko Bug MouseClick.
            dtmHoaDon = (DefaultTableModel) this.tbl_dshd.getModel();
            dtmHoaDon.setRowCount(0);
        }
        countSoHD_TaiQuay();//Đếm lại SL hóa đơn trên bảng sau khi Fill
    }

    private void fill_HTTT_To_Cbb() {//Đẩy tất cả hình thức thanh toán lên combobox.
        dcbHTTT = (DefaultComboBoxModel) cbb_hinhThucThanhToan.getModel();
        dcbHTTT.removeAllElements();
        List<hinhThucThanhToan> listHTTT = htttd.selectAll_HTTT();
        for (hinhThucThanhToan httt : listHTTT) {
            dcbHTTT.addElement(httt);
        }
    }

//    private void fill_Voucher_To_Cbb() {//Đẩy tất cả Cbb lên.
//        dcbVoucherTaiQuay = (DefaultComboBoxModel) cbb_voucher_taiQuay.getModel();
//        dcbVoucherTaiQuay.removeAllElements();
//        dcbVoucherTaiQuay.addElement("Chưa áp dụng voucher"); //Tại vì trog DS ko thể cho cái này insert vào đc.
//        List<Voucher> listVC = vcd.getAll1();
//        for (Voucher vc : listVC) {
//            dcbVoucherTaiQuay.addElement(vc.getMota());
//        }
//    }

    private void fill_HĐCT_To_GioHang(int id_HDCT) {
        dtmGioHang = (DefaultTableModel) this.tbl_dsGioHang.getModel();
        dtmGioHang.setRowCount(0);
        List<HDCTBanHang> listHDCT = hdctd.getTT_HDCT_Fill_GioHang_By_ID_HD(id_HDCT);
        int i = 1;
        for (HDCTBanHang hdct : listHDCT) {
            Object[] data = new Object[]{
                i++,
                "SPCT-" + hdct.getId_ctsp(),
                prd.selectById(String.valueOf(hdct.getId_ctsp())).getName(),
                hdct.getSoLuongSP(),
                moneyFormat(Integer.valueOf(hdct.getGiaTienTra().toString())) + ",000đ",//Giá bán sản phẩm
                moneyFormat(Integer.valueOf(hdct.getDonGia().toString())) + ",000đ",//Giá bán sản phẩm
            };
            dtmGioHang.addRow(data);
        }
    }

    //Tạo 1 HĐ với các thông số cơ bản ID_NV || ID_KH || loaiHD || ID_TTHĐ (chờ thanh toán). 
    //Tổng.GTHĐ || ThanhToan || TienThua ||GiamGiaHĐ. 
    private void taoHoaDon() {
       HoaDonBanHang hd = new HoaDonBanHang();
        hd.setId_nhanVien(GetChucVu.getId()); //Lấy idNV đăng nhập vào.
        hd.setId_khachHang(1);// Default KH khi tạo HĐ là khách vãng lai.
        hd.setLoaiHoaDon(xacDinhLoaiHoaDon()); //Dựa vào tabbedPane đag chọn
        hd.setId_trangThaiHoaDon(1);//Defaul ban đầu = Chờ thanh toán
        //----
        hd.setTongGiaTriHD(new BigDecimal(0));//Mới tạo hóa đơn tổng tiền = 0
     hd.setThanhToan(new BigDecimal(0));//Số tiền thanh toán lúc này là = 0
        hd.setTienThua(new BigDecimal(0));//Số tiền thừa lúc tạo HD = 0
        hd.setGiamGiaHD(new BigDecimal(0));//số giảm giá lúc này là 0
      //-----
        hd.setNguotTao(GetChucVu.getId());

        String message = (bhd.insert(hd) != 0) ? "Tạo hóa đơn thành công" : "Tạo hóa đơn thất bại";
        MsgBox.alter(this, message);
    }
    
    private String xacDinhLoaiHoaDon() {//Tại Quầy/Đặt Hàng : Dựa vào JTabbedPande nào đg đc chọn.Để thực hiện insert
        return (tbp_LoaiHoaDon.getSelectedComponent() == tbp_TaiQuay) ? "Tại Quầy" : "Đặt Hàng";
    }

    private String xacDinhMaNV(int ID_NV) {//để fill lên bảng HĐ.
        NhanVien nv = nvs.getNV_BY_ID(ID_NV);
        return nv.getMaNV();
    }

    private void khachHangDefault() {//Mặc định ban đầu là KH vãng lai
        txt_maKH.setText("KH001");
        txt_tenKH.setText("Khách Vãng Lai");
    }

    private void clearKH() {
        txt_maKH.setText("Chọn hóa đơn để có thông tin");
        txt_tenKH.setText("Chọn hóa đơn để có thông tin");
    }

    private void nhapSLSP_WhenClick_Table_DSSP(int maSPCTChoosed) {
        if (indexInvoiceChoosed == -1) {
            MsgBox.alter(this, "Vui lòng chọn hóa đơn trước khi thêm sản phẩm vào giỏ hàng!!");
        } else {
            maHDChoosed = Integer.valueOf(tbl_dshd.getValueAt(indexInvoiceChoosed, 1).toString().substring(2));//truy vấn SPCT có trong HĐCT chưa ? ~ xem trong hóa đơn chọn đã có SPCT này chưa ? 
            int maxSL_SPCT = prdd.selectById_To_ThemNhanh(maSPCTChoosed).getSoLuong();//SL Lấy theo ID spct. Để so sánh vs g.trị kh muốn mua.
            String soLuongMua;//SL user muốn mua.
            while (true) {//Hiện thị hộp thoại cho đến khi user đóng || nhập đúng
                soLuongMua = MsgBox.prompt(this, "Nhập vào số lượng sản phẩm SPCT-" + maSPCTChoosed + " muốn mua!");
                //Nếu người dùng hủy hộp thoại thì nó ko hiện thị nx.
                if (soLuongMua == null) {
                    MsgBox.alter(this, "Hủy thêm số lượng sản phẩm mua");
                    break;
                }
                if (checkValidation_NhapSL_Mua(soLuongMua, maxSL_SPCT)) {//Đã chek phải là số > 0 && <= SL Max. 
                    break;//Nếu ĐK hợp lệ dừng vòng lặp còn ko thì nó tự T.báo
                }
            }
            if (soLuongMua != null) {//TH user nhập đúng SL --> Check tồn tại ( Update +SL) || chưa tồn tại ( Insert ) 
                boolean tonTaiHDCT = checkTonTai_HDCT_Have_HĐ_And_ID_SPCT(maHDChoosed, maSPCTChoosed);
                if (tonTaiHDCT) {//True --> Update
                    updateHDCT_InDSSP(maHDChoosed, maSPCTChoosed, Integer.valueOf(soLuongMua));//upda lại : SL , đơn giá () HĐCT.
                    update_SL_SPCT_InDSSP(maSPCTChoosed, Integer.valueOf(soLuongMua));//giảm SLSP 
                    update_Tong_GTHĐ(maHDChoosed);
                    fill_ALL_SPCT_To_Table();//Fill lại để cập nhật lại SL
                    fillThongTinHoaDon_TaiQuay_ByID_HD(maHDChoosed);
                    fill_HĐCT_To_GioHang(maHDChoosed);
                } else {//--insert HĐCT
                    createHDCT(maHDChoosed, maSPCTChoosed, Integer.valueOf(soLuongMua));
                    update_SL_SPCT_InDSSP(maSPCTChoosed, Integer.valueOf(soLuongMua));//Ở đây là mua --> SL SPCT giảm
                    update_Tong_GTHĐ(maHDChoosed);
                    fill_ALL_SPCT_To_Table();//Fill lại để cập nhật lại SL
                    fillThongTinHoaDon_TaiQuay_ByID_HD(maHDChoosed);
                    fill_HĐCT_To_GioHang(maHDChoosed);
                }
            }
        }
    }

    //-----------FILL SPCT || Thuộc Tính SP
    private void initDSSP() {
        dtmGioHang = (DefaultTableModel) this.tbl_dsGioHang.getModel();
        dtmGioHang.setRowCount(0);
        fill_ALL_MauSac_To_Cbb();
        fill_ALL_KichCo_To_Cbb();
        fill_HTTT_To_Cbb();
        fill_Voucher_To_Cbb();
        fill_ALL_SPCT_To_Table();
    }
    
        private void fill_Voucher_To_Cbb() {//Đẩy tất cả Cbb lên.
        dcbVoucherTaiQuay = (DefaultComboBoxModel) cbb_voucher_taiQuay.getModel();
        dcbVoucherTaiQuay.removeAllElements();
        dcbVoucherTaiQuay.addElement("Chưa áp dụng voucher"); //Tại vì trog DS ko thể cho cái này insert vào đc.
        List<Voucher> listVC = vcd.getAll1();
        for (Voucher vc : listVC) {
            dcbVoucherTaiQuay.addElement(vc.getMota());
        }
    }
    private void model_Fill_SPCT_To_Table(List<Ispct> listSPCT) {//Công cụ đẩy dữ liệu lên bảng SPCT
        dtmDSSP = (DefaultTableModel) this.tbl_dssp.getModel();
        dtmDSSP.setRowCount(0);
        for (Ispct spct : listSPCT) {
            String imageName = spct.getNameanh();//Lấy key : tên ảnh
            ImageIcon imageIcon = null;
            JLabel lblImage = new JLabel();//Chứa ảnh 
            if (imageName != null) {
                imageIcon = new ImageIcon(getClass().getResource("/Product_images/" + imageName));
                Image image = imageIcon.getImage();//Chuyển sang Image để thiết lập kích thước.
                tbl_dssp.setRowHeight(50);
                tbl_dssp.getColumnModel().getColumn(0).setPreferredWidth(140);
                tbl_dssp.getColumnModel().getColumn(2).setPreferredWidth(140);
                tbl_dssp.getColumnModel().getColumn(7).setPreferredWidth(150);
                imageIcon = new ImageIcon(image.getScaledInstance(tbl_dssp.getColumnModel().getColumn(0).getWidth(), 50, Image.SCALE_SMOOTH));
                lblImage.setIcon(imageIcon);
            }
            tbl_dssp.getColumnModel().getColumn(0).setCellRenderer(new ImageRenderer());
            Object[] data = new Object[]{
                (imageName != null && imageIcon != null) ? lblImage : "chưa thiết lập ảnh",//ảnh spct
                "SPCT-" + spct.getId(),
                spct.getNametenGiay(), //Tên SP
                spct.getNamekichCo(), //Kích cỡ
                spct.getNamemauSac(), //Màu sắc
                spct.getNamethuongHieu(), //thương hiệu
                spct.getNamechatLieu(),
                spct.getNamedayGiay(),
                spct.getNamedeGiay(),
                spct.getSoLuong(), //SL SPCT 
                formatNumber(spct.getGiaBan()),//Giá bán.
            };
            dtmDSSP.addRow(data);
        }
    }

    class ImageRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof Component) {
                return (Component) value;
            } else {
                return createDefaultRenderer(value);
            }
        }
    }

    private Component createDefaultRenderer(Object value) {
        JLabel label = new JLabel();
        label.setText(value.toString());  // Hoặc hiển thị giá trị khác nếu cần
        return label;
    }

    private void fill_ALL_SPCT_To_Table() {//Lấy tất cả SPCT fill lên bảng
        List<Ispct> listSPCT = prdd.getALL_SPCT_For_BanHang();
        model_Fill_SPCT_To_Table(listSPCT);
    }
    
        private void fill_ALL_MauSac_To_Cbb() {//dùng vòng lặp duyệt tất cả màu sắc ở danh sách đổ vào combobox.
        dcbMauSac = (DefaultComboBoxModel) cbb_mauSac2.getModel();
        dcbMauSac.removeAllElements();
        List<MauSac> listMS = msd.selectAll();
        for (MauSac ms : listMS) {
            dcbMauSac.addElement(ms.getName());
        }
    }

    private void fill_ALL_KichCo_To_Cbb() {//dùng vòng lặp duyệt tất cả kích cỡ ở danh sách đổ vào combobox.
        dcbKichCo = (DefaultComboBoxModel) cbb_kichThuoc2.getModel();
        dcbKichCo.removeAllElements();
        List<KichCo> listKC = kcd.selectAll();
        for (KichCo kc : listKC) {
            dcbKichCo.addElement(kc.getName());
        }
    }


    //-------------------Utility Hóa Đơn + SPCT 
    public static String formatNumber(BigDecimal number) {
        //Tạo một đối tượng NumberFormat với Locale.US để sử dụng định dạng tiền tệ của Hoa Kỳ
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);// Định dạng số
        return numberFormat.format(number) + ",000đ";//Định dạng số và chuyển nó thành String.
    }

    public void fillThongTinHoaDon_TaiQuay_ByID_HD(int id_HD) {//Truy vấn HĐ qua id --> Lấy TT fill lên bảng
        HoaDonBanHang hdbh = bhd.selectTT_HD_TaiQuay_ById(id_HD);
        txt_maHD.setText("HĐ" + hdbh.getId());
        //----
        txt_maKH.setText(khser.getTT_KH_BY_ID(hdbh.getId_khachHang()).getMaKH());//Từ idKH --> KH --> mã.KH
        txt_tenKH.setText(khser.getTT_KH_BY_ID(hdbh.getId_khachHang()).getName());//Từ idKH --> KH --> Tên KH
        //----
        txt_maNV.setText(nvs.getTT_NV_BY_ID(hdbh.getId_nhanVien()).getMaNV());//Từ idNV --> NV --> mã.NV
        //----
        txt_ngayTaoHoaDon.setText(hdbh.getNgayTao().toString());
        //---- 

        txt_tongGiaTriHD.setText(moneyFormat(Integer.valueOf(hdbh.getTongGiaTriHD().toString())) + ",000đ");

        txt_thanhToan.setText(moneyFormat(Integer.valueOf(hdbh.getThanhToan().toString())) + ",000đ");

        txt_tienThua.setText(moneyFormat(Integer.valueOf(hdbh.getTienThua().toString())) + ",000đ");
    }

    public String moneyFormat(Integer number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(number);
    }

    private void clearTT_HD_TaiQuay() {//Xóa đi TT_HD_Txại quầy
        txt_maHD.setText(null);//Mã hóa đơn
        txt_maKH.setText("KH001");//mã khách hàng
        txt_tenKH.setText("Khách Vãng Lai");//Tên KH
        txt_maNV.setText(null);//mã nhân viên
        txt_ngayTaoHoaDon.setText(null);//Ngày tạo hóa đơn
        txt_tongGiaTriHD.setText(null);//tổng giá trị HĐ
        txt_thanhToan.setText(null);//thành tiền
        txt_tienThua.setText(null);//Tiền thừa 
        indexInvoiceChoosed = -1;
        lbl_HDChoosed.setText("-1");
    }

    private void countSoHD_TaiQuay() {
        if (tbl_dshd.getRowCount() > 0) {
            lbl_giaTriSoHD.setText(tbl_dshd.getRowCount() + "");
        } else {
            lbl_giaTriSoHD.setText("0");
        }
    }

    //Check phải là số > 0 && <= SL_Max
    public boolean checkValidation_NhapSL_Mua(String SL_Mua, int SL_Max_SPCT) {
        try {
            if (Integer.valueOf(SL_Mua.trim()) <= 0) {
                MsgBox.alter(this, "Số lượng mua > 0!");
                return false;
            } else if (Integer.valueOf(SL_Mua.trim()) > SL_Max_SPCT) {
                MsgBox.alter(this, "Số lượng mua < Số Lượng hiện đang có!");
                return false;
            }
        } catch (NumberFormatException e) {
            MsgBox.alter(this, "Số lượng mua chỉ là số nguyên!");
            return false;
        }
        return true;//TH SL mua <= SL max
    }

    //Chek là số.
    public boolean checkValidation_Update_SL_Mua_OnGioHang(String SL_thayDoi) {
        try {
            Integer.valueOf(SL_thayDoi);
        } catch (NumberFormatException e) {
            MsgBox.alter(this, "yêu cầu nhập là số và >= 0");
            return false;
        }
        return true;
    }

    //Chek tồn tại SPCT (.) HĐ --> Rồi ( True ) || Chưa ( False )
    public boolean checkTonTai_HDCT_Have_HĐ_And_ID_SPCT(int maHD, int maSPCT) {
        return hdctd.check_TonTai_HĐCT_By_IDHĐ_ID_SPCT(maHD, maSPCT) != null;
    }

    public void createHDCT(int maHD, int maSPCT, int SL_Mua) {//Tạo ra 1 HĐCT mới để insert ( nếu hđct đó chưa tồn tại )
        BigDecimal giaTienTra_SP = prdd.selectById_To_ThemNhanh(maSPCTChoosed_On_DSSP).getGiaBan();
        BigDecimal donGia_HĐCT = giaTienTra_SP.multiply(BigDecimal.valueOf(SL_Mua));
        HDCTBanHang hdct = new HDCTBanHang(maHD, maSPCT, SL_Mua, giaTienTra_SP, donGia_HĐCT);
        String message = (hdctd.insert(hdct) == 1) ? "Thêm hóa đơn chi tiết thành công" : "Thêm hóa đơn chi tiết thất bại";
        MsgBox.alter(this, message);
    }

    //TH thêm SPCT vào giỏ hàng nhưng nó đã tồn tại <=> upda sl.
    public void updateHDCT_InDSSP(int id_HD, int id_SPCT, int SL_them) {//  Update ( SL | Đơn Giá ) 
        int ID_HĐCT = hdctd.get_ID_HDCT_BY_ID_HD_And_SPCT(id_HD, id_SPCT);
        int SL_In_HĐCT = hdctd.getSL_SPCT_IN_HĐCT(ID_HĐCT);//lấy số lượng đang có trog HĐCT để update
        BigDecimal giaTienTra_SP = prdd.selectById_To_ThemNhanh(id_SPCT).getGiaBan();//Lấy giá theo id_SPCT
        //-----
        //SL(.) HĐCT tăng
        int SL = SL_In_HĐCT + SL_them;
        BigDecimal donGia_HĐCT = giaTienTra_SP.multiply(BigDecimal.valueOf(SL));//Giá SP * SL
        HDCTBanHang hdct = new HDCTBanHang(ID_HĐCT, SL, donGia_HĐCT);
        String message = (hdctd.update(hdct) == 1) ? "thêm SL vào giỏ hàng thành công" : "thêm SL vào giỏ hàng lỗi";
        MsgBox.alter(this, message);
    }

    public void update_SL_SPCT_InDSSP(int maSPCT, int SL_SPCT_mua_them) {//Dựa vào SL truyền vào thì nó update lại SL Tồn của SPCT khi thêm spct trong dssp
        int SL_SPCT_Ton = prdd.selectById_To_ThemNhanh(maSPCT).getSoLuong();//Lấy SL tồn SPCT
        if (SL_SPCT_mua_them > 0) {// --> SL_SPCT giảm khi user mua thêm
            int SL_Update = SL_SPCT_Ton - SL_SPCT_mua_them;
            String message = (prdd.updateSL_Ton_When_Insert_HDCT(maSPCT, SL_Update) == 1) ? "update SL_Tồn_SPCT thành công" : "update SL_Tồn_SPCT thất bại";
            MsgBox.alter(this, message);
        }
    }

    //TH thêm HĐCT || Update HĐCT.
    public void update_Tong_GTHĐ(int idHD) {//Lấy giá trị Sum(DonGia) = tongGiaTriHD ở bảng HĐ
        BigDecimal tongGTHD_Update = hdctd.get_TongGTHD_IN_Table_HDCT_BY_ID_HD(idHD);//Update lại dựa vào đơn giá upda lại trong HĐCT.
        BigDecimal giamGiaHD_update = bhd.selectTT_HD_TaiQuay_ById(idHD).getGiamGiaHD();//Lấy số tiền đc giảm giá nhờ voucher
        BigDecimal thanhTien_Update;
        if (tongGTHD_Update != null) {
            thanhTien_Update = tongGTHD_Update.subtract(giamGiaHD_update);//Thành tiền = tỏng GTHĐ - giảm giá.
        } else {
            tongGTHD_Update = BigDecimal.valueOf(0);
            thanhTien_Update = BigDecimal.valueOf(0);
        }
        String message = (bhd.update_TongGTHD(idHD, tongGTHD_Update, thanhTien_Update) == 1) ? "cập nhật tổng giá trị hóa đơn thành công" : "cập nhật tổng giá trị hóa đơn thất bại";
        System.out.println(message);
    }
    
    public void search(String str, DefaultTableModel dtmTable, JTable table) {
        dtmTable = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(dtmTable); //Tạo 1 TablerowSorter và liên kết với bảng DTM. TableRowSoft : Quản lý việc sắp xếp và lọc các hàng trong JTable.
        table.setRowSorter(trs); //Gán TableRowSorter vừa tạo cho JTable. -> Kích hoạt việc sắp xếp và lọc cho JTable. 
        //Sử dụng biểu thức chính quy để không phân biệt chữ hoa chữ thường
        Pattern pattern = Pattern.compile(Pattern.quote(str), Pattern.CASE_INSENSITIVE);
//        trs.setRowFilter(RowFilter.regexFilter(str));//Đặc bộ lọc cho TableRowSorter để thực hiện tìm kiếm dựa trên biểu thức chính quy ( Regex ). Nó sẽ tạo 1 bộ lọc dựa trên chuỗi str.
        trs.setRowFilter(new RowFilter<DefaultTableModel, Object>() {
            @Override
            public boolean include(RowFilter.Entry<? extends DefaultTableModel, ? extends Object> entry) {
                // Duyệt qua từng cột trong hàng
                for (int i = entry.getValueCount() - 1; i >= 0; i--) {
                    Object value = entry.getValue(i);
                    if (value != null) {
                        // Kiểm tra nếu giá trị của cột chứa ký tự tìm kiếm
                        Matcher matcher = pattern.matcher(value.toString());
                        if (matcher.find()) {
                            return true;
                        }
                    }
                }
                return false;
            }
        });
    }

    //----------------------------
    private void nhapSLSP_WhenClick_Table_GioHang(int rowSelectedSPCT, int id_HD, int id_SPCT, int ID_HDCT) {
        if (rowSelectedSPCT < 0) {
            MsgBox.alter(this, "Vui lòng chọn sản phẩm cập nhật số lượng để cập nhật");
        } else {
            String SL_nhap;
            while (true) {
                SL_nhap = MsgBox.prompt(this, "nhập số lượng muốn thay đổi.");
                if (SL_nhap == null) {
                    MsgBox.alter(this, "Hủy thay đổi số lượng sản phẩm");
                    break;
                }
                if (checkValidation_Update_SL_Mua_OnGioHang(SL_nhap)) {
                    break;
                }
            }//Check đến user dừng hoặc nhập đúng định dạng.
            if (SL_nhap != null) {
                int SL_nhapInt = Integer.valueOf(SL_nhap);//Số lượng muốn sửa lại
                int SL_gioHang = hdctd.getSL_SPCT_IN_HĐCT(ID_HDCT);//SL trong giỏ hàng
                int SL_ton = prdd.selectById_To_ThemNhanh(id_SPCT).getSoLuong();//SL trong scpt.
                System.out.println("SL nhập " + SL_nhapInt + "/n SL giỏ " + SL_gioHang + "/n" + " SL tồn " + SL_ton);
                if (SL_nhapInt == 0) {//TH1 : SL sửa = 0 <=> xóa hđct chứa scpt (hđct) + upda SL ( spct ) + tongGTHD (hd)
                    hdctd.delete_HDCT_By_ID_SPCT(id_SPCT);//Xóa hđ có id_spct đã chọn.
                    prdd.updateSL_Ton_When_Insert_HDCT(id_SPCT, SL_gioHang + SL_ton);
                } else if (SL_nhapInt < SL_gioHang) {//TH2 : SL sửa < SL giỏ hàng <=> Up SL spct (spct) , SL spct , đơn giá (hđct) , upda TongGTHĐ (hđ)

                    prdd.updateSL_Ton_When_Insert_HDCT(id_SPCT, (SL_gioHang - SL_nhapInt) + SL_ton);//upda lại SL trong spct
                    updateSL_DonGia(ID_HDCT, SL_nhapInt, id_SPCT);

                } else if (SL_nhapInt > SL_gioHang && SL_nhapInt <= (SL_gioHang + SL_ton)) {

                    prdd.updateSL_Ton_When_Insert_HDCT(id_SPCT, SL_ton - (SL_nhapInt - SL_gioHang));
                    updateSL_DonGia(ID_HDCT, SL_nhapInt, id_SPCT);

                } else if (SL_nhapInt > (SL_gioHang + SL_ton)) {
                    MsgBox.alter(this, "số lượng sản phẩm không đủ.");
                }
                update_Tong_GTHĐ(id_HD);
                fill_ALL_SPCT_To_Table();//Fill lại để cập nhật lại SL
                fillThongTinHoaDon_TaiQuay_ByID_HD(maHDChoosed);
                fill_HĐCT_To_GioHang(maHDChoosed);
            }
        }
    }

    public void updateSL_DonGia(int id_hdct, int slUpdate, int id_SPCT) {
        BigDecimal giaTienTra_SP = prdd.selectById_To_ThemNhanh(id_SPCT).getGiaBan();//Lấy giá theo id_SPCT
        BigDecimal donGia_HĐCT = giaTienTra_SP.multiply(BigDecimal.valueOf(slUpdate));//Giá SP * SL
        HDCTBanHang hdct = new HDCTBanHang(id_hdct, slUpdate, donGia_HĐCT);
        String message = (hdctd.update(hdct) == 1) ? "Upda SL + đơn giá spct cho hóa đơn thành công" : "Lỗi cập nhật hóa đơn chi tiết";
        MsgBox.alter(this, message);
    }

    //Mục đích : Loại bỏ hiệu ứng "Chữ gợi ý" khỏi JTextField.
    public void removePlaceholderStyle(JTextField textField) {
        Font font = textField.getFont();
        font = font.deriveFont(Font.PLAIN);
        textField.setFont(font);
        textField.setForeground(Color.BLACK);
    }

    public void addPlaceholderStyle(JTextField textField) {
        Font font = textField.getFont();//Lấy font hiện tại của JTextField
        font = font.deriveFont(Font.ITALIC);//Tạo 1 bản sao mới của Font với kiểu in nghiêng ( Italic )
        textField.setFont(font); //Đặt font mới cho JTextField
        textField.setForeground(Color.GRAY); //Đặt màu chữ là Gray ( Xám ) 
    }


    private void openViewKhachHang() {
        ChonThongTinKH kh = new ChonThongTinKH(this, true);
        kh.setVisible(true);
    }

//    chọn Khách Hàng
    public void chooseKH(KhachHang kh) {
        this.chonKH(kh);
    }


    public void chonKH(KhachHang kh) {//Chọn KH là upda lại kh trong hóa đơn đó
        txt_maKH.setText(kh.getMaKH());
        txt_tenKH.setText(kh.getName());
        int id_KH = kh.getId();
        String id_HDString = tbl_dshd.getValueAt(indexInvoiceChoosed, 1).toString().substring(2);
        if (bhd.update_ID_KH(Integer.valueOf(id_HDString), id_KH) == 1) {
            MsgBox.alter(this, "Thay đổi thông tin khách hàng trong hóa đơn thành công");
        } else {
            MsgBox.alter(this, "Thay đổi thông tin khách hàng thất bại");
        }
    }

    //
    public boolean checkValidation_TienKhachDua_CK() {
        if (dcbHTTT.getSelectedItem().equals("Tiền Mặt") || dcbHTTT.getSelectedItem().equals("Kết Hợp")) {
            String tienKhachDuaStr = txt_tienKhachDua.getText();
            if (tienKhachDuaStr == null && !isBigDecimal(tienKhachDuaStr)) {//check trống
                MsgBox.alter(this, "Không để trống số tiền khách đưa");
                return false;
            }
        }//Tiền mặt
        if (dcbHTTT.getSelectedItem().equals("Chuyển Khoản") || dcbHTTT.getSelectedItem().equals("Kết Hợp")) {
            String tienKhachCK = txt_tienKhachCK.getText();
            if (tienKhachCK == null && !isBigDecimal(tienKhachCK)) {
                MsgBox.alter(this, "Không để trống tiền khách chuyển khoảng ");
                return false;
            }
        }//chuyển khoản
        return true;
    }
//
    public void hopLeDeThanhToan() {//
        Double tienKhachDuaDouble = Double.valueOf(txt_tienKhachDua.getText());
        BigDecimal tienKhachDuaBig = BigDecimal.valueOf(tienKhachDuaDouble);
        int id_HDString = Integer.valueOf(tbl_dshd.getValueAt(indexInvoiceChoosed, 1).toString().substring(2));
        BigDecimal tongGTHD = bhd.selectTT_HD_TaiQuay_ById(id_HDString).getTongGiaTriHD();
//        BigDecimal tienThua = tongGTHD - tienKhachDuaBig;
    }
//
//    // Hàm kiểm tra xem một chuỗi có phải là số không
    private boolean isBigDecimal(String str) {
        try {
            BigDecimal bigDecimal = new BigDecimal(str);
            MsgBox.alter(this, "Yêu cầu nhập tiền mặt/Chuyển khoản là số");
            return true;
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
    }
//
    private void updateTienDua_TienCK() {//Cập nhật lại tiền đưa / tiền ck khi chọn hđ hoặc chọn combobox loại thanh toán.
        String httt_choosed = dcbHTTT.getSelectedItem().toString();
        switch (httt_choosed) {
            case "Tiền Mặt":
                txt_tienKhachDua.setEnabled(true);
                txt_tienKhachDua.setText(null);
                //--
                txt_tienKhachCK.setEnabled(false);//Đóng chỗ nhập tiền khách CK đi ( Đặt hàng )
                txt_tienKhachCK.setText("0đ");
                break;
            case "Chuyển Khoản":
                txt_tienKhachCK.setEnabled(true);
                txt_tienKhachCK.setText(null);
                //----
                txt_tienKhachDua.setEnabled(false);
                txt_tienKhachDua.setText("0đ");
                break;
            case "Kết Hợp":
                txt_tienKhachCK.setEnabled(true);
                txt_tienKhachDua.setEnabled(true);
                txt_tienKhachDua.setText(null);
                txt_tienKhachCK.setText(null);
                break;
            default:
                break;
        }
        txt_tienThua.setText(null);
    }
}
