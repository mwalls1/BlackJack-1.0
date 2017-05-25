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
void setup()
{
  size(1700, 1000);
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
void draw()
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
void mousePressed()
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
     dealer.setWin(true);
     decks.setState(true);
   }
}