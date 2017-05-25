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
  void draw(){
    fill(r,g,b);
    if(over()){
  fill(255-r,255-g,255-b);
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