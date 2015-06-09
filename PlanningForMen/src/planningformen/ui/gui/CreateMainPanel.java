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
public class CreateMainPanel extends javax.swing.JPanel
{

    /**
     * Creates new form CreateMainPanel
     */
    public CreateMainPanel()
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
        createEmployee1 = new planningformen.ui.gui.CreateEmployeePanel();
        createCustomerPanel1 = new planningformen.ui.gui.CreateCustomerPanel();
        createCarPanel2 = new planningformen.ui.gui.CreateCarPanel();
        jLabel1 = new javax.swing.JLabel();

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1280, 720));
        jTabbedPane1.addTab("Employee", createEmployee1);
        jTabbedPane1.addTab("Customer", createCustomerPanel1);
        jTabbedPane1.addTab("Car", createCarPanel2);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Create");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1025, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(411, 411, 411)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private planningformen.ui.gui.CreateCarPanel createCarPanel2;
    private planningformen.ui.gui.CreateCustomerPanel createCustomerPanel1;
    private planningformen.ui.gui.CreateEmployeePanel createEmployee1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
