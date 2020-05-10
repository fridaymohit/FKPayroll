import java.util.Calendar;

class Cal{
	private static Calendar cal;

	static{
		cal = Calendar.getInstance();
		cal.set(2020,1,3);
	}
	static public int day(){
		return cal.get(Calendar.DATE);
	}
	static public int month(){
		return cal.get(Calendar.MONTH);
	}
	static public int year(){
		return cal.get(Calendar.YEAR);
	}
	static public void adday(){
		if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.FRIDAY){
			cal.add(Calendar.DATE,3);
		}
		else{
			cal.add(Calendar.DATE , 1);
		}
	}
	static public boolean isfriday(){
		if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.FRIDAY){
			return true;
		}
		else{
			return false;
		}
	}
	static public int weekday(){
		return cal.get(Calendar.DAY_OF_WEEK);		
	}
	static public boolean islastofmonth(){
		int maxd = cal.getActualMaximum(Calendar.DATE);
		if((day()==maxd)||((cal.get(Calendar.DAY_OF_WEEK)==Calendar.FRIDAY)&&(day()+2>=maxd))) return true;
		return false;
	}
}