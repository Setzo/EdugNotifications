package com.github.setzo.crawler.entity;

import java.time.Instant;

public class Mission {

	private String name;
	
	private MissionType type;
	
	private Instant date;
	
	public Mission() {
	}
	
	public Mission(String name, MissionType type, Instant date) {
		this.name = name;
		this.type = type;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MissionType getType() {
		return type;
	}

	public void setType(MissionType type) {
		this.type = type;
	}
	
	public String toString() {
		return String.format("%s%s%s%s", "Name: ", this.name, ", Type: ", this.type.name());
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}
}
