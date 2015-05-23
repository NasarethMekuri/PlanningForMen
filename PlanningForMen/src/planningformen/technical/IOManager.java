<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
=======
>>>>>>> origin/master
package planningformen.technical;

/**
 *
<<<<<<< HEAD
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
=======
 * @author MKJ
 */
public class IOManager
{
    private DBHandler _dbHandler;
    private static IOManager _instance;
    
    private IOManager()
    {
        _dbHandler = new DBHandler();
    }
    
    public static IOManager getInstance() { return _instance; }
    public DBHandler getDBHandler() { return _dbHandler; }
>>>>>>> origin/master
}
