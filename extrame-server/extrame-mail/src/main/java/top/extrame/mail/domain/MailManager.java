package top.extrame.mail.domain;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import top.extrame.mail.domain.module.MailGroupDetails;
import top.extrame.mail.domain.module.MailService;

import java.util.List;

/**
 * Mail管理类
 */
@Slf4j
@Component
public class MailManager {

    private static final String MAIL_TEMPLATE_SUFFIX = "MailTemplate";

    private final DefaultListableBeanFactory beanFactory;

    /**
     * 初始化mail管理类
     */
    @Autowired
    public MailManager(ConfigurableApplicationContext applicationContext) {
        this.beanFactory = (DefaultListableBeanFactory) applicationContext.getBeanFactory();
        this.processMailTemplateRegistry();
    }
    private void processMailTemplateRegistry() {
        try {
            this.add(beanFactory.getBean(MailService.class).loadMailGroup());
        } catch (Exception e) {
            log.error("初始化MailTemplate失败.", e);
            throw new RuntimeException(e);
        }
    }

    public void add(List<? extends MailGroupDetails> mailGroups) {
        //注入mailTemplate
        mailGroups.forEach(mailGroup -> {
            BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MailTemplate.class);
            builder.addConstructorArgValue(mailGroup);
            beanFactory.registerBeanDefinition(mailGroup.getName() + MAIL_TEMPLATE_SUFFIX, builder.getBeanDefinition());
        });
    }

    public void remove(String name) {
        this.beanFactory.removeBeanDefinition(name + MAIL_TEMPLATE_SUFFIX);
    }

    public MailTemplate getTemplate(String name) {
        return this.beanFactory.getBean(name + MAIL_TEMPLATE_SUFFIX, MailTemplate.class);
    }
}
