package org.tomp.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@Profile("shared-car")
public class MailUtil {

	private static final Logger log = LoggerFactory.getLogger(MailUtil.class);

	@Autowired
	public JavaMailSender emailSender;

	public void sendSimpleMessage(String from, String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		try {
			emailSender.send(message);
		} catch (MailSendException e) {
			log.error(e.getMessage());

			log.error(text);
		}
	}
}
