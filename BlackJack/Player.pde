private int hand;
private int money;
private int bet;
private int moneyWon;
private boolean madeBet;
private boolean playerAce;
private boolean win;
private boolean isTurn;
ArrayList<Card> playerCards = new ArrayList<Card>();
public class Player
{
  private Player()
  {
    win  = false;
    madeBet = false;
    playerAce = false;
    hand = 0;
    money = 100;
    bet = 0;
    moneyWon = 0;
  }
  private void addCard(Card a)
  {
    if (isTurn&&a.getValue() == 1&&!playerAce&&hand<=10)
    {
        playerCards.add(a);
        hand+=11;
        playerAce = true;
        if(hand==21)
          isTurn = false;

    } else if(isTurn)
    {
      if(hand>10&&a.getValue() == 1)
      {
        hand+=1;
              playerCards.add(a);
      }
      else if(playerAce&&a.getValue()+hand>21)
      {
        hand+=a.getValue()-10;
        playerCards.add(a);
        playerAce = false;
      }
      else
      {
        hand+=a.getValue();
              playerCards.add(a);
      }

    }
  }
  private int getHand()
  {
    return hand;
  }
  private void resetData()
  {
    hand = 0;
    bet = 0;
    playerAce = false;
    moneyWon = 0;
  }
  private void paint()
  {
    for (int i =0; i<playerCards.size(); i++)
    {
      image(playerCards.get(i).image, 100+i*110, 400);
    }
  }
  private void placeBet(int a)
  {
    money-=a;
    bet+=a;
    madeBet = true;
    isTurn = true;
  }
  private int getMoney()
  { 
    return money;
  }
  private int getBet()
  {
    return bet;
  }
  private boolean hasBet()
  {
    return madeBet;
  }
  private void setTurn(boolean a)
  {
    isTurn = a;
  }
  private void setWin(boolean a)
  {
     win = a;
  }
  private boolean hasWon()
  {
    return win;
  }
  private boolean turnState()
  {
    return isTurn;
  }
  private void addMoney(int a)
  {
    money+=getBet()*a;
    moneyWon=getBet()*a;
  }
  private void clearHand()
  {
    ArrayList<Card> a = new ArrayList<Card>();
    playerCards = a;
  }
  private void setHasBet(boolean a)
  {
    madeBet = a;
  }
  private int getMoneyWon()
  {
     return moneyWon;
  }
}