package util.rectangle;

import java.util.Optional;
public class Rectangle {
    private final Point TOP_LEFT;
    private final Point BOTTOM_RIGHT;
    public Rectangle(int x, int y, int length, int height){
        if(length <= 0){
            throw new IllegalArgumentException("Negative or zero argument: length");
        }
        if(height <= 0){
            throw new IllegalArgumentException("Negative or zero argument: height");
        }
        TOP_LEFT = new Point(x, y);
        BOTTOM_RIGHT = new Point(x + length, y + height);
    }
    public Rectangle(int length, int height){
        this(0, 0, length, height);
    }
   public Optional<Rectangle> overlap(Rectangle r){
       var overlapTopLeft = new Point(Math.max(this.TOP_LEFT.getX(), r.TOP_LEFT.getX()), Math.max(this.TOP_LEFT.getY(), r.TOP_LEFT.getY()));
       var overlapLength = Math.min(this.BOTTOM_RIGHT.getX(), r.BOTTOM_RIGHT.getX()) - Math.max(this.TOP_LEFT.getX(), r.TOP_LEFT.getX());
       var overlapHeight = Math.min(this.BOTTOM_RIGHT.getY(), r.BOTTOM_RIGHT.getY()) - Math.max(this.TOP_LEFT.getY(), r.TOP_LEFT.getY());
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
        return this.TOP_LEFT.equals(r.TOP_LEFT) && this.BOTTOM_RIGHT.equals(r.BOTTOM_RIGHT);
    }
    @Override
    public int hashCode() {
        return TOP_LEFT.hashCode() + BOTTOM_RIGHT.hashCode();
    }
    @Override
    public String toString(){
        return String.format("(%d, %d) : (%d, %d)", TOP_LEFT.getX(), TOP_LEFT.getY(), BOTTOM_RIGHT.getX() - TOP_LEFT.getX(), BOTTOM_RIGHT.getY() - TOP_LEFT.getY());
   }
}
