package com.nudt.demo_02.entity;

import java.io.Serializable;

/**
 * @Author: Lzy
 * @Time: 2022/4/19
 * @Description: Admin —— role 关系表, 用户与角色是多对多的关系
 */
public class UmsAdminRoleRelation implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long adminId;

    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{ " +
                "id=" + id +
                ", adminId=" + adminId +
                ", roleId=" + roleId +
                " }";
    }
}
