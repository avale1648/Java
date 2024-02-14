package util;
public class LeapYearChecker {
    private int year;
    public LeapYearChecker() {
        year = 0;
    }
    public LeapYearChecker(int year) {
        this.year = year;
    }
    public boolean isLeap() {
        boolean leap = false;
        if(year % 4 == 0) {
            if(year % 100 == 0) {
                if(year % 400 == 0)
                    leap = true;
                else
                    leap = false;
            }
            else
                leap = true;
        }
        else
            leap = false;
        return leap;
    }
    @Override
    public String toString()
    {
        return year + " is" + (isLeap()? "": " not") + " leap year.";
    }
}
