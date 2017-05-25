class Button{
  int x,y;
  String label;
  Button(int x, int y, String label){
    this.x = x;
    this.y = y;
    this.label = label;
  }
  void draw(){
    fill(255,255,255);
    if(over()){
  fill(255,255,0);
    }
    rect(x, y, 120, 30);
    fill(0);
    text(label, x+20, y + 20);
  }
  boolean over(){
    if(mouseX >= x && mouseY >= y && mouseX <= x + 100 && mouseY <= y + 30){
  return true;
    }
    return false;
  }
}