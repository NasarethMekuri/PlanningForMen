/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.application;

import java.util.List;
import planningformen.domain.tyre.Tyre;
import planningformen.domain.tyre.TyreSize;
import planningformen.domain.tyre.TyreType;

/**
 *
 * @author Simon
 */
public interface ITyreController
{
    public boolean createTyre(double purchasePrice, double sellPrice, TyreSize size, TyreType type);
    public boolean updateTyre(Tyre tyre);
    public boolean deleteTyre(Tyre tyre);
    public List<Tyre> findTyres(TyreSize size);
    public List<Tyre> findTyres(TyreType type);
    public Tyre findTyre(String tyreID);
    public List<Tyre> findTyres(String saleID);
}