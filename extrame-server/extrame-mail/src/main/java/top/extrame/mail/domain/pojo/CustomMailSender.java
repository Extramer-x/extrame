package top.extrame.mail.domain.pojo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.io.UnsupportedEncodingException;

/**
 * 邮件发送器
 *
 * @author Jx-zou
 */
public class CustomMailSender {

    private JavaMailSenderImpl sender;
    private final MimeMessage baseMimeMessage;
    private int fail = 0;

    public CustomMailSender(JavaMailSenderImpl sender) {
        this.sender = sender;
        this.baseMimeMessage = sender.createMimeMessage();
    }

    public CustomMailSender(JavaMailSenderImpl sender, MimeMessage baseMimeMessage) {
        this.sender = sender;
        this.baseMimeMessage = baseMimeMessage;
    }

    public void set(JavaMailSenderImpl sender) {
        this.sender = sender;
    }

    public void send(MimeMessage... mimeMessages) throws MessagingException, MailException {
        for (MimeMessage mimeMessage : mimeMessages) {
            mimeMessage.setSender(baseMimeMessage.getSender());
        }
        sender.testConnection();
        sender.send(mimeMessages);
    }

    public boolean isEnabled(int attempts) {
        return this.fail >= attempts;
    }

    public void failed() {
        this.fail++;
    }

    public void resetFail() {
        this.fail = 0;
    }

    public String getFrom() {
        return sender.getUsername();
    }

    public void setPersonal(String personal) throws UnsupportedEncodingException, MessagingException {
        this.baseMimeMessage.setFrom(new InternetAddress(sender.getUsername(), personal, sender.getDefaultEncoding()));
    }
}
