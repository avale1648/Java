package edu.avale1648.homework_2024_02_21.util.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CommandClient {
	private final CommandSwitcher SWITCHER = new CommandSwitcher();
	private final CommandReceiver RECEIVER = new CommandReceiver();
	private final Scanner KEYBOARD = new Scanner(System.in);
	private boolean isRunning = true;

	public CommandClient() {
		Command help = (String[] args) -> {
			System.out.println("help - get list of commands;"
					+ "\nins yyyy-mm-dd title description - add new event to schedule;" + "\nxp - get schedule;"
					+ "\nrm - remove schedule;" + "\nArgs for xp and rm:" + "\n\t-a - get/remove all events;"
					+ "\n\t-s yyyy-mm-dd title - get/remove single event with date and title;"
					+ "\n\t-d yyyy-mm-dd yyyy-mm-dd - get/remove events in date range;"
					+ "\n\t-t title - get/remove events with title;" + "\nstop - stop process.\n");
		};
		Command ins = RECEIVER::execIns;
		Command xp = RECEIVER::execXp;
		Command rm = RECEIVER::execRm;
		Command stop = (String[] args) -> {
			isRunning = false;
			System.out.println("Process is stopped");
		};
		SWITCHER.register("help", help);
		SWITCHER.register("ins", ins);
		SWITCHER.register("xp", xp);
		SWITCHER.register("rm", rm);
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
