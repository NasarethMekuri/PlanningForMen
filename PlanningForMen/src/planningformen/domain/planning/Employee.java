package planningformen.domain.planning;

/**
 *
 * @author MKJ
 */
public class Employee extends Person
{
    private String _employeeID;
    private int _skillType;
    
    /***
     * Use this constructor for creating a new employee. This will autogenerate an employeeID.
     * @param personID The ID of the person (CPR number).
     * @param firstName The first (and possible middle) name of the employee.
     * @param lastName The last name of the employee.
     * @param address The address of the employee.
     * @param phoneNumber The phonenumber of the employee.
     * @param postalNumber The postal number of the employee.
     * @param email The E-mail address of the employee.
     */
    public Employee(String personID, String firstName, String lastName, String address, String phoneNumber, 
                    String postalNumber, String email, int skillType)
    {
        super(personID, firstName, lastName, address, phoneNumber, postalNumber, email);
        _employeeID = generateID();
        _skillType = skillType;
    }
    
    /***
     * Use this constructor for creating an employee where the employeeID is already known.
     * eg. Generating this object from data in a database.
     * @param employeeID The id of the employee.
     * @param personID The ID of the person (CPR number).
     * @param firstName The first (and possible middle) name of the employee.
     * @param lastName The last name of the employee.
     * @param address The address of the employee.
     * @param phoneNumber The phonenumber of the employee.
     * @param postalNumber The postal number of the employee.
     * @param email The E-mail address of the employee.
     * @param skillType The type of skill this employee has.
     */
    public Employee(String employeeID, String personID, String firstName, String lastName, String address, 
                    String phoneNumber, String postalNumber, String email, int skillType)
    {
        super(personID, firstName, lastName, address, phoneNumber, postalNumber, email);
        _employeeID = employeeID;
        _skillType = skillType;
    }
    
    /**
     * @return the employeeID
     */
    public String getEmployeeID() { return _employeeID; }
    
    /***
     * Generates an employeeID from the first two letters in the first name and last name, as well as the six first of the personID (CPR)
     * eg. firstName = Lars; lastName = Hansen; personID =  0102802235; Would give laha010280 as the employeeID.
     */
    private String generateID()
    {
        return firstName.substring(0, 2) + lastName.substring(0, 2) + id.substring(0, 5);
    }
    
    
    public int getSkillType() { return _skillType; }
    
    public void setSkillType(int skillType) { _skillType = skillType; }
}
