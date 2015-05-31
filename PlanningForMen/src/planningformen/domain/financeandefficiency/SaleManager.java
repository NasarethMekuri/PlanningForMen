/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen.domain.financeandefficiency;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.GregorianCalendar;
import planningformen.domain.planning.Customer;
import planningformen.domain.planning.Employee;
import planningformen.domain.planning.Sellable;

/**
 *
 * @author Simon
 */
public class SaleManager
{
    private static SaleManager _instance;
    private List<Sale> _sales;
    private final double TAX = .25f;

    private  SaleManager()
    {
    }
    
    public static synchronized SaleManager getInstance()
    {
        if (_instance == null)
        {
            _instance = new SaleManager();
        }
        return _instance;
    }
    
    
    public boolean createSale(Employee emp, Customer cust, List<Sellable> sellables, double amountPaid)
    {
        Calendar c = GregorianCalendar.getInstance();
        Date sellDate = new Date(c.getTimeInMillis());
        c.add(Calendar.DATE, 14);
        Date dueDate = new Date(c.getTimeInMillis());
        
        Sale sale = new Sale(emp, cust, dueDate, sellDate, true, amountPaid, TAX);
        
        //DO DB STUFF HERE
        
        _sales.add(sale);

        return false;
    }
    
    public boolean printInvoice(Sale sale)
    {
        return false;
    }
    
    public double paySale(Sale sale, double amountPaid)
    {
        if(!sale.IsPaid())
        {
            sale.setAmountPaid(sale.getAmountPaid() + amountPaid);
            return sale.getTotalPrice() - sale.getAmountPaid();
        }
        return 0f;
    }
    
    public List<Sale> getSales(Customer cust, Date fromDate, Date toDate)
    {
        List<Sale> tmpList = new ArrayList<Sale>();
        for(Sale s : _sales)
        {
            if(s.getCustomer() == cust)
            {
                if(s.getSaleDate().after(fromDate) && s.getSaleDate().before(toDate))
                {
                    tmpList.add(s);
                }
            }
        }
        return tmpList;
    }
}
