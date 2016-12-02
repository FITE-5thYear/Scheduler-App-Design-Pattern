import java.util.Calendar;
import java.util.Date;

public class Question2 {
	public static void main(String[] args) {
		CalenderInterface calender = new AdvanceCalender();
		System.out.println(calender.getDateInMarch(2016, 1));
	}
}


interface CalenderInterface{
	public Date getDateInMarch(int year,int day);	
}

class AdvanceCalender implements CalenderInterface{
	private Calendar calendar;

	
	public AdvanceCalender(){
		calendar = Calendar.getInstance();
	}
	
	
	@Override
	public Date getDateInMarch(int year,int day) {
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH,Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH,day);
		return calendar.getTime();
	}
}