import java.util.*;

class Emplist{
	private static Hashtable<Integer,employee> emp = new Hashtable<Integer,employee>();
 	
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
		double per_hour = obj.nextDouble();
		System.out.println("Per month salary:");
		double flat_salary = obj.nextDouble();
		System.out.println("Commission rate:");
		double com_rate = obj.nextDouble();
		

		employee e = new employee(name,emp_type,pay_type,address,bank_acc,per_hour,flat_salary,com_rate);
		emp.put(new Integer(e.getID()),e);
		Head.addsalemem(e.getID());
		Head.addworkmem(e.getID());
		System.out.println("Employee added successfully");

	}

	public static void updateEmp(int Eid){
		int id = new Integer(Eid);
		employee e = emp.get(id);
		if(e==null){
			System.out.println("Employee Doesn't exist");
			return;
		}
		Scanner obj = new Scanner(System.in);
		System.out.println("press 1 to update employee type");
		System.out.println("press 2 to update payment transfer type");
		System.out.println("press 3 to update address");
		System.out.println("press 4 to update bank account");
		System.out.println("press 5 to update per hour payment");
		System.out.println("press 6 to update per month salary");
		System.out.println("press 7 to update commission rate");
		System.out.println("press 8 to update union due");
		System.out.println("press 9 to show complete details of employee");
		System.out.println("press 10 to go back");
		while(true){
			int k = obj.nextInt();
			if(k==1){
				System.out.println("Employee Type(0 -> hourly , 1->monthly , 2-> commissioned)");
				int newtype = obj.nextInt();
				int prevtype = e.getemptype();
				if((prevtype==newtype)||((prevtype+newtype==3))){
					e.changeemptype(newtype);
					System.out.println("Updated successfully");
				}
				else if((Cal.day()==1)||((Cal.day()<=3)&&(Cal.weekday()==Calendar.MONDAY))){
					e.changeemptype(newtype);
					System.out.println("Updated successfully");	
				}
				else{
					System.out.println("Can't update(update can be done only on first working day of month)");
				}
			}
			else if(k==2){
				System.out.println("new payment transfer type(0 -> postal , 1->paymaster , 2-> bank):");
				int val = obj.nextInt();
				e.changepaytype(val);
				System.out.println("Updated successfully");
			}
			else if(k==3){
				System.out.println("new address:");
				obj.nextLine();
				String val = obj.nextLine();
				e.changeadd(val);
				System.out.println("Updated successfully");
			}
			else if(k==4){
				System.out.println("new bank account:");
				obj.nextLine();
				String val = obj.nextLine();
				e.changebank(val);
				System.out.println("Updated successfully");
			}
			else if(k==5){
				System.out.println("new per hour salary:");
				double val = obj.nextDouble();
				e.changehoursalary(val);
				System.out.println("Updated successfully");
			}
			else if(k==6){
				System.out.println("new per month salary:");
				double val = obj.nextDouble();
				e.changeflatsalary(val);
				System.out.println("Updated successfully");
			}	
			else if(k==7){
				System.out.println("new commission rate:");
				double val = obj.nextDouble();
				e.changecomission(val);
				System.out.println("Updated successfully");
			}
			else if(k==8){
				System.out.println("new union due :");
				double val = obj.nextDouble();
				e.changeunidue(val);
				System.out.println("Updated successfully");
			}
			else if(k==9){
				e.showdetails();
			}
			else if(k==10){
				break;
			}
			else {
				System.out.println("Invalid key");
			}

	}
}
	public static void showemp(){
		System.out.println("Employees are :");
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
			(emp.get(k)).delemp();
			emp.remove(k);
			System.out.println("Emloyeee record deleted successfully");
			union.removetounion(id);
		}
	}
	public static employee getemp(int id){
		Integer k = new Integer(id);
		return emp.get(k);
	}

	public static void addmoney(){
		Enumeration<Integer> enumeration = emp.keys();
		Scanner obj = new Scanner(System.in);
		while(enumeration.hasMoreElements()){
			Integer key = enumeration.nextElement();
			employee e = emp.get(key);
			int type = e.getemptype();
			if(type==0){
				System.out.println("Today's work hour for E_id : "+key );
				double work = obj.nextDouble();
				double rate = e.gethour();
				double bal = e.getbalance();
				if(work>8.0){
					bal = bal + 8*rate + (work-8)*rate*(1.5);
				}
				else bal = bal + work*rate;
				e.setbalance(bal);
				Head.addwork(e.getID(),work);
			}
			else if(type==1){
				if(Cal.islastofmonth()){
					double bal = e.getbalance();
					double flat = e.getflat();
					bal = bal + flat;
					e.setbalance(bal);
				}
			}
			else if(type==2){
				System.out.println("Today's sale for E_id : "+key );
				if(Cal.islastofmonth()){
					double bal = e.getbalance();
					double flat = e.getflat();
					bal = bal + flat;
					e.setbalance(bal);
				}

				double sale = obj.nextDouble();
				double prevsale = e.getsales();
				int fri_cnt = e.getfricnt();
				if(Cal.isfriday()){
					fri_cnt++;
				}
				if(fri_cnt==2){
					double com = e.getcomission();
					double bal = e.getbalance();
					bal = bal + ((sale+prevsale)*com)/100;
					e.setbalance(bal);
					e.setsales(0);
					e.setfricnt(0);	
				}
				else{
					e.setsales(prevsale+sale);
					e.setfricnt(fri_cnt);
				}
				Head.addsale(e.getID(),sale);
			}
		}
	}

}