package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    private final StringRedisTemplate stringRedisTemplate;

    public RedisService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public void setKey(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public String getKey(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
}