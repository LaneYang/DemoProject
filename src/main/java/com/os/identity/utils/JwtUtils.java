package com.os.identity.utils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author youyuan.lv
 */
public class JwtUtils {

    public static Map<String, String> map = new HashMap<>();

    public static String createToken(String username) {
        String id = UUID.randomUUID().toString().replace("-","");
        map.put(id, username);
        System.out.println("后台生成token:" + id);
        return id;
    }

    public static boolean verifyToken(String token) throws UnsupportedEncodingException {
        if(map.containsKey(token)){
            return true;
        }else{
            return false;
        }
    }

}