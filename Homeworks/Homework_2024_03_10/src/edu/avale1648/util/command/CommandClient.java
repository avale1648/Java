package edu.avale1648.util.command;

public class CommandClient {
    private final CommandSwitcher SWITCHER;
    private boolean isRunning;

    public CommandClient() {
        SWITCHER = new CommandSwitcher();
        var receiver = new CommandReceiver();
        isRunning = true;
        
        Command help = receiver::help;
        Command stop = (String[] args) -> {
            isRunning = false;
            
            System.out.println("Process is stoped.");
        };
        
        SWITCHER.register("/help", help);
        SWITCHER.register("/stop", stop);
    }

    public void execute() {
        SWITCHER.execute("/help", null);

    }
}
