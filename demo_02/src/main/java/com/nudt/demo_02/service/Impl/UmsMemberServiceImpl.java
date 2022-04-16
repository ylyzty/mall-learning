package com.nudt.demo_02.service.Impl;

import com.nudt.demo_02.common.CommonResult;
import com.nudt.demo_02.service.RedisService;
import com.nudt.demo_02.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * @Author: Lzy
 * @Time: 2022/4/13
 * @Description: 会员管理实现类
 */
@Service
public class UmsMemberServiceImpl implements UmsMemberService {
    @Autowired
    private RedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public CommonResult generateAuthCode(String phone_number) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }

        /**
         * 验证码绑定到手机号，并存储到Redis
         */
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + phone_number, sb.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + phone_number, AUTH_CODE_EXPIRE_SECONDS);

        return CommonResult.success(sb.toString(), "获取验证码成功");
    }

    @Override
    public CommonResult verifyAuthCode(String phone_number, String authCode) {
        if(authCode == null || authCode.isEmpty()) {
            return CommonResult.failed("请输入验证码");
        }

        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + phone_number);
        boolean flag = authCode.equals(realAuthCode);
        if(flag) {
            return CommonResult.success(null, "验证码校验成功");
        }
        else {
            return CommonResult.failed("验证码校验失败");
        }
    }
}
