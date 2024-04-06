package top.extrame.mail.model;

import java.util.Properties;

/**
 * The type MailDetails.
 *
 * @author Jx-zou
 */
public interface MailUser {

    String getUsername();
    String getPassword();
    String getPersonal();
    String getEncoding();
    Boolean isEnabled();
    String getDescription();
    Properties getProperties();
    MailDetails getDetails();
}
