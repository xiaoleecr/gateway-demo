package com.lcr.helloapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName Hello
 * @Description
 * @Author licongrui
 * @Date 2022/1/14
 */
@RestController
public class Hello {
//    @Value("${ribbon.ConnectTimeout}")
    private Long connectTime;

    @Autowired
    RedisTemplate redisTemplate;

//    @Value("${ribbon.ReadTimeout}")
    private Long readTime;
    @GetMapping("/hello")
    public String hello(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
//        valueOperations.setIfAbsent("k1","v1",10, TimeUnit.MINUTES);
//        valueOperations.setIfAbsent("k1","v2",10, TimeUnit.MINUTES);
        valueOperations.setIfPresent("k1","v3");
        return "hello";
    }
    @GetMapping("/bye")
    public String bye(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object k1 = valueOperations.get("k1");
        return k1.toString();
    }
}
