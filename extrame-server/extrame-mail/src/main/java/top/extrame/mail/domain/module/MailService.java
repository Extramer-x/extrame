package top.extrame.mail.domain.module;

import java.util.List;

/**
 * The type MailService.
 *
 * @author Jx-zou
 */
public interface MailService {

    List<? extends MailGroupDetails> loadMailGroup();
}
