/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videoup.views.modbonos;

import com.videoup.entities.VideoupBonos;
import com.videoup.entities.VideoupCustomers;
import com.videoup.entities.VideoupSoldBonos;
import com.videoup.utils.GeneralDAO;
import com.videoup.views.utils.Utils;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Pedro
 */
public class SellBonos extends javax.swing.JDialog{

    private VideoupCustomers socio;
    private List<Component> cBonos;
    private GeneralDAO gDao;
    private com.videoup.views.modsocios.Ficha fichaSoc;
    
    /**
     * Creates new form SellBonos
     */
    public SellBonos(java.awt.Frame parent, boolean modal, VideoupCustomers socio,com.videoup.views.modsocios.Ficha fichaSoc){
        super(parent, modal);
        this.fichaSoc=fichaSoc;
        gDao=new GeneralDAO();
        initComponents();
        this.socio=socio;
        lblSocio.setText(socio.getCodCst()+": "+socio.getName()+" "+socio.getApplldos());
        loadBonos();
        setLocationRelativeTo(null);
    }
    
    private void loadBonos(){
        List<VideoupBonos> lstBonos;
        cBonos=new ArrayList<Component>();
        lstBonos=gDao.getListEntities("from VideoupBonos", null, 0,false);
        cBonos.clear();
        if(lstBonos==null){
            cBonos.add(new JLabel("Error: "+gDao.getError()));
        }else{
            cBonos.add(new JLabel("Seleccione el paquete de bonos a comprar"));
            for(VideoupBonos bono: lstBonos){
                cBonos.add(new SellingBono(this,bono));
            }
        }
        Utils.loadAsTableLayout(cBonos, pnlLits, "No hay bonos registrados");
    }
    
    public void updateTotals(){
        float total=0;
        for(Component cmp: cBonos){
            if(cmp instanceof SellingBono){
                total+=((SellingBono)cmp).getCosto();
            }
        }
        txtTotal.setText(""+total);
    }
    
    private void sellChoosen(){
        VideoupSoldBonos sold;
        Calendar cal=Calendar.getInstance();
        Date today=cal.getTime();
        Date vigen;
        SellingBono sBono;
        boolean allsaved=true;
        for(Component cmp: cBonos){
            if(cmp instanceof SellingBono){
                sBono=((SellingBono)cmp);
                if( sBono.getCosto()>0 ){
                    cal.add(Calendar.DATE,sBono.getDays());
                    vigen=cal.getTime();
                    sold=new VideoupSoldBonos(today,vigen,0,sBono.getBonos(),sBono.getCosto(),socio,
                            sBono.getHours(),sBono.getApplyMovs(),sBono.getApplyGms());
                    if(!gDao.saveEntity(sold,true)){
                        JOptionPane.showMessageDialog(this,gDao.getError(),"Error",JOptionPane.ERROR_MESSAGE);
                        allsaved=false; break;
                    }
                }
            }
        }
        if(allsaved){
            JOptionPane.showMessageDialog(this,"Los bonos han sido asignados","Hecho",JOptionPane.INFORMATION_MESSAGE);
            fichaSoc.refreshBonos();
            dispose();
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

        pnlNorth = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblSocio = new javax.swing.JLabel();
        pnlSouth = new javax.swing.JPanel();
        txtTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnSell = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlLits = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Compra de bonos para socio:");

        lblSocio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSocio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSocio.setText("SOCIO");

        javax.swing.GroupLayout pnlNorthLayout = new javax.swing.GroupLayout(pnlNorth);
        pnlNorth.setLayout(pnlNorthLayout);
        pnlNorthLayout.setHorizontalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorthLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSocio, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlNorthLayout.setVerticalGroup(
            pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNorthLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNorthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblSocio))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlNorth, java.awt.BorderLayout.NORTH);

        txtTotal.setEditable(false);
        txtTotal.setColumns(8);

        jLabel2.setText("Total:");

        btnSell.setText("Comprar");
        btnSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSellActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSouthLayout = new javax.swing.GroupLayout(pnlSouth);
        pnlSouth.setLayout(pnlSouthLayout);
        pnlSouthLayout.setHorizontalGroup(
            pnlSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSouthLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addComponent(btnSell)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlSouthLayout.setVerticalGroup(
            pnlSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSouthLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSouthLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnSell)
                    .addComponent(btnCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlSouth, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout pnlLitsLayout = new javax.swing.GroupLayout(pnlLits);
        pnlLits.setLayout(pnlLitsLayout);
        pnlLitsLayout.setHorizontalGroup(
            pnlLitsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 408, Short.MAX_VALUE)
        );
        pnlLitsLayout.setVerticalGroup(
            pnlLitsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pnlLits);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSellActionPerformed
        sellChoosen();
    }//GEN-LAST:event_btnSellActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSell;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSocio;
    private javax.swing.JPanel pnlLits;
    private javax.swing.JPanel pnlNorth;
    private javax.swing.JPanel pnlSouth;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
