/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.ui.gui;
import planningformen.ui.gui.*;

/**
 *
 * @author Morten
 */
public class FindMainPanel extends javax.swing.JPanel
{

    /**
     * Creates new form FindMainPanel
     */
    public FindMainPanel()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        findCarPanel1 = new planningformen.ui.gui.FindCarPanel();
        findCustomerPanel1 = new planningformen.ui.gui.FindCustomerPanel();
        findEmployeePanel1 = new planningformen.ui.gui.FindEmployeePanel();
        findServicePanel1 = new planningformen.ui.gui.FindServicePanel();
        findTyrePanel1 = new planningformen.ui.gui.FindTyrePanel();
        findSalePanel1 = new planningformen.ui.gui.FindSalePanel();
        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1280, 720));

        javax.swing.GroupLayout findCarPanel1Layout = new javax.swing.GroupLayout(findCarPanel1);
        findCarPanel1.setLayout(findCarPanel1Layout);
        findCarPanel1Layout.setHorizontalGroup(
            findCarPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 903, Short.MAX_VALUE)
        );
        findCarPanel1Layout.setVerticalGroup(
            findCarPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Car", findCarPanel1);

        javax.swing.GroupLayout findCustomerPanel1Layout = new javax.swing.GroupLayout(findCustomerPanel1);
        findCustomerPanel1.setLayout(findCustomerPanel1Layout);
        findCustomerPanel1Layout.setHorizontalGroup(
            findCustomerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 903, Short.MAX_VALUE)
        );
        findCustomerPanel1Layout.setVerticalGroup(
            findCustomerPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Customer", findCustomerPanel1);

        javax.swing.GroupLayout findEmployeePanel1Layout = new javax.swing.GroupLayout(findEmployeePanel1);
        findEmployeePanel1.setLayout(findEmployeePanel1Layout);
        findEmployeePanel1Layout.setHorizontalGroup(
            findEmployeePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 903, Short.MAX_VALUE)
        );
        findEmployeePanel1Layout.setVerticalGroup(
            findEmployeePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Employee", findEmployeePanel1);

        javax.swing.GroupLayout findServicePanel1Layout = new javax.swing.GroupLayout(findServicePanel1);
        findServicePanel1.setLayout(findServicePanel1Layout);
        findServicePanel1Layout.setHorizontalGroup(
            findServicePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 903, Short.MAX_VALUE)
        );
        findServicePanel1Layout.setVerticalGroup(
            findServicePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Service", findServicePanel1);

        javax.swing.GroupLayout findTyrePanel1Layout = new javax.swing.GroupLayout(findTyrePanel1);
        findTyrePanel1.setLayout(findTyrePanel1Layout);
        findTyrePanel1Layout.setHorizontalGroup(
            findTyrePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 903, Short.MAX_VALUE)
        );
        findTyrePanel1Layout.setVerticalGroup(
            findTyrePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Tyre", findTyrePanel1);

        javax.swing.GroupLayout findSalePanel1Layout = new javax.swing.GroupLayout(findSalePanel1);
        findSalePanel1.setLayout(findSalePanel1Layout);
        findSalePanel1Layout.setHorizontalGroup(
            findSalePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 903, Short.MAX_VALUE)
        );
        findSalePanel1Layout.setVerticalGroup(
            findSalePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Sale", findSalePanel1);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Find");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(402, 402, 402)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 372, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private planningformen.ui.gui.FindCarPanel findCarPanel1;
    private planningformen.ui.gui.FindCustomerPanel findCustomerPanel1;
    private planningformen.ui.gui.FindEmployeePanel findEmployeePanel1;
    private planningformen.ui.gui.FindSalePanel findSalePanel1;
    private planningformen.ui.gui.FindServicePanel findServicePanel1;
    private planningformen.ui.gui.FindTyrePanel findTyrePanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
