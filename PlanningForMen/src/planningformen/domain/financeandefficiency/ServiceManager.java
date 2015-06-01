/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen.domain.financeandefficiency;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import planningformen.business.ServiceConverter;

/**
 *
 * @author Simon
 */
public class ServiceManager
{
    private static ServiceManager _instance;
    private List<Service> _services, _finishedServices;
    private Garage[] _garages;
    private ServiceConverter _converter;
    
    private ServiceManager()
    {
        this._converter = new ServiceConverter();
        _services = _converter.retrieveServices();
        
        //TODO: AssignJobs...
        _garages = new Garage[3];
        _garages[0] = GarageFactory.getInstance().getGarage(ServiceType.DIESEL);
        _garages[1] = GarageFactory.getInstance().getGarage(ServiceType.NORMAL);
        _garages[2] = GarageFactory.getInstance().getGarage(ServiceType.TUNING);
        getPrioritizedJobsList();
    }
    
    //Accessor for single instance
    public static synchronized ServiceManager getInstance()
    {
        if (_instance == null)
        {
            _instance = new ServiceManager();
        }
        return _instance;
    }
    
    //Accessor for Services.
    public List<Service> getServices()  {return _services;}
    
    public boolean createService(double price, String description, ServiceType type)
    {
        //TODO: Creation in DB
        return _services.add(new Service(price, description, type)); //TODO: Flip on DB creation success
    }
    
    public List<Service> findServicesByPrice(double minPrice, double maxPrice)
    {
        List<Service> returnServices = new ArrayList();
        for (Service s : _services)
        {
            if (minPrice <= s.getSellPrice() && maxPrice >= s.getSellPrice())
            {
                returnServices.add(s);
            }
        }
        return returnServices;
    }
    
    public List<Service> findServicesByType(ServiceType type)
    {
        List<Service> returnServices = new ArrayList();
        for (Service s : _services)
        {
            if (type == s.getType()) //not sure about this
            {
                returnServices.add(s);
            }
        }
        return returnServices;
    }
    
    /**
     * Creates a List of Services that includes all type1 and type2 services.
     * @param type1
     * @param type2
     * @return returns a List of Services
     */
    public List<Service> findServicesByTypes(ServiceType type1, ServiceType type2)
    {
        List<Service> returnServices = new ArrayList();
        for (Service s : _services)
        {
            if (s.getType() == type1 || s.getType() == type2)
            {
                returnServices.add(s);
            }
        }
        return returnServices;
    }
    
    public List<Service> findServicesByState(ServiceState state)
    {
        List<Service> returnServices = new ArrayList();
        for (Service s : _services)
        {
            if (s.getState() == state)
            {
                returnServices.add(s);
            }
        }
        return returnServices;
    }
    
    public List<Service> findServicesByStates(ServiceState state1, ServiceState state2)
    {
        List<Service> returnServices = new ArrayList();
        for (Service s : _services)
        {
            if (s.getState()== state1 || s.getState()== state2)
            {
                returnServices.add(s);
            }
        }
        return returnServices;
    }
    
    public List<Service> findServicesByTypeAndState(ServiceType type, ServiceState state)
    {
        List<Service> returnServices = new ArrayList();
        for (Service s : _services)
        {
            if (s.getState() == state || s.getType() == type)
            {
                returnServices.add(s);
            }
        }
        return returnServices;
    }
    
    public boolean updateService(Service service)
    {
        //TODO: update in DB
        for (Service s : _services)
        {
            if (s.getId().equals(service.getId()))
            {
                s = service;
                return true;
            }
        }
        return false;
    }
    
    public boolean deleteService(Service service)
    {
        //TODO: delete in DB
        for (int i = 0; i < _services.size(); i++)
        {
            if (_services.get(i).getId().equals(service.getId()))
            {
                _services.remove(i);
                return true;
            }
        }
        return false;
    }
    
    public void getPrioritizedJobsList()
    {
        clearAllGarageJobLists(); //done
        removeFinishedJobs(); //done
        setReservedJobsToPending(); //done
        reAllocateStartedJobs(); //done
        allocateDieselJobs(); //done
        allocateNormalPendingJobs(); //done
        allocateTuningJobs(); //done
    }
    
    private void clearAllGarageJobLists()
    {
        for (int i = 0; i < _garages.length; i++)
        {
            _garages[i].getJobs().clear();
        }
    }
    
    private void removeFinishedJobs()
    {
        for (Service s : _services)
        {   //if service is finished move to finishedServices:
            if (s.getState().getNumericValue() == 4)
            {
                _finishedServices.add(s);
                _services.remove(s);
            }
        }
    }
    
    private void setReservedJobsToPending()
    {
        for (Service s : _services)
        {
            //if Service is reserved, set to pending
            if (s.getState().getNumericValue() == 2)
            {
                s.setState(ServiceState.PENDING);
                _converter.updateService(s); //Update Service in DB.
            }
        }
    }
    
    private void reAllocateStartedJobs()
    {
        for (Service s : _services)
        {
            if (s.getState() == ServiceState.STARTED)
            {
                switch (s.getGarageType().getNumericValue())
                {
                    case 1:
                        _garages[0].getJobs().add(s);
                        break;
                    case 2:
                        _garages[1].getJobs().add(s);
                        break;
                    case 3:
                        _garages[2].getJobs().add(s);
                        break;
                }
            }
        }
    }
    
    private void allocateDieselJobs()
    {
        for (Service s : _services)
        {   //if Diesel
            if (s.getType().getNumericValue() == 1)
            {
                _garages[0].getJobs().add(s);
                s.setState(ServiceState.RESERVED);
                s.setGarageType(ServiceType.DIESEL);
                _converter.updateService(s);
            }
        }
    }
    
    private void allocateNormalPendingJobs()
    {
        List<Service> pendingNormalJobs = getNormalPendingJobs(); //Retrieve all normal pending jobs from the list into a Linked List.
        
        int pendingNormalJobsLeft = pendingNormalJobs.size(); //Count Normal Pending jobs.
        int totalEmployees = getEmployeeCount(); //Count all employees in all garages.
                
        int[] temp = getJobPrEmployee(pendingNormalJobsLeft, totalEmployees); //retrieve numbers of Services(jobs) pr. Employee at index 0, and the remainder at index 1.
        int jobPrEmp = temp[0];
        
        //Define number of jobs for each garage.
        int jobsForDieselGarage = jobPrEmp * _garages[0].getEmployees().size();
        int jobsForNormalGarage = jobPrEmp * _garages[1].getEmployees().size();
        int jobsForTuningGarage = jobPrEmp * _garages[2].getEmployees().size();
        
        //Add jobs to Diesel Garage
        for (int i = 0; i < jobsForDieselGarage; i++)
        {
            _garages[0].getJobs().add(pendingNormalJobs.get(0));
            pendingNormalJobs.remove(0);
        }
        //Add jobs to Normal Garage
        for (int i = 0; i < jobsForNormalGarage; i++)
        {
            _garages[1].getJobs().add(pendingNormalJobs.get(0));
            pendingNormalJobs.remove(0);
        }
        //Add jobs to Tuning Garage
        for (int i = 0; i < jobsForTuningGarage; i++)
        {
            _garages[2].getJobs().add(pendingNormalJobs.get(0));
            pendingNormalJobs.remove(0);
        }
        
        int jobsLeft = temp[1]; //Number of jobs left
        int counter = 0; //this is used to switch between the 3 garages, to give them an even split of the remainding jobs.
        for (int i = 0; i < jobsLeft; i++)
        {
            _garages[counter].getJobs().add(pendingNormalJobs.get(0)); 
            pendingNormalJobs.remove(0);
            counter++;
            if (counter >= _garages.length)
            {
                counter = 0;
            }
        }
    }
    
    private void allocateTuningJobs()
    {
        for (Service s : _services)
        {
            if (s.getType().getNumericValue() == 3)
            {
                _garages[2].getJobs().add(s);
                s.setState(ServiceState.RESERVED);
                s.setGarageType(ServiceType.TUNING);
            }
        }
    }
          
    private List<Service> getNormalPendingJobs()
    {
        List<Service> temp = new LinkedList<Service>();
        
        for (Service s : _services)
        {   //if pending && Normal
            if (s.getState().getNumericValue() == 1 && s.getType().getNumericValue() == 2)
            {
                temp.add(s);
            }
        }
        return temp;
    }
    
     private int getEmployeeCount()
    {
        int employees = 0;
        for (Garage g : _garages)
        {
            employees += g.getEmployees().size();
        }
        return employees;
    }
     
      private int[] getJobPrEmployee(int pendingNormalJobsLeft, int totalEmployees)
    {
        int[] temp = new int[2];
        
        temp[0] = pendingNormalJobsLeft / totalEmployees;
        temp[1] = pendingNormalJobsLeft % totalEmployees;
        
        return temp;
    }
     
    public ServiceState getServiceStateFromInt(Service s, int state)
    {
        return _converter.convertToServiceStateFromInt(s, state);
    }
    
    public ServiceType getServiceTypeFromInt(Service s, int state)
    {
        return _converter.convertToServiceTypeFromInt(s, state);
    }
}
