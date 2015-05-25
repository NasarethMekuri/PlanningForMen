
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen.technical;

import java.sql.*;
import planningformen.core.DBConnector;

/**
 *
 * @author Cymon343
 * =======
 * package planningformen.technical;
 *
 * import java.sql.ResultSet;
 * import planningformen.core.DBConnector;
 * /**
 *
 * @author MKJ
 * >>>>>>> origin/master
 */
public class DBHandler
{
    private DBConnector _dbConnector;
    
    public DBHandler()
    {
        _dbConnector = new DBConnector();
    }
    
    
    //Car Methods
    public boolean createCar(String id, String plate, int year, String make, String model, double volume, String fuel, String version,
            int odometer, Date purchaseDate, double purchasePrice, double sellPrice, String description, boolean inStock)
    {
        Connection c = _dbConnector.getConnection();
        
        CallableStatement cs = null;
        int rowCount = -1;
        
        try
        {
            cs = c.prepareCall("EXECUTE create_car(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            cs.setString(1, id);
            cs.setString(2, plate);
            cs.setInt(3, year);
            cs.setString(4, make);
            cs.setString(5, model);
            cs.setDouble(6, volume);
            cs.setString(7, fuel);
            cs.setString(8, version);
            cs.setInt(9, odometer);
            cs.setDate(10, purchaseDate);
            cs.setDouble(11, purchasePrice);
            cs.setDouble(12, sellPrice);
            cs.setString(13, description);
            cs.setBoolean(14, inStock);
            
            rowCount = cs.executeUpdate();
            
        }
        catch (SQLException ex)
        {
            System.out.println("Error when creating Car in DB!\n" + ex.getLocalizedMessage());
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to close connection! @DBHandler createCar");
            }
        }
        
        return rowCount >= 0; // NEEDS TESTING !! (not sure that 0 is the right number??)
    }
    
    public ResultSet retrieveCars()
    {
        Connection c = _dbConnector.getConnection();
        ResultSet allCars = null;
        
        try
        {
            PreparedStatement ps = c.prepareCall("EXECUTE retrieve_all_cars");
            allCars = ps.executeQuery();
        }
        catch (SQLException ex)
        {
            System.out.println("Database access issues @DBHandler retrieveCars");
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to close connection! @DBHandler retrieveCars");
            }
        }
        
        return allCars;
    }
    
    public boolean updateCar(String id, String plate, int year, String make, String model, double volume, String fuel, String version, int odometer, Date purchaseDate, double purchasePrice, double sellPrice, String description, boolean inStock)
    {
        Connection c = _dbConnector.getConnection();
        
        CallableStatement cs = null;
        int rowCount = -1;
        
        try
        {
            cs = c.prepareCall("EXECUTE update_car(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            cs.setString(1, id);
            cs.setString(2, plate);
            cs.setInt(3, year);
            cs.setString(4, make);
            cs.setString(5, model);
            cs.setDouble(6, volume);
            cs.setString(7, fuel);
            cs.setString(8, version);
            cs.setInt(9, odometer);
            cs.setDate(10, purchaseDate);
            cs.setDouble(11, purchasePrice);
            cs.setDouble(12, sellPrice);
            cs.setString(13, description);
            cs.setBoolean(14, inStock);
            
            rowCount = cs.executeUpdate();
            
        }
        catch (SQLException ex)
        {
            System.out.println("Error when updating Car in DB!\n" + ex.getLocalizedMessage());
        }
        
        
        return rowCount >= 0; //NEEDS TESTING (not sure that 0 is the right number??)
    }
    
    public boolean deleteCar(String id)
    {
        Connection c = _dbConnector.getConnection();
        int rowCount = -1;
        
        try
        {
            CallableStatement cs = c.prepareCall("EXECUTE delete_car(?)");
            cs.setString(1, id);
            
            rowCount = cs.executeUpdate();
        }
        catch (SQLException ex)
        {
            System.out.println("Error when updating Car in DB!\n" + ex.getLocalizedMessage() + "\n@DBHandler deleteCar");
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to close connection! @DBHandler deleteCar");
            }
        }
        
        return rowCount >= 0; //NEEDS TESTING (not sure that 0 is the right number??)
    }
    
    //Customer Methods
    
    public boolean createCustomer(String customerID, String personID, String firstName, String lastName, String address, String phoneNumber, String postalNumber, String email)
    {
        Connection c = _dbConnector.getConnection();
        
        CallableStatement cs = null;
        int rowCount = -1;
        
        try
        {
            cs = c.prepareCall("call create_customer(?,?,?,?,?,?,?,?)");
            cs.setString(1, customerID);
            cs.setString(2, personID);
            cs.setString(3, firstName);
            cs.setString(4, lastName);
            cs.setString(5, address);
            cs.setString(6, phoneNumber);
            cs.setString(7, postalNumber);
            cs.setString(8, email);
            
            rowCount = cs.executeUpdate();
            cs.close();
            
        }
        catch (SQLException ex)
        {
            System.out.println("Error when creating Customer in DB!\n" + ex.getLocalizedMessage());
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to close connection! @DBHandler createCustomer");
            }
        }
        return rowCount != 0;
    }

    public ResultSet retrieveCustomers()
    {
        Connection c = _dbConnector.getConnection();
        ResultSet customers = null;
        
        try
        {
            PreparedStatement ps = c.prepareCall("call retrieve_customers");
            customers = ps.executeQuery();
            ps.close();
        }
        catch (SQLException ex)
        {
            System.out.println("Database access issues @DBHandler retrieveCustomers");
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to close connection! @DBHandler retrieveCustomers");
            }
        }
        return customers;
    }
    
    public boolean updateCustomer(String customerID, String personID, String firstName, String lastName, String address, String phoneNumber, String postalNumber, String email)
    {
        Connection c = _dbConnector.getConnection();
        
        CallableStatement cs = null;
        int rowCount = -1;
        
        try
        {
            cs = c.prepareCall("call update_customer(?,?,?,?,?,?,?,?)");
            //cs.setString(1, customerID);  //This will be changed in future iterations when Customer "evolves". Same goes for the sql queries.
            cs.setString(1, personID); //@MKJ --> Tror dine numbers er off! personID skal være 2?
            cs.setString(2, firstName); //@MKJ --> 3
            cs.setString(3, lastName); //@MKJ --> 4
            cs.setString(4, address); //@MKJ --> 5 ... I could be wrong?
            cs.setString(5, phoneNumber);
            cs.setString(6, postalNumber);
            cs.setString(7, email);
            
            rowCount = cs.executeUpdate();
            cs.close();
            
        }
        catch (SQLException ex)
        {
            System.out.println("Error when updating Customer in DB!\n" + ex.getLocalizedMessage());
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to close connection! @DBHandler updateCustomer");
            }
        }
        return rowCount != 0;
    }
    
    /**
     * Deletes a Person (Either Customer or Employee) based on the personID.
     * @param personID The ID of the person to be deleted.
     * @return A boolean indication whether or not anything was deleted.
     */
    public boolean deletePerson(String personID)
    {
        Connection c = _dbConnector.getConnection();
        
        CallableStatement cs = null;
        int rowCount = -1;
        
        try
        {
            cs = c.prepareCall("call delete_person(?)");
            cs.setString(1, personID);

            rowCount = cs.executeUpdate();
            cs.close();
            
        }
        catch (SQLException ex)
        {
            System.out.println("Error when deleting Person in DB!\n" + ex.getLocalizedMessage());
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to close connection! @DBHandler deletePerson");
            }
        }
        return rowCount != 0;
    }
    
    //Employee Methods
    
    public boolean createEmployee(String employeeID, String personID, String firstName, String lastName, String address, String phoneNumber, String postalNumber, String email)
    {
        Connection c = _dbConnector.getConnection();
        
        CallableStatement cs = null;
        int rowCount = -1;
        
        try
        {
            cs = c.prepareCall("call create_employee(?,?,?,?,?,?,?,?)");
            cs.setString(1, employeeID);
            cs.setString(2, personID);
            cs.setString(3, firstName);
            cs.setString(4, lastName);
            cs.setString(5, address);
            cs.setString(6, phoneNumber);
            cs.setString(7, postalNumber);
            cs.setString(8, email);
            
            rowCount = cs.executeUpdate();
            cs.close();
            
        }
        catch (SQLException ex)
        {
            System.out.println("Error when creating Employee in DB!\n" + ex.getLocalizedMessage());
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to close connection! @DBHandler createEmployee");
            }
        }
        return rowCount != 0;
    }

    public ResultSet retrieveEmployees()
    {
        Connection c = _dbConnector.getConnection();
        ResultSet employees = null;
        
        try
        {
            PreparedStatement ps = c.prepareCall("execute retrieve_employees");
            employees = ps.executeQuery();
            ps.close();
        }
        catch (SQLException ex)
        {
            System.out.println("Database access issues @DBHandler retrieveEmployees");
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to close connection! @DBHandler retrieveEmployees");
            }
        }
        return employees;
    }
    
    public boolean updateEmployee(String employeeID, String personID, String firstName, String lastName, String address, String phoneNumber, String postalNumber, String email)
    {
        Connection c = _dbConnector.getConnection();
        
        CallableStatement cs = null;
        int rowCount = -1;
        
        try
        {
            cs = c.prepareCall("call update_employee(?,?,?,?,?,?,?,?)");
            //cs.setString(1, employeeID);  //This will be changed in future iterations when Employee "evolves". Same goes for the sql queries.
            cs.setString(1, personID);
            cs.setString(2, firstName);
            cs.setString(3, lastName);
            cs.setString(4, address);
            cs.setString(5, phoneNumber);
            cs.setString(6, postalNumber);
            cs.setString(7, email);
            
            rowCount = cs.executeUpdate();
            cs.close();
            
        }
        catch (SQLException ex)
        {
            System.out.println("Error when updating Employee in DB!\n" + ex.getLocalizedMessage());
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to close connection! @DBHandler updateEmployee");
            }
        }
        return rowCount != 0;
    }
    
    
    
    
}
