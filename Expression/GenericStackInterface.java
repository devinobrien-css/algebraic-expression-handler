/**Full Functional Stack
 * @author Devin O'Brien
 * @param <E> type specifier for node of stack
 */
public interface GenericStackInterface<E>
{	
	/**This gets the size of the stack as an int
	 * @return size of the stack as integer
	 */
	public int getSize();
	
	/**Returns the last object of the stack
	 * @return the most recent added object of the stack
	 * @throws StackContentException 
	 */
	public E peek() throws StackContentException;
	
	/**Returns a reference to the last object of the stack and remove it.
     * @return reference to the last object in the stack
	 * @throws StackContentException 
     */
	public E pop() throws StackContentException;

    /**Pushes an object onto the stack.
     * @param cast The object being pushed
     */
	public void push(E o);
	
	/**Returns true if is empty
	 * @return true if Stack is empty
	 */
    public boolean isEmpty();

    /**Returns a String representation of this element 
     * @return String representation of this element
     */
    public String toString();
}
