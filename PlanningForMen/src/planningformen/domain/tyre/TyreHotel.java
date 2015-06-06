/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen.domain.tyre;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import planningformen.business.SlotConverter;
import planningformen.business.WaitingListConverter;
import planningformen.domain.Master;
import planningformen.domain.planning.Customer;

/**
 *
 * @author bruger
 */
public class TyreHotel
{
    private static TyreHotel _instance;
    private Slot[][][] _slots;
    private List<String> _waitingList;
    private SlotConverter _slotConverter;
    private WaitingListConverter _waitingListConverter;
    
    private TyreHotel()
    {
        _slotConverter = new SlotConverter();
        _waitingListConverter = new WaitingListConverter();
        
        _slots = _slotConverter.retrieveSlots();
        // _waitingList = _waitingListConverter.retrieveWaitingList();
        
    }
    
    public static synchronized TyreHotel getInstance()
    {
        if (_instance == null)
        {
            _instance = new TyreHotel();
        }
        return _instance;
    }
    
    //Accessors
    public Slot[][][] getSlots()                {return _slots;}
    public List<String> getWaitingList()  {return _waitingList;}
    
    public Slot findSlotByCustomer(Customer c)
    {
        for (Slot[][] z : _slots)
        {
            for (Slot[] y : z)
            {
                for (Slot x:  y)
                {
                    if (x != null)
                    {
                        if (x.getCustomerID().equals(c.getCustomerID()))
                        {
                            return x;
                        }
                    }
                }
            }
        }
        return null;
    }
    
    public Customer findCustomerBySlot(Slot slot)
    {
        for (Customer c : Master.getInstance().getCustomerManager().getCustomers())
        {
            if (c.getCustomerID().equals(slot.getCustomerID()))
            {
                return c;
            }
        }
        return null;
    }
    
    public boolean reserveSlot(Customer cust, String binaryString)
    {
        if (binaryString.length() > 8)
        {
            return false;
        }
        else
        {
            for (int i = 0; i < binaryString.length(); i++)
            {
                if (binaryString.charAt(i) != '0' || binaryString.charAt(i) != '1')
                {
                    return false;
                }
            }
        }
        return reserveSlot(cust, binaryString.substring(3), binaryString.substring(1, 3), binaryString.substring(0, 1));
    }
    
    
    public boolean reserveSlot(Customer cust, String x, String y, String z)
    {
        Slot s = _slots[_slotConverter.convertStringToByte(z)][_slotConverter.convertStringToByte(y)][_slotConverter.convertStringToByte(x)];
        byte b = _slotConverter.convertStringToByte(z+y+x);       
        
        
        Calendar c = GregorianCalendar.getInstance();
        Date today = new Date(c.getTimeInMillis());
        c.add(Calendar.MONTH, 6);
        Date freeDate = new Date(c.getTimeInMillis());
        
        if (s == null)
        {
            _slotConverter.createSlot(new Slot(b, cust.getCustomerID(),freeDate));
        }
        else
        {
            System.out.println("TRYING TO RESERVE OCCUPIED SLOT @TyreHotel -  reserveSlot");
        }
        
        //findSlot
        //update slot (insert customer)
        
        return false;
        
    }
    
    public boolean endReservation(String binaryString)
    {
        if (binaryString.length() > 8)
        {
            return false;
        }
        else
        {
            for (int i = 0; i < binaryString.length(); i++)
            {
                if (binaryString.charAt(i) != '0' || binaryString.charAt(i) != '1')
                {
                    return false;
                }
            }
        }
        return endReservation(binaryString.substring(3), binaryString.substring(1, 3), binaryString.substring(0, 1));
    }
    
    public boolean endReservation(String x, String y, String z)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean endReservation(Customer cust)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public SlotConverter getSlotConverter() //used for testing
    {
        return _slotConverter;
    }
    
    
}
