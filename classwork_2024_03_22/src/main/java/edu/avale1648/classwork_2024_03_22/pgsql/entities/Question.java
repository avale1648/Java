package edu.avale1648.classwork_2024_03_22.pgsql.entities;

import java.util.concurrent.ThreadLocalRandom;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private final String content;
	private final String answer;

	public Question() {
		var a = ThreadLocalRandom.current().nextInt(1, 9 + 1);
		var b = ThreadLocalRandom.current().nextInt(1, 9 + 1);
		var acts = Actions.toArray();
		var act = acts[ThreadLocalRandom.current().nextInt(acts.length)];

		content = String.format("%d %s %d = ?", a, act, b);
		answer = Integer.toString(calculate(a, b, act));
	}
	
	public int getId() {
		return id;
	}
	
	public String getContent() {
		return content;
	}
	
	public String getAnswer() {
		return answer;
	}

	private int calculate(int a, int b, String action) throws IllegalStateException {
		var result = 0;

		switch (action) {
		case Actions.ADD:
			result = a + b;
			break;
		case Actions.SUBSTRACT:
			result = a - b;
			break;
		case Actions.MULTIPLY:
			result = a * b;
			break;
		case Actions.DIVIDE:
			result = a / b;
			break;
		default:
			throw new IllegalStateException(String.format("There is no action: ", action));
		}

		return result;
	}
}

class Actions {
	public static final String ADD = "+";
	public static final String SUBSTRACT = "-";
	public static final String MULTIPLY = "x";
	public static final String DIVIDE = ":";

	public static String[] toArray() {
		return new String[] { ADD, SUBSTRACT, MULTIPLY, DIVIDE };
	}
}