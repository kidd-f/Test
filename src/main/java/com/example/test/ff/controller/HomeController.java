package com.example.test.ff.controller;

import com.example.test.ff.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    IndexService indexService;

    /**占用内存
     */
    @GetMapping("/home")
    public String home(){

        indexService.home();
        return null;
    }
}
