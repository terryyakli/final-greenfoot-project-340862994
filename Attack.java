import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * attack to damage boss.
 * 
 * @author (Martin) 
 * @version (2023/01/10)
 */
public class Attack extends Actor
{
    /**
     * Act - do whatever the Attack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        getWorld().removeObject(this);
    }
}
