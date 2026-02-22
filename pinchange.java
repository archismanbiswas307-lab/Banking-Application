import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.text.MessageFormat;

import javax.swing.*;
import javax.swing.text.View;

import java.util.*;

public class pinchange extends JFrame implements ActionListener {
    
    JPasswordField oldPin , newPin,confirmPin;
    JCheckBox see1 , see2, see3;
    String pin;
    JButton change , back ;

    pinchange(String pinNo){
        this.pin = pinNo;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT );
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0 , 0 , 900 , 900);
        add(image);

        JLabel heading = new JLabel("CHANGE YOUR PIN");
        heading.setBounds(250 , 310 , 500 , 35);
        heading.setForeground(Color.white);
        heading.setFont(new Font("System", Font.BOLD, 20));
        image.add(heading);

        JLabel text = new JLabel("Enter the older pin:");
        text.setBounds(160 , 340 , 300 , 35);
        text.setFont(new Font("System", Font.BOLD, 19));
        text.setForeground(Color.white);
        image.add(text);

        oldPin = new JPasswordField();
        oldPin.setBounds(340, 345 , 100 , 25);
        oldPin.setBackground(new Color(85,85,85));
        oldPin.setForeground(Color.white);
        oldPin.setEchoChar('*');
        oldPin.setFont(new Font("System", Font.BOLD, 19));
        image.add(oldPin);

        see1 = new JCheckBox("👁");
        see1.setBounds(450, 345 , 50 , 25);
        see1.setBackground(Color.BLACK);
        see1.setForeground(Color.white);
        see1.setFont(new Font("System", Font.BOLD, 20));
        see1.addActionListener(this);
        image.add(see1);

        JLabel text2 = new JLabel("Enter the newer pin:");
        text2.setBounds(160 , 430 , 300 , 35);
        text2.setFont(new Font("System", Font.BOLD, 19));
        text2.setForeground(Color.white);
        image.add(text2);

        newPin = new JPasswordField();
        newPin.setBounds(350, 435 , 100 , 25);
        newPin.setBackground(new Color(85,85,85));
        newPin.setForeground(Color.white);
        newPin.setFont(new Font("System", Font.BOLD, 19));
        image.add(newPin);

        see2 = new JCheckBox("👁");
        see2.setBounds(450, 435 , 50 , 25);
        see2.setBackground(Color.BLACK);
        see2.setForeground(Color.white);
        see2.setFont(new Font("System", Font.BOLD, 20));
        see2.addActionListener(this);
        image.add(see2);

        JLabel text3 = new JLabel("Confirm the newer pin:");
        text3.setBounds(160 , 480 , 300 , 35);
        text3.setFont(new Font("System", Font.BOLD, 19));
        text3.setForeground(Color.white);
        image.add(text3);

        

        confirmPin = new JPasswordField();
        confirmPin.setBounds(370, 485 , 100 , 25);
        confirmPin.setBackground(new Color(85,85,85));
        confirmPin.setForeground(Color.white);
        confirmPin.setFont(new Font("System", Font.BOLD, 19));
        image.add(confirmPin);

        see3 = new JCheckBox("👁");
        see3.setBounds(470, 485 , 50 , 25);
        see3.setBackground(Color.BLACK);
        see3.setForeground(Color.white);
        see3.setFont(new Font("System", Font.BOLD, 20));
        see3.addActionListener(this);
        image.add(see3);

        change = new JButton("Change");
        change.setBounds(160, 555 , 150 , 25);
        change.setFont(new Font("System", Font.BOLD , 15));
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(350, 555 , 150 , 25);
        back.setFont(new Font("System", Font.BOLD , 15));
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(350 , 10);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    

    public static void main(String[] args) {
        new pinchange("").setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

     if (e.getSource() == change) {
          try {
               Conn c = new Conn();
               String old = oldPin.getText();
               String npin = newPin.getText();
               String confString = confirmPin.getText();

               String query = MessageFormat.format("SELECT * FROM logindata WHERE  Pin_Number = {0}" ,old);
               ResultSet result = c.s.executeQuery(query);
                if (!result.next()) {
                    JOptionPane.showMessageDialog(null, "IncorrectPin Number \n Please Enter the correct one");
                    return;
                }

               
               if (!npin.equals(confString)) {
                    JOptionPane.showMessageDialog(null, "Entered Pin does not match");
                    return ; 
               }
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter your New Pin");
                    return ; 
               }
                if (confString.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Re-Enter your New Pin");
                    return ; 
               }
               String query1 = MessageFormat.format("UPDATE bank SET Pin_Number = {0} WHERE Pin_Number = {1}", npin, pin);
               c.s.executeUpdate(query1);
               
               String query2 = MessageFormat.format("UPDATE logindata SET Pin_Number = {0} WHERE Pin_Number = {1}", npin, pin);
               c.s.executeUpdate(query2);
               
               String query3 = MessageFormat.format("UPDATE signupthree SET Pin_Number = {0} WHERE Pin_Number = {1}", npin, pin);
               c.s.executeUpdate(query3);
               
               JOptionPane.showMessageDialog(null, "PIN changed successfully");

               setVisible(false);
               new transactions(npin).setVisible(true);

       } catch (Exception exception) {
         System.out.println(exception);
       }
     }

       if (see1.isSelected()) {
            oldPin.setEchoChar('\u0000');
       } else {
            oldPin.setEchoChar('*');
       }
       
       if (see2.isSelected()) {
            newPin.setEchoChar('\u0000');
       } else {
            newPin.setEchoChar('*');
       }
       
       if (see3.isSelected()) {
            confirmPin.setEchoChar('\u0000');
       } else {
            confirmPin.setEchoChar('*');
       }

       

        if(e.getSource() == back) {
          setVisible(false);
          new transactions(pin).setVisible(true);
       }

    }
}


