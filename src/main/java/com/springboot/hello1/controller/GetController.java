package com.springboot.hello1.controller;

import com.springboot.hello1.dto.MemberDto;
import org.springframework.web.bind.annotation.GetMapping;

public class GetController {
    @GetMapping(value="/request3")
    public String getRequestParam3(MemberDto memberDto){

        return memberDto.toString();
    }
}
