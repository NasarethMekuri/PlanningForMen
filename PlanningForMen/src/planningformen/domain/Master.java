/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.domain;

import planningformen.domain.financeandefficiency.SaleManager;
import planningformen.domain.financeandefficiency.ServiceManager;
import planningformen.domain.financeandefficiency.TransactionManager;
import planningformen.domain.planning.CarManager;
import planningformen.domain.planning.CustomerManager;
import planningformen.domain.planning.EmployeeManager;
import planningformen.domain.tyre.TyreHotel;
import planningformen.domain.tyre.TyreManager;

/**
 *
 * @author Simon
 */
public class Master
{
    private static Master _instance;
    private CustomerManager _customerManager;
    private EmployeeManager _employeeManager;
    private CarManager _carManager;
    private ServiceManager _serviceManager;
    private TransactionManager _transactionManager;
    private TyreHotel _tyreHotel;
    private TyreManager _tyreManager;
    private SaleManager _saleManager;
    
    private  Master()
    {
        _customerManager = _customerManager.getInstance();
        _carManager = _carManager.getInstance();
        _employeeManager = EmployeeManager.getInstance();
        _serviceManager = _serviceManager.getInstance();
        _transactionManager = _transactionManager.getInstance();
        _tyreHotel = TyreHotel.getInstance();
        _tyreManager = TyreManager.getInstance();
        _saleManager = SaleManager.getInstance();
    }
    
    public static synchronized Master getInstance()
    {
        if (_instance == null)
        {
            _instance = new Master();
        }
        return _instance;
    }

    
    public CustomerManager getCustomerManager()         {return _customerManager;}
    public EmployeeManager getEmployeeManager()         {return _employeeManager; }
    public CarManager getCarManager()                   {return _carManager;}
    public ServiceManager getServiceManager()           {return _serviceManager;}
    public TransactionManager getTransactionManager()   {return _transactionManager;}
    public TyreHotel getTyreHotel()                     {return _tyreHotel;}
    public TyreManager getTyreManager()                 {return _tyreManager; }
    public SaleManager getSaleManager()                 {return _saleManager; }
    
    
    
}
