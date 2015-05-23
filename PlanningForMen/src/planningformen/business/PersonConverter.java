package planningformen.business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        Customer customer = null;
        try
        {
            if(rs.next())
            {
                String custID = rs.getString(1);
                String personID = rs.getString(2);
                String fName = rs.getString(3);
                String lName = rs.getString(4);
                String address = rs.getString(5);
                String phoneNr = rs.getString(6);
                String postalNr = rs.getString(7);
                String email = rs.getString(8);
                customer = new Customer(custID, personID, fName, lName, address, phoneNr, postalNr, email);
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
        }
        finally
        {
            try
            {
                rs.close();
            }
            catch(SQLException e)
            {
                System.out.println(e.getLocalizedMessage());
                      
            }
        }
        return customer;
    }
    
    public List<Customer> retrieveCustomers()
    {
        ResultSet rs = _ioManager.getDBHandler().retrieveCustomers();
        List<Customer> customers = new ArrayList<Customer>();
        try
        {
            while(rs.next())
            {
                String custID = rs.getString(1);
                String personID = rs.getString(2);
                String fName = rs.getString(3);
                String lName = rs.getString(4);
                String address = rs.getString(5);
                String phoneNr = rs.getString(6);
                String postalNr = rs.getString(7);
                String email = rs.getString(8);
                customers.add(new Customer(custID, personID, fName, lName, address, phoneNr, postalNr, email));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getLocalizedMessage());
        }
        finally
        {
            try
            {
                rs.close();
            }
            catch(SQLException e)
            {
                System.out.println(e.getLocalizedMessage());
                      
            }
        }
        return customers;
    }
    
    public boolean updateCustomer(Customer customer) //Possibly rename to something like updateCustomerInDB
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
