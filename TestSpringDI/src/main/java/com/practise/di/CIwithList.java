package com.practise.di;

import java.util.Iterator;
import java.util.List;

public class CIwithList {
	private int groupId;
	private String groupName;
	private List<User> users;

	CIwithList(int groupId, String groupName, List<User> users) {
		this.groupId = groupId;
		this.groupName = groupName;
		this.users = users;
	}

	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Group Id:" + groupId);
		System.out.println("Group name:" + groupName);
		System.out.println("Students are: \n");
		Iterator<User> itr = users.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
