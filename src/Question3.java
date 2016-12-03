import java.util.Calendar;
import java.util.Date;

public class Question3 {
	public static void main(String[] args) {
		CalenderInterface calender = SingltonAdvanceCalender.getInstance();
		System.out.println(calender.getDateInMarch(2016, 1)+"\n");
		calender = SingltonAdvanceCalender.getInstance();
		System.out.println(calender.getDateInMarch(2016, 3)+"\n");
		calender = SingltonAdvanceCalender.getInstance();
		System.out.println(calender.getDateInMarch(2016, 7)+"\n");
		calender = SingltonAdvanceCalender.getInstance();
		System.out.println(calender.getDateInMarch(2016, 23)+"\n");
	}
}

class SingltonAdvanceCalender implements CalenderInterface{
	
	private static SingltonAdvanceCalender instance;
	private Calendar calendar;
	private SingltonAdvanceCalender(){
		calendar = Calendar.getInstance();
	}
	
	public static SingltonAdvanceCalender getInstance(){
		if (instance == null){
			System.out.println("Create instance for the first time");
			instance = new SingltonAdvanceCalender();
			return instance;
		}else{
			System.out.println("Reuse the existing instance");
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