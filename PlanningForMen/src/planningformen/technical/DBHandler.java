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
 */
public class DBHandler
{
    private DBConnector _dbConnector;
    
    public DBHandler()
    {
        _dbConnector = new DBConnector();
    }
    
    
    
    
    public boolean createCar(String id, String plate, int year, String make, String model, double volume, String fuel, String version,
            int odometer, Date purchaseDate, double purchasePrice, double sellPrice, String description, boolean inStock)
    {
        
        Connection c = _dbConnector.getConnection();
        
        try
        {
            CallableStatement cs = c.prepareCall("call create_car(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
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
            
            if (cs.executeUpdate() > 0)
            {
                return true;
            }
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
                System.out.println("Failed to close database!");
            }
        }
        
        return false;
    }
}
