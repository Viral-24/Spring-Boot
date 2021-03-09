package com.learning.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService {
	
	private JavaMailSender javamailSender;
	
	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		
		this.javamailSender=javamailSender;
	}
	
	@Async
	 public void sendEmail(SimpleMailMessage email) {
       javamailSender.send(email);
    }

}
