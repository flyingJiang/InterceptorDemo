package com.flying.constant;

public enum HttpCodeEnum {
    CODE_200("200", 200),

    CODE_300("300", 300),

    CODE_401("401", 401),

    CODE_500("500", 500);

    // ... other http code, please fill by you need

    private String name;
    private int value;

    HttpCodeEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    public boolean eq (Integer value){
        if (value == null){
            return false;
        }
        return this.value == value.intValue();
    }
}
