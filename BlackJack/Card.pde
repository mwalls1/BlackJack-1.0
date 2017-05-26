public class Card
{
  public int value;
  public PImage image;
  public Card(int a, PImage b)
  {
    value = a;
    image = b;
    image.resize((displayWidth/12),300);
  }
  private int getValue()
  {
    return value;
  }
}