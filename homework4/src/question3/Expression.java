package question3;

/** The Expression interface is an interface for mathematical expressions.
*
* The class provides methods for evaluating the expression and represent it as a String.
*
*/
public interface Expression {
    // Abstraction Function:
    // An interface for representing a mathematical expression.
	// A mathematical expression must implement this interface.
	
	/**
	 * Calculates the result of the expression
	 * 
	 * @returns The result value of the mathematical expression
	 */
	public double eval();
	
	/**
	 * Returns a string representation of the expression
	 * 
	 * @returns String which represents the expression
	 */
	public String toString();
}
