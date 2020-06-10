package oops;

public class PersonClient {

	public static void main(String[] args) {
		Person P1 = new Person();
		Person P2 = new Person();
		
		System.out.println(P1.name);
		System.out.println(P1.age);
		
		P2.name = "Manan";
		P2.age = 19;
		
		System.out.println(P2.name);
		System.out.println(P2.age);

	}

}
