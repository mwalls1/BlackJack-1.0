package spaceInvaders;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

/**
 *
 */
public class Alien {

    public static int ALIEN_HEIGHT = 40;
    public static int ALIEN_WIDTH  = 40;   

    private int leftPosition = 0;
    private int heightPosition = 0;

    private boolean hitState = false;//Whether this alien has already been shot
    Image alienImage = null;
    SpaceInvaders spaceInvaders = null;
    Image bomb = null;
    
    /**
     *
     */
    public Alien(Image ai, SpaceInvaders si) {
        alienImage = ai;
        spaceInvaders = si;
    }

    /**
     * Returns whether ythe alien had been hit
     */
    public boolean hasBeenHit() {
        return hitState;
    }

    /**
     * Check if a shot fired hit an alien
     */
    public boolean hitAlien(int x, int y) {

	//Is the alien currently alive?
        if(hitState){
        	return false;
        }
        //First lets check the X range
        if ((x >= leftPosition) && (x <= (leftPosition+ALIEN_WIDTH))) {
            //X is ok, now lets check the Y range
            if ((y >= heightPosition) && (y <= (heightPosition+ALIEN_HEIGHT))) {
                //We shot an alien!
                hitState = true;
                alienImage = bomb;
                return true;
            }
        } 
        return false;
    }

    /**
     * Set the position of the alien on the screen
     */
    public void setPosition(int x, int y) {
    	leftPosition = x;
        heightPosition = y;
    }

    /**
     * Returns the current x position of the alien
     */
    public int getXPos() {
        return leftPosition;
    }

    /**
     * Returns the current x position of the alien
     */
    public int getYPos() {
       return heightPosition;
    }    

    /**
     *
     */
    public void drawAlien(Graphics g){
        if(!hitState) 
        {
        	g.drawImage(alienImage,leftPosition, heightPosition,40,40,null);
        }
        	
    }    

}