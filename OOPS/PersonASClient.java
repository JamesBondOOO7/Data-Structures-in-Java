package oops;

public class PersonASClient {

	public static void main(String[] args) {
		PersonAS P1 = new PersonAS();
		PersonAS P2 = new PersonAS();
		
		System.out.println(P1.getName());
		System.out.println(P1.getAge());
		
		P2.setName("Manan");
		P2.setAge(19);
		
		System.out.println(P2.getName());
		System.out.println(P2.getAge());

		// We can't directly access the (private)instance variables of the class.
		// Therefore we have to use methods.
	}

}
