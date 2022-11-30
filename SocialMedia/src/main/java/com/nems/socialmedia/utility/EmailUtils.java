package com.nems.socialmedia.utility;

import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailUtils {

	
	@Autowired
	JavaMailSender emailSender;
	
	public void sendSimpleMessage(String to, String subject, String text, List<String> list) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("carljason0903@gmail.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		if(list != null && list.size() > 0)
			message.setCc(getCCArray(list));
		emailSender.send(message);
	}
	
	private String[] getCCArray(List<String> ccList) {
		String[] cc = new String[(ccList.size())];
		for(int i = 0; i<ccList.size(); i++) {
			cc[i]=ccList.get(i);
		}
		return cc;
	}
	
	public void forgotMail(String to, String subject, String password) throws MessagingException{
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setFrom("carljason0903@gmail.com");
		helper.setTo(to);
		helper.setSubject(subject);
		String htmlMsg = "<p><b>Your Login details for Blog</b><br><b>Email: </b> " + to + " <br><b>Password: </b> " + password + "<br><a href=\"http://localhost:8098/user/login/\">Click here to login</a></p>";
		message.setContent(htmlMsg, "text/html");
		emailSender.send(message);
	}
}
