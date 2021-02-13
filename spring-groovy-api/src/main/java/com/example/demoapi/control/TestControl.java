package com.example.demoapi.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 健康检查
 * @Author mubi
 * @Date 2021/2/13 12:04
 */
@RestController
public class TestControl {

    @GetMapping(value = "/test")
    public String getTest() {
        return "hello test";
    }

}
