/**
 * A code stub/template for a simple GUI
 * - This file describes the main window
 * 
 * @author Justin Jang
 * @version 11/25/2019
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Dimension;


public class MyCustomFrame extends JFrame
{
    //private JButton startButton, button2;
    private JLabel label, instructions;
    private JPanel panel;
    private MyCustomComponent canvas;
    private PictureSquare ps1;
    
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 600;
    private static final int COMPONENT_WIDTH = 500;
    private static final int COMPONENT_HEIGHT = 500;
    //private static final int SQUARE_WIDTH = 50;
    //private static final int SQUARE_HEIGHT = 50;
    
    // Constructor
    public MyCustomFrame() throws IOException
    {
        createComponents();
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }
    
    private void createComponents() throws IOException
    {
        // Create the GUI components
        
        // Create the buttons
        //startButton = new JButton("Start");
        // Connect the listeners (event handlers) to the buttons
        //startButton.addActionListener(new MyButtonListener1());
        //button2.addActionListener(new MyButtonListener2());
        
        // Create the label
        label = new JLabel("Unscramble the picture below! "
        		+ "The empty square goes on the bottom right when your done.");
        instructions = new JLabel("Use the arrow keys to control the empty square.");
        
        // Create the component (which we will use draw things)
        canvas = new MyCustomComponent();
        canvas.setPreferredSize(new Dimension(COMPONENT_WIDTH, COMPONENT_HEIGHT));
        MyController controls = new MyController();
        canvas.addKeyListener(controls);
        // Create the panel and add the GUI components to the panel
        //JLabel pic = loadImage();
        
        panel = new JPanel();
        panel.add(label);
        panel.add(instructions);
        //This button breaks the controller so until i know how to fix it its out
        //panel.add(startButton);
        panel.add(canvas);
        //panel.add(pic);

        canvas.setFocusable(true);
        canvas.requestFocusInWindow();
        //panel.setBackground(Color.RED);
        // Add the panel to the frame
        this.add(panel);
    }
    
    
    public JLabel loadImage() throws IOException
    {
    	String imagePath = "src/resources/squishy.png";
    	BufferedImage myPic = ImageIO.read(new File(imagePath));
    	JLabel pic = new JLabel(new ImageIcon(myPic));
    	return pic;
    }
    
    // Event handlers
    
    class MyButtonListener1 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            System.out.println("Start");
            
        }
    }
   
    class MyController implements KeyListener 
    {
    	
		public void keyPressed(KeyEvent ke)
    	{

        	int x = canvas.getCurrentX();
        	int y = canvas.getCurrentY();
        	
    		System.out.println(canvas.getCurrentX() + " " + canvas.getCurrentY());
    		int keyCode = ke.getKeyCode();
    		
    		switch(keyCode)
    		{
    		case KeyEvent.VK_LEFT:
    			if (y > 0)
    			{
    				int v = y - 1;
    				canvas.swapTiles(x, y, x, v);
    	    		canvas.setCurrentY(v);
    			}
    				
    			System.out.println("up");
    			break;
    		
    		case KeyEvent.VK_RIGHT:
    			if (y < 4)
    			{
    				int v = y + 1;
    				canvas.swapTiles(x, y, x, v);
    	    		canvas.setCurrentY(v);
    			}
    			System.out.println("down");
    			break;
    		
    		case KeyEvent.VK_UP:
    			if (x > 0)
    			{
    				int u = x - 1;
    				canvas.swapTiles(x, y, u, y);
    	    		canvas.setCurrentX(u);
    			}
    			System.out.println("left");
    			break;
    		
    		case KeyEvent.VK_DOWN:
    			if (x < 4)
    			{
    				int u = x + 1;
    				canvas.swapTiles(x, y, u, y);
    	    		canvas.setCurrentX(u);
    			}
    			System.out.println("right");
    			break;
    		}
    		canvas.repaint();
    		System.out.println(canvas.getCurrentX() + " " + canvas.getCurrentY());
    		
    	}
    	public void keyReleased(KeyEvent ke)
    	{
    		
    	}
		public void keyTyped(KeyEvent ke) 
		{
			
		}
    }
  /*
    class MyButtonListener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            System.out.println("Clicked 2");
        }
    }
    
*/
}