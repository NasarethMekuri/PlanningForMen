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
public interface IPurchaseController
{
    public List<Purchase> findPurchases(int year);
    public List<Purchase> findpurchases(Date fromDate, Date toDate);
}
