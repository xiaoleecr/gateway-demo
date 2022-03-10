package com.lcr.helloapplication.controller;

import ch.qos.logback.core.util.ContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/add")
    public String hello(HttpServletRequest request, @RequestParam("k") String k, @RequestParam("v") String v) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
//        valueOperations.setIfAbsent("k1","v1",10, TimeUnit.MINUTES);
        valueOperations.setIfAbsent("k1","v2",10, TimeUnit.MINUTES);
        if (valueOperations.setIfAbsent(k, v)) {
            return "已加入缓存";
        }
        return "key已存在";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("k") String k) {
        if (redisTemplate.delete(k)) {
            return "删除成功";
        }
        return "不存在的key";
    }

    @GetMapping("/get")
    public String bye(@RequestParam("k") String k) {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        Object v = valueOperations.get(k);
        if(null == v){
         return "不存在的key";
        }
        return v.toString();
    }
}
