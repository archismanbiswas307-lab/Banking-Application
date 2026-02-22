import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.*;
public class transactions extends JFrame implements ActionListener{
    JButton deposit, withdrawl,fastcash,ministatement,pinChange,balanceEnquiry,exit;
    String pin;
    transactions(String pinNumber){
        this.pin = pinNumber;
        setLayout(null);
 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210 , 300 , 700 , 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,15));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(170 , 455 , 150 , 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Withdrawl");
        withdrawl.setBounds(355 , 455 , 150 , 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170 , 490 , 150 , 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355 , 490 , 150 , 30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170 , 525 , 150 , 30);
        pinChange.addActionListener(this);
        image.add(pinChange);

         balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(355 , 525 , 150 , 30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setBounds(355 , 560 , 150 , 30);
        exit.addActionListener(this);
        image.add(exit);

        



        getContentPane().setBackground(Color.white);
    
        setSize(900,900);
        setLocation(350,10);
        setUndecorated(true); 
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
       new transactions("");
    }

   
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        }
        else if (e.getSource() == deposit) {
            setVisible(false);
            new deposit(pin).setVisible(true);
        }
        else if (e.getSource() == withdrawl) {
            setVisible(false);
            new withdrawl(pin).setVisible(true);
        }
        else if (e.getSource() == fastcash) {
            setVisible(false);
            new fastcash(pin).setVisible(true);
        }
        else if (e.getSource() == pinChange) {
            setVisible(false);
            new pinchange(pin).setVisible(true);
        }
        else if (e.getSource() == balanceEnquiry) {
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }
        else if (e.getSource() == ministatement) {
            new MiniStatement(pin).setVisible(true);
        }
    }
}
