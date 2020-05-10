
class employee{
	private static int EID = 1;
	private int Emp_id;
	private boolean is_active;
	private String name;
	private int emp_type;   
	private int pay_type;
	private String address;
	private String bank_acc;
	private double curr_bal;
	private int day_count;
	private int fri_cnt;
	private double per_hour;
	private double flat_salary;
	private double sales;
	private double com_rate; 
	private double uni_due;
	private double charge;
	employee(String name,int emp_type,int pay_type,String address,String bank_acc,double per_hour,double flat_salary,double com_rate){
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
	public void changeemptype(int emp_type){
			this.emp_type = emp_type;
	}
	public int getemptype(){
			return emp_type;
	}
	public int getID(){
			return this.Emp_id;
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
			if(emp_type == 0) System.out.println("Current balance : " + curr_bal);
			if(emp_type == 2) System.out.println("Sale : " + sales);
			System.out.println("weekly due charge for union : " + uni_due);
			System.out.println("Charges remaining to pay to union : " + charge);
	}
	public void changepaytype(int pay_type){
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
	public double getcomission(){
			return com_rate;
	}
	public void changeflatsalary(double flat_salary){
			this.flat_salary = flat_salary;
	}
	public double getflat(){
			return flat_salary;
	}
	public void changehoursalary(double per_hour){
			this.per_hour = per_hour;
	}
	public double gethour(){
			return per_hour;
	}
	public void delemp(){
			this.is_active = false;
	}
	public void changeunidue(double k){
			this.uni_due = k;
	}
	public double getunidue(){
			return uni_due;
	}
	public void addcharge(double k){
			charge = charge + k;
	}
	public double getcharge(){
			return charge;
	}
	public double getbalance(){
			return curr_bal;
	}
	public void setbalance(double k){
			curr_bal = k;
	}
	public double getsales(){
			return sales;
	}
	public void setsales(double k){
			sales = k;
	}
	public int getfricnt(){
			return fri_cnt;
	}
	public void setfricnt(int k){
			fri_cnt = k;
	}

}
