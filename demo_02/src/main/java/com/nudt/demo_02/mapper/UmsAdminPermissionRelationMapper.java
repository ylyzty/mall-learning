package com.nudt.demo_02.mapper;

import com.nudt.demo_02.entity.UmsAdminPermissionRelation;

import java.util.List;

/**
 * @Author: Lzy
 * @Time: 2022/4/19
 */
public interface UmsAdminPermissionRelationMapper {
    int count();

    int insertUmsAdminPermissionRelation(UmsAdminPermissionRelation umsAdminPermissionRelation);

    int deleteUmsAdminPermissionRelationById(Long id);

    int updateUmsAdminPermissionRelation(UmsAdminPermissionRelation umsAdminPermissionRelation);

    UmsAdminPermissionRelation selectUmsAdminPermissionRelationById(Long id);

    List<UmsAdminPermissionRelation> selectAllUmsAdminPermissionRelation();
}
