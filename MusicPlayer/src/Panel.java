import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Panel extends JPanel implements ActionListener
{
	JPanel cards, card1, card2, card3;
	JLabel songInfo;
	JCheckBox shuffle;
	JButton play, pause, stop, next;	
	
	Library main = new Library();
	boolean start = false;
	
	public Panel()
	{
		cards = new JPanel(new CardLayout());
		card1 = new JPanel();
		card2 = new JPanel();
		card3 = new JPanel();
		songInfo = new JLabel("No Song Playing");
		
		play = new JButton("Play");
		play.addActionListener(this);
		next = new JButton("Next");
		next.addActionListener(this);
		pause = new JButton("Pause");
		pause.addActionListener(this);
		stop = new JButton("Stop");
		stop.addActionListener(this);
		shuffle = new JCheckBox("Shuffle");
		
		card1.add(songInfo);
		add(card1);
		card2.add(play);
		card2.add(pause);
		card2.add(next);
		card2.add(stop);
		add(card2);
		card3.add(shuffle);
		add(card3);
	}
	
	public void actionPerformed(ActionEvent a) 
	{
		if (a.getSource() == play)
		{
			if (!start)
			{
				main.playFirst();
				start = true;
			}
			else
			{
				main.playCurrentSong();
			}
		}
		if (a.getSource() == next)
		{
			main.stopPlayback();
			if (shuffle.isSelected())
			{
				main.playRandom();
			}
			else
			{
				main.playNext();
			}
		}
		if (a.getSource() == pause)
		{
			main.pausePlayback();
		}
		
		if (a.getSource() == stop)
		{
			main.stopPlayback();
		}
	}

}
