/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.application;

import java.util.List;
import planningformen.domain.financeandefficiency.Garage;
import planningformen.domain.financeandefficiency.Service;
import planningformen.domain.financeandefficiency.ServiceState;
import planningformen.domain.financeandefficiency.ServiceType;

/**
 *
 * @author Simon
 */
public interface IServiceController
{
    public boolean createService(double price, String description, ServiceType type);
    public List<Service> findServicesByPrice(double minPrice, double maxPrice);
    public List<Service> findServicesByType(ServiceType type);
    public List<Service> findServicesByTypes(ServiceType type1, ServiceType type2);
    public List<Service> findServicesByState(ServiceState state);
    public List<Service> findServicesByStates(ServiceState state1, ServiceState state2);
    public List<Service> findServicesByTypeAndState(ServiceType type, ServiceState state);
    public List<Service> findServicesBySaleID(String saleID);
    public boolean updateService(Service updatedService);
    public boolean deleteService(Service serviceToDelete);
    public boolean startJob(Service serviceToStart, ServiceType garage);
    public boolean finishJob(Service serviceToFinish, ServiceType garage);
    public void planJobPriorityForMechanics();
    public Garage[] getGarages(); //this is wrong, out of time.
    public List<Service> getFinishedJobs(); //this is wrong, out of time.
    public List<Service> getServices(); //this is wrong, out of time.
}
