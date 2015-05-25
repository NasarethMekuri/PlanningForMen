package planningformen.business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import planningformen.domain.planning.Customer;
import planningformen.domain.planning.Employee;
import planningformen.domain.planning.Person;
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
    
    public boolean deletePerson(Person person)
    {
        return _ioManager.getDBHandler().deletePerson(person.getId());
    }
    
    //Employees
    public boolean createEmployee(Employee employee) //Possibly rename to something like sendEmployeeToDB
    {
        return _ioManager.getDBHandler().createEmployee(employee.getEmployeeID(), employee.getId(), employee.getFirstName(), 
                                                        employee.getLastName(), employee.getAddress(), employee.getPhoneNumber(), 
                                                        employee.getPostalNumber(), employee.getEmail());
    }
    
    public List<Employee> retrieveEmployees()
    {
        ResultSet rs = _ioManager.getDBHandler().retrieveEmployees();
        List<Employee> employees = new ArrayList<Employee>();
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
                employees.add(new Employee(custID, personID, fName, lName, address, phoneNr, postalNr, email));
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
        return employees;
    }
    
    public boolean updateEmployee(Employee employee) //Possibly rename to something like updateEmployeeInDB
    {
        return _ioManager.getDBHandler().updateEmployee(employee.getEmployeeID(), employee.getId(), employee.getFirstName(), 
                                                        employee.getLastName(), employee.getAddress(), employee.getPhoneNumber(), 
                                                        employee.getPostalNumber(), employee.getEmail());
    }
}
