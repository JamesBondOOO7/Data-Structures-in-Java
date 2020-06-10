package oops;

public class Student_ExcHandling_Client {

	public static void main(String[] args) throws Exception // Dangerous function
	{
		
		Student_ExcHandling s1 = new Student_ExcHandling();
		
		s1.setAge(-10);
		
		System.out.println(s1.getAge());
	}
}
