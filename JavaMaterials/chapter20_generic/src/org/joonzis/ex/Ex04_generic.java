package org.joonzis.ex;

public class Ex04_generic {

	public static void main(String[] args) {
		Room<Chair, Desk> room1 = new Room<>();
		room1.setFurniture1(new Chair());
		room1.setFurniture2(new Desk());
		System.out.println(room1);
		
		System.out.println();
		
		Room<Bed, DressTable> room2 = new Room<>();
		room2.setFurniture1(new Bed());
		room2.setFurniture2(new DressTable());
		System.out.println(room2);
	}

}
class Room <T1, T2>{
	private T1 furniture1;
	private T2 furniture2;
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("첫 번째 가구 : ").append(furniture1).append("\n")
		.append("두 번쨰 가구 : ").append(furniture2);
		return sb.toString();
	}
	public T1 getFurniture1() {
		return furniture1;
	}
	public void setFurniture1(T1 furniture1) {
		this.furniture1 = furniture1;
	}
	public T2 getFurniture2() {
		return furniture2;
	}
	public void setFurniture2(T2 furniture2) {
		this.furniture2 = furniture2;
	}
	
	
}
class Chair{

	@Override
	public String toString() {
		return "의자";
	}
	
}
class Desk{
	
	@Override
	public String toString() {
		return "책상";
	}
	
}
class Bed{
	
	@Override
	public String toString() {
		return "침대";
	}
	
}
class DressTable{
	
	@Override
	public String toString() {
		return "화장대";
	}
	
}