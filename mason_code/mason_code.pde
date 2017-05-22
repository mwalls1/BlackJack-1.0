int dealer;
int player;
boolean bust = false;
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
  //size(1000, 1000);
}
void deal()
{
  while(bust == false)
  {
    int deck = floor(random(cards.size()));
    player+=cards.get(deck).value;
    cards.remove(deck);
    int de = floor(random(cards.size()));
    dealer+=cards.get(deck).value;
  }
}