package middle_test;

public class Ellipse extends Circle {
	private double r2;
	public Ellipse(double r, double r2) {
		super(r);
		this.r2 = r2;
	}
	public double area() {
		double s;
		s = PI * r * r2;
		return s;
	}
	public double perimeter() {
		double c;
		if(r2 > r)
			c=2 * PI * r + 4 * (r2-r);
		else
			c=2 * PI * r2 + 4 * (r-r2);
		return c;
	}
	public void introduce() {
		System.out.println(String.format("Ellipse:r1= %.2f; r2= %.2f; area= %.2f; perimeter= %.2f.",
				r, r2, this.area(), this.perimeter() ));
	}
}
