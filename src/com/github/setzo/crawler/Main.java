package com.github.setzo.crawler;

import java.util.List;

import org.jsoup.nodes.Document;

import com.github.setzo.crawler.config.ApplicationConfig;
import com.github.setzo.crawler.entity.Mission;
import com.github.setzo.crawler.service.DatabaseHandlerService;
import com.github.setzo.crawler.service.DownloadHtmlService;
import com.github.setzo.crawler.service.FindMissionsService;
import com.github.setzo.crawler.service.SendEmailService;

public class Main {

	
	public static void main(String[] args) {

		DownloadHtmlService downloadService = new DownloadHtmlService();
		
		FindMissionsService missionService = new FindMissionsService();
		
		DatabaseHandlerService databaseService = new DatabaseHandlerService();
		
		SendEmailService mailService = new SendEmailService();
		
		try {
			Main.iterate(downloadService, missionService, databaseService, mailService);
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	private static void iterate(DownloadHtmlService downloadService, 
			FindMissionsService missionService, 
			DatabaseHandlerService databaseService,
			SendEmailService mailService) throws Exception {
		
		Document doc = downloadService.getHtml();
		
		List<Mission> results = missionService.findMissions(doc);
		
		results.forEach(result -> {
			
			try {
				if(!databaseService.checkIfMissionExists(result)) {
					databaseService.saveMission(result);
					mailService.sendNotifications(
						ApplicationConfig.getSendToList(),
						"New Mission",
						String.format("\n%s%s\n%s%s\n", "New Mission: ", result.getName(), "Type: ", result.getType().name())
					);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

}
