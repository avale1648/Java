package edu.avale1648.homework_2024_02_21.util.schedule;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Schedule {
	private final Map<LocalDate, Map<String, Event>> EVENTS;

	public Schedule() {
		EVENTS = new HashMap<>();
	}

	public Schedule(Collection<Event> events) {
		this();

		for (Event e : events) {
			insert(e);
		}
	}

	public Schedule insert(Event e) {
		EVENTS.computeIfAbsent(e.getDate(), k -> new HashMap<>()).put(e.getTitle(), e);

		System.out.format("%s is inserted\n", e.toString());

		return this;
	}

	public Optional<Event> get(LocalDate date, String title) {
		Map<String, Event> eventsOnDate = EVENTS.getOrDefault(date, Collections.emptyMap());

		return Optional.ofNullable(eventsOnDate.get(title));
	}

	public List<Event> export() {
		List<Event> allEvents = new ArrayList<>();

		EVENTS.values().forEach(eventsOnDate -> allEvents.addAll(eventsOnDate.values()));

		allEvents.sort(Comparator.comparing(Event::getDate));

		return Collections.unmodifiableList(allEvents);
	}

	public List<Event> export(LocalDate from, LocalDate to) {
		List<Event> dateRangeEvents = new ArrayList<>();

		for (LocalDate date = from; !date.isAfter(to); date = date.plusDays(1)) {
			Map<String, Event> eventsOnDate = EVENTS.getOrDefault(date, Collections.emptyMap());
			dateRangeEvents.addAll(eventsOnDate.values());
		}

		dateRangeEvents.sort(Comparator.comparing(Event::getDate));

		return Collections.unmodifiableList(dateRangeEvents);
	}

	public List<Event> export(String title) {
		List<Event> titledEvents = new ArrayList<>();

		EVENTS.forEach((date, eventsOnDate) -> {
			Event titled = eventsOnDate.get(title);
			if (titled != null) {
				titledEvents.add(titled);
			}
		});

		titledEvents.sort(Comparator.comparing(Event::getDate));

		return titledEvents;
	}

	public Optional<Event> remove(LocalDate date, String title) {
		Map<String, Event> eventsOnDate = EVENTS.get(date);

		if (eventsOnDate != null) {
			Event removed = eventsOnDate.remove(title);
			if (removed != null) {
				if (eventsOnDate.isEmpty()) {
					EVENTS.remove(date);
				}
				return Optional.of(removed);
			}
		}

		return Optional.empty();
	}

	public List<Event> remove() {
		List<Event> allEvents = export();

		EVENTS.clear();

		return allEvents;
	}

	public List<Event> remove(LocalDate from, LocalDate to) {
		List<Event> removedEvents = new ArrayList<>();

		for (LocalDate date = from; !date.isAfter(to); date = date.plusDays(1)) {
			Map<String, Event> eventsOnDate = EVENTS.remove(date);
			if (eventsOnDate != null) {
				removedEvents.addAll(eventsOnDate.values());
			}
		}

		return Collections.unmodifiableList(removedEvents);
	}

	public List<Event> remove(String title) {
		List<Event> removedEvents = new ArrayList<>();

		EVENTS.values().forEach(eventsOnDate -> {
			Event removed = eventsOnDate.remove(title);
			if (removed != null) {
				removedEvents.add(removed);
			}
		});

		return Collections.unmodifiableList(removedEvents);
	}
}
