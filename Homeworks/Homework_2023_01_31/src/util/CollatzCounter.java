package util;
public class CollatzCounter {
    private int number;
    private int steps = 0;
    public CollatzCounter(int number) {
        this.number = number;
    }
    public void count() {
        System.out.print(number);
        while(number != 1) {
            if(number % 2 == 0) {
                number = number / 2;
                steps++;
            }
            else {
                number = 3 * number + 1;
                steps++;
            }
            System.out.print(" -> " + number);
        }
        System.out.println("\n" + this.toString());
    }
    @Override
    public String toString() {
        return "Number: " + number + " Steps: " + steps;
    }
}
