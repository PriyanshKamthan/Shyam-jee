import java.io.Serializable;

public class Member implements Serializable
{
    int id;
    String name;
    String phone;
    String pswd;
    int type;
    Member(int id,String name,String phone,String pswd,int type)
    {
        this.id=id;
        this.name=name;
        this.phone=phone;
        this.pswd=pswd;
        this.type=type;
    }

    public String toString()
    {
        return id+":"+name+":"+phone+":"+pswd+":"+type;
    }
}

//type1=admin,
//type2=manager,
//type3=pharmacy,
//type4=receptionist,
//type5=delivery,