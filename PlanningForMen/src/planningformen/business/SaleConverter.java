/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.business;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import planningformen.domain.financeandefficiency.Sale;
import planningformen.domain.financeandefficiency.Service;
import planningformen.domain.planning.Car;
import planningformen.domain.planning.Customer;
import planningformen.domain.planning.Sellable;
import planningformen.technical.IOManager;

/**
 *
 * @author Cymon343
 */
public class SaleConverter implements ICallback
{
    private List<Sale> _convertedSales;
    private List<Sellable> _sellables;
    
    @Override
    public void extractValues(ResultSet rs) throws SQLException
    {
        _convertedSales = new ArrayList<Sale>();
        
        while(rs.next())
        {
            String saleID = rs.getString(1);
            String empID = rs.getString(2);
            String custID = rs.getString(3);
            Date saleDate = rs.getDate(4);
            Date dueDate = rs.getDate(5);
            double amountPaid = rs.getDouble(6);
            double tax = rs.getDouble(7);
            _convertedsales.add(new Sale(saleID, empID, custID, _sellables, saleDate, dueDate, amountPaid, tax));   
        }
    }
  
    public boolean createSale(Sale sale)
    {
        List<String> carIDs = new ArrayList<String>();
        List<String> serviceIDs = new ArrayList<String>();
       
        for(Sellable s : sale.getItems())
        {
            if(s instanceof Car)
                carIDs.add(((Car)s).getId());
            else
                serviceIDs.add(((Service)s).getId());
        }
        return IOManager.getInstance().getDBHandler().createSale(sale.getId(), sale.getEmployee().getEmployeeID(), sale.getCustomer().getCustomerID(),
                                                                 sale.getSaleDate(), sale.getDueDate(), carIDs.toArray(new String[0]), 
                                                                 serviceIDs.toArray(new String[0]), sale.getAmountPaid());
    }
    
    public List<Sale> retrieveSales()
    {
        IOManager.getInstance().getDBHandler().retrieveSales(this);
        return _convertedSales;
    }
    
    public boolean updateSale(Sale sale)
    {
        List<String> carIDs = new ArrayList<String>();
        List<String> serviceIDs = new ArrayList<String>();
       
        for(Sellable s : sale.getItems())
        {
            if(s instanceof Car)
                carIDs.add(((Car)s).getId());
            else
                serviceIDs.add(((Service)s).getId());
        }
        return IOManager.getInstance().getDBHandler().updateSale(sale.getId(), sale.getEmployee().getEmployeeID(), sale.getCustomer().getCustomerID(),
                                                                 sale.getSaleDate(), sale.getDueDate(), carIDs.toArray(new String[0]), 
                                                                 serviceIDs.toArray(new String[0]), sale.getAmountPaid());
    }
    
    public boolean deleteSale(Sale sale)
    {
        return IOManager.getInstance().getDBHandler().deleteSale(sale.getId());
    }
    
}
