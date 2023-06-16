/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package borderlayoutdemo;
import javax.swing.JFrame;

/**
 *
 * @author bageg
 */
public class BorderLayoutDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BoarderLayout border = new BoarderLayout();
        border.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        border.setSize(300, 200);
        border.setVisible(true);
    }
    
}
