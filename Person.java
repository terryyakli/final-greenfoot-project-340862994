import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * moveable character to defeat boss1.
 * 
 * @author (Martin) 
 * @version (2023/01/18)
 */
public class Person extends Actor
{
    GreenfootImage[] personRight = new GreenfootImage[4];
    GreenfootImage[] personLeft = new GreenfootImage[4];
    SimpleTimer animationTimer = new SimpleTimer();
    
    String facing = "right";
    /**
     * Act - do whatever the Person wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        int x = 0;
        int y = 0;
        
        //allows person to move
        if(Greenfoot.isKeyDown("D")) 
        {
            x+=2;
            facing = "right";
        }
        if(Greenfoot.isKeyDown("A")) 
        {
            x-=2;
            facing = "left";
        }
        setLocation(getX() + x, getY());
        
        //blocks person from going out of fireball range
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
        //blocks person from going out of fireball range
        if(isTouching(Boundary.class))
        {
            setLocation(getX(), getY() - y);
        }
        
        damage();
        collectCoin();
        heal();
        animatePerson();
    }
    
    public Person()
    {
        for(int i = 0; i < personRight.length; i++)
        {
            personRight[i] = new GreenfootImage("images/Person/person" + i + ".png");
            personRight[i].scale(50, 50);
            setImage(personRight[i]);
        }
        
        for(int i = 0; i < personLeft.length; i++)
        {
            personLeft[i] = new GreenfootImage("images/Person/person" + i + ".png");
            personLeft[i].mirrorHorizontally();
            personLeft[i].scale(50, 50);
            setImage(personLeft[i]);
        }
        
        animationTimer.mark();
    }
    
    /*
     * animtes person
     */
    int imageIndex = 0;
    public void animatePerson()
    {
        if(animationTimer.millisElapsed() < 100)
        {
            return;
        }
        animationTimer.mark();
        
        if(facing.equals("right"))
        {
            setImage(personRight[imageIndex]);
            imageIndex = (imageIndex + 1) % personRight.length;
        }
        else
        {
            setImage(personLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % personLeft.length;
        }
    }
    
    /*
     * deals damage to person health bar and plays sound if touching fireball.class
     */
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
    
    /*
     * collects coin and plays sound if touching coin.class
     */
    public void collectCoin()
    {
        GreenfootSound coinSound = new GreenfootSound("coin.mp3");
        if(isTouching(Coin.class))
        {
            coinSound.play();
            removeTouching(Coin.class);
            MyWorld world = (MyWorld) getWorld();
            world.createCoin();
            world.increaseScore();
        }
    }
    
    /*
     * heals player health bar and plays sound if touching heal.class
     */
    boolean y = false;
    public void heal()
    {
        GreenfootSound healSound = new GreenfootSound("heal.mp3");
        if(isTouching(Heal.class))
        {
            healSound.play();
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
