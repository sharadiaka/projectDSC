package com.lab1.projectDSC.entities;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Subjects {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private double[] note;
	private int like;
	
	public Subjects() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double[] getNote() {
		return note;
	}
	public void setNote(double[] note) {
		this.note = note;
	}
	public int getLike() {
		return like;
	}
	public void setLikes(int like) {
		this.like = like;
	}
	

}
