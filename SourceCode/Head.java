import java.util.*;

class Head{

	private static Hashtable<Integer,Hashtable<Calendar,Double>> Sale = new Hashtable<Integer,Hashtable<Calendar,Double>>();
	private static Hashtable<Integer,Hashtable<Calendar,Double>> Work = new Hashtable<Integer,Hashtable<Calendar,Double>>();
	
	public static void addwork(int k,double work){
		Integer id = new Integer(k);
		Hashtable<Calendar,Double> tmp = Work.get(id); 
		Calendar cl = Calendar.getInstance();
		cl.set(Cal.year(),Cal.month(),Cal.day());
		tmp.put(cl,new Double(work));
	} 
	public static void addsale(int k,double sale){
		Integer id = new Integer(k);
		Hashtable<Calendar,Double> tmp = Sale.get(id); 
		Calendar cl = Calendar.getInstance();
		cl.set(Cal.year(),Cal.month(),Cal.day());
		tmp.put(cl,new Double(sale));
	}

	public static void addworkmem(int k){
		Integer id = new Integer(k);
		Work.put(id,new Hashtable<Calendar,Double>());
	}
	public static void addsalemem(int k){
		Integer id = new Integer(k);
		Sale.put(id,new Hashtable<Calendar,Double>());
	}
	private static void payroll(){
		int day = Cal.day();
		int month = Cal.month();
		int year = Cal.year();
		System.out.println("Payroll for :"+ day + "/" + month + "/" + year);
		Emplist.addmoney();
		if(Cal.isfriday()){
		union.addcharge();
		union.getcharges();
		}
		Cal.adday();
	}

	private static void Timecard(int k){
		Integer id = new Integer(k);
		Hashtable<Calendar,Double> tmp = Work.get(id);
		if(tmp==null){
			System.out.println("Employee doesn't exist");
			return;
		}
		Enumeration<Calendar> enumeration = tmp.keys();
		while(enumeration.hasMoreElements()){
			Calendar key = enumeration.nextElement();
			System.out.println("Date :" + key.get(Calendar.DATE) + "/" + key.get(Calendar.MONTH) +"/"  + key.get(Calendar.YEAR) + "    work:" +(tmp.get(key)).doubleValue());
		}
	}
	private static void Salecard(int k){
		Integer id = new Integer(k);
		Hashtable<Calendar,Double> tmp = Sale.get(id);
		if(tmp==null){
			System.out.println("Employee doesn't exist");
			return;
		}
		Enumeration<Calendar> enumeration = tmp.keys();
		while(enumeration.hasMoreElements()){
			Calendar key = enumeration.nextElement();
			System.out.println("Date :" + key.get(Calendar.DATE) + "/" +key.get(Calendar.MONTH) +"/" +key.get(Calendar.YEAR) + "    sale:" +(tmp.get(key)).doubleValue());
		}
	}

	public static void main(String[] args){
		Scanner obj = new Scanner(System.in);
		System.out.println("Welcome to Flipkart Payroll");
		int key;
		System.out.println("Press 1 For new Employee");
		System.out.println("Press 2 To remove Employee");
		System.out.println("Press 3 To Show Employees");
		System.out.println("press 4 to add member to union");
		System.out.println("press 5 to remove member from union");
		System.out.println("press 6 to show all member in union");
		System.out.println("press 7 to run payroll");
		System.out.println("press 8 to show time card");
		System.out.println("press 9 to show sale card");
		System.out.println("press 10 to update employee details");
		System.out.println("press 11 to exit");
		
		while(true){
			System.out.println("Press any key");
			key = obj.nextInt();
			if(key==1) Emplist.addemp();
			else if(key==2){
				System.out.println("Employee_id :");
				int id = obj.nextInt();
				Emplist.removemp(id);
			}
			else if(key==3) Emplist.showemp();
			else if(key==4){
				System.out.println("Employee_id :");
				int id = obj.nextInt();
				union.addtounion(id);
			}
			else if(key==5){
				System.out.println("Employee_id :");
				int id = obj.nextInt();
				union.removetounion(id);
			}
			else if(key==6){
				union.showmember();
			}
			else if(key==7){
				payroll();
			}
			else if(key==8){
				System.out.println("Employee_id :");
				int id = obj.nextInt();
				Timecard(id);
			}
			else if(key==9){
				System.out.println("Employee_id :");
				int id = obj.nextInt();
				Salecard(id);
			}
			else if(key==10){
				System.out.println("Employee_id :");
				int id = obj.nextInt();
				Emplist.updateEmp(id);
			}
			else if(key==11){
				break;
			}
			else{
				System.out.println("Invalid key");
			}
		}
	}

}