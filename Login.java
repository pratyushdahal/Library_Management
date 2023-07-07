package librarymanagement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    JLabel label;
    JButton btn1, btn2;
   
    Login(){
        super("Library Management System");
        label = new JLabel("Login Panel");
        btn1 = new JButton("Admin login");
        btn2 = new JButton("Librarian login");
        
        label.setBounds(140, 50, 100, 30);
        btn1.setBounds(100, 100, 150, 30);
        btn2.setBounds(100, 150, 150, 30);
        
        add(label);
        add(btn1);
        add(btn2);
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
    
        setLayout(null);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }

    

    public static void main(String[] args) {
        new Login();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1){
            Adminlogin adminFrame =  new Adminlogin();
            adminFrame.setVisible(true);
            dispose();
        }
        else{

        }
    }
}
