package edu.avale1648;

import edu.avale1648.util.command.CommandClient;

public class Main {
    public static void main(String[] args) {
        CommandClient client = new CommandClient();

        try {
            client.execute();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}