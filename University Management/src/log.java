import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

import static java.sql.DriverManager.*;

public class log extends JFrame implements ActionListener {
    JButton login , cancel;
    JTextField tfusername;
    JPasswordField tfpassword;
    log(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername = new JLabel("UserName");
        lblusername.setBounds(40,20,100,20);
        add(lblusername);

        tfusername = new JTextField();
        tfusername.setBounds(150,20,150,20);
        add(tfusername);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(40,70,100,20);
        add(lblpassword);

        tfpassword = new JPasswordField();
        tfpassword.setBounds(150,70,150,20);
        add(tfpassword);

        login = new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setFont(new Font("Tahoma",Font.BOLD,15));
        add(login);

        cancel = new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/Second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);

        setSize(600 , 300);
        setLocation(500,250);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==login){

            String username = tfusername.getText();
            String password = tfpassword.getText();
            try {

                classforName("Com.mysql.cj.jdbc.Driver");
                String url ="jdbc:mysql://localhost:3306/neet";
                String Uname = "shivam";
                String Upass = "123";
                Connection con = getConnection(url,Uname,Upass);
                String query = "select * from annu where username ='"+username+"' and password = '"+password+"'";
                Statement stmt = con.createStatement();
                ResultSet rs =stmt.executeQuery(query);

                if (rs.next()){
                    setVisible(false);
                    new Project();
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
//                    setVisible(false);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==cancel) {
            setVisible(false);
        }

    }

    private void classforName(String s) {
    }

    public static void main(String[] args) {

        new log();
    }
}
