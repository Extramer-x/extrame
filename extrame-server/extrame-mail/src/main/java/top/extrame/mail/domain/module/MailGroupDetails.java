package top.extrame.mail.domain.module;

import java.util.List;
import java.util.Map;

/**
 * The type MailGroup.
 *
 * @author Jx-zou
 */
public interface MailGroupDetails {

    String getName();

    String getPersonal();

    Integer getAttempts();

    List<? extends MailSenderDetails> getMailSenderDetailsList();

    Map<String, String> getProperties();

    String getDescription();
}
