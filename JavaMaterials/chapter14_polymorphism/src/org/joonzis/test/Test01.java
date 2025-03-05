package org.joonzis.test;

public class Test01 {
	public static void main(String[] args) {
		Employee ems[] = {new PartTimeWorker("김알바", "gs25", 6, 15000), new SalaryWorker("김봉급", "생산관리", 300), new SalesWorker("김판매잘", "중고차", 200, 1000),
				new SalesWorker("김판매못", "중고차", 200, 100)};
		for (int i = 0; i < ems.length; i++) {
			ems[i].output();
		}
	}
}
abstract class Employee{
	private String name, dept;

	public Employee(String name, String dept) {
		this.name = name;
		this.dept = dept;
	}
	public Employee() {}
	abstract int pay();
	public void output() {
		System.out.println();
		System.out.println("이름 : "+name);
		System.out.println("부서 : "+dept);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
}
class SalaryWorker extends Employee{
	private int salary;

	@Override
	int pay() {
		return salary;
	}

	@Override
	public void output() {
		super.output();
		System.out.println("월급 : "+this.pay()+"만원");
	}
	public SalaryWorker() {}
	public SalaryWorker(String name, String dept, int salary) {
		super(name, dept);
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
class SalesWorker extends SalaryWorker{
	private int salesVolume;
	private double salesIncentive;
	int SalesPay() {
		setSalesIncentive(getSalesVolume()>=1000 ? 10 : (getSalesVolume()>=500 ? 5: 1));
		return (int)(this.getSalary()*salesIncentive/100);
	}
	public SalesWorker() {}
	public SalesWorker(String name, String dept, int salary, int SalesVolume) {
		super(name, dept, salary);
		this.salesVolume = SalesVolume;	
	}

	@Override
	public void output() {
		super.output();
		System.out.println("인센티브 : " + SalesPay()+"만원");
	}
	public int getSalesVolume() {
		return salesVolume;
	}
	public void setSalesVolume(int salesVolume) {
		this.salesVolume = salesVolume;
	}
	public double getSalesIncentive() {
		return salesIncentive;
	}
	public void setSalesIncentive(double salesIncentive) {
		this.salesIncentive = salesIncentive;
		
	}
	
}
class PartTimeWorker extends Employee{
	int workTime, payPerHour;
	public PartTimeWorker() {}
	public PartTimeWorker(String name, String dept, int workTime, int payPerHour) {
		super(name, dept);
		this.workTime = workTime;
		this.payPerHour = payPerHour;
	}
	public int getWorkTime() {
		return workTime;
	}
	public void setWorkTime(int workTime) {
		this.workTime = workTime;
	}
	public int getPayPerHour() {
		return payPerHour;
	}
	public void setPayPerHour(int payPerHour) {
		this.payPerHour = payPerHour;
	}
	@Override
	int pay() {
		return workTime*payPerHour;
	}
	@Override
	public void output() {
		super.output();
		System.out.println("일급 : " + pay()+"만원");
	}
	
}