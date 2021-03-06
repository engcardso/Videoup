/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videoup.views.modformts;

import com.videoup.controllers.Controller;
import com.videoup.entities.VideoupBaseEntity;
import com.videoup.entities.VideoupFormts;
import com.videoup.views.utils.ViewFicha;

/**
 *
 * @author Pedro
 */
public class Ficha extends ViewFicha{

    private VideoupFormts ent;
    
    /**
     * Creates new form Ficha
     */
    public Ficha(Controller ctrl, int id) {
        super(ctrl,id,true);
        initComponents();
        initComps(ent);
    }

    public Ficha(Controller ctrl, Object ent, int id) {
        super(ctrl,id,false);
        initComponents();
        initComps(ent);
    }
    
    @Override
    protected void loadEntity(int id){
        ent=(VideoupFormts)getEntity("from VideoupFormts where idcf="+id);
    }
    
    private void initComps(Object ent){
        putMainContain(mainContain);
        if(ent==null){
            this.ent=new VideoupFormts();
        }else{
            loadEntity(ent);
        }
        setUpValidator();
        addJText2ListenChanges(txNom);
        addJText2ListenChanges(txDesc);
    }
    
    @Override
    protected void setUpValidator(){
        super.setUpValidator();
        vltor.addStringField(txNom, "Nombre del formato", true, 2, 155,0);
        vltor.addStringField(txDesc, "Descripcion", false, 10, 255,0);
    }
    
    @Override
    public String getTitle(){
        return "Ficha de formato"+(getId()==0?" nuevo":(ent==null?" ID: "+getId():": "+ent.getFrmt()));
    }
        
    @Override
    protected boolean saveEntity(VideoupBaseEntity ignore,boolean forceAsNew){
        boolean saved;
        ent.setFrmt(txNom.getText());
        ent.setDfrmt(txDesc.getText());
        saved=super.saveEntity(ent,forceAsNew);
        changes=!saved;
        return saved;
    }
    
    @Override
    protected void updateIdTitle(){
        setId(ent.getIdcf());
        lblTitle.setText(getTitle());
        ctrl.changeViewName(this, getTitle());
    }
    
    @Override
    public void loadEntity(Object oEnt){
        ent=((VideoupFormts)oEnt);
        txNom.setText(ent.getFrmt());
        txDesc.setText(ent.getDfrmt());
        lblTitle.setText(getTitle());
        changes=false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainContain = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txNom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txDesc = new javax.swing.JTextField();

        jLabel1.setText("Formato:");

        jLabel2.setText("Descripcion:");

        javax.swing.GroupLayout mainContainLayout = new javax.swing.GroupLayout(mainContain);
        mainContain.setLayout(mainContainLayout);
        mainContainLayout.setHorizontalGroup(
            mainContainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainContainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainContainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainContainLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txNom, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addComponent(txDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        mainContainLayout.setVerticalGroup(
            mainContainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainContainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainContainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(195, Short.MAX_VALUE))
        );

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel mainContain;
    private javax.swing.JTextField txDesc;
    private javax.swing.JTextField txNom;
    // End of variables declaration//GEN-END:variables
}
