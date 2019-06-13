package com.example.myproject.config;

import com.example.myproject.properties.RedisProperties;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
public class RedisConfig {
    @Autowired
    private RedisProperties redisProperties;


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
