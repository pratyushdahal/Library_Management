package librarymanagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;

public class Viewbook extends JFrame implements ActionListener {
    JTable viewbook;
    JScrollPane viewpane;
    JButton backbtn;

    Viewbook(){
        super("Library Management System");
        viewbook();
    }

    public void viewbook(){
        String [] columnname={"Book","Author","Publication","Quantity"};
        DefaultTableModel model=new DefaultTableModel(columnname,0);
        viewbook=new JTable(model);
        viewpane=new JScrollPane(viewbook);

        Databaseconnector connect=new Databaseconnector();
        connect.connectToDb();
        Statement stm=connect.createStatement();
        String query="SELECT * FROM `tbl_addbook`";
        try {   
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
                String Book=rs.getString("book");
                String author=rs.getString("author");
                String publication=rs.getString("publication");
                String quantity=rs.getString("quantity");

                Object[]rowdata={Book,author,publication,quantity};
                model.addRow(rowdata);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        backbtn=new JButton("Back");
        backbtn.setBounds(100,200,80,30);
        add(backbtn);
        add(viewpane);

        backbtn.addActionListener(this);
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==backbtn) {
            Librariansection librarysection=new Librariansection();
            librarysection.setVisible(true);
            dispose();
        }

    }
    public static void main(String[] args) {
        Viewbook view=new Viewbook();
        view.setVisible(true);
    }
}
