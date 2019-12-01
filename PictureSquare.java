
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class PictureSquare extends JComponent
{
	private static int count = 0;
	private int x, y, id;
	private final int WIDTH = 50, HEIGHT = 50;
	
	public PictureSquare(int xBox, int yBox)
	{
		count++;
		id = count;
		x = xBox;
		y = yBox;
	}
	
	PictureSquare(PictureSquare c)
	{
		id = c.id;
		x = c.x;
		y = c.y;
	}
	
	public PictureSquare assign(PictureSquare other)
	{
		id = other.id;
		x = other.x;
		y = other.y;
		return this;
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	
	public int getID()
	{
		// to keep the last one empty
		if (id == 25)
			return 0;
		return id;
	}
	
	public void setX(int u)
	{
		x = u;
	}
	
	public void setY(int v)
	{
		y = v;
	}
	
	public void setID(int other)
	{
		id = other;
	}
	
	public void paintComponent(Graphics g)
    {
        // Use this method to draw whatever you want
        g.setColor(Color.BLUE);
        g.drawRect(x, y, WIDTH, HEIGHT);
        g.drawString("" + count, x + 25, y + 25);
    }
}
