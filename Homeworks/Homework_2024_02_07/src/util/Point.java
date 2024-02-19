package util;
public class Point {
    private final int x;
    private final int y;
    public Point(int x, int y){
        if(x < 0){
            throw new IllegalArgumentException("Negative argument: x");
        }
        this.x = x;
        if(y < 0){
            throw new IllegalArgumentException("Negative argument: y");
        }
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Point)){
            return false;
        }
        var p = (Point)obj;
        return this.x == p.x && this.y == p.y;
    }

    @Override
    public int hashCode() {
        return x + y;
    }
}
