/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.application;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import planningformen.domain.Master;
import planningformen.domain.financeandefficiency.Sale;
import planningformen.domain.financeandefficiency.SalesNumbers;
import planningformen.domain.planning.Customer;
import planningformen.domain.planning.Employee;
import planningformen.domain.planning.Sellable;

/**
 *
 * @author Simon
 */
public class SaleController implements ISaleController
{

    @Override
    public List<Sellable> getAvailableSellables()
    {
        List<Sellable> sellables = new ArrayList<Sellable>();
        
        sellables.addAll(Master.getInstance().getTyreManager().getTyres());
        sellables.addAll(Master.getInstance().getCarManager().getCars());
        sellables.addAll(Master.getInstance().getServiceManager().getServices());
        System.out.println("Pre sort Length: " + sellables.size());
        //Remove all Sellables already attached to a sale.
        for(int i = 0; i < sellables.size(); i++)
        {
            if(sellables.get(i).getSaleID() == null)
            {
                continue;
            }
            else
            {
                if(sellables.get(i).getSaleID().length() == 0) //Not null, but still considered unasigned.
                    continue;
                sellables.remove(i);
                i--;
            }
        }
        System.out.println("Post sort Length: " + sellables.size());
        return sellables;
    }
    
    @Override
    public boolean createSale(String employeeID, String customerID, List<Sellable> sellables, double amountPaid)
    {
        Employee emp = Master.getInstance().getEmployeeManager().findEmployee(employeeID);
        Customer cust = Master.getInstance().getCustomerManager().findCustomer(customerID);
        
        if(emp == null || cust == null || sellables == null || sellables.size() == 0)
            return false;
        return Master.getInstance().getSaleManager().createSale(emp, cust, sellables, amountPaid);
    }

    @Override
    public boolean updateSale(Sale sale)
    {
        return Master.getInstance().getSaleManager().updateSale(sale);
    }

    @Override
    public boolean deleteSale(Sale sale)
    {
        return Master.getInstance().getSaleManager().deleteSale(sale);
    }

    @Override
    public boolean printInvoice(Sale sale)
    {
        return Master.getInstance().getSaleManager().printInvoice(sale);
    }

    @Override
    public double paySale(Sale sale, double amountPaid)
    {
        System.out.println("Pay sale on Controller");
        return Master.getInstance().getSaleManager().paySale(sale, amountPaid);
    }

    @Override
    public List<Sale> findSales(String customerID, Date fromDate, Date toDate)
    {
        Customer customer = Master.getInstance().getCustomerManager().findCustomer(customerID);
        List<Sale> sales = new ArrayList<Sale>();
        
        if(customer != null)
            sales.addAll(Master.getInstance().getSaleManager().findSales(customer, fromDate, toDate));
        else
            sales.addAll(Master.getInstance().getSaleManager().findSales(fromDate, toDate));
        
      return sales;
    }

    @Override
    public List<Sale> findSales(int year)
    {
        return Master.getInstance().getSaleManager().findSales(year);
    }

    @Override
    public double calculateTaxes(Sale sale)
    {
        return Master.getInstance().getSaleManager().calculateTaxes(sale);
    }

    @Override
    public double calculateTaxes(List<Sale> sales)
    {
        return Master.getInstance().getSaleManager().calculateTaxes(sales);
    }

    @Override
    public SalesNumbers generateYearlySales(int year)
    {
        return Master.getInstance().getSaleManager().generateYearlySales(year);
    }
    
}
