/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.domain.tyre;

/**
 *
 * @author bruger
 */
public enum TyreType
{
    SUMMER(1), WINTER(2), ALL_SEASON(3), MC(4), FOUR_BY_FOUR(5);
    
    private final int _numericValue;
    
    private TyreType(int numericValue)
    {
        _numericValue = numericValue;
    }

    public int getNumericValue() {return _numericValue;}
    
    public static TyreType intToType(int number)
    {
        switch(number)
        {
            case 1:
                return TyreType.SUMMER;
            case 2:
                return TyreType.WINTER;
            case 3:
                return TyreType.ALL_SEASON;
            case 4:
                return TyreType.MC;
            default:
                return TyreType.FOUR_BY_FOUR;
        }
    }
}
