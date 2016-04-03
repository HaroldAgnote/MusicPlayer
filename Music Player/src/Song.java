import javafx.embed.swing.JFXPanel;
import javafx.scene.media.*;
import java.io.*;

public class Song
{
	private String fileName;
	private Media song;
	private static MediaPlayer player;
	
	public Song(String f)
	{
		JFXPanel fxPanel = new JFXPanel();
		
		fileName = f;
		
		song = new Media(new File(f).toURI().toString());
		player = new MediaPlayer(song);
	}
	
	public void playSong()
	{
		System.out.println(fileName + " is playing!");
		
		player.play();
		
	}
	
	public void pauseSong()
	{
		System.out.println(fileName + " has paused.");
		
		player.pause();
	}
	
	public void stopSong()
	{
		System.out.println(fileName + " has stopped.");
		
		player.stop();
	}
	
	public String toString()
	{
		return fileName;
	}
}
