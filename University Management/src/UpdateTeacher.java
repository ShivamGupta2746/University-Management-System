import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import static java.sql.DriverManager.getConnection;

public class UpdateTeacher extends JFrame implements ActionListener {
    JTextField tfcourse ,tfaddress , tfphone , tfemail,tfbranch ;
   // JLabel lblroll;
       JLabel labelEmpId;
    JButton submit , cancel;
    Choice cEmpId;
    UpdateTeacher(){
        setSize(900,650);
        setLocation(350,50);
        setLayout(null);

        JLabel heading = new JLabel("Update Teacher Details");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("Tahoma",Font.ITALIC,35));
        add(heading);

        JLabel lblrollnumber = new JLabel("Select Employee Id");
        lblrollnumber.setBounds(50,100,200,20);
        lblrollnumber.setFont(new Font("serif",Font.PLAIN,20));
        add(lblrollnumber);

        cEmpId = new Choice();
        cEmpId.setBounds(250,100,200,20);
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


        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);

        JLabel labelname = new JLabel();
        labelname.setBounds(200,150,150,30);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelname);

        JLabel lblfname = new JLabel("Father Name");
        lblfname.setBounds(400,150,200,30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);

        JLabel labelfname = new JLabel();
        labelfname.setBounds(600,150,150,30);
        labelfname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelfname);

        JLabel lblrollno = new JLabel("Employee Id :");
        lblrollno.setBounds(50 ,200,200,30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);

//        lblroll = new JLabel();
//        lblroll.setBounds(200,200,200,30);
//        lblroll.setFont(new Font("Tahoma",Font.PLAIN,18));
//        add(lblroll);

        labelEmpId = new JLabel();
        labelEmpId.setBounds(200,200,200,30);
        labelEmpId.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelEmpId);

        JLabel lbldob = new JLabel("Date Of Birth");
        lbldob.setBounds(400 ,200,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);

        JLabel labeldob = new JLabel();
        labeldob.setBounds(600,200,150,30);
        labeldob.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labeldob);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50 ,250,200,30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        tfaddress.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfaddress);


        JLabel lblphone = new JLabel("Phone No");
        lblphone.setBounds(400 ,250,200,30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        tfphone.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfphone);


        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50 ,300,200,30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        tfemail.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfemail);


        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(400 ,300,200,30);
        lblx.setFont(new Font("serif",Font.BOLD,20));
        add(lblx);

        JLabel labelx = new JLabel();
        labelx.setBounds(600,300,150,30);
        labelx.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelx);

        JLabel lblxii = new JLabel("Class XII (%)");
        lblxii.setBounds(50 ,350,200,30);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);

        JLabel labelxii = new JLabel();
        labelxii.setBounds(200,350,150,30);
        labelxii.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelxii);

        JLabel lbladhar = new JLabel("Aadhar Number");
        lbladhar.setBounds(400 ,350,200,30);
        lbladhar.setFont(new Font("serif",Font.BOLD,20));
        add(lbladhar);

        JLabel labeladhaar = new JLabel();
        labeladhaar.setBounds(600,350,150,30);
        labeladhaar.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labeladhaar);

        JLabel lblcourse = new JLabel("Education");
        lblcourse.setBounds(50 ,400,200,30);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);


        tfcourse = new JTextField();
        tfcourse.setBounds(200,400,150,30);
        tfcourse.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfcourse);

        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(400 ,400,200,30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);


        tfbranch = new JTextField();
        tfbranch.setBounds(600,400,150,30);
        tfbranch.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfbranch);


        try {
            classforName("Com.mysql.cj.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/neet";
            String Uname = "shivam";
            String Upass = "123";
            Connection con = getConnection(url,Uname,Upass);
            Statement stmt = con.createStatement();
            String query = "select * from teacher where empId='"+cEmpId.getSelectedItem()+"'";
            ResultSet rs =stmt.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                labelx.setText(rs.getString("class_x"));
                labelxii.setText(rs.getString("class_xii"));
                labeladhaar.setText(rs.getString("aadhar"));
                //lblroll.setText(rs.getString("empId"));
                labelEmpId.setText(rs.getString("empId"));
                tfcourse.setText(rs.getString("education"));
                tfbranch.setText(rs.getString("department"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        cEmpId.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {

                try {
                    classforName("Com.mysql.cj.jdbc.Driver");
                    String url ="jdbc:mysql://localhost:3306/neet";
                    String Uname = "shivam";
                    String Upass = "123";
                    Connection con = getConnection(url,Uname,Upass);
                    Statement stmt = con.createStatement();
                    String query = "select * from teacher where empId='"+cEmpId.getSelectedItem()+"'";
                    ResultSet rs =stmt.executeQuery(query);
                    while(rs.next()){
                        labelname.setText(rs.getString("name"));
                        labelfname.setText(rs.getString("fname"));
                        labeldob.setText(rs.getString("dob"));
                        tfaddress.setText(rs.getString("address"));
                        tfphone.setText(rs.getString("phone"));
                        tfemail.setText(rs.getString("email"));
                        labelx.setText(rs.getString("class_x"));
                        labelxii.setText(rs.getString("class_xii"));
                        labeladhaar.setText(rs.getString("aadhar"));
                       // lblroll.setText(rs.getString("empId"));
                        labelEmpId.setText(rs.getString("empId"));
                        tfcourse.setText(rs.getString("education"));
                        tfbranch.setText(rs.getString("department"));
                    }
                }catch (Exception ee){
                    ee.printStackTrace();
                }
            }
        });

        submit = new JButton("Update");
        submit.setBounds(250,500,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,500,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==submit){
           // String empId = lblroll.getText();
            String empid = labelEmpId.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String course =tfcourse.getText();
            String branch = tfbranch.getText();


            try {

                classforName("Com.mysql.cj.jdbc.Driver");
                String url ="jdbc:mysql://localhost:3306/neet";
                String Uname = "shivam";
                String Upass = "123";
                Connection con = getConnection(url,Uname,Upass);
                String query1 = "update teacher set address='"+address+"' , phone='"+phone+"' , email='"+email+"' , education='"+course+"', department='"+branch+"' where empId='"+empid+"'";
                Statement stmt = con.createStatement();
                stmt.executeUpdate(query1);
                setVisible(false);
                JOptionPane.showMessageDialog(null,"Teacher Details updated Successfully");



            }catch (Exception e){
                e.printStackTrace();
            }

        }
        else {
            setVisible(false);
        }

    }
    private void classforName(String s) {
    }
    public static void main(String[] args) {
        UpdateTeacher updateTeacher = new UpdateTeacher();
    }
}
