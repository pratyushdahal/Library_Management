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
import javax.swing.JTextField;

public class Adminlogin extends JFrame implements ActionListener{
    JLabel user,pass,label;
    JTextField userField,passField;
    JButton loginBtn;
    
    Adminlogin(){
        super("Library management");
        setGui();
    }
    public void setGui(){
        user= new JLabel("Username :");
        userField=new JTextField(25);
        pass=new JLabel("Password:");
        passField=new JTextField(25);
        loginBtn=new JButton("Login");
        add(user);
        add(userField);
        add(pass);
        add(passField);
        add(loginBtn);


        loginBtn.addActionListener(this);
        setLayout(new FlowLayout());
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    
    }
    
    public static void main(String[] args) {
       Adminlogin adminlogin=new Adminlogin();
       adminlogin.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       try {
        if(e.getSource()==loginBtn){
            Databaseconnector cn = new Databaseconnector();
            cn.connectToDb();
            String username = userField.getText();
            String password = passField.getText();
            
            Statement stm = cn.createStatement();
            if(stm == null)
            {
                return;
            }
            String qry="SELECT * FROM  `tbl_adminlogin` WHERE username='"+username+"'"+" AND password='"+password+"';";
            ResultSet rs = stm.executeQuery(qry);

            if(rs.next()){
                dispose();
                Login lgn=new Login();
                lgn.show();
                System.out.println("entered correct username and password");
                Adminsection admin=new Adminsection();
                admin.setVisible(true);
                dispose();
            }else{
                JOptionPane.showMessageDialog(this, "username and password wrong");
            }           
        }


       } catch (Exception ex) {
            System.out.println(ex);
        } 
       
    }
     
}
