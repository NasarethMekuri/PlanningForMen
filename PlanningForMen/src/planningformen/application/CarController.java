/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.application;

import java.sql.Date;
import java.util.List;
import planningformen.domain.Master;
import planningformen.domain.planning.Car;

/**
 *
 * @author Simon
 */
public class CarController implements ICarController
{
 

    @Override
    public boolean createCar(String plate, int year, String make, String model, double volume, String fuel, String version, int odometer, Date purchaseDate, double purchasePrice, double sellPrice, String description, boolean inStock)
    {
        return Master.getInstance().getCarManager().createCar(plate, year, make, model, volume, fuel, version, odometer, purchaseDate, purchasePrice, sellPrice, description, inStock);
    }

    @Override
    public Car findCarByID(String id)
    {
        
        return Master.getInstance().getCarManager().findCarByID(id);
    }

    @Override
    public Car findCarByPlate(String plate)
    {
        return Master.getInstance().getCarManager().findCarByPlate(plate);
    }

    @Override
    public List<Car> findCarsByMake(String make)
    {
        return Master.getInstance().getCarManager().findCarsByMake(make);
    }

    @Override
    public List<Car> findCarsByModel(String model)
    {
        return Master.getInstance().getCarManager().findCarsByModel(model);
    }

    @Override
    public List<Car> findCarsByMakeAndModel(String make, String model)
    {
        return Master.getInstance().getCarManager().findCarsByMakeAndModel(make, model);
    }

    @Override
    public List<Car> findCarsByVersion(String version)
    {
        return Master.getInstance().getCarManager().findCarsByVersion(version);
    }

    @Override
    public List<Car> findCarsByMakeModelVersion(String make, String model, String version)
    {
        return Master.getInstance().getCarManager().findCarsByMakeModelVersion(make, model, version);
    }

    @Override
    public List<Car> findCarsByVolume(double volumeFrom, double volumeTo)
    {
        return Master.getInstance().getCarManager().findCarsByVolume(volumeFrom, volumeTo);
    }

    @Override
    public List<Car> findCarsByPurchasePrice(double priceMin, double priceMax)
    {
        return Master.getInstance().getCarManager().findCarsByPurchasePrice(priceMin, priceMax);
    }

    @Override
    public List<Car> findCarsBySellPrice(double priceMin, double priceMax)
    {
        return Master.getInstance().getCarManager().findCarsBySellPrice(priceMin, priceMax);
    }

    @Override
    public List<Car> findCarsByMiles(int milesMin, int milesMax)
    {
        return Master.getInstance().getCarManager().findCarsByMiles(milesMin, milesMax);
    }

    @Override
    public List<Car> findCarsByYear(int yearFrom, int yearTo)
    {
        return Master.getInstance().getCarManager().findCarsByYear(yearFrom, yearTo);
    }

    @Override
    public List<Car> findCarsByPurchaseDate(Date from, Date to)
    {
        return Master.getInstance().getCarManager().findCarsByPurchaseDate(from, to);
    }

    @Override
    public List<Car> findCarsBySaleID(String saleID)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //@MKJ get down, get down, and move it all around...
    }

    @Override
    public boolean updateCar(Car updatedCar)
    {
        return Master.getInstance().getCarManager().updateCar(updatedCar);
    }

    @Override
    public boolean deleteCar(Car carToDelete)
    {
        return Master.getInstance().getCarManager().deleteCar(carToDelete);
    }
    
}
