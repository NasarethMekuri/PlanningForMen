/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.domain.planning;

/**
 *
 * @author Simon
 */
public class CarManager
{
    private static CarManager _instance;

    private CarManager()    {}
    
    public static synchronized CarManager getIstance()
    {
        if (_instance == null)
        {
            _instance = new CarManager();
        }
        return _instance;
    }
    
}
