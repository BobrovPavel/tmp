import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.*;

public class GetPOPMails {

    private static final String MAIL_POP_HOST = "pop.gmail.com";
    private static final String MAIL_STORE_TYPE = "pop3";
    private static final String POP_USER = "raindropslolz@gmail.com";
    private static final String POP_PASSWORD = "TARGETstart113";
    private static final String POP_PORT = "995";
    private static Message body;

    private static String getTextFromMessage(Message message) throws MessagingException, IOException {
        String result = "";
        if (message.isMimeType("text/plain")) {
            result = message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        }
        return result;
    }

    private static String getTextFromMimeMultipart(MimeMultipart mimeMultipart) throws MessagingException, IOException {
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
                break;
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
            } else if (bodyPart.getContent() instanceof MimeMultipart) {
                result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
            }
        }
        return result;
    }

    public static void getMails(String user, String password) {
        try {
            Properties properties = new Properties();
            properties.put("mail.pop3.host", MAIL_POP_HOST);
            properties.put("mail.pop3.port", POP_PORT);
            properties.put("mail.pop3.starttls.enable", "true");
            properties.put("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            Session emailSession = Session.getDefaultInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(POP_USER, POP_PASSWORD);
                }
            });
            Store store = emailSession.getStore(MAIL_STORE_TYPE);

            store.connect(MAIL_POP_HOST, user, password);

            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            List<Message> messageList = new ArrayList<>();
            messageList = Arrays.asList(emailFolder.getMessages());
            System.out.println("messages.length---" + messageList.size());

            for (int i = 0, n = messageList.size(); i < n; i++) {
                Message message = messageList.get(i);
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Body: " + message.getContent());
                body = messageList.get(0);
                System.out.println(getTextFromMessage(body));
            }

            emailFolder.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getMails(POP_USER, POP_PASSWORD);
    }
}