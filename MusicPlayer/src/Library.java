import java.util.*;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.*;

public class Library
{
	private ArrayList <Song> songs;
	private ArrayList <MediaPlayer> mpSongs;
	private MediaPlayer mpCurrent;
	private Song current; //Update Current Song
	private int i;
	public Library()
	{
		songs = new ArrayList <Song> ();
		mpSongs = new ArrayList <MediaPlayer> ();
		
		addFromFolder();
	}
	
	public void addFromFolder()
	{
		
		JFXPanel jfx = new JFXPanel();
		
		String folderName = "Songs";
		
		File folder = new File(folderName);
		
		if (folder.isDirectory())
		{
			File[] listOfFiles = folder.listFiles();
			for (int i = 0; i < listOfFiles.length; i++)
			{
				String fileName = listOfFiles[i].toURI().toString();
				Media song = new Media (fileName);
				songs.add(new Song(fileName));
				mpSongs.add(new MediaPlayer(song));
			}
		}
	}
	
	public MediaPlayer getMP(int i)
	{
		//Update Current Song
		mpCurrent = mpSongs.get(i);
		return mpCurrent;
	}
	public Song getSong(int i)
	{
		current = songs.get(i);
		return current;
	}
	
	public void playFirst()
	{
		//Update Current Song
		mpCurrent = getMP(0);
		playSong(mpCurrent);
		current = getSong(0);
		
	}
	
	public void playRandom()
	{
		//Update Current Song
		int random = (int) (Math.random()*mpSongs.size());
		mpCurrent = getMP(random);
		playSong(mpCurrent);
		current = getSong(random);
	}
	
	public void playSong(MediaPlayer s)
	{	
		//Song is playing
		s.play();
	
	}
	public void playNext(MediaPlayer N)
	{
		
		current = getSong(i +1);
		mpCurrent = getMP(i+1);
	}
	
	public void pausePlayback()
	{
		//Song is paused
		mpCurrent.pause();
		System.out.println(current + " is paused");
	}
	
	public void stopPlayback()
	{
		//Song has stopped
		mpCurrent.stop();
		System.out.println(current + " is stopped");
	}
	
	public void displaySongs()
	{
		for (int i = 0; i < mpSongs.size(); i++)
		{
			System.out.println((i + 1) + ". " + songs.get(i));
		}
	}
}
