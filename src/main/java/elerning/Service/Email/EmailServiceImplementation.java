package elerning.Service.Email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailServiceImplementation implements EmailService {

    String username;

    String password;

    @Override
    public void sendEmail(String senderName, String senderEmail, String subject, String messagePlainText) {




        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(username));
            message.setSubject(subject);
            message.setText("Imię nadawcy: "+ senderName+ "\n"
                    +"email nadawcy: "+ senderEmail+ "\n"
                    + messagePlainText);
            Transport.send(message);


        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


    }


}
