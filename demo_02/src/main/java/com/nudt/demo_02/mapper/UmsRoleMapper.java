package com.nudt.demo_02.mapper;

import com.nudt.demo_02.entity.UmsRole;

import java.util.List;

/**
 * @Author: Lzy
 * @Time: 2022/4/19
 */
public interface UmsRoleMapper {
    int count();

    int insertUmsRole(UmsRole umsRole);

    int deleteUmsRoleById(Long id);

    int updateUmsRole(UmsRole umsRole);

    UmsRole selectUmsRoleById(Long id);

    List<UmsRole> selectAllUmsRole();
}
