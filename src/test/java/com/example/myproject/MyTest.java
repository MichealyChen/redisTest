package com.example.myproject;


import com.example.myproject.redis.RedisSentinelUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {

    @Autowired
    private JedisSentinelPool pool;




    /**
     * 获取一个jedis 对象
     *
     * @return
     */
    public Jedis getJedis() {
        return pool.getResource();
    }

    @Test
    public void redistest(){
        getJedis().set("ssss11","44444444");
        System.out.println(getJedis().get("ssss11"));
    }

    @Test
    public void redistest2(){

        RedisSentinelUtil sentinelUtil = new RedisSentinelUtil();
        Jedis jedis = sentinelUtil.getJedis();

        jedis.set("ssss11","44444444");
        System.out.println(jedis.get("ssss11"));
    }

}
