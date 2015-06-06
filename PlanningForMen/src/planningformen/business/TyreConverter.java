package planningformen.business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import planningformen.domain.tyre.Tyre;
import planningformen.domain.tyre.TyreSize;
import planningformen.domain.tyre.TyreType;
import planningformen.technical.IOManager;

/**
 *
 * @author Morten
 */
public class TyreConverter implements ICallback
{
    private List<Tyre> _convertedTyres;
    
    @Override
    public void extractValues(ResultSet rs) throws SQLException
    {
        _convertedTyres = new ArrayList<Tyre>();

        while(rs.next())
        {
            String tyreID = rs.getString(1);
            String saleID = rs.getString(2);
            double purchasePrice = rs.getDouble(3);
            double salePrice = rs.getDouble(4);
            int width = rs.getInt(5);
            int profile = rs.getInt(6);
            int diameter = rs.getInt(7);
            TyreType type = TyreType.intToType(rs.getInt(8));
            _convertedTyres.add(new Tyre(tyreID, saleID, purchasePrice, salePrice, new TyreSize(width, profile, diameter), type));
        }
    }
    
    public boolean createTyre(Tyre tyre)
    {
        String id = tyre.getId();
        double purchasePrice = tyre.getPurchasePrice();
        double sellPrice = tyre.getSellPrice();
        int width = tyre.getSize().getWidth();
        int profile = tyre.getSize().getProfile();
        int diameter = tyre.getSize().getDiameter();
        int type = tyre.getType().getNumericValue();
        return IOManager.getInstance().getDBHandler().createTyre(id, purchasePrice, sellPrice, width, profile, diameter, type);
    }
    
    public List<Tyre> retrieveTyres()
    {
        IOManager.getInstance().getDBHandler().retrieveTyres(this);
        return _convertedTyres;
    }
    
    public boolean updateTyre(Tyre tyre)
    {
        String id = tyre.getId();
        String saleID = tyre.getSaleID();
        double purchasePrice = tyre.getPurchasePrice();
        double sellPrice = tyre.getSellPrice();
        int width = tyre.getSize().getWidth();
        int profile = tyre.getSize().getProfile();
        int diameter = tyre.getSize().getDiameter();
        int type = tyre.getType().getNumericValue();
        return IOManager.getInstance().getDBHandler().updateTyre(id, saleID, purchasePrice, sellPrice, width, profile, diameter, type);
    }
    
    public boolean deleteTyre(Tyre tyre)
    {
        return IOManager.getInstance().getDBHandler().deleteTyre(tyre.getId());
    }
    
}
