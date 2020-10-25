import java.util.ArrayList;
/**Converts infix equations to postfix and solves
 * @author Devin O'Brien 
 * @version 1.0
 */
public interface ExpressionInterface 
{
	/**Holds initial string
	 */
	public static String infix = null; 
	
	/**Stack
	 */
	public static GenericStack<String> stack = null;
	
	/**Holds postfix string 
	 */
	public static ArrayList<String> postfix = null;
	
	/**Converts equation from infix to postfix
	 * Precondition : An infix equation to be converted
	 * Postcondition : A postfix language representation of the infix equation
	 * @throws StackContentException if item not found or index out of range
	 * @throws StackUnderflowException if trying to pull from empty list
	 * @returns ArrayList of characters in postfix
	 */
	public ArrayList<String> infixToPost() throws StackUnderflowException, StackContentException;
	
	/**Evaluates a postfix expression
	 * Precondition : Infix formula converted to postfix formula and assembled 
	 * 				  as an ArrayList<String> 
	 * Postcondition : Returns integer value of solved postfix equation
	 * @throws StackUnderflowException if list isEmpty()
	 * @throws StackContentException if object not found
	 * @throws ContentException if item not present in list, Stack or String
	 * @returns answer of postfix equation 
	 */
	public int evaluate() throws StackContentException, StackUnderflowException, ContentException;
	
	/** Solves a two operand, one operator expression
	 * Precondition : parameters - two operands and an operator to be solved
	 * Postcondition : Returns answer of operator applied to two operands
	 * @param num1 - first operand
	 * @param num 2 - second operand
	 * @param oper - operator
	 * @returns value of equation
	 * @returns -1 if error
	 */
	public int solve(int num1,int num2,char oper);
	
	/** Deciphers whether character is or is (!) an operand
	 * Precondition : token of String equation being compared to
	 * 			      other typical symbols of an equation :
	 * 				  (, ), or an operator
	 * Postcondition : true if token is not (, ), or an operator
	 * @param x - token being checked
	 * @return true if object is not a parenthesis or operator
	 */
	public boolean isOperand(char x);
	
	/** Deciphers whether character is an operator or (!)
	 * Precondition : token of String equation being compared to operators
	 * Postcondition : true if object is an operator ( + , - , * , / , %)
	 * @param x - token being compared
	 * @return true if object is an operator
	 */
	public boolean isOperator(char x);

	/**Compares two operators(one sent, one from stack) to decipher algebraic precedence
	 * Precondition : Object sent to method for comparison against top item in stack
	 * Postcondition : Return -1 if Object sent is of lesser precedence than top of 
	 * 				   stack, 0 if Object sent is of equal precedence to top of 
	 *                 stack, or 1 if Object is of greater precedence
	 * @param x - operator sent to method
	 * @throws StackContentException if item not found || index out of list's range
	 * @throws StackUnderflowException if trying to pull an item from an empty list
	 * @returns -1 if operator is of lesser precedence than operator in stack
	 * @returns 0 if operator is of equal precedence to operator in stack
	 * @returns 1 if operator is of greater precedence than operator in stack
	 * @returns -2 if error || not an operator
	 */
	public int compareToAll(Object x) throws StackUnderflowException, StackContentException;
}
