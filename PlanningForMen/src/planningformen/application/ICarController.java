/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.application;

import java.sql.Date;
import java.util.List;
import planningformen.domain.planning.Car;

/**
 *
 * @author Cymon343
 */
public interface ICarController
{
    public boolean createCar(String plate, int year, String make, String model, double volume, String fuel, String version, int odometer, Date purchaseDate, double purchasePrice, double sellPrice, String description, boolean inStock);
    public Car findCarByID(String id);
    public Car findCarByPlate(String plate);
    public List<Car> findCarsByMake(String make);
    public List<Car> findCarsByModel(String model);
    public List<Car> findCarsByMakeAndModel(String make, String model);
    public List<Car> findCarsByVersion(String version);
    public List<Car> findCarsByMakeModelVersion(String make, String model, String version);
    public List<Car> findCarsByVolume(double volumeFrom, double volumeTo);
    public List<Car> findCarsByPurchasePrice(double priceMin, double priceMax);
    public List<Car> findCarsBySellPrice(double priceMin, double priceMax);
    public List<Car> findCarsByMiles(int milesMin, int milesMax);
    public List<Car> findCarsByYear(int yearFrom, int yearTo);
    public List<Car> findCarsByPurchaseDate(Date from, Date to);
    public List<Car> findCarsBySaleID(String saleID);
    public boolean updateCar(Car updatedCar);
    public boolean deleteCar(Car carToDelete);
}
