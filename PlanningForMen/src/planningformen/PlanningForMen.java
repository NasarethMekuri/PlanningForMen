/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen;

import java.sql.Date;
import java.util.List;
import planningformen.domain.planning.*;

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
        System.out.println("#### TESTING CARS ####");
        testApp.testCars();
        //System.out.println("#### TESTING CUSTOMERS ####");
        //testApp.testCustomers();
        
        //System.out.println("#### TESTING EMPLOYEES ####");
        //testApp.testEmployees();
    }
    
    private void testCars()
    {
        
        Date specifiedDate = new Date(0).valueOf("2015-05-25");
        /*
        TESTING ORDER:
        1) Instanciate from DB
        print _cars (expected 5 cars)
        2)  createCar
        print _cars (expected 6 cars)
        3)  updateCar
        print _cars (expected 6 cars)
        4)  findCarby... x13
        ...
        5)  deleteCar x2
        print _cars (expected 4 cars)
        */
        
        System.out.println("Instaciating List of cars:\nexpecting 5 cars (from DB-script)");
        for (Car next : CarManager.getInstance().getCars())
        {
            System.out.println("Car: " + next.getMake() + " " + next.getModel());
        }
        System.out.println("\nCreating car:\nexpecting true: " + CarManager.getInstance().createCar("XY12345", 2015, "Tesla", "S", 0, "electric", "86", 250, specifiedDate, 600000, 685000, "new Car", true));
        System.out.println("\nupdating car:\nexpecting true: " + CarManager.getInstance().updateCar(new Car("XY12345", 2015, "Tesla", "S", 0, "electric", "86", 250, specifiedDate, 600000, 650000, "SOLD!", false)));
        
        System.out.println("\nFinding car by ID:\nexpecting 20150521-AB12345 result: " + CarManager.getInstance().findCarByID("20150521-AB12345").getId());
        System.out.println("\nFinding car by Plate:\nexpecting XY12345 result: " + CarManager.getInstance().findCarByPlate("XY12345").getPlate());
        System.out.println("\nFinding cars by Make:\nexpecting 2 Fords");
        for (Car car : CarManager.getInstance().findCarsByMake("fOrD"))
        {
            System.out.println("This is a " + car.getMake() + " " + car.getModel());
        }
        
        System.out.println("\nFinding cars by Model:\nexpecting a Tesla S");
        for (Car car : CarManager.getInstance().findCarsByModel("s"))
        {
            System.out.println("This is a " + car.getMake() + " " + car.getModel());
        }
        
        System.out.println("\nFinding cars by Make and Model:\nexpecting a Aston Martin DB5");
        for (Car car : CarManager.getInstance().findCarsByMakeAndModel("AstoN Martin", "dB5"))
        {
            System.out.println("This is a " + car.getMake() + " " + car.getModel());
        }
        /* For some reason this doesn't work ?????
        System.out.println("\nFinding cars by version:\nexpecting a Triumph Spitfire");
        for (Car car : CarManager.getInstance().findCarsByVersion("mkI"))
        {
        System.out.println("This is a " + car.getMake() + " " + car.getModel());
        }
        */
        System.out.println("\nFinding cars by Make, Model, and Version:\nexpecting a Ford Fiesta");
        for (Car car : CarManager.getInstance().findCarsByMakeModelVersion("ford", "fiesta", "mkI"))
        {
            System.out.println("This is a " + car.getMake() + " " + car.getModel() + " " + car.getVersion());
        }
        
        System.out.println("\nFinding cars by Volume:\nexpecting 3 cars");
        for (Car car : CarManager.getInstance().findCarsByVolume(1.1 , 3.6))
        {
            System.out.println("This is a " + car.getMake() + " " + car.getModel() + " Volume: " + car.getVolume());
        }
        
        System.out.println("\nFinding cars by purchasePrice:\nexpecting 2 Fords");
        for (Car car : CarManager.getInstance().findCarsByPurchasePrice(0 , 50000))
        {
            System.out.println("This is a " + car.getMake() + " " + car.getModel());
        }
        
        System.out.println("\nFinding cars by sellPrice:\nexpecting a Ferrari 250GT");
        for (Car car : CarManager.getInstance().findCarsBySellPrice(1000000 , 5000001))
        {
            System.out.println("This is a " + car.getMake() + " " + car.getModel());
        }
        
        System.out.println("\nFinding cars by Miles:\nexpecting 2 Cars");
        for (Car car : CarManager.getInstance().findCarsByMiles(10000 , 110000))
        {
            System.out.println("This is a " + car.getMake() + " " + car.getModel());
        }
        
        System.out.println("\nFinding cars by Year:\nexpecting 3 cars");
        for (Car car : CarManager.getInstance().findCarsByYear(1960 , 1970))
        {
            System.out.println("This is a " + car.getMake() + " " + car.getModel());
        }
        
        System.out.println("\nFinding cars by purchaseDate:\nexpecting (all) 5 cars");
        for (Car car : CarManager.getInstance().findCarsByPurchaseDate(new Date(0).valueOf("2015-05-24") , new Date(0).valueOf("2015-05-26")))
        {
            System.out.println("This is a " + car.getMake() + " " + car.getModel());
        }
        
        
        System.out.println("\nDeleting car:\nexpecting true: " + CarManager.getInstance().deleteCar(new Car("BB12345", 2015, "Tesla", "S", 0, "electric", "86", 250, new Date(0).valueOf("2015-05-21"), 600000, 650000, "SOLD!", false)));
        System.out.println("\nDeleting car:\nexpecting true: " + CarManager.getInstance().deleteCar(new Car("AB12345", 2015, "Tesla", "S", 0, "electric", "86", 250, new Date(0).valueOf("2015-05-21"), 600000, 650000, "SOLD!", false)));
        
        
        System.out.println("\n Checking the list on last time, expecting 4 cars (zero Fords):");
        for (Car next : CarManager.getInstance().getCars())
        {
            System.out.println("Car: " + next.getMake() + " " + next.getModel());
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    private void testCustomers()
    {
        CustomerManager.getInstance().createCustomer("0102039877", "Mogens", "Lykketoft", "Somewhere", "666", "8888", "mogens@lykketoft.dk");
        CustomerManager.getInstance().createCustomer("1102039877", "Peter", "Fra l'easy", "TV", "88888888", "8888", "peter@leasy.dk");
        //Retrieve Test
        
        List<Customer> customers = CustomerManager.getInstance().getCustomers();
        customers.get(0).setFirstName("Georg fra Anna og Lotte");
        CustomerManager.getInstance().updateCustomer(customers.get(0));
        if(customers != null)
            System.out.println(customers.size());
        else
            System.out.println("It's null!");
        
        for(Customer c : customers)
        {
            System.out.println(c.getFirstName());
        }
        
        CustomerManager.getInstance().deleteCustomer(customers.get(0));
        CustomerManager.getInstance().deleteCustomer(customers.get(0));
        customers = CustomerManager.getInstance().getCustomers();
        
        System.out.println(customers.size());
    }
    
    private void testEmployees()
    {
        EmployeeManager.getInstance().createEmployee("0102089877", "Anders", "Fjog", "EU", "666", "9999", "dumb@ass.dk");
        EmployeeManager.getInstance().createEmployee("1102089877", "Secret", "even more secret", "hidden", "1234", "5678", "dont@know.it");
        //Retrieve Test
        
        List<Employee> employees = EmployeeManager.getInstance().getEmployees();
        employees.get(0).setFirstName("Bamse");
        EmployeeManager.getInstance().updateEmployee(employees.get(0));
        if(employees != null)
            System.out.println(employees.size());
        else
            System.out.println("It's null!");
        
        for(Employee e : employees)
        {
            System.out.println(e.getFirstName());
        }
        
        EmployeeManager.getInstance().deleteEmployee(employees.get(0));
        EmployeeManager.getInstance().deleteEmployee(employees.get(0));
        employees = EmployeeManager.getInstance().getEmployees();
        
        System.out.println(employees.size());
    }
    
}
