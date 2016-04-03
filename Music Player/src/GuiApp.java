import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiApp extends JFrame
{
	private Panel app;
	
	public GuiApp()
	{
		setBounds(100,100,215,300);
		Panel app = new Panel();
		this.setContentPane(app);
	}
}
