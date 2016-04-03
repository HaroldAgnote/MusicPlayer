import java.util.*;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.*;

public class Library
{
	private ArrayList <MediaPlayer> songs;
	private MediaPlayer current;
	
	public Library()
	{
		songs = new ArrayList <MediaPlayer> ();
		
		addFromFolder();
	}
	
	public void addFromFolder()
	{
		
		String folderName = "Songs";
		
		File folder = new File(folderName);
		
		if (folder.isDirectory())
		{
			File[] listOfFiles = folder.listFiles();
			for (int i = 0; i < listOfFiles.length; i++)
			{
				Media song = new Media (listOfFiles[i].getAbsolutePath());
				songs.add(new MediaPlayer(song));
			}
		}
	}
	
	public MediaPlayer getSong(int i)
	{
		current = songs.get(i);
		return current;
	}
	
	public void playFirst()
	{
		current = getSong(0);
		playSong(current);
	}
	
	public void playRandom()
	{
		int random = (int) (Math.random()*songs.size());
		current = getSong(random);
		playSong(current);
	}
	
	public void playSong(MediaPlayer s)
	{
		s.play();
	}
	
	public void pausePlayback()
	{
		current.pause();
	}
	
	public void stopPlayback()
	{
		current.stop();
	}
	
	public void displaySongs()
	{
		for (int i = 0; i < songs.size(); i++)
		{
			System.out.println((i + 1) + ". " + getSong(i));
		}
	}
}
