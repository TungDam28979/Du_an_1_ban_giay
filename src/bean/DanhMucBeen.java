package bean;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class DanhMucBeen {
//Bắt sự kiện khi nhắn vào mỗi Label.    

    private String kind; //Tên giao diện JPanel.
    private JPanel jpn; //Giao diện JPanel
    private JLabel jlb; //Label chứa tên giao diện

    public DanhMucBeen(String kind, JPanel jpn, JLabel jlb) {
        this.kind = kind;
        this.jpn = jpn;
        this.jlb = jlb;
    }

    public DanhMucBeen() {
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public JPanel getJpn() {
        return jpn;
    }

    public void setJpn(JPanel jpn) {
        this.jpn = jpn;
    }

    public JLabel getJlb() {
        return jlb;
    }

    public void setJlb(JLabel jlb) {
        this.jlb = jlb;
    }

}
