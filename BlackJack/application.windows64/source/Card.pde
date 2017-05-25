public class Card
{
  public int value;
  public PImage image;
  public Card(int a, PImage b)
  {
    value = a;
    image = b;
    image.resize(100,200);
  }
  private int getValue()
  {
    return value;
  }
}