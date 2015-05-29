/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.domain.financeandefficiency;

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
    }
    
    public static synchronized PurchaseManager getInstance()
    {
        if (_instance == null)
        {
            _instance = new PurchaseManager();
        }
        return _instance;
    }
    
    
}
