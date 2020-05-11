package com.project.vava;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Basics {

    @RequestMapping("/")
    public String index() {

        return "Hello world";

    }

}
