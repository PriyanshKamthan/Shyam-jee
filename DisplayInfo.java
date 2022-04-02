import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DisplayInfo implements ActionListener
{
    JPanel p1,p2;
    JLabel heading,l1,l2,l3,l4,l5;
    JLabel loginID,name,phone,pswd,type;
    JButton back;
    JFrame f;
    Member m;
    DisplayInfo(Member m)
    {
        f=new JFrame("Your Information");

        p1=new JPanel();
        heading=new JLabel(m.name+"'s information");
        heading.setBackground(Color.WHITE);
        heading.setFont(new Font("Candara",1,40));
        p1.add(heading);

        p2=new JPanel();
        p2.setLayout(null);
        l1=new JLabel("LoginID:");
        l2=new JLabel("Name:");
        l3=new JLabel("Phone:");
        l4=new JLabel("Password:");
        l5=new JLabel("Type:");
        loginID=new JLabel(""+m.id);
        name=new JLabel(m.name);
        phone=new JLabel(m.phone);
        pswd=new JLabel(m.pswd);
        if(m.type==1)
        type=new JLabel("Admin");
        else if(m.type==2)
        type=new JLabel("Manager");
        else if(m.type==3)
        type=new JLabel("Pharmacy");
        else if(m.type==4)
        type=new JLabel("Receptionist");
        else if(m.type==5)
        type=new JLabel("Dilevery");
        l1.setFont(new Font("Candara",1,20));
        l2.setFont(new Font("Candara",1,20));
        l3.setFont(new Font("Candara",1,20));
        l4.setFont(new Font("Candara",1,20));
        l5.setFont(new Font("Candara",1,20));
        loginID.setFont(new Font("Candara",0,20));
        name.setFont(new Font("Candara",0,20));
        phone.setFont(new Font("Candara",0,20));
        pswd.setFont(new Font("Candara",0,20));
        type.setFont(new Font("Candara",0,20));   
        l1.setBounds(100,60,145,30);
        l2.setBounds(100,100,145,30);
        l3.setBounds(100,140,145,30);
        l4.setBounds(100,180,145,30);
        l5.setBounds(100,220,145,30);
        loginID.setBounds(255,60,145,30);
        name.setBounds(255,100,145,30);
        phone.setBounds(255,140,145,30);
        pswd.setBounds(255,180,145,30);
        type.setBounds(255,220,145,30);
        p2.add(l1);
        p2.add(l2);
        p2.add(l3);
        p2.add(l4);
        p2.add(l5);
        p2.add(loginID);
        p2.add(name);
        p2.add(phone);
        p2.add(pswd);
        p2.add(type);

        back=new JButton("Back");
        back.setFont(new Font("Candara",1,20));
        back.addActionListener(this);

        f.add(p1,BorderLayout.NORTH);
        f.add(p2,BorderLayout.CENTER);
        f.add(back,BorderLayout.SOUTH);
        f.setSize(500,600);
        f.setVisible(true);
        f.setResizable(false);
        f.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){f.dispose();}});
    }
    public void actionPerformed(ActionEvent e)
    {
        JButton bt=(JButton)e.getSource();
        if(bt==back){f.dispose();}
    }
}
