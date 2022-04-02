import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.event.*;

public class ShowAttendance implements ActionListener
{
    JFrame f;
    JPanel p1,p2,p3;
    JLabel l,l1;
    JComboBox<String> filter;
    JTextField t;
    JButton go;
    DefaultTableModel model;
    JTable table;
    ShowAttendance()
    {
        f=new JFrame("View Attendance Page");
        p1=new JPanel();
        l=new JLabel("Attendance");
        l.setFont(new Font("Candara",1,40));
        p1.add(l);

        String str[]={"Today's","Monthly","Name"};
        
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
        model.addColumn("Date");
        model.addColumn("Status");
        
        table.setFont(new Font("Candara",0,15));
        table.setBounds(20,70,430,400);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(455,70,15,400);
        p2.add(pane);
        p2.add(l1);
        p2.add(filter);
        
        t=new JTextField();
        t.setFont(new Font("Candara",0,25));
        t.setEnabled(false);

        t.addKeyListener(new KeyAdapter()
        {
            public void keyReleased(KeyEvent e)
            {
                ArrayList<Attend> attend=new Handler().showAttendance(2,"");
                for(Attend o:attend)
                model.addRow(new Object[]{o.id,o.name,o.date,o.status});
            }
            public void keyPressed(KeyEvent e)
            {
                clear();
            }
        });

        p3=new JPanel();
        p3.setLayout(new BorderLayout());
        go=new JButton("GO");
        p3.add(t);
        p3.add(go,BorderLayout.EAST);

        go.addActionListener(this);

        f.add(p1,BorderLayout.NORTH);
        f.add(p2,BorderLayout.CENTER);
        f.add(p3,BorderLayout.SOUTH);
        f.setVisible(true);
        f.setSize(500,600);
        f.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){f.dispose();}});
    }
    public void actionPerformed(ActionEvent e)
    {
        clear();
        if(filter.getSelectedIndex()==2)
        {
            t.setEnabled(true);
        }
        else if(filter.getSelectedIndex()==0)
        {
            t.setEnabled(false);            
            ArrayList<Attend> attend=new Handler().showAttendance(0,"");
            for(Attend o:attend)
            model.addRow(new Object[]{o.id,o.name,o.date,o.status});    
        }
        else if(filter.getSelectedIndex()==1)
        {
            t.setEnabled(false);
            ArrayList<Attend> attend=new Handler().showAttendance(1,"");
            for(Attend o:attend)
            model.addRow(new Object[]{o.id,o.name,o.date,o.status});    
        }
    }

    void clear()
    {
        while(model.getRowCount()>0)
        {
            model.removeRow(0);
        }
    }
}