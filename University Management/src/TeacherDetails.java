import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class TeacherDetails extends JFrame implements ActionListener {
    Choice cEmpId;
    JTable table;
    JButton search , print , update , add , cancel;


    TeacherDetails(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Search by Employee ID");
        heading.setBounds(20,20,150,20);
        add(heading);

        cEmpId = new Choice();
        cEmpId.setBounds(180,20,150,20);
        add(cEmpId);

        try{

            classforName("Com.mysql.cj.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/neet";
            String Uname = "shivam";
            String Upass = "123";
            Connection con = getConnection(url,Uname,Upass);
            Statement stmt = con.createStatement();
            ResultSet rs =stmt.executeQuery("select * from teacher");
            while (rs.next()){
                cEmpId.add(rs.getString("empId"));
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
            ResultSet rs =stmt.executeQuery("select * from teacher");
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

        add = new JButton("Add");
        add.setBounds(220,70,80,20);
        add.addActionListener(this);
        add(add);


        update = new JButton("Update");
        update.setBounds(320,70,80,20);
        update.addActionListener(this);
        add(update);

        cancel = new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
        cancel.addActionListener(this);
        add(cancel);

        setSize(1000,700);
        setLocation(300,100);
        setVisible(true);
    }

    private void classforName(String s) {
    }


    public static void main(String[] args) {
        new TeacherDetails();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==search){
            String query = "select * from teacher where empId = '"+cEmpId.getSelectedItem()+"'";
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

        } else if (ae.getSource()==add) {
            setVisible(false);
            new AddTeacher();

        } else if (ae.getSource()==update) {
            setVisible(false);
            new UpdateTeacher();

        }else if (ae.getSource()==cancel){
            setVisible(false);

        }
    }
}
