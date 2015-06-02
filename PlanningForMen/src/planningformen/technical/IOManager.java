
package planningformen.technical;

/**
 * @author Cymon343
 */
public class IOManager
{
    private static IOManager _instance;
    private DBHandler _dbHandler;
    private FileHandler _fileHandler;

    private  IOManager()
    {
        this._dbHandler = new DBHandler();
        _fileHandler = new FileHandler();
    }
    
    public static synchronized IOManager getInstance()
    {
        if (_instance == null)
        {
            _instance = new IOManager();
        }
        return _instance;
    }

    
    public DBHandler getDBHandler()     {return _dbHandler;}
    public FileHandler getFileHandler() {return _fileHandler; }
}
