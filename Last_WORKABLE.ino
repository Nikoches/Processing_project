int EN1 = 22; //Подкючение первого движка 
int IN1 = 24; 
int IN2 = 26;
int EN2 = 32; //Подкючение второго движка
int IN3 = 28;
int IN4 = 30;
int LED1 = 52;
char val;
void setup()
{
 Serial.begin(9600);
pinMode (EN1, OUTPUT);
pinMode(LED1, OUTPUT);
       pinMode (EN2, OUTPUT);
       pinMode (IN1, OUTPUT);
       pinMode (IN2, OUTPUT);
       pinMode (IN3, OUTPUT);
       pinMode (IN4, OUTPUT);
}
void loop()
{


if (Serial.available()) {         
    val = Serial.read();           
    if (val == 's') {              
       digitalWrite(IN1, HIGH); // запуск двигателя A
       digitalWrite(IN2, LOW);
       digitalWrite(IN3, HIGH);// запуск двигателя B
       digitalWrite(IN4, LOW);
       analogWrite(EN2, 200); // устанавливаем скорость 200 из доступного диапазона 0~255
       analogWrite(EN1, 200);
    }
    if (val == 'a') {              
       digitalWrite(IN1, LOW);// выключаем двигатели
       digitalWrite(IN2, LOW);
       digitalWrite(IN3, LOW);
       digitalWrite(IN4, LOW); 
   }
    if (val == 'd') {
       digitalWrite(IN1, LOW);// меняем направление вращения двигателей
       digitalWrite(IN2, HIGH);
       digitalWrite(IN3, LOW);
       digitalWrite(IN4, HIGH);

      }
if (val == 'f') {
  digitalWrite(LED1, HIGH);
      }
if (val == 'o') {
  digitalWrite(LED1, LOW);
      }
   
  }
 }





  
  // На пару выводов "IN" поданы разноименные сигналы, мотор готов к вращению
 // digitalWrite (IN3, HIGH);
 // digitalWrite (IN4, LOW);
  // подаем на вывод ENB управляющий ШИМ сигнал 
//  analogWrite(ENB,145);
 // delay(2000);
  //analogWrite(ENB,105);
  //delay(2000);
  //analogWrite(ENB,255);
  //delay(2000);
  // Останавливаем мотор, подав на вывод ENB сигнал низкого уровня. 
  // Состояние выводов "IN" роли не играет.
  //analogWrite(ENB,0);
  //delay(5000);
//}
