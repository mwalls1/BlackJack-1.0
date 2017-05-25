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
    deck.add(new Card(1, loadImage("ace.png")));
    deck.add(new Card(1, loadImage("ace.png")));
    deck.add(new Card(1, loadImage("ace.png")));
    deck.add(new Card(1, loadImage("ace.png")));
    deck.add(new Card(2, loadImage("2.png")));
    deck.add(new Card(2, loadImage("2.png")));
    deck.add(new Card(2, loadImage("2.png")));
    deck.add(new Card(2, loadImage("2.png")));
    deck.add(new Card(3, loadImage("3.png")));
    deck.add(new Card(3, loadImage("3.png")));
    deck.add(new Card(3, loadImage("3.png")));
    deck.add(new Card(3, loadImage("3.png")));
    deck.add(new Card(4, loadImage("4.png")));
    deck.add(new Card(4, loadImage("4.png")));
    deck.add(new Card(4, loadImage("4.png")));
    deck.add(new Card(4, loadImage("4.png")));
    deck.add(new Card(5, loadImage("5.png")));
    deck.add(new Card(5, loadImage("5.png")));
    deck.add(new Card(5, loadImage("5.png")));
    deck.add(new Card(5, loadImage("5.png")));
    deck.add(new Card(6, loadImage("6.png")));
    deck.add(new Card(6, loadImage("6.png")));
    deck.add(new Card(6, loadImage("6.png")));
    deck.add(new Card(6, loadImage("6.png")));
    deck.add(new Card(7, loadImage("7.png")));
    deck.add(new Card(7, loadImage("7.png")));
    deck.add(new Card(7, loadImage("7.png")));
    deck.add(new Card(7, loadImage("7.png")));
    deck.add(new Card(8, loadImage("8.png")));
    deck.add(new Card(8, loadImage("8.png")));
    deck.add(new Card(8, loadImage("8.png")));
    deck.add(new Card(8, loadImage("8.png")));
    deck.add(new Card(9, loadImage("9.png")));
    deck.add(new Card(9, loadImage("9.png")));
    deck.add(new Card(9, loadImage("9.png")));
    deck.add(new Card(9, loadImage("9.png")));
    deck.add(new Card(10, loadImage("10.png")));
    deck.add(new Card(10, loadImage("10.png")));
    deck.add(new Card(10, loadImage("10.png")));
    deck.add(new Card(10, loadImage("10.png")));
    deck.add(new Card(10, loadImage("jack.png")));
    deck.add(new Card(10, loadImage("jack.png")));
    deck.add(new Card(10, loadImage("jack.png")));
    deck.add(new Card(10, loadImage("jack.png")));
    deck.add(new Card(10, loadImage("queen.png")));
    deck.add(new Card(10, loadImage("queen.png")));
    deck.add(new Card(10, loadImage("queen.png")));
    deck.add(new Card(10, loadImage("queen.png")));
    deck.add(new Card(10, loadImage("king.jpg")));
    deck.add(new Card(10, loadImage("king.jpg")));
    deck.add(new Card(10, loadImage("king.jpg")));
    deck.add(new Card(10, loadImage("king.jpg")));
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