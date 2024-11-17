package com.apenasnagelo.api_rest.Security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "security.config")
public class SecurityConfig {
    public String PREFIX;
    public String KEY;
    public long EXPIRATION;

    public void setPREFIX(String prefix) {
        this.PREFIX = prefix;
    }

    public void setKEY(String key) {
        this.KEY = key;
    }

    public void setEXPIRATION(long expiration) {
        this.EXPIRATION = expiration;
    }
}
