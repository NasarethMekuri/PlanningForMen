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
public class Purchase implements Transaction
{
    private Date _purchaseDate;

    public Purchase(String date)
    {
        _purchaseDate = new Date(0).valueOf(date); //Dummy values only
    }
    
    @Override
    public double getTotalPrice()
    {
        return Math.random() * 1000f; //Dummy value
    }

    public Date getPurchaseDate()
    {
        return _purchaseDate;
    } 

    @Override
    public Date getTransactionDate()
    {
        return getPurchaseDate();
    }
}
