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
    private String _customerID; 
    
    /***
     * Use this constructor for creating a new Customer.
     * @param personID The ID of the person (CPR number).
     * @param firstName The first (and possible middle) name of the customer.
     * @param lastName The last name of the customer.
     * @param address The address of the customer.
     * @param phoneNumber The phonenumber of the customer.
     * @param postalNumber The postal number of the customer.
     * @param email The E-mail address of the customer.
     */
    public Customer(String personID, String firstName, String lastName, String address, String phoneNumber, String postalNumber, String email)
    {
        super(personID, firstName, lastName, address, phoneNumber, postalNumber, email);
        _customerID = generateID();
    }
    
    /***
     * Use this constructor for creating a customer where the customerID is already known.
     * eg. Generating this object from data in a database.
     * @param customerID The id of the customer.
     * @param personID The ID of the person (CPR number).
     * @param firstName The first (and possible middle) name of the customer.
     * @param lastName The last name of the customer.
     * @param address The address of the customer.
     * @param phoneNumber The phonenumber of the customer.
     * @param postalNumber The postal number of the customer.
     * @param email The E-mail address of the customer.
     */
    public Customer(String customerID, String personID, String firstName, String lastName, String address, String phoneNumber, String postalNumber, String email)
    {
        super(personID, firstName, lastName, address, phoneNumber, postalNumber, email);
        _customerID = customerID;
    }
    
    /**
     * @return the customerID
     */
    public String getCustomerID() { return _customerID; }
    
    /***
     * Generates a customerID from the first two letters in the first name and last name, the phoneNumber, as well as the six first of the personID (CPR)
     * eg. firstName = Lars; lastName = Hansen; phoneNumber = 22334455; personID = 0102802235; Would give laha22334455010280 as the customerID.
     */
    private String generateID()
    {
        return firstName.substring(0, 2) + lastName.substring(0, 2) + phoneNumber + id.substring(0, 6);
    }
}
