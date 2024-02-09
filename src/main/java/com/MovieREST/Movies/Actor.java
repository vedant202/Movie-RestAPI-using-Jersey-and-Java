package com.MovieREST.Movies;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Actor {
	private int actor_id;
	private String firstname;
	private String lastName;
	private String gender;
	
	public int getActor_id() {
		return actor_id;
	}
	public void setActor_id(int actor_id) {
		this.actor_id = actor_id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Override
	public String toString() {
		return "Actor [actor_id=" + actor_id + ", firstname=" + firstname + ", lastName=" + lastName + ", gender="
				+ gender + "]";
	}
	
	
}
