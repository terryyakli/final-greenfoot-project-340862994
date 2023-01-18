import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * First screen shown when game start
 * 
 * @author (Martin) 
 * @version (2023/01/09)
 */
public class TitleScreen extends World
{
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {
        super(600, 400, 1);
        
        Label titleLabel = new Label("Coin Collect", 100);
        addObject(titleLabel, 300, 75);
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
    
    private void prepare()
    {
        Label label = new Label ("Use W, A, S, D to Move", 30);
        addObject(label,300,360);
        
        Label label2 = new Label ("Press [space] to Start", 40);
        addObject(label2,300,300);
    }
}
