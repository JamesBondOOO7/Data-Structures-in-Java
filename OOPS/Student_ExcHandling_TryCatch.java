package oops;

public class Student_ExcHandling_TryCatch {

	public static void main(String[] args) // Handling danger 
	{
		Student_ExcHandling s1 = new Student_ExcHandling();
		
		try {
			System.out.println("Setting age");
			s1.setAge(-10);
			System.out.println("Age set successfully");
		}catch(Exception e)
		{
			System.out.println("Invalid input");
		}
		finally
		{
			System.out.println("I am executed always");
		}
		
		System.out.println(s1.getAge());
	}

}
