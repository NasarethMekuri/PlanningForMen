package planningformen.domain.tyre;

import java.util.UUID;
import planningformen.domain.planning.Sellable;

/**
 *
 * @author Morten
 */
public class Tyre implements Sellable
{
    private String _id;
    private String _saleID;
    private double _purchasePrice;
    private double _sellPrice;
    private TyreSize _size;
    private TyreType _type;
    
    public Tyre(double purchasePrice, double sellPrice, TyreSize size, TyreType type)
    {
        _purchasePrice = purchasePrice;
        _sellPrice = sellPrice;
        _size = size;
        _type = type;
        _id = generateID();
    }
    
    public Tyre(String saleID, double purchasePrice, double sellPrice, TyreSize size, TyreType type)
    {
        _saleID = saleID;
        _purchasePrice = purchasePrice;
        _sellPrice = sellPrice;
        _size = size;
        _type = type;
        _id = generateID();
    }
    
    public Tyre(String id, String saleID, double purchasePrice, double sellPrice, TyreSize size, TyreType type)
    {
        _id = id;
        _saleID = saleID;
        _purchasePrice = purchasePrice;
        _sellPrice = sellPrice;
        _size = size;
        _type = type;
    }
    
    private String generateID()
    {
        return UUID.randomUUID().toString(); 
    }
    
    @Override
    public double getSellPrice() { return _sellPrice; }
    public String getSaleID() { return _saleID; }
    public String getId() { return _id; }
    public double getPurchasePrice() { return _purchasePrice; }
    public TyreSize getSize() { return _size; }
    public TyreType getType() { return _type; }

    public void setId(String id) { _id = id; }
    public void setSaleID(String saleID) { _saleID = saleID; }
    public void setPurchasePrice(double purchasePrice) { _purchasePrice = purchasePrice; }
    public void setSellPrice(double sellPrice) { _sellPrice = _sellPrice; }
    public void setSize(TyreSize size) { _size = size; }
    public void setType(TyreType type) { _type = _type; }
    
    @Override
    public String toString()
    {
        return "W-" + _size.getWidth() + " d-" + _size.getDiameter() + " p-" + _size.getProfile();
    }
}
