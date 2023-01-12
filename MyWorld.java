import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * world
 * 
 * @author (Martin) 
 * @version (2023/01/02)
 */
public class MyWorld extends World
{
    public int level = 0;
    Label levelLabel;
    int speed = 1;
    
    Health playerHealthBar = new Health();
    Health2 bossHealthBar = new Health2();
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 800x500 cells with a cell size of 1x1 pixels.
        super(800, 500, 1, false); 
        
        prepare();
    }
    
    public void prepare()
    {
        Person Person = new Person();
        addObject(Person, 100, 250);

        levelLabel = new Label(0, 50);
        addObject(levelLabel, 150, 470);
        
        Boundary Boundary = new Boundary();
        addObject(Boundary, 400, 40);
        
        Boundary Boundary2 = new Boundary();
        addObject(Boundary2, 400, 420);
        
        addObject(playerHealthBar, 110, 20);
        
        attackPattern();
        createBoss();
        names();
    }
    
    public void names()
    {
        Label bossName = new Label("Boss1", 30);
        addObject(bossName, 400, 450);
        Label health = new Label("HP", 20);
        addObject(health, 25, 20);
        Label level = new Label("Level", 50);
        addObject(level, 70, 470);
    }
    
    public void gameOver()
    {
        EndScreen world = new EndScreen();
        Greenfoot.setWorld(world);
    }
    
    public void increaseLevel()
    {
        level++;
        levelLabel.setValue(level);
        
        if(level % 2 == 0)
        {
            speed += 1;
        }
        
        createBoss();
    }
    
    public void createFireball()
    {
        Fireball Fireball = new Fireball();
        Fireball.setSpeed(speed);
        int x = randomNumber(800, 1500);
        int y = randomNumber(50, 410);
        addObject(Fireball, x, y);
    }
    
    public int randomNumber(int small, int big)
    {
        int result = Greenfoot.getRandomNumber(big - small + 1);
        return result + small;
    }
    
    public void attackPattern()
    {
        for(int i = 0; i <= 4; i++)
        {
            createFireball();
        }
    }
    
    //may create more than 1 boss in future
    public void createBoss()
    {
        Boss1 Boss1 = new Boss1();
        addObject(Boss1, 650, 250);
        
        addObject(bossHealthBar, 400, 470);
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
