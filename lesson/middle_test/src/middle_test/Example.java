package middle_test;

public class Example {
	public static void main(String[ ] args) {
		Triangle tri = new Triangle(3.0, 4.0, 5.0);
		tri.area( );
		tri.perimeter( );
		tri.introduce( );

		try {
			Triangle test = new Triangle(3,4,15);
			test.error();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		Circle cir = new Circle (5.0);
		cir.area( );
		cir.perimeter( );
		cir.introduce( );
		
		Ellipse ell = new Ellipse(5.0, 6.0);
		ell.area();
		ell.perimeter();
		ell.introduce();
		
		
		}
}
