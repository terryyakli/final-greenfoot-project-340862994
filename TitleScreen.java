import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Game", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {
        super(600, 400, 1);

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
        Label label = new Label ("Use W, A, S, D to Move", 40);
        addObject(label,220,257);
        label.setLocation(297,243);
        label.setLocation(305,240);
        Label label2 = new Label ("Press <space> to Start", 40);
        addObject(label2,249,331);
        label2.setLocation(326,319);
        label.setLocation(328,253);
        label2.setLocation(295,326);
        label.setLocation(278,251);
    }
}
