package util.calculator;
import java.util.ArrayDeque;
import java.util.Deque;
public class CalculatorReceiver {
    private float current = 0f;
    private float old = 0f;
    private final Deque<Float> UNDONE = new ArrayDeque<>();
    private final Deque<Float> HISTORY = new ArrayDeque<>();
    public void add(int n) {
        current = current + n;
    }
    public void sub(int n){
        current = current - n;
    }
    public void mul(int n){
        current = current * n;
    }
    public void div(int n){
        if(n == 0){
            throw new IllegalArgumentException("Cannot divide on zero.");
        }
        current = current / n;
    }
    public void undo(int n){
        if(HISTORY.isEmpty()){
            throw new ArrayStoreException("Cannot undo, no commands in history");
        }
        UNDONE.push(current);
        current = HISTORY.pop();
    }
    public void redo(int n){
        if(UNDONE.isEmpty()){
            throw new ArrayStoreException("Cannot redo, no commands undone");
        }
        HISTORY.push(current);
        current = UNDONE.pop();
    }
    public void setOldToCurrent(){
        old = current;
    }
    public void push(){
        HISTORY.push(old);
    }
    @Override
    public String toString(){
        return String.format("Current number: %f", current);
    }
}
