import java.util.Scanner;

class Head{
 

	public static void main(String[] args){
		Scanner obj = new Scanner(System.in);
		System.out.println("Welcome to Flipkart Payroll");
		int key;
		System.out.println("Press 1 For new Employee");
		System.out.println("Press 2 To remove Employee");
		System.out.println("Press 3 To Show Employee");
		System.out.println("press 4 to add member to union");
		System.out.println("press 5 to remove member from union");
		System.out.println("press 6 to show all member in union");
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
		}
	}

}