package com.example.test.ff.controller;

import com.example.test.ff.dto.MemoryDto;
import com.example.test.ff.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    IndexService indexService;

    @GetMapping("/home")
    public String home(){

        String res = indexService.home();
        return res;
    }
}
