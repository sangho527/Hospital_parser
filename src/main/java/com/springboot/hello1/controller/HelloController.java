package com.springboot.hello1.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello World 123";
    }


    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }


    //http/://localhost:8080/api/v1/get-api/request1?name=sangho&email=calnal805&organization=likelion
    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name + "" + email + "" + organization;
    }

    @GetMapping(value = "/request2")
    public String getVariable2(@RequestParam Map<String, String> param) {
        param.entrySet().forEach((map)->{
            System.out.printf("key:%s value:%s",map.getKey(),map.getValue());
        });
        return "request2가 호출 완료 되었습니다";
    }


}

