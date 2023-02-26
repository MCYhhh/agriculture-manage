package com.agriculture.config.redis;

import com.agriculture.utils.FastJsonRedis;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 使用fastjson来序列化value的值，用string来序列化key的值
 *
 * */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory connectionFactory){
        RedisTemplate<Object,Object> template=new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        FastJsonRedis fastJsonRedis=new FastJsonRedis<>(Object.class);

//        使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(fastJsonRedis);

//        Hash的key也采用StringRedisSerializer的序列化方式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(fastJsonRedis);

        template.afterPropertiesSet();
        return template;
    }
}
