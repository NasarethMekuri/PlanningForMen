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
import planningformen.domain.planning.Car;
import planningformen.technical.IOManager;

/**
 *
 * @author Cymon343
 */
public class CarConverter implements ICallback
{
    private List<Car> _convertedCars;
    
    public CarConverter()
    {}
    
    public boolean createCar(Car carToCreate)
    {
        return IOManager.getInstance().getDBHandler().createCar(carToCreate.getId(), carToCreate.getPlate(), carToCreate.getYear(), carToCreate.getMake(), carToCreate.getModel(),
                carToCreate.getVolume(), carToCreate.getFuel(), carToCreate.getVersion(), carToCreate.getOdometer(),
                carToCreate.getPurchaseDate(), carToCreate.getPurchasePrice(), carToCreate.getSellPrice(), carToCreate.getDescription(),
                carToCreate.isInStock());
    }
    
    public List<Car> retrieveCars()
    {
        IOManager.getInstance().getDBHandler().retrieveCars(this);
        return _convertedCars;
    }
    
    
    @Override
    public void extractValues(ResultSet rs) throws SQLException
    {
        Car aCar = null;
        _convertedCars = new ArrayList();
        
        while (rs.next())
        {
            aCar = new Car(
                    rs.getString(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getDouble(6),
                    rs.getString(7),
                    rs.getString(8),
                    rs.getInt(9),
                    rs.getDate(10),
                    rs.getDouble(11),
                    rs.getDouble(12),
                    rs.getString(13),
                    rs.getBoolean(14));
            
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
