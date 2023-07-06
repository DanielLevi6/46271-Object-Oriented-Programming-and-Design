package question3;

/**
 * A class for representing an Multiplication operator as an Expression
 * 
 */
public class Multiplication implements Expression {
    // Abstraction Function:
	// Represents an Multiplication operator as an Expression
	// 
	// Provides methods for returning the result value of the multiplication to the user
	// and a method returning the Multiplication operation represented as a String
	
    // Representation invariant:
    //      expression1 != null
	//		expression2 != null
	private Expression expression1;
	private Expression expression2;

	/**
	 * Creates a new object which wraps the Multiplication operator
	 * 
	 * @requires expression1 != null, expression2 != null
	 * @param expression1 the left side expression of the multiplication
	 * @param expression2 the right side expression of the multiplication
	 */
	public Multiplication(Expression expression1, Expression expression2) {
		this.expression1 = expression1;
		this.expression2 = expression2;
		checkRep();
	}
	
	/**
	 * Calculates the result of the expression, which is the multiplication between
	 * the two expressions stored in the object
	 * 
	 * @returns The result value of the mathematical expression
	 */
	public double eval() {
		checkRep();
		return this.expression1.eval() * this.expression2.eval();
	}
	
	/**
	 * Returns a string representation of the multiplication operator
	 * 
	 * @returns String which represent the multiplication operation implemented by the object
	 */
	public String toString() {
		checkRep();
		return "(" + this.expression1.toString() + " * " + this.expression2.toString() + ")";
	}
	
    /**
     * @effects checks the Rep. Invariant on the object, and throws an error accordingly
     *
     * @throws AssertionError if the Rep. Invariant was not fulfilled
     */
    private void checkRep() {
    	assert this.expression1 != null : "expression1 is null";
    	assert this.expression2 != null : "expression2 is null";
    }
}
