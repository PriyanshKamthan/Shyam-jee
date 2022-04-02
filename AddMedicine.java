import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddMedicine implements ActionListener
{
    JFrame f;
    JButton b;
    JLabel l,l1,l2,l3;
    JTextField t1,t2,t3;
    JPanel p1,p2;
    AddMedicine()
    {
        f=new JFrame("Add Medicine Page");
        
        p1=new JPanel();
        l=new JLabel("Add Medicine");
        l.setFont(new Font("Candara",1,40));
        p1.add(l);


        p2=new JPanel();
        p2.setLayout(null);
        l1=new JLabel("Enter Medicine Name:");
        l2=new JLabel("Enter Medicine Price:");
        l3=new JLabel("Enter numbers:");

        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        l1.setFont(new Font("Candara",0,18));
        l2.setFont(new Font("Candara",0,18));
        l3.setFont(new Font("Candara",0,18));
        t1.setFont(new Font("Candara",0,18));
        t2.setFont(new Font("Candara",0,18));
        t3.setFont(new Font("Candara",0,18));
        
        l1.setBounds(70,60,180,30);
        l2.setBounds(70,100,180,30);
        l3.setBounds(70,140,180,30);
        t1.setBounds(250,60,180,30);
        t2.setBounds(250,100,180,30);
        t3.setBounds(250,140,180,30);
        p2.add(l1);
        p2.add(l2);
        p2.add(l3);
        p2.add(t1);
        p2.add(t2);
        p2.add(t3);

        b=new JButton("Save Medicine");
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
            if(t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals(""))
            throw new ArithmeticException("Please fill all the fields");
            String name=t1.getText();
            float price=Float.parseFloat(t2.getText());
            int qty=Integer.parseInt(t3.getText());
            if(new Handler().addMedicine(name,price,qty))
            {
                t1.setText("");
                t2.setText("");
                t3.setText("");
                JOptionPane.showMessageDialog(f,"Data saved");
            }
            else JOptionPane.showMessageDialog(f,"Something went wrong");
            f.dispose();
        }
        catch(Exception e1)
        {JOptionPane.showMessageDialog(f,e1.getMessage());}
    } 
}
