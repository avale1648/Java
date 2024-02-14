package util;
public class ByteSwapper {
    private int number = 0;
    public ByteSwapper(int number) {
        this.number = number;
    }
    public int getSwapped() {
        return number & 0xffff0000 | ((number & 0xff00) >> 8) | ((number & 0xff) << 8);
    }
    @Override
    public String toString()
    {
        return "Original: " + number + " Swapped: " + getSwapped();
    }
}
