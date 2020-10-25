/**Handles exceptions catering to the contents of the Stack
 * @author Devin O'Brien
 * @version 1.0
 */
public class ContentException extends Exception 
{
	/**Auto-generated Serial Version UID
	 */
	private static final long serialVersionUID = 1L;
	/**Prints out error message
	 * @param str - error message
	 */
	ContentException(String str)
	{
		System.out.println("--ERROR--");
		System.out.println(str + "\n");
		System.out.println(this.getMessage());
	}
}
