import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.event.*;

public class ShowMedicine
{
    JFrame f;
    JPanel p1,p2;
    JLabel l,l1;
    JComboBox<String> filter;
    JTextField t;
    DefaultTableModel model;
    private DefaultTableCellRenderer cellRenderer;

    JTable table;
    ShowMedicine()
    {
        f=new JFrame("View Medicine Page");
        p1=new JPanel();
        l=new JLabel("Medicines");
        l.setFont(new Font("Candara",1,40));
        p1.add(l);

        String str[]={"Medicine ID","Medicine Name"};
        
        p2=new JPanel();
        p2.setLayout(null);
        l1=new JLabel("Search via: ");
        filter=new JComboBox<>(str);
        l1.setBounds(250,20,150,30);
        filter.setBounds(360,20,190,30);
        l1.setFont(new Font("Candara",1,20));
        filter.setFont(new Font("Candara",0,18));
        
        table=new JTable(model);
        model=(DefaultTableModel)table.getModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Price");
        model.addColumn("Quantity");

        ArrayList<Medicine> med=new Handler().displayAllMedicine();
        for(Medicine m:med)
        model.addRow(new Object[]{m.med_id,m.med_name,m.price,m.quantity});
        
        table.getColumnModel().getColumn(0).setPreferredWidth(5);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
        cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        table.getColumnModel().getColumn(2).setCellRenderer(cellRenderer);
        table.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);

        table.setFont(new Font("Candara",0,15));
        table.setBounds(20,70,730,380);
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
                ArrayList<Medicine> medicine =new Handler().displayMedicineBy(index, t.getText());
                for(Medicine m:medicine)
                model.addRow(new Object[]{m.med_id,m.med_name,m.price,m.quantity});
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
        f.setSize(800,600);
        f.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){f.dispose();}});
    }
    public static void main(String[] args) {
        new ShowMedicine();
    }
}