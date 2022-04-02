import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.event.*;

public class ShowPatient
{
    JFrame f;
    JPanel p1,p2;
    JLabel l,l1;
    JComboBox<String> filter;
    JTextField t;
    DefaultTableModel model;
    JTable table;
    ShowPatient()
    {
        f=new JFrame("View Patient Page");
        p1=new JPanel();
        l=new JLabel("Patients");
        l.setFont(new Font("Candara",1,40));
        p1.add(l);

        String str[]={"Patient ID","Patient Name","Patient Phone"};
        
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
        model.addColumn("Phone1");
        model.addColumn("Phone2");
        model.addColumn("File No");
        model.addColumn("Book No");

        ArrayList<Patient> pat=new Handler().displayAllPatient();
        for(Patient m:pat)
        model.addRow(new Object[]{m.patient_id,m.patient_name,m.patient_phone1,m.patient_phone2,m.patient_file_number,m.book_number});
        
        table.setFont(new Font("Candara",0,15));
        table.setBounds(20,70,430,400);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(455,70,15,400);
        p2.add(pane);
        p2.add(table);
        p2.add(l1);
        p2.add(filter);
        
        t=new JTextField();
        t.setFont(new Font("Candara",0,25));
        t.addKeyListener(new KeyAdapter()
        {
            public void keyReleased(KeyEvent e)
            {
                int index=filter.getSelectedIndex();
                ArrayList<Patient> pat =new Handler().displayPatientBy(index, t.getText());
                for(Patient m:pat)
                model.addRow(new Object[]{m.patient_id,m.patient_name,m.patient_phone1,m.patient_phone2,m.patient_file_number,m.book_number});
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
    public static void main(String ar[]){new ShowPatient();}
}