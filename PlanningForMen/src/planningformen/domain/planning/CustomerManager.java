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
    
    public List<Customer> getCustomers() {return _customers; }
   
    private CustomerManager()
    {
        _personConverter = new PersonConverter();
        _customers = retrieveCustomers();
        System.out.println("CustomerManager constructor!");
    }
    
    public static CustomerManager getInstance()
    {
        if(_instance == null)
            _instance = new CustomerManager();
        return _instance;
    }
    
    public boolean createCustomer(String id, String firstName, String lastName, String address, String phoneNumber, String postalNumber, String email)
    {
        Customer tmpCustomer = new Customer(id, firstName, lastName, address, phoneNumber, postalNumber, email);
        if(_personConverter.createCustomer(tmpCustomer))
        {
            _customers.add(tmpCustomer);
            return true;
        }
        return false;
    }
    
    public List<Customer> retrieveCustomers() //@MKJ -> Skal den ikke være private? eller være getter for _customers?
    {
        return _personConverter.retrieveCustomers();
    }
    
    public Customer findCustomer(String custID)
    {
        Customer foundCustomer = null;
        for(Customer c : _customers)
        {
            if(c.getCustomerID().equals(custID))
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
        if(_personConverter.updateCustomer(customer))
        {
            for(int i = 0; i < _customers.size(); i++)
            {
                if(_customers.get(i).getId().equals(customer.getId()))
                {
                    _customers.set(i, customer);
                    return true;
                }
            }
        }
        return false; //Look into this. Slightly error prone. If the customer is not in the list, the DB may still be updated, and we return false.
    }
    
    public boolean deleteCustomer(Customer customer)
    {
        if(_personConverter.deletePerson(customer))
            return _customers.remove(customer); //Look into this - Same as above. May return false, even though database was updated, in case remove returns false.
        return false; 
    }
}
