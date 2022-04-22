package com.nudt.demo_02.service;

import com.nudt.demo_02.entity.UmsAdmin;
import com.nudt.demo_02.entity.UmsPermission;

import java.util.List;

/**
 * @Author: Lzy
 * @Time: 2022/4/19
 * @Description: 后台管理员Service
 */
public interface UmsAdminService {
    /**
     * 根据用户名获取后台管理员
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 注册管理员
     */
    UmsAdmin register(UmsAdmin umsAdmin);

    /**
     * 管理员登录
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    /**
     * 获取用户所有权限 (包括角色权限和 +- 权限)
     * @param adminId
     * @return
     */
    List<UmsPermission> getAllPermission(Long adminId);
}
