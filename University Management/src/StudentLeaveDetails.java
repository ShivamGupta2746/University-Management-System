import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class StudentLeaveDetails extends JFrame implements ActionListener {
    Choice crollno;
    JTable table;
    JButton search , print , update , add , cancel;


    StudentLeaveDetails(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Search by Roll No");
        heading.setBounds(20,20,150,20);
        add(heading);

        crollno = new Choice();
        crollno.setBounds(180,20,150,20);
        add(crollno);

        try{

            classforName("Com.mysql.cj.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/neet";
            String Uname = "shivam";
            String Upass = "123";
            Connection con = getConnection(url,Uname,Upass);
            Statement stmt = con.createStatement();
            ResultSet rs =stmt.executeQuery("select * from student");
            while (rs.next()){
                crollno.add(rs.getString("rollno"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();

        try{

            classforName("Com.mysql.cj.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/neet";
            String Uname = "shivam";
            String Upass = "123";
            Connection con = getConnection(url,Uname,Upass);
            Statement stmt = con.createStatement();
            ResultSet rs =stmt.executeQuery("select * from studentleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e){
            e.printStackTrace();
        }
        JScrollPane jsb = new JScrollPane(table);
        jsb.setBounds(0,100,1000,600);
        add(jsb);

        search = new JButton("Search");
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        print = new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);


        cancel = new JButton("Cancel");
        cancel.setBounds(220,70,80,20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(1000,700);
        setLocation(300,100);
        setVisible(true);
    }

    private void classforName(String s) {
    }


    public static void main(String[] args) {
        new StudentLeaveDetails();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==search){
            String query = "select * from studentleave where rollno = '"+crollno.getSelectedItem()+"'";
            try {
                classforName("Com.mysql.cj.jdbc.Driver");
                String url ="jdbc:mysql://localhost:3306/neet";
                String Uname = "shivam";
                String Upass = "123";
                Connection con = getConnection(url,Uname,Upass);
                Statement stmt = con.createStatement();
                ResultSet rs =stmt.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                e.printStackTrace();
            }

        } else if (ae.getSource()==print) {
            try {
                table.print();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        else if (ae.getSource()==cancel){
            setVisible(false);

        }
    }
}
