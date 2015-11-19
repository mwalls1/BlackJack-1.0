package spaceInvaders;
import java.awt.*;
import java.awt.event.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 *
 */
public class SpaceInvaders extends JFrame implements Runnable {
    public static int WIDTH = 600;//The width of the frame
    public static int HEIGHT = 400;//The height of the frame

    private int gameSpeed = 100;//Try 500

    AlienArmy army = null;

    Ship ship = null;

    private boolean paused = false;
	private Container content;
    private int score = 0;
    private int health = 3;
	private JLabel scoreLabel;
    Graphics offscreen_high;
    BufferedImage offscreen;

    Image backGroundImage = null;
    Image alienImage = null; 
    Image shipImage = null;
    
    /**
     * This is called a constructor. 
     */
    public SpaceInvaders(String frameTitle) {
    	
        super(frameTitle);
        try {
        	alienImage = ImageIO.read(new File(
    					"res/alienFull.jpg"));
 
    		backGroundImage = ImageIO.read(new File(
    					"res/back3.jpg"));
    		shipImage = ImageIO.read(new File(
    					"res/ship.png"));
    				
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}

        //Create the ship to fight off the invading army!
        ship = new Ship(this,shipImage);

        //Create the alien army
        army = new AlienArmy(ship, this, alienImage);

        //The ship will be controlled by the mouse
        addMouseListener(ship);
        //We also want mouse movement not just mouse clicks
        addMouseMotionListener(ship);

        offscreen = new BufferedImage(WIDTH, HEIGHT,BufferedImage.TYPE_INT_RGB);
        offscreen_high = offscreen.createGraphics();
        scoreLabel=new JLabel("Score", SwingConstants.CENTER);
		scoreLabel.setForeground(Color.white);

        setBackground(Color.black);
        setSize(WIDTH, HEIGHT);
        add(scoreLabel);
        setVisible(true);
        startGame();
    }

    /**
     * As you move your mouse on and off the screen we want to pause
     * the game.
     */
    public void pauseGame(boolean state) {
        paused = state;
    }

    /**
     * Kill an alien and get 5 points!
     */
    public void hitAlienScore() { 
        //Add 5 to the score
        score += 5;
        System.out.println("Current Score = "+score);
    }

    /**
     * Get shot and loose 20 points!
     */
    public void shotShip() {
    	health-=1;
        System.out.println("Current Lives = "+health);
    }
    public int getHP()
    {
    	return health;
    }

    /**
     *
     */
    public void startGame() {
        //These two lines may look confusing but basically they start the 
        //game process, i.e. update the display screen every 100ms.
        Thread thread = new Thread(this);
        thread.start();
    }

    /**
     *
     */
    public void paint(Graphics g) {
        offscreen_high.setColor(Color.black);
        offscreen_high.fillRect(0,0, WIDTH, HEIGHT);

        army.drawArmy(offscreen_high);

        ship.drawShip(offscreen_high);

        g.drawImage(offscreen,0,0,this); 
    }

    public void update(Graphics g) {
        	paint(g);
        	
    }

    /**
     *
     */
    public void moveAliens() {
        army.moveArmy();
    }

    /**
     *
     */
    public void run() {
        int count = 0;
        while(health>0&&true) {
            try {
                Thread.sleep(gameSpeed);
            } catch(InterruptedException ie) {
                //Ignore this exception
            }
            //If the game is currently running, move the aliens
            if(health==0)
            {
            	JLabel gameOver = new JLabel("GAME OVER", JLabel.CENTER);
            	dispose();
            	JFrame frame = new JFrame();
            	frame.setTitle("Game Over");
            	frame.setSize(WIDTH, HEIGHT);
            	frame.getContentPane().setBackground(Color.black);
            	frame.getContentPane().add(gameOver);
            	gameOver.setForeground(Color.white);
            	gameOver.setFont(new Font("ArcadeClassic",Font.PLAIN, 50));
            	gameOver.setVisible(true);
            	frame.setVisible(true);
            }
            if (!paused) {
                if (count >= 5) {
                    moveAliens();
                    count = 0;
                }
            }
            repaint();//Update the screen
            count ++;

        }
    }

    /**
     * Get a reference to the alien army
     */
    public AlienArmy getAlienArmy() {
        return army;
    }

    /**
     * This is the program entry point
     */
    public static void main(String []args) {
        SpaceInvaders invaders = new SpaceInvaders("Space Invaders");
        
    }

}