import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Receptionist implements ActionListener
{
    JPanel p1,p2;
    JLabel heading;
    JButton show;
    JButton punch_attendance,add_patient,show_patient;
    JFrame f;
    Member m;
    Receptionist(Member m)
    {
        this.m=m;
        f=new JFrame("Receptionist page");

        p1=new JPanel();
        heading=new JLabel("Welcome "+m.name);
        heading.setBackground(Color.WHITE);
        heading.setFont(new Font("Candara",1,40));
        p1.add(heading);

        p2=new JPanel();
        p2.setLayout(null);
        punch_attendance=new JButton("Punch my attendance");
        add_patient=new JButton("Add new Patient");
        show_patient=new JButton("Show Patients");
        punch_attendance.setFont(new Font("Candara",0,18));
        add_patient.setFont(new Font("Candara",0,18));
        show_patient.setFont(new Font("Candara",0,18));
        punch_attendance.setBounds(150,20,200,40);
        add_patient.setBounds(150,70,200,40);
        show_patient.setBounds(150,120,200,40);
        p2.add(punch_attendance);
        p2.add(add_patient);
        p2.add(show_patient);
        
        show=new JButton("Show My Info");
        show.setFont(new Font("Candara",1,20));
        show.addActionListener(this);

        punch_attendance.addActionListener(this);
        add_patient.addActionListener(this);
        show_patient.addActionListener(this);

        f.add(p1,BorderLayout.NORTH);
        f.add(p2,BorderLayout.CENTER);
        f.add(show,BorderLayout.SOUTH);
        f.setSize(500,600);
        f.setVisible(true);
        f.setResizable(false);
        f.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){f.dispose();}});
    }

    public void actionPerformed(ActionEvent e)
    {
        JButton bt=(JButton)e.getSource();
        if(bt==show)
        {
            new DisplayInfo(m);
        }
        if(bt==punch_attendance)
        {
            new AddAttendance(m);
        }
        if(bt==add_patient)
        {
            new AddPatient();
        }
        if(bt==show_patient)
        {
            new ShowPatient();
        }
    }  
}