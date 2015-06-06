/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.domain.tyre;

import java.sql.Date;
import planningformen.domain.Master;

/**
 *
 * @author bruger
 */
public class Slot
{
    private byte _position;
    private String _binaryStringPosition, _customerID;
    private boolean _isFree;
    private Date _freeDate;

    public Slot(){}

    public Slot(byte position, String customerID, Date freeDate)
    {
        this._position = position;
        this._customerID = customerID;
        this._freeDate = freeDate;
        this._binaryStringPosition = Master.getInstance().getTyreHotel().getSlotConverter().convertByteToString(position);
    }
    
    //Accessors
    public byte getPosition()               {return _position;}
    public String getBinaryStringPosition() {return _binaryStringPosition;}
    public String getCustomerID()           {return _customerID;}
    public boolean isFree()                 {return _isFree;}
    public Date getFreeDate()               {return _freeDate;}
    //Mutators
    public void setFreeDate(Date freeDate)     {this._freeDate = freeDate;}

    
    
    
    
}
