/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.application;

import java.util.ArrayList;
import java.util.List;
import planningformen.domain.Master;
import planningformen.domain.tyre.Tyre;
import planningformen.domain.tyre.TyreSize;
import planningformen.domain.tyre.TyreType;

/**
 *
 * @author Simon
 */
public class TyreController implements ITyreController
{

    @Override
    public boolean createTyre(double purchasePrice, double sellPrice, TyreSize size, TyreType type)
    {
        return Master.getInstance().getTyreManager().createTyre(purchasePrice, sellPrice, size, type);
    }

    @Override
    public boolean updateTyre(Tyre tyre)
    {
        return Master.getInstance().getTyreManager().updateTyre(tyre);
    }

    @Override
    public boolean deleteTyre(Tyre tyre)
    {
        return Master.getInstance().getTyreManager().deleteTyre(tyre);
    }
    
    public List<Tyre> findTyres(String tyreID, String saleID, TyreSize size, TyreType type)
    {
        List<Tyre> foundTyres = new ArrayList<Tyre>();
        
        foundTyres.addAll(Master.getInstance().getTyreManager().findTyres(saleID));
        foundTyres.addAll(Master.getInstance().getTyreManager().findTyres(size));
        foundTyres.addAll(Master.getInstance().getTyreManager().findTyres(type));
        
        Tyre tyre = Master.getInstance().getTyreManager().findTyre(tyreID);
        if(tyre != null)
            foundTyres.add(tyre);
        
        for(int i = 0; i < foundTyres.size(); i++)
        {
            if(tyreID.length() > 0)
            {
                if(!tyreID.equals(foundTyres.get(i).getType()))
                {
                    foundTyres.remove(i);
                    i--;
                    continue;
                }
            }
            if(saleID.length() > 0)
            {
                if(!saleID.equals(foundTyres.get(i).getSaleID()))
                {
                    foundTyres.remove(i);
                    i--;
                    continue;
                }
            }
            if(size != null)
            {
                if(size.getWidth() > 0 && size.getDiameter() > 0 && size.getProfile() > 0)
                {
                    if(size.equals(foundTyres.get(i).getSize()))
                    {
                        foundTyres.remove(i);
                        i--;
                        continue;
                    }
                }
            }
            if(type != null)
            {
                if(type != foundTyres.get(i).getType())
                {
                    foundTyres.remove(i);
                    i--;
                    continue;
                }
            }
        }
        
        //Remove Duplicates
        for(int i = 0; i < foundTyres.size(); i++)
        {
            for(int j = i + 1; j < foundTyres.size(); j++)
            {
                if(foundTyres.get(i).equals(foundTyres.get(j)))
                {
                    foundTyres.remove(j);
                    j--;
                }
            }
        }
        return foundTyres;
    }

    
}
