import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * world
 * 
 * @author (Martin) 
 * @version (2023/01/02)
 */
public class MyWorld extends World
{
    public int coin = 0;
    Label coinLabel;
    int speed = 1;
    
    Health playerHealthBar = new Health();
    
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

        coinLabel = new Label(0, 50);
        addObject(coinLabel, 150, 470);
        
        Boundary Boundary = new Boundary();
        addObject(Boundary, 400, 40);
        
        Boundary Boundary2 = new Boundary();
        addObject(Boundary2, 400, 420);
        
        addObject(playerHealthBar, 110, 20);
        
        fireballPattern();
        createCoin();
        createHeal();
        names();
    }
    
    public void names()
    {
        Label health = new Label("HP", 20);
        addObject(health, 25, 20);
        Label coin = new Label("Coins:", 50);
        addObject(coin, 70, 470);
    }
    
    public void gameOver()
    {
        EndScreen world = new EndScreen();
        Greenfoot.setWorld(world);
    }
    
    public void createFireball()
    {
        Fireball Fireball = new Fireball();
        Fireball.setSpeed(speed);
        int x = randomNumber(1000, 1500);
        int y = randomNumber(50, 410);
        addObject(Fireball, x, y);
    }
    
    public void fireballPattern()
    {
        for(int i = 0; i <= 4; i++)
        {
            createFireball();
        }
    }
    
    public void createCoin()
    {
        Coin Coin = new Coin();
        int x = randomNumber(40, 760);
        int y = randomNumber(50, 410);
        addObject(Coin, x, y);
    }
    
    public void increaseScore()
    {
        coin++;
        coinLabel.setValue(coin);
        if(coin % 5 == 0)
        {
            speed++;
        }
    }
    
    public void createHeal()
    {
        Heal Heal = new Heal();
        int x = randomNumber(40, 760);
        int y = randomNumber(50, 410);
        addObject(Heal, x, y);
    }
    
    public int randomNumber(int small, int big)
    {
        int result = Greenfoot.getRandomNumber(big - small + 1);
        return result + small;
    }
    
    
    public Health getPlayerHealthBar()
    {
        return playerHealthBar;
    }
    
}
