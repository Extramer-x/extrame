package top.extrame.mail.pojo;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.Getter;
import lombok.Setter;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import top.extrame.mail.model.MailUser;

import java.io.UnsupportedEncodingException;

/**
 * MailProcessor
 *
 * @author Jx-zou
 */
@Setter
@Getter
public class MailProcessor {

    private final MailUser user;
    private final JavaMailSender sender;

    public MailProcessor(MailUser mailUser) {
        this.user = mailUser;
        this.sender = initializeMailSender();
    }

    private JavaMailSender initializeMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(user.getDetails().getHost());
        javaMailSender.setPort(user.getDetails().getPort());
        javaMailSender.setUsername(user.getUsername());
        javaMailSender.setPassword(user.getPassword());
        javaMailSender.setProtocol(user.getDetails().getProtocol());
        javaMailSender.setDefaultEncoding(user.getEncoding());
        javaMailSender.setJavaMailProperties(user.getProperties());
        return javaMailSender;
    }

    public MimeMessageHelper createMimeMessageHelper() throws MessagingException, UnsupportedEncodingException {
        MimeMessage mimeMessage = sender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        if (!user.getPersonal().isEmpty()) {
            mimeMessageHelper.setFrom(user.getUsername(), user.getPersonal());
        }
        return mimeMessageHelper;
    }

    @Async("mailTreadPoolTaskExecutor")
    public void send(MimeMessage... mimeMessages) {
        if (this.user.isEnabled()) {
            sender.send(mimeMessages);
        }
    }

    @Async("mailTreadPoolTaskExecutor")
    public void send(SimpleMailMessage... simpleMailMessages) {
        if (this.user.isEnabled()) {
            sender.send(simpleMailMessages);
        }
    }
}
