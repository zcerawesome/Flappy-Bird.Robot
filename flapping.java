import java.io.File;
import java.io.PrintWriter;
public class flapping extends Thread{
//Use a text file to communicate between the different files
  
  static KeyboardReader reader = new KeyboardReader();
  static PrintWriter pw;
  
  private boolean running = true;

  @Override
  public void run(){
    while(running){
      File obj = new File("Gravatus.txt");
    reader.pauseNothing();
    
    throwAway(obj);
    try{
      pw.println(-2);
      pw.close();
    }catch(Exception e){}
    }
    return;
  }

  private void throwAway(File f){
    try{
      pw = new PrintWriter(f);
    }catch(Exception e){}
  }
  
}