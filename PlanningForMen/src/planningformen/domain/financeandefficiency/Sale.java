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
public class Sale implements Transaction
{
    private String _id;
    private Employee _employee;
    private Customer _customer;
    private Date _dueDate, _saleDate;
    private boolean _isPaid;
    private double _amountPaid, _tax;
    private List<Sellable> _items;

    public Sale(String id, Employee employee, Customer customer, List<Sellable> items, Date dueDate, Date saleDate, double amountPaid, double tax)
    {
        _id = id;
        _employee = employee;
        _customer = _customer;
        _items = items;
        _dueDate = _dueDate;
        _saleDate = saleDate;
        _amountPaid = _amountPaid;
        _tax = _tax;
        _isPaid = amountPaid >= getTotalPrice();
    }
     
    @Override
    public double getTotalPrice()
    {
        double totalPrice = 0;
        
        for(Sellable s : _items)
        {
            totalPrice += s.getSellPrice();
        }
        return totalPrice;
    }

    public String getId() { return _id; }
    public Employee getEmployee() { return _employee; }
    public Customer getCustomer() { return _customer;  }
    public Date getDueDate() { return _dueDate; }
    public double getAmountPaid() { return _amountPaid; }
    public boolean IsPaid() { return _isPaid; }
    public double getTax() { return _tax; }
    public List<Sellable> getItems() { return _items; }
    
    public void setCustomer(Customer customer) { _customer = customer; }
    public void setDueDate(Date dueDate) { _dueDate = dueDate; }
    public Date getSaleDate() { return _saleDate; }
    public void setSaleDate(Date saleDate) {_saleDate = saleDate; }
    public void setIsPaid(boolean isPaid) {_isPaid = isPaid; }
    public void setTax(double tax) {_tax = tax; }
    public void setEmployee(Employee employee) {_employee = employee; }
    
    public void setAmountPaid(double amountPaid)
    {
        _amountPaid = amountPaid; 
        if(_amountPaid >= getTotalPrice())
            _isPaid = true;
    }
}


