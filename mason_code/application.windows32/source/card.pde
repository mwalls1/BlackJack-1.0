public class card
{
  public int value;
  public PImage image;
  public card(int a, PImage b)
  {
    value = a;
    image = b;
    image.resize(100,200);
  }
}