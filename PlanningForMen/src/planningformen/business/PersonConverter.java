package planningformen.business;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
public class PersonConverter implements ICallback
{
    private IOManager _ioManager;
    private List<Customer> _convertedCustomers;
    private List<Employee> _convertedEmployees;
    
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
        System.out.println("Retrieve customers!");
        _ioManager.getDBHandler().retrieveCustomers(this);
        return _convertedCustomers;
    }
    
    public boolean updateCustomer(Customer customer) //Possibly rename to something like updateCustomerInDB
    {
        return _ioManager.getDBHandler().updateCustomer(customer.getCustomerID(), customer.getId(), customer.getFirstName(), 
                                                        customer.getLastName(), customer.getAddress(), customer.getPhoneNumber(), 
                                                        customer.getPostalNumber(), customer.getEmail());
    }
    
    public boolean deletePerson(Person person)
    {
        boolean success = _ioManager.getDBHandler().deletePerson(person.getId());
        System.out.println("PersonConverter returns " + success);
        return success;
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
        _ioManager.getDBHandler().retrieveEmployees(this);
        
        return _convertedEmployees;
    }
    
    public boolean updateEmployee(Employee employee) //Possibly rename to something like updateEmployeeInDB
    {
        return _ioManager.getDBHandler().updateEmployee(employee.getEmployeeID(), employee.getId(), employee.getFirstName(), 
                                                        employee.getLastName(), employee.getAddress(), employee.getPhoneNumber(), 
                                                        employee.getPostalNumber(), employee.getEmail());
    }
 
    @Override
    public void extractValues(ResultSet rs) throws SQLException
    {
        rs.next();
        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println(rsmd.getColumnName(1) + "######");
        if(rsmd.getColumnName(1).contains("customer"))
            extractCostumerValues(rs);
        else if(rsmd.getColumnName(1).contains("employee"))
            extractEmployeeValues(rs);
    }
    
    private void extractCostumerValues(ResultSet rs) throws SQLException
    {
        _convertedCustomers = new ArrayList<Customer>();
        do
        {
            String custID = rs.getString(1);
            String personID = rs.getString(2);
            String fName = rs.getString(3);
            String lName = rs.getString(4);
            String address = rs.getString(5);
            String phoneNr = rs.getString(6);
            String postalNr = rs.getString(7);
            String email = rs.getString(8);
            _convertedCustomers.add(new Customer(custID, personID, fName, lName, address, phoneNr, postalNr, email));
        } while(rs.next());
        rs.close();
    }
    
    private void extractEmployeeValues(ResultSet rs) throws SQLException
    {
        _convertedEmployees = new ArrayList<Employee>();
        do
        {
            String empID = rs.getString(1);
            String personID = rs.getString(2);
            String fName = rs.getString(3);
            String lName = rs.getString(4);
            String address = rs.getString(5);
            String phoneNr = rs.getString(6);
            String postalNr = rs.getString(7);
            String email = rs.getString(8);
            _convertedEmployees.add(new Employee(empID, personID, fName, lName, address, phoneNr, postalNr, email));
        } while(rs.next());
        rs.close();
    }
}
