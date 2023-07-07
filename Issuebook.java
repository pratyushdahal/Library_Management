package librarymanagement;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Issuebook extends JFrame implements ActionListener {
    JLabel bookname,pubname,quantity,studentname,studentid;
    JTextField booknamefield,pubnamefield,quantityfield,studentnamefield,studentidfield;
    JButton issuebtn,cancelbtn;
    Issuebook(){
        super("Library Management System");
        bookissue();
    }
    public void bookissue(){
        bookname=new JLabel("Book name:");
        booknamefield=new JTextField(25);
        pubname=new JLabel("publication:");
        pubnamefield=new JTextField(25);
        studentid=new JLabel("student id:");
        studentidfield=new JTextField(25);
        studentname=new JLabel("student name:");
        studentnamefield=new JTextField(25);
        quantity=new JLabel("Quantity");
        quantityfield=new JTextField(25);
        issuebtn=new JButton("Issue Book");
        cancelbtn=new JButton("Cancel");

        add(bookname);
        add(booknamefield);
        add(pubname);
        add(pubnamefield);
        add(studentid);
        add(studentidfield);
        add(studentname);
        add(studentnamefield);
        add(quantity);
        add(quantityfield);
        add(issuebtn);
        add(cancelbtn);

        issuebtn.addActionListener(this);
        cancelbtn.addActionListener(this);

        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource()==issuebtn) {
            String bname=booknamefield.getText();
            String publication=pubnamefield.getText();
            int studentid=Integer.parseInt(studentidfield.getText());
            String studentname=studentnamefield.getText();
            int quantity=0;
            try {
                Databaseconnector con=new Databaseconnector();
                con.connectToDb();
                Statement stmt=con.createStatement();
                String query="SELECT quantity FROM `tbl_addbook` where book='"+bname+"'";
                ResultSet rs=stmt.executeQuery(query);
                while (rs.next()) {
                    quantity = rs.getInt("quantity");
                }
                if (quantity<=0) {
                    JOptionPane.showMessageDialog(null,"book quantity finished");
                    this.setVisible(false);
                }
                else{
                    String query1="INSERT INTO `tbl_bookissue`(bname,publication,sid,sname,quantity) VALUES('"+bname+"','"+publication+"','"+studentid+"','"+studentname+"','"+quantity+"')";
                    String query2="UPDATE `tbl_addbook` set quantity=quantity-quantity WHERE book='"+bname+"'";
                    String query3="UPDATE `tbl_addbook` set issuebook=issuebook+1 WHERE book='"+bname+"'";
                    int a=stmt.executeUpdate(query1);
                    int aa=stmt.executeUpdate(query2);
                    int aaa=stmt.executeUpdate(query3);
                    if (a==1) {
                        JOptionPane.showMessageDialog(null, "carefully");
                        if (aa==1) {
                            if (aaa==1) {
                                JOptionPane.showMessageDialog(null,"your data updated successfully");
                            }
                            else{
                                JOptionPane.showMessageDialog( null,"fill all the details");
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog( null,"fill all the details");
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog( null,"fill all the details");
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
       }
       
       
       
       
       
       
       
        if(e.getSource()==cancelbtn){
            Librariansection ls=new Librariansection();
            ls.setVisible(true);
            dispose();
       }
    }
    public static void main(String[] args) {
        Issuebook issue=new Issuebook();
        issue.setVisible(true);
    }
}
