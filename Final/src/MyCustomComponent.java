/**
 * A code stub/template for a simple GUI
 * - This file has the component which will
 *   contain the graphics.
 * 
 * @author Justin Jang
 * @version 11/25/2019
 */
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;

public class MyCustomComponent extends JComponent
{
    // Make instance variable(s) to hold references to
    // any objects you need to refer to.
    
    // Overload the constructor to pass reference(s) to 
    // any objects that you need to refer to.
	
	private static final int CAP = 5;
	

	String imagePath = randomImage();
	private static PictureSquare[][] tiles = new PictureSquare[CAP][CAP];
	//empty is the controller of the game. It is the last tile on the bottom right
	private PictureSquare current;
    public MyCustomComponent(/*pass refs here*/) throws IOException
    {
    	populate();
    	setPictures();
    	current = new PictureSquare(0,0);
    	current.assign(tiles[CAP - 1][CAP - 1]);
    	scramble25();
    }
    
    
    // This populates tiles which in turn makes each tile in a 5 x 5 on the canvas
    public void populate()
    {
    	for (int i = 0; i < CAP; i++)
    	{
    		for (int j = 0; j < CAP; j++)
    		{

        		int xValue = j;
        		int yValue = i;
        		tiles[i][j] = new PictureSquare(xValue, yValue);
    		}
    	}
    }
    
    
    //randomly chooses an image for the puzzle
    public String randomImage() throws IOException
    {
    	String[] imageName = {
    			"japaneseWater.jpg",
    			"feelsBadMan.jpg",
    			"animeGirl.jpg",
    			"ramenPanda.jpg" };
    	
    	Random randy = new Random();
    	
    	int randle = randy.nextInt(imageName.length);
    	return "src/res/" + imageName[randle];
    }
    
    public void changeImage() throws IOException
    {
    	imagePath = randomImage();
    }
    
    public ImageIcon loadImage() throws IOException
    {
    	BufferedImage myPic = ImageIO.read(new File(imagePath));
    	return (new ImageIcon(myPic));
    }
    
    public void setPictures() throws IOException
    {
    	BufferedImage myPic = ImageIO.read(new File(imagePath));
    	
    	
    	for (int i = 0; i < CAP; i++)
    	{
    		for (int j = 0; j < CAP; j++)
    		{
    			BufferedImage pic = myPic.getSubimage(
    					tiles[i][j].getX() * 100,
    					tiles[i][j].getY() * 100,
    					100,
    					100);
    			
        		tiles[i][j].setImage(pic);
        		if (i == CAP - 1 && j == CAP - 1)
        			tiles[i][j].setImage(null);
    		}
    	}
    }
    
    //scrambles the puzzle with 25 random moves
    public void scramble25()
    {
    	for (int i = 0; i < 25; i++)
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
    			if (y < CAP - 1)
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
    			if (x < CAP - 1)
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
  //scrambles the puzzle with 500 random moves
    public void scramble500()
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
    			if (y < CAP - 1)
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
    			if (x < CAP - 1)
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
    	tiles[x][y].setImage(tiles[u][v].getImage());
    	tiles[u][v].setImage(null);
    }
   
    public boolean check()
    {
    	boolean solved = true;
    	int count = 1;
    	for (int i = 0; i < CAP; i++)
    	{
    		for (int j = 0; j < CAP; j++)
    		{
    			if (count == CAP * CAP)
    				count = 0;
        		if (tiles[i][j].getID() != count)
        		{
        			return false;
        		}
        		count++;
    		}
    	}
    	return (solved);
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
        g.setColor(Color.MAGENTA);
        //draws the entire canvas
        g.drawRect(0, 0, getWidth()-1, getHeight()-1);
        
        
        //draws every tile with each bit having a number in the middle
        for (int i = 0; i < CAP; i++)
    	{
    		for (int j = 0; j < CAP; j++)
    		{
    			g.drawImage(tiles[i][j].getImage(),
    					tiles[i][j].getX() * 100,
    					tiles[i][j].getY() * 100, 
    					this);
    			/*
    			g.drawRect(tiles[i][j].getX() * 100,
    					tiles[i][j].getY() * 100,
    					100, 100);
    			
                if (tiles[i][j].getID() != 0)
                	g.drawString("" + tiles[i][j].getID(),
                		(tiles[i][j].getX() * 100) + 50, 
                		(tiles[i][j].getY() * 100) + 50);
				*/
                System.out.print(tiles[i][j].getID() + " ");
    		}
    		
    		System.out.println();
    	}
    }
    

}