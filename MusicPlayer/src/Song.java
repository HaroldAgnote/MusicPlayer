import javafx.embed.swing.JFXPanel;
import javafx.scene.media.*;
import java.io.*;

public class Song
{
	private String fileName;
	
	public Song(String f)
	{
		JFXPanel fxPanel = new JFXPanel();
		
		fileName = f;
	}
	
	public String toString()
	{
		return fileName;
	}
	
}
