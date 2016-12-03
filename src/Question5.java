import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Question5 {
    public static void main(String[] args) {
     
        AppointmentBuilder builder = new AppointmentBuilder();
        builder.SetDate(Calendar.getInstance().getTime());
        builder.SetLocation("Hamra");
        builder.SetCoordinators("event");
        
        
        Appointment2 appointment = builder.Build();
        System.out.println(appointment.toString());
        
        builder.SetCoordinators("conference");
        appointment = builder.Build();
        System.out.println(appointment.toString());
    }  
}

class Appointment2{
    public Date date;
    public String location;
    public List<String> coordinators;
    
    @Override
    public String toString(){
    	String string = "Date : " + date;
    	string += "\nLocation :" + location;
    	string += "\nCoordinators :" + coordinators;
    	return string;
    }
}
interface IAppointmentBuilder 
{
    // The appointment creation consist of many phases: set the date, location, coordinators
    void SetDate(Date date);
    void SetLocation(String locatoin);

    //some phases change due to the type of the appointment.. so we pass the appointment type to these  phases
    void SetCoordinators(String Appointment_type);
    Appointment2 Build();
}

class AppointmentBuilder implements IAppointmentBuilder{

    private Appointment2 appointment;
    
    public AppointmentBuilder(){
        this.appointment=new Appointment2();
    }
    
    @Override
    public Appointment2 Build() {
		return appointment;
	}
     
    @Override
    public void SetDate(Date date) {
        appointment.date=date;
    }
    
    @Override
    public void SetLocation(String location){
        appointment.location=location;
    }

    @Override
    public void SetCoordinators(String appointment_type) {
    	appointment.coordinators = new ArrayList<>();
        if(appointment_type.equals("event")){
	        appointment.coordinators.add("Alaa");
	        appointment.coordinators.add("Hania");
        }else if(appointment_type.equals("conference")){
        	appointment.coordinators.add("Mohammed");
        	appointment.coordinators.add("Basel");
        	appointment.coordinators.add("Omar");
        }
    }
}
