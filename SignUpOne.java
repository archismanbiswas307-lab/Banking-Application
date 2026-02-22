import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


public class SignUpOne  extends JFrame implements ActionListener{
    JTextField nameTextField , fnameTextField , mnameTextField, emailTextField, addressTextField,cityTextField,stateTextField,pinTextField;
     Random random = new Random();
    Long ranNo = Math.abs(random.nextLong() % 9000L + 1000L ) ;
    JDateChooser dateChooser;
    JRadioButton maleButton,femaleButton,marrRadioButton,nonmarrRadioButton,otherMar;
    JButton next , prev;
    SignUpOne(){

        setLayout(null);

//Form No generator

       
        
        JLabel formno = new JLabel("APPLICATION FORM NO."+ranNo);
        formno.setFont(new Font("Raleway", Font.BOLD , 38));
        formno.setBounds(140 , 20 , 600 , 40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD , 22));
        personalDetails.setBounds(290 , 80 , 400 , 40);
        add(personalDetails);

//Recipients Name 

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD , 22));
        name.setBounds(100 , 140 , 200 , 50);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD , 14));
        nameTextField.setBounds(300 , 150 , 400 , 30);
        add(nameTextField);

//Fathers Name 

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD , 22));
        fname.setBounds(100 , 190 , 200 , 30);
        add(fname);


        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Raleway", Font.BOLD , 14));
        fnameTextField.setBounds(300 , 200 , 400 , 30);
        add(fnameTextField);

//Mothers Name

        JLabel mname = new JLabel("Mother's Name:");
        mname.setFont(new Font("Raleway", Font.BOLD , 22));
        mname.setBounds(100 , 240 , 200 , 30);
        add(mname);

        mnameTextField = new JTextField();
        mnameTextField.setFont(new Font("Raleway", Font.BOLD , 14));
        mnameTextField.setBounds(300 , 250 , 400 , 30);
        add(mnameTextField);

//Date of Birth

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD , 22));
        dob.setBounds(100 , 290 , 200 , 30);
        add(dob);


        dateChooser = new JDateChooser();
        dateChooser.setBounds(300,290,400,30);
        dateChooser.setForeground(new Color(105, 105 , 105));
        add(dateChooser);
        

//Gender


        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD , 22));
        gender.setBounds(100 , 340 , 200 , 30);
        add(gender);

        maleButton = new JRadioButton("Male");
        maleButton.setFont(new Font("Raleway", Font.BOLD , 15));
        maleButton.setBounds(300, 340, 60 , 30);
        maleButton.setBackground(Color.white);
        add(maleButton);

        femaleButton = new JRadioButton("Female");
        femaleButton.setFont(new Font("Raleway", Font.BOLD , 15));
        femaleButton.setBounds(450, 340, 120 , 30);
        femaleButton.setBackground(Color.white);
        add(femaleButton);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);


//email

        JLabel email = new JLabel("Email Address:");
        email.setFont(new Font("Raleway", Font.BOLD , 22));
        email.setBounds(100 , 390 , 200 , 30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD , 14));
        emailTextField.setBounds(300 , 400 , 400 , 30);
        add(emailTextField);

//Marital

        JLabel marital = new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway", Font.BOLD , 22));
        marital.setBounds(100 , 440 , 200 , 30);
        add(marital);

        
        marrRadioButton = new JRadioButton("Married");
        marrRadioButton.setFont(new Font("Raleway", Font.BOLD , 15));
        marrRadioButton.setBounds(300, 440, 90 , 30);
        marrRadioButton.setBackground(Color.white);
        add(marrRadioButton);

         nonmarrRadioButton = new JRadioButton("Unmarried");
        nonmarrRadioButton.setFont(new Font("Raleway", Font.BOLD , 15));
        nonmarrRadioButton.setBounds(450, 440, 120 , 30);
        nonmarrRadioButton.setBackground(Color.white);
        add(nonmarrRadioButton);

        otherMar = new JRadioButton("Other");
        otherMar.setFont(new Font("Raleway", Font.BOLD , 15));
        otherMar.setBounds(600, 440, 120 , 30);
        otherMar.setBackground(Color.white);
        add(otherMar);

        ButtonGroup mariButtonGroup = new ButtonGroup();
        mariButtonGroup.add(marrRadioButton);
        mariButtonGroup.add(nonmarrRadioButton);
        mariButtonGroup.add(otherMar);

//Address 

        JLabel address = new JLabel("Address :");
        address.setFont(new Font("Raleway", Font.BOLD , 22));
        address.setBounds(100 , 490 , 200 , 30);
        add(address);

        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Raleway", Font.BOLD , 14));
        addressTextField.setBounds(300 , 490 , 400 , 30);
        add(addressTextField);

//City 

        JLabel city = new JLabel("City :");
        city.setFont(new Font("Raleway", Font.BOLD , 22));
        city.setBounds(100 , 540 , 200 , 30);
        add(city);

        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD ,14));
        cityTextField.setBounds(300 , 540 , 400 ,30);
        add(cityTextField);

//State

        JLabel state = new JLabel("State :");
        state.setFont(new Font("Raleway", Font.BOLD , 22));
        state.setBounds(100 , 590 , 200 , 30);
        add(state);

        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Raleway", Font.BOLD , 14));
        stateTextField.setBounds(300 , 590 , 400 , 30);
        add(stateTextField);
//pin code
        JLabel pincode = new JLabel("Pin code :");
        pincode.setFont(new Font("Raleway", Font.BOLD , 22));
        pincode.setBounds(100 , 640 , 200 , 30);
        add(pincode);

        pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD , 14));
        pinTextField.setBounds(300 , 640 , 400 , 30);
        add(pinTextField);

//Next button
        next = new JButton("Next");
        next.setBackground(Color.WHITE);
        next.setBorderPainted(false);
        next.setFont(new Font("Raleway", Font.BOLD, 15));
        next.setBounds(700, 750 , 100 , 30);
        next.addActionListener(this);
        add(next);

//Previous
        prev = new JButton("<- prev");
        prev.setBackground(Color.WHITE);
        prev.setBorderPainted(false);
        prev.setFont(new Font("Raleway", Font.BOLD, 15));
        prev.setBounds(00, 750 , 100 , 30);
        prev.addActionListener(this);
        add(prev);

        getContentPane().setBackground(Color.white);

        setSize(850,899);
        setLocation(350,10);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == prev){
            setVisible(false);
            new Login().setVisible(true);
        }
        else{

                String formNo = ""+ranNo;
                String name = nameTextField.getText();
                String fname = fnameTextField.getText();
                String mname = mnameTextField.getText();
                String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
                String gender = null;
                if (maleButton.isSelected()) {
                        gender = "Male";
                }
                else if (femaleButton.isSelected()) {
                        gender = "Female";
                }

                String email = emailTextField.getText();
                String marital = null;

                if (marrRadioButton.isSelected()) {
                        marital = "Married";
                }
                else if (nonmarrRadioButton.isSelected()) {
                        marital = "Unmarried";
                }
                else if(otherMar.isSelected()) {        
                        marital = "other";
                }

                String address = addressTextField.getText();
                String city = cityTextField.getText();
                String state = stateTextField.getText();
                String pinCode = pinTextField.getText();


                try {
                        
                        if (name.equals("")) {
                                JOptionPane.showMessageDialog(null, "Name is required");
                        }
                        else{
                                Conn c = new Conn();
                        String query = "insert into signup values('"+formNo+"','"+name+"','"+fname+"','"+mname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pinCode+"')";
                                c.s.executeUpdate(query);

                                setVisible(false);
                                new SignUpTwo(formNo).setVisible(true);
                        }
                        
                } catch (Exception ae) {
                        System.out.println(ae);
                }
        }
    }
    public static void main(String[] args) {
        new SignUpOne();
    }
}
