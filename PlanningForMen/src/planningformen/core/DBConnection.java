/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.core;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Cymon343
 */
public class DBConnection 
{
    private final Connection m_connection;
    
    private final String SERVER_NAME = "localhost";
    private final String DATABASE_INSTANCE = "SQLEXPRESS";
    private final String DATABASE_NAME = "PlanningDB";
    private final int PORTNO = 1433;
    private final String USERNAME = "sa";
    private final String PASSWORD = "Brutalis"; //offlimit

    DBConnection() 
    {
        SQLServerDataSource ds = new SQLServerDataSource();
        
        //setup of SQLServer
        ds.setServerName(SERVER_NAME);
        ds.setInstanceName(DATABASE_INSTANCE);
        ds.setDatabaseName(DATABASE_NAME);
        ds.setPortNumber(PORTNO);
        ds.setUser(USERNAME);
        ds.setPassword(PASSWORD);
        
        //connect
        m_connection = ds.getConnection();
        
        try
        {
            if (!m_connection.isClosed())
            {System.out.println("Successfully connected to Database\n");}
        }
        catch (SQLException ex)
        {
            System.out.println("Could not connect to DataBase\n");
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
    }

    /**
     * Returns the connection
     *
     * @return m_connection
     */
    public Connection getConnection() 
    {
        return m_connection;
    }
}
