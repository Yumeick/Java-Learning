package write7;

public class Undergraduate extends Student {
	private String degree;
	public Undergraduate(String name, int age, String degree) {
		super(name, age);
		this.degree= degree;
	}
	public void show() {
		super.show();
		System.out.println("I'm studying for "+degree+".");
	}
}
