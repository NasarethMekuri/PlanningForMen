package planningformen.application;

import java.util.ArrayList;
import java.util.List;
import planningformen.domain.Master;
import planningformen.domain.planning.Employee;
/**
  * @author MKJ
 */
public class EmployeeController implements IEmployeeController
{
    public boolean createEmployee(String personID, String firstName, String lastName, String address, String phoneNumber,
            String postalNumber, String email, int skillType)
    {
        return Master.getInstance().getEmployeeManager().createEmployee(personID.trim(), firstName.trim(), lastName.trim(), address.trim(), phoneNumber.trim(), 
                                                                        postalNumber.trim(), email.trim(), skillType);
    }
    
    public boolean updateEmployee(Employee employee)
    {
        return Master.getInstance().getEmployeeManager().updateEmployee(employee);
    }
    
    public List<Employee> findEmployees(String employeeID, String firstName, String lastName)
    {
        List<Employee> foundEmployees = new ArrayList<Employee>();
        if(employeeID.trim().length() > 0)
        {
            foundEmployees.add(Master.getInstance().getEmployeeManager().findEmployee(employeeID.trim()));
        }

        if(firstName.trim().length() > 0)
        {
            foundEmployees.addAll(Master.getInstance().getEmployeeManager().findEmployees(firstName.trim(), lastName.trim()));
            
        }
        
        if(lastName.trim().length() > 0)
        {
            foundEmployees.addAll(Master.getInstance().getEmployeeManager().findEmployees(lastName.trim()));
        }
        
        for(int i = 0; i < foundEmployees.size(); i++)
        {
            if(!foundEmployees.get(i).getEmployeeID().equals(employeeID.trim()))
            {
                foundEmployees.remove(i);
                i--;
                continue;
            }
            if(!foundEmployees.get(i).getLastName().equals(lastName.trim()) || !foundEmployees.get(i).getFirstName().equals(firstName.trim()))
            {
                foundEmployees.remove(i);
                i--;
                continue;
            }
            if(!foundEmployees.get(i).getLastName().equals(lastName.trim()))
            {
                foundEmployees.remove(i);
                i--;
                continue;
            }
        }
        return foundEmployees;
    }
    
    public boolean deleteEmployee(Employee employee)
    {
        return Master.getInstance().getEmployeeManager().deleteEmployee(employee);
    }
}
