import java.util.*;

class union{
	private static int weekly_due=0;
	private static int charges = 0;
	private static Hashtable<Integer,employee> unimem = new Hashtable<Integer,employee>();
	public static void setweekdue(int k){
		weekly_due = k;
		Enumeration<Integer> enumeration = unimem.keys();
		while(enumeration.hasMoreElements()){
			Integer key = enumeration.nextElement();
			employee e = unimem.get(key);
			e.changeunidue(k);
		}
	}
	public static void addcharge(int k){
		charges = charges + k;
	}
	public static int getCharge(){
		return charges;
	}
	public static void resetcharge(){
		charges = 0;
	}
	public static void addtounion(int k){
		Integer id = new Integer(k);
		if(unimem.get(id)!=null){
			System.out.println("Member already present in the union");
		}
		else if(Emplist.getemp(k)==null){
			System.out.println("Employee not present in database");
		}
		else{
			unimem.put(id,Emplist.getemp(k));
			System.out.println("member added successfully");
		}
	}
	public static void removetounion(int k){
		Integer id = new Integer(k);
		if(unimem.get(id)==null){
			System.out.println("Member not present in union");
		}
		else{
			unimem.remove(k);
			System.out.println("Member removed successfully");
		}
	}
	public static void showmember(){
		System.out.println("Union members are:");
		Enumeration<Integer> enumeration = unimem.keys();
		while(enumeration.hasMoreElements()){
			Integer key = enumeration.nextElement();
			System.out.println("E_id : "+key );
		}
	}

}