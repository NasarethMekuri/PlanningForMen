/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen.core;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Cymon343
 */
public class DBConnector
{
    
    private final String SERVER_NAME = "localhost";
    private final String DATABASE_INSTANCE = "SQLEXPRESS";
    private final String DATABASE_NAME = "PlanningDB";
    private final int PORTNO = 1433;
    private final String USERNAME = "sa";
    private final String PASSWORD = "Brutalis"; //offlimit
    
    public DBConnector()
    {}
    
    /**
     * Returns the connection
     *
     * @return m_connection
     */
    public Connection getConnection()
    {
        SQLServerDataSource ds = new SQLServerDataSource();
        Connection con = null;
        
        Connection c = null;
        
        //setup of SQLServer
        ds.setServerName(SERVER_NAME);
        ds.setInstanceName(DATABASE_INSTANCE);
        ds.setDatabaseName(DATABASE_NAME);
        ds.setPortNumber(PORTNO);
        ds.setUser(USERNAME);
        ds.setPassword(PASSWORD);
        
        try
        {
            con = ds.getConnection();
            try
            {
                if (!con.isClosed())
                {
                    System.out.println("Connected to DB");
                }
            } catch (SQLException ex)
            {
                System.out.println("Error connecting to DB!\n" + ex.getLocalizedMessage());
            }
        }
        catch (SQLServerException ex)
        {
            System.out.println("Error connecting to DB!\n" + ex.getLocalizedMessage());
        }
        
        return con;
    }
}
