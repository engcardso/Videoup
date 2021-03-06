/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videoup.views.modconf;

import com.videoup.entities.VideoupTaxes;
import com.videoup.utils.Validator;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Pedro
 */
public class STax extends javax.swing.JPanel implements DocumentListener{

    private boolean changes;
    private Validator vltor;
    private VideoupTaxes ent; 
    private CTaxes taxesCard;
    
    /**
     * Creates new form STax
     */
    public STax(CTaxes taxesCard){
        this.taxesCard=taxesCard;
        initComponents();
        setUpValidator();
        txNombre.getDocument().addDocumentListener(this);
        txPercent.getDocument().addDocumentListener(this);
        changes=false;
        ent=null;
    }

    private void setUpValidator(){
        vltor=new Validator();
        vltor.addStringField(txNombre, "Nombre del impuesto", true, 2, 25,0);
        vltor.addIntField(txPercent, "Porcentaje del impuesto", true, 1, 99,0);
    }
    
    public boolean isDataValid(){
        return vltor.validate();
    }
    
    public String getError(){
        return vltor.getError();
    }
    
    public boolean hasChanges(){
        return changes;
    }
    
    public void setTaxEntity(VideoupTaxes entity){
        ent=entity;
        txNombre.setText(ent.getNamet());
        txPercent.setText(""+ent.getPorcent());
        jckAlqus.setSelected(ent.getApRent());
        jckVentas.setSelected(ent.getApVent());
        jckFacturOnly.setSelected(ent.getFacturOnl());
    }
    
    /** 
     * @param create If ent is null an create its true then new ent is created, else return ent as null
     * @return 
     */
    public VideoupTaxes getEntity(boolean create){
        if(ent==null && create){
            ent=new VideoupTaxes();
        }
        if(ent!=null){
            ent.setNamet(txNombre.getText());
            ent.setPorcent(Integer.parseInt(txPercent.getText()));
            ent.setApRent(jckAlqus.isSelected());
            ent.setApVent(jckVentas.isSelected());
            ent.setFacturOnl(jckFacturOnly.isSelected());
        }
        return ent;
    }
    
    private void deleteMe(){
        taxesCard.deleteATax(this);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txNombre = new javax.swing.JTextField();
        jckAlqus = new javax.swing.JCheckBox();
        jckVentas = new javax.swing.JCheckBox();
        btnDelete = new javax.swing.JButton();
        jckFacturOnly = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        txPercent = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        jLabel1.setText("Nombre del impuesto:");

        txNombre.setColumns(10);

        jckAlqus.setText("Alquileres");

        jckVentas.setText("Ventas");

        btnDelete.setText("X");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jckFacturOnly.setText("Solo operaciones con factura");

        jLabel2.setText("Valor:");

        txPercent.setColumns(3);

        jLabel3.setText("%");

        jLabel4.setText("Aplicar en:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jckAlqus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jckVentas)
                        .addGap(18, 18, 18)
                        .addComponent(jckFacturOnly)
                        .addGap(0, 217, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txPercent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete)))
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txPercent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnDelete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jckAlqus)
                    .addComponent(jckVentas)
                    .addComponent(jckFacturOnly))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        deleteMe();
    }//GEN-LAST:event_btnDeleteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JCheckBox jckAlqus;
    private javax.swing.JCheckBox jckFacturOnly;
    private javax.swing.JCheckBox jckVentas;
    private javax.swing.JTextField txNombre;
    private javax.swing.JTextField txPercent;
    // End of variables declaration//GEN-END:variables

    @Override
    public void insertUpdate(DocumentEvent e) {
        changes=true;
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        changes=true;
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        changes=true;
    }
}
