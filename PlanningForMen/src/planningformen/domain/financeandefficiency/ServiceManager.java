/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen.domain.financeandefficiency;

import java.util.ArrayList;
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
        handleStates(); //done
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
    
    private void handleStates()
    {
        for (Service s : _services)
        {   //if service is finished move to finishedServices:
            if (s.getState().getNumericValue() == 4)
            {
                _finishedServices.add(s);
                _services.remove(s);
            }
            //if Service is reserved, set to pending
            else if (s.getState().getNumericValue() == 2)
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
            }
        }
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
    
    private List<Service> getNormalJobsinServices()
    {
        List<Service> temp = new ArrayList<>();
        
        
        for (Service s : _services)
        {   //if pending && Normal
            if (s.getState().getNumericValue() == 1 && s.getType().getNumericValue() == 2)
            {
                temp.add(s);
            }
            
        }
        return temp;
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
    
    public Service setServiceState(Service s, int state)
    {
        return _converter.convertServiceNumberToState(s, state);
    }
    
    public Service setServiceType(Service s, int state)
    {
        return _converter.convertServiceNumberToType(s, state);
    }
    
    private int[] getJobPrEmployee(int pendingNormalJobsLeft, int totalEmployees)
    {
        int[] temp = new int[2];
        
        temp[0] = pendingNormalJobsLeft / totalEmployees;
        temp[1] = pendingNormalJobsLeft % totalEmployees;
        
        return temp;
    }
    
    private void allocateNormalPendingJobs()
    {
        int totalEmployees = getEmployeeCount();
        List<Service> pendingNormalJobs = getNormalJobsinServices();
        int pendingNormalJobsLeft = pendingNormalJobs.size();
        
        int[] temp = getJobPrEmployee(pendingNormalJobsLeft, totalEmployees);
        int jobPrEmp = temp[0];
        
        int jobsForDieselGarage = jobPrEmp * _garages[0].getEmployees().size();
        int jobsForNormalGarage = jobPrEmp * _garages[1].getEmployees().size();
        int jobsForTuningGarage = jobPrEmp * _garages[2].getEmployees().size();
        
        
        for (int i = 0; i < jobsForDieselGarage; i++)
        {
            _garages[0].getJobs().add(pendingNormalJobs.get(0));
            pendingNormalJobs.remove(0);
        }
        
        for (int i = 0; i < jobsForNormalGarage; i++)
        {
            _garages[1].getJobs().add(pendingNormalJobs.get(0));
            pendingNormalJobs.remove(0);
        }
        
        for (int i = 0; i < jobsForTuningGarage; i++)
        {
            _garages[2].getJobs().add(pendingNormalJobs.get(0));
            pendingNormalJobs.remove(0);
        }
        
        int jobsLeft = temp[1];
        int counter = 0;
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
    
    
    
    
    
    
    
    
}
