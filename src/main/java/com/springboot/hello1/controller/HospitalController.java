package com.springboot.hello1.controller;


import com.springboot.hello1.dao.HospitalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/hospital")
public class HospitalController {

    @Autowired
    private HospitalDao hospitalDao;

}
