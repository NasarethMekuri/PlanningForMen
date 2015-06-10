/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import planningformen.business.SlotConverter;
import planningformen.domain.financeandefficiency.*;
import planningformen.domain.planning.*;
import planningformen.domain.tyre.*;
import planningformen.ui.gui.MainFrame;

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
        //System.out.println("#### TESTING CARS ####");
        //testApp.testCars();
        
        //System.out.println("#### TESTING SERVICES ####");
        //testApp.testServices();
        
        //System.out.println("#### TESTING CUSTOMERS ####");
        //testApp.testCustomers();
        
        //System.out.println("#### TESTING EMPLOYEES ####");
        //testApp.testEmployees();
        
        //System.out.println("#### TESTING SERVICES V2.0 ####");
        //testApp.moreServiceTests();
        
        /*System.out.println("#### Testing Sales ####");
        testApp.testSales();
        testApp.testTransactions();*/
        //testApp.testTyres();
        
        //testApp.testSlotRetrieval();
        
        testApp.testGUI();
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
        //EmployeeManager.getInstance().createEmployee("0102089877", "Anders", "Fjog", "EU", "666", "9999", "gone@from.dk");
        //EmployeeManager.getInstance().createEmployee("1102089877", "Secret", "even more secret", "hidden", "1234", "5678", "dont@know.it");
        
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
    
    private void testServices()
    {
        System.out.println("Creating 3 services (4x true)");
        System.out.println(ServiceManager.getInstance().createService(25.25, "firstService", ServiceType.NORMAL));
        System.out.println(ServiceManager.getInstance().createService(12, "secondService", ServiceType.DIESEL));
        System.out.println(ServiceManager.getInstance().createService(49, "thirdService", ServiceType.NORMAL));
        System.out.println(ServiceManager.getInstance().createService(200, "fourthService", ServiceType.TUNING));
        
        System.out.println("\n Getting services by price expecting 2");
        System.out.println(ServiceManager.getInstance().findServicesByPrice(15, 50));
        
        System.out.println("\n Getting services by type expecting 2");
        System.out.println(ServiceManager.getInstance().findServicesByType(ServiceType.NORMAL));
        
        System.out.println("\n Getting services by types expecting 3");
        for (Service s : ServiceManager.getInstance().findServicesByTypes(ServiceType.DIESEL, ServiceType.TUNING))
        {
            System.out.println(s.getType());
        }
        
        System.out.println("\n Setting 4 states");
        boolean flip = false;
        for (Service s : ServiceManager.getInstance().findServicesByState(ServiceState.PENDING))
        {
            if (flip)
            {
                s.setState(ServiceState.STARTED);
                flip = false;
            }
            else
            {
                s.setState(ServiceState.RESERVED);
                flip = true;
            }
        }
        
        System.out.println("\n Getting services by State expecting 2");
        for (Service s : ServiceManager.getInstance().findServicesByState(ServiceState.RESERVED))
        {
            System.out.println(s.getState());
        }
        
        System.out.println("\n Getting services by States expecting 4");
        for (Service s : ServiceManager.getInstance().findServicesByStates(ServiceState.RESERVED, ServiceState.STARTED))
        {
            System.out.println(s.getState());
        }
        
        
        
        /*
        System.out.println("\nTesting UPDATE expecting all to be FINISHED");
        for (int i = 0; i < ServiceManager.getInstance().getServices().size(); i++)
        {
        ServiceManager.getInstance().updateService(setter);
        }
        */
        
        /*
        System.out.println("\nDeleting service: expecting 2 services");
        for (Iterator<Service> it = ServiceManager.getInstance().getServices().iterator(); it.hasNext();)
        {
        Service s = it.next();
        if (s.getState() == ServiceState.STARTED)
        {
        ServiceManager.getInstance().deleteService(s); //This gives error, and it should... This is bad code and is for testing only.
        }
        System.out.println(s.getId());
        }
        */
        
        System.out.println("Testing ID toString");
        for (Service s : ServiceManager.getInstance().getServices())
        {
            System.out.println(s.getId().toString());
        }
        
        
    }
    
    /*private void moreServiceTests()
    {
    System.out.println("Checking the List");
    Master.getInstance().getServiceManager().getPrioritizedJobsList();
    
    for (int i = 0; i < Master.getInstance().getServiceManager().getGarages().length; i++)
    {
    System.out.println("DIESEL JOB nr: " + i + 1);
    System.out.println(Master.getInstance().getServiceManager().getGarages()[0].getJobs().get(i));
    System.out.println();
    System.out.println("NORMAL JOB nr: " + i + 1);
    System.out.println(Master.getInstance().getServiceManager().getGarages()[1].getJobs().get(i));
    System.out.println();
    System.out.println("TUNING JOB nr: " + i + 1);
    System.out.println(Master.getInstance().getServiceManager().getGarages()[2].getJobs().get(i));
    }
    }*/
    
    private void testSales()
    {
        //Create Sale
        System.out.println("TESTING CREATE!");
        System.out.println("Customer Count: " + CustomerManager.getInstance().getCustomers().size());
        System.out.println("Employee Count: " + EmployeeManager.getInstance().getEmployees().size());
        System.out.println("Car Count: " + CarManager.getInstance().getCars().size());
        System.out.println("Service Count: " + ServiceManager.getInstance().getServices().size());
        List<Sellable> items = new ArrayList<Sellable>();
        int totalServices = ServiceManager.getInstance().getServices().size();
        int totalCars = CarManager.getInstance().getCars().size();
        items.add(ServiceManager.getInstance().getServices().get(totalServices - 1));
        items.add(CarManager.getInstance().getCars().get(totalCars - 1));
        System.out.println("Items after adding: " + items.size());
        Employee emp = EmployeeManager.getInstance().getEmployees().get(0);
        Customer cust = CustomerManager.getInstance().getCustomers().get(0);
        SaleManager.getInstance().createSale(emp,cust, items, totalCars);
        int index = SaleManager.getInstance().getSales().size() - 1;
        Sale sale = SaleManager.getInstance().getSales().get(index);
        System.out.println("Items after instantiation: " + sale.getItems().size());
        SaleManager.getInstance().printInvoice(sale);
        
        //Update Sale
        System.out.println("TESTING UPDATE");
        sale.getItems().add(CarManager.getInstance().getCars().get(0));
        SaleManager.getInstance().updateSale(sale);
        SaleManager.getInstance().printInvoice(sale);
        
        //if(SaleManager.getInstance().deleteSale(sale))
        //    System.out.println("Deletion succesful!");
    }
    
    public void testTransactions()
    {
        //TransactionManager.getInstance().createTransactionsFile(Date.valueOf("2014-01-01"), Date.valueOf("2015-12-31"));
    }
    
    public void testTyres()
    {
        TyreManager.getInstance().createTyre(500f, 800f, new TyreSize(60, 70, 80), TyreType.MC);
        System.out.println("List Length: " + TyreManager.getInstance().getTyres().size());
        TyreManager.getInstance().deleteTyre(TyreManager.getInstance().getTyres().get(TyreManager.getInstance().getTyres().size() - 1));
        System.out.println("List Length: " + TyreManager.getInstance().getTyres().size());
    }
    
    private void testSlotRetrieval()
    {
        /*
        Slot[][][] slots = TyreHotel.getInstance().getSlots();
        int counter = 0;
        for (Slot[][] z : slots)
        {
        for (Slot[] y : z)
        {
        for (Slot s : y)
        {
        if (s != null)
        {
        System.out.println(s.getBinaryStringPosition());
        }
        
        }
        }
        }
        */
        
        /*
        byte b = -128;
        System.out.println(
        TyreHotel.getInstance().findCustomerBySlot(new Slot(b, "inni01010101010101", null)).getAddress()
        );
        */
        /*
        byte b = -128;
        System.out.println(
        TyreHotel.getInstance().findSlotByCustomer(CustomerManager.getInstance().findCustomer("inni01010101010101")).getBinaryStringPosition());
        */
        
        //################################## #MKJ USE IN REPORT  ####################################
        SlotConverter sc = TyreHotel.getInstance().getSlotConverter();
        byte b = -128;
        for (int i = -127; i < 129; i++)
        {
            System.out.print("Converting " + b + " into: " + sc.convertByteToStringSimple(b));
            System.out.println(" | Converted back = " + sc.convertStringToByte(sc.convertByteToString(b)));
            b++;
        }
        
        /* THIS SHOULD WORK!?
        byte b = 0;
        int x = b;
        
        String zeroes = "0000000";
        
        for (int i = -127; i < 129; i++)
        {
        String binaryString = Integer.toBinaryString(i);
        
        binaryString = zeroes + binaryString;
        
        binaryString = binaryString.substring(binaryString.length() - 8);
        
        System.out.println(binaryString);
        }
        */
        
        
        //System.out.println(TyreHotel.getInstance().getSlotConverter().convertStringToByte("10011100"));
    }

    private void testGUI()
    {
        JFrame frame = new MainFrame();
         frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void moreServiceTests()
    {
        System.out.println(ServiceManager.getInstance().createService(5000, "Tune 1", ServiceType.TUNING));
        System.out.println(ServiceManager.getInstance().createService(5000, "Tune 2", ServiceType.TUNING));
        System.out.println(ServiceManager.getInstance().createService(5000, "Tune 3", ServiceType.TUNING));
        System.out.println(ServiceManager.getInstance().createService(5000, "Tune 4", ServiceType.TUNING));
    }
       
}
