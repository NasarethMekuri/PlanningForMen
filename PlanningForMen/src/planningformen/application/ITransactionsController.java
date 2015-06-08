/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.application;

import java.sql.Date;

/**
 *
 * @author Simon
 */
public interface ITransactionsController
{
     public boolean createTransactionsFile(Date fromDate, Date toDate);
}
