import java.awt.Color;
import java.sql.ResultSet;
import java.text.MessageFormat;

import javax.swing.*;

public class MiniStatement extends JFrame {

    String pin;

    MiniStatement(String pinNo){
        this.pin = pinNo;
        setTitle("Mini Statement");

        JLabel mini = new JLabel();
        add(mini);

        JLabel bank = new JLabel("ABC Bank");
        bank.setBounds(150 , 20 , 100 , 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20 , 80 , 300 , 20);
        add(card);


        try {
            Conn c = new Conn();
            String query = MessageFormat.format("SELECT * FROM logindata WHERE Pin_Number = {0}",pin);
            ResultSet rs =c.s.executeQuery(query);

            while (rs.next()) {
                card.setText("Card Number:"+rs.getString("Card_Number").substring(0,4)+"XXXXXXXX"+rs.getString("Card_Number").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        mini.setBounds(20 , 100,400 ,200);

        try {
            Conn c = new Conn();
             String query = MessageFormat.format("SELECT * FROM bank WHERE Pin_Number = {0}",pin);
            ResultSet rs =c.s.executeQuery(query);
            while (rs.next()) {
                mini.setText(mini.getText() +"<html>" + rs.getString("Date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("Type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Amount")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+"<br><br><html>");
            }
        } catch (Exception e) {
            System.out.println(e);
        }


        JLabel balance = new JLabel();
        int balanceAmt = 0;
        balance.setBounds(20 , 150,400 ,200);
        try {
                Conn c = new Conn();
                String query = MessageFormat.format("SELECT * FROM BANK WHERE Pin_Number = {0}",pin);
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    if (rs.getString("Type").equals("Deposit")) {
                        balanceAmt += Integer.parseInt(rs.getString("Amount"));
                    }
                    else if (rs.getString("Type").equals("withdraw")) {
                        balanceAmt -= Integer.parseInt(rs.getString("Amount"));
                    }
                    else if (rs.getString("Type").equals("Fast Cash")) {
                        balanceAmt -= Integer.parseInt(rs.getString("Amount"));
                    }
                    
                }
            }
            catch (Exception Exception) {
                System.out.println(Exception);
            }
            balance.setText("Your Account Has a balance: ₹"+balanceAmt);
        add(balance);

        setLayout(null);
        setSize(400 , 600);
        setLocation(20 , 20);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}
