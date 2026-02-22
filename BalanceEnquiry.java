import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.text.MessageFormat;

import javax.swing.*;
import java.util.*;
public class BalanceEnquiry extends JFrame implements ActionListener{
    String pin;
    JButton back;

    BalanceEnquiry(String pinNumber){
        this.pin = pinNumber;

        setLayout(null);

        JLabel image = new JLabel(new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")).getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT)));
        image.setBounds(0, 0, 900, 900);
        add(image);


        back = new JButton("Back");
        back.setBounds(350 , 565 , 150 , 30);
        back.setFont(new Font("Raleway", Font.BOLD , 22));
        back.addActionListener(this);
        image.add(back);

        int balance = 0;
        try{   
            Conn c = new Conn();
            String query = MessageFormat.format("SELECT * FROM BANK WHERE Pin_Number = {0}",pin);
            ResultSet rs = c.s.executeQuery(query);
           
            while (rs.next()) {
                if (rs.getString("Type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("Amount"));
                }
                else if (rs.getString("Type").equals("withdraw")) {
                    balance -= Integer.parseInt(rs.getString("Amount"));
                }
                else if (rs.getString("Type").equals("Fast Cash")) {
                    balance -= Integer.parseInt(rs.getString("Amount"));
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

         JLabel text = new JLabel("Your Current Account Balance is ");
        text.setBounds(210 , 300 , 700 , 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,15));
        image.add(text);

        JLabel text2 = new JLabel("₹"+balance+"");
        text2.setBounds(250 , 330 , 700 , 40);
        text2.setForeground(Color.white);
        text2.setFont(new Font("System",Font.BOLD,25));
        image.add(text2);

        setSize(900, 900);
        setLocation(300 , 0);
        setUndecorated(true);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }

       public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new transactions(pin).setVisible(true);
    }
}
