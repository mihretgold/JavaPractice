/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gridlayout;

/**
 *
 * @author bageg
 */
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Container;


public class GridLayoutDemo extends JFrame implements ActionListener{
    private final Container container;
    private final GridLayout layout1;
    private final GridLayout layout2;
    private boolean toggle = true;
    private final JButton[] buttons;
    private static final String[] names = {"one", "two", "three", "Four", "Five", "Six"};
    public GridLayoutDemo(){
        super("Grid Layout");
        layout1 = new GridLayout(2, 3, 5,5);
        layout2 = new GridLayout(3,2);
        container = getContentPane();
        setLayout(layout1);
        buttons = new JButton[names.length];
        for(int count = 0; count < names.length; count++){
            buttons[count] = new JButton(names[count]);
            buttons[count].addActionListener(this);
            add(buttons[count]);
        }
        
    }
    @Override
    public void actionPerformed(ActionEvent event){
        if(toggle){
            setLayout(layout2);
        } else{
            setLayout(layout1);
        }
        toggle = !toggle;
        //re-lay out container
        container.validate();
    }
}
