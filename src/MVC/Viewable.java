package MVC;

import java.awt.Graphics;

/**
 * The interface for the view
 * You must add all the methods that will be sent to the View here..
 * 
 * @author levenick
 */
public interface Viewable {
    public void display();
    public void paintComponent(Graphics g);
    
    
}
