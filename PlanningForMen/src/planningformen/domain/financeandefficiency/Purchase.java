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
public class Purchase implements Transaction
{

    @Override
    public double getTotalPrice()
    {
        return Math.random() * 1000f; //Dummy value
    }
    
}
