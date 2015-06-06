/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.domain.financeandefficiency;

import java.util.List;
import planningformen.domain.planning.Car;
import planningformen.domain.planning.Customer;
import planningformen.domain.planning.Employee;
import planningformen.domain.tyre.Tyre;

/**
 *
 * @author Morten
 */
public interface ISaleCallback
{
    public Employee getEmployeeByID(String empID);
    public Customer getCustomerByID(String custID);
    public List<Car> getCarsBySaleID(String saleID);
    public List<Service> getServicesBySaleID(String saleID);
    public List<Tyre> getTyresBySaleID(String saleID);
}
