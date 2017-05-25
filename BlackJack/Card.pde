public class Card
{
  public int value;
  public PImage image;
  public Card(int a, PImage b)
  {
    value = a;
    image = b;
    image.resize(80,180);
  }
  private int getValue()
  {
    return value;
  }
}