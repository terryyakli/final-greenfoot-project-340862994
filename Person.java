import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * moveable character to defeat boss1.
 * 
 * @author (Martin) 
 * @version (2022/12/26)
 */
public class Person extends Actor
{
    SimpleTimer count = new SimpleTimer();
    /**
     * Act - do whatever the Person wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("A"))
        {
            setLocation(getX() - 2, getY());
        }
        else if(Greenfoot.isKeyDown("D"))
        {
            setLocation(getX() + 2, getY());
        }
        else if(Greenfoot.isKeyDown("W"))
        {
            setLocation(getX(), getY() - 2);
        }
        else if(Greenfoot.isKeyDown("S"))
        {
            setLocation(getX(), getY() + 2);
        }
        else if(Greenfoot.isKeyDown("space"))
        {
            Attack Attack = new Attack();
            getWorld().addObject(Attack, getX(), getY());
            Attack.setRotation(getRotation());
            Attack.setLocation(getX() + 50, getY());
        }
        
        //Removes Fireball if hit
        damage();
    }
    boolean x = false;
    public void damage()
    {
        if(isTouching(Fireball.class))
        {
            removeTouching(Fireball.class);
            MyWorld world = (MyWorld) getWorld();
            Health Health = world.getPlayerHealthBar();
            world.createFireball(); 
            if(x == false)
            {
                Health.damage();
                x = true;
                if(Health.health <=0)
                {
                    world.gameOverLose();
                }
            }
        }
        else
        {
            x = false;
            
        }
    }
}
