package com.sagol.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.sagol.dto.emailVO;

@Component
public class emailUtil {

	@Autowired
	private JavaMailSender sender;

	public void sendEmail(emailVO emailvo) {

		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setTo(emailvo.getToAddress());
			helper.setSubject(emailvo.getSubject());
			helper.setText(emailvo.getBody());
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		sender.send(message);

	}

}