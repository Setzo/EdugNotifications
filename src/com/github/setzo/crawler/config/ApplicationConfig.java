package com.github.setzo.crawler.config;

import java.util.ArrayList;
import java.util.List;

public class ApplicationConfig {

	private static final transient String connectionUrl = "URL";

	private static final transient String email = "LOGIN_EMAIL";
	
	private static final transient String password = "LOGIN_PASS";

	private static final transient String group = "LOGIN_GROUP";

	private static final transient String logIn = "ZALOGUJ / LOGIN";
	
	private static final transient String notificationEmail = "CRAWL_EMAIL";
	
	private static final transient String notificationEmailPassword = "CRAWL_EMAIL_PASS";
	
	private static final transient String smtpHost = "smtp.gmail.com";
	
	private static final transient String smtpPort = "587";
	
	private static final transient String smtpAuth = "true";
	
	private static final transient String smtpTls = "true";

	private static final transient String databaseConnectionUrl = "DATABASE_URL";
	
	private static final transient String databaseUsername = "DATABASE_USERNAME";
	
	private static final transient String databasePassword = "DATABASE_PASSWORD";
	
	private static final transient String userAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/47.0.2526.73 Chrome/47.0.2526.73 Safari/537.36";

	private static transient List<String> sendToList;
	
	static {
		sendToList = new ArrayList<String>();
		
		sendToList.add("EMAIL");
		sendToList.add("EMAIL");
		sendToList.add("EMAIL");
	}
	
	public static String getConnectionUrl() {
		return connectionUrl;
	}

	public static String getEmail() {
		return email;
	}

	public static String getPassword() {
		return password;
	}

	public static String getGroup() {
		return group;
	}

	public static String getLoginText() {
		return logIn;
	}
	
	public static String getUserAgent() {
		return userAgent;
	}

	public static String getNotificationEmail() {
		return notificationEmail;
	}

	public static String getNotificationEmailPassword() {
		return notificationEmailPassword;
	}
	
	public static String getSmtpHost() {
		return smtpHost;
	}

	public static String getSmtpPort() {
		return smtpPort;
	}

	public static String getSmtpAuth() {
		return smtpAuth;
	}

	public static String getSmtpTls() {
		return smtpTls;
	}
	
	public static String getDatabaseConnectionUrl() {
		return databaseConnectionUrl;
	}

	public static String getDatabaseUsername() {
		return databaseUsername;
	}

	public static String getDatabasePassword() {
		return databasePassword;
	}
	
	public static List<String> getSendToList() {
		return sendToList;
	}
}
