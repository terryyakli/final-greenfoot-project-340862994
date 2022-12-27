import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * attack to damage boss.
 * 
 * @author (Martin) 
 * @version (2022/12/26)
 */
public class Attack extends Actor
{
    SimpleTimer count = new SimpleTimer();
    /**
     * Act - do whatever the Attack wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(count.millisElapsed() >= 500)
            {
                getWorld().removeObject(this);
                count.mark();
            }
    }
}
