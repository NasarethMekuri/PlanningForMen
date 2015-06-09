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
public abstract class Person
{
    protected String id;
    protected String firstName;
    protected String lastName;
    protected String address;
    protected String phoneNumber;
    protected String postalNumber;
    protected String email;
    
    public Person(String id, String firstName, String lastName, String address, String phoneNumber, String postalNumber, String email)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.postalNumber = postalNumber;
        this.email = email;
    }
    
    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAddress() { return address; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getPostalNumber() { return postalNumber; }
    public String getEmail() { return email; }

    public void setId(String id) { this.id = id; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAddress(String address) { this.address = address; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setPostalNumber(String postalNumber) { this.postalNumber = postalNumber; }
    public void setEmail(String email) { this.email = email; }
    
    @Override
    public String toString()
    {
        return firstName + " " + lastName;
    }
}
