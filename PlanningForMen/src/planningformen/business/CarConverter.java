/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.business;

import java.util.List;
import planningformen.domain.planning.Car;
import planningformen.technical.IOManager;

/**
 *
 * @author Cymon343
 */
public class CarConverter
{
    private IOManager _ioManager;

    public CarConverter()   
    {}
    
    public boolean createCar(Car carToCreate)
    {
        return _ioManager.getInstance().getDBHandler().createCar(carToCreate.getId(), carToCreate.getPlate(), carToCreate.getYear(), carToCreate.getMake(), carToCreate.getModel(), 
                                                                 carToCreate.getVolume(), carToCreate.getFuel(), carToCreate.getVersion(), carToCreate.getOdometer(), 
                                                                 carToCreate.getPurchaseDate(), carToCreate.getPurchasePrice(), carToCreate.getSellPrice(), carToCreate.getDescription(), 
                                                                 carToCreate.isInStock());
    }
    
    public List<Car> populateCarList()
    {
    //TODO: FIXME
        return null;
    }
    
    public boolean updateCar(Car carToUpdate)
    {
        //TODO: FIXME
        return false;
    }
    
    
    public boolean deleteCar(Car carToDelete)
    {
        //TODO: FIXME
        return false;
    }
}
