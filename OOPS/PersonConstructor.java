package oops;

public class PersonConstructor {

		private String name ;
		private int age ;
		
		public PersonConstructor()
		{
			System.out.println("I am in the default constructor");
		}
		
		public PersonConstructor( int age)
		{
			System.out.println("I am in the parameterised constructor with 1 parameter");
			this.age = age;
		}
		
		public PersonConstructor(int age , String name)
		{
			System.out.println("I am in the parameterised constructor with 2 parameters");
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
}
