package com.atguigu.springcloud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> implements Serializable {
    private int code;

    private String message;

    private T data;

    public CommonResult(int code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }
}
