import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * End screen for game
 * 
 * @author (Martin) 
 * @version (2023/01/18)
 */
public class EndScreen extends World
{

    /**
     * Constructor for objects of class EndScreen.
     * 
     */
    public EndScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        //Adds labels to EndScreen
        prepare();
    }
    
    public void act()
    {
        //resets to MyWorld if "space" is pressed
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld world = new MyWorld();
            Greenfoot.setWorld(world);
        }
    }
    
    public void prepare()
    {
        Label gameOverLabel = new Label("Game Over" , 100);
        addObject(gameOverLabel, 300, 75);
        
        Label label = new Label ("Press [space] to Restart", 40);
        addObject(label,300,360);
    }
}
