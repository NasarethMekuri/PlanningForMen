/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.application;

import java.util.List;
import planningformen.domain.planning.Customer;
import planningformen.domain.Master;

/**
 *
 * @author Simon
 */
public class CustomerController implements ICustomerController
{

    @Override
    public boolean createCustomer(String id, String firstName, String lastName, String address, String phoneNumber, String postalNumber, String email)
    {
        return Master.getInstance().getCustomerManager().createCustomer(id.trim(), firstName.trim(), lastName.trim(), address.trim(),
                                                                        phoneNumber.trim(), postalNumber.trim(), email.trim());
    }

    @Override
    public Customer findCustomer(String custID)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Customer> findCustomers(String firstName, String lastName)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Customer> findCustomers(String lastName)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCustomer(Customer customer)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteCustomer(Customer customer)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
