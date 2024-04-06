package top.extrame.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

/**
 * The type SecurityConfiguration.
 *
 * @author Jx-zou
 */
@EnableReactiveMethodSecurity
@EnableWebFluxSecurity
public class SecurityConfigure {


    @Bean
    SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {



        return http.build();
    }
}
