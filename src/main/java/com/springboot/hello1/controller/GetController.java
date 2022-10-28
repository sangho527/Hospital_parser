package com.springboot.hello1.controller;

import com.springboot.hello1.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Slf4j

public class GetController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        log.info("hello로 요청이 들어왔습니다.");
        return "Hello World";
    }
    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        log.info("getVariable1으로 요청이 들어왔습니다. variable:{}", variable);
        return variable;
    }

    @GetMapping(value = "/name")
    public String getName(){
        log.info("getName으로 요청이 들어왔습니다.");
        return "Sangho";
    }



    @GetMapping(value="/request3")
    public String getRequestParam3(MemberDto memberDto){

        return memberDto.toString();
    }
}
