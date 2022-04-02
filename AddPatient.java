import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddPatient implements ActionListener
{
    JFrame f;
    JButton b;
    JLabel l,l1,l2,l3,l4,l6,l7;
    JTextField t1,t2,t3,t4,t6,t7;
    JPanel p1,p2;
    AddPatient()
    {
        f=new JFrame("Add Patient Page");
        
        p1=new JPanel();
        l=new JLabel("Add Patient");
        l.setFont(new Font("Candara",1,40));
        p1.add(l);

        p2=new JPanel();
        p2.setLayout(null);
        l1=new JLabel("Patient ID:");
        l2=new JLabel("Patient Name:");
        l3=new JLabel("Patient Phone1:");
        l4=new JLabel("Patient Phone2:*");
        l6=new JLabel("Patient File Number:");
        l7=new JLabel("Patient Book Number:");

        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t6=new JTextField();
        t7=new JTextField();

        l1.setFont(new Font("Candara",0,18));
        l2.setFont(new Font("Candara",0,18));
        l3.setFont(new Font("Candara",0,18));
        l4.setFont(new Font("Candara",0,18));
        l6.setFont(new Font("Candara",0,18));
        l7.setFont(new Font("Candara",0,18));
        t1.setFont(new Font("Candara",0,18));
        t2.setFont(new Font("Candara",0,18));
        t3.setFont(new Font("Candara",0,18));
        t4.setFont(new Font("Candara",0,18));
        t6.setFont(new Font("Candara",0,18));
        t7.setFont(new Font("Candara",0,18));
        
        l1.setBounds(50,60,175,30);
        l2.setBounds(50,100,175,30);
        l3.setBounds(50,140,175,30);
        l4.setBounds(50,180,175,30);
        l6.setBounds(50,290,175,30);
        l7.setBounds(50,330,175,30);
        t1.setBounds(225,60,200,30);
        t2.setBounds(225,100,200,30);
        t3.setBounds(225,140,200,30);
        t4.setBounds(225,180,200,30);
        t6.setBounds(225,290,200,30);
        t7.setBounds(225,330,200,30);
        p2.add(l1);
        p2.add(l2);
        p2.add(l3);
        p2.add(l4);
        p2.add(l6);
        p2.add(l7);
        p2.add(t1);
        p2.add(t2);
        p2.add(t3);
        p2.add(t4);
        p2.add(t6);
        p2.add(t7);

        b=new JButton("Save Patients");
        b.setFont(new Font("Candara",1,20));
        b.addActionListener(this);

        f.add(p1,BorderLayout.NORTH);
        f.add(p2,BorderLayout.CENTER);
        f.add(b,BorderLayout.SOUTH);
        f.setVisible(true);
        f.setSize(500,600);
        f.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){f.dispose();}});
    }
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            if(t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("") ||t6.getText().equals("") ||t7.getText().equals(""))
            throw new ArithmeticException("Please fill all the fields");
            int id=Integer.parseInt(t1.getText());
            String name=t2.getText();
            String phone1=t3.getText();
            String phone2=t4.getText();
            int num1=Integer.parseInt(t6.getText());
            int num2=Integer.parseInt(t7.getText());
            if(new Handler().addPatient(id,name,phone1,phone2,num1,num2))
            {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t6.setText("");
                t7.setText("");
                JOptionPane.showMessageDialog(f,"Data saved");
            }
            else JOptionPane.showMessageDialog(f,"Something went wrong");
            f.dispose();
        }
        catch(Exception e1)
        {JOptionPane.showMessageDialog(f,e1.getMessage());}
    }
}