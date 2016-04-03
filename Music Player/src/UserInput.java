import java.util.Scanner;

/**
 * This class is used to take in User Inputs, check if the inputs are valid
 * and return them to the program it was called upon.
 * @author Harold Agnote
 *
 */
public class UserInput 
{
	/**
	 * This method is called when the user needs to input a Integer value
	 * (i.e. 2.3). The method assures the value inputted is a Double and
	 * not a String and then returns the value to the program it was called.
	 * @return	A Double value inputted by the user.
	 */
	public static double getDecimal()
	{
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		double validNum = 0.0;
		while( !valid ) {
			if(in.hasNextDouble()){
				validNum = in.nextDouble();
				valid = true;
			} else {
				in.next();
				System.out.println("Invalid");
			}
		}
		return validNum;
	}
	
	/**
	 * This method is called when the user needs to input an Integer value
	 * (i.e. 5). The method assures the value inputted is a Integer and
	 * not a String and then returns the value to the program it was called.
	 * @return	A Integer value inputted by the user
	 */
	public static int getInt()
	{
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		int validNum = 0;
		while( !valid ) {
			if( in.hasNextInt() ) {
				validNum = in.nextInt();
				valid = true;
			} else {
				in.next();
				System.out.println("Invalid");
			}
		}
	return validNum;
	}
	
	/**
	 * This method is called when the user needs to input a Decimal value
	 * within a given range. For instance if a value needs to be inputted
	 * between the numbers 1 - 5, 3 would be a valid input while 0 or 6 would
	 * not. The method assures that the value inputted is a Integer and not
	 * a String and then returns the value to the program it was called.
	 * @param low	The first value within the range
	 * @param high	The last value within the range
	 * @return	A Integer value inputted by the user.
	 */
	public static int getInt(int low, int high)
	{
		Scanner in = new Scanner(System.in);
		boolean valid = false;
		int validNum = 0;
		while( !valid )
		{
			if( in.hasNextInt() )
			{
				validNum = in.nextInt();
				if(validNum >= low && validNum <= high)
				{
					valid = true;
				}
				else
				{
					System.out.println("Error - Input not in Range");
				}
			}
			else 
			{
				in.next();
				System.out.println("Error - Input is not an Integer");
			}
		}
		return validNum;
	}
	
	/**
	 * This method gets a simple String Input from the user, with no spaces or
	 * returns accounted. 
	 * @return	A single String input from the user
	 */
	public static String getInput()
	{
		Scanner input = new Scanner(System.in);
		return input.next();
	}
	
	/**
	 * This method gets a String Input from the user of an entire line, thereby
	 * accounting for the spaces in between the texts. 
	 * @return	A String input from the user.
	 */
	public static String getInputLine()
	{
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}
	
	/**
	 * This method accepts a Y/N input String from the User and 
	 * returns the result as an integer, 1 or 2.
	 * @return	An integer value of 1 or 2 representing Y or N.
	 */
	public static int getYesNo()
	{
		Scanner input = new Scanner(System.in);
		boolean valid = false;
		int validNum = 0;
		while (!valid)
		{
			String in = input.next();
			if (in.equalsIgnoreCase("Y"))
			{
				validNum = 1;
				valid = true;
			}
			else if (in.equalsIgnoreCase("N"))
			{
				validNum = 2;
				valid = true;
			}
			else
			{
				System.out.println("Error - Invalid Input");
				System.out.println("Please Try Again");
			}
		}
		return validNum;
	}
}

