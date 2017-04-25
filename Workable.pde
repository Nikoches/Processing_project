import controlP5.*;
import processing.serial.*;
import processing.video.*;
Serial serial;
String received;
ControlP5 cp5;
Capture cam;
int a;
Textlabel myTextlabelA;
Textlabel myTextlabelB; 
void setup() {
 // PImage titlebaricon = loadImage("1.png"); surface.setIcon(titlebaricon);
  String[] cameras = Capture.list();
  cp5 = new ControlP5(this);
  size(640,480);
  noStroke();
  //String port = Serial.list()[0];
  //serial = new Serial(this, port, 9600);
   cam = new Capture(this,320,240, cameras[0]);
    cam.start();
    
   myTextlabelA = cp5.addTextlabel("label")
                    .setText("water="+a)
                    .setPosition(400,40)
                    .setColorValue(#000000)
                    .setFont(createFont("Times New Roman",20))
                    ;
 myTextlabelB = cp5.addTextlabel("label1")
                    .setText("HC-SR04="+a+"m")
                    .setPosition(400,80)
                    .setColorValue(#000000)
                    .setFont(createFont("Georgia",20))
                    ;   
  
  cp5.addButton("Forward")
     .setPosition(560,400)
     .updateSize()
     ;  
     
      cp5.addButton("stop")
     .setPosition(560,420)

     .updateSize()
     ;
  cp5.addButton("Backward")
     .setPosition(560,440)

     .updateSize()
     ;
      cp5.addButton("TurnonLights")
     .setPosition(20,400)

     .updateSize()
     ;
      cp5.addButton("TurnoffLights")
     .setPosition(20,420)

     .updateSize()
     ;
      cp5.addButton("Move up")
     .setPosition(100,400)

     .updateSize()
     ;
      cp5.addButton("Move Down")
     .setPosition(100,420)

     .updateSize()
     ;
     
 }
   
  
  void draw() {
    background(255, 204, 0);
   if (cam.available() == true) {
    cam.read();
  }
  image(cam, 20, 20);
  
  }
  
  public static void controlEvent(ControlEvent theEvent) {
  println(theEvent.getController().getName());
}
public void Forward() {
  serial.write('s');
}
public void TurnonLights() {
  serial.write('f');
}
public void TurnoffLights() {
  serial.write('o');
}

public void stop() {
 serial.write('a');
}
 public void Backward() {
 serial.write('2');
}

public void keyPressed(){
if ( key == CODED ) {
if ( keyCode == RIGHT ) {a=10;serial.write('a');
} else if ( keyCode == LEFT ) { a= 10;serial.write('s');
} else if ( keyCode == UP ) { a -= 10;serial.write('0');
} else if ( keyCode == DOWN ) { a += 10;stop();
}
}
}