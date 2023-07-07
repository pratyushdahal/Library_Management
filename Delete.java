package librarymanagement;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Delete extends JFrame implements ActionListener{

    JLabel nametobedelete;
    JTextField usernamefield;
    JButton backButton,deleteButton;

    Delete(){
        super("Library Management System");
        deleteuser();
    }

    public void deleteuser(){
        nametobedelete=new JLabel("Enter a user id to be removed:");
        usernamefield=new JTextField(30);
        deleteButton=new JButton("Delete user");
        backButton=new JButton("Back");

        add(nametobedelete);
        add(usernamefield);
        add(deleteButton);
        add(backButton);
        deleteButton.addActionListener(this);
        backButton.addActionListener(this);

        setLayout(new FlowLayout());
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource()==deleteButton) {
            Databaseconnector conn=new Databaseconnector();
            conn.connectToDb();
            Statement stm=conn.createStatement();
            int id =Integer.parseInt(usernamefield.getText());
            System.out.println(id);
            String query="DELETE FROM `tbl_user` WHERE id='"+id+"'";
            JOptionPane.showMessageDialog(this,"User deleted successfully");
            System.out.println(query);
            try {
                stm.executeUpdate(query);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource()==backButton) {
            Adminsection adminsection=new Adminsection();
            adminsection.setVisible(true);
            dispose(); 
        }
    }
 
    public static void main(String[] args) {
       Delete delete=new Delete();
       delete.setVisible(true);
    }

}
