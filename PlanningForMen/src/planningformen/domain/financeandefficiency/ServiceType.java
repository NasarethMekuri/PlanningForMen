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
public enum ServiceType
{
    DIESEL(1), NORMAL(2), TUNING(3);

    private final int _numericValue;
    
    private ServiceType(int numericValue)
    {
        this._numericValue = numericValue;
    }

    public int getNumericValue() {return _numericValue;}   
}
