/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.application;

import java.util.List;
import planningformen.domain.planning.Customer;

/**
 *
 * @author Simon
 */
public interface ICustomerController
{
    public boolean createCustomer(String id, String firstName, String lastName, String address, String phoneNumber, String email);
    public Customer findCustomer(String custID);
    public List<Customer> findCustomers (String firstName, String lastName);
    public List<Customer> findCustomers (String lastName);
    public boolean updateCustomer(Customer customer);
    public boolean deleteCustomer(Customer customer);
}
