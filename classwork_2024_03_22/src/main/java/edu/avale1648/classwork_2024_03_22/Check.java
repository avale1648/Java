package edu.avale1648.classwork_2024_03_22;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;

import edu.avale1648.classwork_2024_03_22.pgsql.StoreData;
import edu.avale1648.classwork_2024_03_22.pgsql.entities.Question;

/**
 * Servlet implementation class Check
 */
public class Check extends HttpServlet {
	private static final long SERIAL_VERSION_UID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StoreData store = new StoreData();
		String user_answer = request.getParameter("answer");
		Question q = store.getQuestion(
				Integer.parseInt(request.getParameter("questionId")));
		PrintWriter writer = response.getWriter();
		store.saveResult(q, user_answer);
		writer.println("<h1>Your answer is " + user_answer + "; right is " + q.getAnswer() + "</h1>");
		writer.close();
	}

}