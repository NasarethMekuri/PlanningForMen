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
    private ServiceType _type, _garageType;
    private ServiceState _state;
    private double _price;
    private String _description, _id , _saleID;
    
    public Service(double price, String description, ServiceType type) //@SBL/MKJ --> Should state be added here???
    {
        this._id = UUID.randomUUID().toString(); 
        this._price = price;
        this._description = description;
        this._type = type;
        this._state = ServiceState.PENDING;
        this._garageType = null;
    }
    
    public Service(String ID, String saleID, double price, String description, ServiceType type, ServiceState state, ServiceType garage)
    {
        this._id = ID;
        this._saleID = saleID;
        this._price = price;
        this._description = description;
        this._type = type;
        this._state = state;
        this._garageType = garage;
    }
    
    //Accessors
    public String getId()                               {return _id;}
    @Override
    public double getSellPrice()                        {return _price;}
    public String getDescription()                      {return _description;}
    public ServiceType getType()                        {return _type;}
    public ServiceState getState()                      {return _state;}
    public ServiceType getGarageType()                  {return _garageType;}
    public String getSaleID()                           {return _saleID;}
    
    
    
    //Mutators
    public void setType(ServiceType _type)                                          {this._type = _type;}
    public void setGarageType(ServiceType _garageThatStartedService)                {this._garageType = _garageThatStartedService;}
    public void setState(ServiceState _state)                                       {this._state = _state;}
    public void setPrice(double _price)                                             {this._price = _price;}
    public void setDescription(String _description)                                 {this._description = _description;}
    public void setSaleID(String saleID)                                            {this._saleID = saleID;}
}
