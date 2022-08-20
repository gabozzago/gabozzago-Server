package com.wwg.gabozzago.global.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Getter
@AllArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "google")
public class GoogleProperties {
    private final String clientId;
    private final String clientSecret;
    private final String scope;

}
