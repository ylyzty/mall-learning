package com.nudt.demo_02.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Lzy
 * @Time: 2022/4/19
 * @Description: Permission后台用户权限表
 */
public class UmsPermission implements Serializable {
    private static final long SerialVersionUID = 1L;

    private Long id;

    private Long pid;    //父级权限Id

    private String name;

    private String value;

    private String icon;

    /**
     * 权限类型
     * 0 -> 目录, 1 -> 菜单, 2 -> 按钮
     */
    private Integer type;

    private String uri;

    /**
     * 启用状态
     * 1 -> 启用, 0 -> 禁用
     */
    private Integer status;

    private Date createTime;

    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{ " +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", icon='" + icon + '\'' +
                ", type=" + type +
                ", uri='" + uri + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", sort=" + sort +
                ", serialVersionUID=" + SerialVersionUID +
                '}';
    }
}
