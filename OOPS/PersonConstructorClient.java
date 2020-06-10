package oops;

public class PersonConstructorClient {

	public static void main(String[] args) {
		PersonConstructor P1 = new PersonConstructor();
		PersonConstructor P2 = new PersonConstructor(19);
		PersonConstructor P3 = new PersonConstructor(19, "Manan");
		
		System.out.println(P1.getName());
		System.out.println(P1.getAge());
		
		System.out.println(P2.getName());
		System.out.println(P2.getAge());

		System.out.println(P3.getName());
		System.out.println(P3.getAge());

	}

}
