package planningformen.technical;

import java.sql.ResultSet;
import planningformen.core.DBConnector;
/**
 *
 * @author MKJ
 */
public class DBHandler
{
    private DBConnector _dbConnector;
    
    public DBHandler()
    {
        _dbConnector = new DBConnector();
    }
    
    //Customer Methods
    
    public boolean createCustomer(String customerID, String personID, String firstName, String lastName, String address, String phoneNumber, String postalNumber, String email)
    {
        return true;
    }
    
    public ResultSet retrieveCustomer(String customerID)
    {
        return null;
    }
    
    public ResultSet retrieveCustomers()
    {
        return null;
    }
    
    public boolean updateCustomer(String customerID, String personID, String firstName, String lastName, String address, String phoneNumber, String postalNumber, String email)
    {
        return true;
    }
    
    public boolean deleteCustomer(String customerID)
    {
        return true;
    }
}
