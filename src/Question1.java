import java.util.ArrayList;
import java.util.List;

public class Question1 {

	public static void main(String[] args) {
	
		SimpleAppointment SA1 = new SimpleAppointment("Section 1","10:00 AM");
		SimpleAppointment SA2 = new SimpleAppointment("Section 2","11:00 AM");
		SimpleAppointment SA3 = new SimpleAppointment("Section 3","11:30 AM");

		
		CompositeAppointment CA1 = new CompositeAppointment();
		CA1.addSubAppointment(SA1);
		CA1.addSubAppointment(SA2);
		CA1.addSubAppointment(SA3);
	
		
		CompositeAppointment CA2 = new CompositeAppointment();
		
		SimpleAppointment SA4 = new  SimpleAppointment("Stand 23", "5:00 PM");
		
		CA2.addSubAppointment(CA1);
		CA2.addSubAppointment(SA4);
		
		System.out.println(CA2.getSummary());
	}
	


}

interface Appointment{
	public abstract String getSummary();	
}


class CompositeAppointment implements  Appointment{
	private List<Appointment> subAppointmetns;
	
	public CompositeAppointment(){
		subAppointmetns = new ArrayList<>();
	}

	@Override
	public String getSummary() {
		String summary = "Compsosite Appointment \n\t";
		
		for (Appointment appointment : subAppointmetns) {
			summary += appointment.getSummary() +"\n\t";
		}
		summary += "\n";
		return summary;
	}
	
	public void addSubAppointment(Appointment appointment){
		subAppointmetns.add(appointment);
	}
	
	public void removeAppointment(Appointment appointment){
		subAppointmetns.remove(appointment);
	}
	
	public List<Appointment> getSubAppointment(){
		return subAppointmetns;
	}
	
}

class SimpleAppointment implements Appointment{

	private String locaiton;
	private String time;
	
	public SimpleAppointment(String location,String time){
		this.locaiton 	= location;
		this.time 		= time;
	}
	
	@Override
	public String getSummary() {
		return String.format("Simple Appointment { %s , %s }",locaiton,time);
	}
	
}
