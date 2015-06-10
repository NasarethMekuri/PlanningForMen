/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.application;

import java.util.ArrayList;
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
    public List<Customer> findCustomers(String customerID, String firstName, String lastName)
    {
        List<Customer> foundCustomers = new ArrayList<Customer>();
        if(customerID.trim().length() > 0)
        {
            foundCustomers.add(Master.getInstance().getCustomerManager().findCustomer(customerID.trim()));
        }
        if(firstName.trim().length() > 0 && lastName.trim().length() > 0)
        {
            foundCustomers.addAll(Master.getInstance().getCustomerManager().findCustomers(firstName.trim(), lastName.trim()));
        }
        if(lastName.trim().length() > 0)
        {
            foundCustomers.addAll(Master.getInstance().getCustomerManager().findCustomers(lastName.trim()));
        }
        for(int i = 0; i < foundCustomers.size(); i++)
        {
            if(!foundCustomers.get(i).getCustomerID().equals(customerID.trim()) && customerID.trim().length() > 0)
            {
                foundCustomers.remove(i);
                i--;
                continue;
            }
            if(firstName.trim().length() > 0 && lastName.trim().length() > 0)
            {
                if(!foundCustomers.get(i).getLastName().equals(lastName.trim()) || !foundCustomers.get(i).getFirstName().equals(firstName.trim()))
                {
                    foundCustomers.remove(i);
                    i--;
                    continue;
                }
            }
            if(!foundCustomers.get(i).getLastName().equals(lastName.trim()) && lastName.trim().length() > 0)
            {
                foundCustomers.remove(i);
                i--;
                continue;
            }
        }
        
        //Remove Duplicates
        for(int i = 0; i < foundCustomers.size(); i++)
        {
            for(int j = i + 1; j < foundCustomers.size(); j++)
            {
                if(foundCustomers.get(i).equals(foundCustomers.get(j)))
                {
                    foundCustomers.remove(j);
                    j--;
                }
            }
        }
        return foundCustomers;
    }

    @Override
    public boolean updateCustomer(Customer customer)
    {
        return Master.getInstance().getCustomerManager().updateCustomer(customer);
    }

    @Override
    public boolean deleteCustomer(Customer customer)
    {
        return Master.getInstance().getCustomerManager().deleteCustomer(customer);
    }
    
}
