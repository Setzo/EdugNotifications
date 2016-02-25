package com.github.setzo.crawler;

import java.util.List;

import org.jsoup.nodes.Document;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.setzo.crawler.entity.Mission;
import com.github.setzo.crawler.service.DownloadHtmlService;
import com.github.setzo.crawler.service.FindMissionsService;

public class Main {

	private static ApplicationContext appContext;
	
	public static void main(String[] args) {

		Main.appContext = new ClassPathXmlApplicationContext("com/github/setzo/crawler/beans/beans.xml");
		
		DownloadHtmlService downloadService = Main.appContext.getBean(DownloadHtmlService.class);
		
		FindMissionsService missionService = Main.appContext.getBean(FindMissionsService.class);
		
		while(true) {
			
			try {
				
				Document doc = downloadService.getHtml();
				
				List<Mission> results = missionService.findMissions(doc);
				
				results.forEach(System.out::println);
				
				Thread.sleep(10000);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
