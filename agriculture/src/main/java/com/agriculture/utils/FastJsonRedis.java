package com.agriculture.utils;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * redis使用FastJson序列化
 * */
public class FastJsonRedis<T> implements RedisSerializer<T> {
    public static final Charset DEFUALT_CHARSET=Charset.forName("UTF-8");
    private Class<T> object;
    static {
        ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
//        如果遇到反序列化autoType is not support错误，需要添加并修改以下报名到bean文件路径
        // ParserConfig.getGlobalInstance().addAccept("com.xxxxx.xxx");
    }
    public FastJsonRedis(Class<T> object1){
        super();
        this.object=object1;
    }
    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t==null){
            return new byte[0];
        }
        return JSON.toJSONString(t, SerializerFeature.WriteClassName).getBytes(DEFUALT_CHARSET);
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if(bytes==null || bytes.length<0){
            return null;
        }
        String str=new String(bytes,DEFUALT_CHARSET);
        return JSON.parseObject(str,object);
    }


    protected JavaType getJavaType(Class<?> object1){
        return TypeFactory.defaultInstance().constructType(object1);
    }
}
