import java.util.*;

class Emplist{
	private static Hashtable emp = new Hashtable();
 	
	public static void addemp(){


		Scanner obj = new Scanner(System.in);
		System.out.println("Employee name :");
		String name = obj.nextLine();
		System.out.println("Address:");
		String address = obj.nextLine();
		System.out.println("Bank account:");
		String bank_acc = obj.nextLine();
		System.out.println("Employee Type(0 -> hourly , 1->monthly , 2-> commissioned)");
		int emp_type = obj.nextInt();
		System.out.println("Money transfer Type(0 -> postal , 1->paymaster , 2-> bank)");
		int pay_type = obj.nextInt();
		System.out.println("Payment per hour:");
		int per_hour = obj.nextInt();
		System.out.println("Per month salary:");
		int flat_salary = obj.nextInt();
		System.out.println("Commission rate:");
		double com_rate = obj.nextDouble();
	

		employee e = new employee(name,emp_type,pay_type,address,bank_acc,per_hour,flat_salary,com_rate);
		emp.put(new Integer(e.getID()),e);

	}
	public static void showemp(){
		Enumeration<Integer> enumeration = emp.keys();
		while(enumeration.hasMoreElements()){
			Integer key = enumeration.nextElement();
			System.out.println("E_id : "+key );
		}
	}
	public static void removemp(int id){
		Integer k = new Integer(id);
		if(emp.get(k)==null){
			System.out.println("No employee exist with given id");
		}
		else{
			emp.remove(k);
			System.out.println("Emloyeee record deleted successfully");
		}
	}
}