/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen.domain.planning;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Simon
 */
public class CarManager
{
    private static CarManager _instance;
    private List<Car> _cars;
    
    private CarManager()
    {
        //TODO: populate list from database.
    }
    
    public static synchronized CarManager getInstance()
    {
        if (_instance == null)
        {
            _instance = new CarManager();
        }
        return _instance;
    }
    
    public List<Car> getCars()    {return _cars;}
    
    
    public void createCar(String id, String plate, int year, String make, String model, double volume, String fuel, String version, int odometer, Date purchaseDate, double purchasePrice, double sellPrice, String description)
    {
        //TODO Write it to database first!
        _cars.add(new Car(id, plate, year, make, model, volume, fuel, version, odometer, purchaseDate, purchasePrice, sellPrice, description));
    }
    
    
    public Car findCarByID(String id)
    {
        Car returnCar = new Car();
        for (Car next : getCars())
        {
            if (next.getId().equalsIgnoreCase(id))
            {
                returnCar = next;
                return returnCar;
            }
        }
        return null;
    }
    
    public Car findCarByPlate(String plate)
    {
        Car returnCar = new Car();
        for (Car next : getCars())
        {
            if (next.getPlate().equalsIgnoreCase(plate))
            {
                returnCar = next;
                return returnCar;
            }
        }
        return null;
    }
    
    public List<Car> findCarsByMake(String make)
    {
        List<Car> returnCars = new ArrayList();
        for (Car next : getCars())
        {
            if (next.getMake().equalsIgnoreCase(make))
            {
                returnCars.add(next);
            }
        }
        return returnCars;
    }
    
    public List<Car> findCarsByModel(String model)
    {
        List<Car> returnCars = new ArrayList();
        for (Car next : getCars())
        {
            if (next.getModel().equalsIgnoreCase(model))
            {
                returnCars.add(next);
            }
        }
        return returnCars;
    }
    
    public List<Car> findCarsByMakeAndModel(String make, String model)
    {
        List<Car> returnCars = new ArrayList();
        for (Car next : getCars())
        {
            if (next.getMake().equalsIgnoreCase(make) && next.getModel().equalsIgnoreCase(model))
            {
                returnCars.add(next);
            }
        }
        return returnCars;
    }
    
    public List<Car> findCarsByVersion(String version)
    {
        List<Car> returnCars = new ArrayList();
        for (Car next : getCars())
        {
            if (next.getVersion().equalsIgnoreCase(version))
            {
                returnCars.add(next);
            }
        }
        return returnCars;
    }
    
    public List<Car> findCarsByMakeModelVersion(String make, String model, String version)
    {
        List<Car> returnCars = new ArrayList();
        for (Car next : getCars())
        {
            if (next.getMake().equalsIgnoreCase(make) && next.getModel().equalsIgnoreCase(model) && next.getVersion().equalsIgnoreCase(version))
            {
                returnCars.add(next);
            }
        }
        return returnCars;
    }
    
    public List<Car> findCarsByVolume(double volumeFrom, double volumeTo)
    {
        List<Car> returnCars = new ArrayList();
        for (Car next : getCars())
        {
            if (volumeFrom <= next.getVolume() && volumeTo >= next.getVolume())
            {
                returnCars.add(next);
            }
        }
        return returnCars;
    }
    
    public List<Car> findCarsByPurchasePrice(double priceMin, double priceMax)
    {
        List<Car> returnCars = new ArrayList();
        for (Car next : getCars())
        {
            if (priceMin <= next.getPurchasePrice() && priceMax >= next.getPurchasePrice())
            {
                returnCars.add(next);
            }
        }
        return returnCars;
    }
    
    public List<Car> findCarsBySellPrice(double priceMin, double priceMax)
    {
        List<Car> returnCars = new ArrayList();
        for (Car next : getCars())
        {
            if (priceMin <= next.getSellPrice() && priceMax >= next.getSellPrice())
            {
                returnCars.add(next);
            }
        }
        return returnCars;
        
    }
    
    public List<Car> findCarsByMiles(int milesMin, int milesMax)
    {
        List<Car> returnCars = new ArrayList();
        for (Car next : getCars())
        {
            if (milesMin <= next.getOdometer() && milesMax >= next.getOdometer())
            {
                returnCars.add(next);
            }
        }
        return returnCars;
    }
    
    public List<Car> findCarsByYear(int yearFrom, int yearTo)
    {
        List<Car> returnCars = new ArrayList();
        for (Car next : getCars())
        {
            if (yearFrom <= next.getYear() && yearTo >= next.getYear())
            {
                returnCars.add(next);
            }
        }
        return returnCars;
    }
    
    public List<Car> findCarsByPurchaseDate(Date from, Date to)
    {
        List<Car> returnCars = new ArrayList();
        for (Car next : getCars())
        {
            if (from.before(next.getPurchaseDate()) && to.after(next.getPurchaseDate()))
            {
                returnCars.add(next);
            }
        }
        return returnCars;
    }
    
    public void updateCarByID(String id, int year, String make, String model, double volume, String fuel, String version, int odometer, Date purchaseDate, double purchasePrice, double sellPrice, String description)
    {
        for (Car next : _cars)
        {
            if (next.getId().equalsIgnoreCase(id))
            {
                if (year != -1)
                {
                    next.setYear(year);
                }
                if (!"".equals(make))
                {
                    next.setMake(make);
                }
                if (!"".equals(model))
                {
                    next.setModel(model);
                }
                if (volume != -1)
                {
                    next.setVolume(volume);
                }
                if (!"".equals(fuel))
                {
                    next.setFuel(fuel);
                }
                if (!"".equals(version))
                {
                    next.setVersion(version);
                }
                if (odometer != -1)
                {
                    next.setOdometer(odometer);
                }
                if (purchaseDate != null)
                {
                    next.setPurchaseDate(purchaseDate);
                }
                if (purchasePrice != -1)
                {
                    next.setPurchasePrice(purchasePrice);
                }
                if (sellPrice != -1)
                {
                    next.setSellPrice(sellPrice);
                }
                if (!"".equals(description))
                {
                    next.setDescription(description);
                }
            }
        }
    }
    
    public void updateCarByPlate(String plate, int year, String make, String model, double volume, String fuel, String version, int odometer, Date purchaseDate, double purchasePrice, double sellPrice, String description)
    {
        for (Car next : _cars)
        {
            if (next.getPlate().equalsIgnoreCase(plate))
            {
                if (year != -1)
                {
                    next.setYear(year);
                }
                if (!"".equals(make))
                {
                    next.setMake(make);
                }
                if (!"".equals(model))
                {
                    next.setModel(model);
                }
                if (volume != -1)
                {
                    next.setVolume(volume);
                }
                if (!"".equals(fuel))
                {
                    next.setFuel(fuel);
                }
                if (!"".equals(version))
                {
                    next.setVersion(version);
                }
                if (odometer != -1)
                {
                    next.setOdometer(odometer);
                }
                if (purchaseDate != null)
                {
                    next.setPurchaseDate(purchaseDate);
                }
                if (purchasePrice != -1)
                {
                    next.setPurchasePrice(purchasePrice);
                }
                if (sellPrice != -1)
                {
                    next.setSellPrice(sellPrice);
                }
                if (!"".equals(description))
                {
                    next.setDescription(description);
                }
            }
        }
    }
    
    public boolean deleteCarByID(String id)
    {
        for (Car next : getCars())
        {
            if (next.getId().equalsIgnoreCase(id))
            {
                _cars.remove(next);
                return true;
            }
        }
        return false;
    }
    
    public boolean deleteCarByPlate(String plate)
    {
        for (Car next : getCars())
        {
            if (next.getPlate().equalsIgnoreCase(plate))
            {
                _cars.remove(next);
                return true;
            }
        }
        return false;
    }
    
}
