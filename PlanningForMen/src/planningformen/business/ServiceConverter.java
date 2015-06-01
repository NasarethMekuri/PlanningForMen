/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen.business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import planningformen.domain.financeandefficiency.Service;
import planningformen.domain.financeandefficiency.ServiceState;
import planningformen.domain.financeandefficiency.ServiceType;
import planningformen.technical.IOManager;

/**
 *
 * @author Cymon343
 */
public class ServiceConverter implements ICallback
{
    private List<Service> _convertedServices;
    
    public ServiceConverter()
    {}
    
    public boolean createService(Service serviceToCreate)
    {
        return IOManager.getInstance().getDBHandler().createService(serviceToCreate.getId(), serviceToCreate.getSellPrice(), serviceToCreate.getDescription(),
                serviceToCreate.getType().getNumericValue(), serviceToCreate.getState().getNumericValue(), serviceToCreate.getGarageType().getNumericValue());
    }
    
    public List<Service> retrieveServices()
    {
        IOManager.getInstance().getDBHandler().retrieveServices(this);
        return _convertedServices;
    }
    
    
    @Override
    public void extractValues(ResultSet rs) throws SQLException
    {
        Service aService = null;
        _convertedServices = new ArrayList();
        
        ServiceType type = null;
        ServiceState state = null;
        ServiceType garage = null;
        
        
        while (rs.next())
        {
            
            switch (rs.getInt(4))
            {
                case 1:
                    type = ServiceType.DIESEL;
                    break;
                case 2:
                    type = ServiceType.NORMAL;
                    break;
                case 3:
                    type = ServiceType.TUNING;
                    break;
            }
            
            switch (rs.getInt(5))
            {
                case 1:
                    state = ServiceState.PENDING;
                    break;
                case 2:
                    state = ServiceState.RESERVED;
                    break;
                case 3:
                    state = ServiceState.STARTED;
                    break;
                case 4:
                    state = ServiceState.FINISHED;
                    break;
            }
            
            switch (rs.getInt(6))
            {
                case 1:
                    garage = ServiceType.DIESEL;
                    break;
                case 2:
                    garage = ServiceType.NORMAL;
                    break;
                case 3:
                    garage = ServiceType.TUNING;
                    break;
            }
            
            
            
            aService = new Service(
                    rs.getString(1),
                    rs.getDouble(2),
                    rs.getString(3),
                    type,
                    state,
                    garage);
            
            _convertedServices.add(aService);
        }
        
        rs.close();
    }
    
    
    public boolean updateService(Service serviceToUpdate)
    {
        return IOManager.getInstance().getDBHandler().updateService(serviceToUpdate.getId(), serviceToUpdate.getSellPrice(), serviceToUpdate.getDescription(),
                serviceToUpdate.getType().getNumericValue(), serviceToUpdate.getState().getNumericValue(), serviceToUpdate.getGarageType().getNumericValue());
    }
    
    
    public boolean deleteService(Service serviceToDelete)
    {
        return IOManager.getInstance().getDBHandler().deleteService(serviceToDelete.getId());
    }
    
    public Service convertServiceNumberToState(Service s, int state)
    {
        switch (state)
            {
                case 1:
                    s.setState(ServiceState.PENDING);
                    break;
                case 2:
                    s.setState(ServiceState.RESERVED);
                    break;
                case 3:
                    s.setState(ServiceState.STARTED);
                    break;
                case 4:
                    s.setState(ServiceState.FINISHED);
                    break;
            }
        return s;
    }
    
    public Service convertServiceNumberToType(Service s, int type)
    {
        switch (type)
        {
            case 1:
                s.setType(ServiceType.DIESEL);
                break;
            case 2:
                 s.setType(ServiceType.NORMAL);
                break;
            case 3:
                 s.setType(ServiceType.TUNING);
                break;
        }
        return s;
    }
}
