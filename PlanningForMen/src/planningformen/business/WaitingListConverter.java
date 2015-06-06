/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.business;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import planningformen.technical.IOManager;

/**
 *
 * @author Cymon343
 */
public class WaitingListConverter implements ICallback
{
    private List<String> _convertedWaitingList;

     public List<String> retrieveWaitingList()
    {
        IOManager.getInstance().getDBHandler().retrieveWaitingList(this);
        return _convertedWaitingList;
    }
     
    @Override
    public void extractValues(ResultSet rs) throws SQLException
    {
        String customerID = null;
        
        int numberInLine = 0;
        while (rs.next())
        {
            numberInLine = rs.getInt(1);
            customerID =  rs.getString(2);
            _convertedWaitingList.add(numberInLine, customerID);
        }
        
        rs.close();
    }

   
    
}
