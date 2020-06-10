package oops;

public class Student_StaticClient {

	public static void main( String args[]) throws Exception {	// Observe the change
		
		// Array of data type : Student_Static
		Student_Static [] Student = new Student_Static[50];
		
		// Assigning the values of the objects through constructor
		for(int i = 0 ; i<50 ; i++)
		{
			Student[i] = new Student_Static(i + "th");
			System.out.println(Student[i].roll);
			// Gives the same output
		}
		
		// Student_Static.MAX_STUDENTS = 100;
		// Student[7].roll = 10;
		// This shows an error as it has the final keyword in it
		System.out.println(Student_Static.MAX_STUDENTS);
		// But it is accessible due to the keyword " public "
		
		System.out.println(Student_Static.GetNumOfStudents());
		// as number of students i.e NoOfStudents is private
		// therefore function is used
		
		Student[5].ANonStaticFunction();
		// Student_Static.ANonStaticFunction();
		// Gives error as Class calls a non static function which
		// includes some INSTANCE/OBJECT variables.
		
		Student[5].AStaticFunction();
		// See possible but not preferred
		// Because we are calling STATIC/CLASS function through an object
		
		Student_Static.AStaticFunction();
		// Class is referred to call static functions
		Student[20].UniformColor = "Blue";
		// See possible but not preferred
		// Because we are calling STATIC/CLASS variables through an object
		
		System.out.println(Student_Static.GetUniformColor());
		System.out.println(Student[25].GetUniformColor());
		// See possible but not preferred
		// Because we are calling STATIC/CLASS function through an object
		// color of student 25 changes so as the color of the rest of the class variable UniformColor
		
		Student_Static.UniformColor = "Red";
		System.out.println(Student_Static.GetUniformColor());
		System.out.println(Student[35].GetUniformColor());
		
	}
}
