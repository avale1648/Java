package edu.avale1648.classwork_2024_03_22.pgsql.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MathResult {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String response;
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;
	private LocalDateTime dateTime;

	public MathResult(Question q, String answer) {
		question = q;
		response = answer;
		dateTime = LocalDateTime.now();
	}

	public int getId() {
		return id;
	}
	
	public String getResponse() {
		return response;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
}
