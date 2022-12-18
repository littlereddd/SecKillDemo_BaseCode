package com.example.seckill.vo;

//公共返回对象枚举

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public enum RespBeanEnum {

//    通用
    SUCCESS(200, "SUCCESS"),
    ERROR(500, "服务器异常"),

//    登陆模块5002xxx
    LOGIN_ERROR(500210, "用户名或密码错误"),
    MOBILE_ERROR(500211, "手机号格式有误"),
    BIND_ERROR(500212, "参数校验异常"),

//    秒杀模块5005xxx
    EMPTY_STOCK(500500, "库存不足"),
    REPEAT_ERROR(500501, "每人仅限一件"),
    ;

    private final Integer code;
    private final String message;
}
