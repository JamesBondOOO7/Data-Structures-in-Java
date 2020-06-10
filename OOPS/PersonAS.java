package oops;

public class PersonAS {
	private String name ;		// private -> accessible within the class
	private int age ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {		// public -> accessible or visible everywhere
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
