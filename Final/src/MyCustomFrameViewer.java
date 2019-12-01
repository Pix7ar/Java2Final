/**
 * A code stub/template for a simple GUI
 * - This file has the main method, which
 *   simply creates the main window.
 * 
 * @author Justin Jang
 * @version 11/25/2019
 */

import java.io.IOException;
import javax.swing.JFrame;

public class MyCustomFrameViewer
{
   public static void main(String[] args) throws IOException
   {
      MyCustomFrame frame = new MyCustomFrame();
      frame.setTitle("Crappy jigsaw");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}  
