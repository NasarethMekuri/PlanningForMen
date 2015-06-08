package planningformen.application;

import planningformen.domain.Master;
/**
  * @author MKJ
 */
public class EmployeeController implements IEmployeeController
{
    public boolean createEmployee(String personID, String firstName, String lastName, String address, String phoneNumber,
            String postalNumber, String email, int skillType)
    {
        return Master.getInstance().getEmployeeManager().createEmployee(personID, firstName, lastName, address, phoneNumber, postalNumber, email, skillType);
    }
}
