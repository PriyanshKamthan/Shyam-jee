import java.io.Serializable;

public class Medicine implements Serializable
{
    int med_id;
    String med_name;
    float price;
    int quantity;
    Medicine(int med_id,String med_name,float price,int qty)
    {
        this.med_id=med_id;
        this.med_name=med_name;
        this.price=price;
        this.quantity=qty;
    }

    public String toString()
    {
        return med_id+":"+med_name+":"+price+":"+quantity;
    }
}

//id--int--autogenerated
//name--string
//mrp--float
//qty--int