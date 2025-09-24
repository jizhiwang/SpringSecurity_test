package org.Ted.Conlltroller;

import org.Ted.domian.ResponseResult;
import org.Ted.domian.User;
import org.Ted.service.LoginServcie;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private LoginServcie loginServcie;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        return loginServcie.login(user);
    }


    @RequestMapping("/user/logout")
    public ResponseResult logout(){
        return loginServcie.logout();
    }

}
