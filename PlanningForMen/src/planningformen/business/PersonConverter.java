/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.business;

import java.sql.ResultSet;
import java.util.List;
import planningformen.domain.planning.Customer;
import planningformen.technical.IOManager;

/**
 *
 * @author MKJ
 */
public class PersonConverter
{
    private IOManager _ioManager;
    
    public PersonConverter()
    {
        _ioManager = IOManager.getInstance();
    }
    
    //Customers
    public boolean createCustomer(Customer customer) //Possibly rename to something like sendCustomerToDB
    {
        return _ioManager.getDBHandler().createCustomer(customer.getCustomerID(), customer.getId(), customer.getFirstName(), 
                                                        customer.getLastName(), customer.getAddress(), customer.getPhoneNumber(), 
                                                        customer.getPostalNumber(), customer.getEmail());
    }
    
    public Customer retrieveCustomer(String customerID)
    {
        ResultSet rs = _ioManager.getDBHandler().retrieveCustomer(customerID);
        //TODO: convert RS to a customer and return it.
        return null;
    }
    
    public List<Customer> retrieveCustomers()
    {
        ResultSet rs = _ioManager.getDBHandler().retrieveCustomers();
        //TODO: Convert rs to customer list and return it.
        return null;
    }
    
    public boolean updateCustomer(Customer customer) //Possibly renamte to something like updateCustomerInDB
    {
        return _ioManager.getDBHandler().updateCustomer(customer.getCustomerID(), customer.getId(), customer.getFirstName(), 
                                                        customer.getLastName(), customer.getAddress(), customer.getPhoneNumber(), 
                                                        customer.getPostalNumber(), customer.getEmail());
    }
    
    public boolean deleteCustomer(Customer customer)
    {
        return _ioManager.getDBHandler().deleteCustomer(customer.getCustomerID());
    }
    
    //Employees
}
