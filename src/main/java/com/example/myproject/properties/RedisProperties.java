package com.example.myproject.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

@Component
@Data
@PropertySource(value = "classpath:/config/application-redis.yml")
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {

    private String master;

    private int database;

    /**
     * Connection timeout.
     */
    private Duration timeout;


    private List<String> nodes;

    private int maxIdle ;


    private int minIdle ;


    private int maxActive ;

    private long maxWaitMillis ;

}
