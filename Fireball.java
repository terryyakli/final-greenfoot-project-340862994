import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * an attack of boss1.
 * 
 * @author (Martin) 
 * @version (2023/01/18)
 */
public class Fireball extends Actor
{
    /**
     * Act - do whatever the Fireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 1;
    GreenfootImage[] Fireball = new GreenfootImage[7];
    SimpleTimer animationTimer = new SimpleTimer();
    
    public void act()
    {
        // Add your action code here.
        int x = getX() - speed;
        int y = getY();
        setLocation(x, y);
        
        //removes fireball once it gets to -100 x
        MyWorld world = (MyWorld) getWorld();
        if(getX() <= -100)
        {
            world.removeObject(this);
            world.createFireball();
        }
        
        //animates fireball
        animateFireball();
    }
    
    public Fireball()
    {
        for(int i = 0; i < Fireball.length; i++)
        {
            Fireball[i] = new GreenfootImage("images/Fireball/Fireball" + i + ".png");
            Fireball[i].scale(100, 50);
            setImage(Fireball[i]);
        }
        
        animationTimer.mark();
    }
    /*
     * animates fireball
     */
    int imageIndex = 0;
    public void animateFireball()
    {
        if(animationTimer.millisElapsed() < 50)
        {
            return;
        }
        animationTimer.mark();
        
        setImage(Fireball[imageIndex]);
        imageIndex = (imageIndex + 1) % Fireball.length;
    }
    
    //sets speed to fireball
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
