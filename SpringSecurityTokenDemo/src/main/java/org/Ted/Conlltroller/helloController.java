package org.Ted.Conlltroller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class helloController {
    @RequestMapping("/hello")
    @PreAuthorize("hasAuthority('test')")
    public String hello(){
//        System.out.println("hello");
        return "hello";
    }

}
