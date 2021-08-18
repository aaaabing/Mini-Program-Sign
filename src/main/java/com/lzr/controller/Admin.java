package com.lzr.controller;

import com.alibaba.fastjson.JSONObject;
import com.lzr.mapper.SignMapper;
import com.lzr.mapper.UserMapper;
import com.lzr.Entity.User;
import com.lzr.Entity.signInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import static com.lzr.constant.StatusConstant.REGISTERED;
import static com.lzr.constant.StatusConstant.UNREGISTERED;
import com.lzr.Entity.dto.*;
/**
 * @author lzr
 * @date 2021/08/10
 * @version 1.0
 * 全局控制
 */
@RestController
public class Admin {
    @Autowired
    SignMapper signMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RedisTemplate redisTemplate;
    private static final String appid="wx6b7db53e1aab53f7";
    private static final String str="9250a9c1fb6ccea5a3858e06c41be4d0";
    @PostMapping("/checkAdmin")
    public String checkAdmin(@RequestBody String t){
        String uuid= UUID.randomUUID().toString().replace("-", "");
        t= t.substring(5,t.length());
        Cond cond=null;
        String url="https://api.weixin.qq.com/sns/jscode2session?appid="+appid
                +"&secret="+str
                +"&js_code="+t
                +"&grant_type=authorization_code";
        String openid= (String) doGetstr(url).get("openid");
        redisTemplate.opsForValue().set(uuid,openid,1800, TimeUnit.SECONDS);
        if(userMapper.getUser(openid)==null) {
            cond = new Cond(UNREGISTERED, uuid);
            return JSONObject.toJSONString(cond);
        }
        else {
            cond=new Cond(REGISTERED,uuid);
            return JSONObject.toJSONString(cond);
        }
    }

    /**
     *
     * @param code 登录时获取的code
     * @return 登录状态码
     */
    @PostMapping("/checkUser")
    public String checkUser(@RequestParam("code") String code){
        String uuid= UUID.randomUUID().toString();
        Cond cond;
        String url="https://api.weixin.qq.com/sns/jscode2session?appid="+appid
                +"&secret="+str
                +"&js_code="+code
                +"&grant_type=authorization_code";
        //发送请求获取UUID
        String openid= (String) doGetstr(url).get("openid");
        //将openid存入redis，下次检查登录或签到时无需请求，查询redis中是否存在该openid即可，设置过期时间为半个小时
        redisTemplate.opsForValue().set(uuid,openid,1800, TimeUnit.SECONDS);
        //如果当前用户未注册
        if(userMapper.getUser(openid)==null) {
            //返回一个未注册的状态
            cond = new Cond(UNREGISTERED, uuid);
            return JSONObject.toJSONString(cond);
        }
        else {
            //返回已注册状态
            cond=new Cond(REGISTERED,uuid);
            return JSONObject.toJSONString(cond);
        }
        }
    @PostMapping("/registerUser")
    public String registerUser(@RequestBody String t){
        String token=t.substring(t.indexOf("=")+1,t.indexOf("&"));
        String openid= (String) redisTemplate.opsForValue().get(token);
        String userName=null;
        try {
            userName= URLDecoder.decode(t.substring(t.indexOf("&")+6,t.lastIndexOf('&')),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        User user= null;
        user = new User();
        user.setOpenid(openid);
        user.setUserName(userName);
        userMapper.registerUser(user);
        return JSONObject.toJSONString(new Resp(token));
    }

    /**
     * 用户签到服务
     * @param t
     * @return
     */
    @PostMapping("/sign")
    public String sign(@RequestBody String t){
        System.out.println(t);
        String token=t.substring(6,t.indexOf("&"));
        String address=t.substring(t.indexOf("&")+9,t.lastIndexOf("&"));
        String signTime=t.substring(t.lastIndexOf("&")+6,t.length());
        try {
            address=URLDecoder.decode(address,"UTF-8");
            signTime=URLDecoder.decode(signTime,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String userName=userMapper.getUserName((String) redisTemplate.opsForValue().get(token));
        signInf s=new signInf(signTime,userName,address);
        System.out.println(s);
        signMapper.sign(s);
        return "0";
    }
//    @PostMapping("/checkSign")//@TODO 签到前验证是否登录
//    public String checkSign(@RequestBody String t){
//
//    }
    private static JSONObject doGetstr(String url){
        JSONObject js=null;
        try {

            URL u=new URL(url);
            HttpsURLConnection conn= (HttpsURLConnection) u.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("GET");
            conn.connect();
            BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line=null;
            String list="";
            while ((line=br.readLine())!=null) {
                list += line + "\n";
            }
            js=JSONObject.parseObject(list);

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return js;
    }
}
