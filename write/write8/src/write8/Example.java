package write8;

public class Example {
	public static void main(String[] args) {
		Circle cir= new Circle();
		System.out.println(String.format("Circle: area= %.2f", cir.area(3)));
		Square squ= new Square();
		System.out.println(String.format("Square: area= %.2f",squ.area(2)));
	}
}
