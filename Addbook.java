package librarymanagement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;

public class Addbook extends JFrame implements ActionListener {
    JLabel book,author,publication,quantity;
    JButton addbtn,backbtn;
    JTextField bookField,authorField,pubfield,quantityField;

    Addbook(){
        super("Library Management System");
        addbook();
    }

    public void addbook(){
        book=new JLabel("Book name:");
        bookField=new JTextField(25);
        author=new JLabel("Author name:");
        authorField=new JTextField(25);
        publication=new JLabel("Publication name:");
        pubfield=new JTextField(25);
        quantity=new JLabel("Quantity:");
        quantityField=new JTextField(25);
        addbtn=new JButton("Add Book");
        backbtn=new JButton("Back");

        add(book);
        add(bookField);
        add(author);
        add(authorField);
        add(publication);
        add(pubfield);
        add(quantity);
        add(quantityField);
        add(addbtn);
        add(backbtn);

        addbtn.addActionListener(this);
        backbtn.addActionListener(this);
        
        setSize(400, 400);
        setLayout(new FlowLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==addbtn) {
            String book=bookField.getText();
            String author=authorField.getText();
            String publication=pubfield.getText();
            String quantity=quantityField.getText();

            if (book.isEmpty()|| author.isEmpty()|| publication.isEmpty()||quantity.isEmpty()) {
                JOptionPane.showMessageDialog(this,"enter all empty fields");
            }
        try {
            Databaseconnector conn=new Databaseconnector();
            conn.connectToDb();

            Statement stm=conn.createStatement();
            String query="INSERT into `tbl_addbook` (`book`,`author`,`publication`,`quantity`) VALUES ('"+book+"','"+author+"','"+publication+"','"+quantity+"')";
            System.out.println(query);
            stm.executeUpdate(query);

        
            JOptionPane.showMessageDialog(this,"book added successfully");
            Librariansection ls=new Librariansection();
            ls.setVisible(true);
            dispose();     
            }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        }
        if (e.getSource()==backbtn) {
            Librariansection lbs=new Librariansection();
            lbs.setVisible(true);
            dispose();
        }
        
    }

    public static void main(String[] args) {
        Addbook add=new Addbook();
        add.setVisible(true);
    }
    
}
