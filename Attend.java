import java.io.Serializable;

public class Attend implements Serializable
{
    int id;
    String name;
    String date;
    char status;
    Attend(int id,String name,String date,char status)
    {
        this.id=id;
        this.name=name;
        this.date=date;
        this.status=status;        
    }

    public String toString()
    {
        return id+":"+name+":"+date+":"+status;
    }
}