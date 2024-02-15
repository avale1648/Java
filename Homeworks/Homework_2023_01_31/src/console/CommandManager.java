package console;
import util.*;

import java.util.Random;
import java.util.Scanner;
public class CommandManager {
    private Scanner scanner;
    private String input;
    private int maxValue;
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
                if (split[0].equals("/checkIsLeap")) {
                    var year = randomOrNumber(split[1]);
                    var leapYearChecker = new LeapYearChecker(year);
                    System.out.println(leapYearChecker.toString());
                }
                if (split[0].equals("/swapBytes")) {
                    var number = randomOrNumber(split[1]);
                    var byteSwapper = new ByteSwapper(number);
                    System.out.println(byteSwapper.toString());
                }
                if (split[0].equals("/collatzCount")) {
                    var number = randomOrNumber(split[1]);
                    var collatzCounter = new CollatzCounter(number);
                    collatzCounter.count();
                }
                if (split[0].equals("/zeroOneCount")) {
                    var length = randomOrNumber(split[1]);
                    var zeroOneCounter = new ZeroOneCounter(length);
                    zeroOneCounter.count();
                    System.out.println(zeroOneCounter.toString());
                }
                if (split[0].equals("/sortArray")) {
                    var length = randomOrNumber(split[1]);
                    var arraySorter = new ArraySorter(length);
                    arraySorter.fill();
                    arraySorter.gnomeSort();
                }
                if (input.equals("/help")) {
                    System.out.println(
                            "/checkIsLeap [year] - check is [year] leap or not;\n" +
                                    "/swapBytes [number] - swap two lower and upper bytes in [number];\n" +
                                    "/collatzCount [number] - calculate Collatz Conjecture for [number];\n" +
                                    "/zeroOneCount [length] - count zeros and ones in array of [length];\n" +
                                    "/sortArray [length] - sort array with length [length];\n" +
                                    "/stop - stops execution.\n\n" +
                                    "[year],[number],[length] - integer parameter, use \"random\" to generate a random number."
                    );
                }
                if (input.equals("/stop")) {
                    break;
                }
            }
        } catch (Exception e){
            System.out.println(e.toString());
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
