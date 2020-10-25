import java.util.ArrayList;
/**Converts equation to postfix and solves
 * @author Devin O'Brien
 * @version 1.0
 */
public class Expression implements ExpressionInterface
{
	/**Holds infix equation as String
	 */
	private String infix; 
	
	/**Stack of type String to hold operands, operators, or parentheses
	 */
	private GenericStack<String> stack;
	
	/**Holds postfix String from infixToPost() method 
	 */
	private ArrayList<String> postfix;
	
	/**Default Constructor Assignments
	 * Precondition : N/A
	 * Postcondition : empty infix String && empty Stack
	 */
	Expression()
	{
			infix = null;
			stack = null;
			
	}
	
	/**Assigns value to infix String
	 * Precondition : String equation sent to method
	 * Postcondition : String assigned to infix String, Stack initialized
	 * @param str - String representation of formula
	 */
	Expression(String str)
	{
		infix = str;
		stack = new GenericStack<String>();
	}
	
	/**Converts equation from infix to postfix
	 * Precondition : An infix equation to be converted
	 * Postcondition : A postfix language representation of the infix equation
	 * @return ArrayList of characters in postfix
	 */
	public ArrayList<String> infixToPost() 
	{
		ArrayList<String> postfix = new ArrayList<>(); 
		char[] array = infix.toCharArray();

		/* HEADER:
		 * print out equation & separate from operation
		 */
		System.out.print("Processing info on equation : ");
		for(char obj : array)
			System.out.print(obj);
		System.out.println("\n--------------------------------------------");
		
		try
		{
			for(int i = 0; i < infix.length(); i++) //as long as there are more tokens, get next token
			{
				if(isOperand(array[i]) && !isOperator(array[i])) // if isOperand(), 
				{
					System.out.println(array[i] + " <- operand");
					postfix.add(array[i] + ""); // append to postfix String
				}
				else if(array[i] == '(') // else if is (,
				{
					System.out.println(array[i] + " <- \'(\'");
					stack.push(array[i] + ""); // push to stack
				}
				else if(isOperator(array[i])) // else if isOperator(), (order by precedence)
				{
					System.out.println(array[i] + " <- operator");
					if(stack.isEmpty()) // if stack isEmpty(),
					{
					  stack.push(array[i] + ""); // push to stack
					}
					else // if stack (!) isEmpty()
					{
							if(stack.peek() == "(")
								stack.push(array[i] + "");
							else
							{
								while(!stack.isEmpty() && stack.peek() != "(" && compareToAll(array[i]) == -1) //while (!) ( && is of lesser precedence && stack is not empty 
								{
									postfix.add(stack.pop() + ""); // pop operators of greater or equal precedence
								}
								stack.push(array[i] + ""); // then push new operator to stack
							}
					}
				}
				else if(array[i] == ')') // if ) is encountered,
				{
					System.out.println(array[i] + " <- \')\'");
						while(isOperator(stack.peek().charAt(0)) && stack.peek() != "(") // while top of stack is an operand within the parenthesis 					
						{
							postfix.add(""+stack.pop()); // remove token from stack and append to post fix
						}
						stack.pop(); // removes (
				}
			}
			while(!stack.isEmpty()) // when end of infix reached, append remaining contents of stack 
			{
				postfix.add(""+stack.pop());
			}
		}
		catch(StackContentException e)
		{
			System.out.println("\n--ERROR--\n");
			System.out.println("->item may not exist in stack\n");
			System.out.println("->"+e.getMessage());
		}
		return postfix;
	}
	
	/**Evaluates a postfix expression
	 * Precondition : Infix formula converted to postfix formula and assembled 
	 * 				  as an ArrayList<String> 
	 * Postcondition : Returns integer value of solved postfix equation
	 * @throws ContentException if item not present in String, list or stack
	 * @returns answer of postfix equation 
	 */
	public int evaluate() throws ContentException
	{
		try
		{
			postfix = infixToPost();  
			//assembles string of postfix
			System.out.print("Postfix Equation: ");
			for(int i = 0; i < postfix.size(); i++)
			{
				System.out.print(postfix.get(i)); 
			}
			System.out.println();
			for(int i = 0; i < postfix.size(); i++)
			{
				if(isOperand(postfix.get(i).charAt(0))) // when isOperand()
					stack.push(postfix.get(i)); // push to stack
				else if(isOperator(postfix.get(i).charAt(0)))	// when is operator
					stack.push(""+solve(Integer.parseInt(stack.pop()),
							    Integer.parseInt(stack.pop()), postfix.get(i).charAt(0))); 
								// solve w/ past two operands and push to stack 
				else
					throw new ContentException("Expression.evaluate() -> invalid input for: " + postfix.get(i));
			}
			return Integer.parseInt(stack.pop());
		}
		catch(StackContentException e)
		{
			System.out.println("\n--ERROR--\n");
			System.out.println("->item may not exist in stack\n");
			System.out.println("->"+e.getMessage());
		}
		return -1;
	}
	
	/** Solves a two operand, one operator expression
	 * Precondition : parameters - two operands and an operator to be solved
	 * Postcondition : Returns answer of operator applied to two operands
	 * @param num1 - first operand
	 * @param num 2 - second operand
	 * @param oper - operator
	 * @returns value of equation
	 * @returns -1 if error
	 */
	public int solve(int num1,int num2,char oper)
	{
		if(oper == '+')
			return num1 + num2;
		  else if(oper == '-')
			  return num2 - num1; // second pop() - first pop()
		    else if(oper == '/')
		  	    return num2 / num1; // second pop() / first pop()
		      else if(oper == '*')
			    return num1 * num2; 
		        else
		          return -1;
	}
	
	/** Deciphers whether character is or is (!) an operand
	 * Precondition : token of String equation being compared to
	 * 			      other typical symbols of an equation :
	 * 				  (, ), or an operator
	 * Postcondition : true if token is not (, ), or an operator
	 * @param x - token being checked
	 * @return true if object is not a parenthesis or operator
	 */
	public boolean isOperand(char x)
	{
		// if the token is (, ), or an operator return false
		return (x != '(' && x != ')') && !isOperator(x);
		
	}
	
	/** Deciphers whether character is an operator or (!)
	 * Precondition : token of String equation being compared to operators
	 * Postcondition : true if object is an operator ( + , - , * , / , %)
	 * @param x - token being compared
	 * @return true if object is an operator
	 */
	public boolean isOperator(char x)
	{
		return (x == '+'||x == '-'||x == '*'||x == '/'||x == '%');
	}

	/**Compares two operators(one sent, one from stack) to decipher algebraic precedence
	 * Precondition : Object sent to method for comparison against top item in stack
	 * Postcondition : Return -1 if Object sent is of lesser precedence than top of 
	 * 				   stack, 0 if Object sent is of equal precedence to top of 
	 *                 stack, or 1 if Object is of greater precedence
	 * @param x - operator sent to method
	 * @return -1 if operator is of lesser precedence than operator in stack
	 * @return 0 if operator is of equal precedence to operator in stack
	 * @return 1 if operator is of greater precedence than operator in stack
	 * @return -2 if error || not an operator
	 */
	public int compareToAll(Object x) 
	{
		try
		{
			if(x == "+"|| x == "-") 
				if(stack.peek() == "+"||stack.peek() == "-") // equal precedence
					return 0;
				else // if == * || / , therefore x -> lesser precedence
					return -1;
			else if(x == "*"|| x == "/") 
				if(stack.peek() == "+"||stack.peek() == "-") // greater precedence
					return 1;
				else // equal precedence
					return 0;
			else 
				return -2; //signifies error
		}
		catch(StackContentException e)
		{
			System.out.println("\n--ERROR--\n");
			System.out.println("->item may not exist in stack\n");
			System.out.println("->"+e.getMessage());
		}
		return -2;

	}
}
