package com.agriculture.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * JWT工具类
 * */
public class JwtToken {

//    @Value("${jwt.secret}")
//    private static String secret;   //密钥
//    @Value("${jwt.expiration}")
//    private static Long expiration;   //有效期
    private static final Long expirationmill= (long) (60*60*1000*1000000);   //表示一个小时
    private static final String secretkey="platform";

    public static String getUUID(){
        String token= UUID.randomUUID().toString().replace("-","");
        return token;
    }

    /**
     * 生成jwt jwt加密
     * @param subject token中要存放的数据（json格式）
     * @param tillMills token超时时间
     * @return
     * */
    public static String generateJwt(String subject,Long tillMills){
        JwtBuilder builder=getJwtBuilder(subject,tillMills,getUUID());   //设置过期时间
        return builder.compact();
    }

    /**
     * 生成jwt jwt加密
     * @param subject token中要存放的数据（json格式）
     * @return
     * */
    public static String generateJwt(String subject){
        JwtBuilder builder=getJwtBuilder(subject,null,getUUID());   //设置过期时间
        return builder.compact();
    }

    /**
     * 生成jwt jwt加密
     * @param subject token中要存放的数据（json格式）
     * @param tillMills token
     * @param uuid
     * @return
     * */
    public static String generateJwt(String subject,Long tillMills,String uuid){
        JwtBuilder builder=getJwtBuilder(subject,tillMills,uuid);   //设置过期时间
        return builder.compact();
    }

    private static JwtBuilder getJwtBuilder(String subject, Long expirationtime, String uuid) {
        SignatureAlgorithm signatureAlgorithm=SignatureAlgorithm.HS256;
        SecretKey secretKey=generataKey();
        long nowMillis=System.currentTimeMillis();
        Date now=new Date(nowMillis);
        if(expirationtime==null){
            expirationtime=JwtToken.expirationmill;
        }
        long expMills=nowMillis+expirationtime;
        Date expdate=new Date(expMills);
        return Jwts.builder()
                .setId(uuid)   //唯一的ID
                .setSubject(subject)   //主题，可以是json数据
                .setIssuer("brothers")   //签发者
                .setIssuedAt(now)   //签发时间
                .signWith(signatureAlgorithm,secretKey)   //使用HS256对称加密算法签名，第二个参数为密钥
                .setExpiration(expdate);
    }

    private static SecretKey generataKey() {
        byte[] encodedKey= Base64.getDecoder().decode(secretkey);
        SecretKey key=new SecretKeySpec(encodedKey,0,encodedKey.length,"AES");
        return key;
    }

    /**
     * jwt解密
     * @param jwt
     * return
     * throws Exception
     * */
    public static Claims parseJwt(String jwt) throws Exception{
        SecretKey secretKey=generataKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

//    public static void main(String[] args)throws Exception{
//        String jwt=generateJwt("123");
//        System.out.println(jwt);
//        System.out.println(parseJwt("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxZmYxOTVkYjhiMzQ0YWQwODcxNDM0NzYyZWJhMjY5ZiIsInN1YiI6IjEyMyIsImlzcyI6ImJyb3RoZXJzIiwiaWF0IjoxNjc3MzA0NjM3LCJleHAiOjE2NzczMDgyMzd9.2ZTI23l1s60lfnEFxy83Sy47d-sfu8YEMn2Bpikejeg").getSubject());
//    }
}
