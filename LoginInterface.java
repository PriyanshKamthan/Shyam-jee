import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LoginInterface implements ActionListener
{
    JPanel p1,p2,p3;
    JLabel heading,l1,l2,l3;
    JTextField loginID;
    JPasswordField pswd;
    JComboBox<String> type;
    JButton exit,login;
    JFrame f;
    static Member mem;
    LoginInterface()
    {
        f=new JFrame("Login Interface");

        p1=new JPanel();
        heading=new JLabel("Shyam Jee Enterprises");
        heading.setBackground(Color.WHITE);
        heading.setFont(new Font("Candara",1,40));
        p1.add(heading);

        String lis[]={"","Admin","Manager","Pharmacy","Receptionist"};
        
        p2=new JPanel();
        p2.setLayout(null);
        l1=new JLabel("Enter LoginID:");
        l2=new JLabel("Enter Password:");
        l3=new JLabel("Account type:");
        loginID=new JTextField();
        pswd=new JPasswordField();
        type=new JComboBox<>(lis);
        l1.setFont(new Font("Candara",1,20));
        l2.setFont(new Font("Candara",1,20));
        l3.setFont(new Font("Candara",1,20));
        loginID.setFont(new Font("Candara",0,20));
        pswd.setFont(new Font("Candara",0,20));
        type.setFont(new Font("Candara",0,20));
        l1.setBounds(100,60,145,30);
        l2.setBounds(100,100,145,30);
        l3.setBounds(100,140,145,30);
        loginID.setBounds(255,60,145,30);
        pswd.setBounds(255,100,145,30);
        type.setBounds(255,140,145,30);
        p2.add(l1);
        p2.add(l2);
        p2.add(l3);
        p2.add(loginID);
        p2.add(pswd);
        p2.add(type);

        p3=new JPanel();
        p3.setLayout(new GridLayout(1,2));
        exit=new JButton("Exit");
        login=new JButton("Login");
        exit.setFont(new Font("Candara",1,20));
        login.setFont(new Font("Candara",1,20));
        p3.add(exit);
        p3.add(login);

        login.addActionListener(this);
        exit.addActionListener(this);

        f.add(p1,BorderLayout.NORTH);
        f.add(p2,BorderLayout.CENTER);
        f.add(p3,BorderLayout.SOUTH);
        f.setSize(500,400);
        f.setVisible(true);
        f.setResizable(false);
        f.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){f.dispose();}});
    }

    public void actionPerformed(ActionEvent e)
    {
        JButton bt=(JButton)e.getSource();
        if(bt==login)
        {
            int id=Integer.parseInt(loginID.getText());
            String pass=new String(pswd.getPassword());
            if(new Handler().check(id, pass, type.getSelectedIndex()))
            {
                JOptionPane.showMessageDialog(f,"Login successfull");
                clear();
                if(mem.type==1)
                new Admin(mem);
                else if(mem.type==2)
                new Manager(mem);
                else if(mem.type==3)
                new Pharmacy(mem);
                else if(mem.type==4)
                new Receptionist(mem);
                //else if(mem.type==5)
                //new Delivery(mem);
            }
            else
            {
                JOptionPane.showMessageDialog(f,"Incorrect entries");
            }
        }
        if(bt==exit)
        {
            f.dispose();
        }
    }

    void clear()
    {
        loginID.setText("");
        pswd.setText("");
        type.setSelectedIndex(0);
    }  
}
