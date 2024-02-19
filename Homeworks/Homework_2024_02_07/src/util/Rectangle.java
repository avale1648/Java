package util;
import java.util.Optional;
public class Rectangle {
    private final Point topLeft;
    private final Point bottomRight;
    public Rectangle(int x, int y, int length, int height){
        if(length <= 0){
            throw new IllegalArgumentException("Negative or zero argument: length");
        }
        if(height <= 0){
            throw new IllegalArgumentException("Negative or zero argument: height");
        }
        topLeft = new Point(x, y);
        bottomRight = new Point(x + length, y + height);
    }
    public Rectangle(int length, int height){
        this(0, 0, length, height);
    }
   public Optional<Rectangle> overlap(Rectangle r){
       var overlapTopLeft = new Point(Math.max(this.topLeft.getX(), r.topLeft.getX()), Math.max(this.topLeft.getY(), r.topLeft.getY()));
       var overlapLength = Math.min(this.bottomRight.getX(), r.bottomRight.getX()) - Math.max(this.topLeft.getX(), r.topLeft.getX());
       var overlapHeight = Math.min(this.bottomRight.getY(), r.bottomRight.getY()) - Math.max(this.topLeft.getY(), r.topLeft.getY());
       if(overlapLength <= 0 || overlapHeight <= 0){
           return Optional.empty();
       }
       var overlap = new Rectangle(overlapTopLeft.getX(),overlapTopLeft.getY(),overlapLength,overlapHeight);
       return Optional.of(overlap);
   }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Rectangle)){
            return false;
        }
        var r = (Rectangle)obj;
        return this.topLeft.equals(r.topLeft) && this.bottomRight.equals(r.bottomRight);
    }
    @Override
    public int hashCode() {
        return topLeft.hashCode() + bottomRight.hashCode();
    }
    @Override
    public String toString(){
        return String.format("(%d, %d) : (%d, %d)", topLeft.getX(), topLeft.getY(), bottomRight.getX() - topLeft.getX(), bottomRight.getY() - topLeft.getY());
   }
}
