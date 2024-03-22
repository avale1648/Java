package edu.avale1648.homework_2024_02_21.util.command;

import java.lang.IllegalStateException;
import java.util.HashMap;
import java.util.Map;

class CommandSwitcher {
	private final Map<String, Command> COMMANDS = new HashMap<>();

	public void register(String commandName, Command command) {
		COMMANDS.put(commandName, command);
	}

	public void execute(String commandName, String[] args) {
		Command command = COMMANDS.get(commandName);

		if (command == null) {
			throw new IllegalStateException(String.format("There is no command: %s", commandName));
		}

		command.execute(args);
	}

	public boolean contains(String commandName) {
		return COMMANDS.containsKey(commandName);
	}
}
