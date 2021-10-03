package com.example.demoapi.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @Author mubi
 * @Date 2021/6/3 22:39
 */
@JsonSerialize(using = ColorEnumSerializer.class)
public enum ColorEnum {
    BLACK(1, "黑色"),
    WHITE(2, "白色");
    private Integer code;
    private String name;

    ColorEnum(Integer code, String name) {
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
