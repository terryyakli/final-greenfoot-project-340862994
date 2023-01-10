import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * health bar for person.
 * 
 * @author (Martin) 
 * @version (2023/01/09)
 */
public class Health extends Actor
{
    int health = 1; //change this
    int healthBarWidth = 200;
    int healthBarHeight = 15;
    int healthPoint = (int)healthBarWidth/health;
    /**
     * Act - do whatever the Health wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public void act()
    {
        // Add your action code here.
        update();
    }
    
    public void update()
    {
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.BLACK);
        myImage.drawRect(0, 0, healthBarWidth + 1, healthBarHeight + 1);
        myImage.setColor(Color.RED);
        myImage.fillRect(1, 1, health * healthPoint, healthBarHeight);
    }
    
    public void damage()
    {
        health--;
    }
}
