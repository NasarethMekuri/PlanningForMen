/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen.ui.gui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;

/**
 *
 * @author bruger
 */
public class FindCarPanel extends javax.swing.JPanel
{
    private List<JComponent> searchItems;
    
    /**
     * Creates new form FindCarPanel
     */
    public FindCarPanel()
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
        criteria = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        kilometers = new javax.swing.JLabel();
        version = new javax.swing.JLabel();
        make = new javax.swing.JLabel();
        purchaseDate = new javax.swing.JLabel();
        plate = new javax.swing.JLabel();
        purchasePrice = new javax.swing.JLabel();
        volume = new javax.swing.JLabel();
        sellPrice = new javax.swing.JLabel();
        year = new javax.swing.JLabel();
        model = new javax.swing.JLabel();
        carID = new javax.swing.JLabel();
        carIdTxtField = new javax.swing.JTextField();
        plateTxtField = new javax.swing.JTextField();
        yearTxtField = new javax.swing.JTextField();
        makeTxtField = new javax.swing.JTextField();
        modelTxtField = new javax.swing.JTextField();
        versionTxtField = new javax.swing.JTextField();
        volumeTxtField = new javax.swing.JTextField();
        purchasePriceTxtField = new javax.swing.JTextField();
        sellPriceTxtField = new javax.swing.JTextField();
        kilometersTxtField = new javax.swing.JTextField();
        purchaseDateTxtField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("FIND CAR");

        criteria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose search criteria", "CarID", "Plate", "Year", "Make", "Model", "Make and Model", "Version", "Make, Model, and Version", "Volume", "Purchase Price", "Sell Price", "Kilometers", "Purchase Date"}));
        criteria.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                criteriaActionPerformed(evt);
            }
        });

        jLabel2.setText("Choose what to search by:");

        kilometers.setText("Kilometers");

        version.setText("Version");

        make.setText("Make");

        purchaseDate.setText("Purchase Date");

        plate.setText("Plate");

        purchasePrice.setText("Purchase Price");

        volume.setText("Volume");

        sellPrice.setText("Sell Price");

        year.setText("Year");

        model.setText("Model");

        carID.setText("Car ID");

        jButton1.setText("Find Cars");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(plate)
                    .addComponent(carID)
                    .addComponent(make)
                    .addComponent(model)
                    .addComponent(version)
                    .addComponent(volume)
                    .addComponent(purchasePrice)
                    .addComponent(sellPrice)
                    .addComponent(kilometers)
                    .addComponent(year)
                    .addComponent(purchaseDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(kilometersTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(purchaseDateTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(purchasePriceTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(sellPriceTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(versionTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(volumeTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(modelTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(makeTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(yearTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(plateTxtField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(carIdTxtField, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(carID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carIdTxtField))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plate)
                    .addComponent(plateTxtField))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(year)
                    .addComponent(yearTxtField))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(make)
                    .addComponent(makeTxtField))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(model)
                    .addComponent(modelTxtField))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(version)
                    .addComponent(versionTxtField))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volume)
                    .addComponent(volumeTxtField))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(purchasePrice)
                    .addComponent(purchasePriceTxtField))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sellPrice)
                    .addComponent(sellPriceTxtField))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kilometers)
                    .addComponent(kilometersTxtField))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(purchaseDate)
                    .addComponent(purchaseDateTxtField))
                .addGap(52, 52, 52)
                .addComponent(jButton1)
                .addGap(38, 38, 38))
        );

        jList2.setModel(new javax.swing.AbstractListModel()
        {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(criteria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))
                        .addGap(703, 703, 703))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(criteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void criteriaActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_criteriaActionPerformed
    {//GEN-HEADEREND:event_criteriaActionPerformed
        searchItems = populateSearchItemsList();
        
        disableAllSearchComponents();
        
        
        switch (criteria.getSelectedIndex())
        {
            case 1:
                carID.setEnabled(true);
                carIdTxtField.setEnabled(true);
                break;
            case 2:
                plate.setEnabled(true);
                plateTxtField.setEnabled(true);
                break;
            case 3:
                year.setEnabled(true);
                yearTxtField.setEnabled(true);
                break;
            case 4:
                make.setEnabled(true);
                makeTxtField.setEnabled(true);
                break;
            case 5:
                model.setEnabled(true);
                modelTxtField.setEnabled(true);
                break;
            case 6:
                make.setEnabled(true);
                makeTxtField.setEnabled(true);
                model.setEnabled(true);
                modelTxtField.setEnabled(true);
                break;
            case 7:
                version.setEnabled(true);
                versionTxtField.setEnabled(true);
                break;
            case 8:
                make.setEnabled(true);
                makeTxtField.setEnabled(true);
                model.setEnabled(true);
                modelTxtField.setEnabled(true);
                version.setEnabled(true);
                versionTxtField.setEnabled(true);
                break;
            case 9:
                volume.setEnabled(true);
                volumeTxtField.setEnabled(true);
                break;
            case 10:
                purchasePrice.setEnabled(true);
                purchasePriceTxtField.setEnabled(true);
                break;
            case 11:
                sellPrice.setEnabled(true);
                sellPriceTxtField.setEnabled(true);
                break;
            case 12:
                kilometers.setEnabled(true);
                kilometersTxtField.setEnabled(true);
                break;
            case 13:
                purchaseDate.setEnabled(true);
                purchaseDateTxtField.setEnabled(true);
                break;
                
        }
        
    }//GEN-LAST:event_criteriaActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel carID;
    private javax.swing.JTextField carIdTxtField;
    private javax.swing.JComboBox criteria;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel kilometers;
    private javax.swing.JTextField kilometersTxtField;
    private javax.swing.JLabel make;
    private javax.swing.JTextField makeTxtField;
    private javax.swing.JLabel model;
    private javax.swing.JTextField modelTxtField;
    private javax.swing.JLabel plate;
    private javax.swing.JTextField plateTxtField;
    private javax.swing.JLabel purchaseDate;
    private javax.swing.JTextField purchaseDateTxtField;
    private javax.swing.JLabel purchasePrice;
    private javax.swing.JTextField purchasePriceTxtField;
    private javax.swing.JLabel sellPrice;
    private javax.swing.JTextField sellPriceTxtField;
    private javax.swing.JLabel version;
    private javax.swing.JTextField versionTxtField;
    private javax.swing.JLabel volume;
    private javax.swing.JTextField volumeTxtField;
    private javax.swing.JLabel year;
    private javax.swing.JTextField yearTxtField;
    // End of variables declaration//GEN-END:variables
    
    private List<JComponent> populateSearchItemsList()
    {
        List<JComponent> returnList = new ArrayList();
        returnList.add(carID);
        returnList.add(carIdTxtField);
        returnList.add(plate);
        returnList.add(plateTxtField);
        returnList.add(year);
        returnList.add(yearTxtField);
        returnList.add(make);
        returnList.add(makeTxtField);
        returnList.add(model);
        returnList.add(modelTxtField);
        returnList.add(version);
        returnList.add(versionTxtField);
        returnList.add(volume);
        returnList.add(volumeTxtField);
        returnList.add(purchasePrice);
        returnList.add(purchasePriceTxtField);
        returnList.add(sellPrice);
        returnList.add(sellPriceTxtField);
        returnList.add(kilometers);
        returnList.add(kilometersTxtField);
        returnList.add(purchaseDate);
        returnList.add(purchaseDateTxtField);
        
        return returnList;
    }
    
    private void disableAllSearchComponents()
    {
        for (JComponent se : searchItems)
        {
            se.setEnabled(false);
        }
    }
}