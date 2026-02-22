import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.text.MessageFormat;
public class SignUpThree extends JFrame implements ActionListener{
    String formNo;
    JRadioButton savingsAccount , reccuringAccount, currentAccount , fixedDepositeAccount;
    JCheckBox atmBox, internetBnankingBox,mobileBankingBox,emailSmsBox,chequeBookBox,eStatementBox , declarCheckBox;
    JButton submit , cancel;
    SignUpThree(String formno){
        this.formNo = formno;
        setLayout(null);
        JLabel accountDetails = new JLabel("Page 3 : Account Details");
        accountDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        accountDetails.setBounds(280,40,400,40);
        add(accountDetails);

        JLabel accountType = new JLabel("Account Type");
        accountType.setFont(new Font("Raleway", Font.BOLD, 22));
        accountType.setBounds(200,90,200,30);
        add(accountType);

        savingsAccount = new JRadioButton("Savings Account");
        savingsAccount.setFont(new Font("Raleway" , Font.BOLD, 20));
        savingsAccount.setBounds(200,130,250,30);
        savingsAccount.setBackground(Color.white);
        add(savingsAccount);

        reccuringAccount = new JRadioButton("Recurring Account");
        reccuringAccount.setFont(new Font("Raleway" , Font.BOLD, 20));
        reccuringAccount.setBounds(500,130,250,30);
        reccuringAccount.setBackground(Color.white);
        add(reccuringAccount);

        currentAccount = new JRadioButton("Current Account");
        currentAccount.setFont(new Font("Raleway" , Font.BOLD, 20));
        currentAccount.setBounds(200,180,250,30);
        currentAccount.setBackground(Color.white);
        add(currentAccount);

        fixedDepositeAccount = new JRadioButton("Fixed Deposit Account");
        fixedDepositeAccount.setFont(new Font("Raleway" , Font.BOLD, 20));
        fixedDepositeAccount.setBounds(500,180,250,30);
        fixedDepositeAccount.setBackground(Color.white);
        add(fixedDepositeAccount);
        ButtonGroup accButtonGroup = new ButtonGroup();
        accButtonGroup.add(currentAccount);
        accButtonGroup.add(reccuringAccount);
        accButtonGroup.add(savingsAccount);
        accButtonGroup.add(fixedDepositeAccount);

         JLabel cardDetails = new JLabel("Your 16 digit Card Number:");
        cardDetails.setFont(new Font("Raleway", Font.BOLD, 10));
         cardDetails.setBounds(200,300,400,40);
        add(cardDetails);

        JLabel cardNo = new JLabel("Card Number:");
        cardNo.setFont(new Font("Raleway", Font.BOLD, 22));
         cardNo.setBounds(200,280,200,40);
        add(cardNo);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
         number.setBounds(400,280,400,40);
        add(number);

        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
         pin.setBounds(200,350,200,40);
        add(pin);

        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Raleway", Font.BOLD, 22));
         pinNumber.setBounds(400,350,400,40);
        add(pinNumber);
        JLabel pinDetails = new JLabel("This is a 4 digit PIN");
        pinDetails.setFont(new Font("Raleway", Font.BOLD, 10));
         pinDetails.setBounds(200,370,250,40);
        add(pinDetails);

        JLabel servicesLabel = new JLabel("Services Required:");
        servicesLabel.setFont(new Font("Raleway", Font.BOLD,22));
        servicesLabel.setBounds(200, 400,400,40);
        add(servicesLabel); 

        atmBox = new JCheckBox("ATM Card");
        atmBox.setFont(new Font("Raleway", Font.BOLD,18));
        atmBox.setBounds(200, 440, 200 , 40);
        atmBox.setBackground(Color.white);
        add(atmBox);

         internetBnankingBox = new JCheckBox("Internet Banking");
        internetBnankingBox.setFont(new Font("Raleway", Font.BOLD,18));
        internetBnankingBox.setBounds(500, 440, 250 , 40);
        internetBnankingBox.setBackground(Color.white);
        add(internetBnankingBox);

        mobileBankingBox = new JCheckBox("Mobile Banking");
        mobileBankingBox.setFont(new Font("Raleway", Font.BOLD,18));
        mobileBankingBox.setBounds(200, 490, 200 , 40);
        mobileBankingBox.setBackground(Color.white);
        add(mobileBankingBox);

         emailSmsBox = new JCheckBox("Email & SMS option");
        emailSmsBox.setFont(new Font("Raleway", Font.BOLD,18));
        emailSmsBox.setBounds(500, 490, 250 , 40);
        emailSmsBox.setBackground(Color.white);
        add(emailSmsBox);

        chequeBookBox = new JCheckBox("Cheque Book");
        chequeBookBox.setFont(new Font("Raleway", Font.BOLD,18));
        chequeBookBox.setBounds(200, 540, 200 , 40);
        chequeBookBox.setBackground(Color.white);
        add(chequeBookBox);

        eStatementBox = new JCheckBox("E-Statement Option");
        eStatementBox.setFont(new Font("Raleway", Font.BOLD,18));
        eStatementBox.setBounds(500, 540, 250 , 40);
        eStatementBox.setBackground(Color.white);
        add(eStatementBox);

        declarCheckBox = new JCheckBox("I hereby declare that the above entered details connect to the best of my knowledge");
        declarCheckBox.setFont(new Font("Raleway", Font.BOLD,10));
        declarCheckBox.setBounds(300, 620, 500 , 40);
        declarCheckBox.setBackground(Color.white);
        add(declarCheckBox);

        submit= new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD,22));
        submit.setBounds(200, 680, 200 , 40);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);
        
        cancel= new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD,22));
        cancel.setBounds(500, 680, 200 , 40);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);

         getContentPane().setBackground(Color.white);
    
        setSize(850,820);
        setLocation(350,10);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
    public void actionPerformed(ActionEvent action) {
       if (action.getSource() == submit) {
            String accountType = null;
            if(savingsAccount.isSelected()){
                accountType = "Savings Account";
            }
            else if(reccuringAccount.isSelected()){
                accountType = "Recurring Account";
            }
            else if(currentAccount.isSelected()){
                accountType = "Current Account";
            }
            else if(fixedDepositeAccount.isSelected()){
                accountType = "Fixed Deposit Account";
            }

            Random random = new Random();
            String cardNo = ""+(Math.abs((random.nextLong () % 90000000L)) + 5040936000000000L);

            String pinNumber = ""+(Math.abs((random.nextLong()%9000l))+1000L);

            String facility = "";

            if (atmBox.isSelected()) {
                facility += " ATM Card";
            }
            if (internetBnankingBox.isSelected()) {
                facility += " Internet Banking";
            }
            if (mobileBankingBox.isSelected()) {
                facility += " Mobile Banking";
            }
            if (emailSmsBox.isSelected()) {
                facility += " Email & SMS Option";
            }
             if (chequeBookBox.isSelected()) {
                facility += " Cheque Book";
            }
             if (eStatementBox.isSelected()) {
                facility +=  " E-Statement Option";
            }

            try {
                if (accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                }
                else{
                    Conn conn  = new Conn();
                    String query1 = MessageFormat.format("insert into signupthree values(''{0}'' , ''{1}'' , {2} , {3} , ''{4}'')",formNo ,accountType,cardNo,pinNumber,facility);
                    conn.s.executeUpdate(query1);


                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNo + "\n Pin Number: " + pinNumber);
 
                    String query2 = MessageFormat.format("insert into loginData values(''{0}'' , ''{1}'' , ''{2}'')",formNo , cardNo, pinNumber );
                    conn.s.executeUpdate(query2);

                    setVisible(false);
                    new deposit(pinNumber).setVisible(true);

                }
            } catch (Exception e) {
                System.out.println(e);
            }
            
       }
       else if (action.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
       }
    }
    public static void main(String[] args) {
        new SignUpThree("");
    }
}
