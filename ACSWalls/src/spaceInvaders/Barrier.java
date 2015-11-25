package spaceInvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.io.File;

import javax.imageio.ImageIO;

public class Barrier 
{	Points point;
	Image barrierImage = null;
	private boolean hitState;
	public Barrier(int a, int b)
	{
		hitState = false;
		point = new Points(a,b);
	}
	public boolean getHitState()
	{
		return hitState;
	}
	public void drawBarriers(Graphics g)
	{
		g.setColor(Color.green);
	if(!hitState)
				g.fillRect(point.getX(), point.getY(), 40, 20);
	}
	 public boolean checkShot(int xShot, int yShot) {

	      //Is the ship currently alive?
	      //if (hitState) {
	      //If it's alreay been shot then return false;
	      // return false;
	      //}
//First lets check the X range
		 if (point.getIsIn(xShot,yShot)&&point.getHit()==false)
				 {
	                changeHit();
	                return true;
				 }
	      return false;
	 }
	 public void changeHit()
	 {
		 point.setHit(true);
	 }
	 public void changeHitState()
	 {
		 hitState = !hitState;
	 }
}


