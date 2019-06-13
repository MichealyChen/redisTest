package com.example.myproject.redis;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

public class RedisSentinelUtil {

    @Autowired
    private JedisSentinelPool pool;


    public Jedis getJedis() {
        return pool.getResource();
    }
}
