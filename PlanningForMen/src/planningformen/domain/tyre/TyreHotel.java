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
    
    public Slot findSlot(String x, String y, String z)
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
        byte bytePosition = _slotConverter.convertStringToByte(position);
        return reserveSlot(cust, bytePosition);
    }
    
    public boolean reserveSlot(Customer cust, String x, String y, String z) //main
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
            return false;
        }
    }
    
    public boolean reserveSlot(Customer cust, Slot s)
    {
        return reserveSlot(cust, s.getBinaryStringPosition());
    }
    
    public boolean reserveSlot(Customer cust, byte position)
    {
        String binaryPosition = _slotConverter.convertByteToString(position);
        
        return reserveSlot(cust, binaryPosition.substring(3),binaryPosition.substring(1,3), binaryPosition.substring(0,1));
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
        
        String x = binaryString.substring(3);
        String y = binaryString.substring(1,3);
        String z = binaryString.substring(0,1);
        
        return endReservation(x, y, z);
    }
    
    public boolean endReservation(String position)
    {
        Byte b = _slotConverter.convertStringToByte(position);
        
        return endReservation(b);
    }
    
    public boolean endReservation(Byte position)
    {
        String binaryString = _slotConverter.convertByteToString(position);
        
        return endReservation(binaryString.substring(3), binaryString.substring(1, 3), binaryString.substring(0, 1));
    }
    
    public boolean endReservation(String x, String y, String z) //main
    {
        byte zByte = _slotConverter.convertStringToByte(z);
        byte yByte = _slotConverter.convertStringToByte(y);
        byte xByte = _slotConverter.convertStringToByte(x);
        
        Slot s = _slots[zByte][yByte][xByte];
        
        Calendar c = GregorianCalendar.getInstance();
        Date today = new Date(c.getTimeInMillis());
        
        if (s == null)
        {
            System.out.println("Trying to end reservation on a Slot that does not exist");
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
    
    /**
     * This method adds a Customer to the waiting list, and stores his index in the DB.
     * @param c the customer to add to the List.
     * @return int the Customers' "number in line" on the waiting list.
     */
    public int addCustomerToWaitingList(Customer c)
    {
        int nextFreeIndex = _waitingList.size();
        
        if (_waitingListConverter.createWaitingPosition(nextFreeIndex, c.getCustomerID()))
        {
            _waitingList.add(nextFreeIndex, c.getCustomerID());
            
            return nextFreeIndex;
        }
        return -1;
    }
    
    public boolean removeCustomerFromWaitingList(Customer c)
    {
        int index = 0;
        
        for (String custID : _waitingList)
        {
            if (custID.equals(c.getCustomerID()))
            {
                if (_waitingListConverter.deleteWaitingPosition(index))
                {
                    _waitingList.remove(index);
                    updateAllCustomersWaitingPositions();
                    return true;
                }
            }
            index ++;
        }
        return false;
    }
    
    private void updateAllCustomersWaitingPositions()
    {
        for (int i = 0; i < _waitingList.size(); i++)
        {
            String custID = _waitingList.get(i);
            _waitingListConverter.updateWaitingPosition(i, custID);
        }
    }
}
