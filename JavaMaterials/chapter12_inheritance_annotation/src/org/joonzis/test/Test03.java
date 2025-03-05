package org.joonzis.test;

public class Test03 {
	public static void main(String[] args) {
		PartTimeWorker par1 = new PartTimeWorker("김알바", "gs25", 7, 11000);
		par1.output();
		
		SalaryWorker sal1 = new SalaryWorker("김봉급","생산관리부서", 400);
		sal1.output();
		
		SalesWorker sale1 = new SalesWorker("김판매", "건강식품", 300, 15);
		sale1.output();
	}
}
abstract class Employee{
	String name;
	String dept;
	public Employee() {}
	public Employee(String name, String dept) {
		this.name = name;
		this.dept = dept;
	}
	void output() {
		System.out.println();
		System.out.println("이름 : "+this.name);
		System.out.println("부서 : "+this.dept);
	}
	abstract int pay();
}
// Employee 상속한 두 클래스
class PartTimeWorker extends Employee{
	int workTime;
	int payPerHour;
	public PartTimeWorker() {}
	public PartTimeWorker(String name, String dept, int workTime, int payPerHour) {
		super(name, dept);
		this.workTime = workTime;
		this.payPerHour = payPerHour;
	}
	int pay() {
		return workTime*payPerHour;
	}
	void output() {
		super.output();
		System.out.println("근무 시간 : " + this.workTime);
		System.out.println("시급 : " + this.payPerHour + "원");
		System.out.println("일급 : " + this.pay() + "원");
	}
}
class SalaryWorker extends Employee{
	int salary;
	public SalaryWorker() {}
	public SalaryWorker(String name, String dept, int salary) {
		super(name, dept);
		this.salary = salary;
	}
	int pay() {
		return this.salary;
	}
	void output() {
		super.output();
		System.out.println("월급 : " + this.pay() + "만원");	
	}
}
// SalaryWorker 상속한 클래스
class SalesWorker extends SalaryWorker{
	double salesIncentive;
	public SalesWorker() {}
	public SalesWorker(String name, String dept, int salary, double salesIncentive) {
		super(name, dept, salary);
		this.salary = salary;
		this.salesIncentive = salesIncentive;
	}
	int salesPay() {
		return (int)(pay()*(1+this.salesIncentive/100));
	}
	void output() {
		super.output();
		System.out.println("인센티브 : " + this.salesIncentive + "%");
		System.out.printf("총 급여 : %d만원" ,this.salesPay());
	}
}