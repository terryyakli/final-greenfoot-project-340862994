import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Health2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Health2 extends Actor
{
    int health = 2; //change this
    int healthBarWidth = 400;
    int healthBarHeight = 15;
    int healthPoint = (int)healthBarWidth/health;
    /**
     * Act - do whatever the Health2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public Health2()
    {
        update();
    }
    
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
