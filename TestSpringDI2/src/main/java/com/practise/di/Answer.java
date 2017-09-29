package com.practise.di;

public class Answer {
	private String answer;
	private String date;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Answer [answer=" + answer + ", date=" + date + "]";
	}
}
