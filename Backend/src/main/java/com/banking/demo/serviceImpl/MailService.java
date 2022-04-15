package com.banking.demo.serviceImpl;

import java.util.Properties;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



@Service
public class MailService {




	public boolean sendMail(String email, String oneTimePassword) {
	
		try {
				Properties props=System.getProperties();
				props.put("mail.transport.protocol","smtp");
				props.put("mail.smtp.host", HOST);
				props.put("mail.smtp.port", PORT);
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.auth", "true");
	
				Session session=Session.getDefaultInstance(props);
				MimeMessage msg=new MimeMessage(session);
				msg.setFrom(new InternetAddress(FROM,FROMNAME));
				msg.setRecipient(Message.RecipientType.TO,new InternetAddress(email));
				msg.setSubject(SUBJECT);
				msg.setContent("please enter otp to verify email: "+oneTimePassword,"text/html");
				Transport transport=session.getTransport();
				transport.connect(HOST,SMTP_USERNAME,SMTP_PASSWORD);
				transport.sendMessage(msg,msg.getAllRecipients());
				return true;
		}catch(Exception ex) {
				return false;
	
		}
	}
}
