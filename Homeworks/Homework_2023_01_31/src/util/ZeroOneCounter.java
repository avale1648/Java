package util;
//
import java.util.Random;
//
public class ZeroOneCounter {
    private int zeros;
    private int ones;
    private int[] numbers;
    public ZeroOneCounter(int length) {
        var random = new Random();
        zeros = 0;
        ones = 0;
        numbers = new int[length];
        for(var i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1 + 1);
        }
    }
    public void count(){
        for (var i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                zeros++;
            } else {
                ones++;
            }
        }
    }
    @Override
    public String toString() {
        return "Array's Length: " + numbers.length + " Zeros: " + zeros + " Ones: " + ones + " Zeros and Ones: " + (zeros + ones);
    }
}
