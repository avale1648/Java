package edu.avale1648.util.command;

import java.util.Map;
import java.util.HashMap;

public class CommandSwitcher {
    private final Map<String, Command> COMMANDS = new HashMap<>();

    public void register(String key, Command value) {
        if (key == null || key == "") {
            throw new IllegalArgumentException("Command name is null or empty.");
        }
        if (value == null) {
            throw new IllegalArgumentException("Command is null.");
        }
        COMMANDS.put(key, value);
    }

    public void execute(String key, String[] args) {
        var command = COMMANDS.get(key);
        if (command == null) {
            throw new IllegalArgumentException(String.format("There is no command registered for %s.", key));
        }
        command.execute(args);
    }
}
