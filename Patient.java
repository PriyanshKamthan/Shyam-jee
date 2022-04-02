import java.io.Serializable;

public class Patient implements Serializable
{
    int patient_id;
    String patient_name;
    String patient_phone1;
    String patient_phone2;
    int patient_file_number;
    int book_number;
    
    Patient(int patient_id,String patient_name,String patient_phone1,String patient_phone2,int patient_file_number,int book_number)
    {
        this.patient_id=patient_id;
        this.patient_name=patient_name;
        this.patient_phone1=patient_phone1;
        this.patient_phone2=patient_phone2;
        this.patient_file_number=patient_file_number;
        this.book_number=book_number;
    }
    public String toString()
    {
        return patient_id+":"+patient_name+":"+patient_phone1+":"+patient_phone2+":"+patient_file_number+":"+book_number;
    }
}