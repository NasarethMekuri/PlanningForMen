/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.core;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;

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
        
        //setup of SQLServer
        ds.setServerName(SERVER_NAME);
        ds.setInstanceName(DATABASE_INSTANCE);
        ds.setDatabaseName(DATABASE_NAME);
        ds.setPortNumber(PORTNO);
        ds.setUser(USERNAME);
        ds.setPassword(PASSWORD);
        
        return ds.getConnection();
    }
}
