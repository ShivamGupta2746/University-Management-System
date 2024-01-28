import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class FeeStructure extends JFrame {
    FeeStructure(){
        setSize(1000,700);
        setLocation(250,50);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(50,10,400,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        add(heading);

        JTable table =  new JTable();

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,60,1000,700);
        add(jsp);

        try{
            classforName("Com.mysql.cj.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/neet";
            String Uname = "shivam";
            String Upass = "123";
            Connection con = getConnection(url,Uname,Upass);
            Statement stmt = con.createStatement();
            ResultSet rs =stmt.executeQuery("select * from fee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }

        setVisible(true);

    }

    private void classforName(String s) {
    }
    public static void main(String[] args) {
        new FeeStructure();
    }
}
