package com.royal.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.royal.bean.ProductBean;

import javax.mail.internet.MimeMessage;

public class ValidationUtils 
{
	public static String random(int size) {

        StringBuilder generatedToken = new StringBuilder();
        try {
            SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
            // Generate 20 integers 0..20
            for (int i = 0; i < size; i++) 
            {
                generatedToken.append(number.nextInt(9));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return generatedToken.toString();
    }

	
	public static boolean isEmptyStringName(String name)
	{
	    if(name == null || name.equals(""))
	        return true;

	    if(!name.matches("[a-zA-Z]*"))
	        return true;

	    return false;
	}
	public static boolean isEmptySecurityQue(String name)
	{
	    if(name == null || name.equals("") || Integer.parseInt(name)==0)
	        return true;

	    return false;
	}
	public static boolean isValidContactNum(String s) 
    { 
        // The given argument to compile() method  
        // is regular expression. With the help of  
        // regular expression we can validate mobile 
        // number.  
        // 1) Begins with 0 or 91 
        // 2) Then contains 7 or 8 or 9. 
        // 3) Then contains 9 digits 
        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}"); 
  
        // Pattern class contains matcher() method 
        // to find matching between given number  
        // and regular expression 
        Matcher m = p.matcher(s); 
        return (m.find() && m.group().equals(s)); 
    }
/*
 * 
 			# Start of group
				  (?=.*\d)		#   must contains one digit from 0-9
				  (?=.*[a-z])		#   must contains one lowercase characters
				  (?=.*[A-Z])		#   must contains one uppercase characters
				  (?=.*[@#$%])		#   must contains one special symbols in the list "@#$%"
				              .		#     match anything with previous condition checking
				                {6,20}	#        length at least 6 characters and maximum of 20	
				)			# End of group
			  
			 
		2. Password that match:-
		------------------------
		1. mkyong1A@
		2. mkYOn12$

		3. Password that doesn’t match:-
		---------------------------------
		1. mY1A@ , too short, minimum 6 characters
		2. mkyong12@ , uppercase characters is required
		3. mkyoNg12* , special symbol “*” is not allow here
		4. mkyonG$$, digit is required
		5. MKYONG12$ , lower case character is required
*/		
	public static boolean isValidPassword(final String password) 
	{
		final String PASSWORD_PATTERN = 
	              "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
		        
		Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
			  
		Matcher matcher = pattern.matcher(password);
		System.out.println("isValidPassword ===> matcher : " + matcher +" - matcher.matches() - " + matcher.matches());
		return (matcher.matches());
	}
	
	
	public static boolean verifyEmail(String email)
	{
//	    email = email.trim();

	    if(email == null || email.equals(""))
	        return true;

	    if(!email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"))
	        return true;

	    return false;
	}
	
	public static String sendSMS(String OTPMsg,String contactNumber) 
	{
		try {
			// Construct data
			String apiKey = "apikey=" + "mBMObE1Q8jQ-xSdUQqt3ECKdReXYrq8yhwGPFOPZbq";
			String message = "&message=WonderBoon OTP - "+OTPMsg+". Use this to change password.";
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + contactNumber;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			System.out.println(data);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
	
	
	public static String sendOrder(String contactNumber,String store_ownerName) 
	{
		try {
			// Construct data
			String apiKey = "apikey=" + "mBMObE1Q8jQ-Tod3enIbkLYFPtM3ZahbBEc644hLcs";
			String message = "&message=Dear "+store_ownerName+", There is a new Order From Customer! Check It Now!";
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + contactNumber;
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			System.out.println(data);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
	
	
	
	public static String sendConfirmation(String user_email,String user_name,ProductBean productBean) 
	{
		String to = user_email;
		final String from = "wonderboon2610@gmail.com";

		String host = "smtp.gmail.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Get the Session object.// and pass username and password
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				
				return new javax.mail.PasswordAuthentication(from, "dp4416174");
				
			}
			
		});

		// Used to debug SMTP issues
		session.setDebug(true);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);
			
			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));
			
			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			// Set Subject: header field
			message.setSubject("WONDERBOON Order Confirmation");
			
			// Now set the actual message
			message.setText("WONDERBOON\r\n" + 
					"Dear "+user_name+", Your Order for "+productBean.getProduct_Name()+" is Confirmed\r\n" + 
					"Your Order's notification is sent to Store Owner\r\n" + 
					"If you don't recognize the WONDERBOON account "+to+", you can click here to remove your email address from that account.\r\n" + 
					"Thanks,\r\n" + 
					"WONDERBOON team");
			
			System.out.println("sending...");
			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
		return host;
		}
	
	
	
	
	
	
	public static String sendOTPByEmail(String toEmail,String setSubject,String otpMsg) 
	{
		String to = toEmail;
		final String from = "wonderboon2610@gmail.com";

		String host = "smtp.gmail.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Get the Session object.// and pass username and password
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				
				return new javax.mail.PasswordAuthentication(from, "dp4416174");
				
			}
			
		});

		// Used to debug SMTP issues
		session.setDebug(true);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);
			
			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));
			
			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			// Set Subject: header field
			message.setSubject("WONDERBOON account password reset");
			
			// Now set the actual message
			message.setText("WONDERBOON\r\n" + 
					"Password reset code\r\n" + 
					"Please use this code to reset the password for the WONDERBOON account "+to+".\r\n" + 
					"Here is your code: "+otpMsg+"\r\n" + 
					"If you don't recognize the WONDERBOON account "+to+", you can click here to remove your email address from that account.\r\n" + 
					"Thanks,\r\n" + 
					"The WONDERBOON team");
			
			System.out.println("sending...");
			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
		return host;
		}


	

	

}
