package com.nudt.demo_02.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Lzy
 * @Time: 2022/4/19
 * @Description: Role后台用户角色表
 */
public class UmsRole implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String description;

    /**
     * 后台用户数量
     */
    private Integer adminCount;

    private Date createTime;

    /**
     * 启用状态
     * 0 -> 禁用, 1 -> 启用
     */
    private Integer status;

    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAdminCount() {
        return adminCount;
    }

    public void setAdminCount(Integer adminCount) {
        this.adminCount = adminCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", adminCount=" + adminCount +
                ", createTime=" + createTime +
                ", status=" + status +
                ", sort=" + sort +
                ", serialVersionUID" + serialVersionUID +
                '}';
    }
}
