package com.practise.di;

public class Answer {
	private String answer;
	private String date;
	Answer(String answer, String date) {
		this.answer = answer;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Answer [answer=" + answer + ", date=" + date + "]";
	}
}
