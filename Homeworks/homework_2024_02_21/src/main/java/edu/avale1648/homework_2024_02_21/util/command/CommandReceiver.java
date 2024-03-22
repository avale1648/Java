package edu.avale1648.homework_2024_02_21.util.command;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import edu.avale1648.homework_2024_02_21.util.schedule.*;

class CommandReceiver {
	private final Schedule SCHEDULE = new Schedule();

	public void execIns(String[] args) {
		if (args.length != 3) {
			throw new IllegalStateException("There is should be 3 arguments");
		}

		String dateStr = args[0];
		if (!dateStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
			throw new IllegalArgumentException("Date argument doesn't match");
		}
		LocalDate date = LocalDate.parse(dateStr);

		String title = args[1];
		String description = args[0];

		SCHEDULE.insert(new Event(date, title, description));
	}

	public void execXp(String[] args) {
		String type = args[0];

		switch (type) {

		case "-s":
			// length is 3 because args must contain type, date and title
			if (args.length != 3) {
				throw new IllegalStateException("There is should be 3 arguments");
			}

			String dateStr = args[1];
			if (!dateStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
				throw new IllegalArgumentException("Date argument doesn't match");
			}
			LocalDate date = LocalDate.parse(dateStr);

			String title = args[2];

			Event e1 = SCHEDULE.get(date, title).get();

			System.out.format("%s", e1.toString());

			break;

		case "-d":
			// length is 3 because args must contain type, dates of begin and end
			if (args.length != 3) {
				throw new IllegalStateException("There is should be 3 arguments");
			}
			String fromDateStr = args[1];
			if (!fromDateStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
				throw new IllegalArgumentException("Date argument doesn't match");
			}
			LocalDate fromDate = LocalDate.parse(fromDateStr);

			String toDateStr = args[1];
			if (!toDateStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
				throw new IllegalArgumentException("Date argument doesn't match");
			}
			LocalDate toDate = LocalDate.parse(toDateStr);

			List<Event> dateRangeEvents;
			if (fromDate.isBefore(toDate)) {
				dateRangeEvents = SCHEDULE.export(fromDate, toDate);
			} else {
				dateRangeEvents = SCHEDULE.export(toDate, fromDate);
			}

			print("Date Range", dateRangeEvents);

			break;

		case "-t":
			// length is 2 because it must contain type and title
			if (args.length != 2) {
				throw new IllegalStateException("There is should be 3 arguments");
			}

			String title1 = args[1];

			List<Event> titledEvents = SCHEDULE.export(title1);

			print("Title", titledEvents);

			break;
		case "-a":
			List<Event> events = SCHEDULE.export();

			print("all", events);

			break;
		default:
			throw new IllegalStateException("There is no such command");
		}
	}

	public void execRm(String[] args) {
		System.out.println("Are you sure? (y/n)");

		Scanner keyboard = new Scanner(System.in);
		String input = keyboard.nextLine();

		if (input.toLowerCase().equals("y")) {
			String type = args[0];

			switch (type) {

			case "-s":
				// length is 3 because args must contain type, date and title
				if (args.length != 3) {
					throw new IllegalStateException("There is should be 3 arguments");
				}

				String dateStr = args[1];
				if (!dateStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
					throw new IllegalArgumentException("Date argument doesn't match");
				}
				LocalDate date = LocalDate.parse(dateStr);

				String title = args[2];

				Event e1 = SCHEDULE.remove(date, title).get();

				System.out.format("%s", e1.toString());

				break;

			case "-d":
				// length is 3 because args must contain type, dates of begin and end
				if (args.length != 3) {
					throw new IllegalStateException("There is should be 3 arguments");
				}
				String fromDateStr = args[1];
				if (!fromDateStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
					throw new IllegalArgumentException("Date argument doesn't match");
				}
				LocalDate fromDate = LocalDate.parse(fromDateStr);

				String toDateStr = args[1];
				if (!toDateStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
					throw new IllegalArgumentException("Date argument doesn't match");
				}
				LocalDate toDate = LocalDate.parse(toDateStr);

				List<Event> dateRangeEvents;
				if (fromDate.isBefore(toDate)) {
					dateRangeEvents = SCHEDULE.remove(fromDate, toDate);
				} else {
					dateRangeEvents = SCHEDULE.remove(toDate, fromDate);
				}

				print("Date Range", dateRangeEvents);

				break;

			case "-t":
				// length is 2 because it must contain type and title
				if (args.length != 2) {
					throw new IllegalStateException("There is should be 3 arguments");
				}

				String title1 = args[1];

				List<Event> titledEvents = SCHEDULE.remove(title1);

				print("Title", titledEvents);

				break;

			case "-a":
				List<Event> events = SCHEDULE.export();

				print("all", events);

				break;
			default:
				throw new IllegalStateException("There is no such command");
			}
		} else {
			return;
		}
	}

	private void print(String title, List<Event> events) {
		System.out.format("-- %s --\n", title);

		for (Event e : events) {
			System.out.format("%s,", e.toString());
		}

		System.out.println();
	}
}
