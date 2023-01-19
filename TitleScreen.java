import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * First screen shown when game start
 * 
 * @author (Martin) 
 * @version (2023/01/18)
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
        

        prepare();
    }
    
    /*
     * If space is pressed, sets world to MyWorld
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld world = new MyWorld();
            Greenfoot.setWorld(world);
        }
    }
    
    /*
     * Creates all labels in TitleScreen
     */
    private void prepare()
    {
        Label titleLabel = new Label("Coin Collect", 100);
        addObject(titleLabel, 300, 75);
        
        Label label = new Label ("Use W, A, S, D to Move", 30);
        addObject(label,300,360);
        
        Label label2 = new Label ("Press [space] to Start", 40);
        addObject(label2,300,150);
        
        Label label3 = new Label ("Instructions:", 30);
        addObject(label3, 300, 200);
        
        Label label4 = new Label ("Collect Coins and Dodge Fireballs" , 30);
        addObject(label4, 300, 250);
        
        Label label5 = new Label ("Collect Health Bottles to Heal", 30);
        addObject(label5, 300, 300);
    }
}
