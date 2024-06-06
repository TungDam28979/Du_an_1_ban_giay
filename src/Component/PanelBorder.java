
package utility;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
//Thiết lập border JPanel làm giao diện ( Chứa tất cả ) = Menu  + Giao diện chức năng.
public class PanelBorder extends javax.swing.JPanel {

    public PanelBorder() {
        initComponents();
        setOpaque(false);
        setBackground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    @Override
    public void paintComponents(Graphics grphcs) {
        Graphics2D g2 =  (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground()); //Đặt mày cho g2 bằng background hiện tại.
        //Vẽ 1 hình chữ nhật đc làm tròn ở góc với chiều dài và chiểu rộng là getWidth() , getHeight() và bán kính của góc đc làm tròn là 15.
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        super.paintComponents(grphcs);//Lớp cha vẽ lại thành phần bên trog lớp con. 
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
