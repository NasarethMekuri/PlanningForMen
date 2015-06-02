/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen.domain.planning;

import java.sql.Date;

/**
 *
 * @author Simon
 */
public class Car implements Sellable
{
    private String _id, _make, _model, _version, _fuel, _description, _plate, _saleID;
    private double _volume, _purchasePrice, _sellPrice;
    private int _year, _odometer;
    private Date _purchaseDate;
    private boolean _inStock;
    
    public Car()
    {
    }
    
    public Car(String plate, int year, String make, String model, double volume, String fuel, String version, int odometer, Date purchaseDate, double purchasePrice, double sellPrice, String description, boolean inStock)
    {
        this._id = purchaseDate.toString().replace("-", "") + "-" +  plate;
        this._make = make;
        this._model = model;
        this._version = version;
        this._fuel = fuel;
        this._description = description;
        this._plate = plate;
        this._volume = volume;
        this._purchasePrice = purchasePrice;
        this._sellPrice = sellPrice;
        this._year = year;
        this._odometer = odometer;
        this._purchaseDate = purchaseDate;
        this._inStock = inStock;
    }
    
    /**
     * This constructor is only used when the id is known in advance.
     * @param id
     * @param saleID
     * @param plate
     * @param year
     * @param make
     * @param model
     * @param volume
     * @param fuel
     * @param version
     * @param odometer
     * @param purchaseDate
     * @param purchasePrice
     * @param sellPrice
     * @param description
     * @param inStock
     */
    public Car(String id, String saleID, String plate, int year, String make, String model, double volume, String fuel, String version, int odometer, Date purchaseDate, double purchasePrice, double sellPrice, String description, boolean inStock)
    {
        this._id = id;
        this._saleID = saleID;
        this._make = make;
        this._model = model;
        this._version = version;
        this._fuel = fuel;
        this._description = description;
        this._plate = plate;
        this._volume = volume;
        this._purchasePrice = purchasePrice;
        this._sellPrice = sellPrice;
        this._year = year;
        this._odometer = odometer;
        this._purchaseDate = purchaseDate;
        this._inStock = inStock;
    }
    
    //Accessors:
    public String getId()           {return _id;}
    public String getMake()         {return _make;}
    public String getModel()        {return _model;}
    public String getVersion()      {return _version;}
    public String getFuel()         {return _fuel;}
    public String getDescription()  {return _description;}
    public String getPlate()        {return _plate;}
    public double getVolume()       {return _volume;}
    public double getPurchasePrice(){return _purchasePrice;}
    @Override
    public double getSellPrice()    {return _sellPrice;}
    public int getYear()            {return _year;}
    public int getOdometer()        {return _odometer;}
    public Date getPurchaseDate()   {return _purchaseDate;}
    public boolean isInStock()      {return _inStock;}
    public String getSaleID()       {return _saleID;}
    //Mutators:
    
    public void setMake(String make)                   {this._make = make;}
    public void setModel(String model)                 {this._model = model;}
    public void setVersion(String version)             {this._version = version;}
    public void setFuel(String fuel)                   {this._fuel = fuel;}
    public void setDescription(String description)     {this._description = description;}
    public void setPlate(String plate)                 {this._plate = plate;}
    public void setVolume(double volume)               {this._volume = volume;}
    public void setPurchasePrice(double purchasePrice) {this._purchasePrice = purchasePrice;}
    public void setSellPrice(double sellPrice)         {this._sellPrice = sellPrice;}
    public void setYear(int year)                      {this._year = year;}
    public void setOdometer(int odometer)              {this._odometer = odometer;}
    public void setPurchaseDate(Date purchaseDate)     {this._purchaseDate = purchaseDate;}
    public void setInStock(boolean inStock)            {this._inStock = inStock;}
    public void setSaleID(String saleID)               {this._saleID = saleID;}
    
}
