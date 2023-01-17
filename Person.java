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
            x+=2;
        }
        if(Greenfoot.isKeyDown("A")) 
        {
            x-=2;
        }
        setLocation(getX() + x, getY());

        if(isTouching(Boundary.class))
        {
            setLocation(getX() - x, getY());
        }
        
        
        if(Greenfoot.isKeyDown("S")) 
        {
            y+=2;
        }
        if(Greenfoot.isKeyDown("W")) 
        {
            y-=2;
        }
        setLocation(getX(), getY() + y);
        
        if(isTouching(Boundary.class))
        {
            setLocation(getX(), getY() - y);
        }
        
        //Removes Fireball if hit
        damage();
        collectCoin();
        heal();
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
            if(x == false)
            {
                Health.damage();
                oofSound.play();
                world.createFireball();
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
    
    public void collectCoin()
    {
        if(isTouching(Coin.class))
        {
            removeTouching(Coin.class);
            MyWorld world = (MyWorld) getWorld();
            world.createCoin();
            world.increaseScore();
        }
    }
    
    boolean y = false;
    public void heal()
    {
        if(isTouching(Heal.class))
        {
            removeTouching(Heal.class);
            MyWorld world = (MyWorld) getWorld();
            Health Health = world.getPlayerHealthBar();
            if(y == false)
            {
                if(Health.health == 5)
                {
                    world.createHeal();
                    return;
                }
                Health.heal();
                world.createHeal();
                y = true;
            }
        }
        else
        {
            y = false;
        }
    }
}
