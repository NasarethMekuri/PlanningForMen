
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen.technical;

import java.sql.*;
import planningformen.business.ICallback;
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
            cs = c.prepareCall("{call create_car(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
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
            
            cs.close();
            
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
                System.out.println("Failed to close connection! @DBHandler createCar\n" + ex.getLocalizedMessage());
            }
        }
        
        return rowCount >= 0; 
    }
    
    public void retrieveCars(ICallback owner)
    {
        Connection c = _dbConnector.getConnection();
        ResultSet allCars = null;
        
        try
        {
            PreparedStatement ps = c.prepareCall("SELECT * FROM retrieve_all_cars");
            allCars = ps.executeQuery();    
            
            owner.extractValues(allCars);
            
            ps.close();
        }
        catch (SQLException ex)
        {
            System.out.println("SQLException @retrieveCars - DBHandler\n" + ex.getLocalizedMessage());
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to close connection! @DBHandler retrieveCars\n" + ex.getLocalizedMessage());
            }
        }
    }
    
    public boolean updateCar(String id, String saleID, String plate, int year, String make, String model, double volume, String fuel, String version, int odometer, Date purchaseDate, double purchasePrice, double sellPrice, String description, boolean inStock)
    {
        Connection c = _dbConnector.getConnection();
        
        CallableStatement cs = null;
        int rowCount = -1;
        
        try
        {
            cs = c.prepareCall("{call update_car(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, id);
            cs.setString(2, saleID);
            cs.setString(3, plate);
            cs.setInt(4, year);
            cs.setString(5, make);
            cs.setString(6, model);
            cs.setDouble(7, volume);
            cs.setString(8, fuel);
            cs.setString(9, version);
            cs.setInt(10, odometer);
            cs.setDate(11, purchaseDate);
            cs.setDouble(12, purchasePrice);
            cs.setDouble(13, sellPrice);
            cs.setString(14, description);
            cs.setBoolean(15, inStock);
            
            rowCount = cs.executeUpdate();
            
            cs.close();
            
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
            CallableStatement cs = c.prepareCall("{call delete_car(?)}");
            cs.setString(1, id);
            
            rowCount = cs.executeUpdate();
            cs.close();
        }
        catch (SQLException ex)
        {
            System.out.println("Error when deleting Car in DB!\n" + ex.getLocalizedMessage() + "\n@DBHandler deleteCar");
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to close connection! @DBHandler deleteCar\n" + ex.getLocalizedMessage());
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
            cs = c.prepareCall("{call create_customer(?,?,?,?,?,?,?,?)}");
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
                System.out.println("Failed to close connection! @DBHandler createCustomer\n" + ex.getLocalizedMessage());
            }
        }
        return rowCount >= 0;
    }

    public void retrieveCustomers(ICallback owner)
    {
        Connection c = _dbConnector.getConnection();
        ResultSet rs = null;
        
        try
        {
            PreparedStatement ps = c.prepareCall("SELECT * FROM retrieve_customers");
            rs = ps.executeQuery();
            owner.extractValues(rs);
            
            ps.close();
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getLocalizedMessage() + " @DBHandler retrieveCustomers");
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to close connection! @DBHandler retrieveCustomers\n" + ex.getLocalizedMessage());
            }
        }
    }
    
    public boolean updateCustomer(String customerID, String personID, String firstName, String lastName, String address, String phoneNumber, String postalNumber, String email)
    {
        Connection c = _dbConnector.getConnection();
        
        CallableStatement cs = null;
        int rowCount = -1;
        
        try
        {
            cs = c.prepareCall("{call update_customer(?,?,?,?,?,?,?)}");
            //cs.setString(1, customerID);  //This will be changed in future iterations when Customer "evolves". Same goes for the sql queries.
            cs.setString(1, personID); //@Cymon: check db script. Update tager ikke CustomerID (Endnu) Discuss tomorrow evt.
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
                System.out.println("Failed to close connection! @DBHandler updateCustomer\n" + ex.getLocalizedMessage());
            }
        }
        return rowCount >= 0;
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
            cs = c.prepareCall("{call delete_person(?)}");
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
                System.out.println("Failed to close connection! @DBHandler deletePerson\n" + ex.getLocalizedMessage());
            }
        }
        return rowCount >= 0;
    }
    
    //Employee Methods
    
    public boolean createEmployee(String employeeID, String personID, String firstName, String lastName, String address, 
                                  String phoneNumber, String postalNumber, String email, int skillType)
    {
        Connection c = _dbConnector.getConnection();
        
        CallableStatement cs = null;
        int rowCount = -1;
        
        try
        {
            cs = c.prepareCall("{call create_employee(?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, employeeID);
            cs.setString(2, personID);
            cs.setString(3, firstName);
            cs.setString(4, lastName);
            cs.setString(5, address);
            cs.setString(6, phoneNumber);
            cs.setString(7, postalNumber);
            cs.setString(8, email);
            cs.setInt(9, skillType);
            
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
                System.out.println("Failed to close connection! @DBHandler createEmployee\n" + ex.getLocalizedMessage());
            }
        }
        return rowCount >= 0;
    }

    public void retrieveEmployees(ICallback owner)
    {
        Connection c = _dbConnector.getConnection();
        ResultSet employees = null;
        
        try
        {
            PreparedStatement ps = c.prepareCall("SELECT * FROM retrieve_employees");
            employees = ps.executeQuery();
            owner.extractValues(employees);
            ps.close();
        }
        catch (SQLException ex)
        {
            System.out.println("Database access issues @DBHandler retrieveEmployees\n" + ex.getLocalizedMessage());
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to close connection! @DBHandler retrieveEmployees\n" + ex.getLocalizedMessage());
            }
        }
    }
    
    public boolean updateEmployee(String employeeID, String personID, String firstName, String lastName, String address, 
                                  String phoneNumber, String postalNumber, String email, int skillType)
    {
        Connection c = _dbConnector.getConnection();
        
        CallableStatement cs = null;
        int rowCount = -1;
        
        try
        {
            cs = c.prepareCall("{call update_employee(?,?,?,?,?,?,?,?)}");
            //cs.setString(1, employeeID);  //This will be changed in future iterations when Employee "evolves". Same goes for the sql queries.
            cs.setString(1, personID);
            cs.setString(2, firstName);
            cs.setString(3, lastName);
            cs.setString(4, address);
            cs.setString(5, phoneNumber);
            cs.setString(6, postalNumber);
            cs.setString(7, email);
            cs.setInt(8, skillType);
            
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
                System.out.println("Failed to close connection! @DBHandler updateEmployee\n" + ex.getLocalizedMessage());
            }
        }
        return rowCount >= 0;
    }   
    
    //Service Methods:
     public boolean createService(String id, double price, String description, int type, int state, int garageThatStartedService)
    {
        Connection c = _dbConnector.getConnection();
        
        CallableStatement cs = null;
        int rowCount = -1;
        
        try
        {
            cs = c.prepareCall("{call create_service(?,?,?,?,?,?)}");
            cs.setString(1, id);
            cs.setDouble(2, price);
            cs.setString(3, description);
            cs.setInt(4, type);
            cs.setInt(5, state);
            cs.setInt(6, garageThatStartedService);
            
            
            rowCount = cs.executeUpdate();
            
            cs.close();
            
        }
        catch (SQLException ex)
        {
            System.out.println("Error when creating Service in DB!\n" + ex.getLocalizedMessage());
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to close connection! @DBHandler createService\n" + ex.getLocalizedMessage());
            }
        }
        
        return rowCount >= 0; 
    }
    
    public void retrieveServices(ICallback owner)
    {
        Connection c = _dbConnector.getConnection();
        ResultSet allServices = null;
        
        try
        {
            PreparedStatement ps = c.prepareCall("SELECT * FROM retrieve_all_services");
            allServices = ps.executeQuery();    
            
            owner.extractValues(allServices);
            
            ps.close();
        }
        catch (SQLException ex)
        {
            System.out.println("SQLException @retrieveServices - DBHandler\n" + ex.getLocalizedMessage());
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to close connection! @DBHandler retrieveServices\n" + ex.getLocalizedMessage());
            }
        }
    }

    public boolean updateService(String id, String saleID, double price, String description, int type, int state, int garageThatStartedService)
    {
        Connection c = _dbConnector.getConnection();
        
        CallableStatement cs = null;
        int rowCount = -1;
        
        try
        {
            cs = c.prepareCall("{call update_service(?,?,?,?,?,?,?)}");
            cs.setString(1, id);
            cs.setString(2, saleID);
            cs.setDouble(3, price);
            cs.setString(4, description);
            cs.setInt(5, type);
            cs.setInt(6, state);
            cs.setInt(7, garageThatStartedService);
           
            
            rowCount = cs.executeUpdate();
            
            cs.close();
            
        }
        catch (SQLException ex)
        {
            System.out.println("Error when updating Service in DB!\n" + ex.getLocalizedMessage());
        }
        
        
        return rowCount >= 0; 
    }

    public boolean deleteService(String id)
    {
        Connection c = _dbConnector.getConnection();
        int rowCount = -1;
        
        try
        {
            CallableStatement cs = c.prepareCall("{call delete_service(?)}");
            cs.setString(1, id);
            
            rowCount = cs.executeUpdate();
            cs.close();
        }
        catch (SQLException ex)
        {
            System.out.println("Error when deleting a Service in DB!\n" + ex.getLocalizedMessage() + "\n@DBHandler deleteService");
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to close connection! @DBHandler deleteService\n" + ex.getLocalizedMessage());
            }
        }
        
        return rowCount >= 0; 
    }
    
    public boolean createSale(String id, String empID, String custID, Date saleDate, Date dueDate, String[] carIDs, String[] serviceIDs, double amountPaid, double tax)
    {
        System.out.println("CreateSale on DB Level - Pre-Connecting");
        Connection c = _dbConnector.getConnection();
        System.out.println("CreateSale on DB Level!!!");
        CallableStatement cs = null;
        int rowCount = -1;
        
        try
        {
            //Create Sale
            cs = c.prepareCall("{call create_sale(?,?,?,?,?,?,?)}");
            cs.setString(1, id);
            cs.setString(2, empID);
            cs.setString(3, custID);
            cs.setDate(4, saleDate);
            cs.setDate(5, dueDate);
            cs.setDouble(6, amountPaid);
            cs.setDouble(7, tax);
            
            rowCount = cs.executeUpdate();
            cs.close();
            
            if(rowCount >= 0) //Only continue if the initial creation succeeded!
            {
                System.out.println("Create sale - Modify Cars & Services");
                //Create / update many-side
                for(int i = 0; i < carIDs.length; i++)
                {
                    
                    cs = c.prepareCall("{call update_saleid_on_car(?,?)}");

                    cs.setString(1, carIDs[i]);
                    cs.setString(2, id);
                    
                    rowCount = cs.executeUpdate();
                    System.out.println("car with ID: " + carIDs[i] + " has been updated!");
                }

                for(int i = 0; i < serviceIDs.length; i++)
                {
                    cs = c.prepareCall("{call update_saleid_on_service(?,?)}"); 

                    cs.setString(1, serviceIDs[i]);
                    cs.setString(2, id);
                    rowCount = cs.executeUpdate();
                    System.out.println("Service with ID: " + serviceIDs[i] + " has been updated!");    
                }
            }
        }
        catch (SQLException ex)
        {
            System.out.println("Error when creating Sale in DB!\n" + ex.getLocalizedMessage());
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to close connection! @DBHandler createSale\n" + ex.getLocalizedMessage());
            }
        }
        return rowCount >= 0; 
    }
    
    public void retrieveSales(ICallback owner) 
    {
        Connection c = _dbConnector.getConnection();
        ResultSet sales = null;
        
        try
        {
            PreparedStatement ps = c.prepareCall("SELECT * FROM retrieve_all_sales");
            sales = ps.executeQuery();    
            
            owner.extractValues(sales);
            
            ps.close();
        }
        catch (SQLException ex)
        {
            System.out.println("SQLException @retrieveSales - DBHandler\n" + ex.getLocalizedMessage());
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to close connection! @DBHandler retrieveSales\n" + ex.getLocalizedMessage());
            }
        }
    }
    
    public boolean updateSale(String id, String empID, String custID, Date saleDate, Date dueDate, String[] carIDs, String[] serviceIDs, double amountPaid, double tax)
    {
        Connection c = _dbConnector.getConnection();
        
        CallableStatement cs = null;
        int rowCount = -1;
        
        try
        {
            //Update Sale
            cs = c.prepareCall("{call update_sale(?,?,?,?,?,?,?)}");
            cs.setString(1, id);
            cs.setString(2, empID);
            cs.setString(3, custID);
            cs.setDate(4, saleDate);
            cs.setDate(5, dueDate);
            cs.setDouble(6, amountPaid);
            cs.setDouble(7, tax);
            
            rowCount = cs.executeUpdate();
            cs.close();
            
            if(rowCount >= 0) //Only continue if the initial creation succeeded!
            {
               //Create / update many-side
                for(int i = 0; i < carIDs.length; i++)
                {
                    
                    cs = c.prepareCall("{call update_saleid_on_car(?,?)}");

                    cs.setString(1, carIDs[i]);
                    cs.setString(2, id);
                    rowCount = cs.executeUpdate();
                }

                for(int i = 0; i < serviceIDs.length; i++)
                {
                    cs = c.prepareCall("{call update_saleid_on_service(?,?)}"); 

                    cs.setString(1, serviceIDs[i]);
                    cs.setString(2, id);
                    rowCount = cs.executeUpdate();
                }
            }
        }
        catch (SQLException ex)
        {
            System.out.println("Error when updating Sale in DB!\n" + ex.getLocalizedMessage());
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to close connection! @DBHandler updateSale\n" + ex.getLocalizedMessage());
            }
        }
        return rowCount >= 0; 
    }
    
    public boolean deleteSale(String id)
    {
        Connection c = _dbConnector.getConnection();
        int rowCount = -1;
        
        try
        {
            CallableStatement cs = c.prepareCall("{call delete_sale(?)}");
            cs.setString(1, id);

            rowCount = cs.executeUpdate();
            
            cs.close();
        }
        catch (SQLException ex)
        {
            System.out.println("Error when deleting a Sale in DB!\n" + ex.getLocalizedMessage() + "\n@DBHandler deleteSale");
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to close connection! @DBHandler deleteSale\n" + ex.getLocalizedMessage());
            }
        }
        return rowCount >= 0; 
    }

    public void retrieveSlots(ICallback owner)
    {
        Connection c = _dbConnector.getConnection();
        ResultSet slots = null;
        
        try
        {
            PreparedStatement ps = c.prepareCall("SELECT * FROM retrieve_all_slots");
            slots = ps.executeQuery();    
            
            owner.extractValues(slots);
            
            ps.close();
        }
        catch (SQLException ex)
        {
            System.out.println("SQLException @retrieveSlots - DBHandler\n" + ex.getLocalizedMessage());
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to close connection! @DBHandler retrieveSlots\n" + ex.getLocalizedMessage());
            }
        }
    }

    public void retrieveWaitingList(ICallback owner)
    {
        Connection c = _dbConnector.getConnection();
        ResultSet waitingPositions = null;
        
        try
        {
            PreparedStatement ps = c.prepareCall("SELECT * FROM retrieve_all_waiting_positions");
            waitingPositions = ps.executeQuery();    
            
            owner.extractValues(waitingPositions);
            
            ps.close();
        }
        catch (SQLException ex)
        {
            System.out.println("SQLException @retrieveWaitingList - DBHandler\n" + ex.getLocalizedMessage());
        }
        finally
        {
            try
            {
                c.close();
            }
            catch (SQLException ex)
            {
                System.out.println("Failed to close connection! @DBHandler retrieveWaitingList\n" + ex.getLocalizedMessage());
            }
        }
    }
}
