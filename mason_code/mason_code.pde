int dealer;
int player;
int faceDown;
boolean cosmic = false;
Button hit;
Button stay;
Button replay;
Button bet5;
Button bet10;
Button bet15;
int money = 100;
int bet;
boolean madeBet = false;
boolean bust = false;
boolean isTurn = false;
boolean playerWin = false;
boolean dealerWin = false;
boolean noWIn = false;
boolean gameOver = false;
boolean gameOn = false;
ArrayList<card> cards = new ArrayList<card>();
ArrayList<card> dealersHand = new ArrayList<card>();
ArrayList<card> playersHand = new ArrayList<card>();
card faceDownCard;
int r;
int g;
int b;
void setup()
{
  
  size(1500, 1000);
  hit = new Button(50,50, "Hit");
  stay = new Button(300,50, "Stay");
  replay = new Button(700,50,"Replay");
  bet5 = new Button(50,200,"Bet $5");
  bet10 = new Button(150,200,"Bet $10");
  bet15 = new Button(250,200,"Bet $15");
}
void draw()
{
  if(keyPressed)
  {
    if(key == 32)
    {
      cosmic = !cosmic;
    }
  }
  r = floor(random(255));
  g = floor(random(255));
  b = floor(random(255));
  textSize(15);
  if(cosmic)
    background(r,g,b);
  else
    background(100,100,100);
  paintPlayer();
  paintDealer();
  hit.draw();
  stay.draw();
  replay.draw();
  bet5.draw();
  bet10.draw();
  bet15.draw();
  text("Player: "+player, 10,150);
  text("Dealer: "+dealer, 100,150);
  text("Cash: $"+money,200,150);
  text("Bet: $"+bet,350,150);
  if(madeBet == false)
  {
  textSize(50);
  text("Please make a bet",300,500);
  textSize(10);
  }
  if(playerWin==true)
  text("Player Wins!",500,150);
  else if(dealerWin==true)
  text("Dealer Wins!",500,150);
  else if(noWIn==true)
  text("Its a draw!",500,150);

}
void mousePressed()
{
  int draw;
  if(madeBet == false&&bet5.over()&&money>=5)
  {
    newGame();
    bet+=5;
    money-=5;
    madeBet = true;
    isTurn = true;
    redraw();
  }
  else if(madeBet == false&&bet10.over()&&money>=10)
  {
    newGame();
    bet+=10;
    money-=10;
    madeBet = true;
    isTurn = true;
    redraw();
  }
  else if(madeBet == false&&bet15.over()&&money>=15)
  {
    newGame();
    bet+=15;
    money-=15;
    madeBet = true;
    isTurn = true;
    redraw();
  }
  if(hit.over()&&isTurn == true&&bust==false&&madeBet == true)
  {
    draw = floor(random(cards.size()));
    player+=cards.get(draw).value;
    playersHand.add(cards.get(draw));
    cards.remove(draw);
    print("\nPlayers hand: "+player);
    if(player == 21)
    {
      isTurn = false;
      play();
    }
    else if(player>21)
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
   clear();
}
void play()
{
  if(player>21)
  {
    dealerWin = true;
    gameOver = true;
  }
  if(player==21)
  {
    playerWin = true;
    money+=bet*3;
    bet = 0;
    gameOver = true;
  }
  int draw;
  if(isTurn == false&&bust == false&& gameOver == false)
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
      redraw();
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
    money+=bet;
    noWIn = true;
    }
    else
    {
    print("\nPlayer Wins!");
    gameOver = true;
    money+=bet*2;
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
void paintPlayer()
{
  for(int i =0; i<playersHand.size(); i++)
  {
    image(playersHand.get(i).image, 100+i*110,400);
  }
}
void paintDealer()
{
  for(int i =0; i<dealersHand.size(); i++)
  {
    image(dealersHand.get(i).image, 900+i*110,400);
  }
}
void newGame()
{
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
void clear()
{
  bet = 0;
  player = 0;
  dealer = 0;
  while(cards.size()>0)
    cards.remove(0);
  while(dealersHand.size()>0)
    dealersHand.remove(0);
   while(playersHand.size()>0)
     playersHand.remove(0);
     madeBet = false;
     bust = false;
     isTurn = false;
     playerWin = false; 
     dealerWin = false;
     noWIn = false; 
     gameOver = false; 
     gameOn = false;
}
void keyPressed()
{
  
}