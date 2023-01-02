import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * End screen for game
 * 
 * @author (Martin) 
 * @version (2023/01/02)
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
        
        Label gameOverLabel = new Label("Game Over" , 100);
        addObject(gameOverLabel, 300, 200);
        
        prepare();
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld world = new MyWorld();
            Greenfoot.setWorld(world);
        }
    }
    
    public void prepare()
    {
        Label label = new Label ("Press <space> to Restart", 40);
        addObject(label,249,331);
        label.setLocation(326,319);
        label.setLocation(295,326);
    }
}
