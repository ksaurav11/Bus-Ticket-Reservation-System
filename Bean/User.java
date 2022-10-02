package com.masai.Bean;

public class User {
	
	String username;
	int  age;
	String gender;
	int noOfseat;
	String source;
	String destination;
	String date;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String username, int age, String gender, int noOfseat, String source, String destination, String date) {
		super();
		this.username = username;
		this.age = age;
		this.gender = gender;
		this.noOfseat = noOfseat;
		this.source = source;
		this.destination = destination;
		this.date = date;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getNoOfseat() {
		return noOfseat;
	}
	public void setNoOfseat(int noOfseat) {
		this.noOfseat = noOfseat;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "user [username=" + username + ", age=" + age + ", gender=" + gender + ", noOfseat=" + noOfseat
				+ ", source=" + source + ", destination=" + destination + ", date=" + date + "]";
	}
	
	
}
