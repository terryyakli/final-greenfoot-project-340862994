import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * moveable character to defeat boss1.
 * 
 * @author (Martin) 
 * @version (2023/01/09)
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
        int x = 0;
        int y = 0;
        
        
        if(Greenfoot.isKeyDown("D")) 
        {
            x++;
        }
        if(Greenfoot.isKeyDown("A")) 
        {
            x--;
        }
        setLocation(getX() + x, getY());

        if(isTouching(Boundary.class))
        {
            setLocation(getX() - x, getY());
        }
        
        
        if(Greenfoot.isKeyDown("S")) 
        {
            y++;
        }
        if(Greenfoot.isKeyDown("W")) 
        {
            y--;
        }
        setLocation(getX(), getY() + y);
        
        if(isTouching(Boundary.class))
        {
            setLocation(getX(), getY() - y);
        }
        
        if(Greenfoot.isKeyDown("space"))
        {
                attack();
        }
        
        //Removes Fireball if hit
        damage();
    }
    
    public void attack()
    {
        Attack Attack = new Attack();
        getWorld().addObject(Attack, getX(), getY());
        Attack.setRotation(getRotation());
        Attack.setLocation(getX() + 50, getY());
        Greenfoot.delay(1);
    }
    
    boolean x = false;
    public void damage()
    {
        GreenfootSound oofSound = new GreenfootSound("oof.mp3");
        if(isTouching(Fireball.class))
        {
            removeTouching(Fireball.class);
            MyWorld world = (MyWorld) getWorld();
            Health Health = world.getPlayerHealthBar();
            world.createFireball(); 
            if(x == false)
            {
                //Health.damage();
                oofSound.play();
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
