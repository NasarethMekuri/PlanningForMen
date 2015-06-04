/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.domain.tyre;

import planningformen.domain.planning.Sellable;

/**
 *
 * @author Morten
 */
public class Tyre implements Sellable
{
    private String _saleID;
    
    @Override
    public double getSellPrice()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getSaleID() { return _saleID; }
    
}
