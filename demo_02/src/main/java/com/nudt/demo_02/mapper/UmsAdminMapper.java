package com.nudt.demo_02.mapper;

import com.nudt.demo_02.entity.UmsAdmin;
import com.nudt.demo_02.entity.UmsPermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Lzy
 * @Time: 2022/4/19
 */
public interface UmsAdminMapper {
    int count();

    int insertUmsAdmin(UmsAdmin umsAdmin);

    int deleteUmsAdminById(Long adminId);

    int updateUmsAdmin(UmsAdmin umsAdmin);

    UmsAdmin selectUmsAdminById(Long adminId);

    UmsAdmin selectUmsAdminByUsername(String username);

    List<UmsAdmin> selectAllUmsAdmin();

    List<UmsPermission> selectAllPermissionById(@Param("adminId") Long adminId);
}
