import java.util.*;

class union{
	
	private static Hashtable<Integer,employee> unimem = new Hashtable<Integer,employee>();
	
	public static void addcharge(){
		Enumeration<Integer> enumeration = unimem.keys();
		Scanner obj = new Scanner(System.in);
		while(enumeration.hasMoreElements()){
			Integer key = enumeration.nextElement();
			System.out.println("amount of union charge for E_id : "+key );
			double k = obj.nextDouble();
			(unimem.get(key.intValue())).addcharge(k);
		}

	}
	public static void getcharges(){
		Enumeration<Integer> enumeration = unimem.keys();
		Scanner obj = new Scanner(System.in);
		while(enumeration.hasMoreElements()){
			Integer key = enumeration.nextElement();
			double bal = (unimem.get(key.intValue())).getbalance();
			double charge = (unimem.get(key.intValue())).getcharge();
			double week_due = (unimem.get(key.intValue())).getunidue();
			if(bal>=charge+week_due){
				bal = bal - charge - week_due;
				System.out.println("Rs "+bal + "is trasfered to E_id:" +key.intValue());
				bal = 0;
				(unimem.get(key.intValue())).addcharge(-charge);
			}
			else{
				charge = charge + week_due - bal;
				(unimem.get(key.intValue())).addcharge(week_due - bal);
				bal = 0;
			}
			(unimem.get(key.intValue())).setbalance(bal);
			
			
		}

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