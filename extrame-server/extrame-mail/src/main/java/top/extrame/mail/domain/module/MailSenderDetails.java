package top.extrame.mail.domain.module;

import java.nio.charset.Charset;

/**
 * The type MailSender.
 *
 * @author Jx-zou
 */
public interface MailSenderDetails {

    String getHost();

    Integer getPort();

    String getUsername();

    String getPassword();

    String getProtocol();

    Charset getDefaultEncoding();
}
