package com.example.myproject;

import com.example.myproject.dao.borrow.FinancialBorrowDetailMapper;
import com.example.myproject.redis.RedisSentinelUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.Aware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private StringRedisTemplate redis;

    @Autowired
    private RedisSentinelUtil util;


//    @Autowired
//    Jedis jedis;

    @Resource
    private FinancialBorrowDetailMapper financialBorrowDetailMapper;

    @Test
    public void contextLoads() {

        List<Map<Object, Object>> maps = financialBorrowDetailMapper.selectMydata();

        System.out.println(maps);
    }

    @Test
    public void redisTest() {
        redis.opsForValue().set("ssss","44444444");
        System.out.println(redis.opsForValue().get("ssss"));
    }

    @Test
    public void redisTest2() {

        boolean cyx = util.setLock("cyx", "b4d4a940-89db-4487-abde-da1b616ff50a",44);
        System.out.println(cyx);
    }

    @Test
    public void redisTest3() {

        boolean cyx = util.releaseLock("cyx","b4d4a940-89db-4487-abde-da1b616ff50a");
        System.out.println(cyx);
    }





}
