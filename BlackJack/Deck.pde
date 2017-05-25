ArrayList<Card> deck = new ArrayList<Card>();
ArrayList<Card> usedDeck = new ArrayList<Card>();
boolean isOver = false;
public class Deck
{
  public Deck()
  {
    fillDeck();
  }
  public void fillDeck()
  {
    deck.add(new Card(1, loadImage("ace1.png")));
    deck.add(new Card(1, loadImage("ace2.png")));
    deck.add(new Card(1, loadImage("ace3.png")));
    deck.add(new Card(1, loadImage("ace4.png")));
    deck.add(new Card(2, loadImage("21.png")));
    deck.add(new Card(2, loadImage("22.png")));
    deck.add(new Card(2, loadImage("23.jpg")));
    deck.add(new Card(2, loadImage("24.png")));
    deck.add(new Card(3, loadImage("31.png")));
    deck.add(new Card(3, loadImage("32.png")));
    deck.add(new Card(3, loadImage("33.png")));
    deck.add(new Card(3, loadImage("34.png")));
    deck.add(new Card(4, loadImage("41.png")));
    deck.add(new Card(4, loadImage("42.png")));
    deck.add(new Card(4, loadImage("43.png")));
    deck.add(new Card(4, loadImage("44.png")));
    deck.add(new Card(5, loadImage("51.png")));
    deck.add(new Card(5, loadImage("52.png")));
    deck.add(new Card(5, loadImage("53.png")));
    deck.add(new Card(5, loadImage("54.png")));
    deck.add(new Card(6, loadImage("61.png")));
    deck.add(new Card(6, loadImage("62.png")));
    deck.add(new Card(6, loadImage("63.png")));
    deck.add(new Card(6, loadImage("64.png")));
    deck.add(new Card(7, loadImage("71.png")));
    deck.add(new Card(7, loadImage("72.png")));
    deck.add(new Card(7, loadImage("73.png")));
    deck.add(new Card(7, loadImage("74.png")));
    deck.add(new Card(8, loadImage("81.png")));
    deck.add(new Card(8, loadImage("82.png")));
    deck.add(new Card(8, loadImage("83.png")));
    deck.add(new Card(8, loadImage("84.png")));
    deck.add(new Card(9, loadImage("91.png")));
    deck.add(new Card(9, loadImage("92.png")));
    deck.add(new Card(9, loadImage("93.png")));
    deck.add(new Card(9, loadImage("94.png")));
    deck.add(new Card(10, loadImage("101.jpg")));
    deck.add(new Card(10, loadImage("102.png")));
    deck.add(new Card(10, loadImage("103.png")));
    deck.add(new Card(10, loadImage("104.png")));
    deck.add(new Card(10, loadImage("j1.png")));
    deck.add(new Card(10, loadImage("j2.png")));
    deck.add(new Card(10, loadImage("j3.png")));
    deck.add(new Card(10, loadImage("j4.png")));
    deck.add(new Card(10, loadImage("q1.png")));
    deck.add(new Card(10, loadImage("q2.png")));
    deck.add(new Card(10, loadImage("q3.png")));
    deck.add(new Card(10, loadImage("q4.png")));
    deck.add(new Card(10, loadImage("k1.jpg")));
    deck.add(new Card(10, loadImage("k2.png")));
    deck.add(new Card(10, loadImage("k3.png")));
    deck.add(new Card(10, loadImage("k4.png")));
    shuffle();
  }
  private void deal(Player player, Dealer dealer)
  {
      player.addCard(usedDeck.remove(usedDeck.size()-1));
      dealer.faceDown(usedDeck.remove(usedDeck.size()-1));
      player.addCard(usedDeck.remove(usedDeck.size()-1));
      dealer.addCard(usedDeck.remove(usedDeck.size()-1));
      if(dealer.getFace().getValue()+dealer.getHand()==21)
      {
        dealer.addCard(dealer.getFace());
        isOver = true;
        dealer.setWin(true);
      }
  }
  private void newDeck()
  {
    ArrayList<Card> a = new ArrayList<Card>();
    usedDeck = a;
    shuffle();
  }
  private void shuffle()
  {
    while(usedDeck.size()<52)
    {
      usedDeck.add(deck.get(floor(random(deck.size()))));
    }
  }
  private Card drawCard()
  {
    return usedDeck.remove(usedDeck.size()-1);
  }
  private void dealerTurn(Dealer a, Player b)
  {
    a.addFace();
    if(!isOver&&a.getHand()>=21)
      if(a.getHand()==21)
      {
        a.setWin(true);
        isOver = true;
      }
      else
      {
        b.setWin(true);
        b.addMoney(2);
        isOver = true;
      }
      else
      {
        if(b.getHand()>21)
        {
          a.setWin(true);
          isOver = true;
        }
        else
        {
        while(a.getHand()<17)
        {
          a.addCard(usedDeck.remove(usedDeck.size()-1));
        }
        if(a.getHand()>21)
        {
          b.setWin(true);
          b.addMoney(2);
          isOver = true;
        }
        else if(a.getHand()==21)
        {
          a.setWin(true);
          isOver = true;
        }
        else if(a.getHand()<21&&a.getHand()>b.getHand())
        {
          a.setWin(true);
          isOver = true;
        }
        else if(a.getHand()==b.getHand())
        {
          b.addMoney(1);
          isOver= true;
        }
        else
        {
          b.setWin(true);
          b.addMoney(2);
          isOver = true;
        }
      }
     }
  }
  private boolean gameOver()
  {
   return isOver;
  }
  private void setState(boolean a)
  {
    isOver = a;
  }
  private void resetGame(Dealer a, Player b)
  {
    isOver = false;
    a.clearHand();
    b.clearHand();
    a.setWin(false);
    b.setWin(false);
    b.setHasBet(false);
    b.resetData();
    a.resetData();
    newDeck();
  }
}