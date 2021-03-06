/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.videoup.views.utils;

import java.awt.EventQueue;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.OrientationRequested;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;

/**
 *
 * @author Pedro
 */
public class PrintDiag extends javax.swing.JDialog {

    private PrintService[] printers;
    private JasperPrint impresor;
    private int nPages;
    private int pgi;
    private int pgf;
    private int cpy;
    private String errm;
    
    /**
     * Creates new form PrintDiag
     */
    public PrintDiag(java.awt.Frame parent, boolean modal, String titRepo) {
        super(parent, modal);
        initComponents();
        setTitle("Reporte "+titRepo);
        listPrinters();
        pack();
        setLocationRelativeTo(parent);
    }
    
     /**
     * 
     * @param params
     * @param lista
     * @param numRep 1=ingrresos, 2=contrato, 3=imagen, 4=actividad, 5=juegos, 6=peliculas, 7=socios
     * @return 
     */
    public boolean cargaReporte(Map<String,Object> params, ArrayList lista, int numRep){
        JRBeanCollectionDataSource campos=null;
        String dirBase=System.getProperty("user.dir");
        String nomrep="--";
        if(numRep==1){ nomrep="rIngresos"; }
        else if(numRep==2){ nomrep="contrato"; }
        else if(numRep==3){
            rbtnVert.setEnabled(true); rbtnHorz.setEnabled(true); nomrep="cvImage";
        }
        else if(numRep==4){ nomrep="rActivity"; }
        else if(numRep>=5){ nomrep="rListd"; }
        try{
            if(lista!=null){
                campos=new JRBeanCollectionDataSource(lista);
            }
            impresor=JasperFillManager.fillReport(dirBase+File.separator+"reps"+File.separator+nomrep+".jasper",
                    params,(campos!=null?campos:new JREmptyDataSource()));
            nPages=impresor.getPages().size();
            txPgIni.setText( ""+(nPages>0?1:0) );
            txPgFin.setText(""+nPages);
            lblTPages.setText("Total de paginas "+nPages);
            return true;
        }catch(Exception exc){
            exc.printStackTrace();
            return false;
        }
    }
    
    private void listPrinters(){
        printers = PrintServiceLookup.lookupPrintServices(null, null);
        if(printers.length==0){
            jcbPrinters.addItem("No encontro impresoras");
        }else{
            for(int h=0;h<printers.length;h++) {
                jcbPrinters.addItem(""+printers[h].getName());
            }
        }
    }
    
    private boolean validateData(){
        errm=null;
        try{ pgi=Integer.parseInt(txPgIni.getText()); }
        catch(NumberFormatException nfe){ pgi=-1;}
        try{ pgf=Integer.parseInt(txPgFin.getText()); }
        catch(NumberFormatException nfe){ pgf=-1; }
        try{ cpy=Integer.parseInt(txCopias.getText()); }
        catch(NumberFormatException nfe){ cpy=-1; }
        if(pgi<1){ errm="Pagina inicial invalida"; }
        else if(pgf<pgi || pgf>nPages){ errm="Pagina final invalida"; }
        else if(cpy<1){ errm="Numero de copias invalida"; }
        if(errm!=null){
            final PrintDiag pdg=this;
            EventQueue.invokeLater(new Runnable(){
                @Override
                public void run(){
                    JOptionPane.showMessageDialog(pdg,errm,"Error",JOptionPane.ERROR_MESSAGE);
                }
            });
            return false;
        }
        return true;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbtngOtn = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jcbPrinters = new javax.swing.JComboBox();
        btnCancel = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txPgIni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txPgFin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txCopias = new javax.swing.JTextField();
        lblTPages = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rbtnVert = new javax.swing.JRadioButton();
        rbtnHorz = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Imprimir reporte de");

        jLabel1.setText("Impresora:");

        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnPrint.setText("Imprimir");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        jLabel2.setText("Imprimir desde:");

        txPgIni.setColumns(5);
        txPgIni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txPgIni.setText("0");

        jLabel3.setText("a");

        txPgFin.setColumns(5);
        txPgFin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txPgFin.setText("0");

        jLabel4.setText("Copias:");

        txCopias.setColumns(5);
        txCopias.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txCopias.setText("1");

        lblTPages.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTPages.setText("Total de paginas N");

        jLabel5.setText("Orientacion:");

        rbtngOtn.add(rbtnVert);
        rbtnVert.setSelected(true);
        rbtnVert.setText("Vertical");
        rbtnVert.setEnabled(false);

        rbtngOtn.add(rbtnHorz);
        rbtnHorz.setText("Horizontal");
        rbtnHorz.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 168, Short.MAX_VALUE)
                        .addComponent(btnPrint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbPrinters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txCopias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txPgIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txPgFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(rbtnVert)
                            .addComponent(rbtnHorz))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblTPages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbPrinters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblTPages)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txPgIni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txPgFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txCopias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rbtnVert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtnHorz)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnPrint))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        JRPrintServiceExporter exporter;
        PrintRequestAttributeSet atribImp;
        OrientationRequested orientation;
        int rps;
        if(!validateData()){ return; }
        try{
            atribImp=new HashPrintRequestAttributeSet();
            if(rbtnHorz.isSelected()){ orientation=OrientationRequested.LANDSCAPE; }
            else{ orientation=OrientationRequested.PORTRAIT; }
            atribImp.add(orientation);
            atribImp.add(new Copies(cpy));
            exporter = new JRPrintServiceExporter();
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET,atribImp);
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, impresor);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, printers[jcbPrinters.getSelectedIndex()]);
            exporter.setParameter(JRPrintServiceExporterParameter.START_PAGE_INDEX, pgi-1);
            exporter.setParameter(JRPrintServiceExporterParameter.END_PAGE_INDEX, pgf-1);
            exporter.exportReport();
        }catch(Exception exc){
            //System.out.println("*PRINTING*\n"+exc.getMessage());
            exc.printStackTrace();
        }finally{ setVisible(false); }
    }//GEN-LAST:event_btnPrintActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox jcbPrinters;
    private javax.swing.JLabel lblTPages;
    private javax.swing.JRadioButton rbtnHorz;
    private javax.swing.JRadioButton rbtnVert;
    private javax.swing.ButtonGroup rbtngOtn;
    private javax.swing.JTextField txCopias;
    private javax.swing.JTextField txPgFin;
    private javax.swing.JTextField txPgIni;
    // End of variables declaration//GEN-END:variables
}
