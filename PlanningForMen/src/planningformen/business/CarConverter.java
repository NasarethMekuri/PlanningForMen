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
        ResultSet rs = IOManager.getInstance().getDBHandler().retrieveCars();
        List<Car> cars = new ArrayList();
        Car aCar = new Car();
        
        try
        {
            while (rs.next())
            {        
                    aCar.setPlate(rs.getString(2));
                    aCar.setYear(rs.getInt(3));
                    aCar.setMake(rs.getString(4));
                    aCar.setModel(rs.getString(5));
                    aCar.setVolume(rs.getDouble(6));
                    aCar.setFuel(rs.getString(7));
                    aCar.setVersion(rs.getString(8));
                    aCar.setOdometer(rs.getInt(9));
                    aCar.setPurchaseDate(rs.getDate(10));
                    aCar.setPurchasePrice(rs.getDouble(11));
                    aCar.setSellPrice(rs.getDouble(12));
                    aCar.setDescription(rs.getString(13));
                    aCar.setInStock(rs.getBoolean(14));
                    
                    cars.add(aCar);
            }
        }
        catch (SQLException ex)
        {
            System.out.println("Connection issue @populateCarList in CarConverter or resultset closed\n" + ex.getLocalizedMessage()); // TODO Connection closes before ResultSet is processed.
        }
        finally
        {
            try
            {
                rs.close();
                
            }
            catch (SQLException ex)
            {
                System.out.println("Connection issue @populateCarList in CarConverter\n" + ex.getLocalizedMessage()); //TODO TEST
            }
        }
        
        return cars;
    }
    
    public boolean updateCar(Car carToUpdate)
    {
        return _ioManager.getInstance().getDBHandler().updateCar(carToUpdate.getId(), carToUpdate.getPlate(), carToUpdate.getYear(), carToUpdate.getMake(), carToUpdate.getModel(),
                carToUpdate.getVolume(), carToUpdate.getFuel(), carToUpdate.getVersion(), carToUpdate.getOdometer(),
                carToUpdate.getPurchaseDate(), carToUpdate.getPurchasePrice(), carToUpdate.getSellPrice(), carToUpdate.getDescription(),
                carToUpdate.isInStock());
    }
    
    
    public boolean deleteCar(Car carToDelete)
    {
        return _ioManager.getInstance().getDBHandler().deleteCar(carToDelete.getId());
    }
}
