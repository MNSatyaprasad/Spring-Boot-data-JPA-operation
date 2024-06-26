package com.bwas.servive;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSenderService implements SendingEmailService{
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}")
	private String fromMail;

	@Override
	public String purchaseItems(String[] items, Double[] prices, String[] toemails) throws Exception {
		double billAmount=0;
		for(double p :prices)
			billAmount=billAmount+p;
		
		String msg = Arrays.toString(items) +" With Prices "+Arrays.toString(prices) +" Ara Purchased with bill Amount "+billAmount;
		
		String status= sendMail(msg, toemails);
		return msg +"-----"+status;
	}
	
	private String sendMail(String msg,String[] tomails) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		helper.setFrom(fromMail);
		helper.setCc(tomails);
		helper.setSubject("Open it know it");
		helper.setSentDate(new Date());
		helper.setText(msg);
		helper.addAttachment("home.png", new ClassPathResource("home.png"));
		javaMailSender.send(message);
		return "mail sent";
	}
}
