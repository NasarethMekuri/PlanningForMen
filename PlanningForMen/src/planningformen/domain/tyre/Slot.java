/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.domain.tyre;

import java.sql.Date;
import planningformen.domain.planning.Customer;

/**
 *
 * @author bruger
 */
public class Slot
{
    private byte _position;
    private String _binaryStringPosition;
    private Customer _customer;
    private boolean _isFree;
    private Date _freeDate;

    public Slot()
    {
        
    }
    
    //Accessors
    public byte getPosition()               {return _position;}
    public String getBinaryStringPosition() {return _binaryStringPosition;}
    public Customer getCustomer()           {return _customer;}
    public boolean isFree()                 {return _isFree;}
    public Date getFreeDate()               {return _freeDate;}
    //Mutators
    public void setCustomer(Customer customer) {this._customer = customer;}
    public void setFreeDate(Date freeDate)     {this._freeDate = freeDate;}

    
    
    
    
}
