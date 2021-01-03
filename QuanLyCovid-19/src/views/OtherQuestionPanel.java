/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author levietdung
 */
public class OtherQuestionPanel extends javax.swing.JPanel {
    
    private ArrayList<JPanel> listBtn = new ArrayList<JPanel>();
    private ArrayList<JLabel> listLabel = new ArrayList<JLabel>();
    private int isChoosing = -1;

    public void setIsChoosing(int isChoosing) {
        this.isChoosing = isChoosing;
    }
    
    /**
     * Creates new form covid19DiseasePanel
     */
    public OtherQuestionPanel() {
        initComponents();
    }

    public JPanel getjPanel5() {
        return jPanel5;
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
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(0, 0, 255));

        jPanel4.setBackground(new java.awt.Color(51, 102, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseClickedOnBtn1(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mouseEnteredBtn1(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mouseExitedBtn1(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Gửi câu hỏi");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(51, 102, 255));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseClickedOnBtn2(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                mouseEnteredBtn2(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                mouseExitedBtn2(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setText("Hộp thư");
        listBtn.add(jPanel4);
        listBtn.add(jPanel6);
        listLabel.add(jLabel3);
        listLabel.add(jLabel4);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(227, 240, 245));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 677, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 481, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void mouseClickedOnBtn1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseClickedOnBtn1
        if (isChoosing != -1){
            listBtn.get(isChoosing).setBackground(new Color(51,102,255));
            listLabel.get(isChoosing).setForeground(new Color(204,204,204));
        }
        jPanel4.setBackground(new Color(0,0,204));
        jLabel3.setForeground(new Color(255,255,255));
        isChoosing = 0;
        jPanel5.removeAll();
        SendQuestionPanel panel = new SendQuestionPanel();
        jPanel5.add(panel);
        jPanel5.validate();
        jPanel5.repaint();
    }//GEN-LAST:event_mouseClickedOnBtn1

    private void mouseEnteredBtn1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseEnteredBtn1
        jPanel4.setBackground(new Color(0,0,204));
        jLabel3.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_mouseEnteredBtn1

    private void mouseExitedBtn1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseExitedBtn1
        if (isChoosing != 0){
            jPanel4.setBackground(new Color(51,102,255));
            jLabel3.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_mouseExitedBtn1

    private void mouseClickedOnBtn2(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseClickedOnBtn2
        if (isChoosing != -1){
            listBtn.get(isChoosing).setBackground(new Color(51,102,255));
            listLabel.get(isChoosing).setForeground(new Color(204,204,204));
        }
        jPanel6.setBackground(new Color(0,0,204));
        jLabel4.setForeground(new Color(255,255,255));
        isChoosing = 1;
        jPanel5.removeAll();
        InboxPanel panel = new InboxPanel(this);
        jPanel5.add(panel);
        jPanel5.validate();
        jPanel5.repaint();
    }//GEN-LAST:event_mouseClickedOnBtn2

    private void mouseEnteredBtn2(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseEnteredBtn2
        jPanel6.setBackground(new Color(0,0,204));
        jLabel4.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_mouseEnteredBtn2

    private void mouseExitedBtn2(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseExitedBtn2
        if (isChoosing != 1){
            jPanel6.setBackground(new Color(51,102,255));
            jLabel4.setForeground(new Color(204,204,204));
        }
    }//GEN-LAST:event_mouseExitedBtn2


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}
