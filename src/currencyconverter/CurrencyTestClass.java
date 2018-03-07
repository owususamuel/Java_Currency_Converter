/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package currencyconverter;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author owusu
 */
public class CurrencyTestClass {

    public static void main(String[] args) {
        new CurrencyConverter();
        
    }
    
}


class CurrencyConverter extends JFrame implements ActionListener{
         JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JLabel label1 = new JLabel("Enter GHS");
        JLabel label2 = new JLabel("RESULTS");
        JTextField amountField = new JTextField(20);
        JTextField resultField = new JTextField(20);
        JButton dollarBtn = new JButton("Dollar");
        JButton poundBtn = new JButton("Pounds");
        JButton euroBtn = new JButton("Euros");
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        
        double cedi;
        
       
    public CurrencyConverter() {
        getContentPane().setBackground(Color.red);
        setSize(400, 400);
        setLocation(10, 10);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        menuBar.add(menu);
        menu.add(exit);
        
        panel1.add(label1);
        panel1.add(amountField);
        add(panel1);
        
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
            
        });

        dollarBtn.addActionListener(this);
        poundBtn.addActionListener(this);
        euroBtn.addActionListener(this);
        
        dollarBtn.setActionCommand("dol");
        poundBtn.setActionCommand("pou");
        euroBtn.setActionCommand("eur");
        
        panel2.add(label2);
        resultField.setEnabled(false);
        panel2.add(resultField);
        add(panel2);
        
        panel3.add(dollarBtn);
        panel3.add(poundBtn);
        panel3.add(euroBtn);
        add(panel3);
        
        setJMenuBar(menuBar);
        setVisible(true);
        
    }
    
        public double toDollar(double cedis) {
               return cedis /4.2;              
        }
        
        public double toPound(double cedis) {
               return cedis /5.1;              
        }
        
        public double toEuro(double cedis) {
               return cedis /4.6;              
        }
        

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
          cedi = Double.parseDouble(amountField.getText()); 
           switch (e.getActionCommand()) {
            case "dol":
                getContentPane().setBackground(Color.blue);
                resultField.setText(String.valueOf(toDollar(cedi)));
                break;
            case "pou":
                getContentPane().setBackground(Color.green);
                resultField.setText(String.valueOf(toPound(cedi)));
                break;
            case "eur":
                getContentPane().setBackground(Color.yellow);
                resultField.setText(String.valueOf(toEuro(cedi)));
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                break;
            default:
                break;
           }
          
        } catch(NumberFormatException ex) {
          resultField.setText("Enter amount in figures");    
        }
        
       
        
    }

}
