/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.ui.gui;

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

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        findCarPanel2 = new planningformen.ui.gui.FindCarPanel();
        findEmployeePanel2 = new planningformen.ui.gui.FindEmployeePanel();
        findCustomerPanel1 = new planningformen.ui.gui.FindCustomerPanel();
        findTyrePanel2 = new planningformen.ui.gui.FindTyrePanel();
        findServicePanel2 = new planningformen.ui.gui.FindServicePanel();
        findSalePanel1 = new planningformen.ui.gui.FindSalePanel();

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("FIND");

        jTabbedPane1.addTab("Car", findCarPanel2);
        jTabbedPane1.addTab("Employee", findEmployeePanel2);
        jTabbedPane1.addTab("Customer", findCustomerPanel1);
        jTabbedPane1.addTab("Tyre", findTyrePanel2);
        jTabbedPane1.addTab("Service", findServicePanel2);
        jTabbedPane1.addTab("Sale", findSalePanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(427, 427, 427)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private planningformen.ui.gui.FindCarPanel findCarPanel2;
    private planningformen.ui.gui.FindCustomerPanel findCustomerPanel1;
    private planningformen.ui.gui.FindEmployeePanel findEmployeePanel2;
    private planningformen.ui.gui.FindSalePanel findSalePanel1;
    private planningformen.ui.gui.FindServicePanel findServicePanel2;
    private planningformen.ui.gui.FindTyrePanel findTyrePanel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
