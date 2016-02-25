package com.github.setzo.crawler.service;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.github.setzo.crawler.config.ApplicationConfig;

public class SendEmailService {

	private Properties props;

	public SendEmailService() {

		this.props = System.getProperties();
		props.put("mail.smtp.starttls.enable", ApplicationConfig.getSmtpTls());
		props.put("mail.smtp.host", ApplicationConfig.getSmtpHost());
		props.put("mail.smtp.user", ApplicationConfig.getNotificationEmail());
		props.put("mail.smtp.password", ApplicationConfig.getNotificationEmailPassword());
		props.put("mail.smtp.port", ApplicationConfig.getSmtpPort());
		props.put("mail.smtp.auth", ApplicationConfig.getSmtpAuth());
	}
	
	public void sendNotifications(List<String> to, String subject, String body) {
		
		to.forEach(mail -> {
			this.sendNotification(mail, subject, body);
		});
	}

	private void sendNotification(String to, String subject, String body) {

		Session session = Session.getDefaultInstance(props);
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(ApplicationConfig.getNotificationEmail()));
			InternetAddress toAddress = new InternetAddress();

			toAddress = new InternetAddress(to);

			message.addRecipient(Message.RecipientType.TO, toAddress);

			message.setSubject(subject);
			message.setText(body);
			Transport transport = session.getTransport("smtp");
			
			transport.connect(
					ApplicationConfig.getSmtpHost(),
					ApplicationConfig.getNotificationEmail(),
					ApplicationConfig.getNotificationEmailPassword()
			);
			
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			
		} catch (AddressException ae) {
			ae.printStackTrace();
			
		} catch (MessagingException me) {
			me.printStackTrace();
		}
	}
}
