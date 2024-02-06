void setup()
{
Serial.begin(9600);
pinMode(12,OUTPUT);
digitalWrite(12,HIGH);
}

void loop()
{
  if(Serial.available()>0){
    char inChar =Serial.read();
      if(inChar=='1')
      {
      digitalWrite(12,LOW);
      }
      else if(inChar=='0')
      {
      digitalWrite(12,HIGH);
      }
  }
}
