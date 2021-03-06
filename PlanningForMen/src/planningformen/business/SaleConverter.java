/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.business;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import planningformen.domain.financeandefficiency.ISaleCallback;
import planningformen.domain.financeandefficiency.Sale;
import planningformen.domain.financeandefficiency.Service;
import planningformen.domain.planning.Car;
import planningformen.domain.planning.Sellable;
import planningformen.domain.tyre.Tyre;
import planningformen.technical.IOManager;

/**
 *
 * @author Cymon343
 */
public class SaleConverter implements ICallback
{
    private List<Sale> _convertedSales;
    private List<String> _employeeIDs;
    private List<String> _customerIDs;
    
    @Override
    public void extractValues(ResultSet rs) throws SQLException
    {
        _convertedSales = new ArrayList<Sale>();
        _employeeIDs = new ArrayList<String>();
        _customerIDs = new ArrayList<String>();
        
        while(rs.next())
        {
            String saleID = rs.getString(1);
            _employeeIDs.add(rs.getString(2));
            _customerIDs.add(rs.getString(3));
            Date saleDate = rs.getDate(4);
            Date dueDate = rs.getDate(5);
            double amountPaid = rs.getDouble(6);
            double tax = rs.getDouble(7);
            _convertedSales.add(new Sale(saleID, null, null, null, saleDate, dueDate, amountPaid, tax));   
        }
    }
  
    public boolean createSale(Sale sale)
    {
        List<String> carIDs = new ArrayList<String>();
        List<String> serviceIDs = new ArrayList<String>();
        List<String> tyreIDs = new ArrayList<String>();
       
        for(Sellable s : sale.getItems())
        {
            if(s instanceof Car)
                carIDs.add(((Car)s).getId());
            else if(s instanceof Service)
                serviceIDs.add(((Service)s).getId());
            else
                tyreIDs.add(((Tyre)s).getId());
        }
        //Explicit for bug-squashing reasons:
        String saleID = sale.getId();
        String empID = sale.getEmployee().getEmployeeID();
        String custID = sale.getCustomer().getCustomerID();
        Date saleDate = sale.getSaleDate();
        Date dueDate = sale.getDueDate();
        String[] carIDsArr = carIDs.toArray(new String[0]);
        String[] serviceIDsArr = serviceIDs.toArray(new String[0]);
        String[] tyreIDsArr = tyreIDs.toArray(new String[0]);
        double amountPaid = sale.getAmountPaid();
        double tax = sale.getTax();
        return IOManager.getInstance().getDBHandler().createSale(saleID, empID, custID, saleDate, dueDate, carIDsArr, serviceIDsArr, tyreIDsArr, amountPaid, tax);
    }
    
    public List<Sale> retrieveSales(ISaleCallback owner)
    {
        IOManager.getInstance().getDBHandler().retrieveSales(this);
        
        for(int i = 0; i < _convertedSales.size(); i++)
        {
            _convertedSales.get(i).setEmployee(owner.getEmployeeByID(_employeeIDs.get(i)));
            _convertedSales.get(i).setCustomer(owner.getCustomerByID(_customerIDs.get(i)));
            _convertedSales.get(i).getItems().addAll(owner.getCarsBySaleID(_convertedSales.get(i).getId()));
            _convertedSales.get(i).getItems().addAll(owner.getServicesBySaleID(_convertedSales.get(i).getId()));
            _convertedSales.get(i).getItems().addAll(owner.getTyresBySaleID(_convertedSales.get(i).getId()));
        }
        return _convertedSales;
    }
    
    public boolean updateSale(Sale sale)
    {
        List<String> carIDs = new ArrayList<String>();
        List<String> serviceIDs = new ArrayList<String>();
        List<String> tyreIDs = new ArrayList<String>();
       
        for(Sellable s : sale.getItems())
        {
            if(s instanceof Car)
                carIDs.add(((Car)s).getId());
            else if(s instanceof Service)
                serviceIDs.add(((Service)s).getId());
            else
                tyreIDs.add(((Tyre)s).getId());
        }
        return IOManager.getInstance().getDBHandler().updateSale(sale.getId(), sale.getEmployee().getEmployeeID(), sale.getCustomer().getCustomerID(),
                                                                 sale.getSaleDate(), sale.getDueDate(), carIDs.toArray(new String[0]), 
                                                                 serviceIDs.toArray(new String[0]), tyreIDs.toArray(new String[0]), sale.getAmountPaid(), 
                                                                 sale.getTax());
    }
    
    public boolean deleteSale(Sale sale)
    {
        return IOManager.getInstance().getDBHandler().deleteSale(sale.getId());
    }
    
     
    public boolean printInvoice(String input, String fileName)
    {
        return IOManager.getInstance().getFileHandler().createTextFile(input, fileName);
    }
}
