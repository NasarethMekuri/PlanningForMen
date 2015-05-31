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
import planningformen.domain.planning.Car;
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
    
    public boolean createService(Car carToCreate)
    {
        return IOManager.getInstance().getDBHandler().createCar(carToCreate.getId(), carToCreate.getPlate(), carToCreate.getYear(), carToCreate.getMake(), carToCreate.getModel(),
                carToCreate.getVolume(), carToCreate.getFuel(), carToCreate.getVersion(), carToCreate.getOdometer(),
                carToCreate.getPurchaseDate(), carToCreate.getPurchasePrice(), carToCreate.getSellPrice(), carToCreate.getDescription(),
                carToCreate.isInStock());
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
        
        while (rs.next())
        {
            ServiceState state = null; 
            ServiceType type = null;
            ServiceType garage = null;
                    
            
                    
            aService = new Service(
                    rs.getString(1),
                    rs.getDouble(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getInt(6),
                    rs.getInt(7);
            
            _convertedCars.add(aCar);
        }
        
        rs.close();
    }
    
    
    public boolean updateCar(Car carToUpdate)
    {
        return IOManager.getInstance().getDBHandler().updateCar(carToUpdate.getId(), carToUpdate.getPlate(), carToUpdate.getYear(), carToUpdate.getMake(), carToUpdate.getModel(),
                carToUpdate.getVolume(), carToUpdate.getFuel(), carToUpdate.getVersion(), carToUpdate.getOdometer(),
                carToUpdate.getPurchaseDate(), carToUpdate.getPurchasePrice(), carToUpdate.getSellPrice(), carToUpdate.getDescription(),
                carToUpdate.isInStock());
    }
    
    
    public boolean deleteCar(Car carToDelete)
    {
        return IOManager.getInstance().getDBHandler().deleteCar(carToDelete.getId());
    }
    
    
}
