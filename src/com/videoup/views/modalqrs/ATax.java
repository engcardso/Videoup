/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videoup.views.modalqrs;

import java.text.NumberFormat;

/**
 *
 * @author Pedro
 */
public class ATax extends javax.swing.JPanel {
    

    /**
     * Creates new form ATax
     */
    public ATax(String name, float value) {
        NumberFormat frmCurr=NumberFormat.getCurrencyInstance();
        initComponents();
        lblName.setText(name);
        txTax.setText( frmCurr.format(value) );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txTax = new javax.swing.JTextField();
        lblName = new javax.swing.JLabel();

        txTax.setEditable(false);
        txTax.setColumns(5);

        lblName.setText("Impuesto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(334, Short.MAX_VALUE)
                .addComponent(lblName)
                .addGap(18, 18, 18)
                .addComponent(txTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblName))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblName;
    private javax.swing.JTextField txTax;
    // End of variables declaration//GEN-END:variables
}
