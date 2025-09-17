package com.orgthirteen;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    @Test
    public void testGenerateJwt() {
        // 测试生成token的代码
        Map<String,Object> dataMap= new HashMap<>();
        String jwt=Jwts.builder().signWith(SignatureAlgorithm.HS256, "bWVkaWNhbA==")
                .addClaims(dataMap)
                .setExpiration(new Date(System.currentTimeMillis()+3600*1000))
                .compact();
        System.out.println(jwt);
    }
}
