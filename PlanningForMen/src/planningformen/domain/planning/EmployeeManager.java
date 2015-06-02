/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen.domain.planning;

import java.util.ArrayList;
import java.util.List;
import planningformen.business.PersonConverter;
import planningformen.domain.financeandefficiency.ServiceManager;

/**
 *
 * @author Morten
 */
public class EmployeeManager
{
    private static EmployeeManager _instance;
    private List<Employee> _employees;
    private PersonConverter _personConverter;
    
    public List<Employee> getEmployees() { return _employees; }
    
    private EmployeeManager()
    {
        _personConverter = new PersonConverter();
        _employees = retrieveEmployees();
    }
    
    public static EmployeeManager getInstance()
    {
        if(_instance == null)
            _instance = new EmployeeManager();
        return _instance;
    }
    
    public boolean createEmployee(String id, String firstName, String lastName, String address, String phoneNumber,
            String postalNumber, String email, int skillType)
    {
        Employee tmpEmployee = new Employee(id, firstName, lastName, address, phoneNumber, postalNumber, email, skillType);
        if(_personConverter.createEmployee(tmpEmployee))
        {
            _employees.add(tmpEmployee);
            return true;
        }
        return false;
    }
    
    public List<Employee> retrieveEmployees()
    {
        return _personConverter.retrieveEmployees();
    }
    
    public Employee findEmployee(String empID)
    {
        Employee foundEmployee = null;
        for(Employee c : _employees)
        {
            if(c.getEmployeeID().equals(empID))
            {
                {
                    foundEmployee = c;
                    break;
                }
            }
        }
        return foundEmployee;
    }
    
    public List<Employee>findEmployees(String firstName, String lastName)
    {
        List<Employee> foundEmployees = new ArrayList<Employee>();
        
        for(Employee c : _employees)
        {
            if(c.getFirstName().equals(firstName) && c.getLastName().equals(lastName))
                foundEmployees.add(c);
        }
        return foundEmployees;
    }
    
    public List<Employee>findEmployees(String lastName)
    {
        List<Employee> foundEmployees = new ArrayList<Employee>();
        
        for(Employee c : _employees)
        {
            if(c.getLastName().equals(lastName))
                foundEmployees.add(c);
        }
        return foundEmployees;
    }
    
    public boolean updateEmployee(Employee employee)
    {
        if(_personConverter.updateEmployee(employee))
        {
            for(int i = 0; i < _employees.size(); i++)
            {
                if(_employees.get(i).getId().equals(employee.getId()))
                {
                    _employees.set(i, employee);
                    return true;
                }
            }
        }
        return false; //Look into this. Slightly error prone. If the employee is not in the list, the DB may still be updated, and we return false.
    }
    
    public boolean deleteEmployee(Employee employee)
    {
        if(_personConverter.deletePerson(employee))
        {
            return _employees.remove(employee); //Look into this - Same as above. May return false, even though database was updated, in case remove returns false.
        }
        return false;
    }
    
    public boolean addEmployeeToGarage(Employee employee)
    {
        ServiceManager sm = ServiceManager.getInstance(); 
        for(int i = 0; i < sm.getGarages().length; i++) 
        {
            if(sm.getGarages()[i].getType().getNumericValue() == employee.getSkillType())
            {
                sm.getGarages()[i].getEmployees().add(employee);
                return true;
            }
        }
        return false;
    }
    
    public boolean removeEmployeeFromGarage(Employee employee)
    {
        for(int i = 0; i < ServiceManager.getInstance().getGarages().length; i++)
        {
            if(ServiceManager.getInstance().getGarages()[i].getType().getNumericValue() == employee.getSkillType())
            {
                ServiceManager.getInstance().getGarages()[i].getEmployees().remove(employee);
                return true;
            }
        }
        return false;
    }
    
    public void addAllEmployeesToGarage()
    {
        for(Employee e : _employees)
        {
            addEmployeeToGarage(e);
        }
    }
}
