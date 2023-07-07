package librarymanagement;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Lblogin extends JFrame implements ActionListener {
    JLabel name,password;
    JTextField namefield;
    JPasswordField passfield;
    JButton btnlogin;

    Lblogin(){
        super("Library Management System");
        librarylogin();
    }
    public void librarylogin(){
        name=new JLabel("Username:");
        namefield=new JTextField(25);
        password=new JLabel("Password:");
        passfield=new JPasswordField(25);
        btnlogin=new JButton("Login");

        add(name);
        add(namefield);
        add(password);
        add(passfield);
        add(btnlogin);

        btnlogin.addActionListener(this);
        setLayout(new FlowLayout());
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource()==btnlogin) {
                Databaseconnector conn=new Databaseconnector();
                conn.connectToDb();
                String username=namefield.getText();
                String password=new String(passfield.getPassword());

                Statement stm=conn.createStatement();
                if (stm==null) {
                    return;
                }
                 String qry="SELECT * FROM  `tbl_librarianlogin` WHERE username='"+username+"'"+" AND password='"+password+"';";
                 ResultSet rs = stm.executeQuery(qry);
                
                if (rs.next()) {
                    dispose();
                    Login lgn=new Login();
                    lgn.show();
                    System.out.println("entered correct username and password");
                    Librariansection librarian=new Librariansection();
                    librarian.setVisible(true);
                    dispose();
                }else{
                JOptionPane.showMessageDialog(this, "username and password wrong");
                }   
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) {
       Lblogin login=new Lblogin();
       login.setVisible(true);
        
    }
    
}
