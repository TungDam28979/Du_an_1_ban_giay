/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
   
import bean.DanhMucBeen;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import views.JBanHang;
import views.JPHoaDon;
import views.JPKhachHang;
import views.JPNhanVien;
import views.JPSanPham;
import views.JPThongKe;
import views.JPVoucher;
import views.Login;
import views.Main;
/**
 *
 * @author Tran Viet Vuong
 */
public class ChuyenManHinhController {
        
    private JPanel root; //Tham chiếu đến Mainpanel chính của ứng dụng.
    private String kindSelected = ""; //Tên của jpnView đc chọn.

    private List<DanhMucBeen> listItem = null;

    //Tham số = Màn hình jpnView sẽ đc chuyển tới.
    public ChuyenManHinhController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }
    
    //Khi vào ứng dụng thì mặc định là TrangChinhPanel.    
    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "Bán Hàng";
        jpnItem.setBackground(new Color(96, 100, 191));
        jlbItem.setBackground(new Color(96, 100, 191));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new JBanHang()); //Thiết lập lại giao diện khởi đầu
        root.validate();
        root.repaint();
    }
        
    //Thực hiện setEvent cho các laybel.
    public void setEvent(List<DanhMucBeen> listItem) {
        this.listItem = listItem;
        for (DanhMucBeen item : listItem) {
            //Gắn sự kiện cho nhãnh JLabel cho từng mục của DanhMucBeen <=> các JLabel đề có sự kiện này.
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
            item.getJpn().setBackground(new Color(0, 0, 0, 0));
            item.getJlb().setBackground(new Color(0, 0, 0, 0));
            //Tạo 1 đối tượng của lớp LabelEvent với các tham số được truyền vào của danh mục đag xem xét.
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node; //Giao diện JPanel sẽ đc hiển thị lên.
        private String kind; //Tên của Jpanel chọn.
        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override //Chạy sự kiện này khi chuột click vào 1 Jlabel.
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "Bán Hàng":
                    node = new JBanHang();
                    break;
                case "Sản Phẩm":
                    node = new JPSanPham();
                    break;
                case "Hóa Đơn":
                    node = new JPHoaDon();
                    break;
                case "Nhân Viên":
                    node = new JPNhanVien();
                    break;
                case "Thống Kê":
                    node = new JPThongKe();
                    break;
                case "Voucher":
                    node = new JPVoucher();
                    break;
                case "Khách Hàng":
                    node = new JPKhachHang();
                    break;
//                case "Đăng Xuất":
//                    node = new Login();
//                    node = new Main();
//                    this.dispose();
//                    break;
                default:
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackground(kind);
        }

        @Override //Gọi khi chuột đc nhấn xuống. ( Chưa cần thiết ) 
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
//            jpnItem.setBackground(new Color(255, 0, 0));
//            jlbItem.setBackground(new Color(255, 0, 0));
        }

        @Override //Gọi khi có sự kiện chuột đc giải phóng.Là khi click vào chuột và thả ra là nó đc giải phóng.
        public void mouseReleased(MouseEvent e) {
        }

        @Override //đc gọi khi con trỏ chuột đi vào vùng thành phần.
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(96, 100, 191));
            jpnItem.setOpaque(true); //Đặt cho nó ko trong suốt. ( mặc định )  
            jlbItem.setBackground(new Color(96, 100, 191));
        }

        //Đc gọi khi con trỏ chuột rời khỏi vùng thành phần.
        //Nếu nó ko phải là tên giao diện đc chọn. Thì màu của nó sẽ trở lại ban đầu.
        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(0, 0, 0, 0));
                jpnItem.setOpaque(false); //Đặt lại cho nó  trong suốt.
                jlbItem.setBackground(new Color(0, 0, 0, 0));
//                jpnItem.setBackground(null);
//                jlbItem.setBackground(null);
            }
        }
    }

    //Dùng để khi click vào 1 chức năng trong menu thì chức năng khác đc chọn bị bỏ chọn
    private void setChangeBackground(String kind) {
        for (DanhMucBeen item : listItem) {
            if (item.getKind().equalsIgnoreCase(kind)) {
                //Nếu là đag đc chọn thì sẽ có màu như này.
                item.getJpn().setBackground(new Color(96, 100, 191));
                item.getJlb().setBackground(new Color(96, 100, 191));
            } else {
                //Xem sau khi click xog nếu ko phải cái ko phải là cái chọn thí nó sẽ là màu dưới này.

                item.getJpn().setBackground(new Color(0, 0, 0, 0));
                item.getJpn().setOpaque(false); //Đặt cho nó trong suốt
                item.getJlb().setBackground(new Color(0, 0, 0, 0));
            }
        }
    }
}
