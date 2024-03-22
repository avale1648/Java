package edu.avale1648.homework_2024_02_19.util.collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionHelper {
	public static Collection<?> unique(Collection<?> input) {
		Set<Object> output = new HashSet<>(input);
		return output;
	}

	public static boolean containsKey(String key, List<String> chunks) {
		Set<String> chunkSet = new HashSet<>(chunks);

		for (String chunk : chunkSet) {
			String complement = key.substring(chunk.length());
			if (chunkSet.contains(complement)) {
				return true;
			}
		}
		return false;
	}

	public static long sequenceMaxLength(long number, List<Long> numbers) {
		long maxLength = 0;
		long sum = 0;
		int left = 0;

		for (int right = 0; right < numbers.size(); right++) {
			sum += numbers.get(right);
			while (sum >= number) {
				sum -= numbers.get(left);
				left++;
			}
			maxLength = Math.max(maxLength, right - left + 1);
		}

		return maxLength;
	}
}
