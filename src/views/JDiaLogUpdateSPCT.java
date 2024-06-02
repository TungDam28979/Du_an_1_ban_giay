package views;

import views.JPSanPham;
import dao.Anh_Image_DAO;
import dao.ChatLieuDAO;
import dao.DayGiayDao;
import dao.DeGiayDao;
import dao.KichCoDAO;
import dao.MauSacDAO;
import dao.ProductDetaisDAO;
import dao.ThuongHieuDao;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import model.KichCo;
import model.Anh_Image;
import model.ChatLieu;
import model.MauSac;
import model.DayGiay;
import model.ThuongHieu;
import model.HdeGiay;
import model.Ispct;
import model.IspctInsert;
import org.jdesktop.animation.timing.Animator;
import utility.MsgBox;
import utility.Ximage;

public final class JDiaLogUpdateSPCT extends javax.swing.JFrame {

    public JDiaLogUpdateSPCT() {
        initComponents();
        init();
        initMoving(this);
        setLocation(500, 10);
    }
    private static Ispct spctInstance = new Ispct();//Lấy ra tất cả thông tin của đối tượng đã click vòa để đối chiếu khi thực hiện update
    //2 biến mục đích : Để biết nó có cập nhật ảnh không && ảnh nó cập nhật có trùng ảnh ban đầu không.
    static String tenAnh_spctInstance; //Dùng để check xem ảnh update có trùng với ảnh hiện tại không. Nếu trùng thì tb là ko nên update trùng ảnh. Và check xem có sự thay đổi ko ( ảnh là 1 trong số đó ).
    static String tenAnh_update;//đặt là static vì khi cập nhật nó chỉ so sánh với 1 tên ảnh đang được chọn hiện tại thôi.
    static String souce_TenAnh_Update; //Khi ảnh update chọn từ nguồn khác thì thực hiện thêm ảnh từ nguồn khác vào nguồn mặc định.

    public JDiaLogUpdateSPCT(Ispct spct) {
        initComponents();
        initMoving(this);
        init();
        setLocation(500, 10);
        spctInstance = spct; //mục đích để lấy tên SP để fill lại bảng chính sau khi update xong.
        //------------------THIẾT LẬP CÁC TRƯỜNG THÔNG TIN CỦA ĐỐI TƯỢNG CHO GIAO DIỆN 
        lbl_tenSP_ms_kt.setText(spct.getNametenGiay() + "  x  " + "[" + spct.getNamemauSac() + "-" + spct.getNamekichCo() + "]");
        //------Các ComboBox

        cbb_thuongHieu.setSelectedItem(spct.getNamethuongHieu().trim());
        dcbKichThuoc.setSelectedItem(spct.getNamekichCo().trim());
        cbb_mauSac.setSelectedItem(spct.getNamemauSac().trim());
        cbb_chatLieu.setSelectedItem(spct.getNamechatLieu().trim());
        cbb_deGiay.setSelectedItem(spct.getNamedeGiay().trim());
        cbb_dayGiay.setSelectedItem(spct.getNamedayGiay().trim());
        //-------Các thông số khác
        txt_giaBan.setText(spct.getGiaBan().toString().trim()); //Ko có dấu phẩy
        txt_soLuongTon.setText(String.valueOf(spct.getSoLuong()).trim());
        ta_MoTa.setText(spct.getMoTa().trim());
        //----Ảnh : nếu có ảnh thì fill lên còn ko có ảnh thì ghi là ko có ảnh
        if (spct.getNameanh() != null) {
            Image img = Ximage.getImageIcon("/Product_images", spct.getNameanh()).getImage().getScaledInstance(270, 260, Image.SCALE_SMOOTH);
            ImageIcon imgIcon = new ImageIcon(img);
            lbl_avatar.setIcon(imgIcon);
            lbl_avatar.setText(null);
        } else {
            lbl_avatar.setText("chưa thêm ảnh cho sp này.");
            lbl_avatar.setIcon(null);
        }
        lbl_maSo.setText(String.valueOf(spct.getId()));  //ID_SPCT

        tenAnh_spctInstance = spctInstance.getNameanh();//System.out.println("Tên ảnh của đối tượng : " + tenAnh_spctInstance);
        tenAnh_update = tenAnh_spctInstance;//System.out.println("Tên ảnh của AnhUpdate : " + tenAnh_update);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_tenSP_ms_kt = new javax.swing.JLabel();
        lbl_maSoSPCT = new javax.swing.JLabel();
        lbl_maSo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        cbb_thuongHieu = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        cbb_kichThuoc = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        cbb_mauSac = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        cbb_chatLieu = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        cbb_deGiay = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        cbb_dayGiay = new javax.swing.JComboBox<>();
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_giaBan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_soLuongTon = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_MoTa = new javax.swing.JTextArea();
        btn_capNhat = new javax.swing.JButton();
        btn_dongThemNhanh = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbl_avatar = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        maQR = new javax.swing.JLabel();
        test = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panel.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thông Tin Sản Phẩm"));

        lbl_tenSP_ms_kt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_tenSP_ms_kt.setText("Adidas Stan Smith x [Xanh - 40]");

        lbl_maSoSPCT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_maSoSPCT.setText("Mã Số SPCT : ");

        lbl_maSo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_maSo.setText("4");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_maSoSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_maSo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_tenSP_ms_kt, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_tenSP_ms_kt)
                    .addComponent(lbl_maSoSPCT)
                    .addComponent(lbl_maSo))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thông Tin Thuộc Tính"));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thương Hiệu"));

        cbb_thuongHieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 182, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(cbb_thuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cbb_thuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Kích Thước"));

        cbb_kichThuoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 182, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(cbb_kichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cbb_kichThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Màu Sắc"));

        cbb_mauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 182, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(cbb_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cbb_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Chất Liệu"));

        cbb_chatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 182, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(cbb_chatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cbb_chatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Đế Giày"));

        cbb_deGiay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 182, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(cbb_deGiay, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cbb_deGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Dây Giày"));

        cbb_dayGiay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 182, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(cbb_dayGiay, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(cbb_dayGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Giá Bán : ");

        txt_giaBan.setText("200.000.000");

        jLabel2.setText("Số Lượng Tồn : ");

        txt_soLuongTon.setText("300");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_soLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txt_soLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txt_giaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Mô Tả"));

        ta_MoTa.setColumns(20);
        ta_MoTa.setRows(5);
        jScrollPane1.setViewportView(ta_MoTa);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        btn_capNhat.setBackground(new java.awt.Color(255, 255, 0));
        btn_capNhat.setText("Cập Nhật");
        btn_capNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capNhatActionPerformed(evt);
            }
        });

        btn_dongThemNhanh.setBackground(new java.awt.Color(255, 255, 0));
        btn_dongThemNhanh.setText("Trở Về Giao Diện Chính");
        btn_dongThemNhanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dongThemNhanhActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Avatar"));
        jPanel1.setPreferredSize(new java.awt.Dimension(370, 260));

        lbl_avatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_avatar.setText("avatar");
        lbl_avatar.setPreferredSize(new java.awt.Dimension(360, 250));
        lbl_avatar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_avatarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbl_avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbl_avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "QRcode"));
        jPanel14.setPreferredSize(new java.awt.Dimension(256, 260));

        maQR.setText("QRCod");
        maQR.setPreferredSize(new java.awt.Dimension(256, 260));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(maQR, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(maQR, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
        );

        test.setText("Test");
        test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(test)
                .addGap(50, 50, 50)
                .addComponent(btn_dongThemNhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btn_capNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(test)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_capNhat)
                        .addComponent(btn_dongThemNhanh)))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_capNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capNhatActionPerformed
        String sLT = txt_soLuongTon.getText();
        String giaBan = txt_giaBan.getText();
        String moTa = ta_MoTa.getText();
        String thuongHieucbb = cbb_thuongHieu.getSelectedItem().toString().trim();
        String kichThuoccbb = cbb_kichThuoc.getSelectedItem().toString().trim();
        String mauSaccbb = cbb_mauSac.getSelectedItem().toString().trim();
        String chatLieucbb = cbb_chatLieu.getSelectedItem().toString().trim();
        String deGiaycbb = cbb_deGiay.getSelectedItem().toString().trim();
        String dayGiaycbb = cbb_dayGiay.getSelectedItem().toString().trim();

        int checkKhongTrungALL = checkKhongTrungTatCaThuocTinh_KhiInsert_SPCT(thuongHieucbb, kichThuoccbb, mauSaccbb, chatLieucbb, deGiaycbb, dayGiaycbb);
//        System.out.println(spctInstance.getNamethuongHieu());System.out.println(spctInstance.getNamekichCo());System.out.println(spctInstance.getNamemauSac());System.out.println(spctInstance.getNamechatLieu());System.out.println(spctInstance.getNamedeGiay());System.out.println(spctInstance.getNamedayGiay());
        if (fa.checkKhongNull_SPCT(sLT, giaBan) && fa.checkANumber_SPCT(sLT, giaBan) && fa.checkSoHopLe(sLT, giaBan)) {
            //TH1: Upda mà ko trùng thuộc tính <=> đã upda thuộc tính --> update cho nó. 
            //TH2: Upda nhưng trùng attri vs chính nó <=> y.c giá/sl/mô tả/ảnh phải upda
            //TH3: upda nhưng trùng attri vs spct khác <=> ko thể upda do attri upda trùng vs spct ? 
            if (checkKhongTrungALL == -1) {//TH1
                IspctInsert spctInsert = getSPCTUpdate(Integer.valueOf(lbl_maSo.getText()));//Thực hiện thiếp lập tham số Mã SPCT để thực hiện update dựa theo id_SPCT này
                prdd.update(spctInsert);
                String message = (prdd.update(spctInsert) == 1) ? "Cập nhật sản phẩm thành công" : "cập nhật thất bại";
                MsgBox.alter(this, message);
            } else if (checkKhongTrungALL != -1) {//TH trùng attri
                if (checkKhongTrungALL == Integer.valueOf(lbl_maSo.getText()) && ((checkKhongTrungSoLuongBanDau(sLT.trim()) || checkKhongTrungGiaBan(giaBan.trim()) || checkKhongTrungMoTa(moTa.trim()) || checkAnhUpdateKhongTrungVoiAnhBanDau_HoacKhongRong()))) {//TH2:  trùng vs chính nó
                    IspctInsert spctInsert = getSPCTUpdate(Integer.valueOf(lbl_maSo.getText()));//Thực hiện thiếp lập tham số Mã SPCT để thực hiện update dựa theo id_SPCT này
                    prdd.update(spctInsert);
                    String message = (prdd.update(spctInsert) == 1) ? "update giá bán/số lượng/mô tả/hình ảnh/thuộc tính thành công" : "cập nhật thất bại";
                    MsgBox.alter(this, message);
                } else if (checkKhongTrungALL != Integer.valueOf(lbl_maSo.getText())) {//TH3:  trùng attri vs spct khác. 
                    MsgBox.alter(this, "Cập nhật thuộc tính sản phẩm trùng với SPCT-" + checkKhongTrungALL + " nên không thể update.");
                } else {
                    MsgBox.alter(this, "Thay đổi 1 trường thuộc tính giá bán/số lượng/mô tả/hình ảnh/thuộc tính để thực hiện udapte");
                }
            }
        } else {
            MsgBox.alter(this, "Update sp mới thất bại");
        }
    }//GEN-LAST:event_btn_capNhatActionPerformed

    private void btn_dongThemNhanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dongThemNhanhActionPerformed
        this.dispose();
        MsgBox.alter(this, "Đã quay về giao diện chính");
    }//GEN-LAST:event_btn_dongThemNhanhActionPerformed

    private void lbl_avatarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_avatarMouseClicked
        JFileChooser jfc = new JFileChooser("D:\\FPT_Semester_4_Block2\\DA1\\GiaoDienManh\\P4_HuongDanThietKeGiaoDienTrongJavaSwing\\src\\Product_images");
        int result = jfc.showOpenDialog(null); //Kq thao tác của người dùng khi mở hộp thoại theo đường dẫn truyền vào.
        switch (result) {
            case JFileChooser.APPROVE_OPTION -> {
                File file = jfc.getSelectedFile(); //D:\FPT_Semester_4_Block2\DA1\GiaoDienManh\P4_HuongDanThietKeGiaoDienTrongJavaSwing\src\Product_images\giay-puma-court-star-sl-nam-trang-den-01-200x400.png

                int lastBackslashIndex = file.toString().lastIndexOf("\\"); //Lấy vị trí của dấu '\' cuối cùng
                String folder = file.toString().substring(0, lastBackslashIndex);//Lấy folder mà bỏ tên ImageIcon đi.
                //----> lấy ra được folder
                final String nameImageIcon = file.getName();//--> Lấy ra được tên ảnh
                JDiaLogUpdateSPCT.tenAnh_update = nameImageIcon; //Lấy tên ảnh Update để thực hiện so sánh và update và validation.
                ImageIcon imgIcon = new ImageIcon(folder + "\\" + nameImageIcon);
                souce_TenAnh_Update = jfc.getSelectedFile().toString();
                if (imgIcon != null) {
                    lbl_avatar.setText(null);
                    Image img = imgIcon.getImage().getScaledInstance(270, 260, Image.SCALE_SMOOTH);//ép kiểu imageIcon thành Image với kich thước được sửa
                    imgIcon = new ImageIcon(img);//Ép kiểu lại ImageIcon + kích thước được sửa.
                    lbl_avatar.setIcon(imgIcon);
                }
            }
            case JFileChooser.CANCEL_OPTION ->
                MsgBox.alter(this, "Hủy thiết lập ảnh");
            default ->
                MsgBox.alter(this, "Lỗi lấy imgIcon");
        }


    }//GEN-LAST:event_lbl_avatarMouseClicked

    private void testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testActionPerformed
        String sLT = txt_soLuongTon.getText();
        String giaBan = txt_giaBan.getText();
        String moTa = ta_MoTa.getText().trim();
        String thuongHieucbb = cbb_thuongHieu.getSelectedItem().toString().trim();
        String kichThuoccbb = cbb_kichThuoc.getSelectedItem().toString().trim();
        String mauSaccbb = cbb_mauSac.getSelectedItem().toString().trim();
        String chatLieucbb = cbb_chatLieu.getSelectedItem().toString().trim();
        String deGiaycbb = cbb_deGiay.getSelectedItem().toString().trim();
        String dayGiaycbb = cbb_dayGiay.getSelectedItem().toString().trim();
//        boolean checkKhongTrungALL = checkKhongTrungTatCaThuocTinh_KhiInsert_SPCT(thuongHieucbb, kichThuoccbb, mauSaccbb, chatLieucbb, deGiaycbb, dayGiaycbb);
//        System.out.println("không trùng tất cả " + checkKhongTrungALL);
        System.out.println("không trùng mô tả " + checkKhongTrungMoTa(moTa));
        System.out.println("không trùng ảnh update " + checkAnhUpdateKhongTrungVoiAnhBanDau_HoacKhongRong());

    }//GEN-LAST:event_testActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JDiaLogUpdateSPCT().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_capNhat;
    private javax.swing.JButton btn_dongThemNhanh;
    private javax.swing.JComboBox<String> cbb_chatLieu;
    private javax.swing.JComboBox<String> cbb_dayGiay;
    private javax.swing.JComboBox<String> cbb_deGiay;
    private javax.swing.JComboBox<String> cbb_kichThuoc;
    private javax.swing.JComboBox<String> cbb_mauSac;
    private javax.swing.JComboBox<String> cbb_thuongHieu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_avatar;
    private javax.swing.JLabel lbl_maSo;
    private javax.swing.JLabel lbl_maSoSPCT;
    private javax.swing.JLabel lbl_tenSP_ms_kt;
    private javax.swing.JLabel maQR;
    private javax.swing.JPanel panel;
    private javax.swing.JTextArea ta_MoTa;
    private javax.swing.JButton test;
    private javax.swing.JTextField txt_giaBan;
    private javax.swing.JTextField txt_soLuongTon;
    // End of variables declaration//GEN-END:variables
    JPSanPham fa = new JPSanPham();
    ProductDetaisDAO prdd = new ProductDetaisDAO();

    Anh_Image_DAO anhDao = new Anh_Image_DAO();

    //Dao của các Combobo
    ThuongHieuDao thd = new ThuongHieuDao();
    KichCoDAO kcd = new KichCoDAO();
    MauSacDAO msd = new MauSacDAO();
    ChatLieuDAO cld = new ChatLieuDAO();
    DeGiayDao dgd = new DeGiayDao();
    DayGiayDao dgd2 = new DayGiayDao();
    //Modun các combobox
    DefaultComboBoxModel dcbThuongHieu;
    DefaultComboBoxModel dcbKichThuoc;
    DefaultComboBoxModel dcbMauSac;
    DefaultComboBoxModel dcbChatLieu;
    DefaultComboBoxModel dcbDeGiay;
    DefaultComboBoxModel dcbDayGiay;
//------------------------------------------------------------------------------    

    private void init() {
        this.setLocationRelativeTo(null); //căn ra giữa
        fill_ThuongHieu_To_Cbb();
        fill_MauSac_To_Cbb();
        fill_ChatLieu_To_Cbb();
        fill_DeGiay_To_Cbb();
        fill_DayGiay_To_Cbb();
        fill_KichThuoc_To_Cbb();
    }

    public IspctInsert getSPCTUpdate(int id_SPCT) {//Thực hiện update tất cả thông số theo ID_SPCT nhưng ko update tên.SP
        IspctInsert spctInsert = new IspctInsert();

        spctInsert.setId_SPCT(id_SPCT);//Thiết lập giá trị cho SPCT //        System.out.println("ID_SPCT " + id_SPCT);

        spctInsert.setId_thuongHieu(fa.getMaThuocTinhToName("danh sách thương hiệu", dcbThuongHieu.getSelectedItem().toString(), ThuongHieu.class));//        System.out.println("ID_Thương Hiệu " + spctInsert.getId_thuongHieu());

        spctInsert.setId_kichThuoc(fa.getMaThuocTinhToName("danh sách kích thước", dcbKichThuoc.getSelectedItem().toString(), KichCo.class));//        System.out.println("ID_Kích Thước " + spctInsert.getId_kichThuoc());

        spctInsert.setId_mauSac(fa.getMaThuocTinhToName("danh sách màu sắc", dcbMauSac.getSelectedItem().toString(), MauSac.class));//        System.out.println("ID_Màu_Sắc " + spctInsert.getId_mauSac());

        spctInsert.setId_chatLieu(fa.getMaThuocTinhToName("danh sách chất liệu", dcbChatLieu.getSelectedItem().toString(), ChatLieu.class));//        System.out.println("ID_Chất Liệu " + spctInsert.getId_chatLieu());

        spctInsert.setId_deGiay(fa.getMaThuocTinhToName("danh sách đế giày", dcbDeGiay.getSelectedItem().toString(), HdeGiay.class));//        System.out.println("ID_Đế Giày " + spctInsert.getId_deGiay());

        spctInsert.setId_dayGiay(fa.getMaThuocTinhToName("danh sách dây giày", dcbDayGiay.getSelectedItem().toString(), DayGiay.class));//        System.out.println("ID_Dây Giày " + spctInsert.getId_dayGiay());

        //TH ảnh ko tồn tại trong File ảnh chứa sản phẩm thì thực hiện copy ảnh đó vào file chứa các ảnh sản phẩm bằng method save()
        //Sau đó thực hiện insert vào dữ liệu. Sau đó theo tên ảnh truy ra ID --> Lưu id cho đối tượng.
        //TH Ảnh là null mà ko thực hiện thay đổi ảnh thì khi update --> Update là NULL
        if (tenAnh_update != null) {
            spctInsert.setId_anh(updateAnhToObject());// Dựa vào phương thức này thì lấy ra id_ảnh chọn để thực hiện thiết lập ID_ảnh cho spct
        } else {
            spctInsert.setId_anh(-1);//default -1 là ko có ảnh
        }

        spctInsert.setSoLuong(Integer.valueOf(txt_soLuongTon.getText()));//SỐ LƯỢNG

        String giaBanStr = txt_giaBan.getText().trim(); //Bỏ khoảng trắng
        String giaBanStr_BoDau_ChamPhay = giaBanStr.replaceAll("\\,", ""); //thay các dấu ',' bằng rỗng
        Double giaBanDouble = Double.valueOf(giaBanStr_BoDau_ChamPhay); //Ép ra double
//        System.out.println(giaBanDouble); //In ra check

        spctInsert.setGiaBan(BigDecimal.valueOf(giaBanDouble));//Ép ra BigDecimal và thiết lập giá trị

        spctInsert.setMoTa(ta_MoTa.getText());   // MÔ TẢ 
//        System.out.println(ta_MoTa.getText());

//      spctInsert.setMaQR("Mã.QR_Null");
        spctInsert.setUpdate_by(3);  //NGƯỜI SỬA ( Update )

        spctInsert.setTrangThai("Hoạt Động"); //TRẠNG THÁI dựa vào số lượng của SPCT dù Insert ( Update ko có vì nếu nó là 0 thì ko thể nào update đc ? ) 
        spctInsert.setDeleted(0);

        return spctInsert;
    }
//-----------------------Validation khi thực hiện update ít nhất 1 có 1 trường giá trị thay đổi 
    //Lấy d/s đối tượng theo tên. 

    public int checkKhongTrungTatCaThuocTinh_KhiInsert_SPCT(String thuongHieu, String kichThuoc, String mauSac, String chatLieu, String deGiay, String DayGiay) {
        int id = -1;//Là ko trùng.
        List<Ispct> listSPCT_ByName = prdd.select_ALL_SPCT_By_Name(spctInstance.getNametenGiay());
        for (Ispct spct : listSPCT_ByName) {
            boolean trungThuongHieu = thuongHieu.equals(spct.getNamethuongHieu());
            boolean trungKichCo = kichThuoc.equals(spct.getNamekichCo());
            boolean trungMauSac = mauSac.equals(spct.getNamemauSac());
            boolean trungChatLieu = chatLieu.equals(spct.getNamechatLieu());
            boolean trungDeGiay = deGiay.equals(spct.getNamedeGiay());
            boolean trungDayGiay = DayGiay.equals(spct.getNamedayGiay());
            if (trungThuongHieu && trungKichCo && trungMauSac && trungChatLieu && trungDeGiay && trungDayGiay) {
                id = spct.getId();//Nếu mà trùng <=> Xét xem có phải trùng vs nó ko.
                break;
            }
        }
        return id;
    }

    public boolean checkKhongTrungSoLuongBanDau(String SLinput) {//dựa vào SL của đối tượng đầu vào và so với giá trị nhập trên bảng
//        System.out.println("SLinput : " + SLinput);System.out.println("SLĐT : " + String.valueOf(spctInstance.getSoLuong()).trim());
        return !String.valueOf(spctInstance.getSoLuong()).trim().equals(SLinput);
    }

    public boolean checkKhongTrungGiaBan(String giaBanInput) { //cx dựa vào giá bán của dối tượng đầu vào và giá trị nhập
//        System.out.println("giaBanInput : " + giaBanInput);System.out.println("GiaBanĐT : " + String.valueOf(spctInstance.getGiaBan()).trim());
        String giaBancuaDoiTuong = String.valueOf(spctInstance.getGiaBan()).trim();
        return !giaBanInput.trim().equals(giaBancuaDoiTuong);//Nếu giá bán và giá của đối tượng khác nhau thì là true.
    }

    public boolean checkKhongTrungMoTa(String moTaInput) {
//        System.out.println("moTaInput : " + moTaInput);System.out.println("MoTa.ĐS : " + String.valueOf(spctInstance.getMoTa()).trim());
        return !spctInstance.getMoTa().trim().equals(moTaInput.trim());
    }

    //check xem ảnh đối tượng có khác ảnh cập nhật ko. 
    //nếu ảnh cập nhật trùng ảnh đối tượng là trùng. Là nó ko chọn ảnh để cập nhật
    //nếu ảnh cập nhật khác ảnh đối tượng là ko trùng . Là nó đã chọn ảnh khác để cập nhật và thực hiện cập nhật là trả về true.
    public boolean checkKhongTrungTenSP() {//Khi thực hiện Update thì ảnh update ko đc trùng với ảnh ban đầu.
        String message = (tenAnh_update.equals(tenAnh_spctInstance)) ? "Ảnh trùng với ảnh hiện có. không cập nhật" : "Cập nhật ảnh thành công";
        return !tenAnh_spctInstance.equals(tenAnh_update); //Là tên ảnh hiện tại ko cùng tên biến.
    }

    //-------------------------UTILITY : Tiện ích liên quan đến ảnh.
    //Thực hiện update  tên ảnh cho đối tượng  
    //Trường hợp ảnh chưa có trong DB thì thực hiện thêm ảnh vào DB xog rồi update id_anh cho spct. ( theo id_anh có sẵn hoặc mới thêm vào )
    //Nếu trường hợp có rồi thì từ tên ảnh truy ra id_anh và update cho sản phẩm
    //Còn nếu khi đang ko có ảnh mà thực hiện cập nhật thì phải thông báo ko cho cập nhật.
    public int updateAnhToObject() {//Trả về ID_anh để thêm vào đối tượng.
        //Nếu chưa tồn tại thì insert vòa bảng ảnh và thêm vào thư mục ảnh dó
        if (!checkTonTaiAnhTrongThuMuc(tenAnh_update)) {
            Anh_Image anhUpdate = new Anh_Image();
            anhUpdate.setTenAnh(tenAnh_update);
            anhUpdate.setTrangThai("Đang áp dụng");
            anhUpdate.setNguoiTao(2);//mặc định người tạo hiện tại là 2
            this.anhDao.insert(anhUpdate);
            checkAnhCoTonTaiKhongDeThemVaoFolder(souce_TenAnh_Update);//Thêm ảnh lấy ngoài vào source mặc định thì thực hiện cập nhật
        }

        int id_Anh = anhDao.selectIDByNameAnh(tenAnh_update); //Truy vấn từ tên ảnh update ra ID_anh để cập nhật lại vào spct.
        return id_Anh;
    }

    public void checkAnhCoTonTaiKhongDeThemVaoFolder(String souce_TenAnh_Update) {
        if (!checkTonTaiAnhTrongThuMuc(tenAnh_update)) {//Nếu mà chưa tồn tại trong thư mục mặc định thì thực hiện copy ảnh từ chỗ source vào nguồn mặc định
            File source_update_anh = new File(souce_TenAnh_Update);
            save(source_update_anh);
        }
    }

    //Kiểm tra xem tên ảnh FileName đã tồn tại trong thư mục mặc định chưa ( ở đưới ).
    public boolean checkTonTaiAnhTrongThuMuc(String fileName) {
        File fileToCheck = new File("E:\\Du_an1_ql\\src\\Product_images\\" + fileName);
        String massage = (fileToCheck.exists()) ? "ảnh đã tồn tại trong thư mục mặc định " : "ảnh chưa tồn tại";
        return fileToCheck.exists(); //Nếu ảnh đã tồn tại trả về là True.
    }

    //Nếu TH có ảnh ( != 1 ) thì mới check ảnh update vs ảnh ban đầu = equals.
    //TH Nếu ko có ảnh thì khi update cần check xem nó có chọn ảnh update ko. 
    //Mục đích : Để xem avatar có đc update hay ko. 
    public boolean checkAnhUpdateKhongTrungVoiAnhBanDau_HoacKhongRong() {
        if (spctInstance.getNameanh() != null) {//Nếu ban đầu có ảnh. Thì check xem trùng ko. 
            return !tenAnh_spctInstance.equals(tenAnh_update);
        } else {//còn nếu ko có ảnh thì chek xem có null nx hay ko. Nếu mà vẫn null là nó đang là -1. Trả về false
            return tenAnh_update != null;
        }
    }

    public boolean checkAnhKhongNull() {
        return tenAnh_spctInstance != null;
    }

    public static void save(File source_update_anh) { //Thực hiện lưu 1 ảnh = src.getName ( ra tên ảnh ) ( với đường dẫn tới ảnh đó = src vào thư mục lưu ảnh sản phẩm ( như ở dưới ) 
        // Tạo một đối tượng File đích với thư mục là "logos" và tên tệp giống với tên tệp nguồn
        File dst = new File("E:\\Du_an1_ql\\src\\Product_images", source_update_anh.getName());

        // Kiểm tra xem thư mục cha của dst có tồn tại hay không. Nếu không, tạo thư mục cha
        if (!dst.getParentFile().exists()) {
            dst.getParentFile().mkdirs();
        }

        try {
            // Tạo đối tượng Path từ đường dẫn tuyệt đối của tệp nguồn và tệp đích
            Path from = Paths.get(source_update_anh.getAbsolutePath());
            Path to = Paths.get(dst.getAbsolutePath());

            // Thực hiện sao chép và ghi đè nếu tệp đích đã tồn tại
            Files.copy(from, to, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("File copied successfully.");
        } catch (IOException ex) {
            // Nếu có lỗi, ném RuntimeException
            throw new RuntimeException(ex);
        }
    }

//---------------------------------Fill các thuộc tính lên ComboBox
    public void fill_ThuongHieu_To_Cbb() {//Đổ tất cả Thường hiệu vào Cbb
        dcbThuongHieu = (DefaultComboBoxModel) this.cbb_thuongHieu.getModel();
        dcbThuongHieu.removeAllElements();
        List<ThuongHieu> listTH = thd.selectAll();
        for (ThuongHieu TH : listTH) {
            dcbThuongHieu.addElement(TH.getName());
        }
    }

    public void fill_KichThuoc_To_Cbb() {//Đổ tất cả Kích Cỡ vào Cbb
        dcbKichThuoc = (DefaultComboBoxModel) this.cbb_kichThuoc.getModel();
        dcbKichThuoc.removeAllElements();
        List<KichCo> listKC = kcd.selectAll();
        for (KichCo KC : listKC) {
            dcbKichThuoc.addElement(KC.getName());
        }
    }

    public void fill_MauSac_To_Cbb() {//Đổ tất cả Màu Sắc vào Cbb
        dcbMauSac = (DefaultComboBoxModel) this.cbb_mauSac.getModel();
        dcbMauSac.removeAllElements();
        List<MauSac> listMS = msd.selectAll();
        for (MauSac MS : listMS) {
            dcbMauSac.addElement(MS.getName());
        }
    }

    public void fill_ChatLieu_To_Cbb() {//Đổ tất Chât Liệu vào Cbb
        dcbChatLieu = (DefaultComboBoxModel) this.cbb_chatLieu.getModel();
        dcbChatLieu.removeAllElements();
        List<ChatLieu> listCL = cld.selectAll();
        for (ChatLieu CL : listCL) {
            dcbChatLieu.addElement(CL.getName());
        }
    }

    public void fill_DeGiay_To_Cbb() {//Đổ tất cả Đế Giày vào Cbb
        dcbDeGiay = (DefaultComboBoxModel) this.cbb_deGiay.getModel();
        dcbDeGiay.removeAllElements();
        List<HdeGiay> listDG = dgd.selectAll();
        for (HdeGiay DG : listDG) {
            dcbDeGiay.addElement(DG.getName());
        }
    }

    public void fill_DayGiay_To_Cbb() {//Đổ tất cả Dây giày vào Cbb
        dcbDayGiay = (DefaultComboBoxModel) this.cbb_dayGiay.getModel();
        dcbDayGiay.removeAllElements();
        List<DayGiay> listDG = dgd2.selectAll();
        for (DayGiay DG : listDG) {
            dcbDayGiay.addElement(DG.getName());
        }
    }
//------------------------utility 

    public static String formatNumber(BigDecimal number) {
        //Tạo một đối tượng NumberFormat với Locale.US để sử dụng định dạng tiền tệ của Hoa Kỳ
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        // Định dạng số
        return numberFormat.format(number);//Định dạng số và chuyển nó thành String.
    }

    public void setTT_Selected_Before_Update(String thuongHieu, String kichThuoc, String mauSac, String chatLieu, String deGiay, String dayGiay) {
        cbb_thuongHieu.setSelectedItem(thuongHieu);
        cbb_kichThuoc.setSelectedItem(kichThuoc);
        cbb_mauSac.setSelectedItem(mauSac);
        cbb_chatLieu.setSelectedItem(chatLieu);
        cbb_deGiay.setSelectedItem(deGiay);
        cbb_dayGiay.setSelectedItem(dayGiay);
    }

//------------------------------------Thiết lập di chuyên cho giao diện 
    private int x;
    private int y;

    public void initMoving(JFrame fram) {
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                x = e.getX();
                y = e.getY();
            }
        });
        panel.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                fram.setLocation(e.getXOnScreen() - x, e.getYOnScreen() - y);
            }
        });
    }

}//end life
