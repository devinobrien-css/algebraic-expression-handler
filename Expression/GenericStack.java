import java.util.ArrayList;
/**Coordinates data into a FIFO stack
 * @author Devin O'Brien
 * @version 1.0
 * @param <E> type specifier for nodes of stack
 */
public class GenericStack<E> implements GenericStackInterface<E>
	{
	
	/**Holds the elements of the list. 
	 */
	private ArrayList<E> stack;

	/**Default constructor that instantiates a new array list of size 8.  
	 */
	GenericStack()
	{
		stack = new ArrayList<E>(8);
	}
	
	/**Returns the current size of this stack.  
	 * @return current size of this stack.
	 */
	public int getSize()
	{
		return stack.size();
	}
	
	/**Returns the last object of the stack
	 * @return E the last object of the stack
	 * @throws StackContentException if list is empty
	 */
	public E peek() throws StackContentException
	{
		if(this.isEmpty())
			throw new StackContentException("Error: attempting to fetch a reference from an empty list.");
		return stack.get(getSize()-1);
	}
	
	/**Gets the last object in the stack and then removes it.
     * @return the last object in the stack
     * @throws StackContentException if list is empty
     */
	public E pop() throws StackContentException
    {
		if(this.isEmpty())
			throw new StackContentException("Error: attempting to fetch a reference from an empty list."); 
		
        E temp = stack.get(getSize() - 1);
        stack.remove(getSize() - 1);
        return temp;
    }

    /**Pushes an object onto the stack.
     * @param obj - object being added to the stack
     */
	public void push(E obj) 
    {
		stack.add(obj);
    }
	
	/**Returns true if stack is empty 
	 * @return true if stack is empty
	 */
    public boolean isEmpty() 
    {
        return stack.isEmpty();
    }

    /**Returns String value of stack
     * @return String representation of stack
     */
    public String toString() 
    {
    	if(this.isEmpty())
    		return "Error: list is empty";
    	String str = "";
        for(int i = 0; i < this.getSize() - 1; i++)
        {
        	str += stack.get(i);
        }
        return str;
    }
	  
}
