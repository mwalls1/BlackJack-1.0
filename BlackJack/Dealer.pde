private int dealerHand;
private Card faceDown;
private boolean dealerAce;
private boolean hasWon;
private ArrayList<Card> dealerCards = new ArrayList<Card>();
public class Dealer
{
  private Dealer()
  {
    hasWon = false;
    dealerHand = 0;
    dealerAce = false;
  }
  private void addCard(Card a)
  {
    
    if(a.getValue()==1&&!dealerAce&&11+dealerHand<21)
    {
      dealerAce = true;
      dealerCards.add(a);
      dealerHand+=11;
    }
    else if(dealerHand+a.getValue()>21&&dealerAce)
    {
      dealerAce = false;
      dealerCards.add(a);
      dealerHand+=a.getValue()-10;
    }
    else
    {
      dealerHand+=a.getValue();
      dealerCards.add(a);
    }
  }
  private int getHand()
  {
    return dealerHand;
  }
  private void resetData()
  {
    dealerHand = 0;
    dealerAce  = false;
  }
  private void faceDown(Card a)
  {
    faceDown = a;
  }
  private Card getFace()
  {
    return faceDown;
  }
  private void addFace()
  {
    if(faceDown.getValue()==1&&!dealerAce)
    {
      dealerCards.add(faceDown);
      dealerHand+=11;
      dealerAce = true;
    }
    else
    {
      dealerHand+=faceDown.getValue();
      dealerCards.add(faceDown);
    }
  }
  private void paint()
  {
    for (int i =0; i<dealerCards.size(); i++)
    {
    image(dealerCards.get(i).image, 900+i*110, 400);
    }
  }
  private void setWin(boolean a)
  {
    hasWon = a;
  }
  private boolean hasWon()
  {
    return hasWon;
  }
  private void clearHand()
  {
    ArrayList<Card> a = new ArrayList<Card>();
    dealerCards = a;
  }
}