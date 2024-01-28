import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project extends JFrame implements ActionListener {
    Project(){
        setSize(1540,850);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("img/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500,750,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);

        JMenuBar mb = new JMenuBar();

        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);

        JMenuItem facultyinfo = new JMenuItem("New faculty Information");
        facultyinfo.setBackground(Color.WHITE);
        facultyinfo.addActionListener(this);
        newInformation.add(facultyinfo);

        JMenuItem studentinfo = new JMenuItem("New Student Information");
        studentinfo.setBackground(Color.WHITE);
        studentinfo.addActionListener(this);
        newInformation.add(studentinfo);

        // This is the details in the projects

        JMenu details = new JMenu("View Details");
        details.setForeground(Color.RED);
        mb.add(details);

        JMenuItem facultydetails = new JMenuItem("View faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);

        JMenuItem studentdetails = new JMenuItem("View Student Details");
        studentdetails.setBackground(Color.WHITE);
        studentdetails.addActionListener(this);
        details.add(studentdetails);

        // This is the annoother deatails in projects    Leave

        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.blue);
        mb.add(leave);

        JMenuItem facultyleave = new JMenuItem("faculty Leave");
        facultyleave.setBackground(Color.WHITE);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);

        JMenuItem studentleave = new JMenuItem("Student Leave");
        studentleave.setBackground(Color.WHITE);
        studentleave.addActionListener(this);
        leave.add(studentleave);


        // This is the another leave details in the projects in java


        JMenu leavedetails = new JMenu("Leave Details");
        leavedetails.setForeground(Color.RED);
        mb.add(leavedetails);

        JMenuItem facultyleavedetails = new JMenuItem("faculty Leave Details");
        facultyleavedetails.setBackground(Color.WHITE);
        facultyleavedetails.addActionListener(this);
        leavedetails.add(facultyleavedetails);

        JMenuItem studentleavedetails = new JMenuItem("Student Leave Details");
        studentleavedetails.setBackground(Color.WHITE);
        studentleavedetails.addActionListener(this);
        leavedetails.add(studentleavedetails);

        // This is the another details in the projects

        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        mb.add(exam);

        JMenuItem examinationDetails = new JMenuItem("Examination Result");
        examinationDetails.setBackground(Color.WHITE);
        examinationDetails.addActionListener(this);
        exam.add(examinationDetails);

        JMenuItem entermarks = new JMenuItem("Enter Marks");
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        exam.add(entermarks);


        // This is the another details in the prooject

        JMenu updateinfo = new JMenu("Update Details");
        updateinfo.setForeground(Color.RED);
        mb.add(updateinfo);

        JMenuItem updatefacultyinfo = new JMenuItem("Update faculty Details");
        updatefacultyinfo.setBackground(Color.WHITE);
        updatefacultyinfo.addActionListener(this);
        updateinfo.add(updatefacultyinfo);

        JMenuItem updatesttudentinfo = new JMenuItem("Update Students Details");
        updatesttudentinfo.setBackground(Color.WHITE);
        updatesttudentinfo.addActionListener(this);
        updateinfo.add(updatesttudentinfo);


        // This is the another details in the prooject

        JMenu fee = new JMenu("Fee Details");
        fee.setForeground(Color.BLUE);
        mb.add(fee);

        JMenuItem feesttruucturre = new JMenuItem("Fee Structure");
        feesttruucturre.setBackground(Color.WHITE);
        feesttruucturre.addActionListener(this);
        fee.add(feesttruucturre);

        JMenuItem feeform = new JMenuItem("Students Fee Form");
        feeform.setBackground(Color.WHITE);
        feeform.addActionListener(this);
        fee.add(feeform);


        // This is the another details in the prooject

        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.RED);
        mb.add(utility);

        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad);

        JMenuItem calc = new JMenuItem("Calculator");
        calc.setBackground(Color.WHITE);
        calc.addActionListener(this);
        utility.add(calc);

     // This is the about portion

        JMenu about = new JMenu("About");
        about.setForeground(Color.BLUE);
        mb.add(about);

        JMenuItem ab = new JMenuItem("About");
        ab.setBackground(Color.WHITE);
        ab.addActionListener(this);
        about.add(ab);
        // This is the another details in the prooject

        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.red);
        mb.add(exit);

        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        exit.add(ex);



        setJMenuBar(mb);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if (msg.equals("Exit")){
            setVisible(false);
        } else if (msg.equals("Calculator")) {
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception e){

            }
        } else if (msg.equals("Notepad")) {
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception e){

            }
        } else if (msg.equals("New faculty Information")) {
            new AddTeacher();
        } else if (msg.equals("New Student Information")) {
            new AddStudent();
        }

        else if (msg.equals("View faculty Details")) {
            new TeacherDetails();
        }

        else if (msg.equals("View Student Details")) {
            new StudentDetails();
        }

        else if (msg.equals("faculty Leave")) {
            new TeacherLeave();
        }

        else if (msg.equals("Student Leave")) {
            new StudentLeave();
        }

        else if (msg.equals("faculty Leave Details")) {
            new TeacherLeaveDetails();
        }

        else if (msg.equals("Student Leave Details")) {
            new StudentLeaveDetails();
        }

        else if (msg.equals("Update faculty Details")) {
            new UpdateTeacher();
        }

        else if (msg.equals("Update Students Details")) {
            new UpdateStudent();
        }

        else if (msg.equals("Enter Marks")) {
            new EnterMarks();
        }

        else if (msg.equals("Examination Result")) {
            new ExaminationDetails();
        }

        else if (msg.equals("Fee Structure")) {
            new FeeStructure();
        }

        else if (msg.equals("About")) {
            new About();
        }

        else if (msg.equals("Students Fee Form")) {
            new StudentFeeForm();
        }




    }

    public static void main(String[] args) {
        new Project();
    }
}
