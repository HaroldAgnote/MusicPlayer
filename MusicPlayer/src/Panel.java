import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Panel extends JPanel implements ActionListener
{
	JPanel cards, card1, card2, card3;
	JLabel songInfo;
	JCheckBox shuffle;
	JButton prev, play, pause, stop, next;
	JTextArea playlist;
	
	Library main = new Library();
	boolean start = false;
	
	public Panel()
	{
		cards = new JPanel(new CardLayout());
		card1 = new JPanel();
		card2 = new JPanel();
		card3 = new JPanel();
		
		songInfo = new JLabel("No Song Playing");
		
		prev = new JButton("Prev");
		prev.addActionListener(this);
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
		add(shuffle);
		
		card2.add(play);
		card2.add(pause);
		card2.add(prev);
		card2.add(next);
		card2.add(stop);
		add(card2);
	}
	
	public void actionPerformed(ActionEvent a) 
	{
		if (a.getSource() == prev)
		{
			main.stopPlayback();
			if (shuffle.isSelected())
			{
				main.playRandom();
				songInfo.setText(main.getCurrent().toString());
			}
			else
			{
				main.playPrev();
				songInfo.setText(main.getCurrent().toString());
			}
		}
		
		if (a.getSource() == play)
		{
			if (!start)
			{
				start = true;
				if (shuffle.isSelected())
				{
					main.playRandom();
					songInfo.setText(main.getCurrent().toString());
				}
				else
				{
					songInfo.setText(main.getSong(0).toString());
					main.playFirst();
				}
			}
			else
			{
				main.playCurrentSong();
				songInfo.setText(main.getCurrent().toString());
			}
			
			main.getMpCurrent().setOnEndOfMedia(new Runnable () {
				@Override
				public void run()
				{
					main.getMpCurrent().stop();
					if (shuffle.isSelected())
					{
						main.playRandom();
						remove(cards);
						songInfo.setText(main.getCurrent().toString());
						add(cards);
						
					}
					else
					{
						main.playNext();
						remove(cards);
						songInfo.setText(main.getCurrent().toString());
						add(cards);
					}
				}
			});
		}
		if (a.getSource() == next)
		{
			main.stopPlayback();
			if (shuffle.isSelected())
			{
				main.playRandom();
				songInfo.setText(main.getCurrent().toString());
			}
			else
			{
				main.playNext();
				songInfo.setText(main.getCurrent().toString());
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
