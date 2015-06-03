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
import planningformen.domain.planning.EmployeeManager;

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
        _finishedServices = new ArrayList<>();
        _garages = new Garage[3];
        _garages[0] = GarageFactory.getInstance().getGarage(ServiceType.DIESEL);
        _garages[1] = GarageFactory.getInstance().getGarage(ServiceType.NORMAL);
        _garages[2] = GarageFactory.getInstance().getGarage(ServiceType.TUNING);
    }
    
    //Accessor for single instance
    public static synchronized ServiceManager getInstance()
    {
        if (_instance == null)
        {
            _instance = new ServiceManager();
            EmployeeManager.getInstance().addAllEmployeesToGarage(); //This has to happen after the instanciation of ServiceManager!
            _instance.getPrioritizedJobsList(); //This has to happen after the instanciation of ServiceManager!
            
        }
        return _instance;
    }
    
    //Accessors
    public List<Service> getServices()  {return _services;}
    public List<Service> getFinishedServices()  {return _finishedServices;}
    public Garage[] getGarages()    {return _garages;}
    
    
    
    public boolean createService(double price, String description, ServiceType type)
    {
        Service service = new Service(price, description, type);
        if(_converter.createService(service))
            return _services.add(service); //TODO: Flip on DB creation success
        return false;
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
    
    public List<Service> findServicesBySaleID(String saleID)
    {
        List<Service> services = new ArrayList<Service>();
        
        for(Service s : _services)
        {
            if(s.getSaleID() == null)
                continue;
            if(s.getSaleID().equals(saleID))
                services.add(s);
        }
        return services;
    }
    
    public boolean updateService(Service updatedService) //TODO: Re-test!
    {   
        for (Service s : _services)
        {
            if (s.getId().equals(updatedService.getId()))
            {
                if (_converter.updateService(updatedService)) 
                {
                    s = updatedService;
                }
                
                return true;
            }
        }
        return false;
    }
    
    public boolean deleteService(Service serviceToDelete) //TODO: Re-test!
    {
        for (int i = 0; i < _services.size(); i++)
        {
            if (_services.get(i).getId().equals(serviceToDelete.getId()))
            {
                if (_converter.deleteService(serviceToDelete))
                {
                    _services.remove(i);
                }
                return true;
            }
        }
        return false;
    }
    
    public boolean startJob(Service serviceToStart, ServiceType garage)
    {
        for (Service s : _services)
        {
            if (serviceToStart.getId().equals(s.getId()))
            {
                s.setState(ServiceState.STARTED);
                s.setGarageType(garage);
                return _converter.updateService(s); //which one?
            }
        }
        return false;
    }
    
    public boolean finishJob(Service serviceToFinish, ServiceType garage)
    {
        for (Service s : _services)
        {
            if (serviceToFinish.getId().equals(s.getId()))
            {
                s.setState(ServiceState.FINISHED);
                _services.remove(s);
                getFinishedServices().add(s);
                return _converter.updateService(s); //which one?
            }
        }
        return false;
    }
    
    public void getPrioritizedJobsList()
    {
        clearAllGarageJobLists();
        removeFinishedJobs(); //Should be unnessecary
        setReservedJobsToPending();
        reAllocateStartedJobs();
        allocateDieselJobs();
        allocateNormalPendingJobs();
        allocateTuningJobs();
        updateServicesInDB();
    }
    
    private void clearAllGarageJobLists()
    {
        for (int i = 0; i < getGarages().length; i++)
        {
            getGarages()[i].getJobs().clear();
        }
    }
    
    private void removeFinishedJobs() //Should not be neccesary?
    {
        for (int i = 0; i < _services.size(); i++) //ISSUE--> MUST NOT CHANGE SIZE OF _services WHILE USING ITERATOR!
        {   //if service is finished move to finishedServices:
            if (_services.get(i).getState().getNumericValue() == 4)
            {
                getFinishedServices().add(_services.get(i));
                _services.remove(_services.get(i));
                i--;
            }
        }
    }
    
    private void setReservedJobsToPending()
    {
        for (Service s : _services)
        {
            //if Service is reserved, set to pending and set GarageType to null
            if (s.getState().getNumericValue() == 2)
            {
                s.setState(ServiceState.PENDING);
                s.setGarageType(null);
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
                        getGarages()[0].getJobs().add(s);
                        break;
                    case 2:
                        getGarages()[1].getJobs().add(s);
                        break;
                    case 3:
                        getGarages()[2].getJobs().add(s);
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
                getGarages()[0].getJobs().add(s);
                s.setState(ServiceState.RESERVED);
                s.setGarageType(ServiceType.DIESEL);
            }
        }
    }
    
    private void allocateNormalPendingJobs()
    {
        List<Service> pendingNormalJobs = getNormalPendingJobs(); //Retrieve all normal pending jobs from the list into a Linked List.
        
        int pendingNormalJobsLeft = pendingNormalJobs.size(); //Count Normal Pending jobs.
        int totalEmployees = getEmployeeCount(); //Count all employees in all garages.
        
        //Calculate number of jobs each employee should have evenly
        int[] temp = getJobPrEmployee(pendingNormalJobsLeft, totalEmployees); //retrieve numbers of Services(jobs) pr. Employee at index 0, and the remainder at index 1.
        int jobPrEmp = temp[0];
        
        //Define number of jobs for each garage based on number of employees at that garage.
        int jobsForDieselGarage = jobPrEmp * getGarages()[0].getEmployees().size();
        int jobsForNormalGarage = jobPrEmp * getGarages()[1].getEmployees().size();
        int jobsForTuningGarage = jobPrEmp * getGarages()[2].getEmployees().size();
        
        //Add jobs to Diesel Garage
        for (int i = 0; i < jobsForDieselGarage; i++)
        {
            getGarages()[0].getJobs().add(pendingNormalJobs.get(0));
            pendingNormalJobs.get(0).setState(ServiceState.RESERVED);
            pendingNormalJobs.get(0).setGarageType(ServiceType.DIESEL);
            pendingNormalJobs.remove(0);
        }
        //Add jobs to Normal Garage
        for (int i = 0; i < jobsForNormalGarage; i++)
        {
            getGarages()[1].getJobs().add(pendingNormalJobs.get(0));
            pendingNormalJobs.get(0).setState(ServiceState.RESERVED);
            pendingNormalJobs.get(0).setGarageType(ServiceType.NORMAL);
            pendingNormalJobs.remove(0);
        }
        //Add jobs to Tuning Garage
        for (int i = 0; i < jobsForTuningGarage; i++)
        {
            getGarages()[2].getJobs().add(pendingNormalJobs.get(0));
            pendingNormalJobs.get(0).setState(ServiceState.RESERVED);
            pendingNormalJobs.get(0).setGarageType(ServiceType.TUNING);
            pendingNormalJobs.remove(0);
        }
        
        int jobsLeft = temp[1]; //Number of leftOver jobs
        int counter = 0; //this is used to switch between the 3 garages, to give them an even split of the remainding jobs.
        ServiceType tempGarageType = null;
        for (int i = 0; i < jobsLeft; i++)
        {
            tempGarageType = getServiceTypeFromInt(counter + 1);
            
            getGarages()[counter].getJobs().add(pendingNormalJobs.get(0));
            
            pendingNormalJobs.get(0).setState(ServiceState.RESERVED);
            pendingNormalJobs.get(0).setGarageType(tempGarageType);
            
            pendingNormalJobs.remove(0);
            counter++;
            if (counter >= getGarages().length -1) //counter must max be 2 (_garages.length is 3)
            {
                counter = 0;
            }
        }
    }
    
    private void allocateTuningJobs()
    {
        for (Service s : _services)
        {   //If type is tuning...
            if (s.getType().getNumericValue() == 3)
            {
                getGarages()[2].getJobs().add(s);
                s.setState(ServiceState.RESERVED);
                s.setGarageType(ServiceType.TUNING);
            }
        }
    }
    
    private List<Service> getNormalPendingJobs()
    {
        List<Service> pendingNormalJobsLeft = new LinkedList<Service>();
        
        for (Service s : _services)
        {   //if pending && Normal
            if (s.getState().getNumericValue() == 1 && s.getType().getNumericValue() == 2)
            {
                pendingNormalJobsLeft.add(s);
            }
        }
        return pendingNormalJobsLeft;
    }
    
    private int getEmployeeCount()
    {
        int employees = 0;
        for (Garage g : getGarages())
        {
            employees += g.getEmployees().size();
        }
        return employees;
    }
    
    private int[] getJobPrEmployee(int pendingNormalJobsLeft, int totalEmployees)
    {
        int[] temp = new int[2];
        
        if (totalEmployees != 0)
        {
            temp[0] = pendingNormalJobsLeft / totalEmployees;
            temp[1] = pendingNormalJobsLeft % totalEmployees;
        }
        else
        {
            System.out.println("Mads is out of business! -He has no employees!");
        }
        
        return temp;
    }
    
    private void updateServicesInDB()
    {
        for (Service s : _services)
        {
            _converter.updateService(s);
        }
        
        if (!_finishedServices.isEmpty())
        {
            for (Service s : getFinishedServices())
            {
                _converter.updateService(s);
            }
        }
        
    }
    
    public ServiceState getServiceStateFromInt(int state)
    {
        return _converter.convertToServiceStateFromInt(state);
    }
    
    public ServiceType getServiceTypeFromInt(int state)
    {
        return _converter.convertToServiceTypeFromInt(state);
    }
    
    
    
    
}
