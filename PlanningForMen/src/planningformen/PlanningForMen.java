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
        //testApp.testCars();
        System.out.println("#### TESTING CUSTOMERS ####");
        testApp.testCustomers();
        
        System.out.println("#### TESTING EMPLOYEES ####");
        testApp.testEmployees();
    }

    private void testCars()
    {

        Date specifiedDate = new Date(0).valueOf("2015-05-25");        
        
        /*for (Car next : CarManager.getInstance().getCars())
        {
        System.out.println("Car: " + next.getId());
        }*/
        
        CarManager.getInstance();
        
        /* - Connection closes before resultset closes!
        List<Car> cars = CarManager.getInstance().getCars();
        
        for (Car car : cars)
        {
        System.out.println(car);
        }
        */
        
        //CarManager.getInstance().createCar("XY12345", 1966, "Triumph", "Spitfire", 1.2, "petrol", "4 mkII", 75000, specifiedDate, 58000, 60000, "Old Car, 60bHp", true); //Car creation works in DB!
        CarManager.getInstance().deleteCar(new Car("XY12345", 1966, "Triumph", "Spitfire", 1.2, "petrol", "4 mkII", 75000, specifiedDate, 58000, 60000, "Old Car, 60bHp", true)); //Car deletion works in DB!
        //CarManager.getInstance().updateCar(new Car("XY12345", 1966, "Triumph", "Spitfire", 1.2, "petrol", "4 mkII", 75000, specifiedDate, 58000, 60000, "Old Car, 60bHp - SOLD", false)); //Car update works in DB!
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
