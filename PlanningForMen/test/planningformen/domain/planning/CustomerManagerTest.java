/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.domain.planning;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bruger
 */
public class CustomerManagerTest
{
    public CustomerManagerTest()
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
     * Test of createCustomer method, of class CustomerManager.
     */
    @Test
    public void testCreateCustomer()
    {
        System.out.println("createCustomer");
        String id = "0102032345";
        String firstName = "John";
        String lastName = "Doe";
        String address = "Anonymous Street 8";
        String phoneNumber = "555-Secret";
        String postalNumber = "1234";
        String email = "dont@know.it";
        CustomerManager instance = CustomerManager.getInstance();
        boolean expResult = true;
        boolean result = instance.createCustomer(id, firstName, lastName, address, phoneNumber, postalNumber, email);
        assertEquals(expResult, result);
    }

    /**
     * Test of findCustomer method, of class CustomerManager.
     */
    @Test
    public void testFindCustomer()
    {
        System.out.println("findCustomer");
        String id = "";
        CustomerManager instance = CustomerManager.getInstance();
        Customer expResult = null;
        Customer result = instance.findCustomer(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCustomers method, of class CustomerManager.
     */
    @Test
    public void testFindCustomers_String_String()
    {
        System.out.println("findCustomers");
        String firstName = "";
        String lastName = "";
        CustomerManager instance = CustomerManager.getInstance();
        List<Customer> expResult = null;
        List<Customer> result = instance.findCustomers(firstName, lastName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCustomers method, of class CustomerManager.
     */
    @Test
    public void testFindCustomers_String()
    {
        System.out.println("findCustomers");
        String lastName = "";
        CustomerManager instance = CustomerManager.getInstance();
        List<Customer> expResult = null;
        List<Customer> result = instance.findCustomers(lastName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCustomer method, of class CustomerManager.
     */
    @Test
    public void testUpdateCustomer()
    {
        System.out.println("updateCustomer");
        Customer customer = null;
        CustomerManager instance = CustomerManager.getInstance();
        boolean expResult = false;
        boolean result = instance.updateCustomer(customer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCustomer method, of class CustomerManager.
     */
    @Test
    public void testDeleteCustomer()
    {
        System.out.println("deleteCustomer");
        String id = "1102032345";
        String firstName = "John";
        String lastName = "Doe";
        String address = "Anonymous Street 8";
        String phoneNumber = "555-Secret";
        String postalNumber = "1234";
        String email = "dont@know.it";
        CustomerManager instance = CustomerManager.getInstance();
        boolean expResult = true;
        instance.createCustomer(id, firstName, lastName, address, phoneNumber, postalNumber, email);
        Customer customer = instance.findCustomer(id);
        boolean result = instance.deleteCustomer(customer);
        assertEquals(expResult, result);
    }
    
}
