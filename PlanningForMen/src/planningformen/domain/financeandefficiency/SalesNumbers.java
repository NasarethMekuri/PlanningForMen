/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.domain.financeandefficiency;

/**
 *
 * @author Simon
 */
public class SalesNumbers
{
    private double _turnover, _costOfSales, _grossProfit, _expenses, _corporationTax, _profitAfterTax, _operatingProfit;
    private int _id; //year

    public SalesNumbers(double turnover, double costOfSales, int id)
    {
        this._turnover = turnover;
        this._costOfSales = costOfSales;
        this._id = id;
        this._grossProfit = turnover - costOfSales;
        this._expenses = 450; //HARDCODE
        this._operatingProfit = _grossProfit - _expenses;
        this._corporationTax = 5000; //HARDCODE -skal måske regnes ud fra salesList på saleManager?
        this._profitAfterTax = _operatingProfit - _corporationTax;
        
    }
    
    
    
}
