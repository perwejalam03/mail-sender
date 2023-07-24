package org.jsp.mailsender.controller;

import org.jsp.mailsender.dto.EmailConfiguration;
import org.jsp.mailsender.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendEmailController {
	@Autowired
	private SendEmailService emailService;
	
	@Autowired
	private EmailConfiguration configuration;
	
	@PostMapping("/sendmail")
	public String sendEmail(String emailId) {
		configuration.setEmail(emailId);
		configuration.setSubject("Testing java Mail");
		configuration.setText("We are sending this mail to test the mail API");
		return emailService.sendEmail(configuration);
	}
}
