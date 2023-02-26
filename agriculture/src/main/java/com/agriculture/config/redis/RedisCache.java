package com.agriculture.config.redis;

import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Component
public class RedisCache {
    @Resource
    public RedisTemplate redisTemplate;

    /**
     * 缓存基本对象，Integer、String、实体类
     * @param key 缓存的值
     * @param value 缓存的值
     * */
    public <T> void setCacheObject(final String key,final T value){
        redisTemplate.opsForValue().set(key,value);
    }

    /**
     * 缓存基本对象，Integer、String、实体类
     * @param key 缓存的值
     * @param value 缓存的值
     * @param timeout 时间
     * @param timeUnit 时间颗粒度
     * */
    public <T> void setCacheObject(final String key, final T value, final Integer timeout, final TimeUnit timeUnit){
        redisTemplate.opsForValue().set(key,value,timeout,timeUnit);
    }

    /**
     * 设置有效时间
     * @param key redis键
     * @param timeout 超时时间
     * return true---设置成功，false---设置失败
     * **/
    public boolean isExpire(final String key,final long timeout){
        return  isExpire(key, timeout,TimeUnit.SECONDS);
    }

    /**
     * 设置有效时间
     * @param key redis键
     * @param timeout 超时时间
     * @param timeUnit 时间单位
     * return true---设置成功，false---设置失败
     * **/
    public boolean isExpire(final String key,final long timeout,final TimeUnit timeUnit){
        return  isExpire(key, timeout,timeUnit);
    }

    /**
     * 获取缓存的基本对象
     * @param key 缓存键值
     * @return 缓存键值对应的数据
     * */
    public <T> T getCacheObject(final String key){
        ValueOperations<String,T> operations=redisTemplate.opsForValue();
        return operations.get(key);
    }

    /**
     *删除单个对象
     * @param key
     * */
    public boolean deleteObject(final String key){
        return redisTemplate.delete(key);
    }

    /**
     *删除集合对象
     * @param collection 多个集合对象
     * */
    public long deleteObject(final Collection collection){
        return redisTemplate.delete(collection);
    }

    /**
     * 获取缓存的list对象
     * @param key 待缓存的list数据
     * @return 缓存的对象
     * */
    public <T> long setCacheList(final String key,final List<T> dataList){
       Long count=redisTemplate.opsForList().rightPushAll(key,dataList);
       return count==null?0:count;
    }

    /**
     * 获取缓存的list对象
     * @param key 缓存的键值
     * @return 缓存键值对应的数据
     * */
    public <T> List<T> getCacheList(final String key){
        return redisTemplate.opsForList().range(key,0,-1);
    }

    /**
     * 缓存set
     * @param key 缓存键值
     * @param dataset 缓存的数据
     * @return 缓存数据的对象
     * */
    public <T>BoundSetOperations<String,T> setCacheSet(final String key, final Set<T> dataset){
        BoundSetOperations<String,T> setOperations=redisTemplate.boundSetOps(key);
        Iterator<T> iterator=dataset.iterator();
        while (iterator.hasNext())
            setOperations.add(iterator.next());
        return setOperations;
    }

    /**
     * 获取缓存的set
     * @param key
     * @return
     * */
    public <T> Set<T> getCacheSet(final String key){
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 缓存Map
     * @param key
     * @param dataMap
     * */
    public <T> void setCacheMap(final String key, final Map<String,T> dataMap){
        if(dataMap!=null){
            redisTemplate.opsForHash().putAll(key,dataMap);
        }
    }

    /**
     * 获取缓存的Map
     * @param key
     * @return
     * */
    public <T> Map<String,T> getCacheMap(final String key){
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 往Hash中存入数据
     * @param key redis键
     * @param hKey hash键
     * @param value 值
     * */
    public <T> void setCacheMapValue(final String key,final String hKey,final T value){
        redisTemplate.opsForHash().put(key,hKey,value);
    }

    /**
     * 获取Hash中的数据
     * @param key redis键
     * @param hKey hash键
     * @return hash 中的对象
     * */
    public <T> T getCacheMapValue(final String key,final String hKey){
        HashOperations<String,String,T> operations= redisTemplate.opsForHash();
        return operations.get(key,hKey);
    }

    /**
     * 删除hash中的数据
     * @param key
     * @param hkey
     * */
    public void deleCacheMapValue(final String key,final  String hkey){
        HashOperations hashOperations=redisTemplate.opsForHash();
        hashOperations.delete(key,hkey);
    }

    /**
     * 获取多个Hash中的数据
     * @param key redis键
     * @param hKeys Hash键集合
     * return Hash对象集合
     * */
    public <T> List<T> getMultiCacheMapValue(final String key,final Collection<Object> hKeys){
        return redisTemplate.opsForHash().multiGet(key,hKeys);
    }

    /**
     * 获得缓存的基本对象列表
     * @param pattern 字符串前缀
     * @return 对象列表
     * */
    public Collection<String> keys(final String pattern){
        return redisTemplate.keys(pattern);
    }
}
