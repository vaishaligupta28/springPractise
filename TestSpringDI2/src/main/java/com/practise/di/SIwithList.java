package com.practise.di;

import java.util.Iterator;
import java.util.List;

public class SIwithList {
	private int groupId;
	private String groupName;
	private List<User> users;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
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
