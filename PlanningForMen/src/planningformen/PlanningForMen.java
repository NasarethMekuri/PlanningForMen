/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen;

import java.sql.Date;
import planningformen.domain.planning.CarManager;

/**
 *
 * @author Simon
 */
public class PlanningForMen
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        PlanningForMen testApp = new PlanningForMen();
        testApp.testCars();
    }

    private void testCars()
    {
        Date specifiedDate = new Date(0).valueOf("2015-05-25");
        
        CarManager.getInstance();
        
        /* - Connection closes before resultset closes!
        List<Car> cars = CarManager.getInstance().getCars();
        
        for (Car car : cars)
        {
        System.out.println(car);
        }
        */
        
        //CarManager.getInstance().createCar("XY12345", 1966, "Triumph", "Spitfire", 1.2, "petrol", "4 mkII", 75000, specifiedDate, 58000, 60000, "Old Car, 60bHp", true); //Car creation works in DB!
        //CarManager.getInstance().deleteCar(new Car("XY12345", 1966, "Triumph", "Spitfire", 1.2, "petrol", "4 mkII", 75000, specifiedDate, 58000, 60000, "Old Car, 60bHp", true)); //Car deletion works in DB!
        //CarManager.getInstance().updateCar(new Car("XY12345", 1966, "Triumph", "Spitfire", 1.2, "petrol", "4 mkII", 75000, specifiedDate, 58000, 60000, "Old Car, 60bHp - SOLD", false)); //Car update works in DB!
    }
    
}
