import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Blocks person1 from going outside of boss area
 * 
 * @author (Martin) 
 * @version (2023/01/18)
 */
public class Boundary extends Actor
{
    int boundaryWidth = 1000;
    int boundaryHeight = 1;
    Color trans = new Color(0, 0, 0, 0);
    
    /**
     * Act - do whatever the Boundary wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        //Spawns a boundary to keep Person within range of fireballs
        setImage(new GreenfootImage(boundaryWidth, boundaryHeight));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.BLACK);
        myImage.drawRect(0, 0, boundaryWidth, boundaryHeight);
    }
}
