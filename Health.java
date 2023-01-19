import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * health bar for person.
 * 
 * @author (Martin) 
 * @version (2023/01/18)
 */
public class Health extends Actor
{
    int health = 5;
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
    
    /*
     * updates health bar in MyWorld according to damage taken
     */
    public void update()
    {
        setImage(new GreenfootImage(healthBarWidth + 2, healthBarHeight + 2));
        GreenfootImage myImage = getImage();
        myImage.setColor(Color.BLACK);
        myImage.drawRect(0, 0, healthBarWidth + 1, healthBarHeight + 1);
        myImage.setColor(Color.RED);
        myImage.fillRect(1, 1, health * healthPoint, healthBarHeight);
    }
    
    /*
     * subtracts health points due to fireball hits
     */
    public void damage()
    {
        health--;
    }
    
    /*
     * adds health points if healhtbottles are used
     */
    public void heal()
    {
        health++;
    }
}
