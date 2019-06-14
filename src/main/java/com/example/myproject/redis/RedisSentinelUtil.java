package com.example.myproject.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisSentinelPool;
import redis.clients.jedis.commands.JedisCommands;
import redis.clients.jedis.params.SetParams;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class RedisSentinelUtil {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private JedisSentinelPool pool;

    private static final Long RELEASE_SUCCESS = 1L;

    public static final String UNLOCK_LUA;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("if redis.call(\"get\",KEYS[1]) == ARGV[1] ");
        sb.append("then ");
        sb.append("    return redis.call(\"del\",KEYS[1]) ");
        sb.append("else ");
        sb.append("    return 0 ");
        sb.append("end ");
        UNLOCK_LUA = sb.toString();
    }


    public boolean setLock(String key, String requestId,int expire) {
        try {
            Jedis jedis = pool.getResource();

            SetParams setParams = new SetParams();
            setParams.nx().ex(expire);
            return "OK".equals(jedis.set(key, requestId, setParams));
        } catch (Exception e) {
            log.error("set redis occured an exception", e);
        }
        return false;
    }

    public boolean releaseLock(String key, String requestId) {

        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = pool.getResource().eval(UNLOCK_LUA, Collections.singletonList(key), Collections.singletonList(requestId));
        if (RELEASE_SUCCESS.equals(result)) {
            return true;
        }

        return false;
    }

}
