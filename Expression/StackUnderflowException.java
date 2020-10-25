/**Handles exceptions for attempting to pull from empty Stack
 * @author Devin O'Brien
 * @version 1.0
 */
public class StackUnderflowException extends Exception 
{
	/**Auto-generated Serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**Prints out error message
	 * @param str - error message
	 */
	public StackUnderflowException(String str)
	{
		System.out.println("\n--ERROR--\n");
		System.out.println(str + "\n");
		System.out.println(this.getMessage());
	}
}
