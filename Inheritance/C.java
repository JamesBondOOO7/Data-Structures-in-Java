package oops.Inheritance;

public class C extends P {    // Child Class

	int d = 20;
	int d2 = 200;
	
	@Override		// Annotation 
	// fun() of P class is override by this function below:
	public void fun()
	{
		System.out.println("In C fun");
	}
	
	public void fun2()
	{
		System.out.println("In C fun2");
	}
}
