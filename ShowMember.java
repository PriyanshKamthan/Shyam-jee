import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.event.*;

public class ShowMember
{
    JFrame f;
    JPanel p1,p2;
    JLabel l,l1;
    JComboBox<String> filter;
    JTextField t;
    DefaultTableModel model;
    JTable table;
    ShowMember()
    {
        f=new JFrame("View Member Page");
        p1=new JPanel();
        l=new JLabel("Members");
        l.setFont(new Font("Candara",1,40));
        p1.add(l);

        String str[]={"Member ID","Member Name","Member Phone"};
        
        p2=new JPanel();
        p2.setLayout(null);
        l1=new JLabel("Search via: ");
        filter=new JComboBox<>(str);
        l1.setBounds(100,20,150,30);
        filter.setBounds(210,20,190,30);
        l1.setFont(new Font("Candara",1,20));
        filter.setFont(new Font("Candara",0,18));
        
        table=new JTable(model);
        model=(DefaultTableModel)table.getModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Phone");
        model.addColumn("Password");
        model.addColumn("Type");

        ArrayList<Member> mem=new Handler().display();
        for(Member m:mem)
        model.addRow(new Object[]{m.id,m.name,m.phone,m.pswd,m.type});
        
        table.setFont(new Font("Candara",0,15));
        table.setBounds(20,70,430,400);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(455,70,15,400);
        p2.add(pane);
        p2.add(l1);
        p2.add(filter);
        
        t=new JTextField();
        t.setFont(new Font("Candara",0,25));
        t.addKeyListener(new KeyAdapter()
        {
            public void keyReleased(KeyEvent e)
            {
                int index=filter.getSelectedIndex();
                ArrayList<Member> member =new Handler().displayBy(index, t.getText());
                for(Member m:member)
                model.addRow(new Object[]{m.id,m.name,m.phone,m.pswd,m.type});
            }
            public void keyPressed(KeyEvent e)
            {
                while(model.getRowCount()>0)
                {
                    model.removeRow(0);
                }
            }
        });

        f.add(p1,BorderLayout.NORTH);
        f.add(p2,BorderLayout.CENTER);
        f.add(t,BorderLayout.SOUTH);
        f.setVisible(true);
        f.setSize(500,600);
        f.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){f.dispose();}});
    }
}