package com.nudt.demo_02.controller;

import com.nudt.demo_02.common.CommonResult;
import com.nudt.demo_02.entity.UmsAdmin;
import com.nudt.demo_02.entity.UmsPermission;
import com.nudt.demo_02.service.UmsAdminService;
import com.nudt.demo_02.utils.UmsAdminLoginParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Lzy
 * @Time: 2022/4/21
 */
@Controller
@RequestMapping("/admin")
public class UmsAdminController {
    @Autowired
    private UmsAdminService umsAdminService;

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<UmsAdmin> register(@RequestBody UmsAdmin umsAdminParam, BindingResult result) {
        UmsAdmin umsAdmin = umsAdminService.register(umsAdminParam);
        if (umsAdmin == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam, BindingResult result) {
        String token = umsAdminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("tokenHead", tokenHead);
        tokenMap.put("token", token);
        return CommonResult.success(tokenMap);
    }

    @RequestMapping(value = "/permission/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<UmsPermission>> getPermissionList(@PathVariable Long adminId) {
        List<UmsPermission> permissionList = umsAdminService.getAllPermission(adminId);
        return CommonResult.success(permissionList);
    }
}
