package org.Ted.Conlltroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class helloController {
    @RequestMapping("/hello")
    public String hello(){
//        System.out.println("hello");
        return "hello";
    }

}
