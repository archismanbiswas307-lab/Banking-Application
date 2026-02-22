import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.MessageFormat;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{

    JButton login , signup , clear;
    JTextField carTextField ;
    JPasswordField pTextField;

    Login(){
        setLayout(null);

        setTitle("Banking Application");
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(90, 10 , 100 , 100);
        add(label);

        JLabel text = new JLabel("WELCOME TO ABC BANK");
        text.setFont(new Font("Osward",Font.BOLD,30));
        text.setBounds(200, 40 , 400 , 40);
        add(text);

        JLabel cardno = new JLabel("Card Number");
        cardno.setFont(new Font("Railway",Font.BOLD,20));
        cardno.setBounds(120, 150 , 150 , 40);
        add(cardno);

        carTextField = new JTextField();
        carTextField.setBounds(300 , 150 , 250 , 40);
        carTextField.setFont(new Font("Arial" , Font.BOLD , 14));
        add(carTextField);
        
        JLabel pin = new JLabel("Pin");
        pin.setFont(new Font("Railway",Font.BOLD,20));
        pin.setBounds(120, 220 , 150 , 40);
        add(pin);
        
        pTextField = new JPasswordField();
        pTextField.setBounds(300 , 220 , 232 , 30);
        pTextField.setFont(new Font("Arial" , Font.BOLD , 14));
        add(pTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300, 300 , 100 , 30);
        login.setBackground(Color.gray);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300 , 100 , 30);
        clear.setBackground(Color.gray);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350 , 230 , 30);
        signup.setBackground(Color.gray);
        signup.addActionListener(this);
        add(signup);


        getContentPane().setBackground(Color.WHITE);

        setSize(800 ,480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocation(350,200);
        
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == clear) {
            carTextField.setText("");
            pTextField.setText("");
        }
        else if (e.getSource() == login) {
            Conn c = new Conn();
            String cardNo = carTextField.getText();
            String pinNumber = pTextField.getText();

            String query = MessageFormat.format("SELECT * FROM logindata WHERE Card_Number = ''{0}'' and Pin_Number = ''{1}''" ,cardNo,pinNumber);
            try {
                ResultSet result = c.s.executeQuery(query);
                if (result.next()) {
                    setVisible(false);
                    new transactions(pinNumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card No \n or Pin Number \n Please try again");
                }
            } catch (Exception error) {
                System.out.println(error);
            }
        }
        else if(e.getSource() == signup){
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }


    public static void main(String[] args) {
        new Login();
        
    }
}