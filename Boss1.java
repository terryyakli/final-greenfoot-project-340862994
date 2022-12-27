import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss1 extends Actor
{
    /**
     * Act - do whatever the Boss1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        damage();
    }
    
    boolean x = false;
    public void damage()
    {
        if(isTouching(Attack.class))
        {
            MyWorld world = (MyWorld) getWorld();
            Health2 Health = world.getBossHealthBar();
            if(x == false)
            {
                Health.damage();
                x = true;
                if(Health.health <=0)
                {
                    world.gameOverWin();
                }
            }
        }
        else
        {
            x = false;
            
        }
    }
}
