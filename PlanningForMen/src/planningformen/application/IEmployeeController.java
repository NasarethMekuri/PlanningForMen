/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.application;

import java.util.List;
import planningformen.domain.planning.Employee;

/**
 *
 * @author Simon
 */
public interface IEmployeeController
{
    public boolean createEmployee(String personID, String firstName, String lastName, String address, String phoneNumber,
            String postalNumber, String email, int skillType);
    
    public boolean updateEmployee(Employee employee);
    
    public List<Employee> findEmployees(String employeeID, String firstName, String lastName);
    
    public boolean deleteEmployee(Employee employee);
            
}
