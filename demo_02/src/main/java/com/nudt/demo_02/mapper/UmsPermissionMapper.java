package com.nudt.demo_02.mapper;

import com.nudt.demo_02.entity.UmsPermission;

import java.util.List;

/**
 * @Author: Lzy
 * @Time: 2022/4/19
 */
public interface UmsPermissionMapper {
    int count();    //查询记录条数

    int insertUmsPermission(UmsPermission umsPermission);

    int deleteUmsPermissionById(Long id);

    int updateUmsPermission(UmsPermission umsPermission);

    UmsPermission selectUmsPermissionById(Long id);

    List<UmsPermission> selectAllUmsPermission();
}
