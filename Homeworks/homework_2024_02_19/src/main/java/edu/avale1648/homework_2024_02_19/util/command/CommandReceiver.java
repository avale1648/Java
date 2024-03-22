package edu.avale1648.homework_2024_02_19.util.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import edu.avale1648.homework_2024_02_19.util.collection.CollectionHelper;

class CommandReceiver {

	private final static int MIN_ARGS_LENGTH = 3;

	public void execHelp(String[] args) {
		System.out.println("help - get list of commands;" 
					+ "\nunique - do unique method;"
					+ "\ncontainsKey - check contains key;"
					+ "\nsequenceMaxLength - get sequence max length;"
					+ "\nstop - stop the process.");
	}

	public void execUnique(String[] args) {
		if (args.length < MIN_ARGS_LENGTH - 1) {
			throw new IllegalStateException("There is should be at least three arguments");
		}
		List<String> strings = new ArrayList<>(Arrays.asList(args));
		Collection<?> unique = CollectionHelper.unique(strings);

		System.out.println("Origin:");
		for (String arg : args) {
			System.out.format("%s, ", arg);
		}

		System.out.println("\nUnique:");
		for (Object o : unique) {
			System.out.format("%s, ", o.toString());
		}

		System.out.println();
	}

	public void execContainsKey(String[] args) {
		if (args.length < MIN_ARGS_LENGTH) {
			throw new IllegalStateException("There is should be at least three arguments");
		}

		String key = args[0];
		List<String> chunks = new ArrayList<>(Arrays.asList(args)).subList(1, args.length);
		boolean containsKey = CollectionHelper.containsKey(key, chunks);

		System.out.format("Contains key: %s", containsKey);
		System.out.println();
	}

	public void execSequenceMaxLength(String[] args) {
		if (args.length < MIN_ARGS_LENGTH) {
			throw new IllegalStateException("There is should be at least three arguments");
		}

		long number = Long.parseLong(args[0]);

		List<String> strings = new ArrayList<>(Arrays.asList(args)).subList(1, args.length);
		List<Long> numbers = new ArrayList<>();

		for (String s : strings) {
			long l = Long.parseLong(s);
			numbers.add(l);
		}

		long max = CollectionHelper.sequenceMaxLength(number, numbers);

		System.out.format("Key: %d, Numbers: %s, Sequence Max Length: %d", number, numbers.toString(), max);
		System.out.println();
	}
}
