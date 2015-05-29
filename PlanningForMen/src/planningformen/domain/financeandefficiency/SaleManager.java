/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen.domain.financeandefficiency;

import java.sql.Date;
import java.util.List;
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
    
    
    public boolean createSale(Employee emp, Customer cust, List<Sellable> sellables)
    {
        return false;
    }
    
    public boolean printInvoice(Sale sale)
    {
        return false;
    }
    
    public double paySale(Sale sale, double amountPaid)
    {
        return sale.getTotalPrice() - amountPaid;
    }
    
    public List<Sale> getSale(Customer cust, Date fromDate, Date toDate)
    {
        return null;
    }
}
