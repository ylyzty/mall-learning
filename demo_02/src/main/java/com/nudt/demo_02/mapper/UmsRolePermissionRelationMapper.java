package com.nudt.demo_02.mapper;

import com.nudt.demo_02.entity.UmsRolePermissionRelation;

import java.util.List;

/**
 * @Author: Lzy
 * @Time: 2022/4/19
 */
public interface UmsRolePermissionRelationMapper {
    int count();

    int insertUmsRolePermissionRelation(UmsRolePermissionRelation umsRolePermissionRelation);

    int deleteUmsRolePermissionRelationById(Long id);

    int updateUmsRolePermissionRelation(UmsRolePermissionRelation umsRolePermissionRelation);

    UmsRolePermissionRelation selectUmsRolePermissionRelationById(Long id);

    List<UmsRolePermissionRelation> selectAllUmsRolePermissionRelation();
}
