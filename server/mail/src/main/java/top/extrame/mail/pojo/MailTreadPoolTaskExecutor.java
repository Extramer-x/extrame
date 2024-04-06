package top.extrame.mail.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import top.extrame.mail.config.MailThreadPool;

import java.io.Serial;

/**
 * MailTreadPoolTaskExecutor
 *
 * @author Jx
 */
@Component("mailTreadPoolTaskExecutor")
public class MailTreadPoolTaskExecutor extends ThreadPoolTaskExecutor {

    @Serial
    private static final long serialVersionUID = -7071021297991383051L;

    private static final String THREAD_NAME_PREFIX = "[Mail] mailTaskExecutor--";
    /**
     * mail线程池配置对象
     */
    private MailThreadPool poolConfig;


    @Autowired
    public MailTreadPoolTaskExecutor(MailThreadPool mailThreadPool) {
        this.poolConfig = mailThreadPool;
    }

    /**
     * Instantiates a new Mail tread pool task executor.
     */
    public MailTreadPoolTaskExecutor() {
        super.setCorePoolSize(poolConfig.getCorePoolSize());
        super.setMaxPoolSize(poolConfig.getMaxPoolSize());
        super.setQueueCapacity(poolConfig.getQueueCapacity());
        super.setKeepAliveSeconds(poolConfig.getKeepAliveSeconds());
        super.setThreadNamePrefix(THREAD_NAME_PREFIX);
        super.setWaitForTasksToCompleteOnShutdown(poolConfig.isWaitForTasksToCompleteOnShutdown());
        super.setAwaitTerminationMillis(poolConfig.getAwaitTerminationMillis());
    }
}
