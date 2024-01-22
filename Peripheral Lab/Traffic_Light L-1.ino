
int red = 9;
int yellow = 8;
int green = 7;

void setup(){
  
  pinMode(red, OUTPUT);
  pinMode(yellow, OUTPUT);
  pinMode(green,  OUTPUT);
  
}
void loop(){
digitalWrite(red, HIGH);
 delay(3000);
digitalWrite(red,  LOW);
  
  digitalWrite(yellow, HIGH);
delay(1000);
  digitalWrite(yellow,  LOW);
  
digitalWrite(green, HIGH);
delay(3000);
digitalWrite(green,  LOW);
  
digitalWrite(yellow, HIGH);
delay(1000);
  digitalWrite(yellow,  LOW);
 
}
