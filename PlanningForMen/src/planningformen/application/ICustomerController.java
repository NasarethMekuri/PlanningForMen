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
    public boolean createCustomer(String id, String firstName, String lastName, String address, String phoneNumber, String postalNumber, String email);
    public List<Customer> findCustomers(String employeeID, String firstName, String lastName);
    public boolean updateCustomer(Customer customer);
    public boolean deleteCustomer(Customer customer);
}
