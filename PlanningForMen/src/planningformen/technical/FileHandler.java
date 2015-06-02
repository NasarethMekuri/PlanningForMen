/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planningformen.technical;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author bruger
 */
public class FileHandler
{
    private final String FILE_EXTENSION = ".txt";
    
    public boolean printInvoice(String input, String fileName)
    {
        boolean isErrorFree = true;
        PrintWriter output = null;
        try
        {
            output = new PrintWriter(fileName + FILE_EXTENSION);
            output.print(input);
        } catch (FileNotFoundException ex)
        {
            System.out.println(ex.getLocalizedMessage());
            isErrorFree = false;
        }
        finally
        {
            output.close();
        }
        return isErrorFree;
    }
}
