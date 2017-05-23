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

public class mason_code extends PApplet {

int dealer;
int player;
int faceDown;
Button hit;
Button stay;
Button replay;
boolean bust = false;
boolean isTurn = true;
boolean playerWin = false;
boolean dealerWin = false;
boolean noWIn = false;
boolean gameOver = false;
boolean gameOn = false;
ArrayList<card> cards = new ArrayList<card>();
ArrayList<card> dealersHand = new ArrayList<card>();
ArrayList<card> playersHand = new ArrayList<card>();
card faceDownCard;
public void setup()
{
  
  
  hit = new Button(50,50, "Hit");
  stay = new Button(300,50, "Stay");
  replay = new Button(700,50,"Replay");
  newGame();
}
public void draw()
{
  background(150);
  paintPlayer();
  paintDealer();
  hit.draw();
  stay.draw();
  replay.draw();
  text("Player: "+player, 10,150);
  text("Dealer: "+dealer, 100,150);
  if(playerWin==true)
  text("Player Wins!",200,150);
  else if(dealerWin==true)
  text("Dealer Wins!",200,150);
  else if(noWIn==true)
  text("Its a draw!",200,150);

}
public void mousePressed()
{
  int draw;
  if(hit.over()&&isTurn == true&&bust==false)
  {
    draw = floor(random(cards.size()));
    player+=cards.get(draw).value;
    playersHand.add(cards.get(draw));
    cards.remove(draw);
    print("\nPlayers hand: "+player);
    if(player>21)
    {
      bust = true;
      isTurn = false;
      play();
    }
  }
  else if(stay.over()&&isTurn==true)
      {
        print("\nYou stay!");
        isTurn = false;
        play();
   }
   if(replay.over()&&gameOver==true)
   newGame();
}
public void play()
{
  if(player>21)
  dealerWin = true;
  if(player==21)
  playerWin = true;
  int draw;
  if(isTurn == false&&bust == false)
  {
    dealer+=faceDown;
    dealersHand.add(faceDownCard);
    print("\nDealers hand: "+dealer);
    while(dealer<17)
    {
      draw = floor(random(cards.size()));
      dealer+=cards.get(draw).value;
      dealersHand.add(cards.get(draw));
      print("\nDealer draws: "+cards.get(draw).value);
      cards.remove(draw);
      print("\nDealers hand: "+dealer);
    }
    if(dealer>player&&dealer<=21)
    {
    print("\nDealer Wins!");
    dealerWin = true;
    gameOver = true;
    }
    else if(player==dealer)
    {
    print("\nDraw!");
    gameOver = true;
    noWIn = true;
    }
    else
    {
    print("\nPlayer Wins!");
    gameOver = true;
    playerWin = true;
    }
  }
  if(bust == true)
  {
  dealerWin = true;
  print("\nDealer Wins!");
  gameOver = true;
  }
}
public void paintPlayer()
{
  for(int i =0; i<playersHand.size(); i++)
  {
    image(playersHand.get(i).image, 100+i*100,400);
  }
}
public void paintDealer()
{
  for(int i =0; i<dealersHand.size(); i++)
  {
    image(dealersHand.get(i).image, 900+i*100,400);
  }
}
public void newGame()
{
  gameOver = false;
  isTurn = true;
  bust = false;
  playerWin = false;
  dealerWin = false;
  noWIn = false;
  while(cards.size()>0)
    cards.remove(0);
  while(dealersHand.size()>0)
    dealersHand.remove(0);
   while(playersHand.size()>0)
     playersHand.remove(0);
  player = 0;
  dealer = 0;
  cards.add(new card(1,loadImage("ace.png")));
  cards.add(new card(1,loadImage("ace.png")));
  cards.add(new card(1,loadImage("ace.png")));
  cards.add(new card(1,loadImage("ace.png")));
  cards.add(new card(2,loadImage("2.png")));
  cards.add(new card(2,loadImage("2.png")));
  cards.add(new card(2,loadImage("2.png")));
  cards.add(new card(2,loadImage("2.png")));
  cards.add(new card(3,loadImage("3.png")));
  cards.add(new card(3,loadImage("3.png")));
  cards.add(new card(3,loadImage("3.png")));
  cards.add(new card(3,loadImage("3.png")));
  cards.add(new card(4,loadImage("4.png")));
  cards.add(new card(4,loadImage("4.png")));
  cards.add(new card(4,loadImage("4.png")));
  cards.add(new card(4,loadImage("4.png")));
  cards.add(new card(5,loadImage("5.png")));
  cards.add(new card(5,loadImage("5.png")));
  cards.add(new card(5,loadImage("5.png")));
  cards.add(new card(5,loadImage("5.png")));
  cards.add(new card(6,loadImage("6.png")));
  cards.add(new card(6,loadImage("6.png")));
  cards.add(new card(6,loadImage("6.png")));
  cards.add(new card(6,loadImage("6.png")));
  cards.add(new card(7,loadImage("7.png")));
  cards.add(new card(7,loadImage("7.png")));
  cards.add(new card(7,loadImage("7.png")));
  cards.add(new card(7,loadImage("7.png")));
  cards.add(new card(8,loadImage("8.png")));
  cards.add(new card(8,loadImage("8.png")));
  cards.add(new card(8,loadImage("8.png")));
  cards.add(new card(8,loadImage("8.png")));
  cards.add(new card(9,loadImage("9.png")));
  cards.add(new card(9,loadImage("9.png")));
  cards.add(new card(9,loadImage("9.png")));
  cards.add(new card(9,loadImage("9.png")));
  cards.add(new card(10,loadImage("10.png")));
  cards.add(new card(10,loadImage("10.png")));
  cards.add(new card(10,loadImage("10.png")));
  cards.add(new card(10,loadImage("10.png")));
  cards.add(new card(10,loadImage("jack.png")));
  cards.add(new card(10,loadImage("jack.png")));
  cards.add(new card(10,loadImage("jack.png")));
  cards.add(new card(10,loadImage("jack.png")));
  cards.add(new card(10,loadImage("queen.png")));
  cards.add(new card(10,loadImage("queen.png")));
  cards.add(new card(10,loadImage("queen.png")));
  cards.add(new card(10,loadImage("queen.png")));
  cards.add(new card(10,loadImage("king.jpg")));
  cards.add(new card(10,loadImage("king.jpg")));
  cards.add(new card(10,loadImage("king.jpg")));
  cards.add(new card(10,loadImage("king.jpg")));
  int draw;
  draw = floor(random(cards.size()));
  player+=cards.get(draw).value;
  playersHand.add(cards.get(draw));
  cards.remove(draw);
  draw = floor(random(cards.size()));
  faceDown=cards.get(draw).value;
      faceDownCard = cards.get(draw);
      cards.remove(draw);
      draw = floor(random(cards.size()));
      player+=cards.get(draw).value;
      playersHand.add(cards.get(draw));
      cards.remove(draw);
      draw = floor(random(cards.size()));
      dealer+=cards.get(draw).value;
      dealersHand.add(cards.get(draw));
      cards.remove(draw);
      if(player>21)
      bust = true;
      print("\nPlayers hand: "+player);
      gameOn = true;
}
class Button{
  int x,y;
  String label;
  Button(int x, int y, String label){
    this.x = x;
    this.y = y;
    this.label = label;
  }
  public void draw(){
    fill(200);
    if(over()){
  fill(255);
    }
    rect(x, y, 100, 30);
    fill(0);
    text(label, x+45, y + 20);
  }
  public boolean over(){
    if(mouseX >= x && mouseY >= y && mouseX <= x + 100 && mouseY <= y + 30){
  return true;
    }
    return false;
  }
}
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
  public void settings() {  size(1920, 1080); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "mason_code" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
