package oops;

public class Student_ExcHandling {
	private String name;
	private int age;
	
	public void setAge(int age) throws Exception{	// Dangerous function
		if(age < 0)
		{
			throw new Exception("Age can't be negative");
		}
		
		this.age = age;
	}
	
	public int getAge()
	{
		return this.age;
	}
}
