package org.Ted.service;

import org.Ted.domian.ResponseResult;
import org.Ted.domian.User;
import org.springframework.stereotype.Service;

@Service
public interface LoginServcie {
    ResponseResult login(User user);
}
