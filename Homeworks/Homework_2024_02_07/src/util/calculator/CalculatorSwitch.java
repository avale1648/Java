package util.calculator;
import java.util.HashMap;
public class CalculatorSwitch {
    private final HashMap<String, CalculatorCommand> commandMap = new HashMap<>();
    public void register(String commandName, CalculatorCommand command){
        commandMap.put(commandName, command);
    }
    public void execute(String commandName, int n) {
        var command = commandMap.get(commandName);
        if(command == null){
            throw new IllegalStateException("No command registered for" + commandName);
        }
        command.execute(n);
    }
}
