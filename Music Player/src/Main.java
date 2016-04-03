import java.io.*;
import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Library main = new Library();
		
		boolean done = false;
		
		while (!done)
		{
			displayMenu();
			int menu = UserInput.getInt(1, 5);
			switch (menu)
			{
				case 1: main.playFirst();
						break;
				case 2: main.playRandom();
						break;
				case 3: System.out.println("NOT READY YET!!!");
						break;
				case 4: main.pausePlayback();
						break;
				case 5: main.stopPlayback();
						break;
				default:main.stopPlayback();
						done = true;
						break;
			}
		}
		
	}
	
	public static void displayMenu()
	{
		System.out.println("1. Play First");
		System.out.println("2. Play Random");
		System.out.println("3. Play Chosen");
		System.out.println("4. Pause");
		System.out.println("5. Stop");
		System.out.println("6. Quit");
	}
	
}
