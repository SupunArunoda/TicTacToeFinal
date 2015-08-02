/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe_2;


;
import com.jtattoo.plaf.acryl.AcrylLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Supun
 */
public class Startup {

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
        
        
        try {
           UIManager.setLookAndFeel(new  AcrylLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            
        }
        
       new Main_Menu().setVisible(true);
        
    }
    
}
