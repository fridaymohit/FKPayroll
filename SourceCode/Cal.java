import java.util.Calendar;

class Cal{
	private static Calendar cal;

	Cal(){
		cal = Calendar.getInstance();
		cal.set(2020,1,1);
	}
	public int day(){
		return cal.get(Calendar.DATE);
	}
	public int month(){
		return cal.get(Calendar.MONTH);
	}
	public int year(){
		return cal.get(Calendar.YEAR);
	}
	public void adday(){
		if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.FRIDAY){
			cal.add(Calendar.DATE,3);
		}
		else{
			cal.add(Calendar.DATE , 1);
		}
	}
}