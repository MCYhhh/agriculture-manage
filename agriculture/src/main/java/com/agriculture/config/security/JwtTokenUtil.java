//package com.agriculture.config.security;
//
//import com.agriculture.entity.User;
//import io.jsonwebtoken.*;
//import org.springframework.beans.factory.annotation.Value;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//public class JwtTokenUtil {
//    private static final String CLAIM_KEY_USEACCOUNT="platform";   //用户名的key
//    private static final String CLAIM_KEY_CREATED="2023-2-19";   //jwt创建时间
//    @Value("${jwt.secret}")
//    private String secret;
//    @Value("${jwt.expiration}")
//    private Long expiration;
//
//    /**
//     * 根据用户信息生成token
//     * @param user
//     * @return
//     * **/
//    public String generateToken(User user){
//        Map<String,Object>claims=new HashMap<>();
//        claims.put(CLAIM_KEY_USEACCOUNT,user.getUaccount());
//        claims.put(CLAIM_KEY_CREATED,new Date());
//        return generateToken(claims);
//    }
//
//    /**
//     * 从token中获取用户账号
//     * @param token
//     * @return
//     * **/
//    public String getUseraccountFromToken(String token){
//        String useraccount;
//        try {
//            Claims claims=getClaimsFromToken(token);
//            useraccount=claims.getSubject();
//        } catch (Exception e) {
//            useraccount=null;
//        }
//        return useraccount;
//    }
//    /**
//     * 从token中获得荷载
//     * @param token
//     * @return
//     * */
//    private Claims getClaimsFromToken(String token) {
//        Claims claims=null;
//        try{
//            claims=Jwts.parser()
//                    .setSigningKey(secret)
//                    .parseClaimsJws(token)
//                    .getBody();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return claims;   //返回荷载
//    }
//
//    /**
//     *判断token是否失效
//     * @param user
//     * @return
//     * */
//    public boolean validateToken(String token,User user){
//        String uaccount=getUseraccountFromToken(token);
//        return uaccount.equals(user.getUaccount()) && isTokenExpiration(token);
//    }
//
//    /**
//     * 判断token是否失效
//     * @param token
//     * @return
//     * */
//    private boolean isTokenExpiration(String token) {
//        Date expiraDate=getExpiraDateFromToken(token);
//        return expiraDate.before(new Date());
//    }
//
//    /**
//     * 判断token是否可以被刷新
//     * @param token
//     * @return
//     * **/
//    public boolean canRefresh(String token){
//        return !isTokenExpiration(token);
//    }
//
//    /**
//     * 刷新token
//     * @param token
//     * @return
//     * **/
//    public String refreshToken(String token){
//        Claims claims=getClaimsFromToken(token);
//        claims.put(CLAIM_KEY_CREATED,new Date());
//        return generateToken(claims);
//    }
//
//    /**
//     * 从token中获取过期时间
//     * @param token
//     * @return
//     * */
//    private Date getExpiraDateFromToken(String token) {
//     Claims claims= getClaimsFromToken(token);
//     return claims.getExpiration();
//    }
//
//    /**
// * 根据荷载生成jwt token
// * @param claims
// * @return
// * */
//    private String generateToken(Map<String,Object>claims){
//        return Jwts.builder()
//                .setClaims(claims)
//                .setExpiration(generateExpirationDate())
//                .signWith(SignatureAlgorithm.ES256,secret)
//                .compact();
//    }
//
//    /**
//     * 生成token的失效时间
//     * @return
//     * */
//    private Date generateExpirationDate() {
//        return new Date(System.currentTimeMillis()+expiration*1000);
//    }
//}
