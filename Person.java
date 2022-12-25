import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Person here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Person extends Actor
{
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
            //attack code goes here
            setLocation(getX() + 10, getY());
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
            Health Health = world.getHealth();
            world.createFireball(); 
            if(x == false)
            {
                Health.damage();
                x = true;
                if(Health.health <=0)
                {
                    world.gameOver();
                }
            }
        }
        else
        {
            x = false;
            
        }
    }
}
