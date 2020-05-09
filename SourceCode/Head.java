import java.util.Scanner;

class Head{


	public static void main(String[] args){
		Scanner obj = new Scanner(System.in);
		System.out.println("Welcome to Flipkart Payroll");
		int key;
		System.out.println("Press 1 For new Employee");
		System.out.println("Press 2 To remove Employee");
		System.out.println("Press 3 To Show Employee");
		while(true){
			key = obj.nextInt();
			if(key==1) Emplist.addemp();
			else if(key==2){
				System.out.println("Employee_id :");
				int id = obj.nextInt();
				Emplist.removemp(id);
			}
			else if(key==3) Emplist.showemp();
		}
	}

}