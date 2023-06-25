package onlinesurveysystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Thanks extends JFrame implements ActionListener {

    JButton close;

    Thanks() {

        setTitle("Online Survey System");
        setLayout(null);

        setBounds(600, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //for Questions numbers
        JLabel thanks = new JLabel("Thank You For Your Valuable Feedback");
        thanks.setBounds(40, 80, 1500, 100);
        thanks.setForeground(Color.RED);
        thanks.setFont(new Font("Raleway", Font.BOLD, 76));
        add(thanks);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/Thanks.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(450, 280, 580, 100);//600,450
        add(image);

        close = new JButton("CLOSE");
        close.setBounds(600, 500, 300, 30);
        close.setBackground(Color.GREEN);
        close.setForeground(Color.WHITE);
        close.addActionListener(this);
        add(close);

        setSize(1600, 800);
        setLocation(0, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

        try {

            if (ae.getSource() == close) {
                setVisible(false);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        new Thanks();
    }
}
