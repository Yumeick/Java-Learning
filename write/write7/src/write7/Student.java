package write7;

public class Student {
	private String name;
	private int age;
	public Student(String name, int age) {
		this.name= name;
		this.age = age;
	}
	public void show() {
		System.out.println("I'm "+ name+ ", "+ age+ "years old.");
	}
}
