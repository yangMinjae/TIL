package org.joonzis.test;

public class Test02 {

	public static void main(String[] args) {
		User user1 = new User("abcd", "efgh");
		User user2 = new User("abcd", "efgh");
		User user3 = new User("abcde", "efghi");
		System.out.println(user1);
		System.out.println(user2);
		System.out.println(user1.equals(user2)?"동일한 계정": "서로다른계정");
		System.out.println();
		System.out.println(user1);
		System.out.println(user3);
		System.out.println(user1.equals(user3)?"동일한 계정": "서로다른계정");
		System.out.println();
		
	}

}
class User{
	private String id, password;

	public User(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof User) {									//****중요!!!**** Object 객체를 받을 때는 꼭 이 조건문 넣어주자.
			User tmp = (User)obj;
			return this.id.equals(tmp.id) && this.password.equals(tmp.password);
		}
		return false;
	}

	@Override
	public String toString() {
		return "ID : "+id+", Password : "+password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}