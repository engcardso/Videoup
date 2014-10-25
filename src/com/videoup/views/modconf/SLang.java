/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videoup.views.modconf;

import com.videoup.entities.VideoupLangs;
import com.videoup.views.modmovs.MvGmCopy;
import com.videoup.views.utils.ImagePanel;
import com.videoup.views.utils.ViewFicha;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Pedro
 */
public class SLang extends javax.swing.JPanel {

    private VideoupLangs ent;
    private JPanel parent;
    private boolean selectable;
    private boolean selected;
    private boolean asLng;
    
    /**
     * Creates new form SLang
     */
    public SLang(VideoupLangs ent, boolean sel, JPanel parent, boolean asLng, boolean del){
        this.parent=parent;
        this.ent=ent;
        this.asLng=asLng;
        selectable=sel;
        selected=false;
        initComponents();
        if(parent instanceof ViewFicha){
            btnDel.setToolTipText("Eliminar idioma");
        }else if(parent instanceof MvGmCopy){
            btnDel.setToolTipText("Quitar idioma");
        }
        showData(del);
    }
    
    private void showData(boolean del){
        ImagePanel img;
        InputStream inpstr=new ByteArrayInputStream(ent.getImg());
        BufferedImage bfImg;
        try {
            bfImg=ImageIO.read(inpstr);
        }catch (IOException ex) {
            bfImg=null;
            add(new javax.swing.JLabel("Error!"),BorderLayout.WEST);
        }
        if(bfImg!=null){
            img=new ImagePanel(bfImg);
            add(img,BorderLayout.WEST);
        }
        lblLang.setText(" "+ent.getName());
        if(!del){
            remove(btnDel);
        }
    }
    
    public boolean isSelected(){
        return selected;
    }
    
    public VideoupLangs getEntity(){
        return ent;
    }
    
    private void changeSelected(){
        if(selectable){
            selected=!selected;
            if(selected){
                setBorder(new javax.swing.border.LineBorder(new java.awt.Color(34, 33, 34), 2, true));
                setBackground(new Color(198,198,199));
            }else{
                setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
                setBackground(new Color(240,240,240));
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLang = new javax.swing.JLabel();
        btnDel = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        lblLang.setText("Lang");
        lblLang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLangMouseClicked(evt);
            }
        });
        add(lblLang, java.awt.BorderLayout.CENTER);

        btnDel.setText("X");
        btnDel.setToolTipText("Eliminar este idioma");
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });
        add(btnDel, java.awt.BorderLayout.LINE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        if(parent instanceof ViewFicha){
            ((ViewFicha)parent).deleteLang(ent);
        }else if(parent instanceof MvGmCopy){
            ((MvGmCopy)parent).removeLang(ent,asLng);
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void lblLangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLangMouseClicked
        changeSelected();
    }//GEN-LAST:event_lblLangMouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        changeSelected();
    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDel;
    private javax.swing.JLabel lblLang;
    // End of variables declaration//GEN-END:variables
}