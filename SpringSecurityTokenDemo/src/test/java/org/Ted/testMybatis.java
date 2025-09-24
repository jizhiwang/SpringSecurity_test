package org.Ted;

import org.Ted.domian.User;
import org.Ted.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
public class testMybatis {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void findAll(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }


    @Autowired
    private PasswordEncoder passwordEncoder;
    @Test
    public void TestCryptPassword(){
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);

    }
}
