import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (Martin) 
 * @version (2023/01/18)
 */
public class Coin extends Actor
{  
    GreenfootImage[] Coin = new GreenfootImage[3];
    SimpleTimer animationTimer = new SimpleTimer();
    
    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {        
        // Add your action code here.
        int x = getX();
        int y = getY();
        setLocation(x, y);
        
        //animates the coin
        animateCoin();
    }
    
    public Coin()
    {
        for(int i = 0; i < Coin.length; i++)
        {
            Coin[i] = new GreenfootImage("images/Coin/coin" + i + ".png");
            Coin[i].scale(50, 50);
            setImage(Coin[i]);
        }
        
        animationTimer.mark();
    }
    
    /*
     * animates the coin
     */
    int imageIndex = 0;
    public void animateCoin()
    {
        if(animationTimer.millisElapsed() < 50)
        {
            return;
        }
        animationTimer.mark();
        
        setImage(Coin[imageIndex]);
        imageIndex = (imageIndex + 1) % Coin.length;
    }
}
