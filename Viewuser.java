package librarymanagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Viewuser extends JFrame implements ActionListener {
    JTable viewtable;
    JScrollPane scroll;
    JButton backButton;

    Viewuser(){
        super("Library Management System");
        viewuserdetails();
    }
    public void viewuserdetails(){
        String [] columnname={"Username","Password","Email","Address","Contact"};
        DefaultTableModel tablemodel=new DefaultTableModel(columnname, 0);
        viewtable=new JTable(tablemodel);
        scroll=new JScrollPane(viewtable);

        Databaseconnector connect=new Databaseconnector();
        connect.connectToDb();
        Statement stmt=connect.createStatement();
        String query="SELECT * FROM `tbl_user`";
        try {
            ResultSet rs=stmt.executeQuery(query);
            System.out.println(rs);
            while(rs.next()){
                String username = rs.getString("usename");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String contact = rs.getString("contact");

                Object[] rowData = {username, password, email, address, contact};
                tablemodel.addRow(rowData);
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        backButton = new JButton("Back");
        backButton.setBounds(100, 200, 80, 30);
        backButton.addActionListener(this);
        add(backButton);


        add(scroll);
        setSize(400,400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==backButton) {
            Adminsection as=new Adminsection();
            as.setVisible(true);
            dispose();
        }
    }
    public static void main(String[] args) {
        Viewuser view=new Viewuser();
        view.setVisible(true);
    }
    
}
