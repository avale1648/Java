package util;
import java.sql.Array;
import java.util.*;
public class ArraySorter {
    private int length;
    private ArrayList<Integer> numbers;
    public ArraySorter(int length) {
        this.length = length;
        numbers = new ArrayList<Integer>();
    }
    public void fill() {
       var random = new Random();
        while(numbers.size() < length) {
           var a = random.nextInt(length) + 1;
           if(!numbers.contains(a)){
               numbers.add(a);
           }
       }
        System.out.println("Unsorted array:" + numbers);
    }
    public void gnomeSort() {
        var index = 0;
        while(index < numbers.size()) {
            if (index == 0) {
                index++;
            }
            if (numbers.get(index) >= numbers.get(index - 1)) {
                index++;
            } else {
                int temp = 0;
                temp = numbers.get(index);
                numbers.set(index, numbers.get(index - 1));
                numbers.set(index - 1, temp);
                index--;
            }
        }
        System.out.println("Sorted array:" + numbers);
    }
}
