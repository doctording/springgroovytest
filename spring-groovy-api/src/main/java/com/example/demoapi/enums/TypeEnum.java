package com.example.demoapi.enums;


/**
 * @Author mubi
 * @Date 2021/6/3 22:39
 */
public enum TypeEnum {
    TYPE1(1, "类别1"),
    TYPE2(2, "类别2");
    private Integer code;
    private String name;

    TypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "{" +
                "\"code\":" + code +
                ", \"name\":" + "\"" + name + "\"" +
                '}';
    }
}
