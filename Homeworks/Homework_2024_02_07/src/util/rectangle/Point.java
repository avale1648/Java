package util.rectangle;
public class Point {
    private final int X;
    private final int Y;
    public Point(int x, int y){
        if(x < 0){
            throw new IllegalArgumentException("Negative argument: x");
        }
        this.X = x;
        if(y < 0){
            throw new IllegalArgumentException("Negative argument: y");
        }
        this.Y = y;
    }
    public int getX(){
        return X;
    }
    public int getY(){
        return Y;
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Point)){
            return false;
        }
        var p = (Point)obj;
        return this.X == p.X && this.Y == p.Y;
    }

    @Override
    public int hashCode() {
        return X + Y;
    }
}
