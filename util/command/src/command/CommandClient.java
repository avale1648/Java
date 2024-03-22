package command;

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
			System.out.println("help - get list of commands;" + "\nstop - stop process.\n");
		};
		Command stop = (String[] args) -> {
			isRunning = false;
			System.out.println("Process is stopped");
		};
		Command cmd = RECEIVER::execCmd;
		SWITCHER.register("help", help);
		SWITCHER.register("stop", stop);
		SWITCHER.register(null, cmd);
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
				System.out.format("There is no command: %s", commandName);
			}
			try {
				SWITCHER.execute(commandName, args.toArray(String[]::new));
			} catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
		}

		System.out.println("Process is finished");
	}
}
