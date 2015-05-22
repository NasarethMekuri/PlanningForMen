/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen.domain.planning;

import java.util.ArrayList;
import java.util.List;
import planningformen.business.PersonConverter;

/**
 *
 * @author MKJ
 */
public class CustomerManager
{
    private static CustomerManager _instance;
    private List<Customer> _customers;
    private PersonConverter _personConverter;
    private CustomerManager()
    {
        //Populate List from DB
    }
    
    public static CustomerManager getInstance()
    {
        if(_instance == null)
            _instance = new CustomerManager();
        return _instance;
    }
    
    public boolean createCustomer(String id, String firstName, String lastName, String address, String phoneNumber, String postalNumber, String email)
    {
        //DB Stuff first
        _customers.add(new Customer(id, firstName, lastName, address, phoneNumber, postalNumber, email));
        return true;
    }
    
    public Customer findCustomer(String id)
    {
        Customer foundCustomer = null;
        for(Customer c : _customers)
        {
            if(c.getId().equals(id))
            {
                {
                    foundCustomer = c;
                    break;
                }
            }
        }
        return foundCustomer;
    }
    
    public List<Customer>findCustomers(String firstName, String lastName)
    {
        List<Customer> foundCustomers = new ArrayList<Customer>();
        
        for(Customer c : _customers)
        {
            if(c.getFirstName().equals(firstName) && c.getLastName().equals(lastName))
                foundCustomers.add(c);
        }
        return foundCustomers;
    }
    
    public List<Customer>findCustomers(String lastName)
    {
        List<Customer> foundCustomers = new ArrayList<Customer>();
        
        for(Customer c : _customers)
        {
            if(c.getLastName().equals(lastName))
                foundCustomers.add(c);
        }
        return foundCustomers;
    }
    
    public boolean updateCustomer(Customer customer)
    {
        //TODO: Update in database.
        for(Customer c : _customers)
        {
            if(c.getId().equals(customer.getId()))
            {
                c = customer;
                return true;
            }
        }
        return false;
    }
    
    public boolean deleteCustomer(Customer customer)
    {
        //TODO: Delete in Database
        return _customers.remove(customer);

    }
}
