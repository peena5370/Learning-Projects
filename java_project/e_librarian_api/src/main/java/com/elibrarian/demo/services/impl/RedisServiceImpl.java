package com.elibrarian.demo.services.impl;

import com.elibrarian.demo.services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisServiceImpl implements RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    @Autowired
    public RedisServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void set(String key, Object value, long timeout, TimeUnit unit) {
        // opsForValue() is for simple key/value (String) operations
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    @Override
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public Boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    @Override
    public void putInHash(String hashKey, String field, Object value) {
        // opsForHash() is for Redis Hash operations
        redisTemplate.opsForHash().put(hashKey, field, value);
    }

    @Override
    public Object getFromHash(String hashKey, String field) {
        return redisTemplate.opsForHash().get(hashKey, field);
    }
}
