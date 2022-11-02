package com.temple.service;

import java.io.File;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendSimpleMessage(String to, String subject, String text) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("xxxxHospital@gmail.com");
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		javaMailSender.send(message);

	}
	
}
