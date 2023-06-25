package onlinesurveysystem;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class SignUp extends JFrame implements ActionListener{

    JButton  login,submit;
    JTextField nametext,emailtext,phonetext,regtext,statetext;
    SignUp() {
        
        setTitle("Online Survey System");
        setLayout(null);
        
        JLabel text = new JLabel("WELCOME TO ONLINE SURVEY SYSTEM");
        text.setBounds(200, 0, 1100, 150);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Times new Roman", Font.BOLD, 50));
        add(text);
        
//        JLabel text1 = new JLabel("REGISTER HERE");
//        text1.setBounds(630, 0, 1100, 290);
//        text1.setForeground(Color.RED);
//        text1.setFont(new Font("ARIAL", Font.BOLD, 30));
//        add(text1);
//        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/reg.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(610, 60, 280, 200);//600,450
        add(image);
        
         ImageIcon i3 = new ImageIcon(ClassLoader.getSystemResource("Icons/hh.png"));
        JLabel pimage = new JLabel(i3);
        pimage.setBounds(10, 140, 480, 500);//600,450
        add(pimage);
        
       ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Icons/8.png"));
        JLabel secimage = new JLabel(i2);
        secimage.setBounds(1100, 140, 380, 500);//600,450
        add(secimage);

        
     
        
        JLabel name= new JLabel("Name : ");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(550,250,100,50);
        add(name);
        
        nametext=new JTextField();
        nametext.setFont(new Font("Raleway",Font.BOLD,14));
        nametext.setBounds(700,260,230,30);
        add(nametext);
        
        JLabel email= new JLabel("Email : ");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(550,0,1100,640);
        add(email);
        
        emailtext=new JTextField();
        emailtext.setFont(new Font("Raleway",Font.BOLD,14));
        emailtext.setBounds(700,300,230,30);
        add(emailtext);
        
        JLabel phone= new JLabel("Phone No : ");
        phone.setFont(new Font("Raleway",Font.BOLD,20));
        phone.setBounds(550,0,1100,720);
        add( phone);
        
        phonetext=new JTextField();
        phonetext.setFont(new Font("Raleway",Font.BOLD,14));
        phonetext.setBounds(700,340,230,30);
        add(phonetext);
        
        JLabel reg= new JLabel("Register No : ");
        reg.setFont(new Font("Raleway",Font.BOLD,20));
        reg.setBounds(550,0,1100,810);
        add(reg);
                
        regtext=new JTextField();
        regtext.setFont(new Font("Raleway",Font.BOLD,14));
        regtext.setBounds(700,390,230,30);
        add(regtext);
        
        JLabel state= new JLabel("State : ");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(550,0,1100,910);
        add(state);
        
        statetext=new JTextField();
        statetext.setFont(new Font("Raleway",Font.BOLD,14));
        statetext.setBounds(700,440,230,30);
        add(statetext);
        
        submit = new JButton("Register");
        submit.setBounds(600, 530, 100, 30);
        submit.setBackground(Color.GREEN);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        login = new JButton("Now Login");
        login.setBounds(780, 530, 120, 30);
        login.setBackground(Color.GREEN);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
     

        getContentPane().setBackground(Color.WHITE);
        setSize(1600, 800);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        
        String name= nametext.getText();
        String email=emailtext.getText();
        String phone=phonetext.getText();
        String state=statetext.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(rootPane, "Name is Required");
            }else{
                Conn c=new Conn();
                String query="Insert into signup values('"+name+"', '"+email+"', '"+phone+"', '"+state+"')";
                c.s.executeUpdate(query);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
       if(ae.getSource()==login){
           setVisible(false);
           new Login();
       }else if(ae.getSource()==submit){
         JOptionPane.showMessageDialog(rootPane, "Registered Successfully");
       }
    }

    public static void main(String args[]) {
        // TODO code application logic here
        new SignUp();
    }

}
