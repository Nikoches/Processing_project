import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import controlP5.*; 
import processing.serial.*; 
import processing.video.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Workable extends PApplet {




Serial serial;
String received;
ControlP5 cp5;
Capture cam;
int a;
Textlabel myTextlabelA;
Textlabel myTextlabelB; 
public void setup() {
 // PImage titlebaricon = loadImage("1.png"); surface.setIcon(titlebaricon);
  String[] cameras = Capture.list();
  cp5 = new ControlP5(this);
  
  noStroke();
  //String port = Serial.list()[0];
  //serial = new Serial(this, port, 9600);
   cam = new Capture(this,320,240, cameras[0]);
    cam.start();
    
   myTextlabelA = cp5.addTextlabel("label")
                    .setText("water="+a)
                    .setPosition(400,40)
                    .setColorValue(0xff000000)
                    .setFont(createFont("Times New Roman",20))
                    ;
 myTextlabelB = cp5.addTextlabel("label1")
                    .setText("HC-SR04="+a+"m")
                    .setPosition(400,80)
                    .setColorValue(0xff000000)
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
   
  
  public void draw() {
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
  public void settings() {  size(640,480); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Workable" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
