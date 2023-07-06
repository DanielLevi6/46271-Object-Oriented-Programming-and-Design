package question3;

public class Main {
	public static void main(String[] args) {
		System.out.println("Starts the test");

		Expression staff_example = 	new Multiplication(
										 new Addition(
											 new DoubleValue(2.5),
											 new DoubleValue(3.5)
										 ),
										 new UnaryMinus(
											 new IntegerValue(5)
										 )
									 ); 
		

		Expression example2 = 		new Subtraction(
										 new Division(
											 new DoubleValue(5),
											 new DoubleValue(2)),
										 new UnaryMinus(
											 new Addition(
												new IntegerValue(5),
												new Multiplication(
													new IntegerValue(3),
													new DoubleValue(2.5)
												)
											)
										 )
									 );
		
		Expression example3 = 		new Multiplication(
										 new Division(
											 new DoubleValue(5),
											 new Addition(
												 new IntegerValue(2),
												 new DoubleValue(2)
											 )
										 ),
										 new Addition(
											 new Addition(
												new IntegerValue(5),
												new Multiplication(
													new IntegerValue(3),
													new DoubleValue(2.5)
												)
											),
											new Multiplication(
												new Addition(
													new DoubleValue(2.5),
													new IntegerValue(1)
												),
												new DoubleValue(1.25)
											)
										 )
									 );

		System.out.println(staff_example.toString() + " = " + staff_example.eval());
		System.out.println(example2.toString() + " = " + example2.eval());
		System.out.println(example3.toString() + " = " + example3.eval());
	}
}
