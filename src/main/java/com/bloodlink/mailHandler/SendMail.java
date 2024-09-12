package com.bloodlink.mailHandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.bloodlink.model.RequestBlood;

@Service
public class SendMail {
	
	@Autowired
	private JavaMailSender jsm;
	
	  public void postMail(List<String> gmails, RequestBlood requestBlood) {
	        SimpleMailMessage msg = new SimpleMailMessage();

	      
	        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy"); 
	        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a"); 

	       
	        Date requestDate = new Date(requestBlood.getDate().getTime());

	       
	        String subject = "Urgent: " + requestBlood.getUnit() + " Units of " + requestBlood.getBloodGrp() + " Blood Needed!";

	        
	        StringBuilder text = new StringBuilder();
	        text.append("Dear Donor,\n\n")
	            .append("We urgently require ").append(requestBlood.getUnit()).append(" units of ")
	            .append(requestBlood.getBloodGrp()).append(" blood.\n\n")
	            .append("Request Details:\n")
	            .append("------------------------------\n")
	            .append("Patient Name:").append(requestBlood.getPatient()).append("\n")
	            .append("Contact Person: ").append(requestBlood.getContact()).append("\n")
	            .append("Phone: ").append(requestBlood.getPhone()).append("\n")
	            .append("Date: ").append(dateFormat.format(requestDate)).append("\n")
	            .append("Time: ").append(requestBlood.getTime()).append("\n") 
	            .append("Hospital: ").append(requestBlood.getHospital()).append("\n")
	            .append("------------------------------\n\n")
	            .append("Your prompt response can save a life. Thank you for your support.\n\n")
	            .append("Best regards,\n")
	            .append("BloodLink Team");

	        
	        msg.setTo(gmails.toArray(new String[0]));
	        msg.setSubject(subject);
	        msg.setText(text.toString());

	        
	        try {
	            jsm.send(msg);
	        } catch (Exception e) {
	           
	            e.printStackTrace();
	           
	        }
	    }

}
