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
import planningformen.business.SaleConverter;
import planningformen.domain.planning.Car;
import planningformen.domain.planning.CarManager;
import planningformen.domain.planning.Customer;
import planningformen.domain.planning.CustomerManager;
import planningformen.domain.planning.Employee;
import planningformen.domain.planning.EmployeeManager;
import planningformen.domain.planning.Sellable;

/**
 *
 * @author Simon
 */
public class SaleManager implements ISaleCallback
{
    private static SaleManager _instance;
    private List<Sale> _sales;
    private final double TAX = .25f;
    private SaleConverter _saleConverter;

    private SaleManager()
    {
        _saleConverter = new SaleConverter();
        retrieveSales();
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
        System.out.println("CreateSale on Manager Level!!!");
        Calendar c = GregorianCalendar.getInstance();
        Date sellDate = new Date(c.getTimeInMillis());
        c.add(Calendar.DATE, 14);
        Date dueDate = new Date(c.getTimeInMillis());
        
        //Sales ID made from customerID  + size of sales list. May be changed later.
        String saleID = cust.getCustomerID() + "-" + _sales.size();
        
        Sale sale = new Sale(saleID, emp, cust, sellables, sellDate, dueDate, amountPaid, TAX);
        
        if(_saleConverter.createSale(sale))
        {
            System.out.println("All DB stuff done @Sales!");
            return _sales.add(sale);
        }

        return false;
    }
    
    public void retrieveSales()
    {
        _sales = _saleConverter.retrieveSales(this);
    }
    
    public boolean updateSale(Sale sale)
    {
        return _saleConverter.updateSale(sale);
    }
    
    public boolean deleteSale(Sale sale)
    {
        if(_saleConverter.deleteSale(sale))
            return _sales.remove(sale);
        return false;
    }
    public boolean printInvoice(Sale sale)
    {
        StringBuilder output = new StringBuilder();

        output.append("SaleID: " + sale.getId() + "\n");
        output.append("CustomerID: " + sale.getCustomer().getCustomerID() + "\n");
        output.append("Customer Name: " + sale.getCustomer().getFirstName() + " " + sale.getCustomer().getLastName() + "\n");
        output.append("Responsible employee: " + sale.getEmployee().getFirstName() + "" + sale.getEmployee().getLastName() + "\n");
        output.append("\n");
        for(Sellable s : sale.getItems())
        {
            output.append(" Item name goes here "  + s.getSellPrice() + "\n"); //Need changes to sellable Interface to return a meaningful name.
        }
        //Send to tech layer here
        System.out.println(output.toString());
        return _saleConverter.printInvoice(output.toString(), sale.getId());
        
    }
    
    public double paySale(Sale sale, double amountPaid)
    {
        if(!sale.IsPaid())
        {
            double totalAmountPaid = sale.getAmountPaid() + amountPaid;
            
            if(updateSale(sale)) //If db stuff succeeds
            {
                sale.setAmountPaid(amountPaid);
                return sale.getTotalPrice() - sale.getAmountPaid();
            }
        }
        return 0f;
    }
    
    public List<Sale> getSales() {return _sales; }
    
    public List<Sale> findSales(Customer cust, Date fromDate, Date toDate)
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
    
    public List<Sale> findSales(int year)
    {
        Date startDate = new Date(year - 1, 12, 31);
        Date endDate = new Date(year + 1, 1, 1);
        List<Sale> tmpList = new ArrayList<Sale>();
        for(Sale s : _sales)
        {
            if(s.getSaleDate().after(startDate) && s.getSaleDate().before(endDate))
            {
                tmpList.add(s);
            }
        }
        return tmpList;
    }
    
    public double calculateTaxes(Sale sale)
    {
        return sale.getTotalPrice() * sale.getTax();
    }
    
    public double calculateTaxes(List<Sale> sales)
    {
        double totalTax = 0;
        
        for(Sale s : sales)
            totalTax = calculateTaxes(s);
        return totalTax;
    }

    @Override
    public Employee getEmployeeByID(String empID)
    {
        return EmployeeManager.getInstance().findEmployee(empID);
    }

    @Override
    public Customer getCustomerByID(String custID)
    {
        return CustomerManager.getInstance().findCustomer(custID);
    }

    @Override
    public List<Car> getCarsBySaleID(String saleID)
    {
        return CarManager.getInstance().findCarsBySaleID(saleID);
    }

    @Override
    public List<Service> getServicesBySaleID(String saleID)
    {
        return ServiceManager.getInstance().findServicesBySaleID(saleID);
    }
}
