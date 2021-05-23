package com.example.demoapi.control;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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

    @GetMapping(value = "/test-cost")
    public Integer getTestCost() {
        int a = cost1();
        int b = cost2();
        int c = cost3();
        return a + b + c;
    }

    private Integer cost1(){
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        }catch (Exception e){

        }
        return 100 + cost11();
    }

    private Integer cost2(){
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        }catch (Exception e){

        }
        return 200 + cost22();
    }

    private Integer cost3(){
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        }catch (Exception e){

        }
        return 300;
    }

    private Integer cost11(){
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        }catch (Exception e){

        }
        return 50;
    }

    private Integer cost22(){
        try {
            TimeUnit.MILLISECONDS.sleep(30);
        }catch (Exception e){

        }
        return 30;
    }


}
