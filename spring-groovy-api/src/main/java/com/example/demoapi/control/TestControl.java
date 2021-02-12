package com.example.demoapi.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestControl {

    @GetMapping(value = "/test")
    public String getTest() throws Exception {
        return "hello test";
    }

}
