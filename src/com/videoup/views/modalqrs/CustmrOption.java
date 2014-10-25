/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videoup.views.modalqrs;

import com.videoup.entities.VideoupAutrz;
import com.videoup.entities.VideoupCustomers;
import com.videoup.views.utils.Utils;
import com.videoup.views.utils.ViewFicha;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class CustmrOption extends javax.swing.JPanel {

    private VideoupCustomers cst;
    private ViewFicha ficha;
    
    /**
     * Creates new form CustmrOption
     */
    public CustmrOption(VideoupCustomers cst, ViewFicha ficha) {
        this.cst=cst;
        this.ficha=ficha;
        initComponents();
        showData();
    }
    
    private void showData(){
        List<VideoupAutrz> pautz=cst.getVideoupAutrzList();
        List<Component> oPers;
        btnSet.setText("["+cst.getCodCst()+"]");
        lblNameSoc.setText(cst.getName()+" "+cst.getApplldos());
        if(pautz!=null && !pautz.isEmpty()){
            oPers=new ArrayList<Component>();
            for(VideoupAutrz pa: pautz){
                oPers.add(new javax.swing.JLabel(pa.getPname()));
            }
            Utils.loadAsTableLayout(oPers, pnlPautz, "No hay representantes");
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

        jPanel1 = new javax.swing.JPanel();
        btnSet = new javax.swing.JButton();
        lblNameSoc = new javax.swing.JLabel();
        pnlPautz = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        btnSet.setText("[CODESOC] ");
        btnSet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetActionPerformed(evt);
            }
        });
        jPanel1.add(btnSet, java.awt.BorderLayout.NORTH);

        lblNameSoc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNameSoc.setText("Nombre Apellidos Xjgs");
        jPanel1.add(lblNameSoc, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.NORTH);

        pnlPautz.setLayout(null);
        add(pnlPautz, java.awt.BorderLayout.CENTER);
        add(jSeparator1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetActionPerformed
        if(ficha!=null){
            if(ficha instanceof com.videoup.views.modalqrs.Ficha){
                ((com.videoup.views.modalqrs.Ficha)ficha).setCustomr(cst);
            }else if(ficha instanceof com.videoup.views.modvnts.Ficha){
                ((com.videoup.views.modvnts.Ficha)ficha).setCustomr(cst);
            }
        }
    }//GEN-LAST:event_btnSetActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSet;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblNameSoc;
    private javax.swing.JPanel pnlPautz;
    // End of variables declaration//GEN-END:variables
}