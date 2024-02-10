package top.extrame.mail.domain;

import jakarta.mail.MessagingException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import top.extrame.mail.domain.pojo.CustomMailSender;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * The type MailTemplateFactory.
 *
 * @author Jx-zou
 */
public class MailTemplateFactory {

    /**
     * 根据mail配置获取mail发送器
     *
     * @return mail发送器 java mail sender
     */
    public static MailTemplate create(MailGroupDetails mailGroupDetails) throws UnsupportedEncodingException, MessagingException {
        mailGroupDetails.getMailSenderDetailsList().forEach();
        return new CustomMailSender(createSender(mailProperties));
    }

    private static JavaMailSenderImpl createSender(String host, Integer port, String username, String password, String protocol, Charset defaultEncoding, Properties properties) {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(host);
        sender.setPort(port);
        sender.setUsername(username);
        sender.setPassword(password);
        sender.setProtocol(protocol);
        sender.setDefaultEncoding(defaultEncoding.name());
        sender.setJavaMailProperties(properties);
        return sender;
    }
}
