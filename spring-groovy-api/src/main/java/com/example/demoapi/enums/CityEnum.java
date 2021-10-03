package com.example.demoapi.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @Author mubi
 * @Date 2021/6/3 22:39
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CityEnum {
    SHANGHAI(1, "上海"),
    HANGZHOU(2, "杭州");
    private Integer code;
    private String name;

    CityEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
