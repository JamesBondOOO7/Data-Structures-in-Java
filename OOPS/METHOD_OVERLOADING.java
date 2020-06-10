package oops;

public class METHOD_OVERLOADING {

	public static void main(String[] args) {

		System.out.println(sum(2,3));
		System.out.println(sum(2,3,4));
		System.out.println(sum(2.1,3));
		System.out.println(sum(3.2,"hello"));
		int [] arr = {2,3,4,5,6};
		System.out.println(sum(arr));
		System.out.println(sum(2,3,4,5,6));
	}
	
	public static int sum(int a  , int b)
	{
		System.out.println("With 2 args");
		return a+b;
	}
	
	public static int sum(int a ,int b , int c)
	{
		System.out.println("With 3 args");
		return a+b+c;
	}
	
	public static double sum(double a , double b)
	{
		return a+b;
	}
	
	public static double sum( double a , String str)
	{
		return a;
	}
	
	public static int sum(int... args)
	{
		System.out.println("In variable args");
		int sum = 0;
		for(int val : args)
		{
			sum += val;
		}
		return sum;
	}

}
