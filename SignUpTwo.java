import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;


public class SignUpTwo extends JFrame implements ActionListener{
    String formno;
     JButton next , prev;
     JTextField panTextField , aadharTextField;
     JRadioButton yesButton, noButton,eyesButton,enoButton;
     JComboBox<String> religionBox,categoryBox,incomeBox,educationBox,occupationBox;
    SignUpTwo(String formno){
        this.formno = formno;
        int x = 100;
        int y = 140;
        setLayout(null);
        setTitle("New Account Application Form - Page No 2");
         getContentPane().setBackground(Color.white);

        
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD , 22));
        additionalDetails.setBounds(290 , 30 , 400 , 40);
        add(additionalDetails);
        y += 50;

        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Raleway", Font.BOLD , 22));
        religion.setBounds(100 , y , 200 , 50);
        add(religion);
         religionBox = new JComboBox<>(new String[]{
            "Hindu" ,
             "Muslim", 
             "Christian", 
             "Sikh",
             "Jain",
             "Other"
            });
        religionBox.setBounds(200 , y+10 , 600 , 30);
        religionBox.setBackground(Color.WHITE);
        add(religionBox);
        y += 50;

        JLabel category = new JLabel("Category:");
        category.setFont(new Font("Raleway", Font.BOLD , 22));
        category.setBounds(100 , y , 200 , 50);
        add(category);
          categoryBox = new JComboBox<>(new String[]{
         "General" , 
         "SC(Schedule Caste)", 
         "ST(Schedule tribe)", 
         "OBC(Other Backwards Cast)"
        });
        categoryBox.setBounds(210 , y+10 , 590 , 30);
        categoryBox.setBackground(Color.WHITE);
        add(categoryBox);
        y += 50;

        JLabel income = new JLabel("Income:");
        income.setFont(new Font("Raleway", Font.BOLD , 22));
        income.setBounds(100 , y , 200 , 50);
        add(income);

        incomeBox = new JComboBox<>(new String[]{
         "Null" , 
         "< 1,50,000", 
         "< 2,50,000", 
         "< 5,00,000",
         "Upto 10,00,000"
        });
        incomeBox.setBounds(210 , y+10 , 590 , 30);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);
        y += 50;
        
        JLabel educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway", Font.BOLD , 22));
        educational.setBounds(100 , y , 200 , 50);
        add(educational);
        y += 20;

        JLabel qualification = new JLabel("qualification:");
        qualification.setFont(new Font("Raleway", Font.BOLD , 22));
        qualification.setBounds(100 , y , 200 , 50);
        add(qualification);

        educationBox = new JComboBox<>(new String[]{
         "Non Graduate" , 
         "Graduate", 
         "Post Graduate", 
         "Doctorate",
         "Others"
        });

        educationBox.setBounds(250 , y+10 , 550 , 30);
        educationBox.setBackground(Color.WHITE);
        add(educationBox);

        y += 50;

        JLabel occupation = new JLabel("Occupation:");
        occupation.setFont(new Font("Raleway", Font.BOLD , 22));
        occupation.setBounds(100 , y , 200 , 50);
        add(occupation);

         occupationBox = new JComboBox<>(new String[]{
         "Salaried" , 
         "Self Employed", 
         "Business man", 
         "Student",
         "Retired",
         "Others"
        });

        occupationBox.setBounds(250 , y+10 , 550 , 30);
        occupationBox.setBackground(Color.WHITE);
        add(occupationBox);

        y += 50;

        JLabel pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD , 22));
        pan.setBounds(100 , y , 200 , 50);
        add(pan);

        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD , 14));
        panTextField.setBounds(250 , y+10 , 550 , 30);
        add(panTextField);

        y += 50;

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD , 22));
        aadhar.setBounds(100 , y , 200 , 50);
        add(aadhar);

        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD , 14));
        aadharTextField.setBounds(300 , y+10 , 500 , 30);
        add(aadharTextField);

        y += 50;

        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD , 22));
        senior.setBounds(100 , y , 200 , 50);
        add(senior);
        yesButton = new JRadioButton("Yes");
        yesButton.setFont(new Font("Raleway", Font.BOLD , 15));
        yesButton.setBounds(300, y+10, 60 , 30);
        yesButton.setBackground(Color.white);
        add(yesButton);

        noButton = new JRadioButton("No");
        noButton.setFont(new Font("Raleway", Font.BOLD , 15));
        noButton.setBounds(450, y+10, 120 , 30);
        noButton.setBackground(Color.white);
        add(noButton);

        ButtonGroup seniButtonGroup = new ButtonGroup();
        seniButtonGroup.add(yesButton);
        seniButtonGroup.add(noButton);
        
        y += 50;

        JLabel existingAcc = new JLabel("Existing Account:");
        existingAcc.setFont(new Font("Raleway", Font.BOLD , 22));
        existingAcc.setBounds(100 , y , 200 , 50);
        add(existingAcc);

        eyesButton = new JRadioButton("Yes");
        eyesButton.setFont(new Font("Raleway", Font.BOLD , 15));
        eyesButton.setBounds(300, y+10, 60 , 30);
        eyesButton.setBackground(Color.white);
        add(eyesButton);

        enoButton = new JRadioButton("No");
        enoButton.setFont(new Font("Raleway", Font.BOLD , 15));
        enoButton.setBounds(450, y+10, 120 , 30);
        enoButton.setBackground(Color.white);
        add(enoButton);

        ButtonGroup existiButtonGroup = new ButtonGroup();
        existiButtonGroup.add(eyesButton);
        existiButtonGroup.add(enoButton);

        y += 50;

        
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
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == prev) {
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
        else
           { 
            String religion = (String)religionBox.getSelectedItem();
            String category = (String)categoryBox.getSelectedItem();
            String  income = (String)incomeBox.getSelectedItem();
            String education = (String)educationBox.getSelectedItem();
            String pan = panTextField.getText();
            String aadhar = aadharTextField.getText();
            String seniorCitizen = null;
            if (yesButton.isSelected()) {
                seniorCitizen = "Yes";
            }
            else if(noButton.isSelected()){
                seniorCitizen = "No";
            }
            String existingAcc = null;
             if (eyesButton.isSelected()) {
                existingAcc = "Yes";
            }
            else if(enoButton.isSelected()){
                existingAcc = "No";
            }
            try {
                 Conn c = new Conn();
                        String query = "insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+pan+"','"+aadhar+"','"+seniorCitizen+"','"+existingAcc+"')";
                                c.s.executeUpdate(query);
                                setVisible(false);
               new SignUpThree(formno).setVisible(true);

            } catch (Exception e1) {
               System.out.println(e1);
            }
        }
    }
    public static void main(String[] args) {
        new SignUpTwo("");
    }
   
}
