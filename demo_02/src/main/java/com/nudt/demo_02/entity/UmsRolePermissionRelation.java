package com.nudt.demo_02.entity;

import java.io.Serializable;

/**
 * @Author: Lzy
 * @Time: 2022/4/19
 * @Description: role —— permission 关系表, 角色与权限是多对多的关系
 */
public class UmsRolePermissionRelation implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long roleId;

    private Long permissionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{ " +
                "id=" + id +
                ", roleId=" + roleId +
                ", permissionId=" + permissionId +
                ", serialVersionUID=" + serialVersionUID +
                '}';
    }
}
