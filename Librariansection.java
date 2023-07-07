package librarymanagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Librariansection extends JFrame implements ActionListener{
    JLabel label;
    JButton addbtn,viewbtn,issuebtn,viewissuebtn,returnbtn,logoutbtn;

    Librariansection(){
        super("Library Management System");
        librarian();
    }
    public void librarian(){
        label=new JLabel("Librarian Section");
        addbtn=new JButton("Add book");
        viewbtn=new JButton("View book");
        issuebtn=new JButton("Issue book");
        viewissuebtn=new JButton("View issue book");
        returnbtn=new JButton("Return");
        logoutbtn=new JButton("Logout");

        label.setBounds(180,50,100,30);
        addbtn.setBounds(150,100,150,30);
        viewbtn.setBounds(150,150,150,30);
        issuebtn.setBounds(150,200,150,30);
        viewissuebtn.setBounds(150,250,150,30);
        returnbtn.setBounds(150,300,150,30);
        logoutbtn.setBounds(150,350,150,30);

        add(label);
        add(addbtn);
        add(viewbtn);
        add(issuebtn);
        add(viewissuebtn);
        add(returnbtn);
        add(logoutbtn);
        addbtn.addActionListener(this);
        viewbtn.addActionListener(this);
        issuebtn.addActionListener(this);
        viewissuebtn.addActionListener(this);
        returnbtn.addActionListener(this);
        logoutbtn.addActionListener(this);

        setSize(500,500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==addbtn) {
            Addbook add=new Addbook();
            add.setVisible(true);
            dispose();
        }
        if (e.getSource()==viewbtn) {
            Viewbook view=new Viewbook();
            view.setVisible(true);
            dispose();
        }
        if (e.getSource()==issuebtn) {
            Issuebook issue=new Issuebook();
            issue.setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        Librariansection librarysection= new Librariansection();
        librarysection.setVisible(true);
    }
    
}
