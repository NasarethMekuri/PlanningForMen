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
    private List<Service> _services;
    private int[] _garages;
    private ServiceConverter _converter;
    
    private ServiceManager()
    {
        
        this._converter = new ServiceConverter();
        _services = _converter.retrieveServices();
        
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
            if (minPrice <= s.getPrice() && maxPrice >= s.getPrice())
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
}
