package org.Ted.service.impl;

import org.Ted.domian.LoginUser;
import org.Ted.domian.ResponseResult;
import org.Ted.domian.User;
import org.Ted.service.LoginServcie;
import org.Ted.utils.JwtUtil;
import org.Ted.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginServcie {

    //AuthenticationManager Authenticate 进行认证
    @Autowired
   AuthenticationManager AuthenticationManager;

    @Autowired
    private RedisCache redisCache;


    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());

        Authentication authenticate = AuthenticationManager.authenticate(authenticationToken);

        if(Objects.isNull(authenticate)){
            System.out.println("失败");
        }
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userid = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userid);
        Map<String,String> map=new HashMap<>();
        map.put("token",jwt);
        redisCache.setCacheObject("login:"+userid,loginUser);

        return new ResponseResult(200,"登录成功",map);
    }
}
