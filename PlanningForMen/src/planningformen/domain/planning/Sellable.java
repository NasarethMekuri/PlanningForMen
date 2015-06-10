/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.domain.planning;

/**
 *
 * @author Simon
 */
public interface Sellable
{
    public double getSellPrice();
    public String getSaleID();
    public void setSaleID(String saleID);
}
