package org.joonzis.test;

public class Test04 {

	public static void main(String[] args) {
		onlyCar(new Bus());
		onlyCar(new CityTourBus());
		onlyCar(new SeoulBus());
		onlyCar(new Taxi());
		//onlyCar(new Bicycle());		// 오류
	}
	static <T extends Car> void onlyCar(T car) {
		Car c1 = car;
		System.out.println(c1.info());
		System.out.println("-------------------------------");
	}
}
interface Car{
	String info();
}
class Bus implements Car{

	@Override
	public String info() {
		return "차종 : 버스\n";
	}
	
}
class CityTourBus extends Bus{
	@Override
	public String info() {
		return super.info()+"분류 : 시티투어 버스\n";
	}
}
class SeoulBus extends Bus{
	@Override
	public String info() {
		return super.info()+"분류 : 서울 버스\n";
	}
}
class Taxi implements Car{
	@Override
	public String info() {
		return "차종 : 택시\n";
	}
}
class Bicycle{
	
}