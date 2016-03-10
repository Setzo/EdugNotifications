package com.github.setzo.crawler.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import com.github.setzo.crawler.entity.Mission;
import com.github.setzo.crawler.entity.MissionType;

public class FindMissionsService {
	
	private Map<String, MissionType>  missionMap;
	
	public FindMissionsService() {
		
		this.missionMap = new HashMap<String, MissionType>();
		
		this.missionMap.put(".fa-puzzle-piece", MissionType.SPECIAL);
		this.missionMap.put(".fa-flask", MissionType.LABORATORY);
		this.missionMap.put(".fa-bolt", MissionType.BLITZ);
	}
	
	public List<Mission> findMissions(Document doc) {

		List<Mission> missionList = new ArrayList<Mission>();
		
		this.missionMap.entrySet().forEach(entry -> {
			missionList.addAll(
				this.findMissions(doc, entry.getKey(), entry.getValue())
			);
		});
		
		return missionList;
	}
	
	private List<Mission> findMissions(Document doc, String className, MissionType type) {
		
		List<Mission> missionList = new ArrayList<Mission>();
		
		Elements labHtml = doc.select(className);
		
		labHtml.forEach(list -> {
			list.parent().parent().select(".nav-children").forEach(mission -> {
				mission.childNodes().forEach(node -> {
					
					Matcher matcher = Pattern.compile("(?<=>)(.+)(?=<\\/a>)")
							.matcher(node.toString());
					
					while (matcher.find()) {
						missionList.add(new Mission(matcher.group(1), type, Instant.now()));
					}
					
				});
			});
		});
		
		return missionList;
	}
}
