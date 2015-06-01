/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen.domain.financeandefficiency;

import java.util.ArrayList;
import planningformen.domain.planning.Employee;

/**
 *
 * @author Simon
 */
public class GarageFactory 
{
    private static GarageFactory _instance;
    private Garage _dieselGarage, _normalGarage, _tuningGarage;
    
    private GarageFactory()
    {
    }
    
    public static synchronized GarageFactory getInstance()
    {
        if (_instance == null)
        {
            _instance = new GarageFactory();
        }
        return _instance;
    }
    
    public Garage getGarage(ServiceType type)
    {
        switch (type.getNumericValue())
        {
            case 1:
                if (_dieselGarage == null)
                {
                    _dieselGarage = new SubGarage(type);
                    return _dieselGarage;
                }
                return _dieselGarage;
            case 2:
                if (_normalGarage == null)
                {
                    _normalGarage = new SubGarage(type);
                    return _normalGarage;
                }
                return _normalGarage;
            case 3:
                if (_tuningGarage == null)
                {
                    _tuningGarage = new SubGarage(type);
                    return _tuningGarage;
                }
                return _tuningGarage;
            default:
                return null;
        }
        
        
    }
    
    private class SubGarage extends Garage
    {
         public SubGarage(ServiceType _type)
        {
            this._type = _type;
            this._employees = new ArrayList<Employee>();
            this._jobs = new ArrayList<Service>();
        }
    }
}
