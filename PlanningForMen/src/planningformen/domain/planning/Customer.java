/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.domain.planning;

/**
 *
 * @author Simon
 */
public class Customer extends Person
{
        
    public Customer(String id, String firstName, String lastName, String address, String phoneNumber, String postalNumber, String email)
    {
        super(id, firstName, lastName, address, phoneNumber, postalNumber, email);
    }
}
