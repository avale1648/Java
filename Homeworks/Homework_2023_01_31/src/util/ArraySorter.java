package util;
import java.sql.Array;
import java.util.*;
public class ArraySorter {
    private int[] numbers;
    public ArraySorter(int length) {
        numbers = new int[length];
    }
    public void fill() {
        int i, j;
        var random = new Random();
        for(i = 0; i < numbers.length;) {
            int randomNumber = random.nextInt(numbers.length) + 1;
            for(j = 0; j < numbers.length; j++){
                if(numbers[j] == randomNumber)
                    break;
           }
           if(i == j) {
               numbers[i] = randomNumber;
               i++;
           }
       }
        System.out.println("Unsorted Array:" + toString());
    }
    public void gnomeSort() {
        var index = 0;
        while(index < numbers.length){
            if(index == 0){
                index++;
            }
            if(numbers[index] >= numbers[index - 1]) {
                index++;
            }
            else{
                int temp = 0;
                temp = numbers[index];
                numbers[index] = numbers[index - 1];
                numbers[index - 1] = temp;
                index--;
            }
        }
        System.out.println("Sorted Array:" + toString());
    }
    @Override
    public String toString()
    {
        return Arrays.toString(numbers);
    }
}
