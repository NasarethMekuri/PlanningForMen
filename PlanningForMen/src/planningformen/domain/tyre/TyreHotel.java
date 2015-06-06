/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen.domain.tyre;

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
        _slots = _slotConverter.retrieveSlots();
       // _waitingList = _waitingListConverter.retrieveWaitingList();
        _slotConverter = new SlotConverter();
        _waitingListConverter = new WaitingListConverter();
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
                    if (!x.isFree())
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
    
    public boolean reserveSlot(Customer cust, Slot slot)
    {
        //findSlot
        //update slot (insert customer)
        
        return false;
        
    }
    
    public boolean endReservation(Slot s)
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
