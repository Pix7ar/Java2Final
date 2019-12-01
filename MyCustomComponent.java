/**
 * A code stub/template for a simple GUI
 * - This file has the component which will
 *   contain the graphics.
 * 
 * @author Justin Jang
 * @version 11/25/2019
 */
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;

public class MyCustomComponent extends JComponent
{
    // Make instance variable(s) to hold references to
    // any objects you need to refer to.
    
    // Overload the constructor to pass reference(s) to 
    // any objects that you need to refer to.
	
	private static PictureSquare[][] tiles = new PictureSquare[5][5];
	//empty is the controller of the game. It is the last tile on the bottom right
	private PictureSquare current;
    public MyCustomComponent(/*pass refs here*/)
    {
    	populate();
    	current = new PictureSquare(0,0);
    	current.assign(tiles[4][4]);
    	scramble5();
    }
    
    
    // This populates tiles which in turn makes each tile in a 5 x 5 on the canvas
    public void populate()
    {
    	for (int i = 0; i < 5; i++)
    	{
    		for (int j = 0; j < 5; j++)
    		{

        		int xValue = j;
        		int yValue = i;
        		tiles[i][j] = new PictureSquare(xValue, yValue);
    		}
    	}
    }
    //scrambles the puzzle with 5 random moves
    public void scramble5()
    {
    	for (int i = 0; i < 500; i++)
    	{
    		int x = getCurrentX();
        	int y = getCurrentY();
        	
    		System.out.println(getCurrentX() + " " + getCurrentY());
    		Random r = new Random();
    		int code = r.nextInt(4);
    		
    		switch(code)
    		{
    		case 0:
    			if (y > 0)
    			{
    				int v = y - 1;
    				swapTiles(x, y, x, v);
    	    		setCurrentY(v);
    			}
    				
    			System.out.println("up");
    			break;
    		
    		case 1:
    			if (y < 4)
    			{
    				int v = y + 1;
    				swapTiles(x, y, x, v);
    	    		setCurrentY(v);
    			}
    			System.out.println("down");
    			break;
    		
    		case 2:
    			if (x > 0)
    			{
    				int u = x - 1;
    				swapTiles(x, y, u, y);
    	    		setCurrentX(u);
    			}
    			System.out.println("left");
    			break;
    		
    		case 3:
    			if (x < 4)
    			{
    				int u = x + 1;
    				swapTiles(x, y, u, y);
    	    		setCurrentX(u);
    			}
    			System.out.println("right");
    			break;
    		}
    	}
    }
    
    //takes in the points for the location of the destination and switches the IDs
    // of the two units
    // x,y = current
    // u,v = destination
    public void swapTiles(int x, int y, int u, int v)
    {
    	tiles[x][y].setID(tiles[u][v].getID());
    	tiles[u][v].setID(0);
    }
    

    //empty gets and sets for motion
    public PictureSquare getCurrent()
    {
    	return current;
    }
    
    public int getCurrentX()
    {
    	return current.getX();
    }
    
    public int getCurrentY()
    {
    	return current.getY();
    }
    
    public void setCurrentX(int u)
    {
    	current.setX(u);
    }
    
    public void setCurrentY(int v)
    {
    	current.setY(v);
    }
    
    
    public void paintComponent(Graphics g)
    {
        // Use this method to draw whatever you want
        g.setColor(Color.BLUE);
        //draws the entire canvas
        g.drawRect(0, 0, getWidth()-1, getHeight()-1);
        //draws every tile with each bit having a number in the middle
        for (int i = 0; i < 5; i++)
    	{
    		for (int j = 0; j < 5; j++)
    		{
    			g.drawRect(tiles[i][j].getX() * 100, tiles[i][j].getY() * 100, 100, 100);
                if (tiles[i][j].getID() != 0)
                	g.drawString("" + tiles[i][j].getID(),
                		(tiles[i][j].getX() * 100) + 50, (tiles[i][j].getY() * 100) + 50);

                System.out.print(tiles[i][j].getID() + " ");
    		}
    		System.out.println();
    	}
    }
    

}
