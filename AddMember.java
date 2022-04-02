import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddMember implements ActionListener
{
    JFrame f;
    JButton b;
    JLabel l,l1,l2,l3,l4;
    JTextField t1,t2,t3;
    JComboBox<String> t4;
    JPanel p1,p2;
    AddMember()
    {
        f=new JFrame("Add Member Page");
        
        p1=new JPanel();
        l=new JLabel("Add Member");
        l.setFont(new Font("Candara",1,40));
        p1.add(l);

        String lis[]={"","Admin","Manager","Pharmacy","Receptionist"};

        p2=new JPanel();
        p2.setLayout(null);
        l1=new JLabel("Enter Name:");
        l2=new JLabel("Enter Phone:");
        l3=new JLabel("Enter Password:");
        l4=new JLabel("Account Type:");

        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JComboBox<>(lis);
        l1.setFont(new Font("Candara",0,18));
        l2.setFont(new Font("Candara",0,18));
        l3.setFont(new Font("Candara",0,18));
        l4.setFont(new Font("Candara",0,18));
        t1.setFont(new Font("Candara",0,18));
        t2.setFont(new Font("Candara",0,18));
        t3.setFont(new Font("Candara",0,18));
        t4.setFont(new Font("Candara",0,18));
        
        l1.setBounds(100,60,150,30);
        l2.setBounds(100,100,150,30);
        l3.setBounds(100,140,150,30);
        l4.setBounds(100,180,150,30);
        t1.setBounds(250,60,150,30);
        t2.setBounds(250,100,150,30);
        t3.setBounds(250,140,150,30);
        t4.setBounds(250,180,150,30);
        p2.add(l1);
        p2.add(l2);
        p2.add(l3);
        p2.add(l4);
        p2.add(t1);
        p2.add(t2);
        p2.add(t3);
        p2.add(t4);

        b=new JButton("Save Details");
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
            if(t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("") ||t4.getSelectedItem().equals(""))
            throw new ArithmeticException("Please fill all the fields");
            String name=t1.getText();
            String phone=t2.getText();
            String pswd=t3.getText();
            int type=t4.getSelectedIndex();
            if(new Handler().addMember(name,phone,pswd,type))
            {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setSelectedIndex(0);
                JOptionPane.showMessageDialog(f,"Data saved");
            }
            else JOptionPane.showMessageDialog(f,"Something went wrong");
            f.dispose();
        }
        catch(Exception e1)
        {JOptionPane.showMessageDialog(f,e1.getMessage());}
    } 
}
