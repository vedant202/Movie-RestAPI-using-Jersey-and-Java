package com.MovieREST.Movies;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Movie {
	private int id;
	private String movie_name;
	private int year;
	private float rankScore;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", movie_name=" + movie_name + ", year=" + year + ", rankScore=" + rankScore + "]";
	}
	public String getMovie_name() {
		return movie_name;
	}
	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}
	public int getYear() {
		return year;
	}
	public float getRankScore() {
		return rankScore;
	}
	public void setRankScore(float rankScore) {
		this.rankScore = rankScore;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	
	
}
