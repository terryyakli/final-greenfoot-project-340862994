import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    Person Person = new Person();
    Boss1 Boss1 = new Boss1();
    Health Health = new Health();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        addObject(Person, 90, 210);
        addObject(Boss1, 470, 205);
        addObject(Health, 65, 20);
        
        createFireball();
    }
    
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over" , 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    public void createFireball()
    {
        Fireball Fireball = new Fireball();
        //random number ---> Greenfoot.getRandomNumber
        int x = 100;
        int y = 100;
        addObject(Fireball, x, y);
    }
    
    public Health getHealth()
    {
        return Health;
    }
}
