import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;
public class Main {
  static  KeyboardReader reader = new KeyboardReader();
  static PrintWriter pw;

  static int hz = 62;

  public static void main(String[] args) {

    boolean play = true;
    File obj = new File("Gravatus.txt");
    throwAway(obj);
    int force = 0;
    try{
      pw.println(force);
      pw.close();
    } catch(Exception e){}
    int x = 0;
    int y = 25;
    int blockade = 74;
    String s1;
    double totalScore = 0;
    //Start();
    int Middle = (int) Math.random() * 21 + 2;
      try{
        while(play){
        if(blockade == 73){
            Middle = (int) (Math.random() * 21) + 3;
        } else if(blockade == 8){
            blockade = 74;
        }
        //counts to restart the blockade
        //Scans the gravatus file
        String input = scan(obj);
        force = Integer.parseInt(input);
        try{
            int forcing = force +1;
            throwAway(obj);
            pw.println(forcing);

            pw.close();
        }catch (Exception e){}
        //Calls players constructor, and changes position of blockade aferwards
        s1 = "" + totalScore;
        System.out.println("\t\t\tScore: " + s1.substring(0, 3));
        Player playa = new Player();
        System.out.println("-----------------------------------------------------------------------------------------------------");
        playa.MainIdea(x, y, force, blockade, Middle);
        System.out.println("-----------------------------------------------------------------------------------------------------");
        //multi-Theads o change acceleration
        flapping flaps = new flapping();
        flaps.start();
        try{
          Thread.sleep(hz);
          blockade--;
          flaps.interrupt();
        } catch(Exception e){}

        System.out.print("\033[H\033[2J");
        //Finds location of the player, and feeds it into the loop again
        int[] values = playa.getLocation();
        x = values[0];
        y = values[1];
        totalScore += (double) 1/49;
      }
      }catch(Exception e){
        System.out.print("\033[H\033[2J");
        System.out.print("You have died ");
        try{
            Thread.sleep(1000);
            s1 = "" + totalScore;
            System.out.print("your total score is " + s1.substring(0, 3));
        } catch(Exception j){}
        System.exit(0);
      }

  }

  public static void Start(){
    System.out.println("Welcome to Flappy Bird at Home:");
    try{
      Thread.sleep(1500);
      System.out.println("The instructions go as shown:");
    } catch(Exception e){}
    String[] s1 = {" If you touch the top or bottom barriers, you lose"
                  , " If you touch the encroaching barrier you lose"
                  , " You can ONLY press the Enter key as an input"
                  , " You can ONLY press the Enter key as a way to jump"
                  , " Press enter to continue: "};
    for(int i = 1; i <= 4; i++){
      System.out.println(i + "." + s1[i-1]);
      try{
        Thread.sleep(1500);
      }catch(Exception e){}
    }
    System.out.println(s1[4]);
    reader.readLine();
    System.out.print("\033[H\033[2J");
    for(int i = 3; i > 0; i--){
      System.out.println("\t\t\t\tThe game will start in " + i);
      try{
        Thread.sleep(1000);
        System.out.print("\033[H\033[2J");
      }catch(Exception e){}
    }

  }

  public static String scan(File f){
    try{
      Scanner scan = new Scanner(f);
      String s1 = scan.nextLine();
      scan.close();
      return s1;
    }catch(Exception e){return null;}
  }

  public static boolean isAlive(){
    return false;
  }
  
  static void throwAway(File f){
    try{
      pw = new PrintWriter(f);
    }catch(Exception e){}
  }
  
}
