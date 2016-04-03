import javafx.embed.swing.JFXPanel;
import javafx.scene.media.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Song
{
	private String fileName;
	private String songName;
	
	public Song(String f)
	{		
		fileName = f;
		
		songName = fileName.substring(56);
		songName = songName.replace(".mp3", "");
		songName = songName.replaceAll("(\\p{Ll})(\\p{Lu})","$1 $2");
	}
	
	public String toString()
	{
		return songName;
	}
	
}
