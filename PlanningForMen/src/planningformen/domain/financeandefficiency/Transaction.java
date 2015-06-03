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
public interface Transaction
{
    public double getTotalPrice();
    public Date getTransactionDate();
}
