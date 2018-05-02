package util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailUtil {
	public static Properties props;
	public static Authenticator auth;
	static {
		props = new Properties();
		props.setProperty("mail.transport.protocol", "stmp");
		props.setProperty("mail.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.quitwait", "false");
		auth = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("koreanpremium@gmail.com", "PASSWORD---NEEDTOWRITE");
			}
		};
	}
	public static void sendEmail(String toAddress, String codeString) throws Exception {
		Session session = null;
		try {
			session = Session.getDefaultInstance(props, auth);
			MimeMessage msg = new MimeMessage(session);
			String contentText = "KPS 인증 메일 입니다.\n" + "인증 번호는 " + codeString + " 입니다.\n";
			msg.setSender(new InternetAddress("victoriaseong@gmail.com"));
			msg.setSubject("KPS 인증 메일입니다.");
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
			Multipart mp = new MimeMultipart();
			MimeBodyPart mbp1 = new MimeBodyPart();
			mbp1.setText(contentText);
			mp.addBodyPart(mbp1);
			msg.setContent(mp);
			Transport.send(msg);
		} catch (AddressException addr_e) {
			addr_e.printStackTrace();
		} catch (MessagingException msg_e) {
			msg_e.printStackTrace();
		}finally{
			if(session != null) {
				session = null;
			}
		}
	}
}
