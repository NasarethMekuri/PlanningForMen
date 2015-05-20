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
public class Service implements Sellable
{
    private int _id;
    private double _price;
    private String _description;

    public Service(int id, double price, String description)
    {
        this._id = id;
        this._price = price;
        this._description = description;
    }

    public int getId()              {return _id;}
    public double getPrice()        {return _price;}
    public String getDescription()  {return _description;}
    
    public void setId(int id)                      {this._id = id;}
    public void setPrice(double price)             {this._price = price;}
    public void setDescription(String description) {this._description = description;}
    
    
    
    
}
