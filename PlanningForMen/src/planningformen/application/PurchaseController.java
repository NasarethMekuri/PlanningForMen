/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.application;

import java.sql.Date;
import java.util.List;
import planningformen.domain.financeandefficiency.Purchase;

/**
 *
 * @author Simon
 */
public class PurchaseController implements IPurchaseController
{

    @Override
    public List<Purchase> findPurchases(int year)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Purchase> findpurchases(Date fromDate, Date toDate)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
