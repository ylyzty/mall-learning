package com.nudt.demo_01.common;

/**
 * 封装API的错误码
 * @Author: Lzy
 * @Time: 2022/3/14
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
