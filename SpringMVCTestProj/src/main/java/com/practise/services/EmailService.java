package com.practise.services;

import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private int OTP;
	private static final Random rand = new Random();
	//public static Logger logger = Logger.getLogger(EmailService.class);
	private JavaMailSender mailSender;

	public JavaMailSender getMailSender() {
		System.out.println("getmailSender"+ mailSender);
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		System.out.println("setMailSender"+mailSender);
		this.mailSender = mailSender;
	}
	
	private static int generateOTP(){
		 return 100000 + rand.nextInt(900000);
	}
	public int sendMail(String email) {
		System.out.println("sendmail()"+ email);
		OTP = EmailService.generateOTP();MimeMessage message = this.mailSender.createMimeMessage();
		MimeMessageHelper mimeHelper;
		try {
			mimeHelper = new MimeMessageHelper(message, true);
			mimeHelper.setTo(email);
			mimeHelper.setFrom("g28vaishali@gmail.com");
			mimeHelper.setSubject("Password Reset");
			mimeHelper.setText("<html><body>Use this OTP:   "+ OTP + "</body></html>", true);
		//	mimeHelper.setText("<html><body>hi,<br/><a href='http://localhost:8080/SpringMVCTestProj/resetPage'> Click here</a> to reset password</body></html>", true);
			mailSender.send(message);
			
		} catch (MessagingException e) {
			System.out.println("Error Sending email " + e.getMessage());
		}
		return OTP;
	}
}