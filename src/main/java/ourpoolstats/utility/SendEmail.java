package ourpoolstats.utility;

import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import ourpoolstats.service.user.UserOperration;

public class SendEmail {

	public void sendEmail(String emails) {  

		Random random = new Random();
		int a = 1000; // numero minimo
		int b = 5000; // numero massimo
		int c = ((b-a) + 1);
		int miavar = random.nextInt(c) + a;

		final String username = "ourpoolstats@gmail.com";
		final String password = "Rtaplow160876?";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("ourpoolstats@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(emails));
			message.setSubject("Password Temporanea");
			message.setText(
					"La tua Nuova password Temporanea  "
					+ miavar + "\n collegati e cambiala Subito."
							+ "\n"
							+ "Cordiali Saluti");

			Transport.send(message);
			UserOperration userOperration = new UserOperration();
			String user = userOperration.findUsernameToEmail(emails);
			//userOperration.changePassword(user, String.valueOf(miavar));
			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}



}
