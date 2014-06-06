package bee;

/*
 * by baruch o 
 * 27.5.2014  create ,send put to web site
 * 
 * 
 */


import java.io.OutputStreamWriter;
import java.net.*;
//for mail 
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;


public class Ncom {

	public static void main(String[] args) throws Exception {
	
	}
	
	
//send mail test for Gmail	
public static void sendMail(String user,String from, String pass, String[] to, String subject, String body)
{
	   Properties props = System.getProperties();
       String host = "smtp.gmail.com";
       props.put("mail.smtp.starttls.enable", "true");
       props.put("mail.smtp.host", host);
       props.put("mail.smtp.user", user);
       props.put("mail.smtp.password", pass);
       props.put("mail.smtp.port", "587");
       props.put("mail.smtp.auth", "true");
       props.put("mail.smtp.from",from);

       Session session = Session.getDefaultInstance(props);
       MimeMessage message = new MimeMessage(session);

       try {
           message.setFrom(new InternetAddress(from));
           InternetAddress[] toAddress = new InternetAddress[to.length];

           // To get the array of addresses
           for( int i = 0; i < to.length; i++ ) {
               toAddress[i] = new InternetAddress(to[i]);
           }

           for( int i = 0; i < toAddress.length; i++) {
               message.addRecipient(Message.RecipientType.TO, toAddress[i]);
           }

           message.setSubject(subject);
           message.setText(body);
           Transport transport = session.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(message, message.getAllRecipients());
           transport.close();
       }
       catch (AddressException ae) {
           ae.printStackTrace();
       }
       catch (MessagingException me) {
           me.printStackTrace();
       }    


    
	
}	
	
	// putXML send get to web site
	public static void putXML(String XmlString,String Url) throws Exception
	{
		//"http://192.168.56.200/ptest.php"
		URL url = new URL(Url);
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.setDoOutput(true);
		httpCon.setRequestMethod("PUT");
		OutputStreamWriter out = new OutputStreamWriter(
			httpCon.getOutputStream());
			out.write(XmlString);
			out.close();
			httpCon.getInputStream();
	}
	
	
}
