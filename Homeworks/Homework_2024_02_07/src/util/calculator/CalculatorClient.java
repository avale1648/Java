package util.calculator;
import java.util.Scanner;
public class CalculatorClient {
    private final CalculatorSwitch COMMANDS;
    private final CalculatorReceiver RECEIVER;
    private final Scanner SCANNER;
    private String input;
    private Boolean isRunning;
    public CalculatorClient(){
        COMMANDS = new CalculatorSwitch();
        SCANNER = new Scanner(System.in);
        input = "";
        isRunning = true;
        RECEIVER = new CalculatorReceiver();
        COMMANDS.register("/add", RECEIVER::add);
        COMMANDS.register("/sub", RECEIVER::sub);
        COMMANDS.register("/mul", RECEIVER::mul);
        COMMANDS.register("/div", RECEIVER::div);
        COMMANDS.register("/undo", RECEIVER::undo);
        COMMANDS.register("/redo", RECEIVER::redo);
        COMMANDS.register("/help", (int n) -> {
            System.out.println("/add [n: float] - add n to current number;");
            System.out.println("/sub [n: float] - subtract n from current number;");
            System.out.println("/mul [n: float] - multiply current number on n;");
            System.out.println("/div [n: float] - divide current number on n;");
            System.out.println("/undo - undo action;");
            System.out.println("/redo - redo action;");
            System.out.println("/help - get list of commands;");
            System.out.println("/back - back to main console.");
        });
        COMMANDS.register("/back", (int n) -> {
            isRunning = false;
            System.out.println("Back to main console...");
        });
    }
    public void execute(){
        COMMANDS.execute("/help", 0);
        System.out.println(RECEIVER);
        while(isRunning){
            try {
                input = SCANNER.nextLine();
                var split = input.split(" ");
                RECEIVER.setOldToCurrent();
                var command = split[0];
                var n = 0;
                if(split.length == 2){
                    n = Integer.parseInt(split[1]);
                }
                COMMANDS.execute(command, n);
                RECEIVER.push();
                System.out.println(RECEIVER);
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}
