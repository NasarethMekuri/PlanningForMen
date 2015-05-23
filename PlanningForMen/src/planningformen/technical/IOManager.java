/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.technical;

/**
 *
 * @author Cymon343
 */
public class IOManager
{
    private static IOManager _instance;
    private DBHandler _dbHandler;

    private  IOManager()
    {
        this._dbHandler = new DBHandler();
    }
    
    public static synchronized IOManager getInstance()
    {
        if (_instance == null)
        {
            _instance = new IOManager();
        }
        return _instance;
    }

    
    public DBHandler getDbHandler()     {return _dbHandler;}
}
