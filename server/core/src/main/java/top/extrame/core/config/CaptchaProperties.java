package top.extrame.core.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "extra.safety.captcha")
public class CaptchaProperties {

    private Code mail;
    private Code sms;

    @Setter
    @Getter
    public static class Code {
        private Integer size;
        private Integer expire;
    }
}
