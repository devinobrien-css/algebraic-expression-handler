/**Handles exceptions Stack content
 * @author Devin O'Brien
 * @version 1.0
 */
public class StackContentException extends Exception 
{
	/**Auto-generated Serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	
	/**Prints out error message
	 * @param ob - error message
	 */
	public StackContentException(String str)
	{
		System.out.println("--ERROR--");
		System.out.println(str + "\n");
		System.out.println(this.getMessage());
	}
}
