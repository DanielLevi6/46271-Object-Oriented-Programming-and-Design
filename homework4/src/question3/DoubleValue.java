package question3;

/**
 * A class for representing a double value as an Expression
 * 
 */
public class DoubleValue implements Expression {
    // Abstraction Function:
	// Represents a double value as an Expression
	// 
	// Provides methods for returning the double value to the user
	// and returning the value as a String

	private double val;
	
	
	/**
	 * Creates a new object which wraps the double value
	 * 
	 * @requires val != null
	 * @param new_val the double value to write into the new object
	 */
	public DoubleValue(double new_val) {
		this.val = new_val;
	}
	
	/**
	 * Calculates the result of the expression, which is the the value stored in the class
	 * 
	 * @returns The result value of the mathematical expression, which is val in that case
	 */
	public double eval() {
		return val;
	}
	
	/**
	 * Returns a string representation of the val stored in this class
	 * 
	 * @returns String which represent the double value stored in the class
	 */
	public String toString() {
		return "(" + String.valueOf(this.val) + ")";
	}
	
}
