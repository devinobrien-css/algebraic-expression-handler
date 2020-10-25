import java.io.*;
import java.util.*;
/**Executes test runs on Expression class
 * @author Devin O'Brien
 * @version 1.0
 */
public class Driver 
{
	/**Initiates test runs
	 * Precondition : N/A
	 * Postcondition : Test runs performed on Expression class
	 * @param args String array of command-line arguments
	 * @throws FileNotFoundException if file is not located
	 * @throws ContentException if item not present in list, String or Stack
	 */
	public static void main(String[] args) throws FileNotFoundException, ContentException 
	{
		System.out.println("Expression Tests: \n" +
	                       "----------------");
		start();
	}

	/**Begins test runs on Expression class
	 * Precondition : N/A
	 * Postcondition: Tests ran on five different algebraic expressions
	 * @throws FileNotFoundException if File not found in src
	 * @throws ContentException if item not present in list, array or String
	 */
	public static void start() throws FileNotFoundException, ContentException
	{
		ArrayList<String> list = fromFile();
		Expression exp1 = new Expression(list.get(0));
		  System.out.println("Answer:" + exp1.evaluate() + "\n");
		  
		Expression exp2 = new Expression(list.get(1));
		  System.out.println("Answer:" + exp2.evaluate() + "\n");
		  
		Expression exp3 = new Expression(list.get(3));
		  System.out.println("Answer:" + exp3.evaluate() + "\n");
		  
		Expression exp4 = new Expression(list.get(4));
		  System.out.println("Answer:" + exp4.evaluate() + "\n");
		  
		Expression exp5 = new Expression(list.get(5));
		  System.out.println("Answer:" + exp5.evaluate() + "\n");
	}
	/**Pulls data from file input.txt
	 * Precondition : Pulls formulas from each line of file
	 * Postcondition : Returns assembled ArrayList<String> of equations
	 * @return ArrayList of equations
	 * @throws FileNotFoundException if File not found in src
	 */
	public static ArrayList<String> fromFile() throws FileNotFoundException
	{
		Scanner read = new Scanner(new File("input.txt")); //FILE LOCATION
		ArrayList<String> list = new ArrayList<String>(5);
		while(read.hasNextLine())
		{
			list.add(read.nextLine());
		}
		read.close();
		return list;
	}
}
