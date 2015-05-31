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
public enum ServiceState
{
    PENDING(1), RESERVED(2), STARTED(3), FINISHED(4);
    
    private final int _numericValue;

    private ServiceState(int numericvalue)
    {
        this._numericValue = numericvalue;
    }

    public int getNumericValue() {return _numericValue;}
    
}
