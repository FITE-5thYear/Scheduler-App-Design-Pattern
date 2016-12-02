import java.util.Calendar;
import java.util.Date;

public class Question3 {
	public static void main(String[] args) {
		CalenderInterface calender = AdvanceCalender2.getInstance();
		System.out.println(calender.getDateInMarch(2016, 1));
	}
}

class AdvanceCalender2 implements CalenderInterface{
	
	private static AdvanceCalender2 instance;
	private Calendar calendar;
	private AdvanceCalender2(){
		calendar = Calendar.getInstance();
	}
	
	public static AdvanceCalender2 getInstance(){
		if (instance == null){
			instance = new AdvanceCalender2();
			return instance;
		}else{
			return instance;
		}
	}
	
	@Override
	public Date getDateInMarch(int year,int day) {
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH,Calendar.MARCH);
		calendar.set(Calendar.DAY_OF_MONTH,day);
		return calendar.getTime();
	}
}