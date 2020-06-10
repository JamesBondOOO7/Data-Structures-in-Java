package oops;

public class Student_Static {

	private String name;		// INSTANCE VARIABLES
	public final int roll ;
	
	public static final int MAX_STUDENTS = 50;	// STATIC VARIABLES
	private static int NoOfStudents = 0;
	public static String UniformColor = "White";
	
	public Student_Static(String name) throws Exception {
		if(NoOfStudents == MAX_STUDENTS) {
			throw new Exception("Max limit reached");
		}
		this.setName(name);		// Observe we are calling a function within the same class
		Student_Static.NoOfStudents++;
		this.roll = Student_Static.NoOfStudents;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) throws Exception {
		
		if(name == "" || name == null){
			throw new Exception("Names can't be null or empty String");
			}
		
		this.name = name;
	}
	public static int GetNumOfStudents()
	{
		return NoOfStudents;
	}
	
	// A non Static function
	public void ANonStaticFunction()
	{
		System.out.println(this.name + " number says hi to " + (Student_Static.NoOfStudents-1)  + " classmates.");
	}
	// It can work on static variables as well as non static (OBJECT / INSTANCE) variables.
	// this.name -> the student i.e object that calls for this function gets printed on the console
	
	
	// A Static function
	public static void AStaticFunction()
	{
		System.out.println(Student_Static.NoOfStudents + " out of " + Student_Static.MAX_STUDENTS + " say hi to teacher");
		
	}
	// works only with static variables
	// this.INSTANCE_VARIABLES -> can't be used
	
	
	public static void SetUniformColor(String UniformColor)
	{
		Student_Static.UniformColor = UniformColor;
	}
	
	public static String GetUniformColor()
	{
		return Student_Static.UniformColor;
	}
}
