package librarymanagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Adminsection extends JFrame implements ActionListener{
    JButton addbtn,viewbtn,deletebtn,logoutbtn;
    JLabel label; 

    Adminsection(){
        super("Library Management System");
        addadminsection();
    }

    public void addadminsection(){
        label=new JLabel("Admin Section");
        addbtn=new JButton("Add librarian");
        viewbtn=new JButton("View librarian");
        deletebtn=new JButton("Delete librarian");
        logoutbtn=new JButton("Logout");

        label.setBounds(130,50,150,30);
        addbtn.setBounds(100,100,150,30);
        viewbtn.setBounds(100,150,150,30);
        deletebtn.setBounds(100,200,150,30);
        logoutbtn.setBounds(100,250,150,30);
        
        add(label);
        add(addbtn);
        add(viewbtn);
        add(deletebtn);
        add(logoutbtn);
        addbtn.addActionListener(this);
        viewbtn.addActionListener(this);
        deletebtn.addActionListener(this);
        logoutbtn.addActionListener(this);
        setLayout(null);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);     
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==addbtn) {
            Adduser adduser=new Adduser();
            adduser.setVisible(true);
            dispose();
        }
        if (e.getSource()==viewbtn) {
            Viewuser viewuser=new Viewuser();
            viewuser.setVisible(true);
            dispose();
        }
        if (e.getSource()==deletebtn) {
            Delete deleteuser=new Delete();
            deleteuser.setVisible(true);
            dispose();
        }
        if (e.getSource()==logoutbtn) {
            Adminlogin al=new Adminlogin();
            al.setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        Adminsection adminsection=new Adminsection();
        adminsection.setVisible(true);
    }

}
