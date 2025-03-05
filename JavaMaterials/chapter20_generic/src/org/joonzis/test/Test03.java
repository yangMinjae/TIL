package org.joonzis.test;

public class Test03 {
	public static void main(String[] args) {
		Product<Elec, Tv> product1 = new Product<>();
		Product<Life, Cup> product2 = new Product<>();

		product1.setCategory(new Elec());
		product1.setModel(new Tv("LG"));
		
		System.out.println(product1);	
		product2.setCategory(new Life());
		product2.setModel(new Cup("도자기"));
		
		System.out.println(product2);	
		
	}
}
class Product<T1, T2>{
	private T1 category;
	private T2 model;
	public void setCategory(T1 category) {
		this.category=category;
	}
	public void setModel(T2 model) {
		this.model=model;
	}
	@Override
	public String toString() {
		return  category + ", " + model;
	}
	
}
class Elec{

	@Override
	public String toString() {
		return "전자제품";
	}
	
}
class Tv{
	private String model;

	public Tv(String model) {
		super();
		this.model = model;
	}

	@Override
	public String toString() {
		return model+" TV";
	}
	
}
class Life{

	@Override
	public String toString() {
		return "생활용품";
	}
	
}
class Cup{
	private String material;

	public Cup(String material) {
		super();
		this.material = material;
	}

	@Override
	public String toString() {
		return material+" 컵";
	}
}