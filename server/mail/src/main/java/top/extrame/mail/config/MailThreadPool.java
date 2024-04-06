package top.extrame.mail.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * TreadPoolConfig
 *
 * @author Jx
 **/
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "mail.pool")
public class MailThreadPool {

    private int corePoolSize = 10;
    private int maxPoolSize = 50;
    private int queueCapacity = 200;
    private int keepAliveSeconds = 60;
    private int awaitTerminationMillis = 60;
    private boolean waitForTasksToCompleteOnShutdown = true;
}
