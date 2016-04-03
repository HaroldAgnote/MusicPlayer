import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainGui extends JFrame
{
	public static void main(String[]args)
	{
		GuiApp app = new GuiApp();
		app.setTitle("Music Player");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setVisible(true);
	}
}
