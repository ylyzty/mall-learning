package com.nudt.demo_02.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: Lzy
 * @Time: 2022/4/19
 * @Description: Admin后台用户表
 */
public class UmsAdmin implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private String password;

    private String icon;    //头像

    private String email;

    private String nickName;    //昵称

    private String note;    //备注

    private Date createTime;

    private Date loginTime;    //最后登录时间

    /**
     * 账号启用状态
     * 1 -> 启用, 0 -> 禁用
     */
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{ " +
                "id=" + id +
                ", username='" + username + '\'' +
                ", icon='" + icon + '\'' +
                ", email='" + email + '\'' +
                ", nickName='" + nickName + '\'' +
                ", note='" + note + '\'' +
                ", createTime=" + createTime +
                ", loginTime=" + loginTime +
                ", status=" + status +
                " }";
    }

    public static void main(String[] args) {
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setId(1L);
        umsAdmin.setUsername("Lzy");
        umsAdmin.setCreateTime(new Date());
        System.out.println(umsAdmin.toString());
    }
}
