import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class BlackJack extends PApplet {

Dealer dealer;
Player user;
Deck decks;
Button doubleDown;
Button hit;
Button stay;
Button replay;
Button bet5;
boolean hasHit = false;
Button bet10;
Button bet15;
public void setup()
{
  
  user = new Player();
  dealer = new Dealer();
  decks = new Deck();
  hit = new Button(50, 50, "Hit");
  stay = new Button(250, 50, "Stay");
  replay = new Button(700, 50, "Replay");
  bet5 = new Button(50, 200, "Bet $5");
  bet10 = new Button(150, 200, "Bet $10");
  bet15 = new Button(250, 200, "Bet $15");
  doubleDown = new Button(450,50,"Double Down");
}
public void draw()
{
  background(100);
  doubleDown.draw();
  hit.draw();
  stay.draw();
  replay.draw();
  bet5.draw();
  bet10.draw();
  bet15.draw();
  text("Player: "+user.getHand(), 10, 150);
  text("Dealer: "+dealer.getHand(), 100, 150);
  text("Cash: $"+money, 200, 150);
  text("Bet: $"+bet, 350, 150);
  user.paint();
  dealer.paint();
  if(decks.gameOver())
  {
    if(user.hasWon())
    {
      text("Player Wins!", 500, 150);
      text("+"+user.getMoneyWon(), 233, 170);
    }
    else if(dealer.hasWon())
      text("Dealer Wins!", 500, 150);
    else
    {
      text("Its a draw!", 500, 150);
      text("+"+user.getMoneyWon(), 233, 170);
    }
  }
}
public void mousePressed()
{
  if(!user.hasBet()&&bet5.over())
  {
    user.placeBet(5);
    decks.deal(user,dealer);
  }
  if(!user.hasBet()&&bet10.over())
  {
    user.placeBet(10);
    decks.deal(user,dealer);
    gameOver();
  }
  if(!user.hasBet()&&bet15.over())
  {
    user.placeBet(15);
    decks.deal(user,dealer);
    gameOver();
  }
  if(user.turnState()&&hit.over())
  {
    user.addCard(decks.drawCard());
    hasHit=true;
    gameOver();
  }
  if(user.turnState()&&doubleDown.over()&&!hasHit)
  {
    user.placeBet(user.getBet());
    user.addCard(decks.drawCard());
    hasHit=true;
    user.setTurn(false);
    gameOver();
    decks.dealerTurn(dealer,user);
  }
  if(stay.over()&&user.hasBet()&&user.turnState())
  {
    user.setTurn(false);
    decks.dealerTurn(dealer,user);
  }
  if(replay.over()&&decks.gameOver())
  {
    hasHit=false;
    decks.resetGame(dealer,user);
  }
}
public void gameOver()
{
  if(user.getHand()==21)
  {
    user.setTurn(false);
    user.setWin(true);
    user.addMoney(3);
    decks.setState(true);
  }
  else if(user.getHand()>21)
   {
     user.setTurn(false);
     dealer.setWin(true);
     decks.setState(true);
   }
}
class Button{
  int x,y;
  int r = floor(random(255));
  int g= floor(random(255));
  int b= floor(random(255));
  String label;
  Button(int x, int y, String label){
    this.x = x;
    this.y = y;
    this.label = label;
  }
  public void draw(){
    fill(r,g,b);
    if(over()){
  fill(255-r,255-g,255-b);
    }
    rect(x, y, 120, 30);
    fill(0);
    text(label, x+20, y + 20);
  }
  public boolean over(){
    if(mouseX >= x && mouseY >= y && mouseX <= x + 100 && mouseY <= y + 30){
  return true;
    }
    return false;
  }
}
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
  public void settings() {  size(1700, 1000); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "BlackJack" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
