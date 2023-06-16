/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package textfieldframe;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;



/**
 *
 * @author bageg
 */
public class TextFieldFrameDemo extends JFrame {
    private final JTextField text1;
    private final JTextField text2;
    private final JTextField text3;
    private final JPasswordField password;
    private final JButton button;
    private final JCheckBox checkBox1;
    private final JCheckBox checkBox2;
    private final JRadioButton plain;
    private final JRadioButton bold;
    private final JRadioButton itallic;
    private final JRadioButton boldAndItallic;
    private final ButtonGroup radioGroup;
    private final JComboBox<String> imageJComboBox;
    private final JLabel label; 
    
    String[] names = {"comment.png", "person.png", "search.png", "share.png"};
    Icon[] icons = {new ImageIcon(getClass().getResource(names[0])), 
                    new ImageIcon(getClass().getResource(names[1])),
                    new ImageIcon(getClass().getResource(names[2])),
                    new ImageIcon(getClass().getResource(names[3]))
                    };
    
    
    public TextFieldFrameDemo(){
        super("Text Field Frame");
        setLayout(new FlowLayout());
        
        text1 = new JTextField(10);
        add(text1);
        text2 = new JTextField("Enter text here");
        add(text2);
        text3 = new JTextField("Ueditable TextField", 21);
        text3.setEditable(false);
        add(text3);
        password = new JPasswordField("Hidden text");
        add(password);
        Icon profile = new ImageIcon(getClass().getResource("person.png"));
        Icon comment = new ImageIcon(getClass().getResource("comment.png"));
        button = new JButton("FancyButton", profile);
        button.setRolloverIcon(comment);
        add(button);
        checkBox1 = new JCheckBox("Bold");
        add(checkBox1);
        checkBox2 = new JCheckBox("Italic");
        add(checkBox2);
        plain = new JRadioButton("Plain", true);
        bold = new JRadioButton("Bold", false);
        itallic = new JRadioButton("Itallic", false);
        boldAndItallic = new JRadioButton("Bold and Itallic", false);
        add(plain);
        add(bold);
        add(itallic);
        add(boldAndItallic);
        
        radioGroup = new ButtonGroup();
        radioGroup.add(plain);
        radioGroup.add(bold);
        radioGroup.add(itallic);
        radioGroup.add(boldAndItallic);    
        
        Font plainFont = new Font("Serif", Font.PLAIN, 14);
        Font boldFont = new Font("Serif", Font.BOLD, 14);
        Font itallicFont = new Font("Serif", Font.ITALIC, 14);
        Font bIFont = new Font("Serif", Font.ITALIC + Font.BOLD, 14);
        
        imageJComboBox = new JComboBox<String>(names);
        imageJComboBox.setMaximumRowCount(3);
        
        
        TextFieldHandler handler = new TextFieldHandler();
        CheckBoxHandler handle = new CheckBoxHandler();        
        
        text1.addActionListener(handler);
        text2.addActionListener(handler);
        text3.addActionListener(handler);
        password.addActionListener(handler);
//        button.addActionListener(handler);
        checkBox1.addItemListener(handle);
        checkBox2.addItemListener(handle);
        plain.addItemListener(new RadioButtonHandler(plainFont));
        bold.addItemListener(new RadioButtonHandler(boldFont));
        itallic.addItemListener(new RadioButtonHandler(itallicFont));
        boldAndItallic.addItemListener(new RadioButtonHandler(bIFont));
        
        imageJComboBox.addItemListener(
        new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent event){
                if(event.getStateChange() == ItemEvent.SELECTED){
                    label.setIcon(icons[imageJComboBox.getSelectedIndex()]);
                }
            }
        }
        );
        
        add(imageJComboBox);
        label = new JLabel(icons[0]);
        add(label);
    }
        
    private class TextFieldHandler implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent event){
            String string = null;
//            if(event.getSource() == button){
//                JOptionPane.showMessageDialog(null.this, String.format("Your pressed: %s", event.getActionCommand()));
//            }
            if(event.getSource() == text1){
                string = String.format("Text1: %s",event.getActionCommand());
            }
            else if(event.getSource() == text2){
                string = String.format("Text2: %s",event.getActionCommand());
            }
            else if(event.getSource() == text3){
                string = String.format("Text3: %s",event.getActionCommand());
            }
            else if(event.getSource() == password){
                string = String.format("Password: %s",event.getActionCommand());
            }
            
            JOptionPane.showMessageDialog(null, string);
        }
    
    }

    private class CheckBoxHandler implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent event){
            Font font = null;
            if(checkBox1.isSelected() && checkBox2.isSelected()){
                font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
            }
            else if(checkBox1.isSelected()){
                font = new Font("Serif", Font.BOLD , 14);
            }
            else if(checkBox2.isSelected()){
                font = new Font("Serif", Font.ITALIC, 14);
            }
            text3.setFont(font);
        }
    }
    
    private class RadioButtonHandler implements ItemListener{
        Font font = null;
        public RadioButtonHandler(Font font){
           this.font = font;
        }
        @Override
        public void itemStateChanged(ItemEvent event){
            text2.setFont(font);
        }
    }
}
