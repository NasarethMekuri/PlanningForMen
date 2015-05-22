package planningformen.technical;

/**
 *
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
}
