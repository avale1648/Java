package console;
import util.Rectangle;
import java.util.Scanner;
import java.util.Random;
public class CommandManager {
    private final Scanner scanner;
    private final int maxValue;
    private String input;
    public CommandManager(int maxValue) {
        scanner = new Scanner(System.in);
        input = "";
        this.maxValue = maxValue;
    }
    public void execute() {
        System.out.println("type /help to see commands.");
        try {
            while (true) {
                input = scanner.nextLine();
                var split = input.split(" ");
                if(split[0].equals("/help")){
                    System.out.println();
                }
                if(split[0].equals("/rectangle") && split.length == 5){
                    var x = randomOrNumber(split[1]);
                    var y = randomOrNumber(split[2]);
                    var length = randomOrNumber(split[3]);
                    var height = randomOrNumber(split[4]);
                    var r = new Rectangle(x, y, length, height);
                    System.out.println(String.format("r: %s", r));
                }
                if(split[0].equals("/overlap") && split.length == 5){
                    var r1 = new Rectangle(10,10);
                    var x = randomOrNumber(split[1]);
                    var y = randomOrNumber(split[2]);
                    var length = randomOrNumber(split[3]);
                    var height = randomOrNumber(split[4]);
                    var r2 = new Rectangle(x, y, length, height);
                    var overlap = r1.overlap(r2);
                    System.out.println(String.format("r1: %s\nr2: %s\noverlap: %s", r1, r2, overlap));
                }
                if(split[0].equals("/stop")){
                    break;
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
    private int randomOrNumber(String str) {
        var result = 0;
        if(str.equals("random")) {
            var random = new Random();
            result = random.nextInt(maxValue);
        }
        else{
            result = Integer.parseInt(str);
        }
        return result;
    }
}
