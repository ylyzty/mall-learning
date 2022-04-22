package com.nudt.demo_02.entity;

import java.io.Serializable;

/**
 * @Author: Lzy
 * @Time: 2022/4/19
 * @Description: Admin —— permission 关系表
 * 除角色中定义的权限以外的加减权限, 加权限指用户比角色多出的权限, 减权限指用户比角色少的权限
 */
public class UmsAdminPermissionRelation implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long adminId;

    private Long permissionId;

    private Integer type;

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

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{" +
                "id=" + id +
                ", adminId=" + adminId +
                ", permissionId=" + permissionId +
                ", type=" + type +
                "}";
    }
}
