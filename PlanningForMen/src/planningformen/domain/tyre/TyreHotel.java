/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen.domain.tyre;

import java.sql.Date;
import java.util.ArrayList;
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
        _waitingList = _waitingListConverter.retrieveWaitingList();
        
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
    
    public Slot findSlot(String position)
    {
        if (position.length() > 8)
        {
            return null;
        }
        else
        {
            for (int i = 0; i < position.length(); i++)
            {
                if (position.charAt(i) != '0' || position.charAt(i) != '1')
                {
                    return null;
                }
            }
        }
        return findSlot(position.substring(3), position.substring(1, 3), position.substring(0, 1));
    }
    
    private Slot findSlot(String x, String y, String z)
    {
        return _slots[_slotConverter.convertStringToByte(z)][_slotConverter.convertStringToByte(y)][_slotConverter.convertStringToByte(x)];
    }
    
    public List<Slot> findSlotsByCustomer(Customer c)
    {
        List<Slot> temp = new ArrayList<>();
        
        for (Slot[][] z : _slots)
        {
            for (Slot[] y : z)
            {
                for (Slot s:  y)
                {
                    if (s != null)
                    {
                        if (s.getCustomerID().equals(c.getCustomerID()))
                        {
                            temp.add(s);
                        }
                    }
                }
            }
        }
        return temp;
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
    
    public boolean reserveSlot(Customer cust, String position)
    {
        if (position.length() > 8)
        {
            return false;
        }
        else
        {
            for (int i = 0; i < position.length(); i++)
            {
                if (position.charAt(i) != '0' || position.charAt(i) != '1')
                {
                    return false;
                }
            }
        }
        return reserveSlot(cust, position.substring(3), position.substring(1, 3), position.substring(0, 1));
    }
    
    public boolean reserveSlot(Customer cust, String x, String y, String z)
    {
        Slot s = _slots[_slotConverter.convertStringToByte(z)][_slotConverter.convertStringToByte(y)][_slotConverter.convertStringToByte(x)];
        byte b = _slotConverter.convertStringToByte(z+y+x);
        
        Calendar c = GregorianCalendar.getInstance();
        Date today = new Date(c.getTimeInMillis());
        c.add(Calendar.MONTH, 6);
        Date freeDate = new Date(c.getTimeInMillis());
        
        //checking if slot is unused, or the occupants' time has expired.
        if (s == null)
        {
            return _slotConverter.createSlot(new Slot(b, cust.getCustomerID(),freeDate)); //new Slot because (not s), because it can be null
        }
        else if (s.getFreeDate().before(today))
        {
            return _slotConverter.createSlot(new Slot(b, cust.getCustomerID(),freeDate));
        }
        else
        {
            System.out.println("TRYING TO RESERVE OCCUPIED SLOT @TyreHotel -  reserveSlot");
        }
        return false;
    }
    
    public boolean reserveSlot(Customer cust, Slot s)
    {
        return reserveSlot(cust, s.getBinaryStringPosition());
    }
    
    public boolean updateSlot(Slot s)
    {
        String binaryString = s.getBinaryStringPosition();
        byte z = _slotConverter.convertStringToByte(binaryString.substring(0, 1));
        byte y = _slotConverter.convertStringToByte(binaryString.substring(1, 3));
        byte x = _slotConverter.convertStringToByte(binaryString.substring(3));
        
        if (_slotConverter.updateSlot(s))
        {
            _slots[z][y][x] = s;
            return true;
        }
        return false;
    }
    
    public boolean endReservation(Slot s)
    {
        String binaryString = s.getBinaryStringPosition();
        byte z = _slotConverter.convertStringToByte(binaryString.substring(0, 1));
        byte y = _slotConverter.convertStringToByte(binaryString.substring(1, 3));
        byte x = _slotConverter.convertStringToByte(binaryString.substring(3));
        
        Calendar c = GregorianCalendar.getInstance();
        Date today = new Date(c.getTimeInMillis());
        
        if (s.getFreeDate().after(today) && _slotConverter.deleteSlot(s))
        {
            _slots[z][y][x] = null;
            return true;
        }
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
        Slot s = _slots[_slotConverter.convertStringToByte(z)][_slotConverter.convertStringToByte(y)][_slotConverter.convertStringToByte(x)];
        
        byte zByte = _slotConverter.convertStringToByte(z);
        byte yByte = _slotConverter.convertStringToByte(y);
        byte xByte = _slotConverter.convertStringToByte(x);
        
        
        Calendar c = GregorianCalendar.getInstance();
        Date today = new Date(c.getTimeInMillis());
        
        if (s == null)
        {
            System.out.println("There is no need to end this reservation!");
            return false;
        }
        else if (s.getFreeDate().after(today) && _slotConverter.deleteSlot(s))
        {
            _slots[zByte][yByte][xByte] = null;
            return true;
        }
        return false;
    }
    
    public boolean endReservation(Customer cust)
    {
        List<Slot> customersSlots = findSlotsByCustomer(cust);
        for (Slot s : customersSlots)
        {
            return endReservation(s.getBinaryStringPosition());
        }
        return false;
    }
    
    public SlotConverter getSlotConverter() //used for testing
    {
        return _slotConverter;
    }
    
    public int addCustomerToWaitingList(Customer c)
    {
        if (true)
        {
            _waitingList.add(c.getCustomerID());

            for (int i = 0; i < _waitingList.size(); i++)
            {
                if (_waitingList.get(i).equals(c.getCustomerID()))
                {
                    return i;
                }
            }    
        }
        return -1;
    }
    
    
}
