import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Admin implements ActionListener
{
    JPanel p1,p2;
    JLabel heading;
    JButton show;
    JButton add_mem,show_mem,show_attendance;
    JFrame f;
    Member m;
    Admin(Member m)
    {
        this.m=m;
        f=new JFrame("Admin page");

        p1=new JPanel();
        heading=new JLabel("Welcome "+m.name);
        heading.setBackground(Color.WHITE);
        heading.setFont(new Font("Candara",1,40));
        p1.add(heading);

        p2=new JPanel();
        p2.setLayout(null);
        add_mem=new JButton("Add member");
        show_mem=new JButton("Show all members");
        show_attendance=new JButton("Show Attendance");
        add_mem.setFont(new Font("Candara",0,18));
        show_mem.setFont(new Font("Candara",0,18));
        show_attendance.setFont(new Font("Candara",0,18));
        add_mem.setBounds(150,20,200,40);
        show_mem.setBounds(150,70,200,40);
        show_attendance.setBounds(150,120,200,40);
        p2.add(add_mem);
        p2.add(show_mem);
        p2.add(show_attendance);

        add_mem.addActionListener(this);
        show_mem.addActionListener(this);
        show_attendance.addActionListener(this);

        show=new JButton("Show My Info");
        show.setFont(new Font("Candara",1,20));
        show.addActionListener(this);

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
        if(bt==add_mem)
        {
            new AddMember();
        }
        if(bt==show_mem)
        {
            new ShowMember();
        }
        if(bt==show_attendance)
        {
            new ShowAttendance();
        }
    }    
}
