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
	private Song current;
	private int index;;
	
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
	
	public int getSize()
	{
		return songs.size();
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
	
	public MediaPlayer getMpCurrent()
	{
		return mpCurrent;
	}
	
	public Song getCurrent()
	{
		return current;
	}
	
	public void playFirst()
	{
		index = 0;
		current = getSong(index);
		mpCurrent = getMP(index);
		playSong(mpCurrent);	
	}
	
	public void playRandom()
	{
		int random = 0;
		do
		{
			random = (int) (Math.random()*mpSongs.size());
		} while (index == random);
		
		index = random;
		
		current = getSong(index);
		mpCurrent = getMP(index);
		playSong(mpCurrent);
		
	}
	
	public void playCurrentSong()
	{
		playSong(mpCurrent);
	}
	
	public void playSong(MediaPlayer s)
	{	
		//Song is playing
		s.play();
		
		mpCurrent.setOnEndOfMedia(new Runnable () {
			@Override
			public void run()
			{
				mpCurrent.stop();
				playNext();
			}
		});
	}
	
	public void playPrev()
	{
		if (index == 0)
		{
			index = mpSongs.size() - 1;
		}
		else
		{
			index--;
		}
		current = getSong(index);
		mpCurrent = getMP(index);
		playSong(mpCurrent);
	}
	public void playNext()
	{
		if (index < mpSongs.size() - 1)
		{
			index++;
		}
		else
		{
			index = 0;
		}
		current = getSong(index);
		mpCurrent = getMP(index);
		playSong(mpCurrent);
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
