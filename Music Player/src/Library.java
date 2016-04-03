import java.util.*;
import java.io.*;

public class Library
{
	private LinkedList songs;
	private Song current;
	
	public Library()
	{
		songs = new LinkedList();
		
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
				try 
				{
					songs.add(new Song(listOfFiles[i].getCanonicalPath().toString()));
				}
				catch (IOException e) 
				{
					System.out.println("Something Happened");
				}
			}
		}
	}
	
	public Song getSong(int i)
	{
		return songs.get(i).getValue();
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
	
	public void playSong(Song s)
	{
		s.playSong();
	}
	
	public void pausePlayback()
	{
		current.pauseSong();
	}
	
	public void stopPlayback()
	{
		current.stopSong();
	}
}
