/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.application;

import java.util.List;
import planningformen.domain.Master;
import planningformen.domain.financeandefficiency.Garage;
import planningformen.domain.financeandefficiency.Service;
import planningformen.domain.financeandefficiency.ServiceState;
import planningformen.domain.financeandefficiency.ServiceType;

/**
 *
 * @author Simon
 */
public class ServiceController implements IServiceController
{

    @Override
    public boolean createService(double price, String description, ServiceType type)
    {
        return Master.getInstance().getServiceManager().createService(price, description, type);
    }

    @Override
    public List<Service> findServicesByPrice(double minPrice, double maxPrice)
    {
        return Master.getInstance().getServiceManager().findServicesByPrice(minPrice, maxPrice);
    }

    @Override
    public List<Service> findServicesByType(ServiceType type)
    {
        return Master.getInstance().getServiceManager().findServicesByType(type);
    }

    @Override
    public List<Service> findServicesByTypes(ServiceType type1, ServiceType type2)
    {
        return Master.getInstance().getServiceManager().findServicesByTypes(type1, type2);
    }

    @Override
    public List<Service> findServicesByState(ServiceState state)
    {
        return Master.getInstance().getServiceManager().findServicesByState(state);
    }

    @Override
    public List<Service> findServicesByStates(ServiceState state1, ServiceState state2)
    {
        return Master.getInstance().getServiceManager().findServicesByStates(state1, state2);
    }

    @Override
    public List<Service> findServicesByTypeAndState(ServiceType type, ServiceState state)
    {
        return Master.getInstance().getServiceManager().findServicesByTypeAndState(type, state);
    }

    @Override
    public List<Service> findServicesBySaleID(String saleID)
    {
        return Master.getInstance().getServiceManager().findServicesBySaleID(saleID);
    }

    @Override
    public boolean updateService(Service updatedService)
    {
        return Master.getInstance().getServiceManager().updateService(updatedService);
    }

    @Override
    public boolean deleteService(Service serviceToDelete)
    {
        return Master.getInstance().getServiceManager().deleteService(serviceToDelete);
    }

    @Override
    public boolean startJob(Service serviceToStart, ServiceType garage)
    {
        return Master.getInstance().getServiceManager().startJob(serviceToStart, garage);
    }

    @Override
    public boolean finishJob(Service serviceToFinish, ServiceType garage)
    {
        return Master.getInstance().getServiceManager().finishJob(serviceToFinish, garage);
    }

    @Override
    public void planJobPriorityForMechanics()
    {
        Master.getInstance().getServiceManager().planJobPriorityForMechanics();
    }
    
    @Override //this is wrong, out of time.
    public Garage[] getGarages()
    {
        return Master.getInstance().getServiceManager().getGarages();
    }
    
    @Override //this is wrong, out of time.
    public List<Service> getFinishedJobs()
    {
        return Master.getInstance().getServiceManager().getFinishedServices();
    }

    @Override //this is wrong, out of time.
    public List<Service> getServices()
    {
        return Master.getInstance().getServiceManager().getServices();
    }
    
    
    
}
