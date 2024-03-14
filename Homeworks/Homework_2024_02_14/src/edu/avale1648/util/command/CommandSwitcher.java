package edu.avale1648.util.command;

import java.util.HashMap;
import java.util.Map;

public class CommandSwitcher {
    private final Map<String, Command> COMMANDS = new HashMap<>();

    public void register(String commandName, Command command) {
        COMMANDS.put(commandName, command);
    }

    public void execute(String commandName) {
        Command command = COMMANDS.get(commandName);
        if (command == null) {
            throw new IllegalArgumentException(String.format("No command registered for %s", commandName));
        }
        command.execute();
    }

    public boolean contains(String commandName) {
        return COMMANDS.containsKey(commandName);
    }
}