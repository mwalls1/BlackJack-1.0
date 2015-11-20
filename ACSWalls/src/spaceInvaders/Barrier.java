package spaceInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;

public class Barrier 
{
	private int xloc;
	private int yloc;
	private int health = 100;
	Image barrierImage = null;
	private boolean stillAlive = true;
	public Barrier(int a, int b, Image bar)
	{
		xloc = a;
		yloc = b;
		barrierImage = bar;
	}
	public void loseHP()
	{
		health-=25;
		if(health==0)
		{
			stillAlive = false;
		}
	}
	public void drawBarriers(Graphics g)
	{
		if(stillAlive)
			{
			g.drawImage(barrierImage,xloc,yloc,75,40,null);
			}
	}
	 public boolean checkShot(int xShot, int yShot) {

	      //Is the ship currently alive?
	      //if (hitState) {
	      //If it's alreay been shot then return false;
	      // return false;
	      //}

	      //First lets check the X range
	      if ((xShot >= xloc) && (xShot <= (xloc+75))) {
	          //X is ok, now lets check the Y range
	          if ((yShot >= yloc) && (yShot <= (yloc+40))) {
	              //The ship was hit!
	              return true;
	          }
	      } 
	      return false;
	  }

}
