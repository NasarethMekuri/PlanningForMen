/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.domain.planning;

import java.sql.Date;
import org.junit.*;

/**
 *
 * @author Cymon343
 */
public class CarTest
{
    
    public CarTest()
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
     * Test of getId method, of class Car.
     */
    @Test
    public void testGetId()
    {
        System.out.println("getId");
        Car instance = new Car();
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMake method, of class Car.
     */
    @Test
    public void testGetMake()
    {
        System.out.println("getMake");
        Car instance = new Car();
        String expResult = "";
        String result = instance.getMake();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getModel method, of class Car.
     */
    @Test
    public void testGetModel()
    {
        System.out.println("getModel");
        Car instance = new Car();
        String expResult = "";
        String result = instance.getModel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVersion method, of class Car.
     */
    @Test
    public void testGetVersion()
    {
        System.out.println("getVersion");
        Car instance = new Car();
        String expResult = "";
        String result = instance.getVersion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFuel method, of class Car.
     */
    @Test
    public void testGetFuel()
    {
        System.out.println("getFuel");
        Car instance = new Car();
        String expResult = "";
        String result = instance.getFuel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Car.
     */
    @Test
    public void testGetDescription()
    {
        System.out.println("getDescription");
        Car instance = new Car();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlate method, of class Car.
     */
    @Test
    public void testGetPlate()
    {
        System.out.println("getPlate");
        Car instance = new Car();
        String expResult = "";
        String result = instance.getPlate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVolume method, of class Car.
     */
    @Test
    public void testGetVolume()
    {
        System.out.println("getVolume");
        Car instance = new Car();
        double expResult = 0.0;
        double result = instance.getVolume();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPurchasePrice method, of class Car.
     */
    @Test
    public void testGetPurchasePrice()
    {
        System.out.println("getPurchasePrice");
        Car instance = new Car();
        double expResult = 0.0;
        double result = instance.getPurchasePrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSellPrice method, of class Car.
     */
    @Test
    public void testGetSellPrice()
    {
        System.out.println("getSellPrice");
        Car instance = new Car();
        double expResult = 0.0;
        double result = instance.getSellPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getYear method, of class Car.
     */
    @Test
    public void testGetYear()
    {
        System.out.println("getYear");
        Car instance = new Car();
        int expResult = 0;
        int result = instance.getYear();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOdometer method, of class Car.
     */
    @Test
    public void testGetOdometer()
    {
        System.out.println("getOdometer");
        Car instance = new Car();
        int expResult = 0;
        int result = instance.getOdometer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPurchaseDate method, of class Car.
     */
    @Test
    public void testGetPurchaseDate()
    {
        System.out.println("getPurchaseDate");
        Car instance = new Car();
        Date expResult = null;
        Date result = instance.getPurchaseDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isInStock method, of class Car.
     */
    @Test
    public void testIsInStock()
    {
        System.out.println("isInStock");
        Car instance = new Car();
        boolean expResult = false;
        boolean result = instance.isInStock();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMake method, of class Car.
     */
    @Test
    public void testSetMake()
    {
        System.out.println("setMake");
        String make = "";
        Car instance = new Car();
        instance.setMake(make);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setModel method, of class Car.
     */
    @Test
    public void testSetModel()
    {
        System.out.println("setModel");
        String model = "";
        Car instance = new Car();
        instance.setModel(model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVersion method, of class Car.
     */
    @Test
    public void testSetVersion()
    {
        System.out.println("setVersion");
        String version = "";
        Car instance = new Car();
        instance.setVersion(version);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFuel method, of class Car.
     */
    @Test
    public void testSetFuel()
    {
        System.out.println("setFuel");
        String fuel = "";
        Car instance = new Car();
        instance.setFuel(fuel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Car.
     */
    @Test
    public void testSetDescription()
    {
        System.out.println("setDescription");
        String description = "";
        Car instance = new Car();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlate method, of class Car.
     */
    @Test
    public void testSetPlate()
    {
        System.out.println("setPlate");
        String plate = "";
        Car instance = new Car();
        instance.setPlate(plate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVolume method, of class Car.
     */
    @Test
    public void testSetVolume()
    {
        System.out.println("setVolume");
        double volume = 0.0;
        Car instance = new Car();
        instance.setVolume(volume);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPurchasePrice method, of class Car.
     */
    @Test
    public void testSetPurchasePrice()
    {
        System.out.println("setPurchasePrice");
        double purchasePrice = 0.0;
        Car instance = new Car();
        instance.setPurchasePrice(purchasePrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSellPrice method, of class Car.
     */
    @Test
    public void testSetSellPrice()
    {
        System.out.println("setSellPrice");
        double sellPrice = 0.0;
        Car instance = new Car();
        instance.setSellPrice(sellPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setYear method, of class Car.
     */
    @Test
    public void testSetYear()
    {
        System.out.println("setYear");
        int year = 0;
        Car instance = new Car();
        instance.setYear(year);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOdometer method, of class Car.
     */
    @Test
    public void testSetOdometer()
    {
        System.out.println("setOdometer");
        int odometer = 0;
        Car instance = new Car();
        instance.setOdometer(odometer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPurchaseDate method, of class Car.
     */
    @Test
    public void testSetPurchaseDate()
    {
        System.out.println("setPurchaseDate");
        Date purchaseDate = null;
        Car instance = new Car();
        instance.setPurchaseDate(purchaseDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInStock method, of class Car.
     */
    @Test
    public void testSetInStock()
    {
        System.out.println("setInStock");
        boolean _inStock = false;
        Car instance = new Car();
        instance.setInStock(_inStock);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
