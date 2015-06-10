/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.application;

import java.util.List;
import planningformen.domain.Master;
import planningformen.domain.planning.Customer;
import planningformen.domain.tyre.Slot;

/**
 *
 * @author Simon
 */
public class HotelController implements IHotelController
{

    @Override
    public Slot findSlot(String position)
    {
        return Master.getInstance().getTyreHotel().findSlot(position);
    }

    @Override
    public Slot findSlot(String x, String y, String z)
    {
        return Master.getInstance().getTyreHotel().findSlot(x, y, z);
    }

    @Override
    public List<Slot> findSlotsByCustomer(Customer c)
    {
        return Master.getInstance().getTyreHotel().findSlotsByCustomer(c);
    }

    @Override
    public Customer findCustomerBySlot(Slot slot)
    {
        return Master.getInstance().getTyreHotel().findCustomerBySlot(slot);
    }

    @Override
    public boolean reserveSlot(Customer cust, String position)
    {
        return Master.getInstance().getTyreHotel().reserveSlot(cust, position);
    }

    @Override
    public boolean reserveSlot(Customer cust, String x, String y, String z)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reserveSlot(Customer cust, Slot s)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reserveSlot(Customer cust, byte position)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateSlot(Slot s)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean endReservation(Slot s)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean endReservation(String position)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean endReservation(Byte position)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean endReservation(String x, String y, String z)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean endReservation(Customer cust)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int addCustomerToWaitingList(Customer c)
    {
        return Master.getInstance().getTyreHotel().addCustomerToWaitingList(c);
    }

    @Override
    public boolean removeCustomerFromWaitingList(Customer c)
    {
        return Master.getInstance().getTyreHotel().removeCustomerFromWaitingList(c);
    }
    
    @Override
    public int findWaitingNumberByCustomer(Customer c)
    {
        return Master.getInstance().getTyreHotel().findWaitingNumberByCustomer(c);
    }
    
}
