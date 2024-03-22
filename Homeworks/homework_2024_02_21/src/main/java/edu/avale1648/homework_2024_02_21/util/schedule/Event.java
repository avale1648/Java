package edu.avale1648.homework_2024_02_21.util.schedule;

import java.time.LocalDate;

public class Event {
	private final LocalDate DATE;
	private final String TITLE;
	private final String DESCRIPTION;

	public Event(LocalDate date, String title, String description) {
		DATE = date;
		TITLE = title;
		DESCRIPTION = description;
	}

	public LocalDate getDate() {
		return DATE;
	}

	public String getTitle() {
		return TITLE;
	}

	public String getDescription() {
		return DESCRIPTION;
	}

	@Override
	public String toString() {
		return String.format("Date: %s, Title: %s, Description: %s", DATE, TITLE, DESCRIPTION);
	}
}
