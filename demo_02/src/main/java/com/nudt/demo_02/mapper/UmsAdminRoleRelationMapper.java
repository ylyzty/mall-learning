package com.nudt.demo_02.mapper;

import com.nudt.demo_02.entity.UmsAdminRoleRelation;

import java.util.List;

/**
 * @Author: Lzy
 * @Time: 2022/4/19
 */
public interface UmsAdminRoleRelationMapper {
    int count();

    int insertUmsAdminRoleRelation(UmsAdminRoleRelation umsAdminRoleRelation);

    int deleteUmsAdminRoleRelationById(Long id);

    int updateUmsAdminRoleRelation(UmsAdminRoleRelation umsAdminRoleRelation);

    UmsAdminRoleRelation getUmsAdminRoleRelationById(Long id);

    List<UmsAdminRoleRelation> getAllUmsAdminRoleRelation();
}
