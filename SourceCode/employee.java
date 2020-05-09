
enum Emp_Type{
	HOURLY,
	FLAT,
	COMMISIONED
}
enum Pay_Type{
	POSTAL,
	PAYMASTER,
	BANK
}

class employee{
	private static int EID = 1;
	private int Emp_id;
	private boolean is_active;
	private String name;
	private Emp_Type emp_type;   
	private Pay_Type pay_type;
	private String address;
	private String bank_acc;
	private int curr_bal;
	private int day_count;
	private int fri_cnt;
	private int per_hour;
	private int flat_salary;
	private int sales;
	private double com_rate; 
	employee(String name,Emp_Type emp_type,Pay_Type pay_type,String address,String bank_acc,int per_hour,int flat_salary,double com_rate){
		this.name = name;
		this.emp_type = emp_type;
		this.pay_type = pay_type;
		this.address = address;
		this.bank_acc = bank_acc;
		this.curr_bal = 0;
		this.day_count = 0;
		this.fri_cnt = 0;
		this.per_hour = per_hour;
		this.flat_salary = flat_salary;
		this.com_rate = com_rate;
		this.sales = 0;
		this.Emp_id = EID;
		EID++;
		this.is_active = true;
	}
	public void changeemptype(Emp_Type emp_type){
			this.emp_type = emp_type;
	}
	public void showdetails(){
			System.out.println("Emp_id : " + Emp_id);
			System.out.println("Emp_Type : " + emp_type);
			System.out.println("Pay_Type : " + pay_type);
			System.out.println("Address : " + address);
			System.out.println("Bank Account : " + bank_acc);
			System.out.println("Per Hour salary : " + per_hour);
			System.out.println("Flat salary : " + flat_salary);
			System.out.println("Comission Rate : " + com_rate);
			if(emp_type == Emp_Type.HOURLY) System.out.println("Current balance : " + curr_bal);
			if(emp_type == Emp_Type.COMMISIONED) System.out.println("Sale : " + sales);
	}
	public void changepaytype(Pay_Type pay_type){
			this.pay_type = pay_type;
	}
	public void changebank(String s){
			this.bank_acc = s;
	}
	public void changeadd(String s){
			this.address = s;
	}
	public void changecomission(double com_rate){
			this.com_rate = com_rate;
	}
	public void changeflatsalary(int flat_salary){
			this.flat_salary = flat_salary;
	}
	public void changehoursalary(int per_hour){
			this.per_hour = per_hour;
	}
	public void delemp(){
			this.is_active = false;
	}

}