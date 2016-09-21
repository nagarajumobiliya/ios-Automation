package com.mobiliya.iosDemo.realDeviceTest.configure;

import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailReport {

	public static void sendMail() {

		Properties props = new Properties();
		
		props.put("mail.smtp.from", Constants.EMAIL_FROM);
        props.put("mail.smtp.host", Constants.EMAIL_HOST);
        props.put("mail.smtp.port", Constants.EMAIL_PORT);
        props.put("mail.smtp.auth", Constants.EMAIL_SMTP_AUTH);
        props.put("mail.smtp.socketFactory.port", Constants.EMAIL_PORT);
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.put("mail.smtp.starttls.enable", "true");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(Constants.EMAIL_USERNAME, Constants.EMAIL_PASSWORD);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(Constants.EMAIL_FROM));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Constants.EMAIL_TO));
			message.setSubject("Testing Report");

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();
			messageBodyPart = new MimeBodyPart();

			DataSource source = new FileDataSource(Constants.REPORT_FILEPATH);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(Constants.REPORT_FILENAME);
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);
			System.out.println("Sending Email...");
			Transport.send(message);

			System.out.println("Email sent.");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
}
