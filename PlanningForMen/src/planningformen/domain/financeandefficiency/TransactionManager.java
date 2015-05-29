/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.domain.financeandefficiency;

import java.sql.Date;

/**
 *
 * @author Simon
 */
public class TransactionManager
{
    private static TransactionManager _instance;
    private SaleManager _saleManager;
    private PurchaseManager _purchaseManager;

    private TransactionManager()
    {
    }
    
    public static synchronized TransactionManager getInstance()
    {
        if (_instance == null)
        {
            _instance = new TransactionManager();
        }
        return _instance;
    }
    
    
    public boolean createTransactionsFile(Date fromDate, Date toDate)
    {
        return false; //TODO: work-work
    }
    
    public SalesNumbers retrieveyearlySales(int year)
    {
        return null; //TODO work-work
    }
    
    private SalesNumbers generateNewSalesNumbers()
    {
        return null; //TODO work-work
    }
    
}
