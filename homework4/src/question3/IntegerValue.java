package question3;

/**
 * A class for representing an integer value as an Expression
 * 
 */
public class IntegerValue implements Expression {
    // Abstraction Function:
	// Represents an integer value as an Expression
	// 
	// Provides methods for returning the integer value to the user
	// and returning the value as a String

	private int val;

	
	/**
	 * Creates a new object which wraps the integer value
	 * 
	 * @param new_val the integer value to write into the new object
	 */
	public IntegerValue(int new_val) {
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
	 * @returns String which represent the integer value stored in the class
	 */
	public String toString() {
		return String.valueOf(this.val);
	}
	
	
}
