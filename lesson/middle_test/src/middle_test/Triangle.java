
package middle_test;

public class Triangle implements Shape{
	private double a, b, c;
	public void error() {
		if ( (a+b < c) || (a+c < b) || (b+c < a) )
			throw new ArithmeticException("三角形两边之和不能大于第三条边，此三角形无效！");
	}
	public Triangle(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public double area( ) {
		double s, p;
		p=(a + b + c) / 2;
		s=Math.sqrt (p * (p-a) * (p-b) * (p-c));
		return s;
	}
	public double perimeter( ) {
		double per;
		per = a + b + c;
		return per;
	}
	public void introduce( ) {
		System.out.println(String.format("Triangle: a= %.2f; b= %.2f; c = %.2f; area = %.2f; perimeter = %.2f.",
				a, b, c, this.area(), this.perimeter()));
	}
}
