package com.github.setzo.crawler.service;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import com.github.setzo.crawler.config.ApplicationConfig;

@Component("downloadHtmlService")
public class DownloadHtmlService {

	public Document getHtml() throws IOException {
		
		Connection.Response res = Jsoup.connect(ApplicationConfig.getConnectionUrl())
				.userAgent(ApplicationConfig.getUserAgent())
				.data("email", ApplicationConfig.getEmail())
				.data("password", ApplicationConfig.getPassword())
				.data("game", ApplicationConfig.getGroup())
				.data("logowanie", ApplicationConfig.getLoginText())
				.method(Method.POST)
				.execute();

		return res.parse();
	}
	
}
