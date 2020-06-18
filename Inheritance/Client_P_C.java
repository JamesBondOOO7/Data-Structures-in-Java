package oops.Inheritance;

public class Client_P_C {

	public static void main(String[] args) {
		
		System.out.println(" -- Case 1 -- ");
		// Reference -> Parent and Instance -> Parent
		P obj1 = new P();
		System.out.println(obj1.d);
		System.out.println(obj1.d1);
		obj1.fun();
		obj1.fun1();

		System.out.println(" -- Case 2 -- ");
		// Reference -> Parent and Instance -> Child
		P obj2 = new C();
		System.out.println(obj2.d);
		System.out.println(((C)obj2).d);	// Type casting to C type  
		// Accessing the data member of Child class as JVM allows during runtime
		
		System.out.println(obj2.d1);
		
		obj2.fun();	
		((P)obj2).fun();					// Already of P type
		// JVM -> Blueprint of P and C class
		// Therefore Child class is checked first
		// So output is according to the Child class
		// If function is not present in the child class then , Parent class is checked
		
		obj2.fun1();
		((C)obj2).fun2();	// Type Casting
		
		
		System.out.println(" -- Case 3 -- ");
		// Reference -> Child and Instance -> Parent
		// C obj3 = new P();
		// This statement is not allowed in java
		// This happens to give Run time error
		// And Compile time errors are better than Run time errors
		
		System.out.println(" -- Case 4 -- ");
		// Reference -> Child and Instance -> Child
		C obj4 = new C();
		System.out.println(obj4.d);
		System.out.println(((P)obj4).d);	// Type casting so as to access d of P class
		// This is allowed as special space is alloted to data members of both the classes in heap 
		
		System.out.println(obj4.d1);
		System.out.println(obj4.d2);
		
		obj4.fun();
		((P)obj4).fun();
		// Both give same output as function are resolved differently
		// JVM -> Blueprint of P and C class
		// Therefore Child class is checked first
		// So output is according to the Child class
		// If function is not present in the child class then , Parent class is checked
		
		obj4.fun1();
		obj4.fun2();
				
	}

}
