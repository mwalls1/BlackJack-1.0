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
Button quit;
void setup()
{
  fullScreen();
  user = new Player();
  dealer = new Dealer();
  decks = new Deck();
  hit = new Button(20, 50, "Hit");
  stay = new Button(150, 50, "Stay");
  replay = new Button(280, 50, "Replay");
  bet5 = new Button(20, 200, "Bet $5");
  bet10 = new Button(150, 200, "Bet $10");
  bet15 = new Button(280, 200, "Bet $15");
  doubleDown = new Button(410,50,"Double Down");
  quit = new Button(abs(displayWidth-200),50,"Quit");
}
void draw()
{
  textSize(14);
  background(20,100,20);
  doubleDown.draw();
  hit.draw();
  stay.draw();
  replay.draw();
  bet5.draw();
  bet10.draw();
  bet15.draw();
  quit.draw();
  textSize(20);
  fill(255,255,255);
  text("Players Hand:",20,360);
  text("Dealers Hand:",displayWidth/2,360);
  text("Player: "+user.getHand(), 20, 150);
  text("Dealer: "+dealer.getHand(), 130, 150);
  text("Cash: $"+money, 240, 150);
  text("Bet: $"+bet, 360, 150);
  textSize(14);
  user.paint();
  dealer.paint();
  if(decks.gameOver())
  {
    if(user.hasWon())
    {
      fill(0,255,0);
      textSize(20);
      text("Player Wins!", 500, 150);
      text("+"+user.getMoneyWon(), 295, 175);
    }
    else if(dealer.hasWon())
    {
      fill(255,0,0);
      textSize(20);
      text("Dealer Wins!", 500, 150);
    }
    else
    {
      fill(40,40,40);
      textSize(20);
      text("Its a draw!", 500, 150);
      text("+"+user.getMoneyWon(), 295, 175);
    }
  }
}
void mousePressed()
{
  if(!user.hasBet()&&bet5.over()&&user.getMoney()>=5)
  {
    user.placeBet(5);
    decks.deal(user,dealer);
  }
  if(!user.hasBet()&&bet10.over()&&user.getMoney()>=10)
  {
    user.placeBet(10);
    decks.deal(user,dealer);
    gameOver();
  }
  if(!user.hasBet()&&bet15.over()&&user.getMoney()>=15)
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
  if(user.turnState()&&doubleDown.over()&&!hasHit&&user.getMoney()>=user.getBet())
  {
    user.placeBet(user.getBet());
    user.addCard(decks.drawCard());
    hasHit=true;
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
  if(quit.over())
  {
    exit();
  }
}
void gameOver()
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
     user.setWin(false);
     dealer.setWin(true);
     decks.setState(true);
   }
}