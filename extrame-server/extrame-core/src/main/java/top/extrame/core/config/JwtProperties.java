package top.extrame.core.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "extra.safety.jwt")
public class JwtProperties {

    private Token accessToken;
    private Token refreshToken;

    @Setter
    @Getter
    static class Token {
        private Integer expire;
        private String prefix;
        private String iss;
        private String sub;
    }
}
