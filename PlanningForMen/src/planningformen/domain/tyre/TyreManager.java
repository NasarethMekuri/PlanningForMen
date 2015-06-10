package planningformen.domain.tyre;

import java.util.ArrayList;
import java.util.List;
import planningformen.business.TyreConverter;

/**
 *
 * @author MKJ
 */
public class TyreManager
{
    private static TyreManager _instance;
    private List<Tyre> _tyres;
    private TyreConverter _tyreConverter;
    
    public List<Tyre> getTyres() { return _tyres; }
    private TyreManager()
    {
        _tyreConverter = new TyreConverter();
        _tyres = retrieveTyres();
    }
    
    public static TyreManager getInstance()
    {
        if(_instance == null)
        {
            _instance = new TyreManager();
        }
        return _instance;
    }
    
    public List<Tyre> findTyres(TyreSize size)
    {
        List<Tyre> foundTyres = new ArrayList<Tyre>();
        
        for(Tyre t : _tyres)
        {
            if(t.getSize().equals(size))
                foundTyres.add(t);
        }
        return foundTyres;
    }
    
    public List<Tyre> findTyres(TyreType type)
    {
        List<Tyre> foundTyres = new ArrayList<Tyre>();
        
        for(Tyre t : _tyres)
        {
            if(t.getType() == type)
                foundTyres.add(t);
        }
        return foundTyres;
    }
    
    public Tyre findTyre(String tyreID)
    {
        for(Tyre t : _tyres)
        {
            if(t.getId().equals(tyreID))
                return t;
        }
        return null;
    }
    
    public List<Tyre> findTyres(String saleID)
    {
        List<Tyre> foundTyres = new ArrayList<Tyre>();

        for(Tyre t : _tyres)
        {
            if(t.getSaleID() == null)
                continue;
            if(t.getSaleID().equals(saleID))
                foundTyres.add(t);
        }
        return foundTyres;
    }
    
    public boolean createTyre(double purchasePrice, double sellPrice, TyreSize size, TyreType type)
    {
        Tyre tyre = new Tyre(purchasePrice, sellPrice, size, type);
        if(_tyreConverter.createTyre(tyre))
            return _tyres.add(tyre);
        return false;
    }
    
    public List<Tyre> retrieveTyres()
    {
        return _tyreConverter.retrieveTyres();
    }
    
    public boolean updateTyre(Tyre tyre)
    {
        for(Tyre t : _tyres)
        {
            if(t.getId() == tyre.getId())
            {
                if(_tyreConverter.updateTyre(tyre))
                {
                    t = tyre;
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean deleteTyre(Tyre tyre)
    {
        if(_tyreConverter.deleteTyre(tyre))
            return _tyres.remove(tyre);
        return false;
    }
}
