/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Voucher;
import service.TableActionEvent;
import service.service_voucher;
/**
 *
 * @author Tran Viet Vuong
 */
public class JPVoucher extends javax.swing.JPanel {
    private SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aaa");
    private SimpleDateFormat formats = new SimpleDateFormat("yyyy-MM-dd");
    private static boolean Isvoucher = true;
    private service_voucher ser = new service_voucher();
    private DefaultTableModel mol = new DefaultTableModel();
    private int index = -1;
    DecimalFormat df = new DecimalFormat("###.###");

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        JPVoucher spview = new JPVoucher();
        jf.add(spview);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }
    /**
     * Creates new form Tran Viet Vuong
     */
    public JPVoucher() {
        initComponents();
        TableActionEvent event = new TableActionEvent() {
            @Override
            public void onDelete(int row) {
                if (tblvoucher.isEditing()) {
                    tblvoucher.getCellEditor().stopCellEditing();
                }

                updateTrangThaiKT(row);

            }
        };

        String menus[] = {"Sắp diễn ra", "Đang diễn ra", "Đã kết thúc"};
        for (String item : menus) {
            cbtrangthai.addItem(item);
        }

        cbhinhthuc.addItem(" tiền mặt");
        cbhinhthuc.addItem("phần trăm");
        if (cbhinhthuc.equals("tiền mặt")) {
            txtgiatritoidavoucher.setEnabled(false);
            cbhinhthuc.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selectedValue = cbhinhthuc.getSelectedItem().toString();
                    if ("Tiền mặt".equals(selectedValue) && !txtgiatritoidavoucher.isEnabled()) {
                        // Nếu giá trị là "Tiền mặt" và JTextField đã khóa, thoát khỏi sự kiện
                        return;
                    }

                    // Xử lý logic khi giá trị thay đổi
                    if ("Tiền mặt".equals(selectedValue)) {
                        // Nếu giá trị là "Tiền mặt", khóa JTextField
                        txtgiatritoidavoucher.setEnabled(false);
                    } else {
                        // Ngược lại, mở khóa JTextField
                        txtgiatritoidavoucher.setEnabled(true);
                    }
                }
            });
        }

        cbhinhthuc1.addItem("phần trăm");
        cbhinhthuc1.addItem(" tiền mặt");

        this.filltable(ser.getAll1());

        Thread t1 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
//                    updateTrangThai();
                        filltable(ser.getAll1());
                        sleep(60000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };
        t1.start();
    }
    void filltable(List<Voucher> list) {
        mol = (DefaultTableModel) tblvoucher.getModel();
        mol.setRowCount(0);
        int str = 1;
        for (Voucher x : list) {
            String trangthai = "";
            int trangThai = x.getTrangthai();

            Date StartDate = x.getNgaybatdau();
            Date EndDate = x.getNgayketthuc();
            Date ngayTao = new Date();
            LocalDateTime ngaytao = LocalDateTime.now();

            if (StartDate != null || EndDate != null) {

//                if (ngayTao.getTime() < StartDate.getTime()) {
//                    ser.updateTT1(x, x.getMa());
//                } else
                if (ngayTao.getTime() >= StartDate.getTime() && ngayTao.getTime() < EndDate.getTime()) {
                    ser.updateTT2(x, x.getMa());
                } else if (ngayTao.getTime() >= EndDate.getTime()) {
                    ser.updateTT3(x, x.getMa());
                }

            }

            if (trangThai == 1) {
                trangthai = "Sắp diễn ra";
            } else if (trangThai == 2) {
                trangthai = "Đang diễn ra";
            } else if (trangThai == 3) {
                trangthai = "Đã kết thúc";
            }

            Object[] data = {str++, x.getMa(), x.getMota(), x.getHinhthuc(), x.getGiatrivoucher(), x.getGiatritoidavc(), x.getGiatriap(), x.getSoluong(), x.getNgaybatdau(), x.getNgayketthuc(), trangthai, x.getNgaytao()};
            mol.addRow(data);

        }
    }

    private void Reset() {
        txtmota.setText("");
        txtma.setText("");
        cbhinhthuc.setSelectedItem(0);
        txtgiatrivoucher.setText("");
        txtgiatriapdung.setText("");
        txtgiatritoidavoucher.setText("");
        date_batdau.setDate(null);
        date_ketthuc.setDate(null);
        txttimkiem.setText("");
        txtsoluong.setText("");
        //this.filltable(ser.getAll1());
    }
//    private model.voucher readForm2() {
//        java.util.Date StartDate = date_batdau.getDate();
//        java.util.Date EndDate = date_ketthuc.getDate();
//        java.util.Date ngayTao = new Date();
//        return new model.voucher(ngayTao);
//    }

    public void updateTrangThaiKT(int row) {
        row = tblvoucher.getSelectedRow();
        Voucher nv = this.readRorm();
        String ten = tblvoucher.getValueAt((row), 1).toString();
        if (ser.update2(nv, ten) > 0) {
            JOptionPane.showMessageDialog(this, "Sửa thành công");
            this.filltable(ser.getAll1());
        }
        // this.fillTable(ser.getAll1();
    }

    private String date2String(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return sdf.format(date);
    }

    // Hàm chuyển đổi từ date về string
    private Date parseDate(String ngayThang) {
        // Đối tượng hỗ trợ đọc kiểu dữ liệu ngày tháng
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //String date = DateFormat.
        try {
            return sdf.parse(ngayThang);
        } catch (Exception e) {
            //Nếu lỗi trả về thời điểm hiện tại
            return new Date();
        }
    }

    public Voucher readRorm() {
//
//        String ten = txtten.getText().trim();
//        String ma = txtma.getText().trim();
//        Integer soluong = Integer.parseInt(txtsoluong.getText());
//        Float giatri = Float.parseFloat(txtgiatri.getText());
//        Date dateBatDau = date_batdau.getDate();
//        Date dateKetThuc = date_ketthuc.getDate();
//        Double giatrimin = Double.parseDouble(txtgiatritoithieu.getText());
//        BigDecimal giatritoithieu = BigDecimal.valueOf(giatrimin);
//        Double giatrimax = Double.parseDouble(txtgiatritoida.getText());
//        BigDecimal giatritoida = BigDecimal.valueOf(giatrimax);
//        String ht = String.valueOf(cbhinhthuc.getSelectedItem());
//        java.util.Date ngayTao = new Date(); // Khai báo ngayTao một lần
//        int trangthai = 1;
//
//        if (ngayTao.getTime() >= dateBatDau.getTime() && ngayTao.getTime() < dateKetThuc.getTime()) {
//            trangthai = 2;
//        } else if (ngayTao.getTime() >= dateKetThuc.getTime()) {
//            trangthai = 3;
//        } else if (ngayTao.getTime() < dateBatDau.getTime()) {
//            trangthai = 1;
//        }
//
//        return new voucher(ma, ten, ht, giatritoithieu, giatritoida, giatri, soluong, dateKetThuc, ngayTao, trangthai);

        String ten = txtmota.getText().trim();
        String ma = txtma.getText().trim();
        Integer soluong = Integer.parseInt(txtsoluong.getText());
        Float giatriapdug = Float.parseFloat(txtgiatriapdung.getText());
        Date dateBatDau = date_batdau.getDate();
        Date dateKetThuc = date_ketthuc.getDate();
        Double giatrimx = Double.parseDouble(txtgiatritoidavoucher.getText());
        BigDecimal gaitritoidavc = BigDecimal.valueOf(giatrimx);
        Double giatrimin = Double.parseDouble(txtgiatrivoucher.getText());
        BigDecimal giatrivc = BigDecimal.valueOf(giatrimin);
        String ht = String.valueOf(cbhinhthuc.getSelectedItem());
        java.util.Date StartDate = date_batdau.getDate();
        java.util.Date EndDate = date_ketthuc.getDate();
        java.util.Date ngayTao = new Date();
        int trangthai = 1;

        if (ngayTao.getTime() >= StartDate.getTime() && ngayTao.getTime() < EndDate.getTime()) {
            trangthai = 2;
        } else if (ngayTao.getTime() >= EndDate.getTime()) {
            trangthai = 3;
        } else if (ngayTao.getTime() < StartDate.getTime()) {
            trangthai = 1;
        }

        return new Voucher(ma, ten, ht, giatrivc, gaitritoidavc, giatriapdug, soluong, dateKetThuc, dateBatDau, trangthai);
    }

    void search(String str) {
        DefaultTableModel model = (DefaultTableModel) tblvoucher.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
        tblvoucher.setRowSorter(trs);
        String searchText = txttimkiem.getText().trim();
        trs.setRowFilter(RowFilter.regexFilter(str));
    }

    public void showData(int index) {

        // Lấy đối tượng voucher tại chỉ số index
        Voucher x = (Voucher) ser.loadData1().get(index);
        txtgiatriapdung.setText(String.valueOf(x.getGiatriap()));
        txtsoluong.setText(String.valueOf(x.getSoluong()));
        // Thiết lập các giá trị trong các thành phần của biểu mẫu
        txtmota.setText(x.getMota());
        txtma.setText(x.getMa());
        cbhinhthuc.setSelectedItem(x.getHinhthuc());
        txtgiatrivoucher.setText(String.valueOf(x.getGiatrivoucher()));
        //txttimkiem.setText(String.valueOf(x.getSoluong()));
        txtgiatritoidavoucher.setText(String.valueOf(x.getGiatritoidavc()));

        // Thiết lập giá trị ngày
        date_batdau.setDate(x.getNgaybatdau());
        date_ketthuc.setDate(x.getNgayketthuc());
//        // lâys dối tượng sv từ list tại vị trí index
//        voucher x = (voucher) ser.getAll().get(index);
//        txtten.setText(x.getTen());
//        txtma.setText(x.getMa());
//        //  txtsoluong.setText(String.valueOf(x.getGiatri()));
//        cbhinhthuc.setSelectedItem(x.getHinhthuc());
//        txtgiatritoithieu.setText(String.valueOf(x.getGiatritoithieu()));
//        txtsoluong.setText(String.valueOf(x.getSoluong()));
//        txtgiatritoida.setText(String.valueOf(x.getGiatritoida()));
//
//        date_batdau.setDate(x.getNgaybatdau());
//        date_ketthuc.setDate(x.getNgaybatdau());

    }

    // Hàm kiểm tra xem một chuỗi có chứa chỉ số hay không
    private boolean isNumeric(String str) {
        return str.matches("\\d+"); // Kiểm tra xem chuỗi có chứa chỉ số (số) hay không
    }

    // check kí tự và độ dài
    private boolean isSpecialCharacterPresent(String input) {
        // Kiểm tra xem có ký tự đặc biệt nào trong chuỗi không
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }

    private boolean isLengthWithinLimit(String input, int maxLength) {
        // Kiểm tra xem chiều dài của chuỗi có vượt quá giới hạn không
        return input.length() <= maxLength;
    }

    Boolean vadidate() {
        if (txtmota.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên!");
            return false;
        }
//        if (isSpecialCharacterPresent(txtmota.getText().trim())) {
//            JOptionPane.showMessageDialog(this, "Mô tả không được chứa ký tự đặc biệt!");
//            return false;
//        } 
        if (txtma.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã!");
            return false;
        }
        if (isSpecialCharacterPresent(txtma.getText().trim())) {
            JOptionPane.showMessageDialog(this, "mã không được chứa ký tự đặc biệt!");
            return false;
        }
        if (!isLengthWithinLimit(txtma.getText().trim(), 7)) {
            JOptionPane.showMessageDialog(this, "mã quá dài!");
            return false;
        }
        if (cbhinhthuc.equals("tiền mặt ")) {

        } else {
            if (txtgiatritoidavoucher.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập giá trị tối đa!");
                return false;
            }
            if (!isNumeric(txtgiatritoidavoucher.getText().trim())) {
                JOptionPane.showMessageDialog(this, "Giá trị tối đa chỉ được nhập số!");
                return false;
            }
        }

        try {
            Double mucGiam = Double.parseDouble(txtgiatritoidavoucher.getText().trim());
            BigDecimal mucGiamGia = BigDecimal.valueOf(mucGiam);
            if (cbhinhthuc.getSelectedItem().equals("phần trăm")) {
                if (mucGiam >= 100 || mucGiam <= 0) {
                    JOptionPane.showMessageDialog(this, ""
                            + "Giá trị tối đa chỉ được giảm 100% trở xuống và lớn hơn 0!");
                    return false;
                }
            }
            if (cbhinhthuc.getSelectedItem().equals("tiền mặt")) {
                if (mucGiam <= 0) {
                    JOptionPane.showMessageDialog(this, "Giá trị tối đa chỉ được lớn hơn 0!");
                    return false;
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá trị tối đa sai định dạng!");
            return false;
        }
        if (txtgiatrivoucher.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập giá trị tối thiểu!");
            return false;
        }
        try {
            Double toithieu = Double.parseDouble(txtgiatrivoucher.getText().trim());
            BigDecimal giatritoithieu = BigDecimal.valueOf(toithieu);
            if (toithieu <= 0) {
                JOptionPane.showMessageDialog(this, "Giá trị tối thiểu phải lớn hơn 0!");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Giá trị tối thiểu sai định dạng!");
            return false;

        }
        if (txtsoluong.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng!");
            return false;
        }
        try {
            Integer soLuong = Integer.parseInt(txtsoluong.getText().trim());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là một số nguyên lớn hơn 0!");
            return false;
        }
        Integer soLuong = Integer.parseInt(txtsoluong.getText().trim());

        if (soLuong <= 0) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là một số nguyên lớn hơn 0!");
            return false;
        }
        if (date_batdau.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày bắt đầu!");
            return false;
        }
        if (date_ketthuc.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày kết thúc!");
            return false;
        }
        Date startDateUtil = date_batdau.getDate();
        Date endDateUtil = date_ketthuc.getDate();
// Chuyển đổi từ java.util.Date sang LocalDate
        LocalDate startDate = startDateUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate endDate = endDateUtil.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        // LocalDate currentDate = LocalDate.now();

        if (startDate.isAfter(endDate)) {
            JOptionPane.showMessageDialog(this, "Ngày bắt đầu phải nhỏ hơn  ngày kết thúc!");
            return false;
        } else if (endDate.isBefore(startDate)) {
            JOptionPane.showMessageDialog(this, "Ngày kết thúc phải lớn hơn ngày bắt đầu!");
            return false;
        }
        return true;
    }

    public void AddPleacehoderStyle(JTextField textField) {
        Font font = textField.getFont();
        font = font.deriveFont(Font.ITALIC);
        textField.setFont(font);
        textField.setForeground(Color.gray);
    }

    public void RemovePleacehoderStyle(JTextField textField) {
        Font font = textField.getFont();
        font = font.deriveFont(Font.PLAIN);
        textField.setFont(font);
        textField.setForeground(Color.black);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtmota = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbhinhthuc = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtgiatritoidavoucher = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtma = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtgiatriapdung = new javax.swing.JTextField();
        txtsoluong = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        date_batdau = new com.toedter.calendar.JDateChooser();
        date_ketthuc = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        txtgiatrivoucher = new javax.swing.JTextField();
        btnreset = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblvoucher = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        cbhinhthuc1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        date_batdau1 = new com.toedter.calendar.JDateChooser();
        date_ketthuc1 = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        cbtrangthai = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        txtsoluong1 = new javax.swing.JTextField();
        txttimkiem = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Mô tả voucher ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("hình thức giảm giá");

        cbhinhthuc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbhinhthucItemStateChanged(evt);
            }
        });
        cbhinhthuc.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                cbhinhthucComponentHidden(evt);
            }
        });
        cbhinhthuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbhinhthucActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Giá trị tối đa voucher ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Số lượng");

        txtgiatritoidavoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgiatritoidavoucherActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("mã voucher");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Giá trị áp dụng");

        txtgiatriapdung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgiatriapdungActionPerformed(evt);
            }
        });

        txtsoluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsoluongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbhinhthuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtma)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3)
                                .addComponent(txtmota, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                                .addComponent(txtgiatritoidavoucher)
                                .addComponent(jLabel10))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtgiatriapdung, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtmota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(cbhinhthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtgiatritoidavoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtgiatriapdung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(12, 12, 12))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Thời gian bắt đầu");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Thời gian kết thúc");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Giá trị voucher");

        txtgiatrivoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgiatrivoucherActionPerformed(evt);
            }
        });

        btnreset.setBackground(new java.awt.Color(204, 255, 255));
        btnreset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnreset.setText("RESET");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        btnadd.setBackground(new java.awt.Color(51, 255, 255));
        btnadd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnadd.setText("ADD");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btndelete.setBackground(new java.awt.Color(51, 255, 255));
        btndelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnupdate.setBackground(new java.awt.Color(51, 255, 255));
        btnupdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnupdate.setText("UPDATE");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_batdau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                    .addComponent(date_ketthuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnupdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnadd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(70, 70, 70)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnreset)
                                    .addComponent(btndelete)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtgiatrivoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(date_batdau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(date_ketthuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtgiatrivoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnreset)
                    .addComponent(btnadd))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndelete)
                    .addComponent(btnupdate))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("tìm theo tên: ");

        tblvoucher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã", "Tên ", "Hinh thuc", "Giá trị voucher", "Giá trị tối đa voucher ", "Giá trị áp dụng", "Số lượng", "Ngày bắt đầu ", "Ngày kết thúc", "Trạng thái"
            }
        ));
        tblvoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblvoucherMouseClicked(evt);
            }
        });
        tblvoucher.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tblvoucherComponentShown(evt);
            }
        });
        jScrollPane2.setViewportView(tblvoucher);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("hình thức giảm gía");

        cbhinhthuc1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cbhinhthuc1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbhinhthuc1ItemStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("tìm kiếm theo thời gian :");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("from");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("trạng thái");

        cbtrangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả" }));
        cbtrangthai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbtrangthaiItemStateChanged(evt);
            }
        });

        jButton2.setText("LỌC");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtsoluong1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsoluong1ActionPerformed(evt);
            }
        });

        txttimkiem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txttimkiemFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txttimkiemFocusLost(evt);
            }
        });
        txttimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimkiemActionPerformed(evt);
            }
        });
        txttimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txttimkiemKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("to");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbhinhthuc1, 0, 141, Short.MAX_VALUE)
                            .addComponent(txttimkiem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(date_batdau1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_ketthuc1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addGap(43, 43, 43)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(cbtrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(453, 453, 453)
                    .addComponent(txtsoluong1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(454, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txttimkiem)
                                        .addComponent(jLabel9))
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel13)
                                        .addComponent(cbtrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(date_batdau1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(cbhinhthuc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(date_ketthuc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(145, 145, 145)
                    .addComponent(txtsoluong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(145, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbhinhthucItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbhinhthucItemStateChanged
        // TODO add your handling code here:
        //        String selectedValue = cbhinhthuc.getSelectedItem().toString();
        //                if ("Tiền mặt".equals(selectedValue)) {
            //                    // Nếu giá trị là "Tiền mặt", khóa JTextField
            //                    txtgiatritoidavoucher.setEnabled(false);
            //                } else {
            //                    // Ngược lại, mở khóa JTextField
            //                    txtgiatritoidavoucher.setEnabled(true);
            //                }
        //
    }//GEN-LAST:event_cbhinhthucItemStateChanged

    private void cbhinhthucComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_cbhinhthucComponentHidden
        // TODO add your handling code here:
        //          String selectedValue = cbhinhthuc.getSelectedItem().toString();
        //            if ("tiền mặt".equals(selectedValue)) {
            //                    // Nếu giá trị là Option 1, khóa JTextField
            //                    txtgiatritoidavoucher.setEnabled(false);
            //                } else {
            //                    // Ngược lại, mở khóa JTextField
            //                    txtgiatritoidavoucher.setEnabled(true);
            //                }
    }//GEN-LAST:event_cbhinhthucComponentHidden

    private void cbhinhthucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbhinhthucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbhinhthucActionPerformed

    private void txtgiatritoidavoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgiatritoidavoucherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgiatritoidavoucherActionPerformed

    private void txtgiatriapdungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgiatriapdungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgiatriapdungActionPerformed

    private void txtsoluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsoluongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsoluongActionPerformed

    private void txtgiatrivoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgiatrivoucherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgiatrivoucherActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        this.Reset();
    }//GEN-LAST:event_btnresetActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        if (this.vadidate()) {
            int chose = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm phiếu giảm giá không?", "Phiếu giảm giá", JOptionPane.YES_NO_OPTION);
            if (chose == JOptionPane.YES_OPTION) {
                Voucher nv = this.readRorm();

                index = tblvoucher.getSelectedRow();
                int soLuong = Integer.parseInt(txtsoluong.getText());
                if (ser.getID(nv.getMa()) != null) {
                    JOptionPane.showMessageDialog(this, "Mã đã tồn tại");
                } else {
                    if (ser.add(nv) > 0) {
                        JOptionPane.showMessageDialog(this, "Thêm thành công");
                        this.filltable(ser.getAll1());

                    } else {
                        JOptionPane.showMessageDialog(this, "thêm that bai");
                    }
                }
                //                for (int i = 0; i < soLuong; i++) {
                    //                    GenMaTuDong_Ninh genMa = new GenMaTuDong_Ninh() {
                        //                        @Override
                        //                        public String maTuDong() {
                            //                            int gen = new Random().nextInt(1000000);
                            //                            return "VCKH" + gen;
                            //                        }
                        //                    };
                    //                    String ma = genMa.maTuDong();
                    //                    String mavc = tblVoicherAll.getValueAt(index, 1).toString();
                    //                    String id_Voucher = getid.getIDVoucher(mavc);
                    //                    java.util.Date ngayTao = new Date();
                    //                    int trangthai = 1;
                    //                    int xoatt = 0;
                    //                    String id_NguoiTao = null;
                    //                    String id_KhachHang = null;
                    //                    vckh = new Voucher_KhachHang(ma, trangthai, id_Voucher, id_KhachHang, id_NguoiTao, ngayTao, xoatt);
                    //                    servicevckh.insert(vckh);
                    //                }
                //
                //                countDB();
                //                this.fillTable(service.loadData(1));
                //                if (count % 5 == 0) {
                    //                    soTrang = count / 5;
                    //                } else {
                    //                    soTrang = count / 5 + 1;
                    //                }
                //
                //                lblSoTrang.setText("1/" + soTrang);
                //                lblTrang.setText("1");
                //            }
            //        }

        //                voucher x = this.readRorm();
        //                if (ser.add(x) > 0) {
            //                    JOptionPane.showMessageDialog(this, "them thanh  cong");
            //                    this.filltable(ser.getAll1());
            //                } else {
            //                    JOptionPane.showMessageDialog(this, "them that bai");
            //
            //                }
        }
        }
    }//GEN-LAST:event_btnaddActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một phiếu giảm giá để xóa");
            return;
        }
        int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa phiếu giảm giá không?", "Xóa", JOptionPane.YES_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            Voucher nv = this.readRorm();
            index = tblvoucher.getSelectedRow();
            String ma = tblvoucher.getValueAt(index, 1).toString();

            //                    JOptionPane.showMessageDialog(this, id);
            if (ser.delete(nv, ma) > 0) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");

                this.filltable(ser.getAll1());

            } else {
                JOptionPane.showMessageDialog(this, "Xóa Thất Bại");

                this.filltable(ser.getAll1());
            }
        }
        //        index = tbltatca.getSelectedRow();
        //        if (index == -1) {
            //            JOptionPane.showMessageDialog(this, "chọn dòng ");
            //        } else {
            //
            //            String ma = tbltatca.getValueAt(index, 1).toString();
            //            if (ser.delete(ma) > 0) {
                //                JOptionPane.showMessageDialog(this, "xoa thánh cong");
                //                this.filltable(ser.getAll1());
                //            } else {
                //                JOptionPane.showMessageDialog(this, "xoa k thành công");
                //            }
            //        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một phiếu giảm giá để sửa");
            return;
        }
        if (this.vadidate()) {
            int chose = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa phiếu giảm giá không?", "Phiếu giảm giá", JOptionPane.YES_NO_OPTION);
            if (chose == JOptionPane.YES_OPTION) {
                Voucher nv = this.readRorm();
                //Voucher_KhachHang vckh = new Voucher_KhachHang();
                // int soLuong = Integer.parseInt(txtsoluong2.getText());
                index = tblvoucher.getSelectedRow();

                String ma = tblvoucher.getValueAt((index), 1).toString();
                //  String id = getid.getIDVoucher(ma);
                //                for (int i = 0; i < soLuong; i++) {
                    //                    GenMaTuDong_Ninh genMa = new GenMaTuDong_Ninh() {
                        //                        @Override
                        //                        public String maTuDong() {
                            //                            int gen = new Random().nextInt(1000000);
                            //                            return "VCKH" + gen;
                            //                        }
                        //                    };
                    //                    String masv = genMa.maTuDong();
                    //                    String mavc = tblVoicherAll.getValueAt(index, 1).toString();
                    //                    String id_Voucher = getid.getIDVoucher(mavc);
                    //                    java.util.Date ngayTao = new Date();
                    //                    int trangthai = 1;
                    //                    int xoatt = 0;
                    //                    String id_NguoiTao = null;
                    //                    String id_KhachHang = null;
                    //                    vckh.setMa(masv);
                    //                    vckh.setTrangthai(trangthai);
                    //                    vckh.setId_Voucher(id_Voucher);
                    //                    vckh.setId_KhachHang(id_KhachHang);
                    //                    vckh.setId_NguoiTao(id_NguoiTao);
                    //                    vckh.setNgayTao(ngayTao);
                    //                    vckh.setXoaTT(xoatt);
                    //                    vckh = new Voucher_KhachHang(ma, trangthai, id_Voucher, id_KhachHang, id_NguoiTao, ngayTao, xoatt);
                    //                    servicevckh.update(vckh, id);
                    //                }
                if (ser.update(nv, ma) > 0) {
                    JOptionPane.showMessageDialog(this, "Sửa thành công");
                    this.filltable(ser.getAll1());
                } else {
                    JOptionPane.showMessageDialog(this, "Sửa thất bại");
                }
            }

        }

        //        index = tbltatca.getSelectedRow();
        //        if(index < 0 ){
            //            JOptionPane.showMessageDialog(this, "moi nhap dong xoa");
            //        }else{
            //
            //            voucher x = this.readRorm();
            //            String masv = tbltatca.getValueAt(index, 1).toString();
            //            if (ser.update(masv, x)>0) {
                //                JOptionPane.showMessageDialog(this, "update thanh  cong");
                //                this.filltable(ser.getAll());
                //            }else{
                //                JOptionPane.showMessageDialog(this, "k thành công");
                //            }
            //
            //        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void tblvoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblvoucherMouseClicked
        // TODO add your handling code here:
        index = tblvoucher.getSelectedRow();
        this.showData(index);
    }//GEN-LAST:event_tblvoucherMouseClicked

    private void tblvoucherComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tblvoucherComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_tblvoucherComponentShown

    private void cbhinhthuc1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbhinhthuc1ItemStateChanged
        // TODO add your handling code here:
        String ten;
        if (cbhinhthuc1.getSelectedItem().equals("Tất cả")) {
            ten = null;
            filltable(ser.getAll1());
        } else {
            ten = cbhinhthuc1.getSelectedItem().toString();
            //            ten = "%" + ten + "%";
        }
        if (ser.findcbb(ten).size() > 0) {//co sinh vien tim duoc
            this.filltable(ser.findcbb(ten));
        }
    }//GEN-LAST:event_cbhinhthuc1ItemStateChanged

    private void cbtrangthaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbtrangthaiItemStateChanged
        // TODO add your handling code here:
        int trangthai;
        if (cbtrangthai.getSelectedItem().equals("Tất cả")) {
            filltable(ser.getAll1());
            trangthai = 0;

        } else {
            if (cbtrangthai.getSelectedItem().equals("Sắp diễn ra")) {
                trangthai = 1;
                this.filltable(ser.findcbbtt(trangthai));
            } else if (cbtrangthai.getSelectedItem().equals("Đang diễn ra")) {
                trangthai = 2;
                this.filltable(ser.findcbbtt(trangthai));
            } else if (cbtrangthai.getSelectedItem().equals("Đã kết thúc")) {
                trangthai = 3;
                this.filltable(ser.findcbbtt(trangthai));
            }
        }
    }//GEN-LAST:event_cbtrangthaiItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //java.util.Date startDate = date_batdau1.getDate();
        //java.util.Date endDate = date_ketthuc1.getDate();
        //
        //if (startDate == null || endDate == null) {
            //    JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ ngày và giờ");
            //    return;
            //} else {
            //    // Kiểm tra xem startDate và endDate có giá trị không
            //    if (startDate.getTime() == null || endDate.getTime() == null) {
                //        JOptionPane.showMessageDialog(this, "Ngày không hợp lệ");
                //        return;
                //    }
            //
            //    List<voucher> list = ser.find(date_batdau1, date_ketthuc1);
            //    filltable(list);
            //}
        //

        //JDateChooser dateChooserBatDau = date_batdau1;
        //JDateChooser dateChooserKetThuc = date_ketthuc1;
        java.util.Date startDate = date_batdau1.getDate();
        java.util.Date endDate = date_ketthuc1.getDate();

        if (startDate == null || endDate == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ ngày và giờ");
            return;
        } else {
            List<Voucher> list = ser.find(date_batdau1, date_ketthuc1);
            JOptionPane.showMessageDialog(this, "đung");
            filltable(list);
        }

        //        java.util.Date startDate = date_batdau1.getDate();
        //        java.util.Date endDate = date_ketthuc1.getDate();
        //
        //        if (date_batdau1.getDateFormatString().toString().trim().isEmpty() || date_ketthuc1.getDateFormatString().toString().trim().isEmpty()) {
            //            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ ngày và giờ");
            //            return;
            //        } else {
            //            List<voucher> list = ser.find(date_batdau1, date_ketthuc1);
            //            filltable(list);
            //        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtsoluong1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsoluong1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsoluong1ActionPerformed

    private void txttimkiemFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttimkiemFocusGained
        // TODO add your handling code here:
        if (txttimkiem.getText().equals("Tim kiem tat ca")) {
            txttimkiem.setText(null);
            txttimkiem.requestFocus();
            RemovePleacehoderStyle(txttimkiem);
        }
    }//GEN-LAST:event_txttimkiemFocusGained

    private void txttimkiemFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txttimkiemFocusLost
        // TODO add your handling code here:
        if (txttimkiem.getText().length() == 0) {
            AddPleacehoderStyle(txttimkiem);
            txttimkiem.setText("Tìm kiếm tất cả");

        }
    }//GEN-LAST:event_txttimkiemFocusLost

    private void txttimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimkiemActionPerformed

    private void txttimkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttimkiemKeyReleased
        // TODO add your handling code here:
        String trs = txttimkiem.getText();
        search(trs);
    }//GEN-LAST:event_txttimkiemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox<String> cbhinhthuc;
    private javax.swing.JComboBox<String> cbhinhthuc1;
    private javax.swing.JComboBox<String> cbtrangthai;
    private com.toedter.calendar.JDateChooser date_batdau;
    private com.toedter.calendar.JDateChooser date_batdau1;
    private com.toedter.calendar.JDateChooser date_ketthuc;
    private com.toedter.calendar.JDateChooser date_ketthuc1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblvoucher;
    private javax.swing.JTextField txtgiatriapdung;
    private javax.swing.JTextField txtgiatritoidavoucher;
    private javax.swing.JTextField txtgiatrivoucher;
    private javax.swing.JTextField txtma;
    private javax.swing.JTextField txtmota;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txtsoluong1;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
