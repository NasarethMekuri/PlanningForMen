/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen.business;

import java.sql.ResultSet;
import java.sql.SQLException;
import planningformen.domain.tyre.Slot;
import planningformen.technical.IOManager;

/**
 *
 * @author Cymon343
 */
public class SlotConverter implements ICallback
{
    private final int MAX_BITS_IN_BYTE = 8;
    private final int SIGNED_UNSIGNED_BYTE_DIFFERENCE = 128;
    private Slot[][][] _convertedSlots;
    
    
    public Slot[][][] retrieveSlots()
    {
        IOManager.getInstance().getDBHandler().retrieveSlots(this);
        return _convertedSlots;
    }
    
    @Override
    public void extractValues(ResultSet rs) throws SQLException
    {
        Slot aSlot = null;
        _convertedSlots = new Slot[2][3][25];
        byte x = -1;
        byte y = -1;
        byte z = -1;
        
        
        while (rs.next())
        {
            byte b = (byte) (-SIGNED_UNSIGNED_BYTE_DIFFERENCE + rs.getByte(1));
            
            aSlot = new Slot(
                    b,
                    rs.getString(2),
                    rs.getDate(3)
            );
            
            z = (byte) ((aSlot.getBinaryStringPosition().substring(0, 1).equals("0")) ? 0 : 1);
            
            y = convertStringToByte(aSlot.getBinaryStringPosition().substring(1, 3));
            
            x = convertStringToByte(aSlot.getBinaryStringPosition().substring(3));
            
            _convertedSlots[z][y][x] = aSlot;
            
        }
        
        rs.close();
    }
    
    public boolean createSlot(Slot slot)
    {
        //return IOManager.getInstance().getDBHandler().createSlot(slot.getPosition(), slot.getCustomerID(), slot.getFreeDate());
        return false;
    }
    
    
    
    
    public String convertByteToString(Byte b)
    {
        StringBuilder sb = new StringBuilder();
        
        /*
        The (int) binary value of -128 is 0000000 11111111 11111111 11111111 10000000, a byte cannot hold more than 8 bits, so an integer has to be used.
        0xFF (hex) is                     0000000 00000000 00000000 00000000 11111111
        the & operator "carries down" the matches, which results in: 1000 0000, which is -128 in a byte (8 bits).
        */
        
        int i = (b & 0xFF);
        
        String value = Integer.toBinaryString(i);
        
        //ensure 8 bits
        if (i < 2)
        {
            sb.append("0000000");
        }
        else if (i < 4)
        {
            sb.append("000000");
        }
        else if (i < 8)
        {
            sb.append("00000");
        }
        else if (i < 16)
        {
            sb.append("0000");
        }
        else if (i < 32)
        {
            sb.append("000");
        }
        else if (i < 64)
        {
            sb.append("00");
        }
        else if (i < 128)
        {
            sb.append("0");
        }
        
        sb.append(value);
        return sb.toString();
    }
    
    public byte convertStringToByte(String binaryString) //needs to be try-catched !!
    {
        int parsedValue = 0;
        if (binaryString.length() > MAX_BITS_IN_BYTE)
        {
            System.out.println("Bad binary String @SlotConverter - convertStringToByte ");
        }
        else
        {
            for (int i = 0; i < binaryString.length(); i++)
            {
                if (binaryString.charAt(i) != '0' || binaryString.charAt(i) != '1')
                {
                    System.out.println("Bad binary String @SlotConverter - convertStringToByte ");
                }
            }
        }
        
        try
        {
            parsedValue = Integer.parseInt(binaryString, 2); //Parsing int into a binaryString (using radix 2)
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("Bad binary String @SlotConverter - convertStringToByte " + nfe.getLocalizedMessage());
        }
        parsedValue = (parsedValue & 0xFF); //Comparing mathcing bits to a "full byte"
        byte b = (byte) parsedValue; //typecasting to byte
        return b;
    }
    
    public int convertStringToInt(String binaryString)
    {
        int parsedValue = 0;
        if (binaryString.length() > MAX_BITS_IN_BYTE)
        {
            System.out.println("Bad binary String @SlotConverter - convertStringToByte ");
        }
        else
        {
            for (int i = 0; i < binaryString.length(); i++)
            {
                if (binaryString.charAt(i) != '0' || binaryString.charAt(i) != '1')
                {
                    System.out.println("Bad binary String @SlotConverter - convertStringToByte ");
                }
            }
        }
        
        try
        {
            parsedValue = Integer.parseInt(binaryString, 2); //Parsing int into a binaryString (using radix 2)
        }
        catch (NumberFormatException nfe)
        {
            System.out.println("Bad binary String @SlotConverter - convertStringToByte " + nfe.getLocalizedMessage());
        }
        
        return (parsedValue & 0xFF);
    }

    
    
}
