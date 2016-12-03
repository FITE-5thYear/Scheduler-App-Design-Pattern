public class Question4 {
    public static void main(String[] args) {
    	Appointment appointment = new Appointment("Do design patter mini-project","10:00",new NotificationReminder());
    	appointment.reminderUser();
    	System.out.println("User change reminding method from setting");
    	appointment.changeReminderStrategy(new VoiceReminder());
    	appointment.reminderUser();
    }
}

class Appointment{
	private String title;
	private String time;
	
	private RemindingStrategy remindingStrategy;
	
	public Appointment(String title,String time,RemindingStrategy remindingStrategy){
		this.time = time;
		this.title = title;
		this.remindingStrategy = remindingStrategy;
	}
	
	public void changeReminderStrategy(RemindingStrategy remindingStrategy){
		this.remindingStrategy = remindingStrategy;
	}
	
	public void reminderUser(){
		System.out.print(remindingStrategy.remind());
		System.out.println(" - "+title + " - " +time);
	}
}

interface RemindingStrategy
{  
    public String remind();
}

class VoiceReminder implements RemindingStrategy 
{
    @Override
    public String remind() 
    {
       return "Voice Reminder";
    }
}
 
class NotificationReminder implements RemindingStrategy 
{
    @Override
    public String remind() 
    {
       return "Notification Reminder";
    }   
}
 
