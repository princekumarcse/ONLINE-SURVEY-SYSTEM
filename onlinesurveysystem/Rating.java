package onlinesurveysystem;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Rating extends JFrame implements ActionListener {

    JTextField nametext, emailtext;
    JButton submit;
    JRadioButton a, b, c, d;

    Rating() {

        setTitle("Online Survey System");
        setLayout(null);

        JLabel text = new JLabel("HELLO DEAR KINDLY FILL THE SURVEY");
        text.setBounds(200, 0, 1100, 150);
        text.setForeground(Color.RED);
        text.setFont(new Font("Times new Roman", Font.BOLD, 50));
        add(text);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/rate.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(40, 200, 680, 500);//600,450
        add(image);

        JLabel text1 = new JLabel("ENTER BELOW'S DETAILS");
        text1.setForeground(new Color(0, 0, 30));
        text1.setForeground(Color.CYAN);
        text1.setBounds(550, 0, 1100, 290);
        text1.setFont(new Font("ARIAL", Font.BOLD, 30));
        add(text1);

        JLabel name = new JLabel("Name : ");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(1000, 0, 1100, 450);
        add(name);

        nametext = new JTextField();
        nametext.setFont(new Font("Raleway", Font.BOLD, 14));
        nametext.setBounds(1100, 210, 230, 30);
        add(nametext);

        JLabel email = new JLabel("Email : ");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(1000, 0, 1100, 630);
        add(email);

        emailtext = new JTextField();
        emailtext.setFont(new Font("Raleway", Font.BOLD, 14));
        emailtext.setBounds(1100, 300, 230, 30);
        add(emailtext);

        JLabel rate = new JLabel("PLEASE GIVE YOUR VALUABLE FEEDBACK");
        rate.setForeground(Color.ORANGE);
        rate.setFont(new Font("Raleway", Font.BOLD, 30));
        rate.setBounds(830, 350, 1000, 30);
        add(rate);

        a = new JRadioButton("POOR");
        a.setBounds(830, 475, 70, 20);
        a.setBackground(Color.WHITE);
        add(a);

        b = new JRadioButton("AVERAGE");
        b.setBounds(1000, 460, 100, 50);
        b.setBackground(Color.WHITE);
        add(b);

        c = new JRadioButton("GOOD");
        c.setBounds(1200, 460, 80, 50);
        c.setBackground(Color.WHITE);
        add(c);

        d = new JRadioButton("VERY GOOD");
        d.setBounds(1380, 450, 200, 70);
        d.setBackground(Color.WHITE);
        add(d);

        ButtonGroup rategroup = new ButtonGroup();
        rategroup.add(a);
        rategroup.add(b);
        rategroup.add(c);
        rategroup.add(d);

        submit = new JButton("SUBMIT");
        submit.setBounds(1000, 580, 300, 30);
        submit.setBackground(Color.GREEN);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        getContentPane().setBackground(Color.WHITE);
        setSize(1600, 800);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String name = nametext.getText();
        String email = emailtext.getText();
        String rate = null;
        if (a.isSelected()) {
            rate = "POOR";
        } else if (b.isSelected()) {
            rate = "AVERAGE";
        } else if (c.isSelected()) {
            rate = "GOOD";
        } else if (d.isSelected()) {
            rate = "VERY GOOD";
        }

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            } else if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Email is Required");
            } else {
                Conn c = new Conn();
                String query = "Insert into rate values('" + name + "', '" + email + "', '" + rate + "')";
                c.s.executeUpdate(query);
            }

            if (ae.getSource() == submit) {
                JOptionPane.showMessageDialog(rootPane, "Thank You for Your Valuble Time");
                setVisible(false);
                new Thanks();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new Rating();
    }
}
