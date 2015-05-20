/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen.domain.planning;

import java.util.List;

/**
 *
 * @author Simon
 */
public class CustomerManager
{
    private static CustomerManager _instance;
    private List<Customer> _customers;
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
    
    public void createCustomer(String id, String firstName, String lastName, String phoneNumber, String postalNumber, String email)
    {
        
    }
    
    public void findCustomer(String id, String firstName, String lastName, String phoneNumber, String postalNumber, String email)
    {
        
    }
    
    public void updateCustomer(String id, String firstName, String lastName, String phoneNumber, String postalNumber, String email)
    {
        
    }
    
    public void delteCustomer(String id, String firstName, String lastName, String phoneNumber, String postalNumber, String email)
    {
        
    }
}
