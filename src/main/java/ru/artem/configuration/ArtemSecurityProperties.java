package ru.artem.configuration;

import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Data
@Configuration
@ConfigurationProperties(prefix = "security")
public class ArtemSecurityProperties {

    private List<User> users;

    @Data
    @Validated
    public static class User{
        private String username;
        private String password;
    }
}
