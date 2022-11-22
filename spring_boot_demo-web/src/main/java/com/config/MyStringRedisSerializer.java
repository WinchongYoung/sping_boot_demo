//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.config;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

public class MyStringRedisSerializer implements RedisSerializer<Object> {
    private final Charset charset;
    public static final MyStringRedisSerializer US_ASCII;
    public static final MyStringRedisSerializer ISO_8859_1;
    public static final MyStringRedisSerializer UTF_8;

    public MyStringRedisSerializer() {
        this(StandardCharsets.UTF_8);
    }

    public MyStringRedisSerializer(Charset charset) {
        Assert.notNull(charset, "Charset must not be null!");
        this.charset = charset;
    }

    public Object deserialize(@Nullable byte[] bytes) {
        return bytes == null ? null : (JSONObject) JSON.parseObject(new String(bytes, this.charset), Object.class);
    }

    public byte[] serialize(@Nullable Object object) {
        return object == null ? null : JSON.toJSONString(object).getBytes(StandardCharsets.UTF_8);
    }

    public Class<?> getTargetType() {
        return String.class;
    }

    static {
        US_ASCII = new MyStringRedisSerializer(StandardCharsets.US_ASCII);
        ISO_8859_1 = new MyStringRedisSerializer(StandardCharsets.ISO_8859_1);
        UTF_8 = new MyStringRedisSerializer(StandardCharsets.UTF_8);
    }
}
