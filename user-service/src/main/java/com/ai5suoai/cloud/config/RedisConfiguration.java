package com.ai5suoai.cloud.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

/**
 * redis 缓存的配置
 *
 * @author chenzhenjia
 * @since 16/5/15
 */
@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {
    private static String prefix = "By";

    @Bean
    @Primary
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            StringBuilder sb = new StringBuilder();
            String name = method.getName();
            int indexOf = name.indexOf(prefix);
            if (indexOf > 0)
                name = name.substring(indexOf + prefix.length()).toLowerCase();
            sb.append(name).append(":");
            for (Object param : params) {
                sb.append(param);
            }
            return sb.toString();
        };

    }

    @Bean
    @Primary
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        return new RedisCacheManager(redisTemplate);
    }


    @Bean
    public RedisTemplate<Object, Object> redisTemplate(
            RedisConnectionFactory factory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
        template.setConnectionFactory(factory);
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        jackson2JsonRedisSerializer.setObjectMapper(om);
//        template.setValueSerializer(new StringRedisSerializer(Charset.forName("UTF-8")));
        template.setDefaultSerializer(new JdkSerializationRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }

}
