/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.domain.financeandefficiency;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import planningformen.technical.IOManager;

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
        _saleManager = _saleManager.getInstance();
        _purchaseManager = _purchaseManager.getInstance();
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
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.addAll(_saleManager.findSales(null, fromDate, toDate));
        transactions.addAll(_purchaseManager.findpurchases(fromDate, toDate));
        
        StringBuilder output = new StringBuilder();
        output.append("Transaction log for period " + fromDate.toString() + " to " + toDate.toString() + "\n\n");
        
        for(Transaction t : transactions)
        {
            String text = t.getTransactionDate().toString();
            double price = t.getTotalPrice();
            if(t instanceof Purchase)
            {
                price *= -1;
                text = "Purchase - " + text;
            }
            else
                text = "Sale - " + text;
            text += "\t\t" + price + "\n";
            output.append(text);
            System.out.println("added one transaction!");
        }
        String fileName = "Trans-" + fromDate.toString() + "-" + toDate.toString();
                
        return IOManager.getInstance().getFileHandler().createTextFile(output.toString(), fileName);
    }
    
}
