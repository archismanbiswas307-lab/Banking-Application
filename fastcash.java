import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;

import javax.swing.*;
import java.util.*;
public class fastcash extends JFrame implements ActionListener{
    JButton hundredButton, fiveHundredButton, thousandButton, amountTwoThousand, amountFiveThousand, amountTenThousand, back;
    String pin;
    fastcash(String pinNumber){
        this.pin = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210 , 300 , 700 , 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,15));
        image.add(text);

        hundredButton = new JButton("₹100");
        hundredButton.setBounds(170 , 455 , 150 , 30);
        hundredButton.addActionListener(this);
        image.add(hundredButton);

        fiveHundredButton = new JButton("₹500");
        fiveHundredButton.setBounds(355 , 455 , 150 , 30);
        fiveHundredButton.addActionListener(this);
        image.add(fiveHundredButton);

        thousandButton = new JButton("₹1000");
        thousandButton.setBounds(170 , 490 , 150 , 30);
        thousandButton.addActionListener(this);
        image.add(thousandButton);

        amountTwoThousand = new JButton("₹2000");
        amountTwoThousand.setBounds(355 , 490 , 150 , 30);
        amountTwoThousand.addActionListener(this);
        image.add(amountTwoThousand);

        amountFiveThousand = new JButton("₹5000");
        amountFiveThousand.setBounds(170 , 525 , 150 , 30);
        amountFiveThousand.addActionListener(this);
        image.add(amountFiveThousand);

        amountTenThousand = new JButton("₹10000");
        amountTenThousand.setBounds(355 , 525 , 150 , 30);
        amountTenThousand.addActionListener(this);
        image.add(amountTenThousand);

        back = new JButton("Back");
        back.setBounds(355 , 560 , 150 , 30);
        back.addActionListener(this);
        image.add(back);

        



        getContentPane().setBackground(Color.white);
    
        setSize(900,900);
        setLocation(350,10);
        setUndecorated(true); 
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
       new fastcash("");
    }

   
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new transactions(pin).setVisible(true);
        }
        else{  
            String amountWithdrawn = ((JButton)e.getSource()).getText().substring(1);
            Date date = new Date();
            try {
                Conn c = new Conn();
                String query = MessageFormat.format("SELECT * FROM BANK WHERE Pin_Number = {0}",pin);
                ResultSet rs = c.s.executeQuery(query);
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("Type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("Amount"));
                    }
                    else if (rs.getString("Type").equals("withdraw")) {
                        balance -= Integer.parseInt(rs.getString("Amount"));
                    }
                    else if (rs.getString("Type").equals("Fast Cash")) {
                        balance-= Integer.parseInt(rs.getString("Amount"));
                    }     
                }
                if (e.getSource() != back && balance < Integer.parseInt(amountWithdrawn)) {
                    JOptionPane.showConfirmDialog(null, "Insufficient Balance");
                    return;
                }
                String query1 = MessageFormat.format("INSERT INTO BANK (Pin_Number, Date, Type, Amount) VALUES (''{0}'', ''{1}'', ''{2}'', ''{3}'')", pin, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date), "Fast Cash", amountWithdrawn);
                c.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, MessageFormat.format("₹{0} \n has been withdrawn",amountWithdrawn));
                setVisible(false);
                new transactions(pin).setVisible(true);
            } 
            catch (Exception Exception) {
                System.out.println(Exception);
            }
        }
    }
}
