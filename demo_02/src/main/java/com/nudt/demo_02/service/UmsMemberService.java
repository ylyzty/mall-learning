package com.nudt.demo_02.service;

import com.nudt.demo_02.common.CommonResult;

/**
 * @Author: Lzy
 * @Time: 2022/4/12
 * @Description: 会员管理
 */
public interface UmsMemberService {
    /**
     * 生成验证码
     */
    CommonResult generateAuthCode(String phone_number);

    /**
     * 判断验证码是否和手机号码匹配
     */
    CommonResult verifyAuthCode(String phone_number, String authCode);
}
