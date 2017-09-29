package com.practise.di;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CIwithMap {
	int id;
	private Map<String, String> primitiveMap;
	private Map<User, Answer> answers;

	public CIwithMap(int id, Map<String, String> primitiveMap, Map<User, Answer> answers) {
		super();
		this.id = id;
		this.primitiveMap = primitiveMap;
		this.answers = answers;
	}

	public void display() {
		System.out.println("ID:" + id);
		System.out.println("Answers given by users:\n");
		
		//Using non string map
		Set<Entry<User, Answer>> set1 = answers.entrySet();
		Iterator<Entry<User, Answer>> itr1 = set1.iterator();
		while (itr1.hasNext()) {
			Entry<User, Answer> entry = itr1.next();
			User user1 = entry.getKey();
			Answer ans1 = entry.getValue();
			System.out.println(ans1);
			System.out.println("given by:" + user1 +"\n");
		}
		
		//Using string map
		Set<Entry<String, String>> set2 = primitiveMap.entrySet();
		Iterator<Entry<String, String>> itr2 = set2.iterator();
		while (itr2.hasNext()) {
			Entry<String, String> entry = itr2.next();
			String user2 = entry.getKey();
			String ans2 = entry.getValue();
			System.out.println(ans2);
			System.out.println("given by:" + user2 +"\n");
		}
	}
}
