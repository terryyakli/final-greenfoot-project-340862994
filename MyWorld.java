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
    Health playerHealthBar = new Health();
    Health2 bossHealthBar = new Health2();
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        
        prepare();
        
        createFireball();
    }
    
    public void prepare()
    {
        addObject(Person, 90, 210);
        addObject(Boss1, 470, 205);
        addObject(playerHealthBar, 65, 20);
        addObject(bossHealthBar, 300, 370);
        names();
    }
    
    public void names()
    {
        Label bossName = new Label("Boss1", 30);
        addObject(bossName, 300, 350);
        Label health = new Label("HP", 20);
        addObject(health, 25, 20);
    }
    
    public void gameOverWin()
    {
        Label gameOverLabel = new Label("Game Over Win" , 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    public void gameOverLose()
    {
        Label gameOverLabel = new Label("Game Over Lose" , 100);
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
    
    public Health getPlayerHealthBar()
    {
        return playerHealthBar;
    }
    
    public Health2 getBossHealthBar()
    {
        return bossHealthBar;
    }
}
