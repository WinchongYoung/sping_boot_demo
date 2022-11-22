package com.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;



@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    /**
     * cashing 缓存key生成
     *
     * @return
     */
    @Bean
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(target.getClass().getName());
            sb.append(".").append(method.getName());
            for (Object obj : params) {
                sb.append("|").append(obj);
            }
            return sb.toString();
        };
    }

    /**
     * redis对象序列化方式
     *
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();//创建 RedisTemplate，key 和 value 都采用了 Object 类型
        redisTemplate.setConnectionFactory(redisConnectionFactory);//绑定 RedisConnectionFactory

        //创建 FastJsonRedisSerializer 序列方式，对象类型使用 Object 类型，
        // FastJsonRedisSerializer<Object> jackson2JsonRedisSerializer = new FastJsonRedisSerializer<>(Object.class);
        MyStringRedisSerializer jackson2JsonRedisSerializer = new MyStringRedisSerializer(); // 自定义序列化方式
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);

        // 设置 RedisTemplate 序列化规则。因为 key 通常是普通的字符串，所以使用 StringRedisSerializer 即可。
        // 而 value 是对象时，才需要使用序列化与反序列化
        redisTemplate.setKeySerializer(new StringRedisSerializer());// key 序列化规则
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);// value 序列化规则
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());// hash key 序列化规则
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);// hash value 序列化规则
        redisTemplate.afterPropertiesSet();//属性设置后操作
        return redisTemplate;//返回设置好的 RedisTemplate
    }
}
