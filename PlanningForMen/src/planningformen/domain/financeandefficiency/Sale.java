/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.domain.financeandefficiency;

import java.sql.Date;
import planningformen.domain.planning.Customer;
import planningformen.domain.planning.Employee;

/**
 *
 * @author Simon
 */
public class Sale implements Transaction
{
    private String _id;
    private Employee _employee;
    private Customer _customer;
    private Date _dueDate, saleDate;
    private boolean _isPaid;
    private double _amountPaid, _tax;

    public Sale(Employee _employee, Customer _customer, Date _dueDate, Date saleDate, boolean _isPaid, double _amountPaid, double _tax)
    {
        this._employee = _employee;
        this._customer = _customer;
        this._dueDate = _dueDate;
        this.saleDate = saleDate;
        this._isPaid = _isPaid;
        this._amountPaid = _amountPaid;
        this._tax = _tax;
    }
    
    @Override
    public double getTotalPrice()
    {
        return 0.0;
    }
    
}
