import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import static java.sql.DriverManager.getConnection;

public class AddTeacher extends JFrame implements ActionListener {
    JTextField tfname , tffname,tfaddress , tfphone , tfemail , tfx , tfxii , tfadhar;
    JLabel lblempId;
    JDateChooser dcdob;
    JComboBox cbcourse , cbbranch;
    JButton submit , cancel;
    Random ran = new Random();
    long first4= Math.abs(ran.nextLong() % 9000L)+100L;
    AddTeacher(){
        setSize(900,700);
        setLocation(350,50);
        setLayout(null);

        JLabel heading = new JLabel("New Teacher Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);

        JLabel lblfname = new JLabel("Father Name");
        lblfname.setBounds(400,150,200,30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);

        JLabel lblelempid = new JLabel("Employee Id :");
        lblelempid.setBounds(50 ,200,200,30);
        lblelempid.setFont(new Font("serif",Font.BOLD,20));
        add(lblelempid);

        lblempId = new JLabel("101"+first4);
        lblempId.setBounds(200,200,200,30);
        lblempId.setFont(new Font("serif",Font.BOLD,20));
        add(lblempId);

        JLabel lbldob = new JLabel("Date Of Birth");
        lbldob.setBounds(400 ,200,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(600,200,150,30);
        add(dcdob);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50 ,250,200,30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);


        JLabel lblphone = new JLabel("Phone No");
        lblphone.setBounds(400 ,250,200,30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        add(tfphone);


        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50 ,300,200,30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);


        JLabel lblx = new JLabel("Class X (%)");
        lblx.setBounds(400 ,300,200,30);
        lblx.setFont(new Font("serif",Font.BOLD,20));
        add(lblx);

        tfx = new JTextField();
        tfx.setBounds(600,300,150,30);
        add(tfx);

        JLabel lblxii = new JLabel("Class XII (%)");
        lblxii.setBounds(50 ,350,200,30);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);

        tfxii = new JTextField();
        tfxii.setBounds(200,350,150,30);
        add(tfxii);

        JLabel lbladhar = new JLabel("Aadhar Number");
        lbladhar.setBounds(400 ,350,200,30);
        lbladhar.setFont(new Font("serif",Font.BOLD,20));
        add(lbladhar);

        tfadhar = new JTextField();
        tfadhar.setBounds(600,350,150,30);
        add(tfadhar);

        JLabel lblcourse = new JLabel("Qualification");
        lblcourse.setBounds(50 ,400,200,30);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);


        String course[] = {"B.Tech","M.Tech","BCA","MCA","BBA","Bsc","Msc","MBA","M.Com","MA","BA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200,400,150,30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(400 ,400,200,30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);


        String branch[] = {"Computer Science","Mechenical","Electrical","IT","Civil"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(600,400,150,30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);


        submit = new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==submit){
            String name = tfname.getText();
            String fname = tffname.getText();
            String empId = lblempId.getText();
            String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            String x = tfx.getText();
            String xii = tfxii.getText();
            String adhar = tfadhar.getText();
            String education = (String) cbcourse.getSelectedItem();
            String department = (String) cbbranch.getSelectedItem();


            try {

                classforName("Com.mysql.cj.jdbc.Driver");
                String url ="jdbc:mysql://localhost:3306/neet";
                String Uname = "shivam";
                String Upass = "123";
                Connection con = getConnection(url,Uname,Upass);
                String query1 = "insert into teacher values('"+name+"' , '"+fname+"' , '"+empId+"' , '"+dob+"', '"+address+"' , '"+phone+"' , '"+email+"' , '"+x+"' , '"+xii+"' ,'"+adhar+"' , '"+education+"', '"+department+"')";
                Statement stmt = con.createStatement();
                stmt.executeUpdate(query1);
                setVisible(false);
                JOptionPane.showMessageDialog(null,"Teachers Details inserted Successfully");



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
        new AddTeacher();
    }
}
