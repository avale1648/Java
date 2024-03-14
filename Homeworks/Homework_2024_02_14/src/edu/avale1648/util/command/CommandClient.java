package edu.avale1648.util.command;

import java.util.Scanner;

public class CommandClient {
    private final CommandSwitcher SWITCHER;
    private final Scanner SCANNER;
    private boolean isRunning;

    public CommandClient() {
        SWITCHER = new CommandSwitcher();
        CommandReceiver receiver = new CommandReceiver();

        Command orig = receiver::executeOrigResult;
        Command alt = receiver::executeAltResult;
        Command help = () -> System.out.println("/orig - execute original result;\n" +
                "/alt - execute alternative result;\n" +
                "/help - get list of commands;\n" +
                "/stop - stop the process.");
        Command stop = () -> {
            isRunning = false;
        };

        SWITCHER.register("/orig", orig);
        SWITCHER.register("/alt", alt);
        SWITCHER.register("/help", help);
        SWITCHER.register("/stop", stop);

        SCANNER = new Scanner(System.in);
        isRunning = true;
    }

    public void execute() {
        SWITCHER.execute("/help");
        while (isRunning) {
            String input = SCANNER.nextLine();
            if (!SWITCHER.contains(input)) {
                throw new IllegalArgumentException(String.format("There's no command: %s", input));
            }
            SWITCHER.execute(input);
        }
    }
}
