import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Blocks person1 from going outside of boss area
 * 
 * @author (Martin) 
 * @version (2023/01/09)
 */
public class Boundary extends Actor
{
    int boundaryWidth = 1000;
    int boundaryHeight = 1;
    /**
     * Act - do whatever the Boundary wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        setImage(new GreenfootImage(boundaryWidth, boundaryHeight));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.WHITE);
        myImage.drawRect(0, 0, boundaryWidth, boundaryHeight);
    }
}
