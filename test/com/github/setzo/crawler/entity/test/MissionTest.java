package com.github.setzo.crawler.entity.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.Instant;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import com.github.setzo.crawler.entity.Mission;
import com.github.setzo.crawler.entity.MissionType;

public class MissionTest {

	private static final String missionName = "misja";
	
	private static final MissionType missionType = MissionType.BLITZ;
	
	private static final Instant missionDate = Instant.now();
	
	private Mission mission;
	
	@Rule
	public Timeout globalTimeout = Timeout.millis(10);
	
	@Before
	public void prepare() {
		this.mission = new Mission(missionName, missionType, missionDate); 
	}
	
	@Test
	public void checkForNullsTest() {
		Mission mission = new Mission();
		assertNull("Mission name has to be null.", mission.getName());
		assertNull("Mission type has to be null.", mission.getType());
		assertNull("Mission date has to be null.", mission.getDate());
	}
	
	@Test
	public void getNameTest() {
		assertNotNull("Mission getName() method is returning incorrect value 1.", this.mission.getName());
		assertTrue("Mission getName() method is returning incorrect value 2.", this.mission.getName().equals(missionName));
	}
	
	@Test
	public void getTypeTest() {
		assertNotNull("Mission getType() method is returning incorrect value 1.", this.mission.getType());
		assertTrue("Mission getName() method is returning incorrect value 2.", this.mission.getType().equals(missionType));
	}
	
	@Test
	public void getDateTest() {
		assertNotNull("Mission getDate() method is returning incorrect value 1.", this.mission.getDate());
		assertTrue("Mission getName() method is returning incorrect value 2.", this.mission.getDate().equals(missionDate));
	}
	
	@Test
	public void setNameTest() {
		Mission mission = new Mission();
		assertNull("Mission name has to be null at this point.", mission.getName());
		mission.setName(missionName);
		assertNotNull("Mission name cannot be null at this point.", mission.getName());
		assertTrue("Mission getName() method is returning incorrect value.", this.mission.getName().equals(missionName));
	}
	
	@Test
	public void setTypeTest() {
		Mission mission = new Mission();
		assertNull("Mission type has to be null at this point.", mission.getType());
		mission.setType(missionType);
		assertNotNull("Mission type cannot be null at this point.", mission.getType());
		assertTrue("Mission getType() method is returning incorrect value.", this.mission.getType().equals(missionType));
	}
	
	@Test
	public void setDateTest() {
		Mission mission = new Mission();
		assertNull("Mission date has to be null at this point.", mission.getDate());
		mission.setDate(missionDate);
		assertNotNull("Mission date cannot be null at this point.", mission.getDate());
		assertTrue("Mission getDate() method is returning incorrect value.", this.mission.getDate().equals(missionDate));
	}
}
