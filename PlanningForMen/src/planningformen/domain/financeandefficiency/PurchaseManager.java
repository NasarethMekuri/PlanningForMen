/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen.domain.financeandefficiency;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Simon
 */
public class PurchaseManager
{
    private static PurchaseManager _instance;
    private List<Purchase> _purchases;
    
    private  PurchaseManager()
    {
        _purchases = new ArrayList<>();
        _purchases.add(new Purchase("2014-11-24"));
        _purchases.add(new Purchase("2015-06-22"));
        _purchases.add(new Purchase("2014-07-02"));
        _purchases.add(new Purchase("2014-06-18"));
        _purchases.add(new Purchase("2015-01-01"));
    }
    
    public static synchronized PurchaseManager getInstance()
    {
        if (_instance == null)
        {
            _instance = new PurchaseManager();
        }
        return _instance;
    }
    
    public List<Purchase> findPurchases(int year)
    {
        Date startDate = new Date(year - 1, 12, 31);
        Date endDate = new Date(year + 1, 1, 1);
        List<Purchase> tmpList = new ArrayList<Purchase>();
        for(Purchase p : _purchases)
        {
            if(p.getPurchaseDate().after(startDate) && p.getPurchaseDate().before(endDate))
            {
                tmpList.add(p);
            }
        }
        return tmpList;
    }
    
    public List<Purchase> findpurchases(Date fromDate, Date toDate)
    {
        List<Purchase> tmpList = new ArrayList<Purchase>();
        for(Purchase p : _purchases)
        {
            if(p.getPurchaseDate().after(fromDate) && p.getPurchaseDate().before(toDate))
            {
                tmpList.add(p);
            }
        }
        return tmpList;
    }
    
    
    
}
