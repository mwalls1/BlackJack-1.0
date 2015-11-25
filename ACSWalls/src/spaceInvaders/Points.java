package spaceInvaders;

import java.awt.Polygon;

public class Points {
	private boolean hitState;
	Polygon p;
	private int x;
	private int y;
	public Points(int a, int b)
	{
		x = a;
		y = b;
		p = new Polygon();
		p.addPoint(a, b);
		p.addPoint(a+40,b+20);
		p.addPoint(a+40, b);
		p.addPoint(a, b+20);
	}
	public boolean getIsIn(int z, int s)
	{
		return p.contains(z, s);
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public boolean getHit()
	{
		return hitState;
	}
	public void setHit(boolean a)
	{
		hitState = a;
	}

}
