/* autogenerated by Processing revision 1281 on 2023-06-06 */
import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import processing.serial.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class radio_short_message extends PApplet {



static final int MESSAGE_LENGTH = 128;
Serial serialPort; 

 public void setup(){
  /* size commented out by preprocessor */;
  
  String serialDevicePath = null;
  String[] serialDevicePaths = Serial.list();
  for (String path : serialDevicePaths)
  {
    if (path.contains("usbmodem")) {
      serialDevicePath = path;
      break;
    }
  }
  
  if (serialDevicePath != null) 
  {
    serialPort = new Serial(this, serialDevicePath, 9600);
  }
}

 public void draw(){
  background(0);

  byte[] message = new byte[MESSAGE_LENGTH + 3 + 3 + 1];
  message[0] = 0x00;
  message[1] = 0x00;
  message[2] = 0x00;
  message[message.length - 3] = 0x00;
  message[message.length - 2] = 0x00;
  message[message.length - 1] = 0x00;
  serialPort.write(ledValue);
}


  public void settings() { size(500, 388); }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "radio_short_message" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
