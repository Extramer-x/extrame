package top.extrame.mail.domain;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import org.springframework.mail.MailException;
import org.springframework.scheduling.annotation.Async;
import top.extrame.mail.domain.module.MailGroupDetails;
import top.extrame.mail.domain.pojo.CustomMailSender;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * MailTemplate
 *
 * @author Jx-zou
 */
@Slf4j
public class MailTemplate {

    private final MailGroupDetails mailGroupDetails;

    public MailTemplate(MailGroupDetails mailGroupDetails) {
        this.mailGroupDetails = mailGroupDetails;
    }

    /**
     * mail发送器
     */
    @Setter
    @Getter
    private List<CustomMailSender> senders;

    /**
     * 轮询发送
     *
     * @param mimeMessages MimeMessage集合
     */
    @Async("mailTreadPoolTaskExecutor")
    public void send(MimeMessage... mimeMessages) {
        for (CustomMailSender sender : senders) {
            if (sender.isEnabled(mailGroupDetails.getAttempts())) {
                try {
                    sender.send(mimeMessages);
                    return;
                } catch (MessagingException | MailException e) {
                    sender.failed();
                    log.info("[" + sender.getFrom() + "]发送错误.");
                }
            }
        }
    }

    public int getAttempts() {
        return mailGroupDetails.getAttempts();
    }

    public void setAttempts(int attempts) {
        ;
    }

    public void setPersonal(String personal) {
        this.senders.forEach(sender -> {
            try {
                sender.setPersonal(personal);
            } catch (UnsupportedEncodingException | MessagingException e) {
                log.error("修改personal失败.");
                throw new RuntimeException(e);
            }
        });
    }
}
