import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * an attack of boss1.
 * 
 * @author (Martin) 
 * @version (2022/12/29)
 */
public class Fireball extends Actor
{
    /**
     * Act - do whatever the Fireball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 1;
    
    public void act()
    {
        // Add your action code here.
        int x = getX() - 3;//speed;
        int y = getY();
        setLocation(x, y);
        
        MyWorld world = (MyWorld) getWorld();
        if(getX() <= 0)
        {
            world.removeObject(this);
            world.createFireball();
        }
    }
    
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}
