package main;

import java.awt.Color;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dataStructures.k_Queue;
import dataStructures.Queue;

public class Window {
	
	private  JFrame F;
	private k_Queue<JLabel> characters;
	private k_Queue<JLabel> objects;
	private JLabel background;
	private JLabel player;
	
	public Window( short x, short y, short NumNPCs, short NumItems, KeyListener kb, 
			short labelX, short labelY, short itemX, short itemY, short playerX, short playerY)
	{
		System.out.println("Window Instance");
		F = new JFrame();
		
		F.setSize(x, y);
		F.setLayout(null);
		F.setResizable(false);
		F.getContentPane().setBackground(Color.DARK_GRAY);
		F.setDefaultCloseOperation(F.EXIT_ON_CLOSE);
		F.setVisible(true);
		F.addKeyListener(kb);
		
		background = new JLabel();
		background.setVisible(true);
		background.setSize(x, y);
		background.setLocation(0,0);
		
		player = new JLabel();
		player.setVisible(true);
		player.setSize(playerX, playerY);
		F.add(player);
		
		characters = new Queue<JLabel>(NumNPCs);
		objects = new Queue<JLabel>(NumItems);
		
		spawnLabel('N', NumNPCs, labelX, labelY);
		spawnLabel('o', NumItems, itemX, itemY);
		F.add(background);
	}
	
	public JFrame getFrame()
	{
		return F;
	}
	
	public void setBackGround(ImageIcon icon)
	{
		background.setIcon(icon);
		
	}
	
	public void updateLabel(char x, ImageIcon icon, double posX, double posY)
	{
		JLabel label;
		switch (x)
		{
			case 'o':
			case 'O':
			{
				 {
					 label = objects.dequeue();
					 label.setLocation((int)posX,(int) posY);
					 label.setIcon(icon);
					 objects.enqueue(label);
					 break;
				 }
			}
			case 'n':
			case 'N':
			{
					label = characters.dequeue();
					label.setIcon(icon);
					label.setLocation((int)posX, (int)posY);
					characters.enqueue(label);
					break;
				
			}
		}
		
	}
	
	private void spawnLabel(char x, short size, short labelX, short labelY)
	{
		JLabel label;
		if(x == 'o' || x == 'O')
		{
			for(short count = 0; count < size; count++)
			{
				label = new JLabel();
				objects.enqueue(label);
				F.add(label);
				label.setVisible(true);
				label.setSize(labelX, labelY);
				System.out.println("Items Label created");
			}
		}
		else
		{
			for(short count = 0; count < size; count++)
			{
				label = new JLabel();
				characters.enqueue(label);
				F.add(label);
				label.setVisible(true);
				label.setSize(labelX, labelY);
				System.out.println("NPC Label created");
			}
		}
	}
	
	public void updatePlayer(double x, double y, ImageIcon icon)
	{
		player.setLocation((int)x, (int)y);
		if(icon != null)
		{
			player.setIcon(icon);
		}
	}

}
