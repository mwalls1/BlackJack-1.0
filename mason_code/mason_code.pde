int dealer;
int player;
int faceDown;
Button hit;
Button stay;
boolean bust = false;
boolean isTurn = true;
boolean playerWin = false;
boolean dealerWin = false;
boolean noWIn = false;
ArrayList<card> cards = new ArrayList<card>();
void setup()
{
  cards.add(new card(1));
  for(int i = 0; i<39; i++)
  {
    if(cards.get(i).value==10)
      cards.add(new card(1));
      else
        cards.add(new card(cards.get(i).value+1));
  }
  for(int i = 0; i < 12; i++)
  {
    cards.add(new card(10));
  }
  for(int i = 0; i<cards.size(); i++)
    print(cards.get(i).value+" ");
  size(500, 200);
  hit = new Button(50,50, "Hit");
  stay = new Button(300,50, "Stay");
  draw();
  deal();
}
void draw()
{
  background(150);
  hit.draw();
  stay.draw();
  text("Player: "+player, 10,150);
  text("Dealer: "+dealer, 100,150);
}
void deal()
{
      int draw;
      draw = floor(random(cards.size()));
      player+=cards.get(draw).value;
      cards.remove(draw);
      draw = floor(random(cards.size()));
      faceDown=cards.get(draw).value;
      cards.remove(draw);
      draw = floor(random(cards.size()));
      player+=cards.get(draw).value;
      cards.remove(draw);
      draw = floor(random(cards.size()));
      dealer+=cards.get(draw).value;
      cards.remove(draw);
      if(player>21)
      bust = true;
      print("\nPlayers hand: "+player);
}
void mousePressed()
{
  int draw;
  if(hit.over()&&isTurn == true&&bust==false)
  {
    draw = floor(random(cards.size()));
    player+=cards.get(draw).value;
    cards.remove(draw);
    print("\nPlayers hand: "+player);
    if(player>21)
    {
      bust = true;
      play();
    }
  }
  else if(stay.over())
      {
        print("\nYou stay!");
        isTurn = false;
        play();
      }
}
void play()
{
  int draw;
  if(isTurn == false&&bust == false)
  {
    dealer+=faceDown;
    print("\nDealers hand: "+dealer);
    while(dealer<17)
    {
      draw = floor(random(cards.size()));
      dealer+=cards.get(draw).value;
      print("\nDealer draws: "+cards.get(draw).value);
      cards.remove(draw);
      print("\nDealers hand: "+dealer);
    }
    if(dealer>player&&dealer<=21)
    {
    print("\nDealer Wins!");
    dealerWin = true;
    }
    else if(player==dealer)
    {
    print("\nDraw!");
    noWIn = true;
    }
    else
    {
    print("\nPlayer Wins!");
    playerWin = true;
    }
  }
  if(bust == true)
  print("\nDealer Wins!");
}