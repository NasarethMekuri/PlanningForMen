/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package planningformen;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import planningformen.ui.gui.MainFrame;

/**
 *
 * @author Simon
 */
public class PlanningForMen
{
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        PlanningForMen planningForMen = new PlanningForMen();
        
        planningForMen.runProgram();
    }
    
    private void runProgram()
    {
        JFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
