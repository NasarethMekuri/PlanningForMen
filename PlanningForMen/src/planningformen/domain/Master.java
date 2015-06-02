/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.domain;

import planningformen.domain.financeandefficiency.ServiceManager;
import planningformen.domain.financeandefficiency.TransactionManager;
import planningformen.domain.planning.CarManager;
import planningformen.domain.planning.CustomerManager;

/**
 *
 * @author Simon
 */
public class Master
{
    private static Master _instance;
    private CustomerManager _customerManager;
    private CarManager _carManager;
    //TODO: Der mangler en EmployeeManager
    private ServiceManager _serviceManager;
    private TransactionManager _transactionManager;
    
    private  Master()
    {
        _customerManager = _customerManager.getInstance();
        _carManager = _carManager.getInstance();
        //TODO: Der mangler en EmployeeManager
        _serviceManager = _serviceManager.getInstance();
        _transactionManager = _transactionManager.getInstance();
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
    public CarManager getCarManager()                   {return _carManager;}
    public ServiceManager getServiceManager()           {return _serviceManager;}
    public TransactionManager getTransactionManager()   {return _transactionManager;}
    
    
    
}