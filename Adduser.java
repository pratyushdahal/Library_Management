package librarymanagement;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Adduser extends JFrame implements ActionListener{
    JLabel name,pass,email,address,contact;
    JTextField namefield,emailfield,addressfield,contactfield;
    JPasswordField passfield;
    JButton adduserbtn, backbtn;
    Adduser(){
        super("Library Management System");
        adduser();
    }
    public void adduser(){
        name=new JLabel("Name:");
        namefield=new JTextField(30);
        pass=new JLabel("Password:");
        passfield=new JPasswordField(30);
        email=new JLabel("Email:");
        emailfield=new JTextField(30);
        address=new JLabel("Address:");
        addressfield=new JTextField(30);
        contact=new JLabel("Contact:");
        contactfield=new JTextField(30);
        adduserbtn=new JButton("Add User");
        backbtn=new JButton("Back");

        add(name);
        add(namefield);
        add(pass);
        add(passfield);
        add(email);
        add(emailfield);
        add(address);
        add(addressfield);
        add(contact);
        add(contactfield);
        add(adduserbtn);
        add(backbtn);
        adduserbtn.addActionListener(this);
        backbtn.addActionListener(this);
        setLayout(new FlowLayout());
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    }
    



    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource()==adduserbtn) {
                String name=namefield.getText();
                String password=new String(passfield.getPassword());
                String email=emailfield.getText();
                String address=addressfield.getText();
                String contact=contactfield.getText();
                Databaseconnector conn=new Databaseconnector();
                conn.connectToDb();

                Statement st=conn.createStatement();
                String query="INSERT into `tbl_user` (`usename`, `password`, `email`, `address`, `contact`) values('"+name+"','"+password+"','"+email+"','"+address+"','"+contact+"')";
                System.out.print(query);
                st.executeUpdate(query);
                
            }
        } catch (Exception ae) {
            ae.printStackTrace();

        }
        if (e.getSource()==adduserbtn) {
            Adminsection adminsection=new Adminsection();
            adminsection.setVisible(true);
            dispose();
        }
        if (e.getSource()==backbtn) {
            Adminsection section=new Adminsection();
            section.setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        Adduser adduser=new Adduser();
        adduser.setVisible(true);
    }
    
}
