/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.business;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import planningformen.domain.planning.Customer;
import planningformen.domain.planning.Employee;
import planningformen.domain.planning.Person;

/**
 *
 * @author bruger
 */
public class PersonConverterTest
{
    
    public PersonConverterTest()
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
     * Test of createCustomer method, of class PersonConverter.
     */
    @Test
    public void testCreateCustomer()
    {
        System.out.println("createCustomer");
        Customer customer = null;
        PersonConverter instance = new PersonConverter();
        boolean expResult = false;
        boolean result = instance.createCustomer(customer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveCustomers method, of class PersonConverter.
     */
    @Test
    public void testRetrieveCustomers()
    {
        System.out.println("retrieveCustomers");
        PersonConverter instance = new PersonConverter();
        List<Customer> customers = instance.retrieveCustomers();
        boolean expResult = true;
        boolean result = customers.size() > 0;
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCustomer method, of class PersonConverter.
     */
    @Test
    public void testUpdateCustomer()
    {
        System.out.println("updateCustomer");
        Customer customer = null;
        PersonConverter instance = new PersonConverter();
        boolean expResult = false;
        boolean result = instance.updateCustomer(customer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePerson method, of class PersonConverter.
     */
    @Test
    public void testDeletePerson()
    {
        System.out.println("deletePerson");
        Person person = null;
        PersonConverter instance = new PersonConverter();
        boolean expResult = false;
        boolean result = instance.deletePerson(person);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createEmployee method, of class PersonConverter.
     */
    @Test
    public void testCreateEmployee()
    {
        System.out.println("createEmployee");
        Employee employee = null;
        PersonConverter instance = new PersonConverter();
        boolean expResult = false;
        boolean result = instance.createEmployee(employee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of retrieveEmployees method, of class PersonConverter.
     */
    @Test
    public void testRetrieveEmployees()
    {
        System.out.println("retrieveEmployees");
        PersonConverter instance = new PersonConverter();
        List<Employee> expResult = null;
        List<Employee> result = instance.retrieveEmployees();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateEmployee method, of class PersonConverter.
     */
    @Test
    public void testUpdateEmployee()
    {
        System.out.println("updateEmployee");
        Employee employee = null;
        PersonConverter instance = new PersonConverter();
        boolean expResult = false;
        boolean result = instance.updateEmployee(employee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
