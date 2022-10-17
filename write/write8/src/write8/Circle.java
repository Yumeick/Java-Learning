package write8;

public class Circle implements Shape {
	protected final static double PI = 3.1415;
	public double area(double r) {
		return PI * r * r;
	}
}
