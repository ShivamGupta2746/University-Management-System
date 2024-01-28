import com.mysql.cj.util.StringInspector;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.sql.DriverManager.getConnection;

public class TeacherLeave extends JFrame implements ActionListener {
    Choice cEmpId,ctime;
    JDateChooser dcdate;
    JButton submit,cancel;
    TeacherLeave(){
        setSize(500,550);
        setLocation(550,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Apply Leave (Students)");
        heading.setBounds(40,50,300,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);


        JLabel lblrollno = new JLabel("Search by Employee Id");
        lblrollno.setBounds(60,100,200,20);
        lblrollno.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblrollno);

        cEmpId = new Choice();
        cEmpId.setBounds(60,130,200,20);
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

        JLabel lbldate = new JLabel("Take The Date ");
        lbldate.setBounds(60,180,200,20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbldate);

        dcdate = new JDateChooser();
        dcdate.setBounds(60,210,200,25);
        add(dcdate);

        JLabel lbltime = new JLabel("Time Duration");
        lbltime.setBounds(60,260,200,20);
        lbltime.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbltime);

        ctime = new Choice();
        ctime.setBounds(60,290,200,20);
        ctime.add("Full Day");
        ctime.add("Half Day");
        add(ctime);

        submit = new JButton("Submit");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200,350,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);

        setVisible(true);

    }
    private void classforName(String s) {
    }
    public static void main(String[] args) {
        new TeacherLeave();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==submit){

            String empId = cEmpId.getSelectedItem();
            String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
            String duration = ctime.getSelectedItem();

            String query = "insert into teacherleave values('"+empId+"', '"+date+"', '"+duration+"')";
            try {
                classforName("Com.mysql.cj.jdbc.Driver");
                String url ="jdbc:mysql://localhost:3306/neet";
                String Uname = "shivam";
                String Upass = "123";
                Connection con = getConnection(url,Uname,Upass);
                //String query1 = "insert into student values('"+name+"' , '"+fname+"' , '"+rollno+"' , '"+dob+"', '"+address+"' , '"+phone+"' , '"+email+"' , '"+x+"' , '"+xii+"' ,'"+adhar+"' , '"+course+"', '"+branch+"')";
                Statement stmt = con.createStatement();
                stmt.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Leave Confirmed");
                setVisible(false);

            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
        }

    }
}
