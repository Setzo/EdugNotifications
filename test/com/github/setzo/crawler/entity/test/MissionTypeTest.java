package com.github.setzo.crawler.entity.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import com.github.setzo.crawler.entity.MissionType;

public class MissionTypeTest {

	@Rule
	public Timeout globalTimeout = Timeout.millis(10);

	@Test
	public void getIdTest() {

		assertNotNull(MissionType.BLITZ.getId());
		assertNotNull(MissionType.LABORATORY.getId());
		assertNotNull(MissionType.SPECIAL.getId());
	}
}
