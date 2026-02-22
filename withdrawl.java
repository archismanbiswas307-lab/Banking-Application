import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.*;import java.text.SimpleDateFormat;
import javax.swing.*;

public class withdrawl extends JFrame implements ActionListener {
    JButton withdrawlButton , back;
    String pin;
    JTextField amount ;
    withdrawl(String pin){
        this.pin = pin;
        setLayout(null);
        JLabel image = new JLabel(new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg")).getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT)));
        image.setBounds(0, 0, 900, 900);
        add(image);


        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setFont(new Font("System", Font.BOLD,16));
        text.setBounds(210 , 300 , 700 , 35);
        text.setForeground(Color.white);
        image.add(text);

        amount = new JTextField("Amount in INR ₹");
        amount.setFont(new Font("Raleway", Font.BOLD , 22));
        amount.setBounds(170 , 400 , 320 , 25);
        image.add(amount);

        withdrawlButton = new JButton("Withdraw");
        withdrawlButton.setBounds(160 , 450 , 150 , 30);
        withdrawlButton.setFont(new Font("Raleway", Font.BOLD , 22));
        withdrawlButton.addActionListener(this);
        image.add(withdrawlButton);

        back = new JButton("Back");
        back.setBounds(350 , 450 , 150 , 30);
        back.setFont(new Font("Raleway", Font.BOLD , 22));
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300 , 0);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent action) {
       if (action.getSource() == withdrawlButton) {
             String amountwithdrawl = amount.getText();
             Date date = new Date();
             if (amountwithdrawl.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter some Amount to withdrawl");
             }
             else{
                try {
                Conn c = new Conn();
                String query = MessageFormat.format("INSERT INTO BANK (Pin_Number, Date, Type, Amount) VALUES (''{0}'', ''{1}'', ''{2}'', ''{3}'')", pin, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date), "withdraw", amountwithdrawl);
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, MessageFormat.format("₹{0} \n has been withdrawn",amountwithdrawl));
                    setVisible(false);
                    new transactions(pin).setVisible(true);

                } 
                catch (Exception Exception) {
                    System.out.println(Exception);
                }
             }
       }
       else if (action.getSource() == back) {
            setVisible(false);
            new transactions(pin).setVisible(true);
       }
    }
    
    public static void main(String[] args) {
         new withdrawl("");
    }
}
