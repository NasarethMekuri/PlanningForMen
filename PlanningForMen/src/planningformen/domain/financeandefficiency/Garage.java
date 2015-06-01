/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen.domain.financeandefficiency;

import java.util.List;
import planningformen.domain.planning.Employee;

/**
 *
 * @author Simon
 */
public abstract class Garage
{
    protected ServiceType _type;
    protected List<Employee> _employees;
    protected List<Service> _jobs;
    
    
    
    public ServiceType getType()        {return _type;}
    public List<Employee> getEmployees(){return _employees;}
    public List<Service> getJobs()      {return _jobs;}
    
    public void setType(ServiceType _type)              {this._type = _type;}
    public void setEmployees(List<Employee> _employees) {this._employees = _employees;}
    public void setJobs(List<Service> _jobs)            {this._jobs = _jobs;}
}
