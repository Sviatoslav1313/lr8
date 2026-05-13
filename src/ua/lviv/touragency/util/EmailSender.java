package ua.lviv.touragency.util;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class EmailSender {

    private static final String MY_EMAIL = "svjatoslav200713@gmail.com";

    private static final String APP_PASSWORD = "";

    public static void sendCriticalError(String errorInfo) {
        System.out.println("[EMAIL] Preparing to send email notification...");

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MY_EMAIL, APP_PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(MY_EMAIL));
            // Відправляємо самому собі
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(MY_EMAIL)
            );
            message.setSubject("CRITICAL ERROR: Tour Agency System");
            message.setText("У системі сталася критична помилка:\n\n" + errorInfo +
                    "\n\nПеревірте лог-файл на сервері.");

            Transport.send(message);
            System.out.println("[EMAIL] Sent successfully to " + MY_EMAIL);

        } catch (MessagingException e) {
            System.err.println("[EMAIL] Failed to send: " + e.getMessage());
            e.printStackTrace();
        }
    }
}