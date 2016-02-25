package com.github.setzo.crawler.entity;

import javax.annotation.Resource;

@Resource(name="mission")
public class Mission {

	public Mission() {
	}
	
	public Mission(String name, MissionType type) {
		this.name = name;
		this.type = type;
	}

	private String name;
	
	private MissionType type;

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
}
