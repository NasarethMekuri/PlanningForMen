/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.domain.financeandefficiency;

/**
 *
 * @author Simon
 */
public class ServiceManager
{
    private static ServiceManager _instance;

    private ServiceManager()
    {
    }
    
    public static synchronized ServiceManager getInstance()
    {
        if (_instance == null)
        {
            _instance = new ServiceManager();
        }
        return _instance;
    }
    
}
