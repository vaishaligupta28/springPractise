package com.practise.di;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SIwithMap {
	int id;
	private Map<String, String> primitiveMap;
	private Map<User, Answer> answers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Map<String, String> getPrimitiveMap() {
		return primitiveMap;
	}

	public void setPrimitiveMap(Map<String, String> primitiveMap) {
		this.primitiveMap = primitiveMap;
	}

	public Map<User, Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(Map<User, Answer> answers) {
		this.answers = answers;
	}

	public void display() {
		System.out.println("ID:" + id);
		System.out.println("Answers given by users:\n");

		// Using non string map
		Set<Entry<User, Answer>> set1 = answers.entrySet();
		Iterator<Entry<User, Answer>> itr1 = set1.iterator();
		while (itr1.hasNext()) {
			Entry<User, Answer> entry = itr1.next();
			User user1 = entry.getKey();
			Answer ans1 = entry.getValue();
			System.out.println(ans1);
			System.out.println("given by:" + user1 + "\n");
		}

		// Using string map
		Set<Entry<String, String>> set2 = primitiveMap.entrySet();
		Iterator<Entry<String, String>> itr2 = set2.iterator();
		while (itr2.hasNext()) {
			Entry<String, String> entry = itr2.next();
			String user2 = entry.getKey();
			String ans2 = entry.getValue();
			System.out.println(ans2);
			System.out.println("given by:" + user2 + "\n");
		}
	}
}
