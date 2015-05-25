/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen;

import java.sql.Date;
import java.util.List;
import planningformen.domain.planning.Car;
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
        //CarManager.getInstance().createCar("XX12345", 1966, "Triumph", "Spitfire", 1.2, "petrol", "4 mkII", 75000, specifiedDate, 58000, 60000, "Old Car, 60bHp", true);
        CarManager.getInstance();
        List<Car> cars = CarManager.getInstance().getCars();
        
        for (Car car : cars)
        {
            System.out.println(car);
        }
        
        
    }
    
}
