/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.domain.tyre;

import java.util.ArrayList;
import java.util.List;
import planningformen.business.SlotConverter;
import planningformen.business.WaitingListConverter;
import planningformen.domain.planning.Customer;

/**
 *
 * @author bruger
 */
public class TyreHotel
{
    private static TyreHotel _instance;
    private Slot[] _slots;
    private List<Customer> _waitingList;
    private SlotConverter _slotConverter;
    private WaitingListConverter _waitingListConverter;

    private TyreHotel()
    {
        _slots = new Slot[150];
        //_slotConverter.retrieveSlots();
        _waitingList = new ArrayList();
        //_waitingListConverter.retrieveWaitingList();
        
        _slotConverter = new SlotConverter();
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
    public Slot[] getSlots()                {return _slots;}
    public List<Customer> getWaitingList()  {return _waitingList;}
    
    public Slot findSlotByCustomer(Customer c)
    {
        for (Slot s : _slots)
        {
            if (!s.isFree())
            {
                if (s.getCustomer().getCustomerID().equals(c.getCustomerID()))
                {
                    return s;
                }
            }
        }
        return null;
    }

    public SlotConverter getSlotConverter()
    {
        return _slotConverter;
    }

    public WaitingListConverter getWaitingListConverter()
    {
        return _waitingListConverter;
    }
    
    
    
    
}
