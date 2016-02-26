package com.github.setzo.crawler.config.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.net.URI;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import com.github.setzo.crawler.config.ApplicationConfig;

public class ApplicationConfigTest {

	@Rule
	public Timeout globalTimeout = Timeout.millis(10);
	
	@Test
	public void checkIfDatabaseConnectionUrlMatchesTest() {
		
		try {
			
			URI uri = new URI(ApplicationConfig.getDatabaseConnectionUrl());
			
			assertNotNull("Scheme cannot be null", uri.getScheme());
			assertNotNull("Rest of the address cannot be null", uri.getSchemeSpecificPart());
			
		} catch (Exception e) {
			fail("Database connection URL is not correct.");
		}
	}
	
	@Test
	public void checkIfTlsMatchesTest() {
		assertTrue("Smtp tls can be only true or false.",
				ApplicationConfig.getSmtpTls().equals("true") ||
				ApplicationConfig.getSmtpTls().equals("false"));
	}
	
	@Test
	public void checkIfAuthMatchesTest() {
		assertTrue("Smtp auth can be only true or false.",
				ApplicationConfig.getSmtpAuth().equals("true") ||
				ApplicationConfig.getSmtpAuth().equals("false"));
	}
	
	@Test
	public void getConnectionUrlTest() {
		assertNotNull("Connection URL cannot be null.", ApplicationConfig.getConnectionUrl());
	}
	
	@Test
	public void getEmailTest() {
		assertNotNull("Email cannot be null.", ApplicationConfig.getEmail());
	}
	
	@Test
	public void getPasswordTest() {
		assertNotNull("Email password cannot be null.", ApplicationConfig.getPassword());
	}
	
	@Test
	public void getGroupTest() {
		assertNotNull("Group cannot be null.", ApplicationConfig.getGroup());
	}
	
	@Test
	public void getLoginTextTest() {
		assertNotNull("Login text cannot be null.", ApplicationConfig.getLoginText());
	}
	
	@Test
	public void getUserAgentTest() {
		assertNotNull("User Agent cannot be null.", ApplicationConfig.getUserAgent());
	}
	
	@Test
	public void getNotificationEmailTest() {
		assertNotNull("Notification email cannot be null.", ApplicationConfig.getNotificationEmail());
	}
	
	@Test
	public void getNotificationEmailPasswordTest() {
		assertNotNull("Notification email password cannot be null.", ApplicationConfig.getNotificationEmailPassword());
	}
	
	@Test
	public void getSmtpHostTest() {
		assertNotNull("Smtp host cannot be null.", ApplicationConfig.getSmtpHost());
	}
	
	@Test
	public void getSmtpPortTest() {
		assertNotNull("Smtp port cannot be null.", ApplicationConfig.getSmtpPort());
	}
	
	@Test
	public void getSmtpAuthTest() {
		assertNotNull("Smtp auth cannot be null.", ApplicationConfig.getSmtpAuth());
	}
	
	@Test
	public void getSmtpTlsTest() {
		assertNotNull("Smtp TLS cannot be null.", ApplicationConfig.getSmtpTls());
	}
	
	@Test
	public void getDatabaseConnectionUrlTest() {
		assertNotNull("Database connection URL cannot be null.", ApplicationConfig.getDatabaseConnectionUrl());
	}
	
	@Test
	public void getDatabaseUsernameTest() {
		assertNotNull("Database username cannot be null.", ApplicationConfig.getDatabaseUsername());
	}
	
	@Test
	public void getDatabasePasswordTest() {
		assertNotNull("Database password cannot be null.", ApplicationConfig.getDatabasePassword());
	}
	
	@Test
	public void getSendToListTest() {
		assertNotNull("Database password cannot be null.", ApplicationConfig.getSendToList());
		assertTrue("Send to list cannot be empty.", ApplicationConfig.getSendToList().size() != 0);
	}
	
}
