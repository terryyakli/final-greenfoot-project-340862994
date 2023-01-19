import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * world
 * 
 * @author (Martin) 
 * @version (2023/01/18)
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
    
    /*
     * Creates all actors needded in MyWorld
     */
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
    
    /*
     * Creates all labels in MyWorld
     */
    public void names()
    {
        Label health = new Label("HP", 20);
        addObject(health, 25, 20);
        Label coin = new Label("Coins:", 50);
        addObject(coin, 70, 470);
    }
    
    /*
     * Ends the game and sets world to EndScreen
     */
    public void gameOver()
    {
        EndScreen world = new EndScreen();
        Greenfoot.setWorld(world);
    }
    
    /*
     * Creates 1 fireball within random coordinates 
     */
    public void createFireball()
    {
        Fireball Fireball = new Fireball();
        Fireball.setSpeed(speed);
        int x = randomNumber(1000, 1500);
        int y = randomNumber(50, 410);
        addObject(Fireball, x, y);
    }
    
    /*
     * spawns multiple fireballs
     */
    public void fireballPattern()
    {
        for(int i = 0; i <= 4; i++)
        {
            createFireball();
        }
    }
    
    /*
     * Creates 1 coin within random coordinates
     */
    public void createCoin()
    {
        Coin Coin = new Coin();
        int x = randomNumber(40, 760);
        int y = randomNumber(50, 410);
        addObject(Coin, x, y);
    }
    
    /*
     * Increases the score
     */
    public void increaseScore()
    {
        coin++;
        coinLabel.setValue(coin);
        if(coin % 5 == 0)
        {
            speed++;
        }
    }
    
    /*
     * Spawns heal for Person to drink
     */
    public void createHeal()
    {
        Heal Heal = new Heal();
        int x = randomNumber(40, 760);
        int y = randomNumber(50, 410);
        addObject(Heal, x, y);
    }
    
    /*
     * Random number generator within coordinates
     */
    public int randomNumber(int small, int big)
    {
        int result = Greenfoot.getRandomNumber(big - small + 1);
        return result + small;
    }
    
    /*
     * returns value of health bar back to Health
     */
    public Health getPlayerHealthBar()
    {
        return playerHealthBar;
    }
    
}
