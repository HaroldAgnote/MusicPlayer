import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiApp extends JFrame
{
	private Panel app;
	
	public GuiApp()
	{
		setBounds(400,200,400,150);
		Panel app = new Panel();
		this.setContentPane(app);
	}
}
