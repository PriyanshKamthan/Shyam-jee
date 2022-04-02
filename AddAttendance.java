import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class AddAttendance
{
    AddAttendance(Member m)
    {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date=formatter.format(new Date());
        
        if(new Handler().checkAttendance(m.id,date))
        {
            JOptionPane.showMessageDialog(null,"Your Attendance Is already marked");
        }
        else
        {
            new Handler().addAttendance(m.id, m.name, date);
            JOptionPane.showMessageDialog(null, m.name+"'s attendance of "+date+" is updated");
        }
    }
}
