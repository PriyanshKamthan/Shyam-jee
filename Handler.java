import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class Handler
{
    Connection cn;
    PreparedStatement st;
    ResultSet rs;
    ArrayList<Member> obj=new ArrayList<>();
    ArrayList<Attend> obj1=new ArrayList<>();
    ArrayList<Patient> obj2=new ArrayList<>();
    ArrayList<Medicine> obj3=new ArrayList<>();

    Handler() // constructor
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost/login_data?user=root&password=pk1234");
        }
        catch(Exception e){System.out.println(e.getMessage());}
    }
    
    ArrayList<Member> display() // display all members
    {
        Member m;         
        try
        {
            String query1="select * from member order by type;";
            st=cn.prepareStatement(query1);
            rs=st.executeQuery();
            while(rs.next())
            {
                m=new Member(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
                obj.add(m);
            }
            cn.close();
            return obj;
        }
        catch(Exception e){System.out.println(e.getMessage());return obj;}
    }
    ArrayList<Member> displayBy(int index,String str) //display member, searching member vis name, phone,id
    {
        Member m;         
        try
        {
            String query1="";
            if(index==0)
            query1="select * from member where id like '"+str+"%' order by type;";
            if(index==1)
            query1="select * from member where name like '"+str+"%' order by type;";
            if(index==2)
            query1="select * from member where phone like '"+str+"%' order by type;";
            
            st=cn.prepareStatement(query1);
            rs=st.executeQuery();
            while(rs.next())
            {
                m=new Member(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
                obj.add(m);
            }
            cn.close();
            return obj;
        }
        catch(Exception e){System.out.println(e.getMessage());return obj;}
    }
    boolean check(int id,String pswd,int type) //check wheather Member exist or not
    {
        Member m;
        try
        {
            String query1="select * from member where id=? and pswd=? and type=?;";
            st=cn.prepareStatement(query1);
            st.setInt(1,id);
            st.setString(2,pswd);
            st.setInt(3,type);
            rs=st.executeQuery();
            if(rs.next())
            {
                m=new Member(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
                LoginInterface.mem=m;
                cn.close();
                return true;
            }
            cn.close();
            return false;
        }
        catch(Exception e){System.out.println(e.getMessage());return false;}        
    }
    boolean addMember(String name,String phone,String pswd,int type) //add new Member 
    {
        try
        {
            String query="INSERT INTO member (name, phone, pswd, type) VALUES (?,?,?,?);";
            st=cn.prepareStatement(query);
            st.setString(1,name);
            st.setString(2,phone);
            st.setString(3,pswd);
            st.setInt(4,type);
            st.executeUpdate();
            cn.close();
            return true;
        }
        catch(Exception e){System.out.println(e.getMessage());return false;}        
    }
    boolean checkAttendance(int id,String date) // check the attendance of member is marked or not
    {
        try
        {
            String query="select attendance from attendance where id=? and date=?";
            st=cn.prepareStatement(query);
            st.setInt(1,id);
            st.setString(2,date);
            rs=st.executeQuery();
            if(rs.next() && rs.getString(1).equalsIgnoreCase("p"))
            {
                cn.close();
                return true;
            }
            cn.close();
            return false;
        }
        catch(Exception e){System.out.println(e.getMessage());return false;}
    }
    boolean addAttendance(int id,String name,String date) // punch attendance of single member
    {
        try
        {
            String query="insert into attendance (id,name,date,attendance) values (?,?,?,?);";
            st=cn.prepareStatement(query);
            st.setInt(1,id);
            st.setString(2,name);
            st.setString(3,date);
            st.setString(4,"p");
            st.executeUpdate();
            cn.close();
            return true;
        }
        catch(Exception e){System.out.println(e.getMessage());return false;}
    }
    ArrayList<Attend> showAttendance(int index,String str) // returns all the Attend by filter
    {
        Attend m;  
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String today=formatter.format(new Date());       
        try
        {
            String query1="";
            if(index==0)
            {
                query1="select * from attendance where date=? order by name;";
                st=cn.prepareStatement(query1);
                st.setString(1,today);
            }
            if(index==1)
            {
                query1="SELECT id,name,MONTH(date), COUNT(*) FROM attendance GROUP BY name order by name;";
                st=cn.prepareStatement(query1);
            }
            if(index==2)
            {
                query1="select * from attendance where name like '"+str+"%' order by MONTH(date),DATE(date);";
                st=cn.prepareStatement(query1);
            }
            rs=st.executeQuery();
            while(rs.next())
            {
                m=new Attend(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4).charAt(0));
                obj1.add(m);
            }
            cn.close();
            return obj1;
        }
        catch(Exception e){System.out.println(e.getMessage());return obj1;}
    }
    boolean addPatient(int patient_id,String patient_name,String patient_phone1,String patient_phone2,int patient_file_number,int book_number)
    {
        try
        {
            String query="insert into patient values (?,?,?,?,?,?);";
            st=cn.prepareStatement(query);
            st.setInt(1,patient_id);
            st.setString(2,patient_name);
            st.setString(3,patient_phone1);
            st.setString(4,patient_phone2);
            st.setInt(5,patient_file_number);
            st.setInt(6,book_number);
            st.executeUpdate();
            cn.close();
            return true;
        }
        catch(Exception e){System.out.println(e.getMessage());return false;}
    }
    ArrayList<Patient> displayAllPatient() // display all patients
    {
        Patient m;         
        try
        {
            String query1="select * from patient;";
            st=cn.prepareStatement(query1);
            rs=st.executeQuery();
            while(rs.next())
            {
                m=new Patient(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
                obj2.add(m);
            }
            cn.close();
            return obj2;
        }
        catch(Exception e){System.out.println(e.getMessage());return obj2;}
    }   
    ArrayList<Patient> displayPatientBy(int index,String str) //display patient, searching member vis name, phone,id
    {
        Patient m;         
        try
        {
            String query1="";
            if(index==0)
            query1="select * from patient where patient_id like '"+str+"%'order by patient_id;";
            if(index==1)
            query1="select * from patient where patient_name like '"+str+"%' order by patient_name;";
            if(index==2)
            query1="select * from patient where patient_phone1 like '"+str+"%' or patient_phone2 like '"+str+"%';";
            
            st=cn.prepareStatement(query1);
            rs=st.executeQuery();
            while(rs.next())
            {
                m=new Patient(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getInt(6));
                obj2.add(m);
            }
            cn.close();
            return obj2;
        }
        catch(Exception e){System.out.println(e.getMessage());return obj2;}
    }
    boolean addMedicine(String name,float price,int qty) // add new Medicine
    {
        try
        {
            String query="INSERT INTO medicine (med_name, price, quantity) VALUES (?,?,?);";
            st=cn.prepareStatement(query);
            st.setString(1,name);
            st.setFloat(2,price);
            st.setInt(3,qty);
            st.executeUpdate();
            cn.close();
            return true;
        }
        catch(Exception e){System.out.println(e.getMessage());return false;}
    }
    ArrayList<Medicine> displayAllMedicine() // display all medicines
    {
        Medicine m;         
        try
        {
            String query1="select * from medicine;";
            st=cn.prepareStatement(query1);
            rs=st.executeQuery();
            while(rs.next())
            {
                m=new Medicine(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4));
                obj3.add(m);
            }
            cn.close();
            return obj3;
        }
        catch(Exception e){System.out.println(e.getMessage());return obj3;}
    }
    ArrayList<Medicine> displayMedicineBy(int index,String str) //display member, searching member vis name, phone,id
    {
        Medicine m;         
        try
        {
            String query1="";
            if(index==0)
            query1="select * from medicine where med_id like '"+str+"%';";
            if(index==1)
            query1="select * from medicine where med_name like '%"+str+"%' order by med_name;";
            
            st=cn.prepareStatement(query1);
            rs=st.executeQuery();
            while(rs.next())
            {
                m=new Medicine(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4));
                obj3.add(m);
            }
            cn.close();
            return obj3;
        }
        catch(Exception e){System.out.println(e.getMessage());return obj3;}
    }
}