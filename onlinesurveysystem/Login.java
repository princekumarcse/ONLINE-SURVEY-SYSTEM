package onlinesurveysystem;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Login extends JFrame implements ActionListener {

    JButton Signup, Clear, Login;
    JTextField emailTextField;
    JPasswordField PinTextField;

    Login() {

        setTitle("Online Survey System");
        setLayout(null);

        JLabel text = new JLabel("WELCOME TO ONLINE SURVEY SYSTEM");
        text.setBounds(230, 0, 1100, 150);
         text.setForeground(Color.RED);
        text.setFont(new Font("Times new Roman", Font.BOLD, 50));
        add(text);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/5.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 350, 750);//600,450
        add(image);
        
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Icons/5.png"));
        JLabel secimage = new JLabel(i2);
        secimage.setBounds(0, 0, 2500, 750);//600,450
        add(secimage);

        JLabel email = new JLabel("Email : ");
        email.setBounds(500, 160, 1100, 150);
        email.setFont(new Font("Raleway", Font.BOLD, 28));
        add(email);

        emailTextField = new JTextField();
        emailTextField.setBounds(720, 220, 250, 30);
        emailTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(emailTextField);

        JLabel phone = new JLabel("Phone : ");
        phone.setBounds(500, 240, 1100, 150);
        phone.setFont(new Font("Raleway", Font.BOLD, 28));
        add(phone);

        PinTextField = new JPasswordField();
        PinTextField.setBounds(720, 300, 250, 30);
        PinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(PinTextField);

        Clear = new JButton("Clear");
        Clear.setBounds(590, 440, 100, 30);
        Clear.setBackground(Color.cyan);
        Clear.setForeground(Color.WHITE);
        Clear.addActionListener(this);
        add(Clear);
        
         Login = new JButton("SIGN IN");
        Login.setBounds(790, 440, 100, 30);
        Login.setBackground(Color.cyan);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);

        Signup = new JButton("SIGN UP");
        Signup.setBounds(590, 550, 300, 30);
        Signup.setBackground(Color.BLUE);
        Signup.setForeground(Color.WHITE);
        Signup.addActionListener(this);
        add(Signup);

        getContentPane().setBackground(Color.WHITE);
        setSize(1600, 800);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
     
        if (ae.getSource() == Clear) {
            emailTextField.setText(" ");
            PinTextField.setText(" ");
        } else if (ae.getSource() == Login) {
            Conn c = new Conn();

            String email = emailTextField.getText();
            String phone = PinTextField.getText();
            String query = "Select *from signup where email='" + email + "' and phone='" + phone + "'";
            try {
                c.s.executeQuery(query);
                if (email.equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Enter Email");
                } else if (phone.equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Enter Phone NO as Password");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Login Successful");
                    setVisible(false);
                    new Rating();
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (ae.getSource() == Signup) {
            setVisible(false);
            new SignUp().setVisible(true);
        }

    }

    public static void main(String args[]) {
        new Login();
    }
}
