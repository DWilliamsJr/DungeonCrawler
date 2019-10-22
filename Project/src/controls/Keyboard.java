package controls;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
		private double kbX;
		private double kbY;
		
		public Keyboard()
		{
			System.out.println("keyboard instance");
		}
		// could have just changed the value of playerSpeed here
			// instead of creating a kbx and kby
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT)
			{
				kbX = -(entity.Player.playerSpeed );
			}
		else if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
			{
				kbY =  (entity.Player.playerSpeed );
			}
		else if(arg0.getKeyCode() == KeyEvent.VK_UP)
			{
				kbY =  -(entity.Player.playerSpeed );
			}
		else if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
			{
				kbX =  (entity.Player.playerSpeed );
			}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT)
		{
			kbX = 0;
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
		{
			kbY = 0;
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_UP)
		{
			kbY = 0;
		}
		else if(arg0.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			kbX = 0;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}
	
	public double getY()
	{
		return kbY;
	}
	
	public double getX()
	{
		return kbX;
	}
}
