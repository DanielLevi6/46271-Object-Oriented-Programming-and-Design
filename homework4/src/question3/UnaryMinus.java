package question3;

/**
 * A class for representing an Unary Minus operator as an Expression
 * 
 */
public class UnaryMinus implements Expression {
    // Abstraction Function:
	// Represents an Unary Minus operator as an Expression
	// 
	// Provides methods for returning the value of the stored expression to the user
	// after applying unary minus operation on it, and a method returning the 
	// Unary Minus operation represented as a String
	
    // Representation invariant:
    //      expression != null
	private Expression expression;

	/**
	 * Creates a new object which wraps the Unary Minus operator
	 * 
	 * @requires expression != null
	 * @param expression the expression to apply the unary minus operator on
	 */
	public UnaryMinus(Expression expression) {
		this.expression = expression;
		checkRep();
	}
	
	/**
	 * Calculates the result of the expression, which is the unary minus of the stored expression
	 * 
	 * @returns The result value of the mathematical expression
	 */
	public double eval() {
		checkRep();
		return - this.expression.eval();
	}
	
	/**
	 * Returns a string representation of the unary minus operation
	 * 
	 * @returns String which represent the subtraction operator implemented by the object
	 */
	public String toString() {
		checkRep();
		return "(-" + this.expression.toString() + ")";
	}
	
    /**
     * @effects checks the Rep. Invariant on the object, and throws an error accordingly
     *
     * @throws AssertionError if the Rep. Invariant was not fulfilled
     */
    private void checkRep() {
    	assert this.expression != null : "the stored expression is null";
    }

}
