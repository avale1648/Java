package edu.avale1648.classwork_2024_03_22;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Servlet implementation class Check
 */
public class Check extends HttpServlet {
	private static final long SERIAL_VERSION_UID = 1L;
	private static final String ANSWER = "answer";
	private static long rightAnswer = 1L;

	private static final String[] ACTIONS = { "+", "-", "x", ":" };

	private static long a = 1L;
	private static long b = 1L;

	private static String action = "+";

	public static long getA() {
		a = ThreadLocalRandom.current().nextLong(1, 9 + 1);
		return a;
	}

	public static long getB() {
		b = ThreadLocalRandom.current().nextLong(1, 9 + 1);
		return b;
	}

	public static String getAction() {
		int act = ThreadLocalRandom.current().nextInt(0, ACTIONS.length);
		action = ACTIONS[act];
		return ACTIONS[act];
	}

	private boolean isRight(String str) {
		return Long.parseLong(str) == calc();
	}

	private long calc() {
		switch (action) {
		case "+":
			return a + b;
		case "-":
			return a - b;
		case "x":
			return a * b;
		case ":":
			return a / b;
		default:
			return -1L;
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Check() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String answer = request.getParameter(ANSWER);
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Your Answer: </h1>");
		writer.printf("<h1 style=\"color:%s\">%s</h1>\n", isRight(answer) ? "green" : "red", answer);
		writer.println("<h1>Right Answer: </h1>");
		writer.printf("<h1 style=\"color:%s\">%d</h1>\n", "green", calc());
		writer.printf("<h1 style=\"color:%s\">%s</h1>\n", isRight(answer) ? "green" : "red", isRight(answer));
		writer.close();
	}

}
