/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.application;

import java.util.List;
import planningformen.domain.planning.Customer;
import planningformen.domain.tyre.Slot;

/**
 *
 * @author Simon
 */
public interface IHotelController
{
    public Slot findSlot(String position);
    public Slot findSlot(String x, String y, String z);
    public List<Slot> findSlotsByCustomer(Customer c);
    public Customer findCustomerBySlot(Slot slot);
    public boolean reserveSlot(Customer cust, String position);
    public boolean reserveSlot(Customer cust, String x, String y, String z);
    public boolean reserveSlot(Customer cust, Slot s);
    public boolean reserveSlot(Customer cust, byte position);
    public boolean updateSlot(Slot s);
    public boolean endReservation(Slot s);
    public boolean endReservation(String position);
    public boolean endReservation(Byte position);
    public boolean endReservation(String x, String y, String z);
    public boolean endReservation(Customer cust);
    public int addCustomerToWaitingList(Customer c);
    public boolean removeCustomerFromWaitingList(Customer c);
}
