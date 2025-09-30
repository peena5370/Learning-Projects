package com.elibrarian.demo.services;

import java.util.concurrent.TimeUnit;

public interface RedisService {
    void set(String key, Object value, long timeout, TimeUnit unit);

    Object get(String key);

    Boolean delete(String key);

    void putInHash(String hashKey, String field, Object value);

    Object getFromHash(String hashKey, String field);
}
