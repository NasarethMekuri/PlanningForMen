/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.application;

/**
 *
 * @author Simon
 */
public interface IEmployeeController
{
    public boolean createEmployee(String personID, String firstName, String lastName, String address, String phoneNumber,
            String postalNumber, String email, int skillType);
}
