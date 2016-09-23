package com.mobiliya.framework.utilities;

import java.util.Properties;
import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.mobiliya.framework.configure.Constants;
import com.mobiliya.framework.configure.BaseClass;

public class EmailUtility extends BaseClass {

	public static void sendMail(String email, String password, String attachmentFilePath) {

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
				return new PasswordAuthentication(email, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(Constants.EMAIL_FROM));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Testing Report");

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();
			messageBodyPart = new MimeBodyPart();

			DataSource source = new FileDataSource(attachmentFilePath);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName("Report");
			multipart.addBodyPart(messageBodyPart);

			message.setContent(multipart);
			APP_LOGS.info("Sending Email...");

			Transport.send(message);
			APP_LOGS.info("Email sent.");

		} catch (MessagingException e) {
			APP_LOGS.error("Unable to send email: " + e.getMessage());
			e.printStackTrace();
		}

	}
}