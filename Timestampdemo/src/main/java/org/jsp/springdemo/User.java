package org.jsp.springdemo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.jsp.timestamp.dto.UserId;

@Entity
public class User {
	@EmbeddedId
	private UserId userId;
	private String name;
	private int age;
	public UserId getUserId() {
		return userId;
	}
	public void setUserId(UserId userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
