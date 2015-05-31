/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen.domain.financeandefficiency;

import java.util.UUID;
import planningformen.domain.planning.Sellable;

/**
 *
 * @author Simon
 */
public class Service implements Sellable
{
    private ServiceType _type, _garageThatStartedService;
    private ServiceState _state;
    private double _price;
    private String _description, _id;
    
    public Service(double price, String description, ServiceType type) //@SBL/MKJ --> Should state be added here???
    {
        this._id = UUID.randomUUID().toString(); //Maybe NOT
        this._price = price;
        this._description = description;
        this._type = type;
        this._state = ServiceState.PENDING;
        this._garageThatStartedService = null;
    }
    
    public Service(String ID, double price, String description, ServiceType type, ServiceState state, ServiceType garage)
    {
        this._id = ID;
        this._price = price;
        this._description = description;
        this._type = type;
        this._state = state;
        this._garageThatStartedService = garage;
    }
    
    //Accessors
    public String getId()                               {return _id;}
    public double getPrice()                            {return _price;}
    public String getDescription()                      {return _description;}
    public ServiceType getType()                        {return _type;}
    public ServiceState getState()                      {return _state;}
    public ServiceType getGarageThatStartedService()    {return _garageThatStartedService;}
    
    
    
    //Mutators
    public void setType(ServiceType _type)                                          {this._type = _type;}
    public void setGarageThatStartedService(ServiceType _garageThatStartedService)  {this._garageThatStartedService = _garageThatStartedService;}
    public void setState(ServiceState _state)                                       {this._state = _state;}
    public void setPrice(double _price)                                             {this._price = _price;}
    public void setDescription(String _description)                                 {this._description = _description;}
}
