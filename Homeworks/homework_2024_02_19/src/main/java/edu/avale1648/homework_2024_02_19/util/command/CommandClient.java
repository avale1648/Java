package edu.avale1648.homework_2024_02_19.util.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandClient {
	private final CommandSwitcher SWITCHER = new CommandSwitcher();
	private final Scanner KEYBOARD = new Scanner(System.in);
	private boolean isRunning = true;

	public CommandClient() {
		CommandReceiver receiver = new CommandReceiver();

		Command help = receiver::execHelp;
		Command unique = receiver::execUnique;
		Command containsKey = receiver::execContainsKey;
		Command sequenceMaxLength = receiver::execSequenceMaxLength;
		Command stop = (String[] args) -> isRunning = false;

		SWITCHER.register("help", help);
		SWITCHER.register("unique", unique);
		SWITCHER.register("containsKey", containsKey);
		SWITCHER.register("sequenceMaxLength", sequenceMaxLength);
		SWITCHER.register("stop", stop);
	}

	public void execute() {
		List<String> args = new ArrayList<>();
		SWITCHER.execute("help", args.toArray(String[]::new));

		while (isRunning) {
			args.clear();
			String input = KEYBOARD.nextLine();
			String[] parts = input.split(" ");
			String commandName = parts[0];
			for (int i = 1; i < parts.length; i++) {
				args.add(parts[i]);
			}
			if (SWITCHER.contains(commandName) == false) {
				throw new IllegalStateException(String.format("There is no command: %s", commandName));
			}

			SWITCHER.execute(commandName, args.toArray(String[]::new));
		}

		System.out.println("Process is finished");
	}
}
