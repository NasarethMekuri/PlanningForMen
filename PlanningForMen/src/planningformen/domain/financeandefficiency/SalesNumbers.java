/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.domain.financeandefficiency;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Simon
 */
public class SalesNumbers
{
    private final double _turnover, _costOfSales, _grossProfit, _expenses, _corporationTax, _profitAfterTax, _operatingProfit;
    private final int _id; //year
    private List<Sale> _yearlySales;
    private List<Purchase> _yearlyPurchases;

    public SalesNumbers(int year)
    {
        if (year > 2013 && year <= Calendar.getInstance().get(Calendar.YEAR))
        {
            this._id = year;
        }
        else
        {
            _id = Calendar.getInstance().get(Calendar.YEAR);
        }
        _yearlySales = SaleManager.getInstance().findSales(year);
        _yearlyPurchases = PurchaseManager.getInstance().findPurchases(year);
        
        this._turnover = getYearlyTurnover();
        this._costOfSales = getYearlyCostOfSales();
        this._grossProfit = _turnover - _costOfSales;
        this._expenses = 10000; //HARDCODE
        this._operatingProfit = _grossProfit - _expenses;
        this._corporationTax = SaleManager.getInstance().calculateTaxes(_yearlySales); 
        this._profitAfterTax = _operatingProfit - _corporationTax;
    }


    private double getYearlyTurnover()
    {
        double temp = 0;
        for (Sale s : getYearlySales())
        {
            if (s.IsPaid())
            {
                temp += s.getTotalPrice();
            }
        }
        return temp;
    }

    private double getYearlyCostOfSales()
    {
        double temp = 0;
        for (Purchase p : getYearlyPurchases())
        {
            temp += p.getTotalPrice();
        }
        return temp;
    }
    
    public String getProfitLoss()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Profit and loss acount for year " + _id + "\n\n\n");
        sb.append("Turnover \t\t" + getTurnover() + "\n");
        sb.append("Cost of Sales \t\t" + getCostOfSales() + "\n\n");
        sb.append("Gross Profit \t\t" + getGrossProfit() + "\n");
        sb.append("Expenses \t\t" + getExpenses() + "\n\n");
        sb.append("Operating Profit \t" + getOperatingProfit() + "\n\n");
        sb.append("Corporation Tax \t" + getCorporationTax() + "\n\n");
        sb.append("Profit after Tax \t\t" + getProfitAfterTax());
        return sb.toString();
    }

    public double getTurnover()                 {return _turnover;}
    public double getCostOfSales()              {return _costOfSales;}
    public double getGrossProfit()              {return _grossProfit;}
    public double getExpenses()                 {return _expenses;}
    public double getCorporationTax()           {return _corporationTax;}
    public double getProfitAfterTax()           {return _profitAfterTax;}
    public double getOperatingProfit()          {return _operatingProfit;}
    public int getId()                          {return _id;}
    public List<Sale> getYearlySales()          {return _yearlySales;}
    public List<Purchase> getYearlyPurchases()  {return _yearlyPurchases;}
    
    
}
