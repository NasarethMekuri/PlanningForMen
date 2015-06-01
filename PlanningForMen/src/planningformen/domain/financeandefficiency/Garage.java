/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.domain.financeandefficiency;

import java.util.ArrayList;
import java.util.List;
import planningformen.domain.planning.Employee;

/**
 *
 * @author Simon
 */
public class Garage
{
    private ServiceType _type;
    private List<Employee> _employees;
    private List<Service> _jobs;

    public Garage(ServiceType _type)
    {
        this._type = _type;
        this._employees = new ArrayList<Employee>();
        this._jobs = new ArrayList<Service>();
    }
    
    

    public ServiceType getType()        {return _type;}
    public List<Employee> getEmployees(){return _employees;}
    public List<Service> getJobs()      {return _jobs;}
    
    public void setType(ServiceType _type)              {this._type = _type;}
    public void setEmployees(List<Employee> _employees) {this._employees = _employees;}
    public void setJobs(List<Service> _jobs)            {this._jobs = _jobs;}
    
    
}
