package com.example.test.ff.controller;

import com.example.test.ff.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    IndexService indexService;

    @GetMapping("/index")
    public String index(){

        indexService.index();
        long currentTime = System.currentTimeMillis();
        String res = String.valueOf(currentTime);
        return res;
    }
}
