/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package views;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.HoaDonKH;
import model.KhachHang;
import service.HoaDonService;
import service.KhachHangService;

/**
 *
 * @author Admin
 */
public class JPKhachHang extends javax.swing.JPanel {

    private DefaultTableModel dtm = new DefaultTableModel();
    private KhachHangService khs = new KhachHangService();
    private HoaDonService hds = new HoaDonService();
    private HoaDonKH hd = new HoaDonKH();
    private KhachHang kh = new KhachHang();
    private int row = -1;
    
    
    public JPKhachHang() {
        initComponents();
        fillTable(khs.getAll());
        loadTableHD(hds.getAll());
    }
    
    


    void fillTable(List<KhachHang> listkh) {
        dtm = (DefaultTableModel) tbQLKH.getModel();
        dtm.setRowCount(0);
        listkh = khs.getAll();
        int i = 1;
        for (KhachHang kh : listkh) {
            Object[] row = {
                i++,
                kh.getMaKH(),
                kh.getName(),
                kh.isGender() ? "Nữ" : "Nam",
                kh.getPhone(),
                kh.getEmail(),
                kh.getAddress()
            };
            dtm.addRow(row);
        }
    }

    void fillTableHD(int idKH) {
        dtm = (DefaultTableModel) tbDSHD.getModel();
        dtm.setRowCount(0);
        List<HoaDonKH> listhd = hds.getHD(idKH);
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int i = 1;
        for (HoaDonKH hd : listhd) {
            Object[] row = {
                i++,
                hd.getAddress(),
                formatter.format(hd.getThanhTien()),
                sdf.format(hd.getNgayNNH())
            };
            dtm.addRow(row);
        }
    }

    void loadTableHD(List<HoaDonKH> listhd) {
        dtm = (DefaultTableModel) tbDSHD.getModel();
        dtm.setRowCount(0);
        listhd = hds.getAll();
        DecimalFormat formatter = new DecimalFormat("###,###,###");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int i = 1;
        if (listhd != null) {
            for (HoaDonKH hd : listhd) {
                Object[] row = {
                    i++,
                    hd.getAddress(),
                    formatter.format(hd.getThanhTien()),
                    sdf.format(hd.getNgayNNH() //Ngày nhận hàng.
                    )};
                dtm.addRow(row);
            }
        }
    }

    void clearForm() {
        txtIDKH.setText("");
        txtAddress.setText("");
        txtEmail.setText("");
        txtName.setText("");
        txtPhone.setText("");
    }

    void showData(int index) {
        KhachHang kh = khs.getAll().get(index);
        txtIDKH.setText(kh.getMaKH());
        txtName.setText(kh.getName());
        txtPhone.setText(kh.getPhone());
        txtEmail.setText(kh.getEmail());
        txtAddress.setText(kh.getAddress());
        rdoMale.setSelected(!kh.isGender());
        rdoFemale.setSelected(kh.isGender());
    }

    KhachHang readForm() {
        String name = txtName.getText().trim();
        String id = txtIDKH.getText().trim();
        String email = txtEmail.getText().trim();
        String address = txtAddress.getText().trim();
        String phone = txtPhone.getText().trim();
        Boolean gender = rdoFemale.isSelected();
        return new KhachHang(id, name, gender, phone, email, address);
    }

    void searchID(String sdt) {
        RowFilter rf = null;
        dtm = (DefaultTableModel) tbQLKH.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(dtm);
        tbQLKH.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(sdt, 4));
    }

    void searchAddress(String address) {
        RowFilter rf = null;
        dtm = (DefaultTableModel) tbQLKH.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(dtm);
        tbQLKH.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(address, 6));
    }

    void searchAddressHD(String address) {
        RowFilter rf = null;
        dtm = (DefaultTableModel) tbDSHD.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(dtm);
        tbDSHD.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(address, 1));
    }

    void searchNG(String dateG) {
        RowFilter rf = null;
        dtm = (DefaultTableModel) tbDSHD.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(dtm);
        tbDSHD.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(dateG, 3));
    }

    void searchNN(String dateG) {
        RowFilter rf = null;
        dtm = (DefaultTableModel) tbDSHD.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(dtm);
        tbDSHD.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(dateG, 3));
    }

    String getSelected() {
        if (rdoSearchFemale.isSelected()) {
            return "Nữ";
        } else if (rdoSearchMale.isSelected()) {
            return "Nam";
        } else {
            return "Nam";
        }
    }

    void searchGender(String gender) {
        RowFilter rf = null;
        dtm = (DefaultTableModel) tbQLKH.getModel();
        TableRowSorter<DefaultTableModel> trs = new TableRowSorter<DefaultTableModel>(dtm);
        tbQLKH.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter(gender, 3));
    }

    boolean testData() {
        if (txtIDKH.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không bỏ trống mã khách hàng !");
            return false;
        } else if (!txtIDKH.getText().matches("^([a-zA-Z]{2})+([0-9]{3})$")) {
            JOptionPane.showMessageDialog(this, "Mã nhập vào quá dài, không đúng định dạng hoặc chứa kí tự đặc biệt !");
            return false;
        }
        if (txtEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không bỏ trống email khách hàng !");
            return false;
        } else if (!txtEmail.getText().matches("^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$")) {
            JOptionPane.showMessageDialog(this, "Nhập chưa đúng định dạng email !");
            return false;
        }
        if (txtName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không bỏ trống họ tên khách hàng !");
            return false;
        } else if (!txtName.getText().matches("[a-zA-Z ]+$")) {
            JOptionPane.showMessageDialog(this, "Không đúng định dạng tên !");
            return false;
        }
        if (txtAddress.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không bỏ trống địa chỉ của khách hàng !");
            return false;
        } else if (!txtAddress.getText().matches("^[a-zA-Z0-9 ]*$")) {
            JOptionPane.showMessageDialog(this, "Địa chỉ nhập vào chứa kí tự đặc biệt, vui lòng nhập lại !");
            return false;
        }
        if (txtPhone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không bỏ trống số điện thoại khách hàng !");
            return false;
        } else if (!txtPhone.getText().matches("(84|0[3|5|7|8|9])+([0-9]{8})")) {
            JOptionPane.showMessageDialog(this, "Nhập chưa đúng định dạng số điện thoại !");
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rdoFemale = new javax.swing.JRadioButton();
        rdoMale = new javax.swing.JRadioButton();
        txtAddress = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtIDKH = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        rdoSearchFemale = new javax.swing.JRadioButton();
        txtSearchAddress = new javax.swing.JTextField();
        txtSearchID = new javax.swing.JTextField();
        rdoSearchMale = new javax.swing.JRadioButton();
        tabs = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDSHD = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbQLKH = new javax.swing.JTable();
        btnNew = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtSearchDCHD = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtSearchNNH = new javax.swing.JTextField();

        jPanel1.setPreferredSize(new java.awt.Dimension(1050, 735));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ KHÁCH HÀNG");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Họ tên");

        txtName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("SĐT");

        txtPhone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Email");

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Giới tính");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Địa chỉ");

        rdoFemale.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdoFemale.setText("Nữ");

        rdoMale.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdoMale.setText("Nam");

        txtAddress.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Mã KH");

        txtIDKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(32, 32, 32)
                        .addComponent(rdoMale)
                        .addGap(37, 37, 37)
                        .addComponent(rdoFemale)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(47, 47, 47)
                                .addComponent(txtName))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(46, 46, 46)
                                .addComponent(txtIDKH))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel10))
                                .addGap(46, 46, 46)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail)
                                    .addComponent(txtAddress))))
                        .addGap(58, 58, 58))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel5))
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(rdoMale))
                    .addComponent(rdoFemale))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm khách hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("Số ĐT");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("Địa chỉ");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Giới tính");

        rdoSearchFemale.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdoSearchFemale.setText("Nữ");
        rdoSearchFemale.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdoSearchFemaleItemStateChanged(evt);
            }
        });

        txtSearchAddress.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSearchAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchAddressKeyReleased(evt);
            }
        });

        txtSearchID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSearchID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchIDKeyReleased(evt);
            }
        });

        rdoSearchMale.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        rdoSearchMale.setText("Nam");
        rdoSearchMale.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdoSearchMaleItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel11))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(rdoSearchMale)
                                .addGap(61, 61, 61)
                                .addComponent(rdoSearchFemale))
                            .addComponent(txtSearchAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                            .addComponent(txtSearchID))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtSearchID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtSearchAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(rdoSearchMale)
                    .addComponent(rdoSearchFemale))
                .addGap(60, 60, 60)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        tbDSHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Địa chỉ", "Thành tiền", "Ngày nhận hàng"
            }
        ));
        jScrollPane2.setViewportView(tbDSHD);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabs.addTab("Danh sách hoá đơn đã mua", jPanel6);

        tbQLKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã KH", "Họ và tên", "Giới tính", "Số điện thoại", "Email", "Địa chỉ"
            }
        )
        {
            public boolean isCellEditable(int row, int column){
                return false;
            }
        }

    );
    tbQLKH.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            tbQLKHMouseClicked(evt);
        }
    });
    jScrollPane1.setViewportView(tbQLKH);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addGap(209, 209, 209)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(134, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 24, Short.MAX_VALUE))
    );

    tabs.addTab("Thông tin khách hàng", jPanel2);

    btnNew.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    btnNew.setText("Làm mới");
    btnNew.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnNewActionPerformed(evt);
        }
    });

    btnAdd.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    btnAdd.setText("Thêm khách hàng");
    btnAdd.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnAddActionPerformed(evt);
        }
    });

    btnUpdate.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    btnUpdate.setText("Chỉnh sửa");
    btnUpdate.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnUpdateActionPerformed(evt);
        }
    });

    jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm hoá đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

    jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

    jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel18.setText("Địa chỉ");

    txtSearchDCHD.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    txtSearchDCHD.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txtSearchDCHDKeyReleased(evt);
        }
    });

    jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    jLabel20.setText("Ngày nhận hàng");

    txtSearchNNH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
    txtSearchNNH.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            txtSearchNNHKeyReleased(evt);
        }
    });

    javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
    jPanel5.setLayout(jPanel5Layout);
    jPanel5Layout.setHorizontalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel5Layout.createSequentialGroup()
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(55, 55, 55)
                    .addComponent(jLabel12))
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtSearchNNH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                        .addComponent(txtSearchDCHD, javax.swing.GroupLayout.Alignment.LEADING))))
            .addContainerGap(46, Short.MAX_VALUE))
    );
    jPanel5Layout.setVerticalGroup(
        jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel5Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel18)
                .addComponent(txtSearchDCHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel20)
                .addComponent(txtSearchNNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(100, 100, 100)
            .addComponent(jLabel12)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(246, 246, 246)
                    .addComponent(btnNew)
                    .addGap(97, 97, 97)
                    .addComponent(btnAdd)
                    .addGap(94, 94, 94)
                    .addComponent(btnUpdate))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(383, 383, 383)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnNew)
                .addComponent(btnAdd)
                .addComponent(btnUpdate))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(242, 242, 242))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 61, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
    );
    }// </editor-fold>//GEN-END:initComponents

    private void rdoSearchFemaleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdoSearchFemaleItemStateChanged
        String gender = getSelected();
        searchGender(gender);
    }//GEN-LAST:event_rdoSearchFemaleItemStateChanged

    private void txtSearchAddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchAddressKeyReleased
        searchAddress(txtSearchAddress.getText());
    }//GEN-LAST:event_txtSearchAddressKeyReleased

    private void txtSearchIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchIDKeyReleased
        searchID(txtSearchID.getText());
    }//GEN-LAST:event_txtSearchIDKeyReleased

    private void rdoSearchMaleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdoSearchMaleItemStateChanged
        String gender = getSelected();
        searchGender(gender);
    }//GEN-LAST:event_rdoSearchMaleItemStateChanged

    private void tbQLKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbQLKHMouseClicked
        int rowSelected = this.tbQLKH.getSelectedRow();
        if (dtm.getRowCount() > 0) {
            if (evt.getClickCount() == 1) {
                showData(rowSelected);
            } else if (evt.getClickCount() == 2) {
                int idKH = Integer.parseInt(this.tbQLKH.getValueAt(rowSelected, 0).toString());
                fillTableHD(idKH);
                tabs.setSelectedIndex(1);
            }
        }
    }//GEN-LAST:event_tbQLKHMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clearForm();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int choose = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm thông tin khách hàng ?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (choose == JOptionPane.NO_OPTION) {
            return;
        }
        if (testData()) {
            KhachHang kh = this.readForm();
            if (khs.getKH(kh.getMaKH()) != null) {
                JOptionPane.showMessageDialog(this, "Thêm không thành công do trùng mã !");
            } else {
                if (khs.insertKH(kh) > 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công khách hàng mới !");
                    fillTable(khs.getAll());
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm không thành công !");
                }
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        KhachHang kh = this.readForm();
        row = tbQLKH.getSelectedRow();
        int sttDuocChon = tbQLKH.getSelectedRow();
        if (sttDuocChon == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn bản ghi nào !");
            return;
        }
        String idKH = tbQLKH.getValueAt(row, 1).toString();
        int choose = JOptionPane.showConfirmDialog(this, "Bạn có muốn chỉnh sửa thông tin khách hàng ?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (choose == JOptionPane.NO_OPTION) {
            return;
        }
        if (testData()) {
            if (khs.updateKH(kh, idKH) > 0) {
                JOptionPane.showMessageDialog(this, "Chỉnh sửa thành công thông tin khách hàng !");
                fillTable(khs.getAll());
            } else {
                JOptionPane.showMessageDialog(this, "Chỉnh sửa thông tin không thành công !");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtSearchDCHDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchDCHDKeyReleased
        searchAddressHD(txtSearchDCHD.getText());
    }//GEN-LAST:event_txtSearchDCHDKeyReleased

    private void txtSearchNNHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchNNHKeyReleased
        searchNN(txtSearchNNH.getText());
    }//GEN-LAST:event_txtSearchNNHKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JRadioButton rdoSearchFemale;
    private javax.swing.JRadioButton rdoSearchMale;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tbDSHD;
    private javax.swing.JTable tbQLKH;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIDKH;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtSearchAddress;
    private javax.swing.JTextField txtSearchDCHD;
    private javax.swing.JTextField txtSearchID;
    private javax.swing.JTextField txtSearchNNH;
    // End of variables declaration//GEN-END:variables
}
