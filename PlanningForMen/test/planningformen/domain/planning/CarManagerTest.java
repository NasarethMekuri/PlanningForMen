/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.domain.planning;

import java.sql.Date;
import java.util.List;
import org.junit.*;

/**
 *
 * @author Cymon343
 */
public class CarManagerTest
{
    
    public CarManagerTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getInstance method, of class CarManager.
     */
    @Test
    public void testGetInstance()
    {
        System.out.println("getInstance");
        CarManager expResult = null;
        CarManager result = CarManager.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCars method, of class CarManager.
     */
    @Test
    public void testGetCars()
    {
        System.out.println("getCars");
        CarManager instance = null;
        List<Car> expResult = null;
        List<Car> result = instance.getCars();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createCar method, of class CarManager.
     */
    @Test
    public void testCreateCar()
    {
        System.out.println("createCar");
        String plate = "";
        int year = 0;
        String make = "";
        String model = "";
        double volume = 0.0;
        String fuel = "";
        String version = "";
        int odometer = 0;
        Date purchaseDate = null;
        double purchasePrice = 0.0;
        double sellPrice = 0.0;
        String description = "";
        boolean inStock = false;
        CarManager instance = null;
        boolean expResult = false;
        boolean result = instance.createCar(plate, year, make, model, volume, fuel, version, odometer, purchaseDate, purchasePrice, sellPrice, description, inStock);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCarByID method, of class CarManager.
     */
    @Test
    public void testFindCarByID()
    {
        System.out.println("findCarByID");
        String id = "";
        CarManager instance = null;
        Car expResult = null;
        Car result = instance.findCarByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCarByPlate method, of class CarManager.
     */
    @Test
    public void testFindCarByPlate()
    {
        System.out.println("findCarByPlate");
        String plate = "";
        CarManager instance = null;
        Car expResult = null;
        Car result = instance.findCarByPlate(plate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCarsByMake method, of class CarManager.
     */
    @Test
    public void testFindCarsByMake()
    {
        System.out.println("findCarsByMake");
        String make = "";
        CarManager instance = null;
        List<Car> expResult = null;
        List<Car> result = instance.findCarsByMake(make);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCarsByModel method, of class CarManager.
     */
    @Test
    public void testFindCarsByModel()
    {
        System.out.println("findCarsByModel");
        String model = "";
        CarManager instance = null;
        List<Car> expResult = null;
        List<Car> result = instance.findCarsByModel(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCarsByMakeAndModel method, of class CarManager.
     */
    @Test
    public void testFindCarsByMakeAndModel()
    {
        System.out.println("findCarsByMakeAndModel");
        String make = "";
        String model = "";
        CarManager instance = null;
        List<Car> expResult = null;
        List<Car> result = instance.findCarsByMakeAndModel(make, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCarsByVersion method, of class CarManager.
     */
    @Test
    public void testFindCarsByVersion()
    {
        System.out.println("findCarsByVersion");
        String version = "";
        CarManager instance = null;
        List<Car> expResult = null;
        List<Car> result = instance.findCarsByVersion(version);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCarsByMakeModelVersion method, of class CarManager.
     */
    @Test
    public void testFindCarsByMakeModelVersion()
    {
        System.out.println("findCarsByMakeModelVersion");
        String make = "";
        String model = "";
        String version = "";
        CarManager instance = null;
        List<Car> expResult = null;
        List<Car> result = instance.findCarsByMakeModelVersion(make, model, version);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCarsByVolume method, of class CarManager.
     */
    @Test
    public void testFindCarsByVolume()
    {
        System.out.println("findCarsByVolume");
        double volumeFrom = 0.0;
        double volumeTo = 0.0;
        CarManager instance = null;
        List<Car> expResult = null;
        List<Car> result = instance.findCarsByVolume(volumeFrom, volumeTo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCarsByPurchasePrice method, of class CarManager.
     */
    @Test
    public void testFindCarsByPurchasePrice()
    {
        System.out.println("findCarsByPurchasePrice");
        double priceMin = 0.0;
        double priceMax = 0.0;
        CarManager instance = null;
        List<Car> expResult = null;
        List<Car> result = instance.findCarsByPurchasePrice(priceMin, priceMax);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCarsBySellPrice method, of class CarManager.
     */
    @Test
    public void testFindCarsBySellPrice()
    {
        System.out.println("findCarsBySellPrice");
        double priceMin = 0.0;
        double priceMax = 0.0;
        CarManager instance = null;
        List<Car> expResult = null;
        List<Car> result = instance.findCarsBySellPrice(priceMin, priceMax);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCarsByMiles method, of class CarManager.
     */
    @Test
    public void testFindCarsByMiles()
    {
        System.out.println("findCarsByMiles");
        int milesMin = 0;
        int milesMax = 0;
        CarManager instance = null;
        List<Car> expResult = null;
        List<Car> result = instance.findCarsByMiles(milesMin, milesMax);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCarsByYear method, of class CarManager.
     */
    @Test
    public void testFindCarsByYear()
    {
        System.out.println("findCarsByYear");
        int yearFrom = 0;
        int yearTo = 0;
        CarManager instance = null;
        List<Car> expResult = null;
        List<Car> result = instance.findCarsByYear(yearFrom, yearTo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCarsByPurchaseDate method, of class CarManager.
     */
    @Test
    public void testFindCarsByPurchaseDate()
    {
        System.out.println("findCarsByPurchaseDate");
        Date from = null;
        Date to = null;
        CarManager instance = null;
        List<Car> expResult = null;
        List<Car> result = instance.findCarsByPurchaseDate(from, to);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCar method, of class CarManager.
     */
    @Test
    public void testUpdateCar()
    {
        System.out.println("updateCar");
        Car updatedCar = null;
        CarManager instance = null;
        boolean expResult = false;
        boolean result = instance.updateCar(updatedCar);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCar method, of class CarManager.
     */
    @Test
    public void testDeleteCar()
    {
        System.out.println("deleteCar");
        Car carToDelete = null;
        CarManager instance = null;
        boolean expResult = false;
        boolean result = instance.deleteCar(carToDelete);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
