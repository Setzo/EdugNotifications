package com.github.setzo.crawler.config;

public class ApplicationConfig {

	private static final transient String connectionUrl = "URL";

	private static final transient String email = "MAIL";
	
	private static final transient String notificationEmail = "MAIL_N";
	
	private static final transient String notificationEmailPassword = "PASS_N";
	
	private static final transient String smtpHost = "smtp.gmail.com";
	
	private static final transient String smtpPort = "587";
	
	private static final transient String smtpAuth = "true";
	
	private static final transient String smtpTls = "true";

	private static final transient String password = "PASS";

	private static final transient String group = "GROUP";

	private static final transient String logIn = "ZALOGUJ / LOGIN";
	
	private static final transient String userAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/47.0.2526.73 Chrome/47.0.2526.73 Safari/537.36";

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
}
