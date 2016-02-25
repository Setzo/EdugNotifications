package com.github.setzo.crawler.entity;

public enum MissionType {

	SPECIAL(0), LABORATORY(1), BLITZ(2);
	
	private final int id;
	
	private MissionType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}
}
