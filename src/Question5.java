import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Question5 {
    public static void main(String[] args) {
     
        AppointmentBuilder builder = new AppointmentBuilder();
        builder.SetDate();
        builder.SetLocation();
        builder.SetCoordinators("event");
    }
    
}

class Appointment{
    public Calendar date;
    public String location;
    public List<String> coordinators;
}
interface IAppointmentBuilder 
{
    // The appointment creation consist of many phases: set the date, location, coordinators
    void SetDate();
    void SetLocation();

    //some phases change due to the type of the appointment.. so we pass the appointment type to these  phases
    void SetCoordinators(String Appointment_type);
}

class AppointmentBuilder implements IAppointmentBuilder{

    private Appointment appointment;
    
    public AppointmentBuilder(){
        this.appointment=new Appointment();
    }
     
    @Override
    public void SetDate() {
        appointment.date=Calendar.getInstance();
    }
    
    @Override
    public void SetLocation(){
        appointment.location="Hamra";
    }

    @Override
    public void SetCoordinators(String appointment_type) {
        List<String> coords;
        if(appointment_type.equals("event")){
          coords =new ArrayList<>(2);
          coords.add("Alaa");
          coords.add("hania");
        }else if(appointment_type.equals("conference")){
            coords =new ArrayList<>(3);
            coords.add("Mohammed");
            coords.add("Basel");
            coords.add("Omar");
        }
    }
}
