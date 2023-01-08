package middle_test;

public class Circle implements Shape{
	protected double r;
	protected final double PI = 3.1415;
	public Circle (double r) {
		this.r = r;
	}
	public double area( ) {
		double s;
		s = PI * r * r;
		return s;
	}
	public double perimeter( ) {
		double c;
		c = 2 * PI * r;
		return c;
	}
	public void introduce( ) {
		System.out.println(String.format("Circle: r = %.2f; area = %.2f; perimeter = %.2f.", r, this.area(), this.perimeter()));
	}
}
