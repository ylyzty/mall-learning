package com.nudt.demo_02.controller;

import com.nudt.demo_02.common.CommonResult;
import com.nudt.demo_02.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Lzy
 * @Time: 2022/4/13
 */
@Controller
@RequestMapping("/sso")
public class UmsMemberController {
    @Autowired
    private UmsMemberService umsMemberService;

    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String phone_number) {
        return umsMemberService.generateAuthCode(phone_number);
    }

    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePassword(@RequestParam String phone_number, @RequestParam String authCode) {
        return umsMemberService.verifyAuthCode(phone_number, authCode);
    }
}
