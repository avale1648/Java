package util.console;
import util.calculator.CalculatorClient;
import util.rectangle.Rectangle;
import util.stringValidation.*;
import java.util.Scanner;
import java.util.Random;
public class CommandManager {
    private final Scanner SCANNER;
    private final int MAX_VALUE;
    private String input;
    public CommandManager(int maxValue) {
        SCANNER = new Scanner(System.in);
        input = "";
        this.MAX_VALUE = maxValue;
    }
    public void execute() {
        help();
        try {
            while (true) {
                input = SCANNER.nextLine();
                var split = input.split(" ");
                var command = split[0];
                if(command.equals("/rectangle") && split.length == 5){
                    var x = randomOrNumber(split[1]);
                    var y = randomOrNumber(split[2]);
                    var length = randomOrNumber(split[3]);
                    var height = randomOrNumber(split[4]);
                    var r = new Rectangle(x, y, length, height);
                    System.out.format("r: %s", r);
                }
                if(command.equals("/overlap") && split.length == 5){
                    var r1 = new Rectangle(10,10);
                    var x = randomOrNumber(split[1]);
                    var y = randomOrNumber(split[2]);
                    var length = randomOrNumber(split[3]);
                    var height = randomOrNumber(split[4]);
                    var r2 = new Rectangle(x, y, length, height);
                    var overlap = r1.overlap(r2);
                    System.out.format("r1: %s\nr2: %s\noverlap: %s", r1, r2, overlap);
                }
                if(command.equals("/validate") && split.length >= 3) {
                    StringValidationDecorator validator = null;
                    var type = split[1];
                    var validated = split[2];
                    if (split.length == 5) {
                        var condition1 = split[3];
                        var condition2 = split[4];
                        if(type.equals("or")){
                            validator = new StringValidationDecorator(new OrStringValidator(condition1, condition2));
                        }
                        if (type.equals("and")) {
                            validator = new StringValidationDecorator(new AndStringValidator(condition1, condition2));
                        }
                        if(type.equals("inverse")){
                            validator = new StringValidationDecorator(new InverseStringValidator(condition1, condition2));
                        }
                    }
                    if(type.equals("palindrome")){
                        validator = new StringValidationDecorator(new PalindromeStringValidator());
                    }
                    if(type.equals("noSpace")){
                        validator = new StringValidationDecorator(new NoSpaceStringValidator());
                    }
                    if(validator != null) {
                        System.out.println(validator.isValid(validated));
                    }
                }
                if(command.equals("/calculate")){
                    CalculatorClient calculator = new CalculatorClient();
                    calculator.execute();
                    help();
                }
                if(command.equals("/help")){
                    help();
                }
                if(command.equals("/stop")){
                    break;
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void help(){
        System.out.println("/rectangle [x:int] [y:int] [length:int] [height:int] - create a rectangle (x, y) (length, height);");
        System.out.println("/overlap [x:int] [y:int] [length:int] [height:int] - create a rectangle (x, y) (length, height) and\nget an overlap with rectangle (0, 0) (10, 10);");
        System.out.println("/validate or [validated: string] [condition1:string] [condition2:string] - check is validated string valid at least in one condition;");
        System.out.println("/validate and [validated: string] [condition1:string] [condition2:string] - check is validated string valid in both conditions;");
        System.out.println("/validate inverse [validated: string] [condition1:string] [condition2:string] - check is validated string not valid in both conditions;");
        System.out.println("/validate palindrome [validated: string] - check is validated string palindrome;");
        System.out.println("/validate noSpaces [validated: string] - check does validated string has not underscores;");
        System.out.println("/calculate - go to calculator sub-console;");
        System.out.println("/help - get list of commands;");
        System.out.println("/stop - stop process.");
    }
    private int randomOrNumber(String str) {
        var result = 0;
        if(str.equals("random")) {
            var random = new Random();
            result = random.nextInt(MAX_VALUE);
        }
        else{
            result = Integer.parseInt(str);
        }
        return result;
    }
}
