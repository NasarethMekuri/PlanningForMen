/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.application;

import java.sql.Date;
import java.util.List;
import planningformen.domain.financeandefficiency.Sale;
import planningformen.domain.financeandefficiency.SalesNumbers;
import planningformen.domain.planning.Customer;
import planningformen.domain.planning.Sellable;

/**
 *
 * @author Simon
 */
public interface ISaleController
{
    public boolean createSale(String employeeID, String customerID, List<Sellable> sellables, double amountPaid);
    public boolean updateSale(Sale sale);
    public boolean deleteSale(Sale sale);
    public boolean printInvoice(Sale sale);
    public double paySale(Sale sale, double amountPaid);
    public List<Sale> findSales(Customer cust, Date fromDate, Date toDate);
    public List<Sale> findSales(int year);
    public double calculateTaxes(Sale sale);
    public double calculateTaxes(List<Sale> sales);
    public SalesNumbers generateYearlySales(int year);
    public List<Sellable> getAvailableSellables();
}
