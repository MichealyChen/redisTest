package com.example.myproject.config;
import com.example.myproject.properties.RedisProperties1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.List;

@Configuration
public class RedisConfig {

    @Autowired
    private RedisProperties1 redisProperties;


    @Bean
    public JedisSentinelPool getSentinelCluster() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisProperties.getMaxIdle());
        poolConfig.setMinIdle(redisProperties.getMaxIdle());
        poolConfig.setMaxWaitMillis(redisProperties.getMaxWaitMillis());
        poolConfig.setTestOnBorrow(false);
        poolConfig.setTestOnReturn(false);
        poolConfig.setTestWhileIdle(true);
        poolConfig.setMinEvictableIdleTimeMillis(60000);
        poolConfig.setTimeBetweenEvictionRunsMillis(30000);
        poolConfig.setNumTestsPerEvictionRun(-1);
        String masterName = redisProperties.getMaster();
        List<String> sentinels = redisProperties.getNodes();
        return new JedisSentinelPool(masterName, new HashSet<>(sentinels), poolConfig);
    }


}
