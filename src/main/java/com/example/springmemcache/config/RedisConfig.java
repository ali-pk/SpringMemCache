package com.example.springmemcache.config;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;

//@Configuration
public class RedisConfig {
//
//    @Bean
//    @Qualifier("redisJedis")
//    public Jedis jedis() {
//        return new Jedis("localhost", 6379);
//    }
}