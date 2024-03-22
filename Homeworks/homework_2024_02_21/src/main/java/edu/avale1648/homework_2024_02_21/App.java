package edu.avale1648.homework_2024_02_21;

import edu.avale1648.homework_2024_02_21.util.command.CommandClient;

public class App {
	public static void main(String[] args) {
		CommandClient client = new CommandClient();
		try {
			client.execute();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
